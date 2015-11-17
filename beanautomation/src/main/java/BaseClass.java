import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by gjariwala on 11/17/2015.
 */

public class BaseClass extends Utils{


    public void login (String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait( 10,TimeUnit.SECONDS );
        driver.findElement( By.id("login-trigger")).click();
        driver.manage().timeouts().implicitlyWait( 15, TimeUnit.SECONDS );
        driver.switchTo().frame("loginLayer");
        wait.until( ExpectedConditions.visibilityOf(driver.findElement(By.id("loginEmail"))));
        driver.findElement(By.id("loginEmail")).sendKeys(username);
        driver.findElement(By.id("loginPassword")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        System.out.println("BaseClass completed");
        return;
    }

    //This to handle email catcher pop up, solution close it
    public void emailcatcherpopuphandling(){
        try {
            driver.findElement(By.xpath("//*[@id=\"hp\"]/div[3]/div[1]/a/span")).click();
            System.out.println( "Email Catcher pop up present" );
        }
        catch (Exception e){
            System.out.println( "Email msg box not present" );
        }
        return;
    }

    //This to handle "Have an llbean.com account?" pop up, solution close it
    public void haveanllbeanacountpopuphandling(){
        try {
            driver.findElement(By.xpath("//*[@id=\"llb-header-area\"]/div[4]/div/a")).click();
            System.out.println( "Have an LL Bean pop up present" );
        }
        catch (Exception e){
            System.out.println( "Have an LL Bean pop up NOT present" );
        }
        return;
    }
    //This to handle welcome  pop up which shows free shipping, solution close it
    public void welcomellbeanfreeshippingpopuphandling(){
        try {
            driver.findElement(By.cssSelector("img[alt=\"Free Shipping. No minimum order. No end date. Plus 100% Satisfaction Guarantee\"]")).click();
            System.out.println( "Welcome Pop up Present" );
        }
        catch (Exception e){
            System.out.println( "Welcome Pop up Not Present" );
        }
        return;
    }


}
