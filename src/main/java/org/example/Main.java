package org.example;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class Main {

    public WebDriver driver;

    @BeforeTest
    public void launchbrowser() {
        System.out.println("launching browser");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void registerwithvaliddata() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/p[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatem");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("mamdouh");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/input")).sendKeys("hatemmadouh22@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[4]/input")).sendKeys("01012914044");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[6]/button")).click();
        String expected ="You're almost there! We sent an email to hatemamdouh22@gmail.com with a link to activate your account. Please check your email and click the activation link.";
        String actual= driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/div/div[2]/p")).getText();
        Assert.assertEquals(expected,actual);
    }

 

    
    @Test
    public void setpassword(){
        driver.get("https://candymapper.com/m/create?e=hatemmadouh22%40gmail.com&id=01916bf6-2e42-79f4-99d7-098ff81bb67e&t=TixCSdrQjkK3FmWUt4Gmwk3vxnjNQJtJUw&x=1725821182");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("2278174Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("2278174Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        String expected="Hello hatem";
        String actual=driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/h2/span")).getText();
        Assert.assertEquals(expected,actual);
    }

    
    @Test
    public void setpasswordwithdifferntconfirm(){
        driver.get("https://candymapper.com/m/create?e=hatemmadouh22%40gmail.com&id=01916bf6-2e42-79f4-99d7-098ff81bb67e&t=TixCSdrQjkK3FmWUt4Gmwk3vxnjNQJtJUw&x=1725821182");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("2278174Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("24921220hf");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        String expected ="Passwords are not the same";
        String actual =driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/p")).getText();
        Assert.assertEquals(expected,actual);
    }

     

    @Test
    public void registerwithinvalidemail() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/p[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatem");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("mamdouh");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/input")).sendKeys("hatemmadouh22gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[4]/input")).sendKeys("01012914044");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[6]/button")).click();
        String expected ="Enter a valid email address.";
        String actual= driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/p")).getText();
        Assert.assertEquals(expected,actual);
    }

 
    
    @Test
      public void loginwithvalidemailandpassword(){
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatemmadouh22@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("2278174Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        String expected="Account Login";
        String actual=driver.findElement(By.xpath("//*[@id=\"82195fd0-49b8-4d90-832e-4f73457f5f71\"]/div/section/div/div/div[2]/div/div/div/h1")).getText();
        Assert.assertEquals(expected,actual);
    }

     

    @Test
    public void loginwithvalidemailandinvalidpassword() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatemmadouh22@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("2278174Hs");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        String expected = "The password/email address combo is incorrect.";
        String actual = driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/p")).getText();
        Assert.assertEquals(expected, actual);
    }

 
    
    @Test
    public void loginwithinvalidemailandvalidpassword() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatemmadouhgmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("2278174Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        String expected = "Enter a valid email address.";
        String actual = driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/p")).getText();
        Assert.assertEquals(expected, actual);
    }

  
    @Test
    public void loginwithinvalidemailandinvalidpassword() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatemmadouhgmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("2272sasd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        String expected = "Enter a valid email address.";
        String actual = driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/p")).getText();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void loginwithvalidemailandemptypassword() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatemmadouhgmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        String expected = "Passwords can’t be nothing.";
        String actual = driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/p")).getText();
        Assert.assertEquals(expected, actual);
    }

     
    @Test
    public void loginwithemptyemailandvalidpassword() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("2278174Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        String expected = "Enter a valid email address.";
        String actual = driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/p")).getText();
        Assert.assertEquals(expected, actual);
    }

     
    @Test
    public void resetpasswordwithvalidemail(){
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/div/form/div[1]/input")).sendKeys("hatemmadouh22@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/div/form/div[2]/button")).click();
        driver.get("https://candymapper.com/m/reset?e=hatemmadouh22%40gmail.com&id=01916bf6-2e42-79f4-99d7-098ff81bb67e&r=%2Fjoin-us&t=118882&x=1724100583");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("24921220Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("24921220Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        String expected="Account Login";
        String actual=driver.findElement(By.xpath("//*[@id=\"82195fd0-49b8-4d90-832e-4f73457f5f71\"]/div/section/div/div/div[2]/div/div/div/h1")).getText();
        Assert.assertEquals(expected,actual);
    }

     
    @Test
    public void resetpasswordwithinvalidemail(){
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/div/form/div[1]/input")).sendKeys("hatemmadouh22gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/div/form/div[2]/button")).click();
        String expected="Enter a valid email address.";
        String actual =driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/div/form/div[1]/p")).getText();
        Assert.assertEquals(expected,actual);
}

    
    @Test
    public void attendzombietionparty() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatemmadouh22@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("2278174Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        driver.get("https://candymapper.com/halloween-party");
        driver.findElement(By.xpath("//*[@id=\"5f23ce1d-14db-46b1-8658-fc035c3cf0f3\"]/div/section/div/div[2]/div/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"e6ae6e8e-7e3d-459d-8723-502922228897\"]/div/section/div/div[2]/div/div/a[1]")).click();
        WebElement Element = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/div/div/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.sendKeys("hatemmadouh22@gmail.com");
        WebElement elem = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).click().build().perform();
        driver.get("https://gem.godaddy.com/signups/activate/MS0td05zQjFFM1o5NTFjc3gvTldCSi9MVFNlNE9NWjd6SDg0MHFkTzFCT3Zkem1DNFdYaDAxY2h6TUdjaG1hL05kUEs1a3hBZXZsVTI1c0ErSHMtLWJPZkRWSFN1VEhUYlpMR0ktLVRnb2JOb0RGMTBwU3A1VnJJNXFHYWc9PQ==?signup=1005951");
        String expected ="Thank you for confirming!";
        String actual=driver.findElement(By.xpath("/html/body/div/div/div[1]/form/fieldset/div/p")).getText();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void attendghostvileparty() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatemmadouh22@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("2278174Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        driver.get("https://candymapper.com/halloween-party");
        driver.findElement(By.xpath("//*[@id=\"5f23ce1d-14db-46b1-8658-fc035c3cf0f3\"]/div/section/div/div[2]/div/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"e6ae6e8e-7e3d-459d-8723-502922228897\"]/div/section/div/div[2]/div/div/a[2]")).click();
        WebElement Element = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/div/div/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.sendKeys("hatemmadouh22@gmail.com");
        WebElement elem = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).click().build().perform();
        driver.get("https://gem.godaddy.com/signups/activate/MS0td05zQjFFM1o5NTFjc3gvTldCSi9MVFNlNE9NWjd6SDg0MHFkTzFCT3Zkem1DNFdYaDAxY2h6TUdjaG1hL05kUEs1a3hBZXZsVTI1c0ErSHMtLWJPZkRWSFN1VEhUYlpMR0ktLVRnb2JOb0RGMTBwU3A1VnJJNXFHYWc9PQ==?signup=1005951");
        String expected ="Thank you for confirming!";
        String actual=driver.findElement(By.xpath("/html/body/div/div/div[1]/form/fieldset/div/p")).getText();
        Assert.assertEquals(expected,actual);
    }

     
    @Test
    public void attendzombitionpartywithinvalidemail() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatemmadouh22@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("2278174Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        driver.get("https://candymapper.com/halloween-party");
        driver.findElement(By.xpath("//*[@id=\"5f23ce1d-14db-46b1-8658-fc035c3cf0f3\"]/div/section/div/div[2]/div/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"e6ae6e8e-7e3d-459d-8723-502922228897\"]/div/section/div/div[2]/div/div/a[1]")).click();
        WebElement Element = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/div/div/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.sendKeys("hatemmadouh22gmail.com");
        WebElement elem = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).click().build().perform();
        String expected = "Please enter a valid email address.";
        String actual = driver.findElement(By.xpath("//*[@id=\"bs-7\"]/span/span/div/div/form/div[2]/p")).getText();
        Assert.assertEquals(expected, actual);
    }

  
    @Test
    public void hostzombitionparty() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatemmadouh22@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("2278174Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        driver.get("https://candymapper.com/halloween-party");
        driver.findElement(By.xpath("//*[@id=\"5f23ce1d-14db-46b1-8658-fc035c3cf0f3\"]/div/section/div/div[2]/div/div/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"43df0051-7d8b-4811-a847-a508eecbf5d4\"]/div/section/div/div[2]/div/div/a[1]")).click();
        WebElement Element = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/div/div/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.sendKeys("hatemmadouh22@gmail.com");
        WebElement elem = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).click().build().perform();
        driver.get("https://gem.godaddy.com/signups/activate/MS0td05zQjFFM1o5NTFjc3gvTldCSi9MVFNlNE9NWjd6SDg0MHFkTzFCT3Zkem1DNFdYaDAxY2h6TUdjaG1hL05kUEs1a3hBZXZsVTI1c0ErSHMtLWJPZkRWSFN1VEhUYlpMR0ktLVRnb2JOb0RGMTBwU3A1VnJJNXFHYWc9PQ==?signup=1005951");
        String expected ="Thank you for confirming!";
        String actual=driver.findElement(By.xpath("/html/body/div/div/div[1]/form/fieldset/div/p")).getText();
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void hostghostparty() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatemmadouh22@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("2278174Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        driver.get("https://candymapper.com/halloween-party");
        driver.findElement(By.xpath("//*[@id=\"5f23ce1d-14db-46b1-8658-fc035c3cf0f3\"]/div/section/div/div[2]/div/div/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"43df0051-7d8b-4811-a847-a508eecbf5d4\"]/div/section/div/div[2]/div/div/a[2]")).click();
        WebElement Element = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/div/div/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.sendKeys("hatemmadouh22@gmail.com");
        WebElement elem = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).click().build().perform();
        driver.get("https://gem.godaddy.com/signups/activate/MS0td05zQjFFM1o5NTFjc3gvTldCSi9MVFNlNE9NWjd6SDg0MHFkTzFCT3Zkem1DNFdYaDAxY2h6TUdjaG1hL05kUEs1a3hBZXZsVTI1c0ErSHMtLWJPZkRWSFN1VEhUYlpMR0ktLVRnb2JOb0RGMTBwU3A1VnJJNXFHYWc9PQ==?signup=1005951");
        String expected ="Thank you for confirming!";
        String actual=driver.findElement(By.xpath("/html/body/div/div/div[1]/form/fieldset/div/p")).getText();
        Assert.assertEquals(expected,actual);
    }

     
    @Test
    public void hostzombitionpartywithinvalidemail() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatemmadouh22@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("2278174Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        driver.get("https://candymapper.com/halloween-party");
        driver.findElement(By.xpath("//*[@id=\"5f23ce1d-14db-46b1-8658-fc035c3cf0f3\"]/div/section/div/div[2]/div/div/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"43df0051-7d8b-4811-a847-a508eecbf5d4\"]/div/section/div/div[2]/div/div/a[1]")).click();
        WebElement Element = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/div/div/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.sendKeys("hatemmadouh2gmail.com");
        WebElement elem = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).click().build().perform();
        driver.get("https://gem.godaddy.com/signups/activate/MS0td05zQjFFM1o5NTFjc3gvTldCSi9MVFNlNE9NWjd6SDg0MHFkTzFCT3Zkem1DNFdYaDAxY2h6TUdjaG1hL05kUEs1a3hBZXZsVTI1c0ErSHMtLWJPZkRWSFN1VEhUYlpMR0ktLVRnb2JOb0RGMTBwU3A1VnJJNXFHYWc9PQ==?signup=1005951");
        String expected = "Please enter a valid email address.";
        String actual = driver.findElement(By.xpath("//*[@id=\"bs-7\"]/span/span/div/div/form/div[2]/p")).getText();
        Assert.assertEquals(expected, actual);
    }

     
    @Test
    public void hostghostpartywithinvalidemail() {
        driver.get("https://candymapper.com/m/login?r=%2Fjoin-us");
        driver.findElement(By.xpath("//*[@id=\"popup-widget237746-close-icon\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[1]/input")).sendKeys("hatemmadouh22@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[2]/input")).sendKeys("2278174Hd");
        driver.findElement(By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button")).click();
        driver.get("https://candymapper.com/halloween-party");
        driver.findElement(By.xpath("//*[@id=\"5f23ce1d-14db-46b1-8658-fc035c3cf0f3\"]/div/section/div/div[2]/div/div/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"43df0051-7d8b-4811-a847-a508eecbf5d4\"]/div/section/div/div[2]/div/div/a[2]")).click();
        WebElement Element = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/div/div/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.sendKeys("hatemmadouh2gmail.com");
        WebElement elem = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/section/div/div/span/span/div/div/form/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).click().build().perform();
        driver.get("https://gem.godaddy.com/signups/activate/MS0td05zQjFFM1o5NTFjc3gvTldCSi9MVFNlNE9NWjd6SDg0MHFkTzFCT3Zkem1DNFdYaDAxY2h6TUdjaG1hL05kUEs1a3hBZXZsVTI1c0ErSHMtLWJPZkRWSFN1VEhUYlpMR0ktLVRnb2JOb0RGMTBwU3A1VnJJNXFHYWc9PQ==?signup=1005951");
        String expected = "Please enter a valid email address.";
        String actual = driver.findElement(By.xpath("//*[@id=\"bs-7\"]/span/span/div/div/form/div[2]/p")).getText();
        Assert.assertEquals(expected, actual);
    }

     
@Test
    public void verifylaunchCandyMapperbutton(){
    driver.get("https://candymapper.com/");
    driver.findElement(By.xpath("//*[@id=\"nav-238381\"]/li[4]/a")).click();
    String expectedurl="https://candymapper.com/launch-candymapper";
    String actualurl=driver.getCurrentUrl();
    Assert.assertEquals(expectedurl,actualurl);
}


@Test
    public void verifyjoinusbutton(){
    driver.get("https://candymapper.com/");
    driver.findElement(By.xpath("//*[@id=\"bs-2\"]/span/a")).click();
    String expectedurl="https://candymapper.com/m/login?r=%2Fjoin-us";
    String actualurl= driver.getCurrentUrl();
    Assert.assertEquals(expectedurl,actualurl);
}

    
    @Test
    public void verifyHalloweenPartybutton(){
        driver.get("https://candymapper.com/");
        driver.findElement(By.xpath("//*[@id=\"nav-238381\"]/li[3]/a")).click();
        String expectedurl="https://candymapper.com/halloween-party";
        String actualurl= driver.getCurrentUrl();
        Assert.assertEquals(expectedurl,actualurl);
    }

     
}

