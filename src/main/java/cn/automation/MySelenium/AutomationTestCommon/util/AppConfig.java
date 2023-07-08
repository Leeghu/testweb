package cn.automation.MySelenium.AutomationTestCommon.util;

import java.util.Enumeration;
import java.util.PropertyResourceBundle;

import org.apache.log4j.Logger;

public class AppConfig {
    private static final Logger log = Logger.getLogger(AppConfig.class);
    private final static String APP = "app"; //属性文件名称
    private static String FIREFOX_DRIVER_PATH;
    private static String FIREFOX_APP_PATH;
    private static String CHROME_DRIVER_PATH;
    private static String CHROME_APP_PATH;
    private static String IE_DRIVER_PATH;
    private static String IE_APP_PATH;
    private static String URL;
    private static String URI;
    private static String USERNAME;
    private static String PASSWORD;
    private static String REDIS_HOST;
    private static String REDIS_PORT;
    private static String REDIS_DB;

    private static String ORACLE_DRIVERCLASSNAME;
    private static String ORACLE_URL;
    private static String ORACLE_USERNAME;
    private static String ORACLE_PSW;

    private static String MYSQL_DRIVERCLASSNAME;
    private static String MYSQL_URL;
    private static String MYSQL_USERNAME;
    private static String MYSQL_PSW;

    private static String LANGUAGE_COUNTRY;
    private static String RESULT_PRINT;
    private static String VALIDATE;
    private static String DATABASETYPE;
    private static String HEADER_CONTEXT_TYPE;
    private static String RETRY_TIMES;

    public static String getFIREFOX_DRIVER_PATH() {
        return FIREFOX_DRIVER_PATH;
    }

    public static String getFIREFOX_APP_PATH() {
        return FIREFOX_APP_PATH;
    }

    public static String getCHROME_DRIVER_PATH() {
        return CHROME_DRIVER_PATH;
    }

    public static String getCHROME_APP_PATH() {
        return CHROME_APP_PATH;
    }

    public static String getIE_DRIVER_PATH() {
        return IE_DRIVER_PATH;
    }

    public static String getIE_APP_PATH() {
        return IE_APP_PATH;
    }

    public static String getURL() {
        return URL;
    }

