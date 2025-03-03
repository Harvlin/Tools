package com.project.ToolsLibrary.repository;

import com.project.ToolsLibrary.domain.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
    Optional<Tool> findByName(String name);
    List<Tool> findByCategory(String category);
    List<Tool> findToolsByAvailability(Boolean availability);
    List<Tool> findToolByCondition(String condition);
}
