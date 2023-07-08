package cn.automation.MySelenium.AutomationTestCommon.helper;

import cn.automation.MySelenium.AutomationTestCommon.WebDriverFactory;
import cn.automation.MySelenium.AutomationTestCommon.util.Constants;

/**
 * 鼠标操作帮助类
 */
public class MouseHelper {

    /**
     * 鼠标移动到指定对象上
     * @param locator
     */
    public static void mouseOver(String locator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().mouseOver(locator);
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0)
                    WebDriverFactory.getMyDriverInst().mouseOver(locator);
            }
    }

    /**
     * 在指定对象上按下鼠标左键
     * @param locator
     */
    public static void mouseDown(String locator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().mouseDown(locator);
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0)
                    WebDriverFactory.getMyDriverInst().mouseDown(locator);
            }
    }

    /**
     * 在指定对象上按下鼠标右键
     * @param locator
     */
    public static void mouseDownRight(String locator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().mouseDownRight(locator);
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0)
                    WebDriverFactory.getMyDriverInst().mouseDownRight(locator);
            }
    }

    /**
     * 在指定对象上释放鼠标右键
     * @param locator
     */
    public static void mouseUp(String locator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().mouseUp(locator);
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0)
                    WebDriverFactory.getMyDriverInst().mouseUp(locator);
            }
    }

    /**
     * 鼠标移动到指定对象上
     * @param locator
     */
    public static void mouseMove(String locator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().mouseMove(locator);
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0)
                    WebDriverFactory.getMyDriverInst().mouseMove(locator);
            }
    }
}
