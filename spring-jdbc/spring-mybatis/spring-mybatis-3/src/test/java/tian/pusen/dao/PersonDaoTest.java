package tian.pusen.dao;

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
public class PersonDaoTest {
    private static final Logger logger = LoggerFactory.getLogger(PersonDaoTest.class);
    @Test
    public void insert() throws SQLException {
        String configPath = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        IPersonDao personDao = (IPersonDao) ctx.getBean("personDao");

        Person person = new Person();
        person.setId(250);
        person.setName("黄易");
        person.setAge(65);
        int result = personDao.insertPerson(person);
        System.out.println("Insert into the table person with value" +person +" result:"+result);
        List<Person> personList = personDao.queryAllPerson();
        for (Person per: personList) {
            System.out.println(per);
        }
        System.out.println(personDao.queryById(250));
    }


    @Test
    public void delete() throws SQLException {
        String configPath = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        IPersonDao personDao = (IPersonDao) ctx.getBean("personDao");

        Integer id=250;
        int result = personDao.deleteById(id);
        System.out.println("Delete data from table person with keyID:"+id+" The result :"+result );

        List<Person> personList = personDao.queryAllPerson();
        for (Person per: personList) {
            System.out.println(per);
        }
    }
}
