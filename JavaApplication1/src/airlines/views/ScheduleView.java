package airlines.views;

//import airlines.View;
import airlines.structure.Airlines;
import airlines.structure.Locals;
import airlines.structure.Weeks;
import airlines.tables.AirlinesTable;
import airlines.tables.LocalsTable;
import airlines.tables.ScheduleTable;
import airlines.tables.WeeksTable;
import airlines.views.structure.ScheduleConstruct;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Editions.PostgresDbAdapter;
import airlines.queries.Quiery1;
import airlines.queries.Quiery2;
import airlines.queries.Quiery3;
import airlines.structure.Schedule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.TableModel;

public class ScheduleView extends javax.swing.JFrame {
    private final ScheduleConstruct model;
    public int num;
    public void set_num(int num)
    {
        this.num = num;
    }
    public int get_num()
    {
        return num;
    }
    
    public ScheduleView() {
        initComponents();
        model = new ScheduleConstruct();
        schedulesTable.setModel(model);
        schedulesTable.addRowSelectionInterval(0, 0);
        recordPanel.setVisible(false);   
    }
    
    public void updateUi() {
        schedulesTable.updateUI();
        model.updateScheduleList();
    }
    
    private void updateRecords() {
        int selectedId = schedulesTable.getSelectedRow();
        
        int flightNumber = (int) schedulesTable.getValueAt(selectedId, 0);
        String week = (String) schedulesTable.getValueAt(selectedId, 1); 
        String idDeparture = (String) schedulesTable.getValueAt(selectedId, 2); 
        String departure = (String) schedulesTable.getValueAt(selectedId, 3);
        String idArrival = (String) schedulesTable.getValueAt(selectedId, 4);
        String arrival = (String) schedulesTable.getValueAt(selectedId, 5);
        String typeAir = (String) schedulesTable.getValueAt(selectedId, 6);
        int capacity = (int) schedulesTable.getValueAt(selectedId, 7);
        int price = (int) schedulesTable.getValueAt(selectedId, 8);
        String idAirline = (String) schedulesTable.getValueAt(selectedId, 9);

        List<Locals> locals = new LocalsTable().getLocal();
        for (Locals c : locals) {
            iddepartureComboBox.addItem(c.getName());
            idarrivalComboBox.addItem(c.getName());
        }
                    int Departure = 0;
        int Arrival= 0;
        int Airline= 0;
        String queryIdDeparture = "SELECT id FROM locals WHERE name = '" + idDeparture + "';";
        String queryIdArrival = "SELECT id FROM locals WHERE name = '" + idArrival + "';";  
        String queryIdAirline = "SELECT id FROM airlines WHERE name = '" + idAirline + "';";  
        try {
            ResultSet departureSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdDeparture);
            ResultSet arrivalSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdArrival);
            ResultSet airlineSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdAirline);
            departureSet.next();
            arrivalSet.next();
            airlineSet.next();
            Departure = departureSet.getInt("id");
            Arrival = arrivalSet.getInt("id");
            Airline = airlineSet.getInt("id");
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                   
                    iddepartureComboBox.setSelectedIndex(Integer.valueOf(Departure) - 1);
                    idarrivalComboBox.setSelectedIndex(Integer.valueOf(Arrival) - 1);
                   
        List<Weeks> weeks = new WeeksTable().getWeek();
        for (Weeks w: weeks){
            weekComboBox.addItem(w.getWeek());
        }
            String query2 = "SELECT id, weeks FROM week where weeks = '" + week +"';";
            ResultSet set2;
            try {
                set2 = PostgresDbAdapter.getAdapter().executeQueryWithResult(query2);
                    while (set2.next()) {
                    int id_c = set2.getInt("id")-1;
                    weekComboBox.setSelectedIndex(id_c);
                    }
                 
            } catch (SQLException ex) {
                Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
            }
        List<Airlines> airlines = new AirlinesTable().getAirlines();
        for (Airlines a: airlines){
            idAirlineComboBox.addItem(a.getName());
        }
        String query3 = "SELECT id, name FROM airlines where id = '" + String.valueOf(Airline) +"';";
            ResultSet set3;
            try {
                set3 = PostgresDbAdapter.getAdapter().executeQueryWithResult(query3);
                    while (set3.next()) {
                    int id_c = set3.getInt("id")-1;
                    idAirlineComboBox.setSelectedIndex(id_c);
                    }
                 
            } catch (SQLException ex) {
                Logger.getLogger(ScheduleView.class.getName()).log(Level.SEVERE, null, ex);
            }
        flightNumberSpinner.setValue(flightNumber);
        weekComboBox.setSelectedItem(week);
        iddepartureComboBox.setSelectedItem(idDeparture);
        departureField.setText(departure);
        idarrivalComboBox.setSelectedItem(idArrival);
        arrivalField.setText(arrival);
        typeAirField.setText(typeAir);
        capacitySpinner.setValue(capacity);
        priceSpinner.setValue(price);
        idAirlineComboBox.setSelectedItem(idAirline);

    }
    
    public void selectLastRecord() {
        schedulesTable.clearSelection();
        schedulesTable.addRowSelectionInterval(schedulesTable.getRowCount()-1, schedulesTable.getRowCount()-1);
        updateRecords();   
        lastButton.setEnabled(false);
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
        flightNumberSpinner.setEnabled(false);
        weekComboBox.setEnabled(true);
        departureField.setEnabled(true);
        iddepartureComboBox.setEnabled(true);
        arrivalField.setEnabled(true);
        idarrivalComboBox.setEnabled(true);
        typeAirField.setEnabled(true);
        capacitySpinner.setEnabled(true);
        priceSpinner.setEnabled(true);
        idAirlineComboBox.setEnabled(true);
        
    }
    
    private void disableFields() {
        flightNumberSpinner.setEnabled(false);
        weekComboBox.setEnabled(false);
        departureField.setEnabled(false);
        iddepartureComboBox.setEnabled(false);
        arrivalField.setEnabled(false);
        idarrivalComboBox.setEnabled(false);
        typeAirField.setEnabled(false);
        capacitySpinner.setEnabled(false);
        priceSpinner.setEnabled(false);
        idAirlineComboBox.setEnabled(false);
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        airPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("airPU").createEntityManager();
        weekQuery = java.beans.Beans.isDesignTime() ? null : airPUEntityManager.createQuery("SELECT w FROM Week w");
        weekList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : weekQuery.getResultList();
        tablePanel = new javax.swing.JScrollPane();
        schedulesTable = new javax.swing.JTable();
        buttonPanel = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        firstButton = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();
        changeViewButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        recordPanel = new javax.swing.JPanel();
        capacitySpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        departureField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        arrivalField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idAirlineComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        iddepartureComboBox = new javax.swing.JComboBox();
        idarrivalComboBox = new javax.swing.JComboBox();
        typeAirField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        priceSpinner = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        weekComboBox = new javax.swing.JComboBox();
        flightNumberSpinner = new javax.swing.JSpinner();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Расписание самолетов");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        schedulesTable.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        schedulesTable.setModel(schedulesTable.getModel());
        tablePanel.setViewportView(schedulesTable);
        schedulesTable.getAccessibleContext().setAccessibleName("");

        getContentPane().add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 690, 390));

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

        lastButton.setText(">>|");
        lastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastButtonActionPerformed(evt);
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
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addComponent(firstButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changeViewButton)
                            .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addComponent(previousButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastButton))))
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(updateButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousButton)
                    .addComponent(nextButton)
                    .addComponent(firstButton)
                    .addComponent(lastButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeViewButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 230, 180));

        capacitySpinner.setEnabled(false);

        jLabel1.setText("Номер рейса");

        departureField.setEnabled(false);

        jLabel2.setText("День недели");

        arrivalField.setEnabled(false);

        jLabel3.setText("Время вылета");

        jLabel4.setText("Время прибытия");

        jLabel5.setText("Тип самолета");

        idAirlineComboBox.setEnabled(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, idAirlineComboBox, org.jdesktop.beansbinding.ObjectProperty.create(), idAirlineComboBox, org.jdesktop.beansbinding.BeanProperty.create("elements"));
        bindingGroup.addBinding(binding);

        jLabel6.setText("Вместимость");

        jLabel9.setText("Пункт отправления");

        jLabel10.setText("Пункт назначения");

        iddepartureComboBox.setEnabled(false);

        idarrivalComboBox.setEnabled(false);

        typeAirField.setText("jTextField1");
        typeAirField.setEnabled(false);

        jLabel7.setText("Стоимость билета");

        priceSpinner.setEnabled(false);

        jLabel11.setText("Код авиакомпании");

        weekComboBox.setEnabled(false);

        flightNumberSpinner.setEnabled(false);

        javax.swing.GroupLayout recordPanelLayout = new javax.swing.GroupLayout(recordPanel);
        recordPanel.setLayout(recordPanelLayout);
        recordPanelLayout.setHorizontalGroup(
            recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recordPanelLayout.createSequentialGroup()
                        .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weekComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(recordPanelLayout.createSequentialGroup()
                                .addComponent(flightNumberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recordPanelLayout.createSequentialGroup()
                        .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(recordPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(67, 67, 67))
                                .addGroup(recordPanelLayout.createSequentialGroup()
                                    .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(recordPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addGap(23, 23, 23))
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(recordPanelLayout.createSequentialGroup()
                                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)))
                        .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idAirlineComboBox, 0, 189, Short.MAX_VALUE)
                            .addComponent(iddepartureComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(departureField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceSpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(capacitySpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(typeAirField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(arrivalField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idarrivalComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(149, 149, 149))
        );
        recordPanelLayout.setVerticalGroup(
            recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(flightNumberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(weekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iddepartureComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(departureField)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(idarrivalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(arrivalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(typeAirField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(capacitySpinner)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceSpinner))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(recordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idAirlineComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        getContentPane().add(recordPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 20, 440, -1));

        jMenu3.setText("Запросы");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });

        jMenuItem1.setText("Выдать список населенных пунктов, откуда отправляются самолеты авиакомпании «Аэрофлот» ");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Выдать список авиакомпаний, которые обслуживают, по меньшей мере, хотя бы один рейс, вылетающий в дневное время (от 12 до 17 часов)");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Для Москвы выдать количество авиарейсов, связанных с этим городом (считать только рейсы отправления)  ");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //View mainFrame = new View();
        //mainFrame.setVisible(true);
        
    }//GEN-LAST:event_formWindowClosing

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Вы хотите удалить выделенные записи?", "Внимание", dialogButton);
        
        if(dialogResult == JOptionPane.YES_OPTION) {
            int[] selectedRowIds = schedulesTable.getSelectedRows();
            ScheduleTable dao = new ScheduleTable();
            for (int i : selectedRowIds) {
                int selectedId = (int) schedulesTable.getValueAt(i, 0);
                dao.removeSchedule(selectedId);
            }
            
            updateUi();
        }
        
        schedulesTable.addRowSelectionInterval(0, 0);
        updateRecords();
    }//GEN-LAST:event_deleteButtonActionPerformed

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

                addButton.setEnabled(true);
                updateButton.setEnabled(true);
            }
            else {
                //tablePanel.setVisible(true);
                recordPanel.setVisible(true);

                //addButton.setEnabled(false);
                //updateButton.setEnabled(false);
            }
        }
        else {
        
            disableFields();
            enableButtons();
            cancelButton.setEnabled(false);
            updateButton.setText("Правка");
            
            int flightNumber = (int) flightNumberSpinner.getValue();
            String week = (String) weekComboBox.getSelectedItem();
            String departure = (String) departureField.getText();
            String idDeparture = (String) iddepartureComboBox.getSelectedItem();
            String arrival = (String) arrivalField.getText();
            String idArrival = (String) idarrivalComboBox.getSelectedItem();
            String typeAir = (String) typeAirField.getText();
            int capacity = (int) capacitySpinner.getValue();
            int price = (int) priceSpinner.getValue();
            String idAirline = (String) idAirlineComboBox.getSelectedItem();           

            Schedule schedule = new Schedule(
                    flightNumber, 
                    week, 
                    idDeparture,
                    departure,
                    idArrival,
                    arrival,
                    typeAir,
                    capacity, 
                    price,
                    idAirline);
            
            int selectedId = schedulesTable.getSelectedRow();
            int id = (int) schedulesTable.getValueAt(selectedId, 0);
            
            ScheduleTable dao = new ScheduleTable();
            dao.updateScedule(id, schedule);
            updateUi();
            updateUpdateUI(selectedId);
        }   
    }//GEN-LAST:event_updateButtonActionPerformed

    public void updateUpdateUI(int selectedId) {
        schedulesTable.clearSelection();
        schedulesTable.addRowSelectionInterval(selectedId, selectedId);
        updateRecords();   
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        if ("Добавить".equals(addButton.getText())) {
            enableFields();
            disableButtons();
            addButton.setEnabled(true);
            cancelButton.setEnabled(true);
            addButton.setText("Сохранить");
                    if (tablePanel.isVisible()) {
                    tablePanel.setVisible(false);
                    recordPanel.setVisible(true);

                    addButton.setEnabled(true);
                    updateButton.setEnabled(true);
                }
                else {
                  tablePanel.setVisible(false);
            recordPanel.setVisible(true);

            //addButton.setEnabled(true);
            updateButton.setEnabled(true);
            deleteButton.setEnabled(true);
                }
            
            
            flightNumberSpinner.setValue(schedulesTable.getRowCount()+1);
            weekComboBox.setSelectedItem("");
            iddepartureComboBox.setSelectedItem("");
            departureField.setText("");
            idarrivalComboBox.setSelectedItem("");
            arrivalField.setText("");
            typeAirField.setText("");
            capacitySpinner.setValue(0);
            priceSpinner.setValue(0);
            idAirlineComboBox.setSelectedItem("");
            
            List<Locals> locals = new LocalsTable().getLocal();
                for (Locals c : locals) {
                    iddepartureComboBox.addItem(c.getName());
                    idarrivalComboBox.addItem(c.getName());
                }
        
                List<Weeks> weeks = new WeeksTable().getWeek();
                for (Weeks w: weeks){
                    weekComboBox.addItem(w.getWeek());
                }
            
                List<Airlines> airlines = new AirlinesTable().getAirlines();
                for (Airlines a: airlines){
                    idAirlineComboBox.addItem(a.getName());
                }
        
        }
        else {
            disableFields();
            enableButtons();
            cancelButton.setEnabled(false);
            addButton.setText("Добавить");
            
            int flightNumber = (int) flightNumberSpinner.getValue();
            String week = (String) weekComboBox.getSelectedItem();
            String idDeparture = (String) iddepartureComboBox.getSelectedItem();
            String departure = departureField.getText();
            String idArrival = (String) idarrivalComboBox.getSelectedItem();
            String arrival = arrivalField.getText();
            String typeAir = typeAirField.getText();
            int capacity = (int) capacitySpinner.getValue();
            int price = (int) priceSpinner.getValue();
            String idAirline = (String) idAirlineComboBox.getSelectedItem();
            

            Schedule schedule = new Schedule(
                    flightNumber, 
                    week, 
                    idDeparture,
                    departure,
                    idArrival,
                    arrival,
                    typeAir,
                    capacity, 
                    price,
                    idAirline);
            
            ScheduleTable dao = new ScheduleTable();
            dao.addSchedule(schedule);
            updateUi();
            selectLastRecord();
        }   
    }//GEN-LAST:event_addButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        int selectedIndex = schedulesTable.getSelectedRow();
        nextButton.setEnabled(true);
        lastButton.setEnabled(true);
        if (selectedIndex == -1 || selectedIndex == 0) {
            return;
        }
         if (selectedIndex == 1)
        {
            firstButton.setEnabled(false);
            previousButton.setEnabled(false);
        }

        schedulesTable.clearSelection();
        schedulesTable.addRowSelectionInterval(selectedIndex-1, selectedIndex-1);

        updateRecords();
    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        int selectedIndex = schedulesTable.getSelectedRow();
        previousButton.setEnabled(true);
        firstButton.setEnabled(true);
        if (selectedIndex == -1 || selectedIndex+1 == schedulesTable.getRowCount()) {
            return;
        }
         if (selectedIndex+1 == schedulesTable.getRowCount()-1)
        {
            lastButton.setEnabled(false);
            nextButton.setEnabled(false);
        }

        schedulesTable.clearSelection();
        schedulesTable.addRowSelectionInterval(selectedIndex+1, selectedIndex+1);

        updateRecords();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void firstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstButtonActionPerformed
        schedulesTable.clearSelection();
        schedulesTable.addRowSelectionInterval(0, 0);
        updateRecords();
         firstButton.setEnabled(false);
        previousButton.setEnabled(false);
        lastButton.setEnabled(true);
        nextButton.setEnabled(true);
    }//GEN-LAST:event_firstButtonActionPerformed

    private void lastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonActionPerformed
        schedulesTable.clearSelection();
        schedulesTable.addRowSelectionInterval(schedulesTable.getRowCount()-1, schedulesTable.getRowCount()-1);
        updateRecords();
       
        lastButton.setEnabled(false);
        nextButton.setEnabled(false);
        firstButton.setEnabled(true);
        previousButton.setEnabled(true);
    }//GEN-LAST:event_lastButtonActionPerformed

    private void changeViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeViewButtonActionPerformed
        updateRecords();


        if (tablePanel.isVisible()) {
            tablePanel.setVisible(false);
            recordPanel.setVisible(true);

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
        addButton.setEnabled(true);
        updateButton.setEnabled(true);
        cancelButton.setEnabled(false);
        addButton.setText("Добавить");
        updateButton.setText("Правка");
        enableButtons();
        disableFields();
        updateRecords();
    }//GEN-LAST:event_cancelButtonActionPerformed

   
    
    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu3MousePressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(ScheduleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScheduleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScheduleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScheduleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ScheduleView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.persistence.EntityManager airPUEntityManager;
    private javax.swing.JTextField arrivalField;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JSpinner capacitySpinner;
    private javax.swing.JButton changeViewButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField departureField;
    private javax.swing.JButton firstButton;
    private javax.swing.JSpinner flightNumberSpinner;
    private javax.swing.JComboBox idAirlineComboBox;
    private javax.swing.JComboBox idarrivalComboBox;
    private javax.swing.JComboBox iddepartureComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JButton lastButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JSpinner priceSpinner;
    private javax.swing.JPanel recordPanel;
    private javax.swing.JTable schedulesTable;
    private javax.swing.JScrollPane tablePanel;
    private javax.swing.JTextField typeAirField;
    private javax.swing.JButton updateButton;
    private javax.swing.JComboBox weekComboBox;
    private java.util.List<airlines.views.Week> weekList;
    private javax.persistence.Query weekQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
