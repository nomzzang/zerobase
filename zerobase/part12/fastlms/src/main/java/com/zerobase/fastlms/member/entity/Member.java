package com.zerobase.fastlms.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


// 데이터베이스에 들어갈 컬럼 설정
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Member {

    @Id
    private String userId;

    private String userName;
    private String phone;
    private String password;
    private LocalDateTime regDt;

    private boolean emailAuthYn;
    private String emailAuthKey;
    private LocalDateTime emailAuthDt;

}
