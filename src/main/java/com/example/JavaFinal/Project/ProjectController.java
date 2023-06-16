package com.example.JavaFinal.Project;


import com.example.JavaFinal.Department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @PostMapping
    public void registerNewEmployee(@RequestBody Project project) {
        projectService.addNewProject(project);
    }

    @DeleteMapping(path = "project/{projectId}")
    public void deleteEmployee(@PathVariable("projectId") Long projectId) {
        projectService.deleteDepartment(projectId);
    }
}
