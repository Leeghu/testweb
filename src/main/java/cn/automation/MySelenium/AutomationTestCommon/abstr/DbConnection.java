package cn.automation.MySelenium.AutomationTestCommon.abstr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cn.automation.MySelenium.AutomationTestCommon.util.Constants;


public class DbConnection {
    private static final ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();
    //private static Connection conn = null;

    public static Connection getConnection(){
        Connection conn = null;
        try{
            //获取数据库驱动
            if("oracle".equalsIgnoreCase(Constants.DATABASE_TYPE)){
                Class.forName(Constants.ORACLE_DRIVER_CLASSNAME);
                conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USERNAME, Constants.ORACLE_PSW);
            }else if("mysql".equalsIgnoreCase(Constants.DATABASE_TYPE)){
                Class.forName(Constants.MYSQL_DRIVER_CLASSNAME);
                conn = DriverManager.getConnection(Constants.MYSQL_URL, Constants.MYSQL_USERNAME, Constants.MYSQL_PSW);
                System.out.println(conn);
            }
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getDataBaseConnection(){
        Connection conn = connectionHolder.get();
        try{
            if (conn == null || conn.isClosed()){
                Connection con = DbConnection.getConnection();
                connectionHolder.set(con);
                System.out.println("[Thread]" + Thread.currentThread().getName());
                return con;
            }
            return conn;
        } catch(Exception e) {
            System.out.println("[ThreadLocal Get Connection Error]" + e.getMessage());
        }
        return null;
    }


    public void close() {
        Connection conn = connectionHolder.get();
        if (conn!=null){
            try { conn.close(); conn = null; } catch (SQLException e) { e.printStackTrace(); }
        }
    }

}
