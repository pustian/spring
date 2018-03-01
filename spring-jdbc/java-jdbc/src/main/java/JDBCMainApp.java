import java.sql.*;

/**
 * Created by tianpusen on 2017/4/7.
 * 注意事物设置
 *    conn.setAutoCommit(false);  //将自动提交设置为false
 *    conn.commit();      //当两个操作成功后手动提交
 *    conn.rollback();    //一旦其中一个操作出错都将回滚，使两个操作都不成功
 */
public class JDBCMainApp {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/tian_test";
    static final String DATEBASE_USER = "root";
    static final String DATEBASE_PASSWD = "ldap4$";
    static {
        try {
            // 加载驱动类
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
      //  useStatement();
        usePreparedStatement();
    }

    // 通过DriverManager获取数据库连接
    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        connection = DriverManager.getConnection(DATABASE_URL, DATEBASE_USER, DATEBASE_PASSWD);
        return connection;
    }

    public static void useStatement() throws SQLException{
        Connection connection = getConnection();
        Statement statement = (Statement) connection.createStatement();
        int insertResult = statement.executeUpdate("insert person (name, age) value ('bobo', 24)");
        System.out.println("insert ok affect line:"+ insertResult);

        int updateResult = statement.executeUpdate("update person set age = 30 where id = '1' ");
        System.out.println("update ok affect line:"+updateResult);

        ResultSet resultSet = statement.executeQuery("select * from person");
        // 操作ResultSet结果集
        while (resultSet.next()) {
            // 第一种获取字段方式
            System.out.println("id:"+ resultSet.getString(1) + " name:" +
                    resultSet.getString(2) + " age:" + resultSet.getString(3));
            System.out.print("---- ");
            // 第二种获取字段方式
            System.out.println("id:"+ resultSet.getString("id") + " name:" +
                    resultSet.getString("name") + " age:" + resultSet.getString("age"));
        }
        resultSet.close();

        statement.close();
        connection.close();
    }

    public static void usePreparedStatement() throws SQLException{
        String preparedSQL = "insert person (name, age) value (?, ?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(preparedSQL);
        preparedStatement.setString(1, "田");
        preparedStatement.setInt(2, 21);
        int insertResult = preparedStatement.executeUpdate();
        System.out.println("insert ok affect line:"+ insertResult);


        String preparedUpdateSQL = "update person set name = ? where id = ?";
        PreparedStatement preparedUpdateStatement = (PreparedStatement) connection.prepareStatement(preparedUpdateSQL);
        preparedUpdateStatement.setString(1, "Hello");
        preparedUpdateStatement.setInt(2, 1);
        int updateResult = preparedUpdateStatement.executeUpdate();
        System.out.println("update ok affect line:"+updateResult);

        ResultSet resultSet = preparedUpdateStatement.executeQuery("select * from person");
        // 操作ResultSet结果集
        while (resultSet.next()) {
            // 第二种获取字段方式
            System.out.println("id:"+ resultSet.getString("id") + " name:" +
                    resultSet.getString("name") + " age:" + resultSet.getString("age"));
        }
        resultSet.close();
        preparedUpdateStatement.close();
        preparedStatement.close();
    }
}
