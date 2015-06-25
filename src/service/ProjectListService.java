package service;

import model.ProjectDetail;
import javax.persistence.*;
import java.util.*;

public class ProjectListService {

    private EntityManager manager;

    public ProjectListService(EntityManager manager) {
        this.manager = manager;
    }

    public ProjectDetail createProject(int projectID, String projectTitle,
            String projectStatus, String projectLastUpdated, String startDate,
            String endDate, String description, String comments, String theme,
            String disciplines, String location) {
        ProjectDetail project = new ProjectDetail();
        project.setProjectId(projectID);
        project.setProjectTitle(projectTitle);
        project.setProjectStatus(projectStatus);
        project.setProjectLastUpdated(projectLastUpdated);
        project.setProjectStartdate(startDate);
        project.setProjectEnddate(endDate);
        project.setProjectDescription(description);
        project.setProjectComments(comments);
        project.setProjectTheme(theme);
        project.setDisciplinesInvolved(disciplines);
        project.setPrototypeLocation(location);
        manager.persist(project);
        return project;
    }

    // method to read a record
    public ProjectDetail readProject(int projectID) {
        ProjectDetail project = manager.find(ProjectDetail.class, projectID);
        return project;
    }

    // method to read all records
    public List<ProjectDetail> readAll() {
        TypedQuery<ProjectDetail> query = manager.createQuery(
                "SELECT e FROM ProjectDetail e", ProjectDetail.class);
        List<ProjectDetail> result = query.getResultList();
        return result;
    }

    // method to update a record
    public void updateProject(int projectID, String projectTitle,
            String projectStatus, String projectLastUpdated, String startDate,
            String endDate, String description, String comments, String theme,
            String disciplines, String location) {
            ProjectDetail project = manager.find(ProjectDetail.class, projectID);
            project.setDisciplinesInvolved(disciplines);
            project.setProjectComments(comments);
            project.setProjectDescription(description);
            project.setProjectEnddate(endDate);
            project.setProjectStatus(projectStatus);
            project.setProjectTheme(theme);
            project.setProjectTitle(projectTitle);
            project.setProjectLastUpdated(projectLastUpdated);
            project.setPrototypeLocation(location);
            project.setProjectStartdate(startDate);
            manager.merge(project);            
    }

    // method to delete a record
    public ProjectDetail deleteProject(int projectID) {

        ProjectDetail project = manager.find(ProjectDetail.class, projectID);

        if (project != null) {
            manager.remove(project);
        }
        return project;
    }

}
