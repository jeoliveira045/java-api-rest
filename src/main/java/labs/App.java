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

        var db = DatabaseConnection.instance();

        Statement statement = db.connect().createStatement();

        statement.execute("CREATE TABLE PERSON(ID NUMBER PRIMARY KEY, FIRST_NAME VARCHAR(50), LAST_NAME VARCHAR(50))");

        Person person = new Person(1L, "JANE", "DOE");


        PersonDao dao = new PersonDaoImpl();

        dao.save(new Person(2L, "JOHN", "DOE"));
        dao.findAll().forEach((value) -> {
            System.out.println(value);
        });

    }
}
