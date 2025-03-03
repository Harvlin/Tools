package com.project.ToolsLibrary.mapper;

import com.project.ToolsLibrary.domain.dto.ToolDto;
import com.project.ToolsLibrary.domain.entity.Tool;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ToolMapper {
    ToolDto toDto(Tool tool);
    Tool toEntity(ToolDto toolDto);
}
