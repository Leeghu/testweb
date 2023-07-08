package cn.automation.MySelenium.AutomationTestCommon.assertion;

public class InexactComparisonCriteria extends ComparisonCriteria{

    public Object fDelta;

    public InexactComparisonCriteria(double delta)
    {
        this.fDelta = Double.valueOf(delta);
    }

    protected void assertElementsEqual(Object expected, Object actual) {
        if ((expected instanceof Double)) {
            Assert.assertEquals(((Double)expected).doubleValue(), ((Double)actual).doubleValue(), ((Double)this.fDelta).doubleValue());
        }
        else
            Assert.assertEquals(((Float)expected).floatValue(), ((Float)actual).floatValue(), ((Float)this.fDelta).floatValue());
    }
}
