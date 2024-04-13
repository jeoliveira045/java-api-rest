package labs.entities.dao.daoImpl;

import labs.config.DatabaseConnection;
import labs.entities.Person;
import labs.entities.dao.PersonDao;
import labs.exceptions.DaoException;

import java.sql.SQLException;
import java.sql.Statement;

public class PersonDaoImpl implements PersonDao {


    @Override
    public Person save(Person person) throws DaoException {
        return null;
    }

    @Override
    public Person findById(Object o) {
        return null;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Object o) {

    }
}
