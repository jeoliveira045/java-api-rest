package labs.config;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB1";
    String username = "javaapi";
    String password = "javaapi";

    Connection conn;

    private static DatabaseConnection database = new DatabaseConnection();

    public static DatabaseConnection instance(){
        return database;
    }

    private DatabaseConnection(){

    }

//    public Connection getConnection(){
//        return conn;
//    }

    public Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(URL, username, password);
        return conn;
    }

    public void close() throws SQLException {
        conn.close();
    }


}
