package cn.automation.MySelenium.AutomationTestCommon.test;

import cn.automation.MySelenium.AutomationTestCommon.util.Constants;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = Integer.parseInt(Constants.RETRY_TIMES);

    /**
     * 如果必须重试测试方法，则below方法返回“true”，否则返回“false”
     * 它将结果作为刚刚运行的测试方法的参数
     * @param result
     * @return
     */
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount){
            System.out.println("Retrying test" + result.getName() + "with status"
                    + getResultStatusName(result.getStatus()) + "for the" + (retryCount+1) + "time(s).");
        retryCount++;
        return true;
        }
        return false;
    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }
}
