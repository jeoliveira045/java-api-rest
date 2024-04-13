package labs;

import labs.config.DatabaseConnection;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
        String[] first_names = {"Luke", "Albert", "Joan", "Patricia", "Bob"};
        String[] last_names = {"Jonhson", "Smith", "Schwartzmann", "Aguilera", "Russell"};

        var db = DatabaseConnection.instance();

        Statement statement = db.connect().createStatement();

//        st.execute("CREATE TABLE PERSON(ID NUMBER PRIMARY KEY, FIRST_NAME VARCHAR(50), LAST_NAME VARCHAR(50))");


//        var insertSql = "insert into employees";




    }
}