    public static String getURI() {
        return URI;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getREDIS_HOST() {
        return REDIS_HOST;
    }

    public static String getREDIS_PORT() {
        return REDIS_PORT;
    }

    public static String getREDIS_DB() {
        return REDIS_DB;
    }

    public static String getORACLE_DRIVERCLASSNAME() {
        return ORACLE_DRIVERCLASSNAME;
    }

    public static String getORACLE_URL() {
        return ORACLE_URL;
    }

    public static String getORACLE_USERNAME() {
        return ORACLE_USERNAME;
    }

    public static String getORACLE_PSW() {
        return ORACLE_PSW;
    }

    public static String getMYSQL_DRIVERCLASSNAME() {
        return MYSQL_DRIVERCLASSNAME;
    }

    public static String getMYSQL_URL() {
        return MYSQL_URL;
    }

    public static String getMYSQL_USERNAME() {
        return MYSQL_USERNAME;
    }

    public static String getMYSQL_PSW() {
        return MYSQL_PSW;
    }

    public static String getLANGUAGE_COUNTRY() {
        return LANGUAGE_COUNTRY;
    }

    public static String getRESULT_PRINT() {
        return RESULT_PRINT;
    }

    public static String getVALIDATE() {
        return VALIDATE;
    }

    public static String getDATABASETYPE() {
        return DATABASETYPE;
    }

    public static String getHEADER_CONTEXT_TYPE() {
        return HEADER_CONTEXT_TYPE;
    }

    public static String getRETRY_TIMES() {
        return RETRY_TIMES;
    }

    static {
        log.info("开始初始化配置文件");
        readAppConfig();
        log.info("初始化配置文件结束");
    }

    /**
     * @Title: readBrowserConfig
     * @Description: 读取app配置文件
     */
    private static void readAppConfig() {
        // PropertyResourceBundle使用属性文件中的静态字符串集合来管理语言环境资源。
        try {
            PropertyResourceBundle prb = (PropertyResourceBundle) PropertyResourceBundle.getBundle(APP);
            Enumeration<String> enu = prb.getKeys();

            if(enu.hasMoreElements()){
                if(null != prb.handleGetObject("FIREFOX.DRIVER.PATH")){
                    FIREFOX_DRIVER_PATH = prb.getString("FIREFOX.DRIVER.PATH");
                }
                if(null != prb.handleGetObject("FIREFOX.APP.PATH")){
                    FIREFOX_APP_PATH = prb.getString("FIREFOX.APP.PATH");
                }
                if(null != prb.handleGetObject("CHROME.DRIVER.PATH")){
                    CHROME_DRIVER_PATH = prb.getString("CHROME.DRIVER.PATH");
                }
                if(null != prb.handleGetObject("CHROME.APP.PATH")){
                    CHROME_APP_PATH = prb.getString("CHROME.APP.PATH");
                }
                if(null != prb.handleGetObject("IE.DRIVER.PATH")){
                    IE_DRIVER_PATH = prb.getString("IE.DRIVER.PATH");
                }
                if(null != prb.handleGetObject("IE.APP.PATH")){
                    IE_APP_PATH = prb.getString("IE.APP.PATH");
                }
                if(null != prb.handleGetObject("URL")){
                    URL = prb.getString("URL");
                }
                if(null != prb.handleGetObject("URI")){
                    URI = prb.getString("URI");
                }
                if(null != prb.handleGetObject("USERNAME")){
                    USERNAME = prb.getString("USERNAME");
                }
                if(null != prb.handleGetObject("PASSWORD")){
                    PASSWORD = prb.getString("PASSWORD");
                }
                if(null != prb.handleGetObject("REDIS_HOST")){
                    REDIS_HOST = prb.getString("REDIS_HOST");
                }
                if(null != prb.handleGetObject("REDIS_PORT")){
                    REDIS_PORT = prb.getString("REDIS_PORT");
                }
                if(null != prb.handleGetObject("REDIS_DB")){
                    REDIS_DB = prb.getString("REDIS_DB");
                }
                if(null != prb.handleGetObject("ORACLE_DRIVER_CLASSNAME")){
                    ORACLE_DRIVERCLASSNAME = prb.getString("ORACLE_DRIVER_CLASSNAME");
                }
                if(null != prb.handleGetObject("ORACLE_URL")){
                    ORACLE_URL = prb.getString("ORACLE_URL");
                }
                if(null != prb.handleGetObject("ORACLE_USERNAME")){
                    ORACLE_USERNAME = prb.getString("ORACLE_USERNAME");
                }
                if(null != prb.handleGetObject("ORACLE_PSW")){
                    ORACLE_PSW = prb.getString("ORACLE_PSW");
                }
                if(null != prb.handleGetObject("MYSQL_DRIVER_CLASSNAME")){
                    MYSQL_DRIVERCLASSNAME = prb.getString("MYSQL_DRIVER_CLASSNAME");
                }
                if(null != prb.handleGetObject("MYSQL_URL")){
                    MYSQL_URL = prb.getString("MYSQL_URL");
                }
                if(null != prb.handleGetObject("MYSQL_USERNAME")){
                    MYSQL_USERNAME = prb.getString("MYSQL_USERNAME");
                }
                if(null != prb.handleGetObject("MYSQL_PSW")){
                    MYSQL_PSW = prb.getString("MYSQL_PSW");
                }
                if(null != prb.handleGetObject("LANGUAGE_COUNTRY")){
                    LANGUAGE_COUNTRY = prb.getString("LANGUAGE_COUNTRY");
                }
                if(null != prb.handleGetObject("RESULT_PRINT")){
                    RESULT_PRINT = prb.getString("RESULT_PRINT");
                }
                if(null != prb.handleGetObject("VALIDATE")){
                    VALIDATE = prb.getString("VALIDATE");
                }
                if(null != prb.handleGetObject("DATABASE_TYPE")){
                    DATABASETYPE = prb.getString("DATABASE_TYPE");
                }
                if(null != prb.handleGetObject("HEADER_CONTEXT_TYPE")){
                    HEADER_CONTEXT_TYPE = prb.getString("HEADER_CONTEXT_TYPE");
                }
                if(null != prb.handleGetObject("RETRY_TIMES")){
                    RETRY_TIMES = prb.getString("RETRY_TIMES");
                } else {
                    RETRY_TIMES = "1";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.toString());
        }
    }
}
