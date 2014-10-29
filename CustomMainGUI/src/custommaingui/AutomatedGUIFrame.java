/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custommaingui;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author farshad
 */
public class AutomatedGUIFrame extends javax.swing.JFrame {

    /**
     * Creates new form AutomatedGUIFrame
     */
    public AutomatedGUIFrame() {
        libraryFunction = new LibraryFunction();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MainTabbedPane = new javax.swing.JTabbedPane();
        BrowsePanel = new javax.swing.JPanel();
        BrowsePanelSubScrollPane2 = new javax.swing.JScrollPane();
        BrowseDBTable = new javax.swing.JTable();
        FirstButtonBrowsePane = new javax.swing.JButton();
        PreviousButtonBrowsePane = new javax.swing.JButton();
        LastButtonBrowsePane = new javax.swing.JButton();
        NextButtonBrowsePane = new javax.swing.JButton();
        ADDPanel = new javax.swing.JPanel();
        SerialLabelAddPane = new javax.swing.JLabel();
        TitleLabelAddPane = new javax.swing.JLabel();
        AuthorLabelAddPane = new javax.swing.JLabel();
        SerialTxtFieldAddPane = new javax.swing.JTextField();
        ManualTxtFieldAddPane = new javax.swing.JTextField();
        AuthorTxtFieldAddPane = new javax.swing.JTextField();
        SaveButtonAddPane = new javax.swing.JButton();
        DiscardButtonAddPane = new javax.swing.JButton();
        SearchPanel = new javax.swing.JPanel();
        SearchPanelSubScrollPane = new javax.swing.JScrollPane();
        SearchDBTable = new javax.swing.JTable();
        SerialTxtFieldSearchPane = new javax.swing.JTextField();
        TitleTxtFieldSearchPane = new javax.swing.JTextField();
        AuthorTxtFieldSearchPane = new javax.swing.JTextField();
        SearchButtonSearchPane = new javax.swing.JButton();
        MainMenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        Add_Item_FileMenu = new javax.swing.JMenuItem();
        Search_Item_FileMenu = new javax.swing.JMenuItem();
        Browse_Item_FileMenu = new javax.swing.JMenuItem();
        Exit_Item_FileMenu = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        UsrMan_HelpMenu = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));
        setName("MainFrame"); // NOI18N

        MainTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MainTabbedPaneStateChanged(evt);
            }
        });

        BrowsePanel.setToolTipText("");

        BrowseDBTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html> <b>Number</b> </html>", "<html> <b>Manual Serial Number</b> </html>", "<html> <b>Title of Manual</b> </html>", "<html> <b>Author Name</b> </html>"
            }
        ));
        BrowsePanelSubScrollPane2.setViewportView(BrowseDBTable);

        FirstButtonBrowsePane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/custommaingui/up.png"))); // NOI18N
        FirstButtonBrowsePane.setText("<html>\n<b>First</b>\n</html>\n");
        FirstButtonBrowsePane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstButtonBrowsePaneActionPerformed(evt);
            }
        });

        PreviousButtonBrowsePane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/custommaingui/back.png"))); // NOI18N
        PreviousButtonBrowsePane.setText("<html>\n<b>Previous<b>\n</html>");
        PreviousButtonBrowsePane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonBrowsePaneActionPerformed(evt);
            }
        });

        LastButtonBrowsePane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/custommaingui/down.png"))); // NOI18N
        LastButtonBrowsePane.setText("<html>\n<b>Last</b>\n</html>");
        LastButtonBrowsePane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastButtonBrowsePaneActionPerformed(evt);
            }
        });

        NextButtonBrowsePane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/custommaingui/forward.png"))); // NOI18N
        NextButtonBrowsePane.setText("<html>\n<b>Next</b>\n</html>");
        NextButtonBrowsePane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonBrowsePaneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BrowsePanelLayout = new javax.swing.GroupLayout(BrowsePanel);
        BrowsePanel.setLayout(BrowsePanelLayout);
        BrowsePanelLayout.setHorizontalGroup(
            BrowsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BrowsePanelLayout.createSequentialGroup()
                .addGroup(BrowsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BrowsePanelLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(FirstButtonBrowsePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(PreviousButtonBrowsePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(NextButtonBrowsePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(LastButtonBrowsePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BrowsePanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(BrowsePanelSubScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        BrowsePanelLayout.setVerticalGroup(
            BrowsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BrowsePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(BrowsePanelSubScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(BrowsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirstButtonBrowsePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreviousButtonBrowsePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LastButtonBrowsePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NextButtonBrowsePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        MainTabbedPane.addTab("Browse DB", BrowsePanel);

        SerialLabelAddPane.setText("<html>\n<b>Serial Number</b>\n</html>");

        TitleLabelAddPane.setText("<html>\n<b>Manual Title</b>\n</html>");

        AuthorLabelAddPane.setText("<html>\n<b>Author Name</b>\n</html>");

        SerialTxtFieldAddPane.setText("Enter Manual Serial Number");

        ManualTxtFieldAddPane.setText("Enter Manual Title");

        AuthorTxtFieldAddPane.setText("Enter Author Name");

        SaveButtonAddPane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/custommaingui/import.png"))); // NOI18N
        SaveButtonAddPane.setText("<html>\n<b>Save</b>\n</html>");
        SaveButtonAddPane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonAddPaneActionPerformed(evt);
            }
        });

        DiscardButtonAddPane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/custommaingui/cancel.png"))); // NOI18N
        DiscardButtonAddPane.setText("<html>\n<b>Discard</b>\n</html>");
        DiscardButtonAddPane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscardButtonAddPaneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ADDPanelLayout = new javax.swing.GroupLayout(ADDPanel);
        ADDPanel.setLayout(ADDPanelLayout);
        ADDPanelLayout.setHorizontalGroup(
            ADDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADDPanelLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(ADDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AuthorLabelAddPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TitleLabelAddPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SerialLabelAddPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ADDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ADDPanelLayout.createSequentialGroup()
                        .addComponent(SaveButtonAddPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(DiscardButtonAddPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SerialTxtFieldAddPane)
                    .addComponent(ManualTxtFieldAddPane)
                    .addComponent(AuthorTxtFieldAddPane))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        ADDPanelLayout.setVerticalGroup(
            ADDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADDPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(ADDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SerialLabelAddPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SerialTxtFieldAddPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(ADDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitleLabelAddPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ManualTxtFieldAddPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(ADDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AuthorLabelAddPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AuthorTxtFieldAddPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(ADDPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButtonAddPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiscardButtonAddPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        MainTabbedPane.addTab("ADD Manual", ADDPanel);

        SearchDBTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html> <b>Number</b> </html>", "<html> <b>Manual Serial Number</b> </html>", "<html> <b>Title of Manual</b> </html>", "<html> <b>Author Name</b> </html>"
            }
        ));
        SearchPanelSubScrollPane.setViewportView(SearchDBTable);

        SerialTxtFieldSearchPane.setText("Enter the Manual Serial Number");

        TitleTxtFieldSearchPane.setText("Enter Manual Title");

        AuthorTxtFieldSearchPane.setText("Enter Author Name");

        SearchButtonSearchPane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/custommaingui/search.png"))); // NOI18N
        SearchButtonSearchPane.setText("<html>\n<b>Search</b>\n</html>");
        SearchButtonSearchPane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonSearchPaneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchPanelLayout = new javax.swing.GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchPanelLayout);
        SearchPanelLayout.setHorizontalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchPanelSubScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SearchPanelLayout.createSequentialGroup()
                        .addComponent(SerialTxtFieldSearchPane, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TitleTxtFieldSearchPane, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AuthorTxtFieldSearchPane, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchButtonSearchPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SearchPanelLayout.setVerticalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SerialTxtFieldSearchPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TitleTxtFieldSearchPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AuthorTxtFieldSearchPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButtonSearchPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(SearchPanelSubScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        MainTabbedPane.addTab("Search DB", SearchPanel);

        FileMenu.setText("File");
        FileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileMenuActionPerformed(evt);
            }
        });

        Add_Item_FileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/custommaingui/add.png"))); // NOI18N
        Add_Item_FileMenu.setMnemonic('V');
        Add_Item_FileMenu.setText("<html> <b>ADD Manual</b> </html>");
        Add_Item_FileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_Item_FileMenuActionPerformed(evt);
            }
        });
        FileMenu.add(Add_Item_FileMenu);

        Search_Item_FileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/custommaingui/search.png"))); // NOI18N
        Search_Item_FileMenu.setMnemonic('V');
        Search_Item_FileMenu.setText("<html> <b>Search DB</b> </html>");
        Search_Item_FileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_Item_FileMenuActionPerformed(evt);
            }
        });
        FileMenu.add(Search_Item_FileMenu);

        Browse_Item_FileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/custommaingui/browse.png"))); // NOI18N
        Browse_Item_FileMenu.setText("<html>\n<b>Browse DB</b>\n</html>");
        Browse_Item_FileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Browse_Item_FileMenuActionPerformed(evt);
            }
        });
        FileMenu.add(Browse_Item_FileMenu);

        Exit_Item_FileMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        Exit_Item_FileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/custommaingui/close.png"))); // NOI18N
        Exit_Item_FileMenu.setText("<html>\n<b>Exit</b>\n</html>");
        Exit_Item_FileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_Item_FileMenuActionPerformed(evt);
            }
        });
        FileMenu.add(Exit_Item_FileMenu);

        MainMenuBar.add(FileMenu);

        HelpMenu.setText("Help");

        UsrMan_HelpMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        UsrMan_HelpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/custommaingui/information.png"))); // NOI18N
        UsrMan_HelpMenu.setText("<html>\n<b>User Manual</b>\n</html>");
        UsrMan_HelpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsrMan_HelpMenuActionPerformed(evt);
            }
        });
        HelpMenu.add(UsrMan_HelpMenu);

        MainMenuBar.add(HelpMenu);

        setJMenuBar(MainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainTabbedPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Search_Item_FileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_Item_FileMenuActionPerformed
        // TODO add your handling code here:
        MainTabbedPane.setSelectedIndex(2);
    }//GEN-LAST:event_Search_Item_FileMenuActionPerformed

    private void FileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileMenuActionPerformed
        // TODO add your handling code here:
        /* Dont write anything here*/
    }//GEN-LAST:event_FileMenuActionPerformed

    private void Browse_Item_FileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Browse_Item_FileMenuActionPerformed
        // TODO add your handling code here:
        MainTabbedPane.setSelectedIndex(0);
    }//GEN-LAST:event_Browse_Item_FileMenuActionPerformed

    private void Add_Item_FileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_Item_FileMenuActionPerformed
        // TODO add your handling code here:
        MainTabbedPane.setSelectedIndex(1);
    }//GEN-LAST:event_Add_Item_FileMenuActionPerformed

    private void Exit_Item_FileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit_Item_FileMenuActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_Exit_Item_FileMenuActionPerformed

    private void UsrMan_HelpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsrMan_HelpMenuActionPerformed
        // TODO add your handling code here:

        Main_ManualReader.PrintMan();
    }//GEN-LAST:event_UsrMan_HelpMenuActionPerformed

    private void NextButtonBrowsePaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonBrowsePaneActionPerformed
        // TODO add your handling code here:
        String[][] resultData = libraryFunction.BrowseNext();
        libraryFunction.addRow(BrowseDBTable, resultData);
    }//GEN-LAST:event_NextButtonBrowsePaneActionPerformed

    private void SearchButtonSearchPaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonSearchPaneActionPerformed
        // TODO add your handling code here:       

        // Text areas In add panel
        //JOptionPane.showMessageDialog(null,SerialTxtFieldSearchPane.getText());        
        String values0 = SerialTxtFieldSearchPane.getText();
        String values1 = TitleTxtFieldSearchPane.getText();
        String values2 = AuthorTxtFieldSearchPane.getText();

        String[] keys = new String[3];
        String[] values = new String[3];

        ValidationEngine vEngine = new ValidationEngine();
        int checkFlag = 0;
        if (vEngine.checkString(values0, 1, 0)) {
            values[checkFlag] = new String(values0);
            keys[checkFlag] = new String("id");

            checkFlag++;
        }
        if (vEngine.checkString(values1, 1, 1)) {
            values[checkFlag] = new String(values1);
            keys[checkFlag] = new String("BookName");

            checkFlag++;
        }
        if (vEngine.checkString(values2, 1, 2)) {
            values[checkFlag] = new String(values2);
            keys[checkFlag] = new String("Author");

            checkFlag++;
        }
        if (checkFlag > 0) {
            System.out.println("checkFlag : " + checkFlag);

            String[][] resultData = libraryFunction.Search(keys, values);
            libraryFunction.addRow(SearchDBTable, resultData);

            discardData(1);
        } else {
            System.out.println("checkFlag : " + checkFlag);
        }
    }//GEN-LAST:event_SearchButtonSearchPaneActionPerformed

    private void SaveButtonAddPaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonAddPaneActionPerformed
        // TODO add your handling code here:

        // Text areas In add panel
        String values0 = SerialTxtFieldAddPane.getText();
        String values1 = ManualTxtFieldAddPane.getText();
        String values2 = AuthorTxtFieldAddPane.getText();

        String[] keys = {"id", "BookName", "Author"};

        ValidationEngine vEngine = new ValidationEngine();
        int checkFlag = 0;
        if (!vEngine.checkString(values0, 0, 0)) {
            values0 = "??????";
            checkFlag++;
        }
        if (!vEngine.checkString(values1, 0, 1)) {
            values1 = "Untitled";
            checkFlag++;
        }
        if (!vEngine.checkString(values2, 0, 2)) {
            values2 = "Unknown";
            checkFlag++;
        }
        if (checkFlag < 3) {
            System.out.println("Add checkFlag : " + checkFlag);
            String[] values = {values0, values1, values2};

            if (libraryFunction.Add(keys, values)) {
                discardData(0);
            }
        } else {
            System.out.println("Add checkFlag : " + checkFlag);
        }
    }//GEN-LAST:event_SaveButtonAddPaneActionPerformed

    private void DiscardButtonAddPaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscardButtonAddPaneActionPerformed
        // TODO add your handling code here:
        discardData(0);

    }//GEN-LAST:event_DiscardButtonAddPaneActionPerformed

    private void FirstButtonBrowsePaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstButtonBrowsePaneActionPerformed
        // TODO add your handling code here:
        String[][] resultData = libraryFunction.BrowseFirst();
        libraryFunction.addRow(BrowseDBTable, resultData);
    }//GEN-LAST:event_FirstButtonBrowsePaneActionPerformed

    private void PreviousButtonBrowsePaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonBrowsePaneActionPerformed
        // TODO add your handling code here:
        String[][] resultData = libraryFunction.BrowsePrevious();
        libraryFunction.addRow(BrowseDBTable, resultData);
    }//GEN-LAST:event_PreviousButtonBrowsePaneActionPerformed

    private void LastButtonBrowsePaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastButtonBrowsePaneActionPerformed
        // TODO add your handling code here:
        String[][] resultData = libraryFunction.BrowseLast();
        libraryFunction.addRow(BrowseDBTable, resultData);
    }//GEN-LAST:event_LastButtonBrowsePaneActionPerformed

    private void MainTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MainTabbedPaneStateChanged
        //Tanu ADD YOUR CODE HERE////
        /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        */
    }//GEN-LAST:event_MainTabbedPaneStateChanged

    /**
     * My Codes :D starts
     */
    private void discardData(int i) {
        ValidationEngine vEngine = new ValidationEngine();
        String[] message = vEngine.getMessage(i);
        if (i == 0) {
            SerialTxtFieldAddPane.setText(message[0]);
            ManualTxtFieldAddPane.setText(message[1]);
            AuthorTxtFieldAddPane.setText(message[2]);
        } else if (i == 0) {
            SerialTxtFieldSearchPane.setText(message[0]);
            TitleTxtFieldSearchPane.setText(message[1]);
            AuthorTxtFieldSearchPane.setText(message[2]);
        }

    }

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
            java.util.logging.Logger.getLogger(AutomatedGUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutomatedGUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutomatedGUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutomatedGUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutomatedGUIFrame().setVisible(true);
            }
        });
    }  //end of main

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADDPanel;
    private javax.swing.JMenuItem Add_Item_FileMenu;
    private javax.swing.JLabel AuthorLabelAddPane;
    private javax.swing.JTextField AuthorTxtFieldAddPane;
    private javax.swing.JTextField AuthorTxtFieldSearchPane;
    private javax.swing.JTable BrowseDBTable;
    private javax.swing.JPanel BrowsePanel;
    private javax.swing.JScrollPane BrowsePanelSubScrollPane2;
    private javax.swing.JMenuItem Browse_Item_FileMenu;
    private javax.swing.JButton DiscardButtonAddPane;
    private javax.swing.JMenuItem Exit_Item_FileMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JButton FirstButtonBrowsePane;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JButton LastButtonBrowsePane;
    private javax.swing.JMenuBar MainMenuBar;
    private javax.swing.JTabbedPane MainTabbedPane;
    private javax.swing.JTextField ManualTxtFieldAddPane;
    private javax.swing.JButton NextButtonBrowsePane;
    private javax.swing.JButton PreviousButtonBrowsePane;
    private javax.swing.JButton SaveButtonAddPane;
    private javax.swing.JButton SearchButtonSearchPane;
    private javax.swing.JTable SearchDBTable;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JScrollPane SearchPanelSubScrollPane;
    private javax.swing.JMenuItem Search_Item_FileMenu;
    private javax.swing.JLabel SerialLabelAddPane;
    private javax.swing.JTextField SerialTxtFieldAddPane;
    private javax.swing.JTextField SerialTxtFieldSearchPane;
    private javax.swing.JLabel TitleLabelAddPane;
    private javax.swing.JTextField TitleTxtFieldSearchPane;
    private javax.swing.JMenuItem UsrMan_HelpMenu;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private LibraryFunction libraryFunction;
}
