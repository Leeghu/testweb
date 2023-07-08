package cn.automation.MySelenium.AutomationTestCommon;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



//



public class MyWebDriver implements IMyWebDriver {
    private WebDriverFactory webDriver = new WebDriverFactory();
    private static final Logger log = Logger.getLogger(MyWebDriver.class);

    public WebElement findElement(String locator) {
        if (locator.startsWith("id=")) {
            return WebDriverFactory.getDriverInst().findElement(By.id(locator.substring("id=".length())));
        }
        if (locator.startsWith("name=")) {
            return WebDriverFactory.getDriverInst().findElement(By.name(locator.substring("name=".length())));
        }
        if (locator.startsWith("xpath")) {
            return WebDriverFactory.getDriverInst().findElement(By.xpath(locator.substring("xpath=".length())));
        }
        if (locator.startsWith("//")) {
            return  WebDriverFactory.getDriverInst().findElement(By.xpath(locator));
        }
        if (locator.startsWith("css=")) {
            return WebDriverFactory.getDriverInst().findElement(By.cssSelector(locator.substring("css=".length())));
        }
        if (locator.startsWith("link")) {
            return WebDriverFactory.getDriverInst().findElement(By.linkText(locator.substring("link=".length())));
        }
        try {
            return WebDriverFactory.getDriverInst().findElement(By.id(locator));
        } catch (Exception e) {
            return WebDriverFactory.getDriverInst().findElement(By.name(locator));
        }
    }

    public boolean findElementPresent(String locator) {
        boolean status = false;

        if (locator.startsWith("id=")) {
            try {
                WebDriverFactory.getDriverInst().findElement(By.id(locator.substring("id=".length())));
                status = true;
            } catch (org.openqa.selenium.NoSuchElementException e) {
                status = false;
            } catch (org.openqa.selenium.NoSuchFrameException e) {
                status = false;
            }
        }

        if (locator.startsWith("name=")) {
            try {
                WebDriverFactory.getDriverInst().findElement(By.name(locator.substring("name=".length())));
                status = true;
            } catch (org.openqa.selenium.NoSuchElementException e) {
                status = false;
            } catch (org.openqa.selenium.NoSuchFrameException e) {
                status = false;
            }
        }

        if (locator.startsWith("xpath=")) {
            try {
                WebDriverFactory.getDriverInst().findElement(By.xpath(locator.substring("xpath=".length())));
                status = true;
            } catch (org.openqa.selenium.NoSuchElementException e) {
                status = false;
            } catch (org.openqa.selenium.NoSuchFrameException e) {
                status = false;
            }
        }

        if (locator.startsWith("//")) {
            try {
                WebDriverFactory.getDriverInst().findElement(By.xpath(locator));
                status = true;
            } catch (org.openqa.selenium.NoSuchElementException e) {
               //
                status = false;
            } catch (org.openqa.selenium.NoSuchFrameException e) {
                status = false;
            }
        }

        if (locator.startsWith("css=")) {
            try {
                WebDriverFactory.getDriverInst().findElement(By.cssSelector(locator.substring("css=".length())));
                status = true;
            } catch (org.openqa.selenium.NoSuchElementException e) {
                status = false;
            } catch (org.openqa.selenium.NoSuchFrameException e) {
                status = false;
            }
        }
        return status;
    }

    public void start() {
        webDriver.getFirefoxDriverInst();
    }

    public void start(String Browser) {
        try {
            if (Browser.equalsIgnoreCase("firefox")) {
                webDriver.getFirefoxDriverInst();
            } else if (Browser.equalsIgnoreCase("chrome")) {
                webDriver.getChromeDriverInst();
            } else {
                webDriver.getInternetExplorerDriverInst();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.toString());
        }
    }

    public void stop() {
        WebDriverFactory.getDriverInst().quit();
    }

    public void click(String paramString) {
        findElement(paramString).click();

    }

    public void jsClick(String paramString) {
        WebElement target = findElement(paramString);
        ((JavascriptExecutor) WebDriverFactory.getDriverInst()).executeScript("arguments[0].click();",
                new Object[] { target });
    }

