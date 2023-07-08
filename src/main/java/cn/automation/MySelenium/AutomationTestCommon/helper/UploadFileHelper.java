package cn.automation.MySelenium.AutomationTestCommon.helper;

import cn.automation.MySelenium.AutomationTestCommon.WebDriverFactory;

public class UploadFileHelper {
    /**
     * 在指定上传对象上上传指定文件，文件路径为绝对路径
     * @param locator
     * @param path
     */
    public static void uploadFile(String locator, String path) {
        WebDriverFactory.getMyDriverInst().type(locator, path);
    }

    /**
     * 在指定上传对象上上传指定文件，文件路径为classloader的相对路径
     * @param element
     * @param packagePath
     */
    public static void uploadFileByPackagePath(String element, String packagePath) {
        if (packagePath.startsWith("\\")) {
            uploadFile(element, getProjectPath(packagePath));
            return;
        }
        uploadFile(element, getProjectPath(packagePath));
    }

    /**
     * 获得当前jvm的classloader的路径
     * @param packagePath
     * @return
     */
    public static String getPath(String packagePath) {
        String fullPath = "";
        try {
            fullPath = UploadFileHelper.class.getProtectionDomain().getClassLoader()
                    .getResource(packagePath.replace("\\", "/")).getFile();
            return fullPath.substring(1);
        } catch (NullPointerException jarPath) {
            String jarPath1 = WebDriverFactory.class.getProtectionDomain().getCodeSource().getLocation().getPath();

            if (jarPath1.endsWith("jar")) {
                int index = jarPath1.lastIndexOf("/");
                fullPath = jarPath1.substring(0, index + 1) + packagePath.replace("\\", "/");
                return fullPath.substring(1);
            }
            fullPath = jarPath1;
        }
        return fullPath.substring(1);
    }

    /**
     * 获取当前项目的路径
     * @param packagePath
     * @return
     */
    public static String getProjectPath(String packagePath) {
        String fullPath = "";
        try {
            fullPath = System.getProperty("user.dir") + packagePath;
            return fullPath;
        } catch (NullPointerException jarPath) {
            fullPath = System.getProperty("user.dir") + packagePath;
        }
        return fullPath;
    }
}
