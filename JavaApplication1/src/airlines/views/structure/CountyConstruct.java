/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines.views.structure;

import airlines.structure.Country;
import airlines.tables.CountryTable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Екатерина
 */
public class CountyConstruct implements TableModel {
    private List<Country> country;
    private Set<TableModelListener> listeners;
    private final CountryTable dao;
    
    public void updateCountryList() {
        country = dao.getCountry();
    }
    
    public CountyConstruct() {
        listeners = new HashSet<>();
        dao = new CountryTable();
        updateCountryList();
    }
    
    @Override
    public int getRowCount() {
        return country.size();
    }

    @Override
    public int getColumnCount() {
        return Country.getFieldCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Country countries = country.get(rowIndex);
        return countries.getField(columnIndex);
    }
        
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Country.getFieldClass(columnIndex);
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return Country.getFieldName(columnIndex);
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

