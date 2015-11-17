import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by gjariwala on 11/17/2015.
 */
public class Tests {
    BaseClass bs = new BaseClass();;

    //Test to verify successful log in
    @Test
    public void loginverification () throws InterruptedException{

        bs.setup();
        bs.driver.get("http://www.llbean.com");
        bs.driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        bs.emailcatcherpopuphandling();
        bs.haveanllbeanacountpopuphandling();
        bs.login("gautamjariwala1@gmail.com", "ready2go");
        bs.driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        bs.welcomellbeanfreeshippingpopuphandling();
        bs.driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        if (bs.driver.findElement(By.xpath("//*[@id=\"emailUpdates\"]/a")).isDisplayed()){
            System.out.println("Log in Successful");
        }
        else{
            System.out.println("Log in unSuccessful");
        }
        bs.teardown();
    }
}