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
//    IPersonDao personDao ;
//    public PersonDaoTest() {
//        String configPath = "applicationContext.xml";
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
//        IPersonDao personDao = (IPersonDao) ctx.getBean("personOperDao");
//    }
    private static final Logger logger = LoggerFactory.getLogger(PersonDaoTest.class);
    @Test
    public void insert() throws SQLException {
        String configPath = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        IPersonDao personDao = (IPersonDao) ctx.getBean("personDao");

        Person person = new Person();
        person.setId(113);
        person.setName("黄易");
        person.setAge(65);
        Person inserted = personDao.insertPerson(person);
        System.out.println("Insert into the table person with value"+inserted );
        System.out.println("insert parameter and result is the same object:"+(person == inserted));
        List<Person> personList = personDao.queryAllPerson();
        for (Person per: personList) {
            System.out.println(per);
        }
    }


    @Test
    public void delete() throws SQLException {
        String configPath = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        IPersonDao personDao = (IPersonDao) ctx.getBean("personDao");

        Integer id=113;
        boolean bool = personDao.deleteById(id);
        System.out.println("Delete data from table person with keyID:"+id+" The result :"+bool );

        List<Person> personList = personDao.queryAllPerson();
        for (Person per: personList) {
            System.out.println(per);
        }
    }



}
