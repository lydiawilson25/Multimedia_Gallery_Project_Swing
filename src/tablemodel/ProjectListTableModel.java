package tablemodel;

import model.ProjectDetail;
import service.ProjectListService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;
import java.util.*;

public class ProjectListTableModel extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    List<ProjectDetail> projectDetailList; // stores the model data in a List
    // collection of type projectlist
    private static final String PERSISTENCE_UNIT_NAME = "Temp_GUI"; // Used in
    // persistence.xml
    private static EntityManagerFactory factory; // JPA
    private EntityManager manager; // JPA
    private ProjectDetail projectlist; // represents the entity projectlist
    private ProjectListService projectlistService;

    // This field contains additional information about the results
    int numcols, numrows; // number of rows and columns

    public ProjectListTableModel() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        projectlist = new ProjectDetail();
        projectlistService = new ProjectListService(manager);

        // read all the records from projectlist
        projectDetailList = projectlistService.readAll();

        // update the number of rows and columns in the model
        numrows = projectDetailList.size();
        numcols = projectlist.getNumberOfColumns();
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
            return projectDetailList.get(row).getColumnData(col);
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
            return projectlist.getColumnName(col);
        } catch (Exception err) {
            return err.toString();
        }
    }

    // update the data in the given row and column to aValue
    public void setValueAt(Object aValue, int row, int col) {
        // data[rowIndex][columnIndex] = (String) aValue;
        try {
            ProjectDetail element = projectDetailList.get(row);
            element.setColumnData(col, aValue);
            fireTableCellUpdated(row, col);
        } catch (Exception err) {
            err.toString();
        }
    }

    public List<ProjectDetail> getList() {
        return projectDetailList;
    }

    public EntityManager getEntityManager() {
        return manager;
    }

    // create a new table model using the existing data in list
    public ProjectListTableModel(List<ProjectDetail> list, EntityManager em) {
        projectDetailList = list;
        numrows = projectDetailList.size();
        projectlist = new ProjectDetail();
        numcols = projectlist.getNumberOfColumns();
        manager = em;
        projectlistService = new ProjectListService(manager);
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
        ProjectDetail newRecord = projectlistService.createProject(
                Integer.parseInt(array[0]), (String) array[1],
                (String) array[2], (String) array[3], (String) array[4],
                (String) array[5], (String) array[6], (String) array[7],
                (String) array[8], (String) array[9], (String) array[10]);
        userTransaction.commit();

        // set the current row to rowIndex
        projectDetailList.add(newRecord);
        int row = projectDetailList.size();
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
        projectlistService.updateProject(
                Integer.parseInt(array[0]), (String) array[1],
                (String) array[2], (String) array[3], (String) array[4],
                (String) array[5], (String) array[6], (String) array[7],
                (String) array[8], (String) array[9], (String) array[10]);
        userTransaction.commit();
        fireTableCellUpdated(row, 0);
        // set the current row to rowIndex
//        projectDetailList.add(newRecord);
//        int row = projectDetailList.size();
//        int col = 0;
//
//        // update the data in the model to the entries in array
//        for (Object data : array) {
//            setValueAt((String) data, row - 1, col++);
//        }
//
//        numrows++;
    }

    public void deleteRow(String[] array, int row) {
		// data[rowIndex][columnIndex] = (String) aValue;

        // add row to database
        EntityTransaction userTransaction = manager.getTransaction();
        userTransaction.begin();
        ProjectDetail project = projectlistService.deleteProject(Integer
                .parseInt(array[0]));
        userTransaction.commit();

        // set the current row to rowIndex
        projectDetailList.remove(project);

        fireTableCellUpdated(row, 0);

		// // update the data in the model to the entries in array
        // for (Object data : array) {
        // setValueAt((String) data, row - 1, col++);
        // }
        //
        // numrows++;
    }
}
