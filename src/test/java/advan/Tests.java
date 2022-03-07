package advan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static advan.Utilities.logChecker;

public class Tests {

    public static void main(String[] args) {

        logChecker("chrome", "getOwnPropertyLogs");
        logChecker("chrome-headless", "getOwnPropertyLogs");

        /*
        Browser type:
                        chrome
                        chrome-headless
        Property Type:
                        getOwnPropertyLogs
                        getGlobalLogs
         */

        logChecker("chrome-headless", "getGlobalLogs");
        logChecker("chrome", "getGlobalLogs");




//        WebDriver driver = Driver.get("chrome-headless");
//        driver.get("https://huge-dom.vanilla-cms.org/en/browser");
//        List<WebElement> element = driver.findElements(By.xpath("//table[@class=\"hugeDom hugeDom_table\"]/tbody/tr/th/a"));
//        System.out.println("element.size() = " + element.size()); //element.size() = 1617
    }

}