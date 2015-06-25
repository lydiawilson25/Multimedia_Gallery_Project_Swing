package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import queryFiles.Controller;
import queryFiles.ProjectDetails;
import controller.LoginListTableController;
import controller.MediaListTableController;
import controller.MemberListTableController;
import controller.ProjectListTableController;
import java.io.File;

/**
 *
 * @author Lydia
 */
public class ProjectListGUI extends javax.swing.JFrame {

    private ProjectListTableController projectListTableController;
    private MediaListTableController mediaListTableController;
    private LoginListTableController loginListTableController;
    private MemberListTableController memberListTableController;
    private JTable projectListTable;
    private JTable mediaListTable;
    private JTable memberListTable;

    /**
     * Creates new form ProjectListGUI
     */
    public ProjectListGUI() {

        projectListTableController = new ProjectListTableController(this);
        mediaListTableController = new MediaListTableController(this);
        loginListTableController = new LoginListTableController(this);
        memberListTableController = new MemberListTableController(this);
        projectListTable = new JTable(projectListTableController.getTableModel());
        projectListTable.getSelectionModel().addListSelectionListener(projectListTableController);
        mediaListTable = new JTable(mediaListTableController.getTableModel());
        mediaListTable.getSelectionModel().addListSelectionListener(mediaListTableController);
        memberListTable = new JTable(memberListTableController.getTableModel());
        memberListTable.getSelectionModel().addListSelectionListener(memberListTableController);
        initComponents();
        addJTable();

    }

    public void addJTable() {
        // create a window
        projectPanel.setLayout(new BorderLayout());
        mediaPanel.setLayout(new BorderLayout());
        memberPanel.setLayout(new BorderLayout());
    }

    public void updateTable() {
        projectListTable.setModel(projectListTableController.getTableModel());
        mediaListTable.setModel(mediaListTableController.getTableModel());
        memberListTable.setModel(memberListTableController.getTableModel());
    }

    // display data on the projectTitleTextField
    public void setprojectTitleTextField(String value) {
        projectTitleTextField.setText(value);
    }

    // display data on the projectIDTextField
    public void setprojectIDTextField(String value) {
        projectIDTextField.setText(value);
    }

    // display data on the projectStatusTextField
    public void setprojectStatusTextField(String value) {
        projectStatusTextField.setText(value);
    }

    // display data on the lastUpdatedTextField
    public void setlastUpdatedTextField(String value) {
        lastUpdatedTextField.setText(value);
    }

    // display data on the startDateTextField
    public void setstartDateTextField(String value) {
        startDateTextField.setText(value);
    }

    // display data on the endDateTextField
    public void setendDateTextField(String value) {
        endDateTextField.setText(value);
    }

    public void setprojectDescTextField(String value) {
        projectDescTextField.setText(value);
    }

    public void setprojectCommentsTextField(String value) {
        projectCommentsTextField.setText(value);
    }

    public void setdisciplinesTextField(String value) {
        disciplinesTextField.setText(value);
    }

    public void setthemesTextField(String value) {
        themesTextField.setText(value);
    }

    public void setprototypeLocationTextField(String value) {
        prototypeLocationTextField.setText(value);
    }

    public void setmediaIDTextField(String value) {
        mediaIDTextField.setText(value);
    }

    public void setmediaProjectIDTextField(String value) {
        mediaProjectIDTextField.setText(value);
    }
    
    public String getmediaProjectIDTextField() {
        return this.mediaProjectIDTextField.getText();
    }

    public void setmediaTypeTextField(String value) {
        mediaTypeTextField.setText(value);
    }

    public void setmediaNameTextField(String value) {
        mediaNameTextField.setText(value);
    }

    public void setmediaDescTextField(String value) {
        mediaDescTextField.setText(value);
    }

    public void setmediaFileTextField(String value) {
        mediaFileTextField.setText(value);
    }

    public void setmemberIDTextField(String value) {
        memberIDTextField.setText(value);
    }

    public void setmemberNameTextField(String value) {
        memberNameTextField.setText(value);
    }

    public void setmemberRoleTextField(String value) {
        memberRoleTextField.setText(value);
    }

