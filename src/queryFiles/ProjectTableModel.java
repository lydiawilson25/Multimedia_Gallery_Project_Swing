package queryFiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

//table model for project name table
public class ProjectTableModel extends AbstractTableModel{
	EntityManagerFactory emf;
	EntityManager manager;
	EntityTransaction transaction;
	ProjectDetails[] projects;
	String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December"};

	//constructor for table model takes all the textfields used for query and uses them to filter 
	//the projects in the database, storing the remaining projects in field array projects.
	public ProjectTableModel(String project_title, String current_status, 
			String year_start_date, String month_start_date, String year_end_date, 
			String month_end_date, String theme, String members, String description, String media_type) {
		emf = Persistence.createEntityManagerFactory("Temp_GUI");
		manager = emf.createEntityManager();
		transaction = manager.getTransaction();

		//query from the database based on the project_title string.
		//if the string is empty, select all and if not, select using LIKE.
		TypedQuery<ProjectDetails> query;
		if(project_title.equals("")){
			query = manager.createQuery("Select e FROM project_details e", ProjectDetails.class);
		}
		else{
			query = manager.createQuery("Select e FROM project_details e WHERE e.project_title LIKE :pname", ProjectDetails.class);
			query.setParameter("pname", "%"+ project_title + "%");
		}

		//store query results in tempprojects.
		List<ProjectDetails> tempprojects = query.getResultList();
		
		//Go through a series of filters using the other string fields passed in
		if(!current_status.equals(""))
			tempprojects = filterStatus(current_status, tempprojects);
		if(!year_start_date.equals("No Filter") || !month_start_date.equals("No Filter"))
			tempprojects = filterStartDate(year_start_date, month_start_date, tempprojects);
		if(!year_end_date.equals("No Filter") || !month_end_date.equals("No Filter"))
			tempprojects = filterEndDate(year_end_date, month_end_date, tempprojects);
		if(!theme.equals(""))
			tempprojects = filterTheme(theme, tempprojects);
		if(!members.equals(""))
			tempprojects = filterMembers(members, tempprojects);
		if(!description.equals(""))
			tempprojects = filterDescription(description, tempprojects);
		if(!media_type.equals("No Filter"))
			tempprojects = filterMediaType(media_type, tempprojects);
			
		//finally store the remaining projects in projects array.
		Set<ProjectDetails> tempprojectsSet = new HashSet<ProjectDetails>(tempprojects);
		projects = tempprojectsSet.toArray(new ProjectDetails[tempprojectsSet.size()]);
	}
	
	//filters projects based on status
	//checks to see if status' of the projects passed in contain the status filter.
	public List<ProjectDetails> filterStatus(String status, List<ProjectDetails> projects){
		System.out.println("Status");
		for(int i=0; i<projects.size();){
			String one = projects.get(i).getproject_status().toLowerCase();
			String two = status.toLowerCase();
			if(!one.contains(two)){
				projects.remove(i);
			}
			else if (i<projects.size())
				i++;
			else
				break;
		}
		return projects;
	}
	public List<ProjectDetails> filterStartDate(String year_start_date, String month_start_date, List<ProjectDetails> projects){
		System.out.println("Start Date");
		int month_index = Arrays.asList(months).indexOf(month_start_date) + 1;
		String month;
		if(month_index < 10)
			month = ("" + 0 + month_index);
		else
			month = ("" + month_index);
		if (!year_start_date.equals("No Filter") && month_start_date.equals("No Filter")){
			for(int i=0; i<projects.size();){
				String one = projects.get(i).getproject_startdate();
				String two = year_start_date;
				if(!one.contains(two)){
					projects.remove(i);
				}
				else if (i<projects.size())
					i++;
				else
					break;
			}
		}
		else if(year_start_date.equals("No Filter") && !month_start_date.equals("No Filter")){
			for(int i=0; i<projects.size();){
				String one = projects.get(i).getproject_startdate();
				String[] parts = one.split("-");
				String two = month;
				if(!parts[1].contains(two)){
					projects.remove(i);
				}
				else if (i<projects.size())
					i++;
				else
					break;
			}
		}
		else if (!year_start_date.equals("No Filter") && !month_start_date.equals("No Filter")){
			for(int i=0; i<projects.size();){
				String one = projects.get(i).getproject_startdate();
				String two = year_start_date;
				String[] parts = one.split("-");
				String three = month;
				if(!one.contains(two) || !parts[1].contains(three)){
					projects.remove(i);
				}
				else if (i<projects.size())
					i++;
				else
					break;
			}
		}
		return projects;
	}
	public List<ProjectDetails> filterEndDate(String year_end_date, String month_end_date, List<ProjectDetails> projects){
		System.out.println("End Date");
		System.out.println(year_end_date);
		System.out.println(month_end_date);
		int month_index = Arrays.asList(months).indexOf(month_end_date) + 1;
		String month;
		if(month_index < 10)
			month = ("" + 0 + month_index);
		else
			month = ("" + month_index);
		if (!year_end_date.equals("No Filter") && month_end_date.equals("No Filter")){
			for(int i=0; i<projects.size();){
				String one = projects.get(i).getproject_enddate();
				String two = year_end_date;
				if(!one.contains(two)){
					projects.remove(i);
				}
				else if (i<projects.size())
					i++;
				else
					break;
			}
		}
		else if(year_end_date.equals("No Filter") && !month_end_date.equals("No Filter")){
			for(int i=0; i<projects.size();){
				String one = projects.get(i).getproject_enddate();
				String[] parts = one.split("-");
				String two = month;
				System.out.println(parts[1]);
				if(!parts[1].contains(two)){
					projects.remove(i);
				}
				else if (i<projects.size())
					i++;
				else
					break;
			}
		}
		else if (!year_end_date.equals("No Filter") && !month_end_date.equals("No Filter")){
			for(int i=0; i<projects.size();){
				String one = projects.get(i).getproject_enddate();
				String two = year_end_date;
				String[] parts = one.split("-");
				String three = month;
				if(!one.contains(two) || !parts[1].contains(three)){
					projects.remove(i);
				}
				else if (i<projects.size())
					i++;
				else
					break;
			}
		}
		return projects;
	}
	
