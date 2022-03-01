package advan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HeadlessLogCheck {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup(); //runs the latest
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        Path sampleFile = Paths.get("/Users/agulgonul/Documents/GitHub/test2/src/test/java/advan/index.html");
        driver.get(sampleFile.toUri().toString());
        boolean displayed = driver.findElement(By.xpath("//div[@class='chromeLog']")).isDisplayed();

        boolean enabled = driver.findElement(By.xpath("//div[@class='chromeLog']")).isEnabled();

        if (!displayed || !enabled) throw new java.lang.Error("Error");


        WebElement element = driver.findElement(By.xpath("//div[@class='chromeLog']"));

        String JSLogs = element.getText();
        System.out.println("Full JSLogs = " + JSLogs);
        String[] logsArray = JSLogs.split(",");
        System.out.println("Arrayed List: " + logsArray.length);
        for (String each : logsArray) {
//            System.out.println("each = " + each);
        }


        writeToAFile(JSLogs);

        Thread.sleep(2000);

        driver.quit();
        System.out.println("closed");
    }





    public static void writeToAFile(String logs) {
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("HeadlessChromeLogs.txt"), "utf-8"));
            writer.write(logs);
        } catch (IOException ex) {
            // Report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/}
        }
    }
}
