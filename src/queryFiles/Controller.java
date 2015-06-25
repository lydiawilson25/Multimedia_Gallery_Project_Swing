package queryFiles;

import javax.sql.RowSetEvent;

public class Controller {
	//controller has the tablemodels
	private MembersTableModel membersTableModel;
	private ProjectTableModel projectTableModel;
	private MediaTableModel mediaTableModel;
	
	//getter for gui to access projects in tablemodel
	public ProjectDetails[] getProjects(){
		return projectTableModel.getProjects();
	}
	
	//getters for the tablemodels
	public MembersTableModel getMembersTableModel() {
		return membersTableModel;
	}
	
	public MediaTableModel getMediaTableModel() {
		return mediaTableModel;
	}
	
	public ProjectTableModel getProjectTableModel() {
		return projectTableModel;
	}
	
	//uses the information in the query text fields and creates
	//a new tablemodel using this information

	public void queryProject(String project_title, String current_status, 
			String year_start_date, String month_start_date, String year_end_date, 
			String month_end_date, String theme, String members, String description, String media_type){
			projectTableModel = new ProjectTableModel(project_title, current_status, 
					year_start_date, month_start_date, year_end_date, month_end_date,
					theme, members, description, media_type);
	}
	
	//this function is used to alter the members table model when a project is
	//selected from the project names table. 
	public void queryMembers(int d){
		membersTableModel = new MembersTableModel(d);
	}
	
	//this function is used to alter the media table model when a project is
	//selected from the project names table. 
	public void queryMedia(int d){
		mediaTableModel = new MediaTableModel(d);
	}

	public void cursorMoved(RowSetEvent event) {
		//do nothing
	}
	public void rowSetChanged(RowSetEvent event) {
		//do nothing
	}
}
