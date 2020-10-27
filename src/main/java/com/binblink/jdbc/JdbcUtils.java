package com.binblink.jdbc;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;




/*
 * v 1.0
 * 加载配置文件
 * 封装链接数据库
 */

public class JdbcUtils {

    private static Properties prop = null;

    // 数据库连接池
    private static DruidDataSource dataSource = new DruidDataSource();

    // 它是事务专用连接！
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    static {
        try {

            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            prop = new Properties();

            prop.load(in);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    static {
        dataSource.configFromPropety(prop);
    }

    /**
     * @author binblink
     * @Description jdbc配置文件获取
     **/
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
    }

    /**
     * @author binblink
     * @Description 连接池获取
     **/
    public static Connection getConnectionByDataSource() throws SQLException {

        return dataSource.getConnection().getConnection();
    }

    /**
    *
    * @author binblink
    * @Date 2020/10/26 14:40
    * @version 1.0.0
    * @Description 事务更新
    *
    **/
    public static void update(String sql) throws SQLException {

        try {

            Connection connection = getConnectionByDataSource();
            connection.setAutoCommit(false);//这一步为开启事务
            tl.set(connection);
            PreparedStatement ps = connection.prepareStatement(sql);
            Thread.sleep(1000);
            boolean result = ps.execute();
            connection.commit();
            System.out.println(result);
        } catch (SQLException e) {
            System.out.println("回滚了！");
            tl.get().rollback();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            tl.get().close();
            tl.remove();
        }
    }
    /**
     *
     * @author binblink
     * @Date 2020/10/26 14:40
     * @version 1.0.0
     * @Description 事务更新
     *
     **/
    public static void updateDelay(String sql) throws SQLException {

        try {

            Connection connection = getConnectionByDataSource();
            connection.setAutoCommit(false);
            System.out.println(select("select * from emp where empno = 1002"));
            Thread.sleep(10000);
            System.out.println(select("select * from emp where empno = 1002"));
            tl.set(connection);
            PreparedStatement ps = connection.prepareStatement(sql);

            boolean result = ps.execute();
            System.out.println("delay"+result);


            connection.commit();

        } catch (SQLException e) {

            System.out.println("回滚了！");
            tl.get().rollback();
        } catch (InterruptedException e) {
            System.out.println("回滚了！");
            e.printStackTrace();
        } finally {

            tl.get().close();
            tl.remove();
        }
    }

    public static JSONObject select(String sql) throws SQLException {

        Connection connection = getConnectionByDataSource();

        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        JSONObject jsonObject = new JSONObject();

        if (rs.next()) {
            // 遍历每一列
            for (int i = 1; i <= columnCount; i++) {
                String columnName =metaData.getColumnLabel(i);
                String value = rs.getString(columnName);
                jsonObject.put(columnName, value);
            }
        }

       return jsonObject;
    }


    /**
     * 开启事务
     * 1. 获取一个Connection，设置它的setAutoComnmit(false)
     * 2. 还要保证dao中使用的连接是我们刚刚创建的！
     * --------------
     * 1. 创建一个Connection，设置为手动提交
     * 2. 把这个Connection给dao用！
     * 3. 还要让commitTransaction或rollbackTransaction可以获取到！
     * @throws SQLException
     */
    public static void beginTransaction() throws SQLException {
        Connection con = tl.get();
        if(con != null) throw new SQLException("已经开启了事务，就不要重复开启了！");
		/*
		 * 1. 给con赋值！
		 * 2. 给con设置为手动提交！
		 */
        con = getConnection();//给con赋值，表示事务已经开始了
        con.setAutoCommit(false);

        tl.set(con);//把当前线程的连接保存起来！
    }

    /**
     * 提交事务
     * 1. 获取beginTransaction提供的Connection，然后调用commit方法
     * @throws SQLException
     */
    public static void commitTransaction() throws SQLException {
        Connection con = tl.get();//获取当前线程的专用连接
        if(con == null) throw new SQLException("还没有开启事务，不能提交！");
		/*
		 * 1. 直接使用con.commit()
		 */
        con.commit();
        con.close();
        // 把它设置为null，表示事务已经结束了！下次再去调用getConnection()返回的就不是con了
        tl.remove();//从tl中移除连接
    }

    /**
     * 提交事务
     * 1. 获取beginTransaction提供的Connection，然后调用rollback方法
     * @throws SQLException
     */
    public static void rollbackTransaction() throws SQLException {
        Connection con = tl.get();
        if(con == null) throw new SQLException("还没有开启事务，不能回滚！");
		/*
		 * 1. 直接使用con.rollback()
		 */
        con.rollback();
        con.close();
        tl.remove();
    }

    /**
     * 释放连接　
     * @param connection
     * @throws SQLException
     */
    public static void releaseConnection(Connection connection) throws SQLException {
        Connection con = tl.get();
		/*
		 * 判断它是不是事务专用，如果是，就不关闭！
		 * 如果不是事务专用，那么就要关闭！
		 */
        // 如果con == null，说明现在没有事务，那么connection一定不是事务专用的！
        if(con == null) connection.close();
        // 如果con != null，说明有事务，那么需要判断参数连接是否与con相等，若不等，说明参数连接不是事务专用连接
        if(con != connection) connection.close();
    }


}
