package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.awaitility.Awaitility.await;

public class Await {

  public static void awaitForElementToBeVisible(WebDriver driver, By locator){
    await().until(() -> !driver.findElements(locator).isEmpty());
  }
  public static WebElement awaitForElementAndGet(WebDriver driver, By locator){
    await().until(() -> !driver.findElements(locator).isEmpty());
    return driver.findElement(locator);
  }

  public static void awaitForElementToBeInvisible(WebDriver driver, By locator){
    await().until(() -> driver.findElements(locator).isEmpty());
  }
}
