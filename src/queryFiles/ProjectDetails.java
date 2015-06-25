package queryFiles;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//ENTITY CLASS FOR project_details TABLE
@Entity(name = "project_details")
public class ProjectDetails implements Serializable{
	  @Id
	  @GeneratedValue(strategy = GenerationType.TABLE)
	  @Column
	  private int project_id;
	  @Column
	  private String project_title;
	  @Column
	  private String project_status;
	  @Column
	  private String project_last_updated;
	  @Column
	  private String project_startdate;
	  @Column
	  private String project_enddate;
	  @Column
	  private String project_description;
	  @Column
	  private String project_comments;
	  @Column
	  private String project_theme;
	  @Column
	  private String disciplines_involved;
	  @Column
	  private String prototype_location;
	  
	  public int getproject_id() {
	    return project_id;
	  }
	  public String getproject_title(){
		  return project_title;
	  }
	  public String getproject_status(){
		  return project_status;
	  }
	  public String getproject_last_updated(){
		  return project_last_updated;
	  }
	  public String getproject_startdate(){
		  return project_startdate;
	  }
	  public String getproject_enddate(){
		  return project_enddate;
	  }
	  public String getproject_description(){
		  return project_description;
	  }
	  public String getproject_comments(){
		  return project_comments;
	  }
	  public String getproject_theme(){
		  return project_theme;
	  }
	  public String getdisciplines_involved(){
		  return disciplines_involved;
	  }
	  public String getprototype_location(){
		  return prototype_location;
	  }
	  
	  public void setproject_id(int d){
		  project_id = d;
	  }
	  public void setproject_title(String s){
		  project_title = s;
	  }
	  public void setproject_status(String s){
		  project_status = s;
	  }
	  public void setproject_last_updated(String s){
		  project_last_updated = s;
	  }
	  public void setproject_startdate(String s){
		  project_startdate = s;
	  }
	  public void setproject_enddate(String s){
		  project_enddate = s;
	  }
	  public void setproject_description(String s){
		  project_description = s;
	  }
	  public void setproject_comments(String s){
		  project_comments = s;
	  }
	  public void setproject_theme(String s){
		  project_theme = s;
	  }
	  public void setdisciplines_involved(String s){
		  disciplines_involved = s;
	  }
	  public void setprototype_location(String s){
		  prototype_location = s;
	  }
	  
	   // return number of columns in the table
	   public int getNumberOfColumns() {
		   return 11;
	   }
	   
	   // return the data in column i
	   public Object getColumnData(int i) throws Exception {
		   if (i == 0)
			   return getproject_id();
		   else if (i == 1)
			   return getproject_title();
		   else if (i == 2) 
			   return getproject_status();
		   else if (i == 3) 
			   return getproject_last_updated();
		   else if (i == 4) 
			   return getproject_startdate();
		   else if (i == 5) 
			   return getproject_enddate();
		   else if (i == 6) 
			   return getproject_description();
		   else if (i == 7) 
			   return getproject_comments();
		   else if (i == 8) 
			   return getproject_theme();
		   else if (i == 9) 
			   return getdisciplines_involved();
		   else if (i == 10) 
			   return getprototype_location();
		   else
			   throw new Exception("Error: invalid column index in courselist table");    
	   }
	   
	   // return the name of column i
	   public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 0) 
			   colName = "Project ID";
		   else if (i == 1)
			   colName = "Project Title";
		   else if (i == 2)
			   colName = "Status";
		   else if (i == 3)
			   colName = "Last Updated";
		   else if (i == 4)
			   colName = "Start Date";
		   else if (i == 5)
			   colName = "End Date";
		   else if (i == 6)
			   colName = "Description";
		   else if (i == 7)
			   colName = "Comments";
		   else if (i == 8)
			   colName = "Themes";
		   else if (i == 9)
			   colName = "Disciplines Involved";
		   else if (i == 10)
			   colName = "Prototype Location";
		   else
			   throw new Exception("Access to invalid column number in courselist table");
		   
		   return colName;
	   }
	   
	   // set data column i to value
	   public void setColumnData(int i, String value) throws Exception {
		   if (i == 0) 
			   project_id = Integer.parseInt(value);
		   else if (i == 1) 
			   project_title = value;
		   else if (i == 2) 
			   project_status = value;
		   else if (i == 3)
			   project_last_updated = value;
		   else if (i == 4)
			   project_startdate = value;
		   else if (i == 5)
			   project_enddate = value;
		   else if (i == 6)
			   project_description = value;
		   else if (i == 7)
			   project_comments = value;
		   else if (i == 8)
			   project_theme = value;
		   else if (i == 9)
			   disciplines_involved = value;
		   else if (i == 10)
			   prototype_location = value;
		   else
			   throw new Exception("Error: invalid column index in courselist table");    
	   }
	   
	  @Override
	  public String toString() {
	    return "ProjectDetails [ProjectID = " + project_id + ", "
	    	    + " Project Title = " + project_title + ","
	    	    + " Status = " + project_status + ","
	    	    + " Last Updated = " + project_last_updated + ","
	    	    + " Start Date = " + project_startdate + ","
	    	    + " End Date = " + project_enddate + ","
	    	    + " Description = " + project_description + ","
	    	    + " Comments = " + project_comments + ","
	    	    + " Theme = " + project_theme + ","
	    	    + " Disciplines Involved = " + disciplines_involved + ","
	    	    + " Prototype Location = " + prototype_location + ","
	        + "]";
	  }
	  
	  @Override
	  public boolean equals(Object other){
		  if(other instanceof ProjectDetails){
			  if(other == null) return false;
			  if(((ProjectDetails)other).getproject_id() == getproject_id()) return true;
		  }
		  return false;
	  }
}
