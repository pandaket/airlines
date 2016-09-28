/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines.tables;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import airlines.structure.Country;
import Editions.PostgresDbAdapter;
/**
 *
 * @author Екатерина
 */
public class CountryTable {
    public List<Country> getCountry() {
        List<Country> country = new ArrayList<>();
        try {
            ResultSet set = PostgresDbAdapter.getAdapter().executeQueryWithResult("SELECT id, countryreg FROM airlines;");
            while (set.next()) {
                int id = set.getInt("id");
                String country_name = set.getString("countryreg");
                Country countries = new Country(id, country_name);
                country.add(countries);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return country;
    }
public List<Country> getCountry1() {
        List<Country> country = new ArrayList<>();
        try {
            ResultSet set = PostgresDbAdapter.getAdapter().executeQueryWithResult("SELECT id, country FROM locals;");
            while (set.next()) {
                int id = set.getInt("id");
                String country_name = set.getString("country");
                Country countries = new Country(id, country_name);
                country.add(countries);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return country;
    }

    
     public List<Country> getCity() {
        List<Country> city = new ArrayList<>();
        try {
            ResultSet set = PostgresDbAdapter.getAdapter().executeQueryWithResult("SELECT id, name FROM locals;");
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                Country countries = new Country(id, name);
                city.add(countries);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return city;
    }
     public List<Country> getCity1() {
        List<Country> city = new ArrayList<>();
        try {
            ResultSet set = PostgresDbAdapter.getAdapter().executeQueryWithResult("SELECT id, name FROM cities;");
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                Country countries = new Country(id, name);
                city.add(countries);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return city;
    }

}
