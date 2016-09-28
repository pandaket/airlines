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
public class Country {
    
    private int id;
    private String country;
    private String city;
    
    
    private static String[] fieldNames = new String[] { "Код", "Страна" };
    
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
                return getCountry();
            
            default:
                throw new IndexOutOfBoundsException();
        }
    }
    
    public Country(int id, String country) {
        this.id = id;
        this.country = country;
        
    }
    
    public Country(String country) {
        this.country = country;
       
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }
    
    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    
    
}
