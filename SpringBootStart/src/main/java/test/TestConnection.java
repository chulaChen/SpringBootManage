package test;

/**
 * @author cz
 * @Date 2018/8/13
 * @Description
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestConnection {

    private static Connection con = null;

    public static Connection abrirBanco(){
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
            System.out.println("conectando");
            return con;
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("driver nao encontrado: " + cnfe.getMessage());
            return null;
        }
        catch(SQLException sql){
            System.out.println("SQLException: " + sql.getMessage());
            System.out.println("SQLState: " + sql.getSQLState());
            System.out.println("Erro: " + sql.getErrorCode());
            System.out.println("StackTrace: " + sql.getStackTrace());
            return null;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void fecharBDcon(){
        try{
            con.close();
        }
        catch(Exception e){
            System.out.println("erro ao fechar o banco" + e.getMessage());
        }
    }
    public static void main(String arr[]) throws SQLException {
        System.out.println("Making connection..");
        Connection connection = TestConnection.abrirBanco();
        // 预执行加载
        PreparedStatement preparedStatement = null;
        String sqlString = "select * from users";
          preparedStatement = connection.prepareStatement(sqlString);
        ResultSet  resultSet = preparedStatement.executeQuery();
        System.out.println(connection == null);
        System.out.println("JDBCUtlTool made...");
    }
}