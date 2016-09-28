/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines.structure;

/**
 *
 * @author Екатерина
 */
public class Weeks {
    
    private int id;
    private String week;
    
    
    private static String[] fieldNames = new String[] { "Код", "День недели" };
    
    public static String getFieldName(int index) {
        return fieldNames[index];
    }
    
    public static int getFieldCount() {
        return fieldNames.length;
    }
    
    public static Class<?> getFieldClass(int index) {
        switch (index) {
            case 0:
                return int.class;
            case 1:
                return String.class;
            
            default:
                throw new IndexOutOfBoundsException();
        }
    }
    
    public Object getField(int index) {
        switch (index) {
            case 0:
                return getId();
            case 1:
                return getWeek();
            
            default:
                throw new IndexOutOfBoundsException();
        }
    }
    
    public Weeks(int id, String week) {
        this.id = id;
        this.week = week;
        
    }
    
    public Weeks(String week) {
        this.week = week;
       
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    
    
}
