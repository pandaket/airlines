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
import airlines.structure.Weeks;
import Editions.PostgresDbAdapter;
/**
 *
 * @author Екатерина
 */
public class WeeksTable {
    public List<Weeks> getWeek() {
        List<Weeks> weeks = new ArrayList<>();
        try {
            ResultSet set = PostgresDbAdapter.getAdapter().executeQueryWithResult("SELECT * FROM week");
            while (set.next()) {
                int id = set.getInt("id");
                String week_name = set.getString("weeks");
                Weeks week = new Weeks(id, week_name);
                weeks.add(week);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return weeks;
    }

    

}
