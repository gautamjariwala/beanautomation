import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.swing.FilePane;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by gjariwala on 11/17/2015.
 */
public class Utils {

        public static WebDriver driver;
    WebDriverWait wait;
        public void setup(){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\gjariwala\\JARS\\chromedriver.exe");
            driver = new ChromeDriver();
             wait = new WebDriverWait(driver, 10);

        }

        public void teardown(){
        driver.quit();
        }



}

