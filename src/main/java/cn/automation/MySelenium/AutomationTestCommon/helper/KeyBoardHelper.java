package cn.automation.MySelenium.AutomationTestCommon.helper;

import cn.automation.MySelenium.AutomationTestCommon.WebDriverFactory;
import cn.automation.MySelenium.AutomationTestCommon.util.Constants;

public class KeyBoardHelper {
    /**
     * 模拟在指定对象上按下并释放某键
     * @param locator
     * @param key
     */
    public static void keyPress(String locator, String key) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().keyPress(locator, key);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0)
                    WebDriverFactory.getMyDriverInst().keyPress(locator, key);
            }
    }

    /**
     * 操作键盘的某键
     * @param key
     */
    public static void keyPressNative(String key) {
        WebDriverFactory.getMyDriverInst().keyPressNative(key);
    }

    /**
     * 按下shift键，不释放
     */
    public static void shiftKeyDown() {
        WebDriverFactory.getMyDriverInst().shiftKeyDown();
    }

    /**
     * 释放shift键
     */
    public static void shiftKeyUp() {
        WebDriverFactory.getMyDriverInst().shiftKeyUp();
    }

    /**
     * 按下meta键，不释放
     */
    public static void metaKeyDown() {
        WebDriverFactory.getMyDriverInst().metaKeyDown();
    }

    /**
     * 释放meta键
     */
    public static void metaKeyUp() {
        WebDriverFactory.getMyDriverInst().metaKeyUp();
    }

    /**
     * 按下alt键，不释放
     */
    public static void altKeyDown() {
        WebDriverFactory.getMyDriverInst().altKeyDown();
    }

    /**
     * 释放alt键
     */
    public static void altKeyUp() {
        WebDriverFactory.getMyDriverInst().altKeyUp();
    }

    /**
     * 按下ctrl键，不释放
     */
    public static void controlKeyDown() {
        WebDriverFactory.getMyDriverInst().controlKeyDown();
    }

    /**
     * 释放ctrl键
     */
    public static void controlKeyUp() {
        WebDriverFactory.getMyDriverInst().controlKeyUp();
    }

    /**
     * 在指定对象上按下某键，不释放
     * @param locator
     * @param key
     */
    public static void keyDown(String locator, String key) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().keyDown(locator, key);
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0)
                    WebDriverFactory.getMyDriverInst().keyDown(locator, key);
            }
    }

    /**
     * 在指定对象上释放某键
     * @param locator
     * @param key
     */
    public static void keyUp(String locator, String key) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().keyUp(locator, key);
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0)
                    WebDriverFactory.getMyDriverInst().keyUp(locator, key);
            }
    }
}
