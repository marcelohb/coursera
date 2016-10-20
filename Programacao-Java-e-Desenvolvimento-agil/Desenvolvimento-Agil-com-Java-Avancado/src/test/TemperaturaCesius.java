package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TemperaturaCesius {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "C:\\Programas\\geckodriver-v0.11.1-win64\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void cemGraus() throws Exception {
    driver.get(baseUrl + "/Temperaturas/");
    new Select(driver.findElement(By.id("tipo"))).selectByVisibleText("Celcius");
    driver.findElement(By.name("t1")).clear();
    driver.findElement(By.name("t1")).sendKeys("100");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("100.0 graus celsius = 212.0 graus fahrenheit", driver.findElement(By.cssSelector("pre")).getText());
  }

  @Test
  public void zeroGraus() throws Exception {
    driver.get(baseUrl + "/Temperaturas/");
    new Select(driver.findElement(By.id("tipo"))).selectByVisibleText("Celcius");
    driver.findElement(By.name("t1")).clear();
    driver.findElement(By.name("t1")).sendKeys("0");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("0.0 graus celsius = 32.0 graus fahrenheit", driver.findElement(By.cssSelector("pre")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
