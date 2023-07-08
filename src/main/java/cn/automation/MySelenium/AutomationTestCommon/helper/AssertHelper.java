package cn.automation.MySelenium.AutomationTestCommon.helper;

import cn.automation.MySelenium.AutomationTestCommon.assertion.Assert;
import cn.automation.MySelenium.AutomationTestCommon.assertion.Validate;
import cn.automation.MySelenium.AutomationTestCommon.util.Constants;
import org.apache.log4j.Logger;
import org.testng.Reporter;

public class AssertHelper extends Assert {
    private final static Logger log = Logger.getLogger(AssertHelper.class);

    public static boolean isEmptyString(String s) {
        return s==null||s.toUpperCase().equals("NULL")||s.trim().equals("");
    }

    /**
     * 逐一判断集合中的元素是否相等
     * @param subTest
     * @param subArray
     */
    public static void arrayEqual(String subTest[], String subArray[]){
        try{
            if("true".equalsIgnoreCase(Constants.VALIDATE)){
                Validate.assertArrayEquals(getLineInfo(), subTest, subArray);
            } else {
                Assert.assertArrayEquals(getLineInfo(), subTest, subArray);
            }
        } catch (Exception e) {
            log.info(e.getMessage() + "==>" + getLineInfo());
            Reporter.log(e.getMessage() + "==>" + getLineInfo());
        }
    }

    /**
     * 判断两元素是否相等
     * @param expected
     * @param actual
     */
    public static void assertEquals(String expected, String actual){
        try{
            if("true".equalsIgnoreCase(Constants.VALIDATE)){
                Validate.assertEquals(getLineInfo(), expected, actual);
            } else {
                Assert.assertEquals(getLineInfo(), expected, actual);
            }
        } catch (Exception e) {
            log.info(e.getMessage() + "==>" + getLineInfo());
            Reporter.log(e.getMessage() + "==>" + getLineInfo());
        }
    }

    /**
     * 判断字符串是否含有预期的内容
     * @param expected
     * @param actual
     */
    public static void assertContain(String expected, String actual){
        try{
            if("true".equalsIgnoreCase(Constants.VALIDATE)){
                Validate.assertContain(expected, actual);
            } else {
                Assert.assertContain(expected, actual);
            }
        } catch (Exception e) {
            log.info(e.getMessage() + "==>" + getLineInfo());
            Reporter.log(e.getMessage() + "==>" + getLineInfo());
        }
    }

    /**
     * 获取断言信息,打印信息如下：true ======= > 控件：User ==> *file.java: 165 ==> expected: * ==> actual: *
     * @return
     */
    public static String getLineInfo() {
        StackTraceElement[] ste = new Throwable().getStackTrace();
        StringBuffer sbuffer = new StringBuffer();
        for (int i = 0; i < ste.length && i < 5; i++) {
            if (ste[i].getFileName().startsWith("TF")){
                sbuffer.append("Testing==>>" + ste[i].getFileName() + ": Line " + ste[i].getLineNumber() + " ==>");
            }
        }
        return sbuffer.toString();
    }
}
