package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PalavraTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void testPalavraNaoExiste() throws Exception {
    driver.get(baseUrl + "/Tradutor/");
    driver.findElement(By.id("palavra")).clear();
    driver.findElement(By.id("palavra")).sendKeys("xxx");
    driver.findElement(By.name("Traduzir")).click();
    assertEquals("Palavra traduzida: xxx", driver.findElement(By.cssSelector("pre")).getText());
  }

  @Test
  public void testPrimeiraPalavra() throws Exception {
    driver.get(baseUrl + "/Tradutor/");
    driver.findElement(By.id("palavra")).clear();
    driver.findElement(By.id("palavra")).sendKeys("palavra");
    driver.findElement(By.name("Traduzir")).click();
    assertEquals("Palavra traduzida: WORD", driver.findElement(By.cssSelector("pre")).getText());
  }
  
  @Test
  public void testSegundaPalavra() throws Exception {
    driver.get(baseUrl + "/Tradutor/");
    driver.findElement(By.id("palavra")).clear();
    driver.findElement(By.id("palavra")).sendKeys("liquidificador");
    driver.findElement(By.name("Traduzir")).click();
    assertEquals("Palavra traduzida: BLENDER", driver.findElement(By.cssSelector("pre")).getText());
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
