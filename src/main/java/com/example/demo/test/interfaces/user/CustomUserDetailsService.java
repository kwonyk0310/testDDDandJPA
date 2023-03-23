package com.example.demo.test.interfaces.user;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.example.demo.test.domain.model.entity.OperatorDTO;
import com.example.demo.test.domain.repository.UserRepository;
import com.example.demo.test.domain.repository.UsersRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

    private final UsersRepository usersRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        return usersRepository.findOneWithAuthoritiesByLoginId(loginId)
                .map(user -> createUser(loginId, user))
                .orElseThrow(() -> new UsernameNotFoundException(loginId + " -> 존재 하지 않음."));
    }

    /**Security User 정보를 생성한다. */
    private User createUser(String loginId, OperatorDTO operatorDTO) {
        System.out.println(operatorDTO.getIsUse());
        if(!"Y".equals(operatorDTO.getIsUse())){
            throw new BadCredentialsException(loginId + " -> 활성화 되어있지 않습니다.");
        }
        List<GrantedAuthority> grantedAuthorities = operatorDTO.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAthrNm()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(
                operatorDTO.getLoginId(),
                operatorDTO.getOprrPswd(),
                grantedAuthorities);
    }

}
