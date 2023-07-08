package cn.automation.MySelenium.AutomationTestCommon.helper;

import cn.automation.MySelenium.AutomationTestCommon.WebDriverFactory;

public class SleepHelper {
    /**
     * 等待固定时间
     * @param interval
     */
    public static void sleep(int interval) {
        try {
            Thread.sleep(interval);
        } catch(Exception e) {
        }
    }

    /**
     * 等待指定对象出现，等待总时间为interval*times*2
     * @param locator
     * @param interval
     * @param times
     */
    public static void sleep(String locator, int interval, int times) {
        int count = times;
        boolean flag = true;

        while (count > 0) {
            sleep(interval);
            flag = WebDriverFactory.getMyDriverInst().isElementPresent(locator);
            if (flag) {
                count = 0;
            } else {
                --count;
                sleep(interval);
            }
        }
    }

    /**
     * 等待指定对象消失，等待总时间为interval*times*2
     * @param locator
     * @param interval
     * @param times
     */
    public static void sleepLose(String locator, int interval, int times) {
        int count = times;
        boolean flag = true;

        while (count > 0) {
            sleep(interval);
            flag = WebDriverFactory.getMyDriverInst().isElementPresent(locator);
            if (!flag) {
                count = 0;
            } else {
                --count;
                sleep(interval);
            }
        }
    }
}