    public void setmemberProjectIDTextField(String value) {
        memberProjectIDTextField.setText(value);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewerTabbedPanel = new javax.swing.JTabbedPane();
        queryTab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        queryTab1 = new javax.swing.JPanel();
        statusQueryLabel = new javax.swing.JLabel();
        themeCategoryQueryLabel = new javax.swing.JLabel();
        membersQueryLabel = new javax.swing.JLabel();
        descriptionOutcomesQueryLabel = new javax.swing.JLabel();
        mediaComboBox = new javax.swing.JComboBox();
        queryButton = new javax.swing.JButton();
        statusQueryTextField = new javax.swing.JTextField();
        themeCategoryQueryTextField = new javax.swing.JTextField();
        membersQueryTextField = new javax.swing.JTextField();
        descriptionOutcomesQueryTextField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        projectNameTable = new javax.swing.JTable();
        projectTitleQueryTextField = new javax.swing.JTextField();
        projectTitleQueryLabel = new javax.swing.JLabel();
        startDateQueryLabel = new javax.swing.JLabel();
        endDateQueryLabel = new javax.swing.JLabel();
        year_start_date = new javax.swing.JComboBox();
        year_end_date = new javax.swing.JComboBox();
        month_start_date = new javax.swing.JComboBox();
        month_end_date = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        projectTitleTextField1 = new javax.swing.JTextField();
        projectLastUpdatedTextField = new javax.swing.JTextField();
        projectStartDateTextField = new javax.swing.JTextField();
        projectTitleLabel1 = new javax.swing.JLabel();
        projectLastUpdatedLabel = new javax.swing.JLabel();
        projectStartDateLabel = new javax.swing.JLabel();
        projectEndDateLabel = new javax.swing.JLabel();
        projectEndDateTextField = new javax.swing.JTextField();
        prototypeLocationLabel1 = new javax.swing.JLabel();
        prototypeLocationTextField1 = new javax.swing.JTextField();
        disciplinesInvolvedLabel = new javax.swing.JLabel();
        projectDescriptionLabel = new javax.swing.JLabel();
        disciplinesInvolvedTextField = new javax.swing.JTextField();
        projectDescriptionTextField = new javax.swing.JTextField();
        projectCommentsLabel1 = new javax.swing.JLabel();
        projectCommentsTextField1 = new javax.swing.JTextField();
        projectThemeLabel = new javax.swing.JLabel();
        projectThemeTextField = new javax.swing.JTextField();
        projectStatusLabel1 = new javax.swing.JLabel();
        projectStatusTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        projectMembersTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        projectMediaTable = new javax.swing.JTable();
        adminTabbedPanel = new javax.swing.JTabbedPane();
        loginPanel = new javax.swing.JPanel();
        userNameLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        passwordLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        loginErrorLabel = new javax.swing.JLabel();
        projectPanel = new javax.swing.JPanel(false);
        projectTitleTextField = new javax.swing.JTextField();
        projectTitleLabel = new javax.swing.JLabel();
        projectIDLabel = new javax.swing.JLabel();
        projectAddButton = new javax.swing.JButton();
        projectClearButton = new javax.swing.JButton();
        projectDeleteButton = new javax.swing.JButton();
        projectStatusTextField = new javax.swing.JTextField();
        lastUpdatedTextField = new javax.swing.JTextField();
        startDateTextField = new javax.swing.JTextField();
        endDateTextField = new javax.swing.JTextField();
        projectStatusLabel = new javax.swing.JLabel();
        lastUpdatedLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        projectDescTextField = new javax.swing.JTextField();
        projectCommentsTextField = new javax.swing.JTextField();
        disciplinesTextField = new javax.swing.JTextField();
        projectDescLabel = new javax.swing.JLabel();
        projectCommentsLabel = new javax.swing.JLabel();
        discipilinesLabel = new javax.swing.JLabel();
        prototypeLocationTextField = new javax.swing.JTextField();
        prototypeLocationLabel = new javax.swing.JLabel();
        themesTextField = new javax.swing.JTextField();
        themesLabel = new javax.swing.JLabel();
        projectIDTextField = new javax.swing.JTextField();
        projectResultsPane = new javax.swing.JScrollPane(projectListTable);
        projectUpdateButton = new javax.swing.JButton();
        mediaPanel = new javax.swing.JPanel();
        mediaTypeTextField = new javax.swing.JTextField();
        mediaTypeLabel = new javax.swing.JLabel();
        mediaIDLabel = new javax.swing.JLabel();
        mediaAddButton = new javax.swing.JButton();
        mediaClearButton = new javax.swing.JButton();
        mediaDeleteButton = new javax.swing.JButton();
        mediaDescTextField = new javax.swing.JTextField();
        mediaDescLabel = new javax.swing.JLabel();
        mediaProjectIDTextField = new javax.swing.JTextField();
        mediaNameTextField = new javax.swing.JTextField();
        mediaProjectIDLabel = new javax.swing.JLabel();
        mediaNameLabel = new javax.swing.JLabel();
        mediaFileLabel = new javax.swing.JLabel();
        mediaIDTextField = new javax.swing.JTextField();
        mediaResultsPane = new javax.swing.JScrollPane(mediaListTable);
        jFileChooser2 = new javax.swing.JFileChooser();
        mediaUpdateButton = new javax.swing.JButton();
        mediaFileTextField = new javax.swing.JTextField();
        memberPanel = new javax.swing.JPanel();
        memberNameTextField = new javax.swing.JTextField();
        memberNameLabel = new javax.swing.JLabel();
        memberIDLabel = new javax.swing.JLabel();
        memberAddButton = new javax.swing.JButton();
        memberClearButton = new javax.swing.JButton();
        memberDeleteButton = new javax.swing.JButton();
        memberProjectIDTextField = new javax.swing.JTextField();
        memberRoleTextField = new javax.swing.JTextField();
        memberProjectIDLabel = new javax.swing.JLabel();
        MemberRoleLabel = new javax.swing.JLabel();
        memberIDTextField = new javax.swing.JTextField();
        memberUpdateButton = new javax.swing.JButton();
        memberResultsPane = new javax.swing.JScrollPane(memberListTable);
        headerPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel(new ImageIcon("Frugal_Blk_BriteRed_72dpi.jpg"));
        logoLabel1 = new javax.swing.JLabel(new ImageIcon("scu-logo.png"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projects Modification Screen");

        viewerTabbedPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        viewerTabbedPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        statusQueryLabel.setText("Current Status:");

        themeCategoryQueryLabel.setText("Theme/Category:");

        membersQueryLabel.setText("Members:");

        descriptionOutcomesQueryLabel.setText("Description/Outcomes:");

        mediaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { 
        		"No Filter", "Adobe Files", "Associated Hyperlinks", "CAD Documents", "Code", "Direct Hyperlink", "Map",
        		"PDF", "Photos", "Plain Text", "Powerpoint", "SpreadSheet", "Video", "Word Documents"
        		}));
    	

        queryButton.setText("Query");

        projectNameTable.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	            },
	            new String [] {
	                "Project Titles"
	            }
	        ));
        jScrollPane4.setViewportView(projectNameTable);

        projectTitleQueryLabel.setText("Project Title:");

        startDateQueryLabel.setText("Start Date:");

        endDateQueryLabel.setText("End Date:");

        year_start_date.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Filter", "2008", "2009", "2010", "2011", "2012", "2013", "2014" }));

        year_end_date.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Filter", "2008", "2009", "2010", "2011", "2012", "2013", "2014" }));

        month_start_date.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Filter", "January", "February", "March", "April",
        		"May", "June", "July", "August", "September", "October", "November", "December"}));

        month_end_date.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Filter", "January", "February", "March", "April",
        		"May", "June", "July", "August", "September", "October", "November", "December"}));

        javax.swing.GroupLayout queryTab1Layout = new javax.swing.GroupLayout(queryTab1);
        queryTab1.setLayout(queryTab1Layout);
        queryTab1Layout.setHorizontalGroup(
            queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(queryTab1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(queryTab1Layout.createSequentialGroup()
                            .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(mediaComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(projectTitleQueryLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(statusQueryLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(startDateQueryLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(endDateQueryLabel, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(30, 30, 30)
                            .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(projectTitleQueryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(statusQueryTextField))
                                .addGroup(queryTab1Layout.createSequentialGroup()
                                    .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(year_end_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(year_start_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(month_start_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(month_end_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, queryTab1Layout.createSequentialGroup()
                            .addComponent(membersQueryLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(membersQueryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, queryTab1Layout.createSequentialGroup()
                            .addComponent(themeCategoryQueryLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(themeCategoryQueryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, queryTab1Layout.createSequentialGroup()
                            .addComponent(descriptionOutcomesQueryLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                            .addComponent(descriptionOutcomesQueryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(queryButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );
        queryTab1Layout.setVerticalGroup(
            queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, queryTab1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(queryTab1Layout.createSequentialGroup()
                        .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(projectTitleQueryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projectTitleQueryLabel))
                        .addGap(18, 18, 18)
                        .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusQueryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusQueryLabel))
                        .addGap(18, 18, 18)
                        .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startDateQueryLabel)
                            .addComponent(year_start_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(month_start_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endDateQueryLabel)
                            .addComponent(year_end_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(month_end_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(themeCategoryQueryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(themeCategoryQueryLabel))
                        .addGap(18, 18, 18)
                        .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(membersQueryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(membersQueryLabel))
                        .addGap(18, 18, 18)
                        .addGroup(queryTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descriptionOutcomesQueryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptionOutcomesQueryLabel))
                        .addGap(18, 18, 18)
                        .addComponent(mediaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(queryButton))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(queryTab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(queryTab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        queryTab.addTab("Query", jPanel1);

        projectTitleTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectTitleTextField1ActionPerformed(evt);
            }
        });

//        projectStartDateTextField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                projectStartDateTextFieldActionPerformed(evt);
//            }
//        });

        projectTitleLabel1.setText("Project Title:");

        projectLastUpdatedLabel.setText("Project Last Updated:");

        projectStartDateLabel.setText("Project Start Date:");

        projectEndDateLabel.setText("Project End Date:");

        prototypeLocationLabel1.setText("Prototype Location:");

        disciplinesInvolvedLabel.setText("Discplines Involved:");

        projectDescriptionLabel.setText("Project Description:");

        projectCommentsLabel1.setText("Project Comments:");

        projectThemeLabel.setText("Project Theme:");

        projectStatusLabel1.setText("Project Status:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(projectStatusLabel1)
                        .addGap(70, 70, 70)
                        .addComponent(projectStatusTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(projectThemeLabel)
                        .addGap(69, 69, 69)
                        .addComponent(projectThemeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(projectStartDateLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(projectStartDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(projectLastUpdatedLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                            .addComponent(projectLastUpdatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(projectTitleLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(projectTitleTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(projectEndDateLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(projectEndDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(disciplinesInvolvedLabel)
                    .addComponent(projectDescriptionLabel)
                    .addComponent(projectCommentsLabel1)
                    .addComponent(prototypeLocationLabel1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(projectCommentsTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(projectDescriptionTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(prototypeLocationTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disciplinesInvolvedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectTitleLabel1)
                    .addComponent(projectTitleTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prototypeLocationLabel1)
                    .addComponent(prototypeLocationTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(projectLastUpdatedLabel)
                            .addComponent(projectLastUpdatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(disciplinesInvolvedLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(projectStartDateLabel)
                            .addComponent(projectStartDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(projectEndDateLabel)
                            .addComponent(projectEndDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(projectThemeLabel)
                            .addComponent(projectThemeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(projectStatusLabel1)
                            .addComponent(projectStatusTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(disciplinesInvolvedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(projectDescriptionLabel)
                            .addComponent(projectDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(projectCommentsTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projectCommentsLabel1))))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        queryTab.addTab("Project Information", jPanel2);

        projectMembersTable.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                
	            },
	            new String [] {
	                "Member Name", "Member Role"
	            }
	        ));
        jScrollPane3.setViewportView(projectMembersTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(59, Short.MAX_VALUE)))
        );

        queryTab.addTab("Member Details", jPanel3);

        projectMediaTable.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	            },
	            new String [] {
	                "Media Type", "Media Name", "Description", "Media File"
	            }
	        ));
	 
        jScrollPane5.setViewportView(projectMediaTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(59, Short.MAX_VALUE)))
        );

        queryTab.addTab("Media Details", jPanel4);

        viewerTabbedPanel.addTab("Query Centrale", queryTab);

        adminTabbedPanel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                adminTabbedPanelStateChanged(evt);
            }
        });
        adminTabbedPanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminTabbedPanelFocusGained(evt);
            }
        });

        loginPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        userNameLabel.setText("UserName");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        passwordLabel.setText("Password");

        userNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTextFieldActionPerformed(evt);
            }
        });

        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });

        loginErrorLabel.setText(" ");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(userNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addComponent(passwordLabel)
                        .addGap(18, 18, 18)
                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loginErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(loginErrorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameLabel)
                    .addComponent(passwordLabel)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(loginButton)
                .addContainerGap(317, Short.MAX_VALUE))
        );

        userNameLabel.getAccessibleContext().setAccessibleDescription("");

        adminTabbedPanel.addTab("Login", loginPanel);

        projectPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        projectPanel.setPreferredSize(new java.awt.Dimension(722, 172));

        projectTitleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectTitleTextFieldActionPerformed(evt);
            }
        });

        projectTitleLabel.setText("Project Title");

        projectIDLabel.setText("Project ID");

        projectAddButton.setText("Add");
        projectAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectAddButtonActionPerformed(evt);
            }
        });

        projectClearButton.setText("Clear");
        projectClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectClearButtonActionPerformed(evt);
            }
        });

        projectDeleteButton.setText("Delete");
        projectDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectDeleteButtonActionPerformed(evt);
            }
        });

        projectStatusTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectStatusTextFieldActionPerformed(evt);
            }
        });

        lastUpdatedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastUpdatedTextFieldActionPerformed(evt);
            }
        });

        startDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateTextFieldActionPerformed(evt);
            }
        });

        endDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateTextFieldActionPerformed(evt);
            }
        });

        projectStatusLabel.setText("Status");

        lastUpdatedLabel.setText("Last updated");

        startDateLabel.setText("Start date");

        endDateLabel.setText("End date");

        projectDescTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectDescTextFieldActionPerformed(evt);
            }
        });

        projectCommentsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectCommentsTextFieldActionPerformed(evt);
            }
        });

        disciplinesTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disciplinesTextFieldActionPerformed(evt);
            }
        });

        projectDescLabel.setText("Description");

        projectCommentsLabel.setText("Comments");

        discipilinesLabel.setText("Disciplines");

        prototypeLocationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prototypeLocationTextFieldActionPerformed(evt);
            }
        });

        prototypeLocationLabel.setText("Prototype Location");

        themesTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themesTextFieldActionPerformed(evt);
            }
        });

        themesLabel.setText("Themes");

        projectIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectIDTextFieldActionPerformed(evt);
            }
        });

        projectUpdateButton.setText("Update");
        projectUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectUpdateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout projectPanelLayout = new javax.swing.GroupLayout(projectPanel);
        projectPanel.setLayout(projectPanelLayout);
        projectPanelLayout.setHorizontalGroup(
            projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectPanelLayout.createSequentialGroup()
                .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(projectPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(projectResultsPane))
                    .addGroup(projectPanelLayout.createSequentialGroup()
                        .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(projectPanelLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(projectStatusLabel)
                                    .addComponent(lastUpdatedLabel)
                                    .addComponent(startDateLabel)
                                    .addComponent(endDateLabel)
                                    .addComponent(projectTitleLabel)
                                    .addComponent(projectIDLabel))
                                .addGap(18, 18, 18)
                                .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(projectTitleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(projectStatusTextField)
                                    .addComponent(lastUpdatedTextField)
                                    .addComponent(startDateTextField)
                                    .addComponent(endDateTextField)
                                    .addComponent(projectIDTextField)))
                            .addGroup(projectPanelLayout.createSequentialGroup()
                                .addContainerGap(145, Short.MAX_VALUE)
                                .addComponent(projectAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(projectUpdateButton)
                                .addGap(49, 49, 49)))
                        .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(projectPanelLayout.createSequentialGroup()
                                .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(projectDescLabel)
                                    .addComponent(discipilinesLabel)
                                    .addComponent(projectCommentsLabel)
                                    .addComponent(prototypeLocationLabel)
                                    .addComponent(themesLabel))
                                .addGap(33, 33, 33)
                                .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(projectCommentsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(disciplinesTextField)
                                    .addComponent(prototypeLocationTextField)
                                    .addComponent(projectDescTextField)
                                    .addComponent(themesTextField))
                                .addGap(0, 34, Short.MAX_VALUE))
                            .addGroup(projectPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(projectDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(projectClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        projectPanelLayout.setVerticalGroup(
            projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectDescTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectDescLabel)
                    .addComponent(projectIDLabel)
                    .addComponent(projectIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectCommentsLabel)
                    .addComponent(projectCommentsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectTitleLabel)
                    .addComponent(projectTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(discipilinesLabel)
                    .addComponent(disciplinesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(projectPanelLayout.createSequentialGroup()
                        .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(projectStatusLabel)
                            .addComponent(projectStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastUpdatedLabel)
                            .addComponent(lastUpdatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(themesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(themesLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startDateLabel)
                            .addComponent(startDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prototypeLocationLabel)
                            .addComponent(prototypeLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endDateLabel)
                            .addComponent(endDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(projectAddButton)
                            .addComponent(projectClearButton)
                            .addComponent(projectDeleteButton)
                            .addComponent(projectUpdateButton))))
                .addGap(11, 11, 11)
                .addComponent(projectResultsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        adminTabbedPanel.addTab("Project", projectPanel);

        mediaPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        mediaTypeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediaTypeTextFieldActionPerformed(evt);
            }
        });

        mediaTypeLabel.setText("Media Type");

        mediaIDLabel.setText("Media ID");

        mediaAddButton.setText("Add");
        mediaAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediaAddButtonActionPerformed(evt);
            }
        });

        mediaClearButton.setText("Clear");
        mediaClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediaClearButtonActionPerformed(evt);
            }
        });

        mediaDeleteButton.setText("Delete");
        mediaDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediaDeleteButtonActionPerformed(evt);
            }
        });

        mediaDescTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediaDescTextFieldActionPerformed(evt);
            }
        });

        mediaDescLabel.setText("Description");

        mediaProjectIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediaProjectIDTextFieldActionPerformed(evt);
            }
        });

        mediaNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediaNameTextFieldActionPerformed(evt);
            }
        });

        mediaProjectIDLabel.setText("Project ID");

        mediaNameLabel.setText("Media Name");

        mediaFileLabel.setText("Attach Media File ");

        mediaIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediaIDTextFieldActionPerformed(evt);
            }
        });

        mediaUpdateButton.setText("Update");
        mediaUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediaUpdateButtonActionPerformed(evt);
            }
        });

        mediaFileTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mediaFileTextFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mediaFileTextFieldMouseEntered(evt);
            }
        });
        mediaFileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediaFileTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mediaPanelLayout = new javax.swing.GroupLayout(mediaPanel);
        mediaPanel.setLayout(mediaPanelLayout);
        mediaPanelLayout.setHorizontalGroup(
            mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mediaPanelLayout.createSequentialGroup()
                .addGroup(mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mediaPanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mediaDescLabel)
                            .addComponent(mediaTypeLabel)
                            .addComponent(mediaIDLabel))
                        .addGap(18, 18, 18)
                        .addGroup(mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(mediaTypeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addComponent(mediaDescTextField)
                                .addComponent(mediaIDTextField))
                            .addComponent(mediaAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mediaPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mediaFileLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mediaPanelLayout.createSequentialGroup()
                                        .addComponent(mediaProjectIDLabel)
                                        .addGap(8, 8, 8))
                                    .addComponent(mediaNameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(23, 23, 23))
                            .addGroup(mediaPanelLayout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(mediaUpdateButton)
                                .addGap(65, 65, 65)
                                .addComponent(mediaDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)))
                        .addGroup(mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mediaClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mediaNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mediaProjectIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mediaFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mediaPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mediaResultsPane)))
                .addContainerGap())
        );
        mediaPanelLayout.setVerticalGroup(
            mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mediaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mediaProjectIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mediaProjectIDLabel)
                    .addComponent(mediaIDLabel)
                    .addComponent(mediaIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mediaNameLabel)
                    .addComponent(mediaNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mediaTypeLabel)
                    .addComponent(mediaTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mediaDescLabel)
                        .addComponent(mediaDescTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mediaFileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mediaFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(mediaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(mediaAddButton)
                    .addComponent(mediaClearButton)
                    .addComponent(mediaDeleteButton)
                    .addComponent(mediaUpdateButton))
                .addGap(18, 18, 18)
                .addComponent(mediaResultsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addGap(100, 100, 100))
        );

        adminTabbedPanel.addTab("Media", mediaPanel);

        memberPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        memberNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberNameTextFieldActionPerformed(evt);
            }
        });

        memberNameLabel.setText("Member Name");

        memberIDLabel.setText("Member ID");

        memberAddButton.setText("Add");
        memberAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberAddButtonActionPerformed(evt);
            }
        });

        memberClearButton.setText("Clear");
        memberClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberClearButtonActionPerformed(evt);
            }
        });

        memberDeleteButton.setText("Delete");
        memberDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberDeleteButtonActionPerformed(evt);
            }
        });

        memberProjectIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberProjectIDTextFieldActionPerformed(evt);
            }
        });

        memberRoleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberRoleTextFieldActionPerformed(evt);
            }
        });

        memberProjectIDLabel.setText("Project ID");

        MemberRoleLabel.setText("Member Role");

        memberIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberIDTextFieldActionPerformed(evt);
            }
        });

        memberUpdateButton.setText("Update");
        memberUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberUpdateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout memberPanelLayout = new javax.swing.GroupLayout(memberPanel);
        memberPanel.setLayout(memberPanelLayout);
        memberPanelLayout.setHorizontalGroup(
            memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memberPanelLayout.createSequentialGroup()
                .addGroup(memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memberPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(memberNameLabel)
                            .addComponent(memberIDLabel))
                        .addGap(18, 18, 18)
                        .addGroup(memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(memberNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(memberIDTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addGroup(memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(memberProjectIDLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MemberRoleLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(memberPanelLayout.createSequentialGroup()
                        .addContainerGap(140, Short.MAX_VALUE)
                        .addComponent(memberAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(memberUpdateButton)
                        .addGap(56, 56, 56)
                        .addComponent(memberDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memberPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(memberRoleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(memberProjectIDTextField)))
                    .addGroup(memberPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(memberClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(memberPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(memberResultsPane)
                .addContainerGap())
        );
        memberPanelLayout.setVerticalGroup(
            memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memberPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberProjectIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memberProjectIDLabel)
                    .addComponent(memberIDLabel)
                    .addComponent(memberIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MemberRoleLabel)
                    .addComponent(memberRoleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memberNameLabel)
                    .addComponent(memberNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(memberAddButton)
                    .addComponent(memberClearButton)
                    .addComponent(memberDeleteButton)
                    .addComponent(memberUpdateButton))
                .addGap(18, 18, 18)
                .addComponent(memberResultsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        adminTabbedPanel.addTab("Member", memberPanel);

        viewerTabbedPanel.addTab("Admin Centrale", adminTabbedPanel);
        adminTabbedPanel.setEnabledAt(1, false);
        adminTabbedPanel.setEnabledAt(2, false);
        adminTabbedPanel.setEnabledAt(3, false);

        headerPanel.setBackground(new java.awt.Color(204, 0, 51));

        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        logoLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(logoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(385, Short.MAX_VALUE)))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(logoLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewerTabbedPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewerTabbedPanel)
                .addGap(2, 2, 2))
        );
        //////////
        controller = new Controller();
        listSelectionModel = projectNameTable.getSelectionModel();
   		listSelectionModel.addListSelectionListener(new MyListSelectionListener());
   		projectNameTable.setSelectionModel(listSelectionModel);
   		
   		queryButton.addActionListener(new ActionListener(){
   			public void actionPerformed(ActionEvent e){
   				String project_title = projectTitleQueryTextField.getText();
   				String current_status = statusQueryTextField.getText();
   				
   				String year_start_date_value = (String) year_start_date.getSelectedItem();
   				String month_start_date_value = (String) month_start_date.getSelectedItem();
   				
   				String year_end_date_value = (String) year_end_date.getSelectedItem();
   				String month_end_date_value = (String) month_end_date.getSelectedItem();
   				
   				String theme = themeCategoryQueryTextField.getText();
   				String members = membersQueryTextField.getText();
   				String description = descriptionOutcomesQueryTextField.getText();
   				String media_type = (String) mediaComboBox.getSelectedItem();

   				controller.queryProject(project_title, current_status, 
   						year_start_date_value, month_start_date_value, year_end_date_value, month_end_date_value,
   						theme, members, description, media_type);
   				
   				updateProjectNameTable();
   			}
   		});
   		/////////
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void memberIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberIDTextFieldActionPerformed

    private void memberRoleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberRoleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberRoleTextFieldActionPerformed

    private void memberProjectIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberProjectIDTextFieldActionPerformed
       
    }//GEN-LAST:event_memberProjectIDTextFieldActionPerformed

    private void memberDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberDeleteButtonActionPerformed
        int rowId = memberListTable.getSelectedRow();

        String[] array = new String[memberListTable.getColumnCount()];
        array[0] = memberIDTextField.getText();
        array[1] = memberProjectIDTextField.getText();
        array[2] = memberNameTextField.getText();
        array[3] = memberRoleTextField.getText();
        memberListTableController.deleteRow(array, rowId);
    }//GEN-LAST:event_memberDeleteButtonActionPerformed

    private void memberClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberClearButtonActionPerformed
        memberIDTextField.setText(null);
        memberProjectIDTextField.setText(null);
        memberNameTextField.setText(null);
        memberRoleTextField.setText(null);
    }//GEN-LAST:event_memberClearButtonActionPerformed

    private void memberAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberAddButtonActionPerformed
        String[] array = new String[memberListTable.getColumnCount()];

        array[0] = memberIDTextField.getText();
        array[1] = memberProjectIDTextField.getText();
        array[2] = memberNameTextField.getText();
        array[3] = memberRoleTextField.getText();

        memberListTableController.addRow(array);
    }//GEN-LAST:event_memberAddButtonActionPerformed

    private void memberNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberNameTextFieldActionPerformed

    private void mediaIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediaIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mediaIDTextFieldActionPerformed

    private void mediaNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediaNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mediaNameTextFieldActionPerformed

    private void mediaProjectIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediaProjectIDTextFieldActionPerformed
        
    }//GEN-LAST:event_mediaProjectIDTextFieldActionPerformed

    private void mediaDescTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediaDescTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mediaDescTextFieldActionPerformed

    private void mediaDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediaDeleteButtonActionPerformed
        int rowId = mediaListTable.getSelectedRow();

        String[] array = new String[mediaListTable.getColumnCount()];

        array[0] = mediaIDTextField.getText();
        array[1] = mediaProjectIDTextField.getText();
        array[2] = mediaTypeTextField.getText();
        array[3] = mediaNameTextField.getText();
        array[4] = mediaDescTextField.getText();
        array[5] = mediaFileTextField.getText();//null;
        mediaListTableController.deleteRow(array, rowId);
    }//GEN-LAST:event_mediaDeleteButtonActionPerformed

    private void mediaClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediaClearButtonActionPerformed
        mediaIDTextField.setText(null);
        mediaProjectIDTextField.setText(null);
        mediaTypeTextField.setText(null);
        mediaNameTextField.setText(null);
        mediaDescTextField.setText(null);
        mediaFileTextField.setText(null);

    }//GEN-LAST:event_mediaClearButtonActionPerformed

    private void mediaAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediaAddButtonActionPerformed
        String[] array = new String[mediaListTable.getColumnCount()];

        array[0] = mediaIDTextField.getText();
        array[1] = mediaProjectIDTextField.getText();
        array[2] = mediaTypeTextField.getText();
        array[3] = mediaNameTextField.getText();
        array[4] = mediaDescTextField.getText();
        array[5] = mediaFileTextField.getText();

        mediaListTableController.addRow(array);
    }//GEN-LAST:event_mediaAddButtonActionPerformed

    private void mediaTypeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediaTypeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mediaTypeTextFieldActionPerformed

    private void projectIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectIDTextFieldActionPerformed

    private void themesTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themesTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_themesTextFieldActionPerformed

    private void prototypeLocationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prototypeLocationTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prototypeLocationTextFieldActionPerformed

    private void disciplinesTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disciplinesTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disciplinesTextFieldActionPerformed

    private void projectCommentsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectCommentsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectCommentsTextFieldActionPerformed

    private void projectDescTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectDescTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectDescTextFieldActionPerformed

    private void endDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateTextFieldActionPerformed

    private void startDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateTextFieldActionPerformed

    private void lastUpdatedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastUpdatedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastUpdatedTextFieldActionPerformed

    private void projectStatusTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectStatusTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectStatusTextFieldActionPerformed

    private void projectDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectDeleteButtonActionPerformed
        // TODO add your handling code here:
        int rowId = projectListTable.getSelectedRow();

        String[] array = new String[projectListTable.getColumnCount()];
        array[1] = projectTitleTextField.getText();
        array[0] = projectIDTextField.getText();
        array[2] = projectStatusTextField.getText();
        array[3] = lastUpdatedTextField.getText();
        array[4] = startDateTextField.getText();
        array[5] = endDateTextField.getText();
        array[6] = projectDescTextField.getText();
        array[7] = projectCommentsTextField.getText();
        array[8] = disciplinesTextField.getText();
        array[9] = themesTextField.getText();
        array[10] = prototypeLocationTextField.getText();
        projectListTableController.deleteRow(array, rowId);
    }//GEN-LAST:event_projectDeleteButtonActionPerformed

    private void projectClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectClearButtonActionPerformed
        // TODO add your handling code here:
        projectIDTextField.setText(null);
        projectTitleTextField.setText(null);
        projectStatusTextField.setText(null);
        lastUpdatedTextField.setText(null);
        startDateTextField.setText(null);
        endDateTextField.setText(null);
        projectDescTextField.setText(null);
        projectCommentsTextField.setText(null);
        disciplinesTextField.setText(null);
        themesTextField.setText(null);
        prototypeLocationTextField.setText(null);
    }//GEN-LAST:event_projectClearButtonActionPerformed

    private void projectAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectAddButtonActionPerformed
        // TODO add your handling code here:
        String[] array = new String[projectListTable.getColumnCount()];

        array[0] = projectIDTextField.getText();
        array[1] = projectTitleTextField.getText();
        array[2] = projectStatusTextField.getText();
        array[3] = lastUpdatedTextField.getText();
        array[4] = startDateTextField.getText();
        array[5] = endDateTextField.getText();
        array[6] = projectDescTextField.getText();
        array[7] = projectCommentsTextField.getText();
        array[8] = disciplinesTextField.getText();
        array[9] = themesTextField.getText();
        array[10] = prototypeLocationTextField.getText();

        projectListTableController.addRow(array);
    }//GEN-LAST:event_projectAddButtonActionPerformed

    private void projectTitleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectTitleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectTitleTextFieldActionPerformed

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed

    private void userNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTextFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String userName = userNameTextField.getText();
        String password = passwordTextField.getText();
        System.out.println("userName:" + userName);
        System.out.println("password:" + password);
        String output = loginListTableController.validate(userName, password);
        if ("success".equalsIgnoreCase(output)) {
            adminTabbedPanel.setEnabledAt(1, true);
            adminTabbedPanel.setEnabledAt(2, true);
            adminTabbedPanel.setEnabledAt(3, true);
            adminTabbedPanel.setSelectedIndex(1);
            adminTabbedPanel.setEnabledAt(0, false);
        } else {
            loginErrorLabel.setText("Invalid Login");
            loginErrorLabel.setForeground(Color.red);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void adminTabbedPanelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminTabbedPanelFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_adminTabbedPanelFocusGained

    private void adminTabbedPanelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_adminTabbedPanelStateChanged
        // TODO add your handling code here:

        if (adminTabbedPanel.getSelectedIndex() == 2) {

            int projectId = Integer.parseInt((projectIDTextField.getText() == null || "".equals(projectIDTextField.getText())) ? "0" : projectIDTextField.getText());
            System.out.println("projectId=" + projectId);
            mediaListTableController.mediaRecords(projectId);

        } else if (adminTabbedPanel.getSelectedIndex() == 3) {
            int projectId = Integer.parseInt((projectIDTextField.getText() == null || "".equals(projectIDTextField.getText())) ? "0" : projectIDTextField.getText());
            System.out.println("projectId=" + projectId);
            memberListTableController.memberRecords(projectId);
        }
    }//GEN-LAST:event_adminTabbedPanelStateChanged

    private void projectUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectUpdateButtonActionPerformed
        int rowId = projectListTable.getSelectedRow();

        String[] array = new String[projectListTable.getColumnCount()];
        array[1] = projectTitleTextField.getText();
        array[0] = projectIDTextField.getText();
        array[2] = projectStatusTextField.getText();
        array[3] = lastUpdatedTextField.getText();
        array[4] = startDateTextField.getText();
        array[5] = endDateTextField.getText();
        array[6] = projectDescTextField.getText();
        array[7] = projectCommentsTextField.getText();
        array[8] = disciplinesTextField.getText();
        array[9] = themesTextField.getText();
        array[10] = prototypeLocationTextField.getText();
        projectListTableController.updateRow(array, rowId);
    }//GEN-LAST:event_projectUpdateButtonActionPerformed

    private void mediaUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediaUpdateButtonActionPerformed
        int rowId = mediaListTable.getSelectedRow();

        String[] array = new String[mediaListTable.getColumnCount()];

        array[0] = mediaIDTextField.getText();
        array[1] = mediaProjectIDTextField.getText();
        array[2] = mediaTypeTextField.getText();
        array[3] = mediaNameTextField.getText();
        array[4] = mediaDescTextField.getText();
        array[5] = mediaFileTextField.getText();
        mediaListTableController.updateRow(array, rowId);
    }//GEN-LAST:event_mediaUpdateButtonActionPerformed

    private void memberUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberUpdateButtonActionPerformed
        int rowId = memberListTable.getSelectedRow();

        String[] array = new String[memberListTable.getColumnCount()];

        array[0] = memberIDTextField.getText();
        array[1] = memberProjectIDTextField.getText();
        array[2] = memberNameTextField.getText();
        array[3] = memberRoleTextField.getText();
        memberListTableController.updateRow(array, rowId);
    }//GEN-LAST:event_memberUpdateButtonActionPerformed

    private void projectTitleTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

     private void mediaFileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                   

    }                                                  

    private void mediaFileTextFieldMouseEntered(java.awt.event.MouseEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void mediaFileTextFieldMouseClicked(java.awt.event.MouseEvent evt) {                                                
                chooser = new JFileChooser();
        //chooser.setAcceptAllFileFilterUsed(false);
        // This file filter allows the user to select JPG/JPEG files only
//        FileNameExtensionFilter jpgFilter = new FileNameExtensionFilter(
//                "JPG/JPEG files", "JPG", "JPEG", "jpg", "jpeg");
//        // This file filter allows the user to select PNG files only
//        FileNameExtensionFilter pngFilter = new FileNameExtensionFilter(
//                "PNG files", "PNG", "png");
//        chooser.setFileFilter(jpgFilter);
//        chooser.setFileFilter(pngFilter);
        int returnVal = chooser.showOpenDialog(window);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // open a dialog box to select files
            File file = chooser.getSelectedFile();
            
            mediaFileTextField.setText(file.getPath());
            System.out.println(file.getName());

            // load the image from the file and put it in drawing panel
//            Image image = new javax.swing.ImageIcon(file.getPath()).getImage();
//            drawingPanel.loadImage(image);
//
//            // update the title of the image
//            titleLabel.setText(file.getName());
//            titlePanel.repaint();
        }
    }                                                        
