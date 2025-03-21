package com.project.ToolsLibrary.controller;

import com.project.ToolsLibrary.domain.dto.MemberDto;
import com.project.ToolsLibrary.domain.entity.Member;
import com.project.ToolsLibrary.mapper.MemberMapper;
import com.project.ToolsLibrary.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/members")
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @Autowired
    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @GetMapping("/get-Member/{id}")
    public ResponseEntity<MemberDto> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(memberMapper.toDto(memberService.getMember(id)));
    }

    @GetMapping("/get-All-Members")
    public ResponseEntity<List<MemberDto>> getAll() {
        List<Member> members = memberService.getAllMember();
        List<MemberDto> memberDtos = members.stream().map(memberMapper::toDto).toList();
        return ResponseEntity.ok(memberDtos);
    }

    @PostMapping
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberDto) {
        Member member = memberMapper.toEntity(memberDto);
        Member savedMemberEntity = memberService.save(member);
        return new ResponseEntity<>(memberMapper.toDto(savedMemberEntity), HttpStatus.CREATED);
    }

    @PatchMapping("/partial-Update-Member/{id}")
    public ResponseEntity<MemberDto> partialUpdateMember(@PathVariable Long id, @RequestBody MemberDto memberDto) {
        Member member = memberMapper.toEntity(memberDto);
        Member updatedMemberEntity = memberService.partialUpdateMember(id, member);
        return new ResponseEntity<>(memberMapper.toDto(updatedMemberEntity), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete-Member/{id}")
    public ResponseEntity deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
