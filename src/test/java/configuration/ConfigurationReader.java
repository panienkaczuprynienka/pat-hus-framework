package configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

  private Properties properties;
  private static ConfigurationReader configurationReader;

  private ConfigurationReader() {
    BufferedReader reader;
    String propertyFilePath = "src/main/resources/configuration.properties";
    try {
      reader = new BufferedReader(new FileReader(propertyFilePath));
      properties = new Properties();
      try {
        properties.load(reader);
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
    }
  }

  public static ConfigurationReader getConfigurationReader() {
    if (configurationReader == null) {
      configurationReader = new ConfigurationReader();
    }
    return configurationReader;
  }

  public String getBrowser() throws Exception {
    String browser = properties.getProperty("browser");
    if (browser == null) {
      throw new Exception("Browser not specified in configuration.properties");
    } else {
      return browser;
    }
  }

  public Boolean isRemote() throws Exception {
    String isRemote = properties.getProperty("is.remote");
    if (isRemote.equals("false")) {
      return false;
    } else if (isRemote.equals("true")) {
      return true;
    } else {
      throw new Exception("Is remote not specified / incorrectly specified in configuration.properties");
    }
  }

  public String getGridUrl() throws Exception {
    String gridUrl = properties.getProperty("grid.url");
    if (gridUrl == null) {
      throw new Exception("Grid url not specified in configuration.properties");
    } else {
      return gridUrl;
    }
  }
}
