package Testing_Pack;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




/**
* Created by san on 4/18/17.
*/
public class LoginCredintials {

    static WebDriver driver = null;

    @Test
    public void GoogleSignup(){

    System.setProperty("webdriver.gecko.driver","C:\\Users\\USer\\eclipse-workspace\\tp1\\src\\geckodriver.exe");

   driver = new FirefoxDriver();
    String baseUrl = "https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default";
    driver.get(baseUrl);

    //By ID Text area1
    WebElement text1 = driver.findElement(By.id("FirstName"));
    text1.clear();
    text1.sendKeys("San ");

    WebElement text2 = driver.findElement(By.id("LastName"));
    text2.clear();
    text2.sendKeys("P");

    WebElement text3 = driver.findElement(By.xpath(".//*[@id='GmailAddress']"));
    text3.clear();
    text3.sendKeys("s20077444");

    WebElement text4 = driver.findElement(By.xpath(".//*[@id='Passwd']"));
    text4.clear();
    text4.sendKeys("123abcdxy");

    WebElement text5 = driver.findElement(By.xpath(".//*[@id='PasswdAgain']"));
    text5.clear();
    text5.sendKeys("123abcdxy");

    WebElement text6 = driver.findElement(By.id("BirthDay"));
    text6.clear();
    text6.sendKeys("1");

    WebElement text7 = driver.findElement(By.id("BirthYear"));
    text7.clear();
    text7.sendKeys("2000");

    WebElement text8 = driver.findElement(By.id("RecoveryPhoneNumber"));
    text8.clear();
    text8.sendKeys("9222103436");

    WebElement text9 =  driver.findElement(By.id("RecoveryEmailAddress"));
    text9.clear();
    text9.sendKeys("abc_gh@yahoo.com");


    googleSelect(By.id("Gender"), "Male");

    googleSelect(By.id("BirthMonth"), "March");

    googleSelect(By.xpath(".//*[@id='CountryCode']/div"), "United States");

    WebElement text10 = driver.findElement(By.id("submitbutton"));
    text10.click();

    driver.quit();

 }


 private static void googleSelect(By by, String text) {
    driver.findElement(by).click();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOf(
            driver.findElement(By.xpath("//div[@class='goog-menu goog-menu-vertical']//div[text()='" + text + "']"))));
    driver.findElement(By.xpath("//div[@class='goog-menu goog-menu-vertical']//div[text()='" + text + "']")).click();

  }
}

