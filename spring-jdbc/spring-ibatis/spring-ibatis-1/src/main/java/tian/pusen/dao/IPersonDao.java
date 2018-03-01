package tian.pusen.dao;

import tian.pusen.entity.Person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by tianpusen on 2017/4/9.
 */
public interface IPersonDao {
    public Person insertPerson(Person person) throws SQLException;   //添加
    public boolean deleteById(int id) throws SQLException;            //删除
    public boolean updatePerson(Person person) throws SQLException;    //修改
    public Person queryById(int id) throws SQLException;              //根据ID查询
    public List<Person> queryAllPerson() throws SQLException;         //查询全部
}
