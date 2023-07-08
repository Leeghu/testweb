package cn.automation.MySelenium.AutomationTestCommon.assertion;

import java.util.LinkedList;
import java.util.List;

public class ResultAccumulator {
    public static ResultAccumulator INSTANCE = new ResultAccumulator();
    private List<Result> results = new LinkedList<>();

    public void add(boolean flag, String message) {
        Result result = new Result(flag, message);
        this.results.add(result);
    }

    public void clear() {
        this.results.clear();
    }
    public List<Result> getResults() {
        return this.results;
    }
}
