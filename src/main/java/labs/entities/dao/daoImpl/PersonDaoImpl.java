package labs.entities.dao.daoImpl;

import labs.config.DatabaseConnection;
import labs.entities.Person;
import labs.entities.dao.PersonDao;
import labs.exceptions.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonDaoImpl implements PersonDao {


    @Override
    public Person save(Person person) throws DaoException {

        try{
            Connection conn = DatabaseConnection.instance().connect();

            var stmt = conn.prepareStatement("INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME) VALUES (?, ?, ?)");

            stmt.setLong(1,person.getId());
            stmt.setString(2,person.getFirstName());
            stmt.setString(3,person.getLastName());

            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch(SQLException e){
            throw new DaoException(e);
        } catch(ClassNotFoundException e){
            e.fillInStackTrace();
        }

        return person;

    }
    @Override
    public Person findById(Object o) {
        try{
            var conn = DatabaseConnection.instance().connect();

            var stmt = conn.prepareStatement("SELECT ID, FIRST_NAME, LAST_NAME FROM PERSON WHERE ID = ?");

            stmt.setLong(1, Long.parseLong(o.toString()));

            stmt.executeUpdate();

            var resultSet = stmt.getResultSet();

            Person person = new Person();

            while(resultSet.next()){
                person.setId(resultSet.getLong("ID"));
                person.setFirstName(resultSet.getString("FIRST_NAME"));
                person.setLastName(resultSet.getString("LAST_NAME"));
            }

            stmt.close();
            conn.close();

            return person;


        } catch(SQLException e){
            throw new DaoException(e);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(Person person) {
        try{
            var conn = DatabaseConnection.instance().connect();

            var stmt = conn.prepareStatement("UPDATE PERSON SET FIRST_NAME = ?, LAST_NAME = ? WHERE ID = ?");

            stmt.setLong(3, person.getId());
            stmt.setString(1, person.getFirstName());
            stmt.setString(2, person.getLastName());

            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException e){
            throw new DaoException(e);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public List<Person> findAll(){
        return null;
    }
}
