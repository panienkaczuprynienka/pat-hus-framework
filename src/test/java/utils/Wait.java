package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class Wait {
protected WebDriver driver;
protected WebDriverWait wait;
protected static final long DURATION = 10;

  public Wait(WebDriver driver) {
    this.driver = driver;
    this.wait=new WebDriverWait(driver, DURATION);
  }

  public WebDriver getWebDriver() {
    return driver;
  }

  public  void waitForElementToBeVisible(By locator){
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
  }

}
