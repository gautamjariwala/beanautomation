import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by gjariwala on 11/17/2015.
 */

public class BaseClass extends Utils{

    @FindBy(id="login-trigger")
        WebElement homePageLoginLinkId;

    @FindBy(id="loginEmail")
        WebElement homepageLoginFieldId;

    @FindBy(id="loginPassword")
        WebElement homepageLoginPasswordId;

    @FindBy(id="loginButton")
        WebElement homepageLoginButtonId;

    @FindBy(xpath="//*[@id=\"hp\"]/div[3]/div[1]/a/span")
        WebElement homepageEmailPopupCrossIconXpath;

    @FindBy(xpath = "//*[@id='llb-header-area']/div[4]/div/a")
        WebElement homepageHaveAnAccountPopupCrossIconXpath;

    @FindBy(css = "img[alt=\"Free Shipping. No minimum order. No end date. Plus 100% Satisfaction Guarantee\"]")
        WebElement homepageFreeShippingCenterPoppupCss;

   public void login (String username, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait( 10,TimeUnit.SECONDS );
        homePageLoginLinkId.click();
        //driver.findElement( By.id("login-trigger")).click();
        driver.manage().timeouts().implicitlyWait( 15, TimeUnit.SECONDS );
        driver.switchTo().frame("loginLayer");
        wait.until( ExpectedConditions.visibilityOf(driver.findElement(By.id("loginEmail"))));
        //driver.findElement(By.id("loginEmail")).sendKeys(username);
        homepageLoginFieldId.sendKeys(username);
        //driver.findElement(By.id("loginPassword")).sendKeys(password);
        homepageLoginPasswordId.sendKeys(password);
        //driver.findElement(By.id("loginButton")).click();
        homepageLoginButtonId.click();
        System.out.println("BaseClass completed");

       }

    //This to handle email catcher pop up, solution close it
    public void emailCatcherPopupHandling(){
        try {
            //driver.findElement(By.xpath("//*[@id=\"hp\"]/div[3]/div[1]/a/span")).click();
            homepageEmailPopupCrossIconXpath.click();
            System.out.println( "Email Catcher pop up present" );
        }
        catch (Exception e){
            System.out.println( "Email msg box not present" );
        }

    }

    //This to handle "Have an llbean.com account?" pop up, solution close it
    public void haveAnLlBeanAccountPopupHandling(){
        try {
            //driver.findElement(By.xpath("//*[@id=\"llb-header-area\"]/div[4]/div/a")).click();
            homepageHaveAnAccountPopupCrossIconXpath.click();
            System.out.println( "Have an LL Bean pop up present" );
        }
        catch (Exception e){
            System.out.println( "Have an LL Bean pop up NOT present" );
        }

    }
    //This to handle welcome  pop up which shows free shipping, solution close it
    public void welcomeLlBeanFreeShippingPopupHandling(){
        try {
            //driver.findElement(By.cssSelector("img[alt=\"Free Shipping. No minimum order. No end date. Plus 100% Satisfaction Guarantee\"]")).click();
            homepageFreeShippingCenterPoppupCss.click();
            System.out.println( "Welcome Pop up Present" );
        }
        catch (Exception e){
            System.out.println( "Welcome Pop up Not Present" );
        }

    }

    public void globalNav (String typeOfProduct) throws RuntimeException{

       if(typeOfProduct.equalsIgnoreCase( "men's")){
           WebElement we = driver.findElement(By.id("dp-26"));
           action.moveToElement(we).perform();
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Shirts")));
           action.moveToElement(driver.findElement(By.linkText("Shirts"))).click().perform();
        }
        else
        if(typeOfProduct.equalsIgnoreCase( "women's" )){
            WebElement we = driver.findElement(By.id("dp-27"));
            action.moveToElement(we).perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Shirts")));
            action.moveToElement(driver.findElement(By.linkText("Shirts"))).click().perform();
        }
        else
        if(typeOfProduct.equalsIgnoreCase( "kid's" )){
            WebElement we = driver.findElement(By.id("dp-28"));
            action.moveToElement(we).perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Activewear")));
            action.moveToElement(driver.findElement(By.linkText("Shirts"))).click().perform();
        }
        else
        if(typeOfProduct.equalsIgnoreCase( "footwear" )){
            WebElement we = driver.findElement(By.id("dp-474"));
            action.moveToElement(we).perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Men's Footwear")));
            action.moveToElement(driver.findElement(By.linkText("Shirts"))).click().perform();
        }



    }


}
