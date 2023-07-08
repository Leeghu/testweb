package cn.automation.MySelenium.AutomationTestCommon.helper;

import cn.automation.MySelenium.AutomationTestCommon.WebDriverFactory;

import java.util.Set;

public class BrowserHelper {
    /**
     * 启动浏览器
     * @param Browser
     */
    public static void start(String Browser) {
        WebDriverFactory.getMyDriverInst().start(Browser);
    }

    /**
     * 关闭所有该WebDriver实例浏览器，且停止WebDriver实例
     */
    public static void stop() {
        WebDriverFactory.getMyDriverInst().stop();
    }

    /**
     * 关闭当前页面
     */
    public static void close() {
        WebDriverFactory.getMyDriverInst().close();
    }

    /**
     * 浏览器窗口最大化
     */
    public static void windowMaximize() {
        WebDriverFactory.getMyDriverInst().windowMaximize();
    }

    /**
     * 获取当前页面所在frame的源码
     * @return
     */
    public static String getPageSource() {
        return WebDriverFactory.getMyDriverInst().getBodyText();
    }

    /**
     * 打开一个页面
     * @param baseUrl
     */
    public static void open(String baseUrl) {
        WebDriverFactory.getMyDriverInst().open(baseUrl);
    }

    /**
     * 浏览器切换到指定的窗口
     * @param windowTitle
     */
    public static void selectWindow(String windowTitle) {
        WebDriverFactory.getMyDriverInst().selectWindow(windowTitle);
    }

    /**
     * 点击页面的回退按钮
     */
    public static void goBack() {
        WebDriverFactory.getMyDriverInst().goBack();
    }

    /**
     * 点击页面的刷新按钮
     */
    public static void refresh() {
        WebDriverFactory.getMyDriverInst().refresh();
    }

    /**
     * 获得当前浏览器显示页面的绝对路径
     */
    public static void getLocation() {
        WebDriverFactory.getMyDriverInst().getLocation();
    }

    /**
     * 获取当前浏览器的标题，只返回当前激活窗口的标题
     */
    public static void getTitle() {
        WebDriverFactory.getMyDriverInst().getTitle();
    }

    /**
     * 在当前页面执行JS脚本
     * @param express
     * @return
     */
    public static String executeScript(String express) {
        return WebDriverFactory.getMyDriverInst().getEval(express);
    }

    /**
     * 获得浏览器句柄
     * @return
     */
    public static String getBrowserWindHandle() {
        return WebDriverFactory.getMyDriverInst().getBrowserWinHandle();
    }
    public static void highlight(String locator) {
        WebDriverFactory.getMyDriverInst().highlight(locator);
    }
    public static String getWindowHandler() {
        return WebDriverFactory.getMyDriverInst().getWindowHandler();
    }
    public static Set<String> getWindowHandlers() {
        return WebDriverFactory.getMyDriverInst().getWindowHandlers();
    }
    public static void screenshot() {
        WebDriverFactory.getMyDriverInst().screenshot();
    }
}
