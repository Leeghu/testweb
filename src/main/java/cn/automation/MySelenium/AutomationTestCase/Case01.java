package cn.automation.MySelenium.AutomationTestCase;

import cn.automation.MySelenium.AutomationTestCommon.helper.BrowserHelper;
import cn.automation.MySelenium.AutomationTestCommon.util.Constants;
import org.testng.annotations.Test;

public class Case01 {
    @Test
    public static void case0101() {
        BrowserHelper.start("chrome");
        BrowserHelper.open(Constants.URL);
        BrowserHelper.windowMaximize();

    }
}
