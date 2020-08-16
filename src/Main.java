import com.jdbc.model.Role;
import com.jdbc.utility.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            PreparedStatement pre = DBConnection.getConnection().prepareStatement("Select * from User");
            System.out.println(DBConnection.getConnection().hashCode());
            System.out.println(DBConnection.getConnection().hashCode());

            ResultSet res = pre.executeQuery();
            while (res.next()) {
                System.out.println(res.getString("id") + res.getString("name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
