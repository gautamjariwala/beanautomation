import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.swing.FilePane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by gjariwala on 11/17/2015.
 */
public class Utils {

        public static WebDriver driver;
        WebDriverWait wait;
        Properties prop;
        Actions action;

        public void setup(){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\gjariwala\\JARS\\chromedriver.exe");
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);
            PageFactory.initElements(driver, this);
            action = new Actions( driver );

        }

        public void comparetextbyid (String locatorid, String expectedtext, String pass_message, String fail_message ) {
            if (driver.findElement( By.id( locatorid ) ).getText().equals( expectedtext )) {
                System.out.println( pass_message );
            } else {
                System.out.println( fail_message );
            }
        }

        public void comparetextbyxpath (String locatorid, String expectedtext, String pass_message, String fail_message ) {
            if (driver.findElement( By.xpath( locatorid ) ).getText().equals( expectedtext )) {
                System.out.println( pass_message );
            } else {
                System.out.println( fail_message );
            }
        }

        public void comparetextbycss (String locatorid, String expectedtext, String pass_message, String fail_message ) {
            if (driver.findElement( By.cssSelector( locatorid ) ).getText().equals( expectedtext )) {
                System.out.println( pass_message );
            } else {
                System.out.println( fail_message );
            }
        }

        public void teardown()
        {
        driver.quit();
        }
}

