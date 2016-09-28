package airlines.tables;

import Editions.PostgresDbAdapter;
import airlines.structure.Schedule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ScheduleTable {    
    
    
    public List<Schedule> getSchedule() {
        List<Schedule> schedules = new ArrayList<>();
        try {
            ResultSet set = PostgresDbAdapter.getAdapter().executeQueryWithResult("SELECT * FROM schedule order by flight_number asc;");
            while (set.next()) {
                int flightNumber = set.getInt("flight_number");
                String week = set.getString("week");
                String idDeparture = set.getString("id_departure");
                String departure = set.getString("departure");
                String idArrival = set.getString("id_arrival");
                String arrival = set.getString("arrival");
                String typeAir = set.getString("air_type");
                int capacity = set.getInt("capacity");
                int price = set.getInt("price");
                String idAirline = set.getString("id_airline");
                String Departure="";
        String Arrival="";
        String Airline="";
        String queryIdDeparture = "SELECT name FROM locals WHERE id = " + idDeparture + ";";
        String queryIdArrival = "SELECT name FROM locals WHERE id = " + idArrival + ";";  
        String queryIdAirline = "SELECT name FROM airlines WHERE id = " + idAirline + ";";  
        //String queryIdWeek = "SELECT id FROM week WHERE weeks = '" + week + "';";
        
        try {
            ResultSet departureSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdDeparture);
            ResultSet arrivalSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdArrival);
            ResultSet airlineSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdAirline);
            
            departureSet.next();
            arrivalSet.next();
            airlineSet.next();
            Departure = departureSet.getString("name");
            Arrival = arrivalSet.getString("name");
            Airline = airlineSet.getString("name");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                
                Schedule schedule = new Schedule(
                                                                flightNumber,
                                                                week, 
                                                                Departure, 
                                                                departure, 
                                                                Arrival,
                                                                arrival,
                                                                typeAir,
                                                                capacity,
                                                                price,
                                                                Airline);
                schedules.add(schedule);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

        return schedules;
    }

    public void addSchedule(Schedule schedule) {
        int flightNumber = schedule.getFlightNumber();
        String week = schedule.getWeek();
        String idDeparture = schedule.getIdDeparture();
        String departure = schedule.getDeparture();
        String arrival = schedule.getArrival();
        String idArrival = schedule.getIdArrival();
        String typeAir = schedule.getTypeAir();
        int capacity = schedule.getCapacity();
        int price = schedule.getPrice();
        String idAirline = schedule.getIdAirline();
        
        int Departure = 0;
        int Arrival= 0;
        int Airline = 0;
        String queryIdDeparture = "SELECT id FROM locals WHERE name = '" + idDeparture + "';";
        String queryIdArrival = "SELECT id FROM locals WHERE name = '" + idArrival + "';";  
        String queryIdAirline = "SELECT id FROM airlines WHERE name = '" + idAirline + "';";  
        //String queryIdWeek = "SELECT id FROM week WHERE weeks = '" + week + "';";
        
        try {
            ResultSet departureSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdDeparture);
            ResultSet arrivalSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdArrival);
            ResultSet airlineSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdAirline);
            
            departureSet.next();
            arrivalSet.next();
            airlineSet.next();
            Departure = departureSet.getInt("id");
            Arrival = arrivalSet.getInt("id");
            Airline = airlineSet.getInt("id");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        String query = "INSERT INTO schedule("
                + "flight_number, "
                + "week, "
                + "id_departure, "
                + "departure, "
                + "id_arrival, "
                + "arrival, "
                + "air_type, "
                + "capacity, "
                + "price, "
                + "id_airline"
                + ") VALUES ("
                + "'" + flightNumber + "', "
                + "'" + week + "', "
                + Departure + ", "
                + "'" + departure + "', "
                + Arrival + ", "
                + "'" + arrival + "', "
                + "'" + typeAir + "', "
                + capacity + ", "
                + price + ", "
                + Airline + ");";
        
        try {
            PostgresDbAdapter.getAdapter().executeQuery(query);
        } catch (SQLException ex) {
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Вы неверно ввели данные. Осуществите ввод заново!");
        }
    }

    public void removeSchedule(int flightNumber) {
        String query = "DELETE FROM schedule WHERE flight_number = " + flightNumber + ";";
   
        try {
            PostgresDbAdapter.getAdapter().executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateScedule(int flightNumber, Schedule updatedSchedule) {
        String week = updatedSchedule.getWeek();
        String idDeparture = updatedSchedule.getIdDeparture();
        String departure = updatedSchedule.getDeparture();
        String idArrival = updatedSchedule.getIdArrival();
        String arrival = updatedSchedule.getArrival();
        String typeAir = updatedSchedule.getTypeAir();
        int capacity = updatedSchedule.getCapacity();
        int price = updatedSchedule.getPrice();
        String idAirline = updatedSchedule.getIdAirline();
        
        int Departure = 0;
        int Arrival= 0;
        int Airline = 0;
        String queryIdDeparture = "SELECT id FROM locals WHERE name = '" + idDeparture + "';";
        String queryIdArrival = "SELECT id FROM locals WHERE name = '" + idArrival + "';";  
        String queryIdAirline = "SELECT id FROM airlines WHERE name = '" + idAirline + "';";  
        //String queryIdWeek = "SELECT id FROM week WHERE weeks = '" + week + "';";
        
        try {
            ResultSet departureSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdDeparture);
            ResultSet arrivalSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdArrival);
            ResultSet airlineSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdAirline);
            
            departureSet.next();
            arrivalSet.next();
            airlineSet.next();
            Departure = departureSet.getInt("id");
            Arrival = arrivalSet.getInt("id");
            Airline = airlineSet.getInt("id");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        String query = "UPDATE schedule SET ("
                + "week, "
                + "id_departure, "
                + "departure, "
                + "id_arrival, "
                + "arrival, "
                + "air_type, "
                + "capacity, "
                + "price, "
                + "id_airline"
                + ") = ("
                + "'" + week + "', "
                + Departure + ", "
                + "'" + departure + "', "
                + Arrival + ", "
                + "'" + arrival + "', "
                + "'" + typeAir + "', "
                + capacity + ", "
                + price + ", "
                + Airline
                + ") WHERE flight_number = '" + flightNumber + "';";
   
        try {
            PostgresDbAdapter.getAdapter().executeQuery(query);
        } catch (SQLException ex) {
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Вы неверно ввели данные. Осуществите ввод заново!");
        }
    }
}
