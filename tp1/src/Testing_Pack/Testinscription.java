package Testing_Pack;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Testinscription {
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
  public void testInscription() throws Exception {
    driver.get("http://localhost:8095/tp1/login");
    driver.findElement(By.linkText("s'inscrire?")).click();
    driver.findElement(By.id("Nom")).click();
    driver.findElement(By.id("Nom")).clear();
    driver.findElement(By.id("Nom")).sendKeys("oubda");
    driver.findElement(By.id("prenom")).click();
    driver.findElement(By.id("prenom")).clear();
    driver.findElement(By.id("prenom")).sendKeys("nico");
    driver.findElement(By.name("lieun")).click();
    new Select(driver.findElement(By.name("lieun"))).selectByVisibleText("Bien-Hoa");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='lieu de Naissance'])[1]/following::option[4]")).click();
    driver.findElement(By.name("stat")).click();
    new Select(driver.findElement(By.name("stat"))).selectByVisibleText("Adherent");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='status'])[1]/following::option[2]")).click();
    driver.findElement(By.id("motpass")).click();
    driver.findElement(By.id("motpass")).clear();
    driver.findElement(By.id("motpass")).sendKeys("oubdanico");
    driver.findElement(By.id("datenaissnce")).click();
    driver.findElement(By.id("datenaissnce")).clear();
    driver.findElement(By.id("datenaissnce")).sendKeys("0002-02-12");
    driver.findElement(By.id("datenaissnce")).clear();
    driver.findElement(By.id("datenaissnce")).sendKeys("0020-02-12");
    driver.findElement(By.id("datenaissnce")).clear();
    driver.findElement(By.id("datenaissnce")).sendKeys("0200-02-12");
    driver.findElement(By.id("datenaissnce")).clear();
    driver.findElement(By.id("datenaissnce")).sendKeys("2000-02-12");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Formulaire'])[1]/following::div[1]")).click();
    driver.findElement(By.name("submit")).click();
  }

  @After
  public void tearDown() throws Exception {
   // driver.quit();
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
