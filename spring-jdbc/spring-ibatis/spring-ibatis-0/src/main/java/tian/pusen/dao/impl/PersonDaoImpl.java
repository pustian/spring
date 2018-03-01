package tian.pusen.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import tian.pusen.dao.IPersonDao;
import tian.pusen.entity.Person;

import java.util.List;

/**
 * Created by tianpusen on 2017/4/9.
 */
public class PersonDaoImpl extends SqlMapClientDaoSupport implements IPersonDao {

    public Person insertPerson(Person person)  {
        return (Person) getSqlMapClientTemplate().insert("insertPerson", person);
    }

    public boolean deleteById(int id)  {
        return getSqlMapClientTemplate().delete("deletePerson", id) > 0;
    }

    public boolean updatePerson(Person person)  {
        return getSqlMapClientTemplate().update("updatePerson", person) > 0;
    }

    public Person queryById(int id)  {
        return (Person) getSqlMapClientTemplate().queryForObject("queryByID", id);
    }

    public List<Person> queryAllPerson()  {
        return getSqlMapClientTemplate().queryForList("queryAllPerson");
    }
}
