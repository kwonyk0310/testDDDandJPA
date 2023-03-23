package com.example.demo.test.domain.model.entity;

import java.util.Set;
import lombok.Data;

@Data
public class OperatorDTO {
    private String oprrId;
    private String loginId;
    private String oprrNm;
    private String oprrPswd;
    private String isUse;
    private Set<AuthDTO> authorities;
}
