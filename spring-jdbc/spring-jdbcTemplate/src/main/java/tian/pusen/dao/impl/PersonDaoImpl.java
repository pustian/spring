package tian.pusen.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import tian.pusen.dao.IPersonDao;
import tian.pusen.entity.Person;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tianpusen on 2017/4/10.
 * 其中，batchUpdate适合于批量增、删、改操作;
 *      update(…)：使用于增、删、改操作；
 *      execute（）：执行一个独立的sql语句，包括ddl语句；
 *      queryForInt ：查询出一个整数值
 */
public class PersonDaoImpl implements IPersonDao {
    private JdbcTemplate jdbcTemplate;
    public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(Person person) {
        String insertSQL= "insert into person(id, name, age) values(?, ?, ?)";
        Object objects[] = new Object[]{ person.getId(), person.getName(), person.getAge()} ;
        return jdbcTemplate.update(insertSQL, objects);
    }

    @Override
    public int deleteById(int id) {
        String deleteSQL = "delete from person where id=(?)";
        Object objects[] = new Object[]{id};
        int[] types = new int[]{java.sql.Types.INTEGER};
        return jdbcTemplate.update(deleteSQL, objects, types);
    }

    @Override
    public int updatePerson(final Person person) {
        String updateSQL = "update person set name=?, age= ? where id = ?";
        PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter(){
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, person.getName());
                ps.setInt(2,person.getAge());
                ps.setInt(3, person.getId());
            }
        };
        return jdbcTemplate.update(updateSQL, preparedStatementSetter);
    }

    @Override
    public Person queryById(int id) {
        String selectSQL = "select id, name, age from person where id=(?)";
        Object objects[] = new Object[]{id};
        return jdbcTemplate.queryForObject(selectSQL, objects, Person.class);
    }

    @Override
    public List<Person> queryAllPerson() {
//        String selectSQL = "select id, name, age from person";
//        return jdbcTemplate.queryForList(selectSQL, Person.class);
        return null;
    }
}
