package cn.automation.MySelenium.AutomationTestCommon;

import java.util.Set;

public abstract interface IMyWebDriver {
    /**
     *
     */

    public abstract void start();

    public abstract void start(String paramString);

    public abstract void stop();

    public abstract void click(String paramString);

    public abstract void jsClick(String paramString);

    public abstract void doScroll(String paramString1, String paramString2);

    public abstract void doubleClick(String paramString);

    public abstract void contextMenu(String paramString);

    public abstract void ClickAt(String paramString1, String paramString2);

    public abstract void doubleClickAt(String paramString1, String paramString2);

    public abstract void contextMenuAt(String paramString1, String paramString2);

    public abstract void focus(String paramString);

    public abstract void keyPress(String paramString1, String paramString2);

    public abstract void shiftKeyDown();

    public abstract void shiftKeyUp();

    public abstract void metaKeyDown();

    public abstract void metaKeyUp();

    public abstract void altKeyDown();

    public abstract void altKeyUp();

    public abstract void controlKeyDown();

    public abstract void controlKeyUp();

    public abstract void keyDown(String paramString1, String paramString2);

    public abstract void keyUp(String paramString1, String paramString2);

    public abstract void mouseOver(String paramString);

    public abstract void mouseOut(String paramString);

    public abstract void mouseDown(String paramString);

    public abstract void mouseDownRight(String paramString);

    public abstract void mouseDownAt(String paramString1, String paramString2);

    public abstract void mouseDownRightAt(String paramString1, String paramString2);

    public abstract void mouseUp(String paramString);

    public abstract void mouseUpRight(String paramString);

    public abstract void mouseUpAt(String paramString1, String paramString2);

    public abstract void mouseUpRightAt(String paramString1, String paramString2);

    public abstract void mouseMove(String paramString);

    public abstract void mouseMoveAt(String paramString1, String paramString2);

    public abstract void type(String paramString1, String paramString2);

    public abstract void typeKeys(String paramString1, String paramString2);

    public abstract void check(String paramString);

    public abstract void uncheck(String paramString);

    public abstract void select(String paramString1, String paramString2);

    public abstract void addSelection(String paramString1, String paramString2);

    public abstract void removeSelection(String paramString1, String paramString2);

    public abstract void removeAllSelection(String paramString);

    public abstract void submit(String paramString);

    public abstract void open(String paramString);

    public abstract void openWindow(String paramString1, String paramString2);

    public abstract void selectWindow(String paramString);

    public abstract void selectFrame(String paramString);

    public abstract void chooseCancelOnNextConfirmation();

    public abstract void chooseOkOnNextConfirmation();

    public abstract void answerOnNextPrompt(String paramString);

    public abstract void goBack();

    public abstract void refresh();

    public abstract void close();

    public abstract boolean isAlertPresent();

    public abstract boolean isPromptPresent();

    public abstract boolean isConfirmationPresent();

    public abstract String getAlert();

    public abstract String getConfirmation();

    public abstract String getPrompt();

    public abstract String getLocation();

    public abstract String getTitle();

    public abstract String getBodyText();

    public abstract String getValue(String paramString);

    public abstract String getText(String paramString);

    public abstract void highlight(String paramString);

    public abstract String getEval(String paramString);

    public abstract boolean isChecked(String paramString);

    public abstract String getTable(String paramString);

    public abstract String[] getSelectedLabels(String paramString);

    public abstract String getSelectedLabel(String paramString);

    public abstract String[] getSelectedValues(String paramString);

    public abstract String getSelectedValue(String paramString);

    public abstract String[] getSelectedIndexes(String paramString);

    public abstract String getSelectedIndex(String paramString);

    public abstract String[] getSelectedIds(String paramString);

    public abstract String getSelectedId(String paramString);

    public abstract boolean isSomethingSelected(String paramString);

    public abstract String[] getSelectOptions(String paramString);

    public abstract String getAttribute(String paramString);

    public abstract boolean isTextPresent(String paramString);

    public abstract boolean isElementPresent(String paramString);

    public abstract boolean isVisible(String paramString);

    public abstract boolean isEditable(String paramString);

    public abstract void windowFocus();

    public abstract void windowMaximize();

    public abstract String[] getAllWindowIds();

    public abstract String[] getAllWindowNames();

    public abstract String[] getAllWindowTitles();

    public abstract String getHtmlSource();

    public abstract Number getElementPositionLeft(String paramString);

    public abstract Number getElementPositionTop(String paramString);

    public abstract Number getElementWidth(String paramString);

    public abstract Number getElementHeight(String paramString);

    public abstract Number getXpathCount(String paramString);

    public abstract void setTimeout(String paramString);

    public abstract void waitForPageToLoad(String paramString);

    public abstract void waitForFrameToLoad(String paramString1, String paramString2);

    public abstract String getCookie();

    public abstract String getCookieByName(String paramString);

    public abstract boolean isCookiePresent(String paramString);

    public abstract void createCookie(String paramString1, String paramString2);

    public abstract void deleteCookie(String paramString1, String paramString2);

    public abstract void deleteAllVisibleCookies();

    public abstract void setBrowserLogLevel(String paramString);

    public abstract void runScript(String paramString);

    public abstract void useXpathLibrary(String paramString);

    public abstract void setContext(String paramString);

    public abstract void keyDownNative(String paramString);

    public abstract void keyUpNative(String paramString);

    public abstract void keyPressNative(String paramString);

    public abstract void defaultContent();

    public abstract void parentFrame();

    public abstract void clear(String paramString);

    public abstract Set<String> getWindowHandlers();

    public abstract void selectWinByHandler();

    public abstract String getWindowHandler();

    public abstract String getBrowserWinHandle();

    public abstract void downloadFile(String paramString1, String paramString2, String paramString3);

    public abstract void screenshot();
}
