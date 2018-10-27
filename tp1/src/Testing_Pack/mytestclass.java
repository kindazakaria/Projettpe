package Testing_Pack;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class mytestclass {

 public static void main(String[] args) {
  //set geckodriver path.
  System.setProperty("webdriver.gecko.driver","C:\\Users\\USer\\eclipse-workspace\\tp1\\src\\geckodriver.exe");
  //initialize firefox driver object to open firefox browser.
    WebDriver driver = new FirefoxDriver();
    //open URL in browser.
    driver.get("http://localhost:8095/tp1/login");
    String i = driver.getCurrentUrl();
    System.out.println(i);
    driver.close();
   }
}