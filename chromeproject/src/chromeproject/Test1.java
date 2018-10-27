package chromeproject;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test1() throws Exception {
    driver.get("http://localhost:8095/tp1/login");
    driver.findElement(By.name("nom")).clear();
    driver.findElement(By.name("nom")).sendKeys("marthe");
    driver.findElement(By.name("passwd")).clear();
    driver.findElement(By.name("passwd")).sendKeys("12345678");
    driver.findElement(By.name("nom")).click();
    driver.findElement(By.name("nom")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=nom | ]]
    driver.findElement(By.name("nom")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=nom | ]]
    driver.findElement(By.name("passwd")).click();
    driver.findElement(By.name("passwd")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=passwd | ]]
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("HISTORIQUE")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
