package airlines.tables;

import Editions.PostgresDbAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import airlines.structure.Locals;

import java.util.ArrayList;
import java.util.List;


public class LocalsTable {    
    
       
    public List<Locals> getLocal() {
        List<Locals> locals = new ArrayList<>();
        try {
            ResultSet set = PostgresDbAdapter.getAdapter().executeQueryWithResult("SELECT * FROM locals;");
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String country = set.getString("country");
                int numAirports = set.getInt("numAirports");
                int population = set.getInt("population");

                Locals local = new Locals(id, name, country, numAirports, population );
                locals.add(local);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return locals;
    }

    public void addLocal(Locals local) {
        String name = local.getName();
        String country = local.getCountry();
        int numAirports = local.getNumAirports();
        int population = local.getPopulation();
        String Country = "";
        String Name= "";
        int Count=0;
        
        String queryIdDeparture = "SELECT country FROM cities WHERE country = '" + country + "';";
        String queryIdArrival = "SELECT name FROM cities WHERE name = '" + name + "';";  
        String queryCount = "SELECT count(*) FROM locals;";  
         
        //String queryIdWeek = "SELECT id FROM week WHERE weeks = '" + week + "';";
        
        try {
            ResultSet departureSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdDeparture);
            ResultSet arrivalSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdArrival);
            ResultSet countSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryCount);
            while(departureSet.next()){
                Country = departureSet.getString("country");
            }
            while(arrivalSet.next()){
                Name = arrivalSet.getString("name");
            }
            while (countSet.next()){
            Count = countSet.getInt("count")+1;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
        String query = "INSERT INTO locals(id, name,country,numAirports,population) VALUES ("+Count+",'" + Name + "', '" + Country + "', "+ numAirports + ", "+ population + ");";
   
        try {
            PostgresDbAdapter.getAdapter().executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeLocal(int id) {
        String query = "DELETE FROM locals WHERE id = " + id + ";";
   
        try {
            PostgresDbAdapter.getAdapter().executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateLocal(int id, Locals updateLocal) {
        String name = updateLocal.getName();
        String country = updateLocal.getCountry();
        int numAirports = updateLocal.getNumAirports();
        int population = updateLocal.getPopulation();
        String Country = "";
        String Name= "";
        
        String queryIdDeparture = "SELECT country FROM locals WHERE country = '" + country + "';";
        String queryIdArrival = "SELECT name FROM locals WHERE name = '" + name + "';";  
         
        //String queryIdWeek = "SELECT id FROM week WHERE weeks = '" + week + "';";
        
        try {
            ResultSet departureSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdDeparture);
            ResultSet arrivalSet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryIdArrival);
            
            departureSet.next();
            arrivalSet.next();
            
            Country = departureSet.getString("country");
            Name = arrivalSet.getString("name");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
        String query = "UPDATE locals SET (name, country, numAirports, population) = ('" + Name + "', '" + Country + "', "+ numAirports + ", "+ population +  ") WHERE id = " + id + ";";
   
        try {
            PostgresDbAdapter.getAdapter().executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
