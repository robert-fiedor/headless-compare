package advan;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeLogCheck {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup(); //runs the latest
        WebDriver driver = new ChromeDriver();

        Path sampleFile = Paths.get("/Users/agulgonul/Documents/GitHub/test2/src/test/java/advan/index.html");
        driver.get(sampleFile.toUri().toString());

        boolean displayed = driver.findElement(By.xpath("//div[@class='chromeLog']")).isDisplayed();

        boolean enabled = driver.findElement(By.xpath("//div[@class='chromeLog']")).isEnabled();

        if(!displayed || !enabled) throw new java.lang.Error("Error");

        WebElement getOwnPropertyNames = driver.findElement(By.xpath("//div[@class='chromeLog']"));

        String JSLogs = getOwnPropertyNames.getText();
        System.out.println("Full JSLogs = " + JSLogs);
        String[] logsArray = JSLogs.split(",");
        System.out.println("Arrayed List: " + logsArray.length);
        for (String each: logsArray) {
//            System.out.println("each = " + each);
        }

        writeToAFile(JSLogs);

        Thread.sleep(2000);

        driver.quit();
        System.out.println("closed");
    }





    public static void writeToAFile(String logs){
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("ChromeLogs.txt"), "utf-8"));
            writer.write(logs);
        } catch (IOException ex) {
            // Report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }
}


//        from selenium import webdriver.
//                from selenium.webdriver.common.desired_capabilities import DesiredCapabilities.
//# enable browser logging.
//                d = DesiredCapabilities.CHROME.
//                d[‘loggingPrefs’] = { ‘browser’:‘ALL’ }
//        driver = webdriver.Chrome(desired_capabilities=d)
//# load the desired webpage.
//        driver.get(‘http://foo.com’)

