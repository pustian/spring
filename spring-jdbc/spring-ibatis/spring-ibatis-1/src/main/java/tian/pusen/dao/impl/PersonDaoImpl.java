package tian.pusen.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import tian.pusen.dao.IPersonDao;
import tian.pusen.entity.Person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by tianpusen on 2017/4/9.
 */
public class PersonDaoImpl extends SqlMapClientDaoSupport implements IPersonDao {

    public Person insertPerson(Person person) throws SQLException {
        return (Person) getSqlMapClient().insert("insertPerson", person);
    }

    public boolean deleteById(int id) throws SQLException {
        return getSqlMapClient().delete("deletePerson", id) > 0;
    }

    public boolean updatePerson(Person person) throws SQLException {
        return getSqlMapClient().update("updatePerson", person) > 0;
    }

    public Person queryById(int id) throws SQLException {
        return (Person) getSqlMapClient().queryForObject("queryByID", id);
    }

    public List<Person> queryAllPerson() throws SQLException {
        return getSqlMapClient().queryForList("queryAllPerson");
    }
}
