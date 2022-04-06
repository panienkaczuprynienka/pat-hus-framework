package pageobjects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Await.awaitForElementAndGet;

public class PocztaPage extends BasePage {

  public PocztaPage(WebDriver driver) {
    super(driver);
  }

  public void assertLogInFormVisible() {
    Assertions.assertThatCode(() ->
    {
      awaitForElementAndGet(driver, By.id("sitebar"));
    }).doesNotThrowAnyException();
  }
}
