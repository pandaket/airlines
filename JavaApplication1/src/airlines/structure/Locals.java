package airlines.structure;



public class Locals {
    private int id;
    private String name;
    private String country;
    private int numAirports;
    private int population;
    
    private static String[] fieldNames = new String[] { "Код населенного пункта", "Наименование населенного пункта", "Государство", "Число аэропортов", "Численность населения" };
    
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
                return String.class;
            case 3:
                return int.class;    
            case 4:
                return int.class;     
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
                return getCountry();
            case 3:
                return getNumAirports();
            case 4:
                return getPopulation();   
            default:
                throw new IndexOutOfBoundsException();
        }
    }
    
    public Locals(int id, String name, String country,  int numAirports, int population) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.numAirports = numAirports;
        this.population = population;
    }
    
    public Locals(String name, String country,  int numAirports, int population) {
        this.name = name;
        this.country = country;
        this.numAirports = numAirports;
        this.population = population;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumAirports() {
        return numAirports;
    }
    
    public void setNumAirports(int numAirports) {
        this.numAirports = numAirports;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

}
