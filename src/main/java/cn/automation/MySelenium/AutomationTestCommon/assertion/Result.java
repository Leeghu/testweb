package cn.automation.MySelenium.AutomationTestCommon.assertion;

import java.io.Serializable;

public class Result implements Serializable {
    private static final long serialVersionUID = 892173572454763979L;
    private boolean flag;
    private String message;

    public Result(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public boolean isFlag() {
        return this.flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
