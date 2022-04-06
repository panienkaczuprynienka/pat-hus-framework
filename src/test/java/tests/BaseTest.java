package tests;

import DriverManager.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import navigation.ApplicationUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pageobjects.MainPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

  protected WebDriver driver;
  protected WebDriverWait wait;
  protected MainPage mainPage;

  @BeforeClass
  public void setUp() throws Exception {
    driver = new DriverManager.WebDriverManager().getWebDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 5);
    driver.navigate().to(ApplicationUrl.MAIN_PAGE);
    mainPage = new MainPage(driver);

  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}
