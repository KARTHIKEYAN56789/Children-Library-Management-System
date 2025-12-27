package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import java.util.List;

public interface MemberService {
    Member saveMember(Member member);
    List<Member> getAllMembers();
    Member getMemberById(Long id);
    Member updateMember(Long id, Member member);
    List<Member> getMembersByPhone(String phone);
    List<Member> getMembersByEmail(String email);
}
