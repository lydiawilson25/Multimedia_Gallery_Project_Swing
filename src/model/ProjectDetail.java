package model;

import model.MediaDetail;
import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistent class for the project_details database table.
 * 
 */
@Entity
@Table(name = "project_details")
@NamedQuery(name = "ProjectDetail.findAll", query = "SELECT p FROM ProjectDetail p")
public class ProjectDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "project_id")
	private int projectId;

	@Column(name = "disciplines_involved")
	private String disciplinesInvolved;

	@Column(name = "project_comments")
	private String projectComments;

	@Column(name = "project_description")
	private String projectDescription;

	@Column(name = "project_enddate")
	private String projectEnddate;

	@Column(name = "project_last_updated")
	private String projectLastUpdated;

	@Column(name = "project_startdate")
	private String projectStartdate;

	@Column(name = "project_status")
	private String projectStatus;

	@Column(name = "project_theme")
	private String projectTheme;

	@Column(name = "project_title")
	private String projectTitle;

	@Column(name = "prototype_location")
	private String prototypeLocation;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project", fetch=FetchType.EAGER)
	private final List<MediaDetail> mediafiles = new ArrayList<MediaDetail>();

	public List<MediaDetail> getMediafiles() {
		return mediafiles;
	}

	public ProjectDetail() {
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getDisciplinesInvolved() {
		return this.disciplinesInvolved;
	}

	public void setDisciplinesInvolved(String disciplinesInvolved) {
		this.disciplinesInvolved = disciplinesInvolved;
	}

	public String getProjectComments() {
		return this.projectComments;
	}

	public void setProjectComments(String projectComments) {
		this.projectComments = projectComments;
	}

	public String getProjectDescription() {
		return this.projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectEnddate() {
		return this.projectEnddate;
	}

	public void setProjectEnddate(String projectEnddate) {
		this.projectEnddate = projectEnddate;
	}

	public String getProjectLastUpdated() {
		return this.projectLastUpdated;
	}

	public void setProjectLastUpdated(String projectLastUpdated) {
		this.projectLastUpdated = projectLastUpdated;
	}

	public String getProjectStartdate() {
		return this.projectStartdate;
	}

	public void setProjectStartdate(String projectStartdate) {
		this.projectStartdate = projectStartdate;
	}

	public String getProjectStatus() {
		return this.projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectTheme() {
		return this.projectTheme;
	}

	public void setProjectTheme(String projectTheme) {
		this.projectTheme = projectTheme;
	}

	public String getProjectTitle() {
		return this.projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getPrototypeLocation() {
		return this.prototypeLocation;
	}

	public void setPrototypeLocation(String prototypeLocation) {
		this.prototypeLocation = prototypeLocation;
	}

	// return number of columns in the table
	public int getNumberOfColumns() {
		return 11;
	}

	// return the data in column i
	public String getColumnData(int i) throws Exception {
		if (i == 0)
			return Integer.toString(getProjectId());
		else if (i == 1)
			return getProjectTitle();
		else if (i == 2)
			return getProjectStatus();
		// return Integer.toString(getEnrollment());
		else if (i == 3)
			return getProjectLastUpdated();
		else if (i == 4)
			return getProjectStartdate();
		else if (i == 5)
			return getProjectEnddate();
		else if (i == 6)
			return getProjectDescription();
		else if (i == 7)
			return getProjectComments();
		else if (i == 8)
			return getProjectTheme();
		else if (i == 9)
			return getDisciplinesInvolved();
		else if (i == 10)
			return getPrototypeLocation();

		else
			throw new Exception("Error: invalid column index in project table");
	}

	// return the name of column i
	public String getColumnName(int i) throws Exception {
		String colName = null;
		if (i == 0)
			colName = "Project ID";
		else if (i == 1)
			colName = "Title";
		else if (i == 2)
			colName = "Status";
		else if (i == 3)
			colName = "Last Updated Date";
		else if (i == 4)
			colName = "Start Date";
		else if (i == 5)
			colName = "End Date";
		else if (i == 6)
			colName = "Description";
		else if (i == 7)
			colName = "Comments";
		else if (i == 8)
			colName = "Theme";
		else if (i == 9)
			colName = "Disciplines";
		else if (i == 10)
			colName = "Prototype Location";

		else
			throw new Exception(
					"Access to invalid column number in courselist table");

		return colName;
	}

	// set data column i to value
	public void setColumnData(int i, Object value) throws Exception {
		if (i == 0)
			projectId = Integer.parseInt((String) value);
		else if (i == 1)
			projectTitle = (String) value;
		else if (i == 2)
			projectStatus = (String) value;
		else if (i == 3)
			projectLastUpdated = (String) value;
		else if (i == 4)
			projectStartdate = (String) value;
		else if (i == 5)
			projectEnddate = (String) value;
		else if (i == 6)
			projectDescription = (String) value;
		else if (i == 7)
			projectComments = (String) value;
		else if (i == 8)
			projectTheme = (String) value;
		else if (i == 9)
			disciplinesInvolved = (String) value;
		else if (i == 10)
			prototypeLocation = (String) value;
		else
			throw new Exception(
					"Error: invalid column index in courselist table");
	}

	@Override
	public String toString() {
		StringBuilder obj = new StringBuilder();
		obj.append("ProjectDetail [projectId=").append(projectId).append(", disciplinesInvolved=")
		.append(disciplinesInvolved).append(", projectComments=").append(projectComments)
		.append(", projectDescription=").append(projectDescription).append(", projectEnddate=")
		.append(projectEnddate).append(", projectLastUpdated=").append(projectLastUpdated)
		.append(", projectStartdate=").append(projectStartdate).append(", projectStatus=")
		.append(projectStatus).append(", projectTheme=").append(projectTheme)
		.append(", projectTitle=").append(projectTitle).append(", prototypeLocation=")
		.append(prototypeLocation).append(", mediafiles=").append(mediafiles).append("]");
		return obj.toString();
	}

}