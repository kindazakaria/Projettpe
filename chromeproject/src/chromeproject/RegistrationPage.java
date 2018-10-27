package chromeproject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class RegistrationPage {
WebDriver driver;
public void invokeBrowser() {
try {
{
System.setProperty("webdriver.chrome.driver", "C:\\Users\\USer\\eclipse-workspace\\chromeproject\\chromedriver.exe");
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
}
} catch (Exception e) {
e.printStackTrace();
}
}
public void registration() {
try {
{
driver.navigate().to("http://localhost:8095/tp1/inscription;jsessionid=94735B6D9D247C289EEF6832C1BF6250");
driver.findElement(By.name("nom")).sendKeys("adama");
driver.findElement(By.name("prenom")).sendKeys("kinda");

Select country=new Select(driver.findElement(By.name("lieun")));
country.selectByVisibleText("Hanoi");

Select month=new Select(driver.findElement(By.name("stat")));
month.selectByVisibleText("Adherent");
//Select day =new Select(driver.findElement(By.id("dd_date_8")));
//day.selectByVisibleText("13");
//Select year=new Select(driver.findElement(By.name("datenaissnce")));
//year.selectByVisibleText("");

driver.findElement(By.name("motp")).sendKeys("adamakinda");

driver.findElement(By.id("datenaissnce")).sendKeys("08/12/1999");

Thread.sleep(1000);


//click on submit button
driver.findElement(By.name("submit")).click();
}
} catch (InterruptedException e) {
e.printStackTrace();
}
}
public static void main(String[] args) {
RegistrationPage obj=new RegistrationPage();
obj.invokeBrowser();
obj.registration();
}
}