    public void doScroll(String paramString, String paramString2) {
        WebElement scroll = findElement(paramString);
        WebElement target = findElement(paramString2);
        ((JavascriptExecutor) WebDriverFactory.getDriverInst()).executeScript("arguments[0].scrollLeft = 0;",
                new Object[] { scroll });
        ((JavascriptExecutor) WebDriverFactory.getDriverInst()).executeScript("arguments[0].scrollTop = 0;",
                new Object[] { scroll });

        if (target.getLocation().x > scroll.getLocation().x + scroll.getSize().width) {
            int scrollX = target.getLocation().x - scroll.getLocation().x
                    + (target.getSize().width - scroll.getSize().width) / 2;
            ((JavascriptExecutor) WebDriverFactory.getDriverInst())
                    .executeScript("arguments[0].scrollLeft = " + scrollX + ";", new Object[] { scroll });
        }

        if (target.getLocation().y > scroll.getLocation().y + scroll.getSize().height) {
            int scrollY = target.getLocation().y - scroll.getLocation().y
                    + (target.getSize().height - scroll.getSize().height) / 2;
            ((JavascriptExecutor) WebDriverFactory.getDriverInst())
                    .executeScript("arguments[0].scrollTop = " + scrollY + ";", new Object[] { scroll });
        }

    }

    public void doubleClick(String paramString) {
        //
        findElement(paramString).click();
        findElement(paramString).click();
    }

    public void contextMenu(String paramString) {

    }

    public void ClickAt(String paramString1, String paramString2) {

    }

    public void doubleClickAt(String paramString1, String paramString2) {

    }

    public void contextMenuAt(String paramString1, String paramString2) {

    }

    public void focus(String paramString) {

    }

    public void keyPress(String paramString1, String paramString2) {
        new Actions(WebDriverFactory.getDriverInst())
                .sendKeys(findElement(paramString1), new CharSequence[] { Keys.valueOf(paramString2) }).perform();
    }

    public void shiftKeyDown() {
        new Actions(WebDriverFactory.getDriverInst()).keyDown(Keys.SHIFT).perform();

    }

    public void shiftKeyUp() {
        new Actions(WebDriverFactory.getDriverInst()).keyUp(Keys.SHIFT).perform();

    }

    public void metaKeyDown() {
        new Actions(WebDriverFactory.getDriverInst()).keyDown(Keys.META).perform();

    }

    public void metaKeyUp() {
        new Actions(WebDriverFactory.getDriverInst()).keyUp(Keys.META).perform();

    }

    public void altKeyDown() {
        new Actions(WebDriverFactory.getDriverInst()).keyDown(Keys.ALT).perform();

    }

    public void altKeyUp() {
        new Actions(WebDriverFactory.getDriverInst()).keyUp(Keys.ALT).perform();

    }

    public void controlKeyDown() {
        new Actions(WebDriverFactory.getDriverInst()).keyDown(Keys.CONTROL).perform();

    }

    public void controlKeyUp() {
        new Actions(WebDriverFactory.getDriverInst()).keyUp(Keys.CONTROL).perform();

    }

    public void keyDown(String paramString1, String paramString2) {
        new Actions(WebDriverFactory.getDriverInst()).keyDown(findElement(paramString1), Keys.valueOf(paramString2))
                .perform();
    }

    public void keyUp(String paramString1, String paramString2) {
        new Actions(WebDriverFactory.getDriverInst()).keyUp(findElement(paramString1), Keys.valueOf(paramString2))
                .perform();

    }

    public void mouseOver(String paramString) {
        new Actions(WebDriverFactory.getDriverInst()).moveToElement(findElement(paramString)).perform();

    }

    public void mouseOut(String paramString) {
        new Actions(WebDriverFactory.getDriverInst()).moveToElement(findElement(paramString), -10, -10).perform();

    }

    public void mouseDown(String paramString) {
        new Actions(WebDriverFactory.getDriverInst()).clickAndHold(findElement(paramString)).perform();

    }

    public void mouseDownRight(String paramString) {
        //
        new Actions(WebDriverFactory.getDriverInst()).contextClick(findElement(paramString)).perform();

    }

    public void mouseDownAt(String paramString1, String paramString2) {

    }

    public void mouseDownRightAt(String paramString1, String paramString2) {

    }

    public void mouseUp(String paramString) {
        new Actions(WebDriverFactory.getDriverInst()).release(findElement(paramString)).perform();

    }

    public void mouseUpRight(String paramString) {

    }

    public void mouseUpAt(String paramString1, String paramString2) {

    }

    public void mouseUpRightAt(String paramString1, String paramString2) {

    }

