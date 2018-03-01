package tian.pusen.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import tian.pusen.dao.IPersonDao;
import tian.pusen.entity.Person;

import java.util.List;

/**
 * Created by tianpusen on 2017/4/10.
 */
public class PersonDaoImpl implements IPersonDao{
    private final static String NAMESPACE= "tian.pusen.dao.IPersonDao.";

    private SqlSessionTemplate sqlSessionTemplate;
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int insertPerson(Person person) {
        return sqlSessionTemplate.insert(NAMESPACE+"insertPerson", person);
    }

    @Override
    public int deleteById(int id) {
        return sqlSessionTemplate.delete(NAMESPACE + "deleteById", id);
    }

    @Override
    public int updatePerson(Person person) {
        return sqlSessionTemplate.update(NAMESPACE+"updatePerson", person );
    }

    @Override
    public Person queryById(int id) {
        return sqlSessionTemplate.selectOne(NAMESPACE+"queryById", id );
    }

    @Override
    public List<Person> queryAllPerson() {
        return sqlSessionTemplate.selectList(NAMESPACE+"queryAllPerson");
    }
}
