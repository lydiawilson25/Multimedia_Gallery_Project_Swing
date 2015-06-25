package queryFiles;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//ENTITY CLASS FOR member_details TABLE
@Entity(name = "member_details")
public class Members implements Serializable{
	  @Id
	  @GeneratedValue(strategy = GenerationType.TABLE)
	  @Column
	  private int member_id;
	  @Column
	  private int project_id;
	  @Column
	  private String member_name;
	  @Column
	  private String member_role;
	 
	  public int getmember_id(){
		  return member_id;
	  }
	  public int getproject_id() {
	    return project_id;
	  }
	  public String getmember_name(){
		  return member_name;
	  }
	  public String getmember_role(){
		  return member_role;
	  }
	  
	  public void setmember_id(int d){
		  member_id = d;
	  }
	  public void setproject_id(int d){
		  project_id = d;
	  }
	  public void setmember_name(String s){
		  member_name = s;
	  }
	  public void setmember_role(String s){
		  member_role = s;
	  }
	  
	   // return number of columns in the table
	   public int getNumberOfColumns() {
		   return 4;
	   }
	   
	   // return the data in column i
	   public Object getColumnData(int i) throws Exception {
		   if (i == 0)
			   return getmember_id();
		   else if (i == 1)
			   return getproject_id();
		   else if (i == 2) 
			   return getmember_name();
		   else if (i == 3) 
			   return getmember_role();
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
			   colName = "Member Role";
		   else if (i == 3)
			   colName = "Member Name";
		   else
			   throw new Exception("Access to invalid column number in courselist table");
		   
		   return colName;
	   }
	   
	   // set data column i to value
	   public void setColumnData(int i, String value) throws Exception {
		   if (i == 0) 
			   member_id = Integer.parseInt(value);
		   else if (i == 1) 
			   project_id = Integer.parseInt(value);
		   else if (i == 2) 
			   member_name = value;
		   else if (i == 3)
			   member_role = value;
		   else
			   throw new Exception("Error: invalid column index in courselist table");    
	   }
	   
	  @Override
	  public String toString() {
	    return "ProjectDetails [Member ID = " + member_id + ", "
	    	    + " Project ID = " + project_id + ","
	    	    + " Member Name = " + member_name + ","
	    	    + " Member Role = " + member_role + ","
	        + "]";
	  }
}
