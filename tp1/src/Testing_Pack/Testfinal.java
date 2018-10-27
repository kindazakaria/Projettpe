package Testing_Pack;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Testfinal {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\USer\\eclipse-workspace\\tp1\\src\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFinal() throws Exception {
    driver.get("http://localhost:8095/tp1/login");
    driver.findElement(By.name("nom")).click();
    driver.findElement(By.name("nom")).clear();
    driver.findElement(By.name("nom")).sendKeys("marthe");
    driver.findElement(By.name("passwd")).click();
    driver.findElement(By.name("passwd")).clear();
    driver.findElement(By.name("passwd")).sendKeys("12345678");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("DEMANDE EMP.")).click();
    driver.findElement(By.linkText("HISTORIQUE")).click();
    driver.findElement(By.linkText("CATALOGUE")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Support:'])[1]/following::span[4]")).click();
    driver.findElement(By.linkText("Se deconnecter")).click();
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
