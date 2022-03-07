package advan;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static advan.Utilities.url;
import static advan.Utilities.writeToAFile;


public class LogForTwo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = Driver.get("chrome-headless");
        driver.get(url());

        WebElement getOwnPropertyNames = driver.findElement(By.xpath("//div[@class='chromeLog']"));

        String headlessLogs = getOwnPropertyNames.getText();

        writeToAFile(headlessLogs, "HeadlessChromeLogs");


//        Driver.closeDriver();
        System.out.println("completed");

        driver = Driver.get("chrome-headless");
        driver.get(url());

        getOwnPropertyNames = driver.findElement(By.xpath("//div[@class='chromeLog']"));

        String chromeLogs = getOwnPropertyNames.getText();

        writeToAFile(chromeLogs, "ChromeLogs");
        Driver.closeDriver();
        System.out.println("closed");



    }
}
