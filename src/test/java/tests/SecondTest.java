package tests;

import listeners.Listener;
import listeners.Retry;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.PocztaPage;

@Listeners(Listener.class)
public class SecondTest extends BaseTest {

  @Test(retryAnalyzer = Retry.class)
  public void mySecondTest() throws Exception {
    mainPage.closeAcceptCookiesBanner(driver);
    mainPage.assertLogoExists();
    PocztaPage pocztaPage = mainPage.clickPocztaIcon();
    pocztaPage.assertLogInFormVisible();
  }
}