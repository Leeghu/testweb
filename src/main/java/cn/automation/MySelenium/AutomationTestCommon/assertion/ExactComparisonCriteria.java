package cn.automation.MySelenium.AutomationTestCommon.assertion;

public class ExactComparisonCriteria extends ComparisonCriteria {
    protected void assertElementsEqual(Object expected, Object actual) {
        Assert.assertEquals(expected, actual);
    }
}