    public void mouseMove(String paramString) {
        new Actions(WebDriverFactory.getDriverInst()).moveToElement(findElement(paramString)).perform();

    }

    public void mouseMoveAt(String paramString1, String paramString2) {

    }

    public void type(String paramString1, String paramString2) {
        findElement(paramString1).sendKeys(new CharSequence[] { paramString2 });

    }

    public void typeKeys(String paramString1, String paramString2) {

    }

    public void check(String paramString) {
        WebElement checkElement = findElement(paramString);
        if (!(checkElement.isSelected()))
            checkElement.click();
    }

    public void uncheck(String paramString) {
        WebElement checkElement = findElement(paramString);
        if (checkElement.isSelected())
            checkElement.click();
    }

    public void select(String paramString1, String paramString2) {
        Select selectElement = new Select(findElement(paramString1));
        if (paramString2.startsWith("value=")) {
            selectElement.selectByValue(paramString2.substring("value=".length()));
        } else if (paramString2.startsWith("index=")) {
            selectElement.selectByIndex(Integer.parseInt(paramString2.substring("index=".length())));
        } else if (paramString2.startsWith("label=")) {
            selectElement.selectByVisibleText(paramString2.substring("label=".length()));
        } else
            selectElement.selectByVisibleText(paramString2);

    }

    public void addSelection(String paramString1, String paramString2) {
        Select selectElement = new Select(findElement(paramString1));
        if (paramString2.startsWith("value=")) {
            selectElement.selectByValue(paramString2.substring("value=".length()));
        } else if (paramString2.startsWith("index=")) {
            selectElement.selectByIndex(Integer.parseInt(paramString2.substring("index=".length())));
        } else if (paramString2.startsWith("label=")) {
            selectElement.selectByVisibleText(paramString2.substring("label=".length()));
        } else
            selectElement.selectByVisibleText(paramString2);
    }

    public void removeSelection(String paramString1, String paramString2) {
        Select selectElement = new Select(findElement(paramString1));
        if (paramString2.startsWith("value=")) {
            selectElement.deselectByValue(paramString2.substring("value=".length()));
        } else if (paramString2.startsWith("index=")) {
            selectElement.deselectByIndex(Integer.parseInt(paramString2.substring("index=".length())));
        } else if (paramString2.startsWith("label=")) {
            selectElement.deselectByVisibleText(paramString2.substring("label=".length()));
        } else
            selectElement.deselectByVisibleText(paramString2);
    }

    public void removeAllSelection(String paramString) {
        Select selectElement = new Select(findElement(paramString));
        selectElement.deselectAll();

    }

    public void submit(String paramString) {

    }

    public void open(String paramString) {

        WebDriverFactory.getDriverInst().get(paramString);

    }

    public void openWindow(String paramString1, String paramString2) {

    }

    public void selectWindow(String paramString) {
        Set<?> handlers = WebDriverFactory.getDriverInst().getWindowHandles();
        Iterator<?> it = handlers.iterator();
        while (it.hasNext()) {
            WebDriver window = WebDriverFactory.getDriverInst().switchTo().window((String) it.next());
            if (window.getTitle().equals(paramString))
                return;
        }
    }

    public void selectFrame(String paramString) {
        if (paramString.startsWith("index=")) {
           WebDriverFactory.getDriverInst().switchTo()
                .frame(Integer.parseInt(paramString.substring("index=".length())));

            return;
        }
        if (paramString.startsWith("//")) {
            WebDriverFactory.getDriverInst().switchTo()
                    .frame(WebDriverFactory.getDriverInst().findElement(By.xpath(paramString)));

            return;
        }
        if (paramString.startsWith("xpath")) {
            WebDriverFactory.getDriverInst().switchTo()
                    .frame(WebDriverFactory.getDriverInst().findElement(By.xpath(paramString.substring("xpath=".length()))));

            return;
        }
        WebDriverFactory.getDriverInst().switchTo().frame(paramString);

    }

    public void chooseCancelOnNextConfirmation() {
        WebDriverFactory.getDriverInst().switchTo().alert().dismiss();

    }

    public void chooseOkOnNextConfirmation() {
        WebDriverFactory.getDriverInst().switchTo().alert().accept();

    }

    public void answerOnNextPrompt(String paramString) {
        WebDriverFactory.getDriverInst().switchTo().alert().sendKeys(paramString);
        WebDriverFactory.getDriverInst().switchTo().alert().accept();

    }

