package controller;

//import cards.ProjectListGUI;
import gui.ProjectListGUI;
import tablemodel.MediaListTableModel;
import javax.sql.RowSetEvent;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * Updated controller Glue between the view (CourseListGUI) and the model
 * (CourseListTableModel). No database specific code here. Contains a reference
 * to both the TableModel and the graphical user interface.
 *
 * @author rgrover
 */
public class MediaListTableController implements ListSelectionListener,
        TableModelListener {

    private MediaListTableModel tableModel;
    private ProjectListGUI gui;

    public MediaListTableController(ProjectListGUI gui) {
        this.gui = gui;
        // create the tableModel using the data in the cachedRowSet
        tableModel = new MediaListTableModel();
        tableModel.addTableModelListener(this);

    }

    // new code
    public TableModel getTableModel() {
        return tableModel;
    }

    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
        int firstIndex = selectModel.getMinSelectionIndex();
        // read the data in each column using getValueAt and display it on
        // corresponding textfield
        
        gui.setmediaIDTextField((String) tableModel.getValueAt(firstIndex, 0));
        gui.setmediaProjectIDTextField((String) tableModel.getValueAt(firstIndex,
                1));
        gui.setmediaTypeTextField((String) tableModel.getValueAt(
                firstIndex, 2));
        gui.setmediaNameTextField((String) tableModel.getValueAt(firstIndex,
                3));
        gui.setmediaDescTextField((String) tableModel.getValueAt(firstIndex, 4));
        gui.setmediaFileTextField((String) tableModel.getValueAt(firstIndex, 5));
    }

    public void cursorMoved(RowSetEvent event) {

    }

    public void rowSetChanged(RowSetEvent event) {

    }

    public void tableChanged(TableModelEvent event) {
        try {
            // get the index of the inserted row
            // tableModel.getRowSet().moveToCurrentRow();
            int firstIndex = event.getFirstRow();

            // create a new table model with the new data
            tableModel = new MediaListTableModel(tableModel.getList(),
                    tableModel.getEntityManager());
            tableModel.addTableModelListener(this);
            // update the JTable with the data
            gui.updateTable();

            // read the data in each column using getValueAt and display it on
            // corresponding textfield
            gui.setmediaIDTextField((String) tableModel.getValueAt(firstIndex, 0));
            gui.setmediaProjectIDTextField(tableModel.mediaProjectID);
            gui.setmediaTypeTextField((String) tableModel.getValueAt(
                    firstIndex, 2));
            gui.setmediaNameTextField((String) tableModel.getValueAt(firstIndex,
                    3));
            gui.setmediaDescTextField((String) tableModel.getValueAt(firstIndex, 4));
            gui.setmediaFileTextField((String) tableModel.getValueAt(firstIndex, 5));
        } catch (Exception exp) {
            exp.getMessage();
            exp.printStackTrace();
        }
    }

    public void addRow(String[] array) {
        tableModel.addRow(array);
    }
    
    public void updateRow(String[] array, int row) {
        tableModel.updateRow(array, row);
    }

    public void deleteRow(String[] array, int row) {

        tableModel.deleteRow(array, row);
    }

    public void mediaRecords(int projectId){

        tableModel.mediaRecords(projectId);
        //gui.updateTable();
    }
    
}
