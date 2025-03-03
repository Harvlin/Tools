package com.project.ToolsLibrary.service.impl;

import com.project.ToolsLibrary.domain.entity.Tool;
import com.project.ToolsLibrary.repository.ToolRepository;
import com.project.ToolsLibrary.service.ToolService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ToolServiceImpl implements ToolService {

    private final ToolRepository toolRepository;

    @Autowired
    public ToolServiceImpl(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @Override
    public Tool getToolById(Long id) {
        return toolRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tool Not Found"));
    }

    @Override
    public Tool getToolByName(String toolName) {
        return toolRepository.findByName(toolName).orElseThrow(() -> new EntityNotFoundException("Tool Not Found"));
    }

    @Override
    public List<Tool> getToolsByCategory(String category) {
        return toolRepository.findByCategory(category);
    }

    @Override
    public List<Tool> getToolsByAvailability(Boolean availability) {
        return toolRepository.findToolsByAvailability(availability);
    }

    @Override
    public List<Tool> getByCondition(String condition) {
        return toolRepository.findToolByCondition(condition);
    }

    @Override
    public List<Tool> getAllTool() {
        return toolRepository.findAll();
    }

    @Override
    public Tool save(Tool tool) {
        return toolRepository.findById(tool.getId())
                .orElseGet(() -> toolRepository.save(tool));
    }

    @Override
    public Tool partiallyUpdateTool(Long id, Tool tool) {
        tool.setId(id);
        return toolRepository.findById(id).map(existingTool -> {
            Optional.ofNullable(tool.getName()).ifPresent(existingTool::setName);
            Optional.ofNullable(tool.getCategory()).ifPresent(existingTool::setCategory);
            Optional.ofNullable(tool.getDescription()).ifPresent(existingTool::setDescription);
            Optional.ofNullable(tool.getSafetyRequirements()).ifPresent(existingTool::setSafetyRequirements);
            Optional.ofNullable(tool.getCondition()).ifPresent(existingTool::setCondition);
            Optional.ofNullable(tool.getAvailable()).ifPresent(existingTool::setAvailable);
            Optional.ofNullable(tool.getQrCode()).ifPresent(existingTool::setQrCode);
            Optional.ofNullable(tool.getReservations()).ifPresent(existingTool::setReservations);
            return toolRepository.save(existingTool);
        }).orElseThrow(() -> new EntityNotFoundException("Tool Not Found"));
    }

    @Override
    public void deleteTool(Long id) {
        if (toolRepository.existsById(id)) {
            toolRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Tool Not Found");
        }
    }
}
