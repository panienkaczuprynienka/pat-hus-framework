package DriverManager;

import configuration.ConfigurationReader;
import listeners.Listener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static DriverManager.Browser.*;
import static configuration.ConfigurationReader.getConfigurationReader;
import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class WebDriverManager {

  private Logger log = LogManager.getLogger(Listener.class);
  private WebDriver driver;
  private static String GRID_URL = null;
  private static String BROWSER;

  static {
    try {
      BROWSER = ConfigurationReader.getConfigurationReader().getBrowser();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      GRID_URL = getConfigurationReader().getGridUrl();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public WebDriver getWebDriver() throws Exception {
    if (!getConfigurationReader().isRemote()) {
      log.info("Running tests locally");
      switch (valueOf(BROWSER)) {
        case CHROME:
          chromedriver().setup();
          driver = new ChromeDriver();
          return driver;
        case FIREFOX:
          System.setProperty("webdriver.gecko.driver", "C:/drivers/geckodriver.exe");
          driver = new FirefoxDriver();
          return driver;
        default:
          log.warn("Not applicable name of driver chosen");
      }
    } else {
      log.info("Running tests remotely");
      switch (valueOf(BROWSER)) {
        case CHROME:
          ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
          ChromeOptions chromeOptions = new ChromeOptions();
          driver = new RemoteWebDriver(new URL(GRID_URL), chromeOptions);
          webDriverThreadLocal.set(driver);
          return webDriverThreadLocal.get();
        case FIREFOX:
          FirefoxOptions firefoxOptions = new FirefoxOptions();
          driver = new RemoteWebDriver(new URL(GRID_URL), firefoxOptions);
          return driver;
        default:
          log.warn("Not applicable name of driver chosen");
      }
    }
    return null;
  }
}