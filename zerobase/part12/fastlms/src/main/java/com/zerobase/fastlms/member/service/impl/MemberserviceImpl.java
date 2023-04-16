package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.components.Mailcomponents;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MemberserviceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final Mailcomponents mailComponents;


    /**
     * 회원가입
     *
     * @param parameter
     * @return
     */

    @Override
    public boolean register(MemberInput parameter) {

        Optional<Member> optionalMember = memberRepository.findById(parameter.getUserId());
        if (optionalMember.isPresent()) {
            return false;
        }

        String uuid = UUID.randomUUID().toString();

        Member member = Member.builder()
                .userId(parameter.getUserId())
                .userName(parameter.getUserName())
                .phone(parameter.getPhone())
                .password(parameter.getPassword())
                .regDt(LocalDateTime.now())
                .emailAuthYn(false)
                .emailAuthKey(uuid)
                .build();
        memberRepository.save(member);




//        member.setUserId(parameter.getUserId());
//        member.setUserName(parameter.getUserName());
//        member.setPhone(parameter.getPhone());
//        member.setPassword(parameter.getPassword());
//        member.setRegDt(LocalDateTime.now());
//        member.setEmailAuthYn(false);
//        member.setEmailAuthKey(uuid);



        String email = parameter.getUserId();
        String subject = " 가입 메일";
        String text = "<p>사이트 가입을 축하<p><p>아래에 링크를 클릭.</p>"
                + "<div><a href='http://localhost:8080/member/email-auth?id=" + uuid + "'> 가입완료 </a></div>";

        mailComponents.sendMail(email, subject, text);


        return true;
    }

    @Override
    public boolean emailAuth(String uuid) {

        Optional<Member> optionalMember = memberRepository.findByEmailAuthKey(uuid);
        if (!optionalMember.isPresent()) {
            return false;
        }
        Member member = optionalMember.get();
        member.setEmailAuthYn(true);
        member.setEmailAuthDt(LocalDateTime.now());
        memberRepository.save(member);

        return true;
    }
}
