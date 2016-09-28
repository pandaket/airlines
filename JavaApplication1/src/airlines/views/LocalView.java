package airlines.views;

import Editions.PostgresDbAdapter;
import airlines.View;
import airlines.structure.Country;
import airlines.structure.Locals;
import airlines.tables.CountryTable;
import airlines.tables.LocalsTable;
import airlines.views.structure.LocalConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class LocalView extends javax.swing.JFrame {
    private final LocalConstruct model;
    DefaultComboBoxModel d1=new  DefaultComboBoxModel();
    int _count = 0;
    
    public LocalView() {
        initComponents();
        model = new LocalConstruct();
        localsTable.setModel(model);
        
        // выделяем первую запись в таблице
        localsTable.addRowSelectionInterval(0, 0);
        recordPanel.setVisible(false); 
        newCountryLabel.setVisible(false);
        newCityLabel.setVisible(false);
        newCountry.setVisible(false);
        newCity.setVisible(false);
       
    }
    
    public void updateUi() {
        localsTable.updateUI();
        model.updateLocalList();
    }
    
    private void updateRecordInForm() throws SQLException {
        int selectedId = localsTable.getSelectedRow();
        
        int id = (int) localsTable.getValueAt(selectedId, 0);
        String name = (String) localsTable.getValueAt(selectedId, 1);
        String country = (String) localsTable.getValueAt(selectedId, 2);
        int numAirports = (int) localsTable.getValueAt(selectedId, 3);
        int population = (int) localsTable.getValueAt(selectedId, 4);
        
             
            List<Country> cities = new CountryTable().getCity();
            for (Country w: cities){
                nameComboBox.addItem(w.getCity());
            };
            
            String query1 = "SELECT id, name FROM locals where name = '" + name +"';";
            ResultSet set1 = PostgresDbAdapter.getAdapter().executeQueryWithResult(query1);
            while (set1.next()) {
            int id_c = set1.getInt("id")-1;
            nameComboBox.setSelectedIndex(id_c);
            }
            
            List<Country> countries = new CountryTable().getCountry1();
            for (Country w: countries){
                countryComboBox.addItem(w.getCountry());
            };
            
            String query = "SELECT id, country FROM locals where country = '" + country +"';";
            ResultSet set = PostgresDbAdapter.getAdapter().executeQueryWithResult(query);
            while (set.next()) {
            int id_c = set.getInt("id")-1;
            countryComboBox.setSelectedIndex(id_c);
            } 
            
        
            
        numAirportsSpinner.setValue(numAirports);
        populationSpinner.setValue(population);
    }
    
    private void disableButtons() {
        nextButton.setEnabled(false);
        previousButton.setEnabled(false);
        firstButton.setEnabled(false);
        lastButton.setEnabled(false);
        addButton.setEnabled(false);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
        changeViewButton.setEnabled(false);
    }
    
    // деактивация почти всех кнопок
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
    
    
    private void enableFields() {
        nameComboBox.setEnabled(true);
        countryComboBox.setEnabled(true);
        numAirportsSpinner.setEnabled(true);
        populationSpinner.setEnabled(true);
    }
    
    
    private void disableFields() {
        nameComboBox.setEnabled(false);
        countryComboBox.setEnabled(false);
        numAirportsSpinner.setEnabled(false);
        populationSpinner.setEnabled(false);
    }
    
   
    public void selectLastRecord() throws SQLException {
        localsTable.clearSelection();
        localsTable.addRowSelectionInterval(localsTable.getRowCount()-1, localsTable.getRowCount()-1);
        updateRecordInForm();   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePanel = new javax.swing.JScrollPane();
        localsTable = new javax.swing.JTable();
        buttonPanel = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        firstButton = new javax.swing.JButton();
        changeViewButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        recordPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        numAirportsSpinner = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        populationSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        nameComboBox = new javax.swing.JComboBox<>();
        countryComboBox = new javax.swing.JComboBox<>();
        newCityButton = new javax.swing.JButton();
        newCity = new javax.swing.JTextField();
        newCountry = new javax.swing.JTextField();
        newCityLabel = new javax.swing.JLabel();
        newCountryLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Список населенных пунктов");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        localsTable.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        localsTable.setModel(localsTable.getModel());
        tablePanel.setViewportView(localsTable);

        getContentPane().add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 660, 300));

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

        previousButton.setText("<<");
        previousButton.setEnabled(false);
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        lastButton.setText(">>|");
        lastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastButtonActionPerformed(evt);
            }
        });

        nextButton.setText(">>");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        firstButton.setText("|<<");
        firstButton.setEnabled(false);
        firstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstButtonActionPerformed(evt);
            }
        });

        changeViewButton.setLabel("Переключить вид");
        changeViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeViewButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Отмена");
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addComponent(firstButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previousButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastButton))
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(changeViewButton))
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousButton)
                    .addComponent(firstButton)
                    .addComponent(nextButton)
                    .addComponent(lastButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changeViewButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(cancelButton))
                .addGap(141, 141, 141))
        );

        getContentPane().add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 260, 140));

        jLabel5.setText("Число аэропортов");

        numAirportsSpinner.setEnabled(false);

        jLabel6.setText("Численность населения");

        jLabel1.setText("Наименование населенного пункта");

        populationSpinner.setEnabled(false);

        jLabel3.setText("Государство");

        nameComboBox.setEnabled(false);

        countryComboBox.setEnabled(false);
        countryComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                countryComboBoxItemStateChanged(evt);
            }
        });
        countryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryComboBoxActionPerformed(evt);
            }
        });

        newCityButton.setText("+");
        newCityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCityButtonActionPerformed(evt);
            }
        });

        newCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCountryActionPerformed(evt);
            }
        });

        newCityLabel.setText("Введите новый город");

        newCountryLabel.setText("Введите новую страну");

        javax.swing.GroupLayout recordPanelLayout = new javax.swing.GroupLayout(recordPanel);
        recordPanel.setLayout(recordPanelLayout);
        recordPanelLayout.setHorizontalGroup(
            recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(recordPanelLayout.createSequentialGroup()
                            .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(recordPanelLayout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))
                                .addComponent(newCountryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, recordPanelLayout.createSequentialGroup()
                            .addComponent(newCityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(recordPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)))
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, recordPanelLayout.createSequentialGroup()
                        .addComponent(nameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(countryComboBox, 0, 194, Short.MAX_VALUE)
                        .addComponent(numAirportsSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addComponent(populationSpinner)
                        .addComponent(newCity)
                        .addComponent(newCountry)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newCityButton)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        recordPanelLayout.setVerticalGroup(
            recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newCityButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(numAirportsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(populationSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newCityLabel)
                    .addComponent(newCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newCountryLabel)
                    .addComponent(newCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        getContentPane().add(recordPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 490, 250));

        jButton1.setText("Обновить данные");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(843, 330, 140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        View mainFrame = new View();
        mainFrame.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Вы хотите удалить выделенные записи?", "Внимание", dialogButton);
        
        if(dialogResult == JOptionPane.YES_OPTION) {
            int[] selectedRowIds = localsTable.getSelectedRows();
            LocalsTable dao = new LocalsTable();
            for (int i : selectedRowIds) {
                int selectedId = (int) localsTable.getValueAt(i, 0);
                dao.removeLocal(selectedId);
            }
            
            updateUi();
        }
        
        localsTable.addRowSelectionInterval(0, 0);
        try {
            updateRecordInForm();
        } catch (SQLException ex) {
            Logger.getLogger(LocalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        numAirportsSpinner.setValue(0);
        populationSpinner.setValue(0);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // первый клик - открывем для редактирования
        if ("Правка".equals(updateButton.getText())) {
            enableFields();
            disableButtons();
            updateButton.setEnabled(true);
            cancelButton.setEnabled(true);
            updateButton.setText("Сохранить");
            if (tablePanel.isVisible()) {
            // отображаем запись
            tablePanel.setVisible(false);
            recordPanel.setVisible(true);

            // открываем кнопки
            addButton.setEnabled(false);
            updateButton.setEnabled(true);
            deleteButton.setEnabled(false);
            }
            else {
                tablePanel.setVisible(false);
                recordPanel.setVisible(true);
                deleteButton.setEnabled(false);

                addButton.setEnabled(false);
               // updateButton.setEnabled(false);
            }
        }
        else {
            // второй клик - собираем данные и сохраняем в бд
            disableFields();
            enableButtons();
            cancelButton.setEnabled(false);
            updateButton.setText("Правка");
            
            String name = (String) nameComboBox.getSelectedItem();
            String country = (String) countryComboBox.getSelectedItem();
            int numAirports = (int) numAirportsSpinner.getValue();
            int population = (int) populationSpinner.getValue();
            
            Locals locals = new Locals(name, country, numAirports, population);

            int selectedId = localsTable.getSelectedRow();
            int id = (int) localsTable.getValueAt(selectedId, 0);
            
            LocalsTable dao = new LocalsTable();
            dao.updateLocal(id, locals);
            updateUi();
            try {
                updateUpdateUI(selectedId);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка ввода данных, повторите заново");
            }
        } 
    }//GEN-LAST:event_updateButtonActionPerformed

    public void updateUpdateUI(int selectedId) throws SQLException {
        localsTable.clearSelection();
        localsTable.addRowSelectionInterval(selectedId, selectedId);
        updateRecordInForm();   
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
 
        if ("Добавить".equals(addButton.getText())) {
            enableFields();
            disableButtons();
            addButton.setEnabled(true);
            cancelButton.setEnabled(true);
            addButton.setText("Сохранить");
            if (tablePanel.isVisible()) {
            // отображаем запись
            tablePanel.setVisible(false);
            recordPanel.setVisible(true);
            
            }
            
        else {
            tablePanel.setVisible(false);
            recordPanel.setVisible(true);

            //addButton.setEnabled(true);
            updateButton.setEnabled(true);
            deleteButton.setEnabled(true);
        }
            
            // открываем кнопки
            addButton.setEnabled(true);
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
            try {
                    updateRecordInForm();
                } catch (SQLException ex) {
                    Logger.getLogger(LocalView.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else {
            // второй клик - собираем данные и сохраняем в бд
            disableFields();
            enableButtons();
            cancelButton.setEnabled(false);
            addButton.setText("Добавить");
            String name = "";
            String country = "";
            if (nameComboBox.isVisible() && countryComboBox.isVisible())
            {    
            name = (String) nameComboBox.getSelectedItem();
            country = (String) countryComboBox.getSelectedItem();
            }
            else
            {
            name = (String) newCity.getText();
            country = (String) newCountry.getText();
           
            String q1 = "insert into cities values ("+_count+",'"+country+"','"+name+"');";
            try { 
               PostgresDbAdapter.getAdapter().executeQuery(q1);   
            } catch (SQLException ex) {
                Logger.getLogger(LocalView.class.getName()).log(Level.SEVERE, null, ex);
            }
            nameComboBox.addItem(name);
            countryComboBox.addItem(country);
            nameComboBox.setVisible(true);
            countryComboBox.setVisible(true);  
            newCity.setVisible(false);
            newCountry.setVisible(false);
            newCityLabel.setVisible(false);
            newCountryLabel.setVisible(false);
             
            
            }
            
            int numAirports = (int) numAirportsSpinner.getValue();
            int population = (int) populationSpinner.getValue();
            
            Locals local = new Locals(name, country, numAirports, population);
            LocalsTable dao = new LocalsTable();
            dao.addLocal(local);
            updateUi();
            try {
                selectLastRecord();
                updateRecordInForm();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка ввода данных, повторите заново");
            }
        }   
    }//GEN-LAST:event_addButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        int selectedIndex = localsTable.getSelectedRow();

        // не выделено ничего или первая запись
        if (selectedIndex == -1 || selectedIndex == 0) {
            return;
        }
         if (selectedIndex == 1)
        {
            firstButton.setEnabled(false);
            previousButton.setEnabled(false);
            
        }
            lastButton.setEnabled(true);
            nextButton.setEnabled(true);
        localsTable.clearSelection();
        localsTable.addRowSelectionInterval(selectedIndex-1, selectedIndex-1);

        try {
            updateRecordInForm();
        } catch (SQLException ex) {
            Logger.getLogger(LocalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    private void lastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonActionPerformed
        localsTable.clearSelection();
        localsTable.addRowSelectionInterval(localsTable.getRowCount()-1, localsTable.getRowCount()-1);
        try {
            updateRecordInForm();
        } catch (SQLException ex) {
            Logger.getLogger(LocalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        lastButton.setEnabled(false);
        nextButton.setEnabled(false);
        firstButton.setEnabled(true);
        previousButton.setEnabled(true);
    }//GEN-LAST:event_lastButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        int selectedIndex = localsTable.getSelectedRow();

        // не выделено ничего или последняя запись
        if (selectedIndex == -1 || selectedIndex+1 == localsTable.getRowCount()) {
            return;
        }
         if (selectedIndex+1 == localsTable.getRowCount()-1)
        {
            lastButton.setEnabled(false);
            nextButton.setEnabled(false);
            
        }
            firstButton.setEnabled(true);
            previousButton.setEnabled(true);
        localsTable.clearSelection();
        localsTable.addRowSelectionInterval(selectedIndex+1, selectedIndex+1);

        try {
            updateRecordInForm();
        } catch (SQLException ex) {
            Logger.getLogger(LocalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void firstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstButtonActionPerformed
        localsTable.clearSelection();
        localsTable.addRowSelectionInterval(0, 0);
        try {
            updateRecordInForm();
        } catch (SQLException ex) {
            Logger.getLogger(LocalView.class.getName()).log(Level.SEVERE, null, ex);
        }
         firstButton.setEnabled(false);
        previousButton.setEnabled(false);
        lastButton.setEnabled(true);
        nextButton.setEnabled(true);
    }//GEN-LAST:event_firstButtonActionPerformed

    private void changeViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeViewButtonActionPerformed
        try {
            updateRecordInForm();
        } catch (SQLException ex) {
            Logger.getLogger(LocalView.class.getName()).log(Level.SEVERE, null, ex);
        }

        // вид таблицы
        if (tablePanel.isVisible()) {
            // отображаем запись
            tablePanel.setVisible(false);
            recordPanel.setVisible(true);

            // открываем кнопки
            addButton.setEnabled(true);
            updateButton.setEnabled(true);
        }
        else {
            tablePanel.setVisible(true);
            recordPanel.setVisible(false);

            //addButton.setEnabled(false);
            //updateButton.setEnabled(false);
        }
    }//GEN-LAST:event_changeViewButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        //addButton.setEnabled(false);
        //updateButton.setEnabled(false);
        cancelButton.setEnabled(false);
        addButton.setText("Добавить");
        updateButton.setText("Правка");
        enableButtons();
        disableFields();
        
        try {
            updateRecordInForm();
            newCityLabel.setVisible(false);
        newCity.setVisible(false);
        newCountryLabel.setVisible(false);
        newCountry.setVisible(false);
        nameComboBox.setVisible(true);
        countryComboBox.setVisible(true);
        jLabel1.setVisible(true);
        jLabel3.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(LocalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void countryComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_countryComboBoxItemStateChanged

    }//GEN-LAST:event_countryComboBoxItemStateChanged

    private void countryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryComboBoxActionPerformed
        // TODO add your handling code here:
        nameComboBox.removeAllItems();
        String coname;
        coname = (String)countryComboBox.getSelectedItem();
        String q = "select count(*) from cities";
        String q1 = "select id,name from locals where country='"+coname+"';";
        try {
            ResultSet set = PostgresDbAdapter.getAdapter().executeQueryWithResult(q);
            ResultSet set1 = PostgresDbAdapter.getAdapter().executeQueryWithResult(q1);
            while(set.next())
                  { 
                  _count = set.getInt("count")+1;
                  }
                  while(set1.next())
                  { 
                  String code=set1.getString("name");
                  nameComboBox.addItem(code);
                  }
        } catch (SQLException ex) {
            Logger.getLogger(LocalView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_countryComboBoxActionPerformed

    private void newCityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCityButtonActionPerformed
        // TODO add your handling code here:
        newCityLabel.setVisible(true);
        newCity.setVisible(true);
        newCountryLabel.setVisible(true);
        newCountry.setVisible(true);
        nameComboBox.setVisible(false);
        countryComboBox.setVisible(false);
        jLabel1.setVisible(false);
        jLabel3.setVisible(false);
    }//GEN-LAST:event_newCityButtonActionPerformed

    private void newCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newCountryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        LocalView locals = new LocalView();
        locals.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(LocalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new LocalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton changeViewButton;
    private javax.swing.JComboBox<String> countryComboBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton firstButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton lastButton;
    private javax.swing.JTable localsTable;
    private javax.swing.JComboBox<String> nameComboBox;
    private javax.swing.JTextField newCity;
    private javax.swing.JButton newCityButton;
    private javax.swing.JLabel newCityLabel;
    private javax.swing.JTextField newCountry;
    private javax.swing.JLabel newCountryLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JSpinner numAirportsSpinner;
    private javax.swing.JSpinner populationSpinner;
    private javax.swing.JButton previousButton;
    private javax.swing.JPanel recordPanel;
    private javax.swing.JScrollPane tablePanel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
