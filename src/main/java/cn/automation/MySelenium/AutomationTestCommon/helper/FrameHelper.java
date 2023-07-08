package cn.automation.MySelenium.AutomationTestCommon.helper;

import cn.automation.MySelenium.AutomationTestCommon.WebDriverFactory;
import cn.automation.MySelenium.AutomationTestCommon.util.Constants;

public class FrameHelper {
    /**
     * 选择指定的Frame
     * @param locator
     */
    public static void selectFrame(String locator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().selectFrame(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0)
                    WebDriverFactory.getMyDriverInst().selectFrame(locator);
            }

    }

    /**
     * 返回到页面顶层Frame
     */
    public static void getDefaultContent() {
        WebDriverFactory.getMyDriverInst().defaultContent();
    }

    /**
     * 返回到父层Frame
     */
    public static void getParentFame() {
        WebDriverFactory.getMyDriverInst().parentFrame();
    }
}
