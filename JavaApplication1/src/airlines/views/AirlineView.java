package airlines.views;

import Editions.PostgresDbAdapter;
import airlines.View;
import airlines.queries.Quiery1;
import airlines.queries.Quiery2;
import airlines.queries.Quiery3;
import airlines.structure.Airlines;
import airlines.structure.Country;
import airlines.tables.AirlinesTable;
import airlines.tables.CountryTable;
import airlines.views.structure.AirlineConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AirlineView extends javax.swing.JFrame {
    private final AirlineConstruct model;
    
    public AirlineView() {
        initComponents();
        model = new AirlineConstruct();
        airlinesTable.setModel(model);
        
        airlinesTable.addRowSelectionInterval(0, 0);
        recordPanel.setVisible(false);    
    }
    
    public void updateUi() {
        airlinesTable.updateUI();
        model.updateAirlines();
    }
    
  
    private void enableFields() {
        //idField.setEnabled(true);
        nameField.setEnabled(true);
        openedField.setEnabled(true);
        numAircraftsSpinner.setEnabled(true);
        countriesComboBox.setEnabled(true);
    
    }
    
   
    private void disableFields() {
        idField.setEnabled(false);
        nameField.setEnabled(false);
        openedField.setEnabled(false);
        numAircraftsSpinner.setEnabled(false);
        countriesComboBox.setEnabled(false);
      
    }
  
    public void selectLastRecord() throws SQLException {
        airlinesTable.clearSelection();
        airlinesTable.addRowSelectionInterval(airlinesTable.getRowCount()-1, airlinesTable.getRowCount()-1);
        updateRecordInForm();   
    }
    
 
    private void updateRecordInForm() throws SQLException {
        int selectedId = airlinesTable.getSelectedRow();
        
        int id = (int) airlinesTable.getValueAt(selectedId, 0);
        String name = (String) airlinesTable.getValueAt(selectedId, 1);
        Date dateCreation = (java.sql.Date) airlinesTable.getValueAt(selectedId, 2);
        int numAircrafts = (int) airlinesTable.getValueAt(selectedId, 3);
        String countryReg = (String) airlinesTable.getValueAt(selectedId, 4);
        idField.setText(Integer.toString(id));
        nameField.setText(name);
        //dateCreationBox.setSelectedItem(dateCreation);
        numAircraftsSpinner.setValue(numAircrafts);
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        String dateCreate = format.format(dateCreation);
        openedField.setText(dateCreate);
        List<Country> countries = new CountryTable().getCountry();
        for (Country w: countries){
            countriesComboBox.addItem(w.getCountry());
        };
        String query = "SELECT id FROM airlines where countryreg = '" + countryReg +"';";
        ResultSet set = PostgresDbAdapter.getAdapter().executeQueryWithResult(query);
        while (set.next()) {
        int id_c = set.getInt("id")-1;
        countriesComboBox.setSelectedIndex(id_c);
        }
        
    
        idField.setEnabled(false);
    }
    
  
    private void disableButtons() {
        nextButton.setEnabled(false);
        previousButton.setEnabled(false);
        firstButton.setEnabled(false);
        lastButton.setEnabled(false);;
        changeViewButton.setEnabled(false);
  }
    
 
    private void enableButtons() {
        nextButton.setEnabled(true);
        previousButton.setEnabled(true);
        firstButton.setEnabled(true);
        lastButton.setEnabled(true);
        addButton.setEnabled(true);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);
        changeViewButton.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        airPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("airPU").createEntityManager();
        countriesQuery = java.beans.Beans.isDesignTime() ? null : airPUEntityManager.createQuery("SELECT c FROM Countries c");
        countriesList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : countriesQuery.getResultList();
        tablePanel = new javax.swing.JScrollPane();
        airlinesTable = new javax.swing.JTable();
        buttonPanel = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        changeViewButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        firstButton = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        recordPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        numAircraftsSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        openedField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        countriesComboBox = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Авиакомпании");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        airlinesTable.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        airlinesTable.setModel(airlinesTable.getModel());
        tablePanel.setViewportView(airlinesTable);

        getContentPane().add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 560, 310));

        deleteButton.setText("Удалить");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        addButton.setText("Добавить");
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Правка");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        changeViewButton.setLabel("Переключить вид");
        changeViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeViewButtonActionPerformed(evt);
            }
        });

        previousButton.setText("<<");
        previousButton.setEnabled(false);
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        firstButton.setText("|<<");
        firstButton.setEnabled(false);
        firstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstButtonActionPerformed(evt);
            }
        });

        lastButton.setText(">>|");
        lastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Отмена");
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        nextButton.setText(">>");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(firstButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previousButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastButton))
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(changeViewButton))
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousButton)
                    .addComponent(nextButton)
                    .addComponent(firstButton)
                    .addComponent(lastButton))
                .addGap(18, 18, 18)
                .addComponent(changeViewButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(cancelButton))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        getContentPane().add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 260, 180));

        jLabel3.setText("Число самолетов");

        jLabel5.setText("Страна приписки");

        nameField.setEnabled(false);
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        numAircraftsSpinner.setEnabled(false);

        jLabel1.setText("Наименование");

        jLabel2.setText("Дата создания");

        openedField.setEnabled(false);

        idField.setEnabled(false);

        jLabel4.setText("Код авиакомпании");

        countriesComboBox.setEnabled(false);

        javax.swing.GroupLayout recordPanelLayout = new javax.swing.GroupLayout(recordPanel);
        recordPanel.setLayout(recordPanelLayout);
        recordPanelLayout.setHorizontalGroup(
            recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recordPanelLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4))
                .addGap(59, 59, 59)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(openedField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(numAircraftsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(countriesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );
        recordPanelLayout.setVerticalGroup(
            recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(openedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(numAircraftsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countriesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        getContentPane().add(recordPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 470, 260));

        jMenu1.setText("Запросы");

        jMenuItem1.setText("Выдать список населенных пунктов, откуда отправляются самолеты авиакомпании «Аэрофлот» ");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Выдать список авиакомпаний, которые обслуживают, по меньшей мере, хотя бы один рейс, вылетающий в дневное время (от 12 до 17 часов)");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Для Москвы выдать количество авиарейсов, связанных с этим городом (считать только рейсы отправления)  ");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //View mainFrame = new View();
        //mainFrame.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        addButton.setEnabled(true);
        updateButton.setEnabled(true);
        cancelButton.setEnabled(false);
        addButton.setText("Добавить");
        updateButton.setText("Правка");
        enableButtons();
        disableFields();
        try {
            updateRecordInForm();
        } catch (SQLException ex) {
            Logger.getLogger(AirlineView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void lastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonActionPerformed
        airlinesTable.clearSelection();
        airlinesTable.addRowSelectionInterval(airlinesTable.getRowCount()-1, airlinesTable.getRowCount()-1);
        try {
            updateRecordInForm();
        } catch (SQLException ex) {
            Logger.getLogger(AirlineView.class.getName()).log(Level.SEVERE, null, ex);
        }
        lastButton.setEnabled(false);
        nextButton.setEnabled(false);
        firstButton.setEnabled(true);
        previousButton.setEnabled(true);
    }//GEN-LAST:event_lastButtonActionPerformed

    private void firstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstButtonActionPerformed
        airlinesTable.clearSelection();
        airlinesTable.addRowSelectionInterval(0, 0);
        try {
            updateRecordInForm();
        } catch (SQLException ex) {
            Logger.getLogger(AirlineView.class.getName()).log(Level.SEVERE, null, ex);
        }
        firstButton.setEnabled(false);
        previousButton.setEnabled(false);
        lastButton.setEnabled(true);
        nextButton.setEnabled(true);
    }//GEN-LAST:event_firstButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        int selectedIndex = airlinesTable.getSelectedRow();

        if (selectedIndex == -1 || selectedIndex+1 == airlinesTable.getRowCount()) {
            return;
        }
        if (selectedIndex+1 == airlinesTable.getRowCount()-1)
        {
            lastButton.setEnabled(false);
            nextButton.setEnabled(false);
        }

        airlinesTable.clearSelection();
        airlinesTable.addRowSelectionInterval(selectedIndex+1, selectedIndex+1);

        try {
            updateRecordInForm();
        } catch (SQLException ex) {
            Logger.getLogger(AirlineView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        firstButton.setEnabled(true);
        previousButton.setEnabled(true);
    }//GEN-LAST:event_nextButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        int selectedIndex = airlinesTable.getSelectedRow();


        if (selectedIndex == -1 || selectedIndex == 0) {
            return;
        }
        if (selectedIndex == 1)
        {
            firstButton.setEnabled(false);
            previousButton.setEnabled(false);
        }

        airlinesTable.clearSelection();
        airlinesTable.addRowSelectionInterval(selectedIndex-1, selectedIndex-1);

        try {
            updateRecordInForm();
        } catch (SQLException ex) {
            Logger.getLogger(AirlineView.class.getName()).log(Level.SEVERE, null, ex);
        }
        lastButton.setEnabled(true);
        nextButton.setEnabled(true);
    }//GEN-LAST:event_previousButtonActionPerformed

    private void changeViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeViewButtonActionPerformed
        try {
            updateRecordInForm();
        } catch (SQLException ex) {
            Logger.getLogger(AirlineView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (tablePanel.isVisible()) {
     
            tablePanel.setVisible(false);
            recordPanel.setVisible(true);
            addButton.setEnabled(true);
            updateButton.setEnabled(true);
        }
        else {
            tablePanel.setVisible(true);
            recordPanel.setVisible(false);
        }
    }//GEN-LAST:event_changeViewButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        
        if ("Правка".equals(updateButton.getText())) {
            enableFields();
            disableButtons();
            updateButton.setEnabled(true);
            cancelButton.setEnabled(true);
            updateButton.setText("Сохранить");
            
            if (tablePanel.isVisible()) {
            tablePanel.setVisible(false);
            recordPanel.setVisible(true);
            addButton.setEnabled(false);
            updateButton.setEnabled(true);
            deleteButton.setEnabled(false);
            }
            else {
                tablePanel.setVisible(false);
                recordPanel.setVisible(true);
                deleteButton.setEnabled(false);
                //tablePanel.setVisible(true);
                addButton.setEnabled(false);
            }
        }
        else {
            disableFields();
            enableButtons();
            cancelButton.setEnabled(false);
            updateButton.setText("Правка");
            
            int id_new = Integer.valueOf(idField.getText());
            String name = nameField.getText();
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            
            java.util.Date dateCreation = null;
            try {
                java.util.Date dateCreate = (java.util.Date) format.parse(openedField.getText());
                dateCreation = new java.sql.Date(dateCreate.getTime());
            } 
            catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка ввода данных, повторите заново");
            }
            int numAircrafts = (int) numAircraftsSpinner.getValue();            
            String countryReg = (String) countriesComboBox.getSelectedItem();
            Airlines airline = new Airlines(id_new, name, dateCreation, numAircrafts, countryReg);

            int selectedId = airlinesTable.getSelectedRow();
            int id = (int) airlinesTable.getValueAt(selectedId, 0);

            AirlinesTable dao = new AirlinesTable();
            dao.updateAirline(id, airline);
            updateUi();
            try {
                updateUpdateUI(selectedId);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка ввода данных, повторите заново");

            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        
        if ("Добавить".equals(addButton.getText())) {
           
        if (tablePanel.isVisible()) {
            
            tablePanel.setVisible(false);
            recordPanel.setVisible(true);
            addButton.setEnabled(true);
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
        else {
            tablePanel.setVisible(true);
            recordPanel.setVisible(true);

            updateButton.setEnabled(true);
            deleteButton.setEnabled(true);
        }
            enableFields();
            disableButtons();
            addButton.setEnabled(true);
            cancelButton.setEnabled(true);
            addButton.setText("Сохранить");
            idField.setEnabled(false);
            String s = String.valueOf(airlinesTable.getRowCount()+1);
            idField.setText(s);
            nameField.setText("");
            openedField.setText("");
            numAircraftsSpinner.setValue(0);
            List<Country> countries = new CountryTable().getCountry();
               for (Country w: countries){
            countriesComboBox.addItem(w.getCountry());
                };
        }
        else {
            
            disableFields();
            enableButtons();
            cancelButton.setEnabled(false);
            addButton.setText("Добавить");
            int id = Integer.valueOf(idField.getText());
            String name = nameField.getText();
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            Date dateCreation = null;
            try {
                dateCreation = (Date) format.parse(openedField.getText());
            } catch (ParseException ex) {
                 JOptionPane.showMessageDialog(null, "Ошибка ввода данных, повторите заново");
            }
            int numAircrafts = (int) numAircraftsSpinner.getValue();
            String countryReg = (String) countriesComboBox.getSelectedItem();
            

            Airlines airline = new Airlines(id, name, dateCreation, numAircrafts, countryReg);

            AirlinesTable dao = new AirlinesTable();
            try {
                dao.addAirline(airline);
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Ошибка ввода данных, повторите заново");
            }
            updateUi();
            try {
                selectLastRecord();
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Ошибка ввода данных, повторите заново");
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Удалить выбранные записи?", "Удаление", dialogButton);

        if(dialogResult == JOptionPane.YES_OPTION) {
            int[] selectedRowIds = airlinesTable.getSelectedRows();
            AirlinesTable dao = new AirlinesTable();
            for (int i : selectedRowIds) {
                int selectedId = (int) airlinesTable.getValueAt(i, 0);
                dao.removeAirline(selectedId);
            }

            updateUi();
        }

        airlinesTable.addRowSelectionInterval(0, 0);
        try {
            updateRecordInForm();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Ошибка");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        // TODO add your handling code here:
        new Quiery1().setVisible(true);
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
        // TODO add your handling code here:
        new Quiery2().setVisible(true);
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
        // TODO add your handling code here:
        new Quiery3().setVisible(true);
    }//GEN-LAST:event_jMenuItem3MousePressed

    public void updateUpdateUI(int selectedId) throws SQLException {
        airlinesTable.clearSelection();
        airlinesTable.addRowSelectionInterval(selectedId, selectedId);
        updateRecordInForm();   
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
            java.util.logging.Logger.getLogger(AirlineView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AirlineView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AirlineView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AirlineView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AirlineView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.persistence.EntityManager airPUEntityManager;
    private javax.swing.JTable airlinesTable;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton changeViewButton;
    private javax.swing.JComboBox<String> countriesComboBox;
    private java.util.List<airlines.views.Countries> countriesList;
    private javax.persistence.Query countriesQuery;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton firstButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JButton lastButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton nextButton;
    private javax.swing.JSpinner numAircraftsSpinner;
    private javax.swing.JTextField openedField;
    private javax.swing.JButton previousButton;
    private javax.swing.JPanel recordPanel;
    private javax.swing.JScrollPane tablePanel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
