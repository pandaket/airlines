package airlines.views.structure;

import airlines.structure.Locals;
import airlines.tables.LocalsTable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class LocalConstruct implements TableModel {
    private List<Locals> locals;
    private Set<TableModelListener> listeners;
    private final LocalsTable dao;
    
    public void updateLocalList() {
        locals = dao.getLocal();
    }
    
    public LocalConstruct() {
        listeners = new HashSet<>();
        dao = new LocalsTable();
        updateLocalList();
    }
    
    @Override
    public int getRowCount() {
        return locals.size();
    }

    @Override
    public int getColumnCount() {
        return Locals.getFieldCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Locals local = locals.get(rowIndex);
        return local.getField(columnIndex);
    }
        
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Locals.getFieldClass(columnIndex);
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return Locals.getFieldName(columnIndex);
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
