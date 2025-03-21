package com.project.ToolsLibrary.controller;

import com.project.ToolsLibrary.domain.dto.ToolDto;
import com.project.ToolsLibrary.domain.entity.Tool;
import com.project.ToolsLibrary.mapper.ToolMapper;
import com.project.ToolsLibrary.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tools")
public class ToolController {
    private ToolService toolService;
    private ToolMapper toolMapper;

    @Autowired
    public ToolController(ToolService toolService, ToolMapper toolMapper) {
        this.toolService = toolService;
        this.toolMapper = toolMapper;
    }

    @PostMapping
    public ResponseEntity<ToolDto> createTool(@RequestBody ToolDto toolDto) {
        Tool tool = toolMapper.toEntity(toolDto);
        Tool savedTool = toolService.save(tool);
        return new ResponseEntity<>(toolMapper.toDto(savedTool), HttpStatus.CREATED);
    }

    @GetMapping("/get-Tool/{id}")
    public ResponseEntity<ToolDto> getToolById(@PathVariable Long id) {
        return ResponseEntity.ok(toolMapper.toDto(toolService.getToolById(id)));
    }

    @GetMapping("/get-All-Tools")
    public ResponseEntity<List<ToolDto>> getTools() {
        List<Tool> tools = toolService.getAllTool();
        List<ToolDto> toolDtos = tools.stream().map(toolMapper::toDto).toList();
        return new ResponseEntity<>(toolDtos, HttpStatus.OK);
    }

    @PatchMapping("/partial-Update-Tool/{id}")
    public ResponseEntity<ToolDto> partialUpdateTool(@PathVariable Long id, @RequestBody ToolDto toolDto) {
        Tool tool = toolMapper.toEntity(toolDto);
        Tool updatedTool = toolService.partiallyUpdateTool(id, tool);
        return new ResponseEntity<>(toolMapper.toDto(updatedTool), HttpStatus.OK);
    }

    @DeleteMapping("/delete-Tool/{id}")
    public ResponseEntity<?> deleteTool(@PathVariable Long id) {
        toolService.deleteTool(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
