/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines.views.structure;

import airlines.structure.Weeks;
import airlines.tables.WeeksTable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Екатерина
 */
public class WeeksConstruct implements TableModel {
    private List<Weeks> weeks;
    private Set<TableModelListener> listeners;
    private final WeeksTable dao;
    
    public void updateWeekList() {
        weeks = dao.getWeek();
    }
    
    public WeeksConstruct() {
        listeners = new HashSet<>();
        dao = new WeeksTable();
        updateWeekList();
    }
    
    @Override
    public int getRowCount() {
        return weeks.size();
    }

    @Override
    public int getColumnCount() {
        return Weeks.getFieldCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Weeks week = weeks.get(rowIndex);
        return week.getField(columnIndex);
    }
        
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Weeks.getFieldClass(columnIndex);
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return Weeks.getFieldName(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }
}

