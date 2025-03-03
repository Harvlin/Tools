package com.project.ToolsLibrary.service;

import com.project.ToolsLibrary.domain.entity.Tool;

import java.util.List;

public interface ToolService {
    Tool getToolById(Long id);
    Tool getToolByName(String toolName);
    List<Tool> getToolsByCategory(String category);
    List<Tool> getToolsByAvailability(Boolean availability);
    List<Tool> getByCondition(String condition);
    List<Tool> getAllTool();
    Tool save(Tool tool);
    Tool partiallyUpdateTool(Long id, Tool tool);
    void deleteTool(Long id);
}
