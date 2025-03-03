package com.project.ToolsLibrary.mapper;

import com.project.ToolsLibrary.domain.dto.MemberDto;
import com.project.ToolsLibrary.domain.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    MemberDto toDto(Member member);
    Member toEntity(MemberDto memberDto);
}
