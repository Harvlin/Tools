package com.project.ToolsLibrary.service;

import com.project.ToolsLibrary.domain.entity.Member;

import java.util.List;

public interface MemberService {
    Member getMember(Long id);
    List<Member> getAllMember();
    Member save(Member member);
    Member partialUpdateMember(Long id, Member member);
    void deleteMember(Long id);
}
