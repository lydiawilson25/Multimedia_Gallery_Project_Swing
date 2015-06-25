package controller;

//import cards.ProjectListGUI;
import gui.ProjectListGUI;
import tablemodel.MemberListTableModel;
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
public class MemberListTableController implements ListSelectionListener,
        TableModelListener {

    private MemberListTableModel tableModel;
    private ProjectListGUI gui;

    public MemberListTableController(ProjectListGUI gui) {
        this.gui = gui;
        // create the tableModel using the data in the cachedRowSet
        tableModel = new MemberListTableModel();
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
        gui.setmemberIDTextField((String) tableModel.getValueAt(firstIndex, 0));
        gui.setmemberProjectIDTextField((String) tableModel.getValueAt(firstIndex,
                1));
        gui.setmemberNameTextField((String) tableModel.getValueAt(
                firstIndex, 2));
        gui.setmemberRoleTextField((String) tableModel.getValueAt(firstIndex,
                3));
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
            tableModel = new MemberListTableModel(tableModel.getList(),
                    tableModel.getEntityManager());
            tableModel.addTableModelListener(this);
            // update the JTable with the data
            gui.updateTable();

            // read the data in each column using getValueAt and display it on
            // corresponding textfield
            gui.setmemberIDTextField((String) tableModel.getValueAt(firstIndex, 0));
            gui.setmemberProjectIDTextField(tableModel.memberProjectID);
            gui.setmemberNameTextField((String) tableModel.getValueAt(
                    firstIndex, 2));
            gui.setmemberRoleTextField((String) tableModel.getValueAt(firstIndex,
                    3));
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

    public void memberRecords(int projectId) {
        tableModel.memberRecords(projectId);
        //gui.updateTable();
    }

}
