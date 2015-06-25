package tablemodel;

import model.MediaDetail;
import service.MediaListService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;
import java.util.*;

public class MediaListTableModel extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    List<MediaDetail> mediaDetailList; // stores the model data in a List
    // collection of type projectlist
    private static final String PERSISTENCE_UNIT_NAME = "Temp_GUI"; // Used in
    public static String mediaProjectID; // Used in
    // persistence.xml
    private static EntityManagerFactory factory; // JPA
    private EntityManager manager; // JPA
    private MediaDetail medialist; // represents the entity projectlist
    private MediaListService medialistService;

    // This field contains additional information about the results
    int numcols, numrows; // number of rows and columns

    public MediaListTableModel() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        medialist = new MediaDetail();
        medialistService = new MediaListService(manager);

        // read all the records from projectlist
        mediaDetailList = medialistService.readMediaFiles(1);

        // update the number of rows and columns in the model
        numrows = mediaDetailList.size();
        
        numcols = medialist.getNumberOfColumns();
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
            return mediaDetailList.get(row).getColumnData(col);
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
            return medialist.getColumnName(col);
        } catch (Exception err) {
            return err.toString();
        }
    }

    // update the data in the given row and column to aValue
    public void setValueAt(Object aValue, int row, int col) {
        // data[rowIndex][columnIndex] = (String) aValue;
        try {
            MediaDetail element = mediaDetailList.get(row);
            element.setColumnData(col, aValue);
            fireTableCellUpdated(row, col);
        } catch (Exception err) {
            err.toString();
        }
    }
    
    public List<MediaDetail> getList() {
        return mediaDetailList;
    }
    
    public EntityManager getEntityManager() {
        return manager;
    }

    // create a new table model using the existing data in list
    public MediaListTableModel(List<MediaDetail> list, EntityManager em) {
        mediaDetailList = list;
        numrows = mediaDetailList.size();
        medialist = new MediaDetail();
        numcols = medialist.getNumberOfColumns();
        manager = em;
        medialistService = new MediaListService(manager);
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
        MediaDetail newRecord = medialistService.createMedia(
                Integer.parseInt(array[0]), Integer.parseInt(array[1]),
                (String) array[2], (String) array[3], (String) array[4], (String) array[5]);
        userTransaction.commit();

        // set the current row to rowIndex
        mediaDetailList.add(newRecord);
        array[5] = newRecord.getMediaFile();
        int row = mediaDetailList.size();
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
        medialistService.updateMedia(
                Integer.parseInt(array[0]), Integer.parseInt(array[1]),
                (String) array[2], (String) array[3], (String) array[4],(String) array[5]);
        userTransaction.commit();

        fireTableCellUpdated(row, 0);

    }
        
    public void deleteRow(String[] array, int row) {
		// data[rowIndex][columnIndex] = (String) aValue;

        // add row to database
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        MediaDetail media = medialistService.deleteMedia(Integer
                .parseInt(array[0]),array[5]);
        userTransaction.commit();

        // set the current row to rowIndex
        mediaDetailList.remove(media);
        
        fireTableCellUpdated(row, 0);

    }
    
    public void mediaRecords(int projectId){
        mediaProjectID = Integer.toString(projectId);
        mediaDetailList = medialistService.readMediaFiles(projectId);
                // update the number of rows and columns in the model
        numrows = mediaDetailList.size();
        numcols = medialist.getNumberOfColumns();
        fireTableDataChanged();
    }
}
