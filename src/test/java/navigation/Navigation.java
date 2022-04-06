package navigation;

import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;

public class Navigation {
  WebDriver driver;

  public MainPage navigateToMainPage(){
    driver.navigate().to(ApplicationUrl.MAIN_PAGE);
    return new MainPage(driver);
  }

}
