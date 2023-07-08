package cn.automation.MySelenium.AutomationTestCommon.helper;

import cn.automation.MySelenium.AutomationTestCommon.MyWebDriver;
import cn.automation.MySelenium.AutomationTestCommon.WebDriverFactory;
import cn.automation.MySelenium.AutomationTestCommon.util.Constants;

public class PopUpHelper {
    /**
     * 点击提示对话框的确认按钮，并且返回提示框中的提示内容
     * @return
     */
    public static String clickOnAlert() {
        String alertText = "";
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                alertText = WebDriverFactory.getMyDriverInst().getAlert();
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    alertText = WebDriverFactory.getMyDriverInst().getAlert();
                }
            }
        }
        return alertText;
    }

    /**
     * 获取输入对话框中的提示信息
     * @return
     */
    public static String getPrompt() {
        String propmtText = "";
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                propmtText = WebDriverFactory.getMyDriverInst().getPrompt();
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    propmtText = WebDriverFactory.getMyDriverInst().getPrompt();
                }
            }
        }
        return propmtText;
    }

    /**
     * 获取警告对话框的提示信息
     * @return
     */
    public static String getTextOnConfirmation() {
        String confirmationText = "";
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                confirmationText = WebDriverFactory.getMyDriverInst().getConfirmation();
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    confirmationText = WebDriverFactory.getMyDriverInst().getConfirmation();
                }
            }
        }
        return confirmationText;
    }

    /**
     * 点击告警对话框的确认按钮，并且返回提示框中的提示内容
     * @return
     */
    public static String clickOnConfirmation() {
        MyWebDriver myWebDriver = WebDriverFactory.getMyDriverInst();
        String text = myWebDriver.getConfirmation();
        myWebDriver.chooseOkOnNextConfirmation();
        return text;
    }

    /**
     * 点击告警对话框的取消按钮，并且返回提示框中的提示内容
     * @return
     */
    public static String clickCancelConfirmation() {
        MyWebDriver myWebDriver = WebDriverFactory.getMyDriverInst();
        String text = myWebDriver.getConfirmation();
        myWebDriver.chooseCancelOnNextConfirmation();
        return text;
    }

    /**
     * 在输入对话框中输入内容，并且点击确认按钮
     * @param text
     * @return
     */
    public static void clickOkOnPrompt(String text) {
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                WebDriverFactory.getMyDriverInst().answerOnNextPrompt(text);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().answerOnNextPrompt(text);
                }
            }
        }
    }

    /**
     * 判断是否存在提示对话框
     * @return
     */
    public static boolean isAlertExit() {
        boolean isAlert = false;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                isAlert = WebDriverFactory.getMyDriverInst().isAlertPresent();
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    isAlert = WebDriverFactory.getMyDriverInst().isAlertPresent();
                }
            }
        }
        return isAlert;
    }

    /**
     * 判断是否存在警告对话框
     * @return
     */
    public static boolean isConfirmationExit() {
        boolean isConfirmationExit = false;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                isConfirmationExit = WebDriverFactory.getMyDriverInst().isConfirmationPresent();
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    isConfirmationExit = WebDriverFactory.getMyDriverInst().isConfirmationPresent();
                }
            }
        }
        return isConfirmationExit;
    }

    /**
     * 判断是否存在输入对话框
     * @return
     */
    public static boolean isPromptExit() {
        boolean isPromptExit = false;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                isPromptExit = WebDriverFactory.getMyDriverInst().isPromptPresent();
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    isPromptExit = WebDriverFactory.getMyDriverInst().isPromptPresent();
                }
            }
        }
        return isPromptExit;
    }
}
