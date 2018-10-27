package Testing_Pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Gecko_Driver {

public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\USer\\eclipse-workspace\\tp1\\src\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.toolsqa.com");

	Thread.sleep(5000);
	driver.quit();
}
}
