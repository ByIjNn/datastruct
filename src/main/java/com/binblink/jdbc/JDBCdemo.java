package com.binblink.jdbc;

import java.sql.*;

import org.junit.Test;


/**
 * @author binblink
 * @version 1.0.0
 * @Date 2020/10/26 13:38
 * @Description 1.8 后jdbc 中connection等加入jre扩展包
 * 不在需要class.forName 加载驱动 并且com.mysql.jdbc.Driver 已过时 应为com.mysql.cj.jdbc.Driver
 * jdbc 一步一步演化，最终为数据库连接池的形式。
 **/
public class JDBCdemo {


    @Test
    public void fun() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");

        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/exam?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";

        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(" 数据库链接成功！");
    }

    /*
     * 链接数据库
     * 执行DQL
     */
    @Test
    public void fun2() throws ClassNotFoundException, SQLException {

        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/exam?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";

        String sql = "select * from emp";


        Connection conn = DriverManager.getConnection(url, user, password);

        Statement stem = conn.createStatement();

        ResultSet res = stem.executeQuery(sql);

        while (res.next()) {
            String ename = res.getString("ename");
            int empno = res.getInt(1);
            double sal = res.getDouble("sal");

            System.out.println(ename + " , " + empno + " , " + sal);


        }
        /*
         * 关闭资源
		 * 倒关
		 */
        res.close();
        stem.close();
        conn.close();
    }

    /*
     * 代码规范化
     * 释放资源
     */
    @Test
    public void fun3() throws Exception {

        Connection con = null;
        Statement stem = null;
        ResultSet res = null;

        try {


            String user = "root";
            String password = "123456";
            String url = "jdbc:mysql://localhost:3306/exam?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";

            con = DriverManager.getConnection(url, user, password);
            String sql = "select * from emp";
            stem = con.createStatement();
            res = stem.executeQuery(sql);

            int count = res.getMetaData().getColumnCount();
            while (res.next()) {
                for (int i = 1; i < count; i++) {
                    System.out.print(res.getObject(i));
                    if (i < count) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

            if (res != null) res.close();
            if (stem != null) stem.close();
            if (con != null) con.close();

        }
    }

    @Test
    public void fun4() throws Exception {
        boolean bool = login2("lisi", "123");
        System.out.println(bool);
    }

    /**
     * @author binblink
     * @version 1.0.0
     * @Description 配置文件形式
     **/
    @Test
    public void fun5() throws SQLException {
        Connection con = JdbcUtils.getConnection();
        System.out.println(con);
    }


    @Test
    public void fun6() throws SQLException {
        String sql = "update emp set sal = 1600 where empno = 1002";
        JdbcUtils.update(sql);
    }

    @Test
    public void fun8() throws SQLException {

        String sql = "update emp set sal = 1 where empno = 1002";
        JdbcUtils.updateDelay(sql);

    }

    @Test
    public void fun7() throws SQLException {
        String sql = "select * from emp where empno = 1002";
        System.out.println(JdbcUtils.select(sql));
    }




    public boolean login2(String sname, String sex) throws Exception {

        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/exam?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";

        Connection con = DriverManager.getConnection(url, user, password);

        String sql = "select * from student where sname=? and ssex=?";

        PreparedStatement pstem = con.prepareStatement(sql);

        pstem.setString(1, sname);
        pstem.setString(2, sex);
        ResultSet res = pstem.executeQuery();

        return res.next();
    }


}
