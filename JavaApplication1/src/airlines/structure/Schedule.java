package airlines.structure;

public class Schedule {
    private int flightNumber;
    private String week;
    private String iddeparture;
    private String idarrival;
    private String arrival;
    private String departure;
    private String typeAir;
    private int capacity;
    private int price;
    private String idAirline;
    
    private static String[] fieldNames = new String[] { "Номер рейса", 
                                                        "День недели", 
                                                        "Пункт отправления", 
                                                        "Время отправления", 
                                                        "Пункт прибытия",
                                                        "Время прибытия",
                                                        "Тип самолета",
                                                        "Вместимость",
                                                        "Стоимость билета",
                                                        "Код авиакомпании"
                                                         };
    
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
                return String.class;
            case 4:
                return String.class;    
            case 5:
                return String.class;     
            case 6:
                return String.class; 
            case 7:
                return int.class;
            case 8:
                return int.class;
            case 9:
                return String.class;
            default:
                throw new IndexOutOfBoundsException();
        }
    }
    
    public Object getField(int index) {
        switch (index) {
            case 0:
                return getFlightNumber();
            case 1:
                return getWeek();
            case 2:
                return getIdDeparture();
            case 3:
                return getDeparture();
            case 4:
                return getIdArrival();
            case 5:
                return getArrival();
            case 6:
                return getTypeAir();
            case 7:
                return getCapacity();
            case 8:
                return getPrice();  
            case 9:
                return getIdAirline();
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    public Schedule(int flightNumber, String week, String idDeparture, String departure, String idArrival, String arrival, String typeAir, int capacity, int price, String idAirline) {
        this.flightNumber = flightNumber;
        this.week = week;
        this.iddeparture = idDeparture;
        this.idarrival = idArrival;
        this.arrival = arrival;
        this.departure = departure;
        this.typeAir = typeAir;
        this.capacity = capacity;
        this.price = price;
        this.idAirline = idAirline;
        
    }
    public Schedule(String idDeparture) { 
        this.iddeparture = idDeparture; 
    }
    
    public Schedule(int flightNumber, String week, String idDeparture, String departure, String idArrival, String arrival, String typeAir, int capacity, int price) {
        this.flightNumber = flightNumber;
        this.week = week;
        this.iddeparture = idDeparture;
        this.departure = departure;
        this.idarrival = idArrival;
        this.arrival = arrival;
        this.typeAir = typeAir;
        this.capacity = capacity;
        this.price = price;
        
    }
    
    public Schedule(String week, String idDeparture, String departure, String idArrival, String arrival, String typeAir, int capacity, int price, String idAirline) {
        this.week = week;
        this.iddeparture = idDeparture;
        this.idarrival = idArrival;
        this.arrival = arrival;
        this.departure = departure;
        this.typeAir = typeAir;
        this.capacity = capacity;
        this.price = price;
        this.idAirline = idAirline;
    }
    
    public int getFlightNumber() {
        return flightNumber;
    }
    
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getIdDeparture() {
        return iddeparture;
    }

    public void setIdDeparture(String idDeparture) {
        this.iddeparture = idDeparture;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getIdArrival() {
        return idarrival;
    }

    public void setIdArrival(String idArrival) {
        this.idarrival = idArrival;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getTypeAir() {
        return typeAir;
    }

    public void setTypeAir(String typeAir) {
        this.typeAir = typeAir;
    }
    
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(String idAirline) {
        this.idAirline = idAirline;
    }
}
