package queryFiles;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//ENTITY CLASS FOR media_details TABLE
@SuppressWarnings("serial")
@Entity(name = "media_details")
public class Media implements Serializable{
	@Id
	  @GeneratedValue(strategy = GenerationType.TABLE)
	  @Column
	  private int media_id;
	  @Column
	  private int project_id;
	  @Column
	  private String media_type;
	  @Column
	  private String media_name;
	  @Column
	  private String description;
	  @Column
	  private String media_file;
	 
	  public int getmedia_id(){
		  return media_id;
	  }
	  public int getproject_id() {
	    return project_id;
	  }
	  public String getmedia_type(){
		  return media_type;
	  }
	  public String getmedia_name(){
		  return media_name;
	  }
	  public String getdescription(){
		  return description;
	  }
	  public String getmedia_file(){
		  return media_file;
	  }
	  
	  public void setmedia_id(int d){
		  media_id = d;
	  }
	  public void setproject_id(int d){
		  project_id = d;
	  }
	  public void setmedia_type(String s){
		  media_type = s;
	  }
	  public void setmedia_name(String s){
		  media_name = s;
	  }
	  public void setdescription(String s){
		  description = s;
	  }
	  public void setmedia_file(String s){
		  media_file = s;
	  }
	  
	   // return number of columns in the table
	   public int getNumberOfColumns() {
		   return 6;
	   }
	   
	   // return the data in column i
	   public Object getColumnData(int i) throws Exception {
		   if (i == 0)
			   return getmedia_id();
		   else if (i == 1)
			   return getproject_id();
		   else if (i == 2) 
			   return getmedia_type();
		   else if (i == 3) 
			   return getmedia_name();
		   else if (i == 4) 
			   return getdescription();
		   else if (i == 5) 
			   return getmedia_file();
		   else
			   throw new Exception("Error: invalid column index in courselist table");    
	   }
	   
	   // return the name of column i
	   public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 0) 
			   colName = "Member ID";
		   else if (i == 1)
			   colName = "Project ID";
		   else if (i == 2)
			   colName = "Media Type";
		   else if (i == 3)
			   colName = "Media Name";
		   else if (i == 4)
			   colName = "Description";
		   else if (i == 5)
			   colName = "Media File";
		   else
			   throw new Exception("Access to invalid column number in courselist table");
		   
		   return colName;
	   }
	   
	   // set data column i to value
	   public void setColumnData(int i, String value) throws Exception {
		   if (i == 0) 
			   media_id = Integer.parseInt(value);
		   else if (i == 1) 
			   project_id = Integer.parseInt(value);
		   else if (i == 2) 
			   media_type = value;
		   else if (i == 3)
			   media_name = value;
		   else if (i == 4) 
			   description = value;
		   else if (i == 5)
			   media_file = value;
		   else
			   throw new Exception("Error: invalid column index in courselist table");    
	   }
	   
	  @Override
	  public String toString() {
	    return "MediaDetails [Media ID = " + media_id + ", "
	    	    + " Project ID = " + project_id + ","
	    	    + " Media Type = " + media_type + ","
	    	    + " Media Name = " + media_name + ","
	    	    + " Description = " + description + ","
	    	    + " Media File = " + media_file + ","
	        + "]";
	  }
}
