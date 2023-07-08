package cn.automation.MySelenium.AutomationTestCommon;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cn.automation.MySelenium.AutomationTestCommon.util.AppConfig;

/**
 * @ClassName: WebDriverFactory
 * @Description: driverInst工厂
 * @author:
 * @date:
 *
 */
public class WebDriverFactory {
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal();
    private static final String userDataDir;

    /**
     * @Title: setDriverInst
     * @Description: 设置DriverInst
     * @param driverInst
     */
    public static void setDriverInst(WebDriver driverInst) {
        threadLocal.set(driverInst);
    }

    /**
     * @Title: getMyDriverInst
     * @Description: 获得getMyDriverInst
     * @return： myDriverInst
     * @throws:
     */
    public static MyWebDriver getMyDriverInst() {
        MyWebDriver myDriverInst = new MyWebDriver();
        return myDriverInst;
    }

    /**
     * @Title: getDriverInst
     * @Description: 获得driverInst(该实例是selenium实例，可直接调用selenium的方法)
     * @return：WebDriver
     * @throws:
     */
    public static WebDriver getDriverInst() {
        return threadLocal.get();
    }

    /**
     * @Tiltle: getFirefoxDriverInst
     *             、getChromeDriverInst、getInternetExplorerDriverInst
     * @Description: 获得driverInst(该实例是selenium实例，可直接调用selenium的方法)
     * @return
     * @throws:
     */
    public WebDriver getFirefoxDriverInst() {
        //

        System.setProperty("webdriver.gecko.driver", AppConfig.getFIREFOX_DRIVER_PATH());
        System.setProperty("webdriver.firefox.bin", AppConfig.getFIREFOX_APP_PATH());
        WebDriver driverInst = new FirefoxDriver();
        setDriverInst(driverInst);
        return driverInst;
    }
    static{
        File file = new File(FileUtils.getUserDirectoryPath() + File.separator + "autoCache");
        if (!file.exists()){
            file.mkdir();
        }
        userDataDir = file.getAbsolutePath();
    }
    public WebDriver getChromeDriverInst(){
        //
        System.setProperty("webdriver.chrome.driver",AppConfig.getCHROME_DRIVER_PATH());
        System.setProperty("webdriver.chrome.bin",AppConfig.getCHROME_APP_PATH());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");//取消显示信息栏(正在受自动软件控制)
//        options.addArguments("-incognito");//隐身模式启动
//        options.addArguments("--headless");//无头模式 静默模式
//        options.addArguments("--disable-gpu");
        options.addArguments("--disable-images");//禁用图像
        options.addArguments("--disable-plugins");//禁用加载所有插件
        options.addArguments("--disable-java");//禁用java
        options.addArguments("--disable-javascript");//禁用javascript
        options.addArguments("-disk-cache-size=819200");//指定Cache大小，单位Byte
//        options.addArguments("f'--user-data-dir='" + userDataDir + "'");//指定用户数据路径
        WebDriver driverInst = new ChromeDriver(options);
        setDriverInst(driverInst);
        return driverInst;
    }

    public WebDriver getInternetExplorerDriverInst(){

        System.setProperty("webdriver.chrome.driver", AppConfig.getIE_DRIVER_PATH());
        System.setProperty("webdriver.chrome.bin", AppConfig.getIE_APP_PATH());
        WebDriver driverInst = new InternetExplorerDriver();
        setDriverInst(driverInst);
        return driverInst;
    }
}
