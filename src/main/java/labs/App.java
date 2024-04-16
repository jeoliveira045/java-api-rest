package labs;

import labs.config.DatabaseConnection;
import labs.entities.Person;
import labs.entities.dao.PersonDao;
import labs.entities.dao.daoImpl.PersonDaoImpl;

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

//        Statement statement = db.connect().createStatement();
//
//        statement.execute("CREATE TABLE PERSON(ID NUMBER PRIMARY KEY, FIRST_NAME VARCHAR(50), LAST_NAME VARCHAR(50))");

        Person person = new Person(1L, "JOHN", "DOE");

        PersonDao dao = new PersonDaoImpl();

//        dao.save(person);
        System.out.println(dao.findById(1L));






//        var insertSql = "insert into employees";




    }
}
