package airlines.views.structure;

import airlines.structure.Schedule;
import airlines.tables.ScheduleTable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ScheduleConstruct implements TableModel {
    private List<Schedule> schedule;
    private Set<TableModelListener> listeners;
    private final ScheduleTable dao;
    
    public void updateScheduleList() {
        schedule = dao.getSchedule();
    }
    
    public ScheduleConstruct() {
        listeners = new HashSet<>();
        dao = new ScheduleTable();
        updateScheduleList();
    }
    
    @Override
    public int getRowCount() {
        return schedule.size();
    }

    @Override
    public int getColumnCount() {
        return Schedule.getFieldCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Schedule schedules = schedule.get(rowIndex);
        return schedules.getField(columnIndex);
    }
        
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Schedule.getFieldClass(columnIndex);
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return Schedule.getFieldName(columnIndex);
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
