package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static ru.stqa.pft.addressbook.appManager.ApplicationManager.properties;
import java.sql.*;

public class DbConnectionTest {

    @Test
    public void testDbConnecttion() {
        //http://dev.mysql.com/doc/connector-j/6.0/en/connector-j-usagenotes-connect-drivermanager.html
        Connection conn = null;
        try {

            //DriverManager.getConnection("jdbc:mysql://localhost:3306/test?" +
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?" + <- error
            // conn = DriverManager.getConnection ( properties.getProperty("web.dbName") );
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?useSSL=false&" +
                            "serverTimezone=UTC&user=root&password=");

            // http://localhost/phpmyadmin/db_structure.php?server=1&db=addressbook&token=b80997d0a3f816f988c452b27491a10f
            Statement st = conn.createStatement();
                     //rs = collection
            ResultSet rs = st.executeQuery("select  group_id, group_name, group_header, group_footer from group_list");
            Groups groups = new Groups();
            while (rs.next()) {
                groups.add(new GroupData().setId(rs.getInt("group_id")).withName(rs.getString("group_name")).
                        withHeader(rs.getNString("group_header")).withFooter(rs.getString("group_footer")));
            }
            rs.close();
            st.close();
            conn.close();

            System.out.println(groups);


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
