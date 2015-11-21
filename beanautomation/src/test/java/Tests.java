import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by gjariwala on 11/17/2015.
 */
public class Tests {
    private BaseClass bs = new BaseClass();

    @BeforeClass
    public void tearup(){
        bs.setup();
        bs.driver.get("http://www.llbean.com");

    }

    //Test to verify successful log in
    //HappyPath Test 1 Verification 1
   @Test
   @Parameters ({"username","password"})
    public void loginverification (String username, String password ) throws InterruptedException{



        bs.driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        bs.emailCatcherPopupHandling();
        bs.haveAnLlBeanAccountPopupHandling();
        //bs.login("gautamjariwala1@gmail.com", "ready2go");
        bs.login(username, password);
        bs.driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        bs.welcomeLlBeanFreeShippingPopupHandling();
        bs.driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        if (bs.driver.findElement(By.xpath("//*[@id=\"emailUpdates\"]/a")).isDisplayed()){
            System.out.println("Log in Successful");
        }
        else{
            System.out.println("Log in unSuccessful");
        }

    }

    //HappyPath Test 1 Verification 2
   @Test
   @Parameters({"category"})
    public void testatbVerification(String category){
       //bs.driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
       bs.driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
       //bs.globalNav( "Men's" );
       bs.globalNav( category );
       bs.comparetextbyxpath( "//*[@id=\\\"mainbody\\\"]/div[8]/div[1]/h1","Men's Shirts", "We are on right Men's category grid page", "Nope it's not the Men's grid page, check your code" );
      /*

       if (bs.driver.findElement( By.xpath( "*//*//**//*[@id=\"mainbody\"]/div[8]/div[1]/h1" ) ).getText().equals( "Men's Shirts" )){
           System.out.println("We are on right Men's category grid page");
       }
       else{
           System.out.println("Nope it's not the Men's grid page, check your code");
   }*/
       /*if (bs.driver.findElement(By.xpath("/*//*[@id=\"emailUpdates\"]/a")).isDispla
       bs.driver.gettxt1("dasdasdada", "mens shirt", "success", "fail");
       yed()){
           System.out.println("Log in Successful");
       }
       else{
           System.out.println("Log in unSuccessful");
       }*/
    }

    //HappyPath Test 1 Verification 3



    @AfterClass
    public void teardown(){
        bs.driver.quit();

    }
}