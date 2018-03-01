package tian.pusen.dao;

import tian.pusen.entity.Person;

import java.util.List;

/**
 * Created by tianpusen on 2017/4/9.
 */
public interface IPersonDao {
    public Person insertPerson(Person person) ;   //添加
    public boolean deleteById(int id) ;            //删除
    public boolean updatePerson(Person person) ;    //修改
    public Person queryById(int id) ;              //根据ID查询
    public List<Person> queryAllPerson() ;         //查询全部
}
