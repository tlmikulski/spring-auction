package pl.altkom.spring;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class SeleniumTest {
	public static void main(String[] args) {
		WebDriver chromeDriver = new FirefoxDriver();
		chromeDriver.get("http://google.pl");
		chromeDriver.findElement(By.id("lst-ib")).sendKeys("1212");

		chromeDriver.close();
	}
}