    public void goBack() {
        WebDriverFactory.getDriverInst().navigate().back();

    }

    public void refresh() {
        WebDriverFactory.getDriverInst().navigate().refresh();

    }

    public void close() {
        WebDriverFactory.getDriverInst().switchTo().defaultContent().close();

    }

    public boolean isAlertPresent() {
        Boolean isPresent = Boolean.valueOf(true);
        try {
            WebDriverFactory.getDriverInst().switchTo().alert();
        } catch (Exception e) {
            isPresent = Boolean.valueOf(false);
        }
        return isPresent.booleanValue();
    }

    public boolean isPromptPresent() {
        return isAlertPresent();
    }

    public boolean isConfirmationPresent() {
        return isAlertPresent();
    }

    public String getAlert() {
        String alertText = WebDriverFactory.getDriverInst().switchTo().alert().getText();
        WebDriverFactory.getDriverInst().switchTo().alert().accept();
        return alertText;
    }

    public String getConfirmation() {
        return WebDriverFactory.getDriverInst().switchTo().alert().getText();
    }

    public String getPrompt() {
        return WebDriverFactory.getDriverInst().switchTo().alert().getText();
    }

    public String getLocation() {

        return WebDriverFactory.getDriverInst().getCurrentUrl();
    }

    public String getTitle() {
        return WebDriverFactory.getDriverInst().getTitle();
    }

    public String getBodyText() {
        return WebDriverFactory.getDriverInst().getPageSource();
    }

    public String getValue(String paramString) {
        return findElement(paramString).getAttribute("value");
    }

    public String getText(String paramString) {
        return findElement(paramString).getText();
    }

    public void highlight(String paramString) {
        WebElement element = findElement(paramString);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriverInst();
        System.out.println(js.executeScript("return arguments[0].style.border", new Object[] { element }));
        log.info(js.executeScript("return arguments[0].style.border", new Object[] { element }));
        js.executeScript("arguments[0].style.border='3px solid red';", new Object[] { element });

    }

    public String getEval(String paramString) {
        Object result = ((JavascriptExecutor) WebDriverFactory.getDriverInst()).executeScript(paramString,
                new Object[0]);

        if (result == null) {
            return "";
        }
        return result.toString();
    }

    public boolean isChecked(String paramString) {
        return findElement(paramString).isSelected();
    }

    public String getTable(String paramString) {
        return null;
    }

    public String[] getSelectedLabels(String paramString) {
        Select select = new Select(findElement(paramString));

        List<?> listSelected = select.getAllSelectedOptions();
        if ((listSelected == null) || (listSelected.size() <= 0)) {
            return new String[0];
        }
        String[] selectLabels = new String[listSelected.size()];
        for (int i = 0; i < listSelected.size(); ++i) {
            selectLabels[i] = ((WebElement) listSelected.get(i)).getText();
        }
        return selectLabels;
    }

    public String getSelectedLabel(String paramString) {
        Select select = new Select(findElement(paramString));
        return select.getFirstSelectedOption().getText();
    }

    public String[] getSelectedValues(String paramString) {
        return new String[0];
    }

    public String getSelectedValue(String paramString) {
        return null;
    }

    public String[] getSelectedIndexes(String paramString) {
        return new String[0];
    }

    public String getSelectedIndex(String paramString) {
        return null;
    }

    public String[] getSelectedIds(String paramString) {
        return new String[0];
    }

    public String getSelectedId(String paramString) {
        return null;
    }

    public boolean isSomethingSelected(String paramString) {
        Select select = new Select(findElement(paramString));
        List<?> listSelected = select.getAllSelectedOptions();

        return ((listSelected != null) && (listSelected.size() > 0));
    }

    public String[] getSelectOptions(String paramString) {
        Select select = new Select(findElement(paramString));

        List<?> listOptions = select.getOptions();
        if ((listOptions == null) || (listOptions.size() <= 0)) {
            return new String[0];
        }
        String[] labels = new String[listOptions.size()];
        for (int i = 0; i < listOptions.size(); ++i) {
            labels[i] = ((WebElement) listOptions.get(i)).getText();
        }
        return labels;
    }

    public String getAttribute(String paramString) {
        int atIndex = paramString.lastIndexOf("@");
        String locator = paramString.substring(0, atIndex);
        if (locator.endsWith("/")) {
            locator = locator.substring(0, locator.length() - 1);
        }
        String attribute = paramString.substring(atIndex + 1);
        return findElement(locator).getAttribute(attribute);
    }

