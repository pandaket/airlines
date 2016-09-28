package airlines.tables;

import Editions.PostgresDbAdapter;
import airlines.structure.Airlines;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;


public class AirlinesTable {    
    
    public List<Airlines> getAirlines() {
        List<Airlines> airlines = new ArrayList<>();
        try {
            ResultSet set = PostgresDbAdapter.getAdapter().executeQueryWithResult("SELECT * FROM airlines");
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                Date dateCreation = set.getDate("dateCreation");
                int numAircrafts = set.getInt("numAircrafts");
                String countryReg = set.getString("countryReg");
                
                Airlines airline = new Airlines(id, name, dateCreation, numAircrafts, countryReg);
                airlines.add(airline);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return airlines;
    }

    public void addAirline(Airlines airline) throws SQLException {
        int id = airline.getId();
        String name = airline.getName();
        Date dateCreation = airline.getDateCreation();
        int numAircrafts = airline.getNumAircraft();
        String countryReg = airline.getCountryReg();
        
        int Country = 0;
        String queryCountry = "SELECT id FROM airlines WHERE countryreg = '" + countryReg + "';";
        ResultSet countrySet = PostgresDbAdapter.getAdapter().executeQueryWithResult(queryCountry);
        countrySet.next();
        Country = countrySet.getInt("id");
        String query = "INSERT INTO airlines("
                + "id,"
                + "name, "
                + "datecreation, "
                + "numaircrafts, "
                + "countryreg "
                + ") VALUES ("
                + "" + id + ", "
                + "'" + name + "', "
                + "'" + dateCreation + "', "
                + "" + numAircrafts + ", "
                + "'" + countryReg + "');";
   
        try {
            PostgresDbAdapter.getAdapter().executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeAirline(int id) {
        String query = "DELETE FROM airlines WHERE id = " + id + ";";
   
        try {
            PostgresDbAdapter.getAdapter().executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateAirline(int id, Airlines alterAirline) {
        int id_new = alterAirline.getId();
        String name = alterAirline.getName();
        Date dateCreation = alterAirline.getDateCreation();
        int numAircrafts = alterAirline.getNumAircraft();
        String countryReg = alterAirline.getCountryReg();
        
        String query = "UPDATE airlines SET (id, name, datecreation, numaircrafts, countryreg) = ("+id_new+",'" + name + "', '" + dateCreation + "', " + numAircrafts + ", '"+ countryReg + "') WHERE id = " + id + ";";
   
        try {
            PostgresDbAdapter.getAdapter().executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}
