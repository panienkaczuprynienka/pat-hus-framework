package tests;

import configuration.ConfigurationReader;
import listeners.Listener;
import listeners.Retry;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.PocztaPage;

@Listeners(Listener.class)
public class FirstTest extends BaseTest {

  @Test(retryAnalyzer = Retry.class)
  public void myFirstTest() throws Exception {
    mainPage.closeAcceptCookiesBanner(driver);
    mainPage.assertLogoExists();
    PocztaPage pocztaPage = mainPage.clickPocztaIcon();
    pocztaPage.assertLogInFormVisible();
  }

}
