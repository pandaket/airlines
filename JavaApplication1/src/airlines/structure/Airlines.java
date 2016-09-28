package airlines.structure;

import java.util.Date;



public class Airlines {
    private int id;
    private String name;
    private Date dateCreation;
    private int numAircrafts;
    private String countryReg;
    
    private static String[] fieldNames = new String[] { "Код авиакомпании", "Наименование авиакомпании", "Дата создания", "Число самолетов", "Страна приписки" };
    
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
            case 2:
                return Date.class;
            case 3:
                return int.class;    
            case 4:
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
                return getName();
            case 2:
                return getDateCreation();
            case 3:
                return getNumAircraft();    
            case 4:
                return getCountryReg();     
            default:
                throw new IndexOutOfBoundsException();
        }
    }
    
    public Airlines(int id, String name, Date dateCreation, int numAircrafts, String countryReg) {
        this.id = id;
        this.name = name;
        this.dateCreation = dateCreation;
        this.numAircrafts = numAircrafts;
        this.countryReg = countryReg;
    }
    
    public Airlines(int id, String name, Date dateCreation, int numAircrafts) {
        this.id = id;
        this.name = name;
        this.dateCreation = dateCreation;
        this.numAircrafts = numAircrafts;
    }
    
    public Airlines(String name, Date dateCreation, int numAircrafts, String countryReg) {
        this.name = name;
        this.dateCreation = dateCreation;
        this.numAircrafts = numAircrafts;
        this.countryReg = countryReg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getNumAircraft() {
        return numAircrafts;
    }

    public void setNumAircraft(int numAircrafts) {
        this.numAircrafts = numAircrafts;
    }

    public String getCountryReg() {
        return countryReg;
    }

    public void setCountryReg(String countryReg) {
        this.countryReg = countryReg;
    }

}