////////////////////////////////////
    class MyListSelectionListener implements ListSelectionListener{
	      @Override
	      public void valueChanged(ListSelectionEvent e) {
	          int row = projectNameTable.getSelectedRow();
	          if(row >= 0){
	          ProjectDetails[] projects = controller.getProjects();
	          projectTitleTextField1.setText(projects[row].getproject_title());
	          projectStatusTextField1.setText(projects[row].getproject_status());
	          projectLastUpdatedTextField.setText(projects[row].getproject_last_updated());
	          projectStartDateTextField.setText(projects[row].getproject_startdate());
	          projectEndDateTextField.setText(projects[row].getproject_enddate());
	          projectThemeTextField.setText(projects[row].getproject_theme());
	          prototypeLocationTextField1.setText(projects[row].getprototype_location());
	          disciplinesInvolvedTextField.setText(projects[row].getdisciplines_involved());
	          projectDescriptionTextField.setText(projects[row].getproject_description());
	          projectCommentsTextField1.setText(projects[row].getproject_comments());
	          
	          int d = projects[row].getproject_id();

	          controller.queryMembers(d);
	          controller.queryMedia(d);
	          
	          updateMemberNameTable();
	          updateMediaNameTable();
	          }
	      } 
	   
	 };
	   public void updateProjectNameTable(){
	    	projectNameTable.setModel(controller.getProjectTableModel());
	  }
	    
	   public void updateMemberNameTable(){
		   projectMembersTable.setModel(controller.getMembersTableModel());
	   }
	   
	   public void updateMediaNameTable(){
		   projectMediaTable.setModel(controller.getMediaTableModel());
	   }
	   
