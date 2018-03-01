package tian.pusen.mapper;

import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import tian.pusen.entity.Person;

import java.util.List;

/**
 * Created by tianpusen on 2017/4/9.
 */
@MapperScan
public interface IPersonMapper {
    @Insert("INSERT INTO person(id, name, age) values(#{id}, #{name}, #{age})")
    public int insertPerson(Person person) ;     //添加

    @Delete("DELETE FROM person WHERE id=#{id} ")
    public int deleteById(@Param("id")int id) ; //删除

    @Update("UPDATE person SET name = #{name}, age=#{age} WHERE id=#{id}")
    public int updatePerson(Person person) ;     //修改

    @Select("SELECT id,name,age FROM person WHERE id= #{id}")
    public Person queryById(@Param("id") int id) ;              //根据ID查询

    @Select("SELECT id,name,age FROM person")
    public List<Person> queryAllPerson() ;         //查询全部
}
