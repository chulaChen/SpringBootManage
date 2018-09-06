package test;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author cz
 * @Date 2018/8/30
 * @Description
 */
public class QueryRunnerDemo {
    private static Connection con = JDBCUtlTool.getConnection();

    public static void main(String[] args)throws SQLException {
        insert();
//        update();
        //delete();
    }
    /*
     *  定义方法,使用QueryRunner类的方法delete将数据表的数据删除
     */
    public static void delete()throws SQLException{
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        //写删除的SQL语句
        String sql = "DELETE FROM sort WHERE sid=?";
        //调用QueryRunner方法update
        int row = qr.update(con, sql, 8);
        System.out.println(row);
        /*
         *  判断insert,update,delete执行是否成功
         *  对返回值row判断
         *  if(row>0) 执行成功
         */
        DbUtils.closeQuietly(con);
    }

    /*
     *  定义方法,使用QueryRunner类的方法update将数据表的数据修改
     */
    public static void update()throws SQLException{
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        //写修改数据的SQL语句
        String sql = "UPDATE sort SET sname=?,sprice=?,sdesc=? WHERE sid=?";
        //定义Object数组,存储?中的参数
        Object[] params = {"花卉",100.88,"情人节玫瑰花",4};
        //调用QueryRunner方法update
        int row = qr.update(con, sql, params);
        System.out.println(row);
        DbUtils.closeQuietly(con);
    }


    /*
     * 定义方法,使用QueryRunner类的方法update向数据表中,添加数据
     */
    public static void insert()throws SQLException{
        //创建QueryRunner类对象
        QueryRunner qr = new QueryRunner();
        String sql = "INSERT INTO sort (sname,sprice,sdesc)VALUES(?,?,?)";
        //将三个?占位符的实际参数,写在数组中
        Object[] params = {"体育用品",289.32,"购买体育用品"};
        //调用QueryRunner类的方法update执行SQL语句
        int row = qr.update(con, sql, params);
        System.out.println(row);
        DbUtils.closeQuietly(con);
    }


}
