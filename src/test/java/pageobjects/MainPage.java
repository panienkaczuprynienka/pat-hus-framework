package pageobjects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Wait;

import static utils.Await.awaitForElementToBeVisible;

public class MainPage extends BasePage {


  public MainPage(WebDriver driver) {
    super(driver);
  }

  public void assertLogoExists() {
    awaitForElementToBeVisible(driver, By.cssSelector(".logo"));
    WebElement logo = driver.findElement(By.cssSelector(".logo"));
    Assertions.assertThat(logo).isNotNull();
  }

  public PocztaPage clickPocztaIcon(){
    awaitForElementToBeVisible(driver, By.cssSelector(".mail"));
    WebElement pocztaIcon = driver.findElement(By.cssSelector(".mail"));
    pocztaIcon.click();
    awaitForElementToBeVisible(driver, By.cssSelector(".container-interia-poczta"));
    return new PocztaPage(driver);
  }

}
