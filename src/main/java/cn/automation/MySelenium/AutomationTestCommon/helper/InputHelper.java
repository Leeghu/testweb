package cn.automation.MySelenium.AutomationTestCommon.helper;

import cn.automation.MySelenium.AutomationTestCommon.WebDriverFactory;
import cn.automation.MySelenium.AutomationTestCommon.util.Constants;

/**
 * @ClassName: InputHelper
 * @Description: Input的类型的操作公共类
 * @author
 * @Date
 */
public class InputHelper {
    /**
     * 在指定的对象里输入内容，该操作会清空之前的内容
     * @param locator
     * @param text
     */
    public static void type(String locator, String text) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().clear(locator);
                WebDriverFactory.getMyDriverInst().type(locator, text);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().clear(locator);
                    WebDriverFactory.getMyDriverInst().type(locator, text);
                }
            }
    }

    /**
     * 在指定对象结尾追加内容，该操作不会清空之前的操作
     * @param locator
     * @param text
     */
    public static void append(String locator, String text) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().type(locator, text);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().type(locator, text);
                }
            }
    }

    /**
     * 单击指定对象
     * @param locator
     */
    public static void click(String locator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().click(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().click(locator);
                }
            }
    }

    /**
     * scroll
     * @param scrollLocator
     * @param targetLocator
     */
    public static void scroll(String scrollLocator, String targetLocator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().doScroll(scrollLocator, targetLocator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().doScroll(scrollLocator, targetLocator);
                }
            }
    }

    /**
     * jsClick
     * @param locator
     */
    public static void jsClick(String locator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().jsClick(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().jsClick(locator);
                }
            }
    }

    /**
     * 获取指定对象的Text内容
     * @param locator
     * @return
     */
    public static String getText(String locator) {
        String tip = "";
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                tip = WebDriverFactory.getMyDriverInst().getText(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    tip = WebDriverFactory.getMyDriverInst().getText(locator);
                }
            }
        }
        return tip;
    }

    /**
     * 获取指定对象的某个属性值
     * @param attributeLocator
     * @return
     */
    public static String getAttribute(String attributeLocator) {
        String value = "";
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                value = WebDriverFactory.getMyDriverInst().getAttribute(attributeLocator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    value = WebDriverFactory.getMyDriverInst().getAttribute(attributeLocator);
                }
            }
        }
        return value;
    }

    /**
     * 获取指定对象的Value值
     * @param locator
     * @return
     */
    public static String getValue(String locator) {
        String value = "";
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                value = WebDriverFactory.getMyDriverInst().getValue(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    value = WebDriverFactory.getMyDriverInst().getValue(locator);
                }
            }
        }
        return value;
    }

    /**
     * 双击指定对象
     * @param locator
     */
    public static void doubleClick(String locator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().doubleClick(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().doubleClick(locator);
                }
            }
    }

    /**
     * 显示指定对象的右键菜单
     * @param locator
     */
    public static void contextMenu(String locator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().contextMenu(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().contextMenu(locator);
                }
            }
    }

    /**
     * 清空指定对象的内容
     * @param locator
     */
    public static void clear(String locator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().clear(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().clear(locator);
                }
            }
    }

    /**
     * 选中指定的(Checkbox/Rediobox)对象
     * @param locator
     */
    public static void check(String locator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().check(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().check(locator);
                }
            }
    }

    /**
     * 取消选中指定的(Checkbox/Rediobox)对象
     * @param locator
     */
    public static void uncheck(String locator) {
        int count = Constants.COUNT;
        while (count > 0)
            try {
                WebDriverFactory.getMyDriverInst().uncheck(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    WebDriverFactory.getMyDriverInst().uncheck(locator);
                }
            }
    }

    /**
     * 判断指定的(Checkbox/Rediobox)对象是否被选中
     * @param locator
     * @return
     */
    public static boolean isChecked(String locator) {
        boolean isCheck = false;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                isCheck = WebDriverFactory.getMyDriverInst().isChecked(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    isCheck = WebDriverFactory.getMyDriverInst().isChecked(locator);
                }
            }
        }
        return isCheck;
    }

    /**
     * 判断是否存在指定的text内容，范围为当前页面可访问的Frame
     * @param text
     * @return
     */
    public static boolean isTextPresent(String text) {
        boolean isPresent = false;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                isPresent = WebDriverFactory.getMyDriverInst().isTextPresent(text);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    isPresent = WebDriverFactory.getMyDriverInst().isTextPresent(text);
                }
            }
        }
        return isPresent;
    }

    /**
     * 判断指定对象是否存在
     * @param locator
     * @return
     */
    public static boolean isElementPresent(String locator) {
        boolean isPresent = false;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                isPresent = WebDriverFactory.getMyDriverInst().isElementPresent(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    isPresent = WebDriverFactory.getMyDriverInst().isElementPresent(locator);
                }
            }
        }
        return isPresent;
    }

    /**
     * 判断指定的对象是否可见
     * @param locator
     * @return
     */
    public static boolean isVisible(String locator) {
        boolean isVisible = false;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                isVisible = WebDriverFactory.getMyDriverInst().isVisible(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    isVisible = WebDriverFactory.getMyDriverInst().isVisible(locator);
                }
            }
        }
        return isVisible;
    }

    /**
     * 判断指定的对象是否可编辑
     * @param locator
     * @return
     */
    public static boolean isEditable(String locator) {
        boolean isEditable = false;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                isEditable = WebDriverFactory.getMyDriverInst().isEditable(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    isEditable = WebDriverFactory.getMyDriverInst().isEditable(locator);
                }
            }
        }
        return isEditable;
    }

    /**
     * 获取指定对象的位置X
     * @param locator
     * @return
     */
    public static Number getElementPositionLeft(String locator) {
        Number left = null;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                left = WebDriverFactory.getMyDriverInst().getElementPositionLeft(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    left = WebDriverFactory.getMyDriverInst().getElementPositionLeft(locator);
                }
            }
        }
        return left;
    }

    /**
     * 获取指定对象的位置Y
     * @param locator
     * @return
     */
    public static Number getElementPositionTop(String locator) {
        Number top = null;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                top = WebDriverFactory.getMyDriverInst().getElementPositionTop(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    top = WebDriverFactory.getMyDriverInst().getElementPositionTop(locator);
                }
            }
        }
        return top;
    }

    /**
     * 获取指定对象的宽度
     * @param locator
     * @return
     */
    public static Number getElementWidth(String locator) {
        Number width = null;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                width = WebDriverFactory.getMyDriverInst().getElementWidth(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    width = WebDriverFactory.getMyDriverInst().getElementWidth(locator);
                }
            }
        }
        return width;
    }

    /**
     * 获取指定对象的高度
     * @param locator
     * @return
     */
    public static Number getElementHeight(String locator) {
        Number height = null;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                height = WebDriverFactory.getMyDriverInst().getElementHeight(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    height = WebDriverFactory.getMyDriverInst().getElementHeight(locator);
                }
            }
        }
        return height;
    }

    /**
     * 获取满足指定Xpath的条件的对象的个数
     * @param locator
     * @return
     */
    public static Number getXpathCount(String locator) {
        Number xpathCount = null;
        int count = Constants.COUNT;
        while (count > 0) {
            try {
                xpathCount = WebDriverFactory.getMyDriverInst().getXpathCount(locator);
                count = 0;
            } catch (Exception e) {
                --count;
                SleepHelper.sleep(Constants.INTERVAL);
                if (count == 0) {
                    xpathCount = WebDriverFactory.getMyDriverInst().getXpathCount(locator);
                }
            }
        }
        return xpathCount;
    }
}