////////////////////////////////////
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProjectListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectListGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectListGUI().setVisible(true);
            }
        });
    }
private JFileChooser chooser;
 private JFrame window = new JFrame();
    // Variables declaration - do not modify                     
    private javax.swing.JLabel MemberRoleLabel;
    private javax.swing.JTabbedPane adminTabbedPanel;
    private javax.swing.JLabel descriptionOutcomesQueryLabel;
    private javax.swing.JTextField descriptionOutcomesQueryTextField;
    private javax.swing.JLabel discipilinesLabel;
    private javax.swing.JLabel disciplinesInvolvedLabel;
    private javax.swing.JTextField disciplinesInvolvedTextField;
    private javax.swing.JTextField disciplinesTextField;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JLabel endDateQueryLabel;
    private javax.swing.JTextField endDateTextField;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lastUpdatedLabel;
    private javax.swing.JTextField lastUpdatedTextField;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginErrorLabel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel logoLabel1;
    private javax.swing.JButton mediaAddButton;
    private javax.swing.JButton mediaClearButton;
    private javax.swing.JComboBox mediaComboBox;
    private javax.swing.JButton mediaDeleteButton;
    private javax.swing.JLabel mediaDescLabel;
    private javax.swing.JTextField mediaDescTextField;
    private javax.swing.JLabel mediaFileLabel;
    private javax.swing.JTextField mediaFileTextField;
    private javax.swing.JLabel mediaIDLabel;
    private javax.swing.JTextField mediaIDTextField;
    private javax.swing.JLabel mediaNameLabel;
    private javax.swing.JTextField mediaNameTextField;
    private javax.swing.JPanel mediaPanel;
    private javax.swing.JLabel mediaProjectIDLabel;
    private javax.swing.JTextField mediaProjectIDTextField;
    private javax.swing.JScrollPane mediaResultsPane;
    private javax.swing.JLabel mediaTypeLabel;
    private javax.swing.JTextField mediaTypeTextField;
    private javax.swing.JButton mediaUpdateButton;
    private javax.swing.JButton memberAddButton;
    private javax.swing.JButton memberClearButton;
    private javax.swing.JButton memberDeleteButton;
    private javax.swing.JLabel memberIDLabel;
    private javax.swing.JTextField memberIDTextField;
    private javax.swing.JLabel memberNameLabel;
    private javax.swing.JTextField memberNameTextField;
    private javax.swing.JPanel memberPanel;
    private javax.swing.JLabel memberProjectIDLabel;
    private javax.swing.JTextField memberProjectIDTextField;
    private javax.swing.JScrollPane memberResultsPane;
    private javax.swing.JTextField memberRoleTextField;
    private javax.swing.JButton memberUpdateButton;
    private javax.swing.JLabel membersQueryLabel;
    private javax.swing.JTextField membersQueryTextField;
    private javax.swing.JComboBox month_end_date;
    private javax.swing.JComboBox month_start_date;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JButton projectAddButton;
    private javax.swing.JButton projectClearButton;
    private javax.swing.JLabel projectCommentsLabel;
    private javax.swing.JLabel projectCommentsLabel1;
    private javax.swing.JTextField projectCommentsTextField;
    private javax.swing.JTextField projectCommentsTextField1;
    private javax.swing.JButton projectDeleteButton;
    private javax.swing.JLabel projectDescLabel;
    private javax.swing.JTextField projectDescTextField;
    private javax.swing.JLabel projectDescriptionLabel;
    private javax.swing.JTextField projectDescriptionTextField;
    private javax.swing.JLabel projectEndDateLabel;
    private javax.swing.JTextField projectEndDateTextField;
    private javax.swing.JLabel projectIDLabel;
    private javax.swing.JTextField projectIDTextField;
    private javax.swing.JLabel projectLastUpdatedLabel;
    private javax.swing.JTextField projectLastUpdatedTextField;
    private javax.swing.JTable projectMediaTable;
    private javax.swing.JTable projectMembersTable;
    private javax.swing.JTable projectNameTable;
    private javax.swing.JPanel projectPanel;
    private javax.swing.JScrollPane projectResultsPane;
    private javax.swing.JLabel projectStartDateLabel;
    private javax.swing.JTextField projectStartDateTextField;
    private javax.swing.JLabel projectStatusLabel;
    private javax.swing.JLabel projectStatusLabel1;
    private javax.swing.JTextField projectStatusTextField;
    private javax.swing.JTextField projectStatusTextField1;
    private javax.swing.JLabel projectThemeLabel;
    private javax.swing.JTextField projectThemeTextField;
    private javax.swing.JLabel projectTitleLabel;
    private javax.swing.JLabel projectTitleLabel1;
    private javax.swing.JLabel projectTitleQueryLabel;
    private javax.swing.JTextField projectTitleQueryTextField;
    private javax.swing.JTextField projectTitleTextField;
    private javax.swing.JTextField projectTitleTextField1;
    private javax.swing.JButton projectUpdateButton;
    private javax.swing.JLabel prototypeLocationLabel;
    private javax.swing.JLabel prototypeLocationLabel1;
    private javax.swing.JTextField prototypeLocationTextField;
    private javax.swing.JTextField prototypeLocationTextField1;
    private javax.swing.JButton queryButton;
    private javax.swing.JTabbedPane queryTab;
    private javax.swing.JPanel queryTab1;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JLabel startDateQueryLabel;
    private javax.swing.JTextField startDateTextField;
    private javax.swing.JLabel statusQueryLabel;
    private javax.swing.JTextField statusQueryTextField;
    private javax.swing.JLabel themeCategoryQueryLabel;
    private javax.swing.JTextField themeCategoryQueryTextField;
    private javax.swing.JLabel themesLabel;
    private javax.swing.JTextField themesTextField;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JTabbedPane viewerTabbedPanel;
    private javax.swing.JComboBox year_end_date;
    private javax.swing.JComboBox year_start_date;
    // End of variables declaration         
    ListSelectionModel listSelectionModel;
    Controller controller;
}
