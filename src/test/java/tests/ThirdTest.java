package tests;

import listeners.Listener;
import listeners.Retry;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjects.PocztaPage;

@Listeners(Listener.class)
public class ThirdTest extends BaseTest {

  @Test(retryAnalyzer = Retry.class)
  public void myThirdTest() throws Exception {
    mainPage.closeAcceptCookiesBanner(driver);
    mainPage.assertLogoExists();
    PocztaPage pocztaPage = mainPage.clickPocztaIcon();
    pocztaPage.assertLogInFormVisible();
    Assert.assertEquals(1, 2);
  }
}