    public boolean isTextPresent(String paramString) {
        String Xpath = "//*[contains(text(),'" + paramString + "')]";
        try {
            WebDriverFactory.getDriverInst().findElement(By.xpath(Xpath));
            return true;
        } catch (Exception e){
            log.error(e.toString());
            e.printStackTrace();
        }
        return false;
    }

    public boolean isElementPresent(String paramString) {
        return findElementPresent(paramString);
    }

    public boolean isVisible(String paramString) {
        return findElement(paramString).isDisplayed();
    }

    public boolean isEditable(String paramString) {
        return findElement(paramString).isEnabled();
    }

    public void windowFocus() {

    }

    public void windowMaximize() {
        WebDriverFactory.getDriverInst().manage().window().maximize();

    }

    public String[] getAllWindowIds() {
        return new String[0];
    }

    public String[] getAllWindowNames() {
        return new String[0];
    }

    public String[] getAllWindowTitles() {
        return new String[0];
    }

    public String getHtmlSource() {
        return null;
    }

    public Number getElementPositionLeft(String paramString) {
        return Integer.valueOf(findElement(paramString).getLocation().getX());
    }

    public Number getElementPositionTop(String paramString) {
        return Integer.valueOf(findElement(paramString).getLocation().getY());
    }

    public Number getElementWidth(String paramString) {
        return Integer.valueOf(findElement(paramString).getSize().getWidth());
    }

    public Number getElementHeight(String paramString) {
        return Integer.valueOf(findElement(paramString).getSize().getHeight());
    }

    public Number getXpathCount(String paramString) {
        if (paramString.startsWith("xpath=")) {
            return Integer.valueOf(WebDriverFactory.getDriverInst()
                    .findElements(By.xpath(paramString.substring("xpath=".length()))).size());
        }
        return Integer.valueOf(WebDriverFactory.getDriverInst().findElements(By.xpath(paramString)).size());
    }

    public void setTimeout(String paramString) {

    }

    public void waitForPageToLoad(String paramString) {

    }

    public void waitForFrameToLoad(String paramString1, String paramString2) {

    }

    public String getCookie() {
        return null;
    }

    public String getCookieByName(String paramString) {
        return null;
    }

    public boolean isCookiePresent(String paramString) {
        return false;
    }

    public void createCookie(String paramString1, String paramString2) {

    }

    public void deleteCookie(String paramString1, String paramString2) {

    }

    public void deleteAllVisibleCookies() {

    }

    public void setBrowserLogLevel(String paramString) {

    }

    public void runScript(String paramString) {

    }

    public void useXpathLibrary(String paramString) {

    }

    public void setContext(String paramString) {

    }

    public void keyDownNative(String paramString) {

    }

    public void keyUpNative(String paramString) {

    }

    public void keyPressNative(String paramString) {
        new Actions(WebDriverFactory.getDriverInst()).sendKeys(new CharSequence[] { Keys.valueOf(paramString) })
                .perform();
    }

    public void defaultContent() {
        WebDriverFactory.getDriverInst().switchTo().defaultContent();
    }

    public void parentFrame() {
        WebDriverFactory.getDriverInst().switchTo().parentFrame();
    }

    public void clear(String paramString) {
        findElement(paramString).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        findElement(paramString).sendKeys(Keys.DELETE);
        findElement(paramString).clear();

    }

    public Set<String> getWindowHandlers() {

        return WebDriverFactory.getDriverInst().getWindowHandles();
    }

    public void selectWinByHandler() {

    }

    public String getWindowHandler() {
        return WebDriverFactory.getDriverInst().getWindowHandle();
    }

    public String getBrowserWinHandle() {
        return WebDriverFactory.getDriverInst().getWindowHandle();
    }

    public void downloadFile(String paramString1, String paramString2, String paramString3) {
//        WebDriverFactory.getDriverInst().downloadFile(String paramString1, String paramString2, String paramString3);
        findElement(paramString1).click();
    }

    public void screenshot() {
        //调用截图方法
        File src = ((TakesScreenshot) WebDriverFactory.getDriverInst()).getScreenshotAs(OutputType.FILE);

        try {
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            //拷贝截图文件到我们项目./Screenshots
            FileUtils.copyFile(src, new File(".\\target\\Screenshots\\"+dateFormat.format(date)+".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
