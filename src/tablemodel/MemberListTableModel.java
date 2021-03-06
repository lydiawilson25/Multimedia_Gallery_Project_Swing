package tablemodel;

import model.MemberDetail;
import service.MemberListService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;

import java.util.*;

public class MemberListTableModel extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    List<MemberDetail> memberDetailList; // stores the model data in a List
    // collection of type projectlist
    private static final String PERSISTENCE_UNIT_NAME = "Temp_GUI"; // Used in
    // persistence.xml
    private static EntityManagerFactory factory; // JPA
    private EntityManager manager; // JPA
    private MemberDetail memberlist; // represents the entity projectlist
    private MemberListService memberlistService;
    public static String memberProjectID; // Used in

    // This field contains additional information about the results
    int numcols, numrows; // number of rows and columns

    public MemberListTableModel() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        memberlist = new MemberDetail();
        memberlistService = new MemberListService(manager);

        // read all the records from projectlist
        memberDetailList = memberlistService.readMembers(1);

        // update the number of rows and columns in the model
        numrows = memberDetailList.size();
        numcols = memberlist.getNumberOfColumns();
    }

    // returns a count of the number of rows
    public int getRowCount() {
        return numrows;
    }

    // returns a count of the number of columns
    public int getColumnCount() {
        return numcols;
    }

    // returns the data at the given row and column number
    public Object getValueAt(int row, int col) {
        try {
            return memberDetailList.get(row).getColumnData(col);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    // table cells are not editable
    public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
    }
    
    public Class<?> getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }

    // returns the name of the column
    public String getColumnName(int col) {
        try {
            return memberlist.getColumnName(col);
        } catch (Exception err) {
            return err.toString();
        }
    }

    // update the data in the given row and column to aValue
    public void setValueAt(Object aValue, int row, int col) {
        // data[rowIndex][columnIndex] = (String) aValue;
        try {
            MemberDetail element = memberDetailList.get(row);
            element.setColumnData(col, aValue);
            fireTableCellUpdated(row, col);
        } catch (Exception err) {
            err.toString();
        }
    }
    
    public List<MemberDetail> getList() {
        return memberDetailList;
    }
    
    public EntityManager getEntityManager() {
        return manager;
    }

    // create a new table model using the existing data in list
    public MemberListTableModel(List<MemberDetail> list, EntityManager em) {
        memberDetailList = list;
        numrows = memberDetailList.size();
        memberlist = new MemberDetail();
        numcols = memberlist.getNumberOfColumns();
        manager = em;
        memberlistService = new MemberListService(manager);
    }

    // In this method, a newly inserted row in the GUI is added to the table
    // model as well as the database table
    // The argument to this method is an array containing the data in the
    // textfields of the new row.
    public void addRow(String[] array) {
		// data[rowIndex][columnIndex] = (String) aValue;

        // add row to database
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        MemberDetail newRecord = memberlistService.createMember(
                Integer.parseInt(array[0]), Integer.parseInt(array[1]),
                (String) array[2], (String) array[3]);
        userTransaction.commit();

        // set the current row to rowIndex
        memberDetailList.add(newRecord);
        int row = memberDetailList.size();
        int col = 0;

        // update the data in the model to the entries in array
        for (Object data : array) {
            setValueAt((String) data, row - 1, col++);
        }
        
        numrows++;
    }
    
        public void updateRow(String[] array, int row) {
		// data[rowIndex][columnIndex] = (String) aValue;

        // add row to database
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        memberlistService.updateMember(
                Integer.parseInt(array[0]), Integer.parseInt(array[1]),
                (String) array[2], (String) array[3]);
        userTransaction.commit();

        fireTableCellUpdated(row, 0);

    }
        
    public void deleteRow(String[] array, int row) {
		// data[rowIndex][columnIndex] = (String) aValue;

        // add row to database
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        MemberDetail media = memberlistService.deleteMedia(Integer
                .parseInt(array[0]));
        userTransaction.commit();

        // set the current row to rowIndex
        memberDetailList.remove(media);
        
        fireTableCellUpdated(row, 0);

    }
    
    public void memberRecords(int projectId){
    	memberProjectID = Integer.toString(projectId);
        memberDetailList = memberlistService.readMembers(projectId);
                // update the number of rows and columns in the model
        numrows = memberDetailList.size();
        numcols = memberlist.getNumberOfColumns();
        fireTableDataChanged();
    }
}
