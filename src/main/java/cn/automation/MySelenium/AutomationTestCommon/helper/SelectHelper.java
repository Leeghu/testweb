package cn.automation.MySelenium.AutomationTestCommon.helper;

import cn.automation.MySelenium.AutomationTestCommon.WebDriverFactory;
import cn.automation.MySelenium.AutomationTestCommon.util.Constants;

public class SelectHelper {
    /**
     * 在指定下拉列表里选中选项，不清楚之前的选项
     *
     * @param locator
     * @param value   选项的标识 value=value index=index label=label
     */
    public static void select(String locator, String value) {
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                WebDriverFactory.getMyDriverInst().select(locator, value);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().select(locator, value);
                }
            }
        }
    }

    public static void selectOnly(String locator, String value){
        removeAllSelection(locator);
        select(locator, value);
    }

    /**
     *
     * @param locator
     * @param value
     */
    public static void addSelection(String locator, String value) {
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                WebDriverFactory.getMyDriverInst().addSelection(locator, value);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().addSelection(locator, value);
                }
            }
        }
    }

    /**
     *
     * @param locator
     * @param value
     */
    public static void removeSelection(String locator, String value) {
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                WebDriverFactory.getMyDriverInst().removeSelection(locator, value);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().removeSelection(locator, value);
                }
            }
        }
    }

    /**
     *
     * @param locator
     */
    public static void removeAllSelection(String locator) {
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                WebDriverFactory.getMyDriverInst().removeAllSelection(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().removeAllSelection(locator);
                }
            }
        }
    }

    /**
     *
     * @param locator
     * @return
     */
    public static String[] getSelectLabels(String locator) {
        return WebDriverFactory.getMyDriverInst().getSelectedLabels(locator);
    }

    /**
     *
     * @param locator
     * @return
     */
    public static String getSelectedLabel(String locator) {
        return WebDriverFactory.getMyDriverInst().getSelectedLabel(locator);

    }

    /**
     *
     * @param locator
     * @return
     */
    public static boolean isSomethingSelected(String locator) {
        return WebDriverFactory.getMyDriverInst().isSomethingSelected(locator);
    }

    /**
     *
     * @param locator
     * @return
     */
    public static String[] getSelectOptions(String locator) {
        String[] options = null;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                options = WebDriverFactory.getMyDriverInst().getSelectOptions(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    options = WebDriverFactory.getMyDriverInst().getSelectOptions(locator);
                }
            }
        }
        return options;
    }
}
