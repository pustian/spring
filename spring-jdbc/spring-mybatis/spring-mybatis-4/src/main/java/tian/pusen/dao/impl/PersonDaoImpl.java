package tian.pusen.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import tian.pusen.dao.IPersonDao;
import tian.pusen.entity.Person;

import java.util.List;

/**
 * Created by tianpusen on 2017/4/10.
 */
public class PersonDaoImpl extends SqlSessionDaoSupport implements IPersonDao {

    private final static String NAMESPACE= "tian.pusen.dao.IPersonDao.";


    @Override
    public int insertPerson(Person person) {
        return getSqlSession().insert(NAMESPACE+"insertPerson", person);
    }

    @Override
    public int deleteById(int id) {
        return getSqlSession().delete(NAMESPACE + "deleteById", id);
    }

    @Override
    public int updatePerson(Person person) {
        return getSqlSession().update(NAMESPACE+"updatePerson", person );
    }

    @Override
    public Person queryById(int id) {
        return getSqlSession().selectOne(NAMESPACE+"queryById", id );
    }

    @Override
    public List<Person> queryAllPerson() {
        return getSqlSession().selectList(NAMESPACE+"queryAllPerson");
    }
}
