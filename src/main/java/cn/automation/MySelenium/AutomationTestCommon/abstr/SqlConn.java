package cn.automation.MySelenium.AutomationTestCommon.abstr;

import java.sql.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class SqlConn {

    Connection conn = DbConnection.getDataBaseConnection();
    private static final Logger log = Logger.getLogger(SqlConn.class);
    private static PreparedStatement pstmt = null;
    public static Statement st = null;
    public static ResultSet resultSet =null;

    public SqlConn(){
        if (conn == null){
            conn = DbConnection.getDataBaseConnection();
        }
    }

    //@Bizlet("获取一个指定的查询结果值")
    private static String getValue(ResultSet rs, String colName) {
        if (rs == null)
            return null;
        try {
            if (rs.next()) {
                return rs.getString(colName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param querysql
     * @param colname
     * @return
     */
    public static String DBquery (String querysql, String colname) {
        String str = null;
        try{
            st = new SqlConn().conn.createStatement();
            resultSet = st.executeQuery(querysql);
            str = getValue(resultSet, colname);
            close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void DBexecute(String sql){
        try{
            st = new SqlConn().conn.createStatement();
            st.execute(sql);
            close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param executesql
     * @param querysql
     * @param colname
     * @return
     */
    public static String[] DBexecuteArray_query(String executesql, String querysql, String colname){
        String[] str = null;
        try{
            st = new SqlConn().conn.createStatement();
            st.execute(executesql);
            resultSet = st.executeQuery(querysql);
            str = getResult_SigleCol(resultSet, colname);
            close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return str;
    }

    /**
     *
     * @param sqls
     */
    public static void DBexecutedBatch(String[] sqls) {
        try {
            /*DbConnection dbconn = new DbConnection();
            Connection conn = getOracleConnection();*/
            st = new SqlConn().conn.createStatement();
            for (String sql : sqls) {
                st.addBatch(sql);
            }
            st.executeBatch();
            close();
        }catch(SQLException e){
            log.debug("");
            e.printStackTrace();
        }
    }

    /**
     *
     * @param querysql
     * @param colname
     * @return
     */
    public static String[] DBqueryArray(String querysql, String colname) {
        String[] str = null;
        try{
            /*DbConnection dbconn = new DbConnection();
            Connection conn = getOracleConnection();*/
            st = new SqlConn().conn.createStatement();
            resultSet = st.executeQuery(querysql);
            str = getResult_SigleCol(resultSet, "1");
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String[] getResult_SigleCol(ResultSet rs, String colname) {
        ArrayList<String> list = new ArrayList<>();
        String result[] = null;
        try {
            while (rs != null && rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rs == null) {
            return null;
        }
        result = (String[]) list.toArray(new String[list.size()]);
        close();
        return result;
    }

    public static String[] getResult_MultiCol(String querysql, int colNum) {
        ArrayList<String> list = new ArrayList<>();
        try{
            st = new SqlConn().conn.createStatement();
            resultSet = st.executeQuery(querysql);
            if (resultSet != null && resultSet.next()) {
                for (int i = 0;i < colNum; i++) {
                    list.add(resultSet.getString(i+1));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (resultSet == null) {
            return null;
        }
        String result[] = (String[]) list.toArray(new String[list.size()]);
        close();
        return result;
    }

    public static void close() {
        if (resultSet!=null){
            try { resultSet.close(); resultSet = null; } catch (SQLException e) { e.printStackTrace(); }
        }
        if (st!=null) {
            try { st.close(); st = null; } catch (SQLException e) { e.printStackTrace(); }
        }
        if (pstmt!=null) {
            try { pstmt.close(); pstmt = null; } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}
