package advan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Utilities {


    public static void logChecker(String browserType, String propertyType) {

        WebDriver driver = Driver.get(browserType);

        driver.get(url());

        WebElement getOwnPropertyNames = driver.findElement(By.xpath("//div[@class='chromeLog']"));
        WebElement getGlobalObjects = driver.findElement(By.xpath("//div[@class='globalLog']"));

        String getOwnPropertyLogs = getOwnPropertyNames.getText();
        String getGlobalLogs = getGlobalObjects.getText();

        String logType = propertyType.equals("getOwnPropertyLogs") ? getOwnPropertyLogs : getGlobalLogs;

        writeToAFile(logType, browserType+"-"+propertyType);
        System.out.println("propertyType = " + propertyType);
        System.out.println("browserType = " + browserType);
        driver.quit();
        System.out.println("log checker creating the file: " + browserType);
    }


    public static void writeToAFile(String logs, String fileName) {
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName + ".txt"), "utf-8"));
            writer.write(logs);
        } catch (IOException ex) {
            // Report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/}
        }
    }

    public static String url() {
        Path sampleFile = Paths.get("src/test/java/advan/index.html");
        return sampleFile.toUri().toString();
    }
}