	//filters projects based on theme
	//checks to see if themes' of the projects passed in contain the theme filter.
	public List<ProjectDetails> filterTheme(String theme, List<ProjectDetails> projects){
		System.out.println("Theme");
		for(int i=0; i<projects.size();){
			String one = projects.get(i).getproject_theme().toLowerCase();
			String two = theme.toLowerCase();
			if(!one.contains(two)){
				projects.remove(i);
			}
			else if (i<projects.size())
				i++;
			else
				break;
		}
		return projects;
	}
	
	//filters projects based on members involved
	//queries members that contain the members string than compares the project id's
	//of these members to the project id's of the projects keeping the projects
	//that find a match.
	public List<ProjectDetails> filterMembers(String members, List<ProjectDetails> projects){
		System.out.println("Members");
		TypedQuery<Members> queryMembers;
		queryMembers = manager.createQuery("Select e FROM member_details e WHERE e.member_name LIKE :mname", Members.class);
		queryMembers.setParameter("mname", "%"+ members + "%");
		List<Members> tempMembers = queryMembers.getResultList();
		
		boolean flag;
		for(int i=0; i<projects.size();){
			flag = false;
			int one = projects.get(i).getproject_id();
			for(int j=0; j<tempMembers.size(); j++){
				if(tempMembers.get(j).getproject_id() == one){
					flag = true;
					break;
				}
			}
			if(flag == false){
				projects.remove(i);
			}
			else if (i<projects.size())
				i++;
			else
				break;
		}
		return projects;
	}
	
	//filters projects based on theme
	//checks to see if themes' of the projects passed in contain the theme filter.
	public List<ProjectDetails> filterDescription(String description, List<ProjectDetails> projects){
		System.out.println("Description");
		for(int i=0; i<projects.size();){
			String one = projects.get(i).getproject_description().toLowerCase();
			String two = description.toLowerCase();
			if(!one.contains(two)){
				projects.remove(i);
			}
			else if (i<projects.size())
				i++;
			else
				break;
		}
		return projects;
	}
	
	//filters projects based on media content
	//queries media that contain the media_type string than compares the project id's
	//of these media to the project id's of the projects keeping the projects
	//that find a match.
	public List<ProjectDetails> filterMediaType(String media_type, List<ProjectDetails> projects){
		System.out.println("Media Type");
		TypedQuery<Media> queryMedia;
		queryMedia = manager.createQuery("Select e FROM media_details e WHERE e.media_type = :mtype", Media.class);
		queryMedia.setParameter("mtype", media_type);
		List<Media> tempMedia = queryMedia.getResultList();
		
		boolean flag;
		for(int i=0; i<projects.size();){
			flag = false;
			int one = projects.get(i).getproject_id();
			for(int j=0; j<tempMedia.size(); j++){
				if(tempMedia.get(j).getproject_id() == one){
					flag = true;
					break;
				}
			}
			if(flag == false){
				projects.remove(i);
			}
			else if (i<projects.size())
				i++;
			else
				break;
		}
		return projects;
	}
	
	//table model stuff
	public int getRowCount() {
		return projects.length;
	}
	
	public int getColumnCount() {
		return 1;
	}
	
	public String getValueAt(int row, int col) {
		if(row>=0){
			if (col == 0){
				return projects[row].getproject_title();
			}
			else
				return "N/A";
		}
		else
			return "N/A";
	}
	
	public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	}
	
	public Class<?> getColumnClass(int col) {
		return String.class;
	}
	
	public String getColumnName(int col) {
		if (col == 0)
			return "Project Title";
		else
			return "N/A";
	}
	
	public void addTableModelListener(TableModelListener l) {
		// not used
	}
	
	public void removeTableModelListener(TableModelListener l) {
		// not used
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		//not used
	}

	public ProjectDetails[] getProjects(){
		return projects;
	}
}
