package queryFiles;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

//Table model for members table
public class MembersTableModel extends AbstractTableModel{
	EntityManagerFactory emf;
	EntityManager manager;
	EntityTransaction transaction;
	Members[] members;
	
	//Using a project id given, this constructor finds all entries in 
	//the members table with that projectid and stores the result
	//in the class field array called members.
	public MembersTableModel(int projectid) {
		emf = Persistence.createEntityManagerFactory("Temp_GUI");
		manager = emf.createEntityManager();
		transaction = manager.getTransaction();
		
		TypedQuery<Members> query = manager.createQuery("Select e FROM member_details e WHERE e.project_id = :pid", Members.class);
		query.setParameter("pid", projectid);
		List<Members> tempmembers = query.getResultList();
		members = new Members[tempmembers.size()];
		for(int i=0; i<tempmembers.size(); i++){
			members[i] = (Members) tempmembers.get(i);
		}
	}
	
	//Table model stuff
	public int getRowCount() {
		return members.length;
	}
	
	public int getColumnCount() {
		return 2;
	}
	
	public String getValueAt(int row, int col) {
		if(row>=0){
			if (col == 0){
				return members[row].getmember_name();
			}
			else if (col == 1){
				return members[row].getmember_role();
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
			return "Member Name";
		else if (col == 1){
			return "Member Role";
		}
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
	}
	
	//getter for members
	public Members[] getMembers(){
		return members;
	}
}
