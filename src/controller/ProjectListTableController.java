package controller;

//import cards.ProjectListGUI;
import gui.ProjectListGUI;
import tablemodel.ProjectListTableModel;
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
public class ProjectListTableController implements ListSelectionListener,
		TableModelListener {

	private ProjectListTableModel tableModel;
	private ProjectListGUI gui;

	public ProjectListTableController(ProjectListGUI gui) {
		this.gui = gui;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new ProjectListTableModel();
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
		gui.setprojectIDTextField((String) tableModel.getValueAt(firstIndex, 0));
		gui.setprojectTitleTextField((String) tableModel.getValueAt(firstIndex,
				1));
		gui.setprojectStatusTextField((String) tableModel.getValueAt(
				firstIndex, 2));
		gui.setlastUpdatedTextField((String) tableModel.getValueAt(firstIndex,
				3));
		gui.setstartDateTextField((String) tableModel.getValueAt(firstIndex, 4));
		gui.setendDateTextField((String) tableModel.getValueAt(firstIndex, 5));
		gui.setprojectDescTextField((String) tableModel.getValueAt(firstIndex,
				6));
		gui.setprojectCommentsTextField((String) tableModel.getValueAt(
				firstIndex, 7));
		gui.setdisciplinesTextField((String) tableModel.getValueAt(firstIndex,
				8));
		gui.setthemesTextField((String) tableModel.getValueAt(firstIndex, 9));
		gui.setprototypeLocationTextField((String) tableModel.getValueAt(
				firstIndex, 10));
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
			tableModel = new ProjectListTableModel(tableModel.getList(),
					tableModel.getEntityManager());
			tableModel.addTableModelListener(this);
			// update the JTable with the data
			gui.updateTable();

			// read the data in each column using getValueAt and display it on
			// corresponding textfield
			gui.setprojectIDTextField((String) tableModel.getValueAt(
					firstIndex, 0));
			gui.setprojectTitleTextField((String) tableModel.getValueAt(
					firstIndex, 1));

			gui.setprojectStatusTextField((String) tableModel.getValueAt(
					firstIndex, 2));
			gui.setlastUpdatedTextField((String) tableModel.getValueAt(
					firstIndex, 3));
			gui.setstartDateTextField((String) tableModel.getValueAt(
					firstIndex, 4));
			gui.setendDateTextField((String) tableModel.getValueAt(firstIndex,
					5));
			gui.setprojectDescTextField((String) tableModel.getValueAt(
					firstIndex, 6));
			gui.setprojectCommentsTextField((String) tableModel.getValueAt(
					firstIndex, 7));
			gui.setdisciplinesTextField((String) tableModel.getValueAt(
					firstIndex, 8));
			gui.setthemesTextField((String) tableModel
					.getValueAt(firstIndex, 9));
			gui.setprototypeLocationTextField((String) tableModel.getValueAt(
					firstIndex, 10));
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

}
