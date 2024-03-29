package cn.automation.MySelenium.AutomationTestCommon.test;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor Constructor, Method testMethod) {

        IRetryAnalyzer retry = annotation.getRetryAnalyzer();

        if (retry == null) {
            annotation.setRetryAnalyzer(Retry.class);
        }
    }
}
