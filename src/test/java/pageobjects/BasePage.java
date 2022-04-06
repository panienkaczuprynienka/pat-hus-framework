package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Await;

import static utils.Await.awaitForElementAndGet;
import static utils.Await.awaitForElementToBeInvisible;

public abstract class BasePage {
 protected WebDriver driver;
 protected WebDriverWait wait;

 protected static final By ACCEPT_COOKIES_BTN = By.cssSelector(".rodo-popup-agree");

  public BasePage(WebDriver driver) {
    this.driver = driver;
   this.wait = new WebDriverWait(driver, 5);
  }

  public void closeAcceptCookiesBanner(WebDriver driver){
   WebElement acceptBtn = awaitForElementAndGet(driver, ACCEPT_COOKIES_BTN);
   acceptBtn.click();
   awaitForElementToBeInvisible(driver, ACCEPT_COOKIES_BTN);
  }
}
