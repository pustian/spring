package tian.pusen.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import tian.pusen.entity.Person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by tianpusen on 2017/4/9.
 */
public class PersonMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(PersonMapperTest.class);
    @Test
    public void insert() throws SQLException {
        String configPath = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        PersonMapper personMapper = (PersonMapper) ctx.getBean("personMapper");

        Person person = new Person();
        person.setId(150);
        person.setName("黄易");
        person.setAge(65);
        int result = personMapper.insertPerson(person);
        System.out.println("Insert into the table person with value" +person +" result:"+result);
        List<Person> personList = personMapper.queryAllPerson();
        for (Person per: personList) {
            System.out.println(per);
        }
    }


    @Test
    public void delete() throws SQLException {
        String configPath = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        PersonMapper personMapper = (PersonMapper) ctx.getBean("personMapper");

        Integer id=150;
        int result = personMapper.deleteById(id);
        System.out.println("Delete data from table person with keyID:"+id+" The result :"+result );

        List<Person> personList = personMapper.queryAllPerson();
        for (Person per: personList) {
            System.out.println(per);
        }
    }
}
