package com.project.ToolsLibrary.service.impl;

import com.project.ToolsLibrary.domain.entity.Member;
import com.project.ToolsLibrary.repository.MemberRepository;
import com.project.ToolsLibrary.service.MemberService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member getMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Member Not Found"));
    }

    @Override
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member partialUpdateMember(Long id, Member member) {
        return memberRepository.findById(id).map(existingMember -> {
            Optional.ofNullable(member.getName()).ifPresent(existingMember::setName);
            Optional.ofNullable(member.getEmail()).ifPresent(existingMember::setEmail);
            Optional.ofNullable(member.getPhone()).ifPresent(existingMember::setPhone);
            Optional.ofNullable(member.getSafetyCertifications()).ifPresent(existingMember::setSafetyCertifications);
            return memberRepository.save(existingMember);
        }).orElseThrow(() -> new EntityNotFoundException("Member does not exist"));
    }


    @Override
    public void deleteMember(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Member does not exist");
        }
    }
}
