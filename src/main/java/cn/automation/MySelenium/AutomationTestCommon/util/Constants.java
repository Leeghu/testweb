package cn.automation.MySelenium.AutomationTestCommon.util;

import test.v6.A;

public class Constants {
    public static int COUNT = 5;
    public static int INTERVAL = 500;

    public static String CHROME_DRIVER_PATH = AppConfig.getCHROME_DRIVER_PATH();
    public static String CHROME_APP_PATH = AppConfig.getCHROME_APP_PATH();
    public static String FIREFOX_DRIVER_PATH = AppConfig.getFIREFOX_DRIVER_PATH();
    public static String FIREFOX_APP_PATH=AppConfig.getFIREFOX_APP_PATH();
    public static String IE_DRIVER_PATH= AppConfig.getIE_DRIVER_PATH();
    public static String IE_APP_PATH=AppConfig.getIE_APP_PATH();

    public static String DATABASE_TYPE=AppConfig.getDATABASETYPE();

    public static String ORACLE_DRIVER_CLASSNAME=AppConfig.getORACLE_DRIVERCLASSNAME();
    public static String ORACLE_URL=AppConfig.getORACLE_URL();
    public static String ORACLE_USERNAME=AppConfig.getORACLE_USERNAME();
    public static String ORACLE_PSW=AppConfig.getORACLE_PSW();

    public static String MYSQL_DRIVER_CLASSNAME=AppConfig.getMYSQL_DRIVERCLASSNAME();
    public static String MYSQL_URL=AppConfig.getMYSQL_URL();
    public static String MYSQL_USERNAME=AppConfig.getMYSQL_USERNAME();
    public static String MYSQL_PSW=AppConfig.getMYSQL_PSW();

    public static String URL=AppConfig.getURL();
    public static String URI=AppConfig.getURI();
    public static String USERNAME=AppConfig.getUSERNAME();
    public static String PASSWORD=AppConfig.getPASSWORD();

    public static String REDIS_HOST=AppConfig.getREDIS_HOST();
    public static String REDIS_PORT=AppConfig.getREDIS_PORT();
    public static String REDIS_DB=AppConfig.getREDIS_DB();

    public static String LANGUAGE_COUNTRY=AppConfig.getLANGUAGE_COUNTRY();

    public static String RESULT_PRINT=AppConfig.getRESULT_PRINT();
    public static String VALIDATE=AppConfig.getVALIDATE();
    public static String HEADER_CONTEXT_TYPE=AppConfig.getHEADER_CONTEXT_TYPE();
    public static String RETRY_TIMES=AppConfig.getRETRY_TIMES();
}
