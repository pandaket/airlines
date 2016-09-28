package airlines.views.structure;

import airlines.structure.Airlines;
import airlines.tables.AirlinesTable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class AirlineConstruct implements TableModel {
    private List<Airlines> airlines;
    private Set<TableModelListener> listeners;
    private final AirlinesTable dao;
    
    public void updateAirlines() {
        airlines = dao.getAirlines();
    }
    
    public AirlineConstruct() {
        listeners = new HashSet<>();
        dao = new AirlinesTable();
        updateAirlines();
    }
    
    @Override
    public int getRowCount() {
        return airlines.size();
    }

    @Override
    public int getColumnCount() {
        return Airlines.getFieldCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Airlines film = airlines.get(rowIndex);
        return film.getField(columnIndex);
    }
        
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Airlines.getFieldClass(columnIndex);
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return Airlines.getFieldName(columnIndex);
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
