package queryFiles;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

//Table model class for media table
public class MediaTableModel extends AbstractTableModel{
	EntityManagerFactory emf;
	EntityManager manager;
	EntityTransaction transaction;
	Media[] media;
	
	//Using a project id given, this constructor finds all entries in 
	//the media_details table with that projectid and stores the result
	//in the class field array called media.
	public MediaTableModel(int projectid) {
		emf = Persistence.createEntityManagerFactory("Temp_GUI");
		manager = emf.createEntityManager();
		transaction = manager.getTransaction();
		
		TypedQuery<Media> query = manager.createQuery("Select e FROM media_details e WHERE e.project_id = :pid", Media.class);
		query.setParameter("pid", projectid);
		List<Media> tempmedia = query.getResultList();
		media = new Media[tempmedia.size()];
		for(int i=0; i<tempmedia.size(); i++){
			media[i] = (Media) tempmedia.get(i);
		}
	}
	
	//Table model stuff
	public int getRowCount() {
		return media.length;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getValueAt(int row, int col) {
		if(row>=0){
			if (col == 0){
				return media[row].getmedia_type();
			}
			else if (col == 1){
				return media[row].getmedia_name();
			}
			else if (col == 2){
				return media[row].getdescription();
			}
			else if (col == 3){
				return media[row].getmedia_file();
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
			return "Media Type";
		else if (col == 1){
			return "Media Name";
		}
		else if (col == 2){
			return "Member Description";
		}
		else if (col == 2){
			return "Member File";
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
	
	//getter for media array
	public Media[] getMedia(){
		return media;
	}
}
