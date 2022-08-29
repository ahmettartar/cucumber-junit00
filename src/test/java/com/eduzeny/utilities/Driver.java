package com.eduzeny.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    // Creating a private constructor, we are closing access to the
    // object of this class from outside the class
    private Driver() {
    }

    // We make WebDriver private, because we want to close access from outside of class
    // We make it static, because we will use it inside static method
    //private static WebDriver driver; // value is null by default
    // => PLUGIN SONRASI OFF YAPTIK YUKARIDAKINI.

    //driverPool kullanmak icin degistirmis olduk.

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    // Create a re-usable utility method which will return same driver instance when we call it
    public static WebDriver getDriver() {

        // it will check if driver is null and if it is we will set up browser inside if statement
        // if you already setup driver and using it again for following line of codes, it will return to same driver
        if (driverPool.get() == null) { //(driver == null)

            // We read browserType from configuration.properties with
            // help of ConfigurationReader class' getProperty() method
            String browserType = ConfigurationReader.getProperty("browser");

            //Selenium grid'te yukaridaki yerine bunu yazdik.(bak)
            //String browserName = System.getProperty("browser") != null ? browserName = System.getProperty("browser") : ConfigurationReader.getProperty("browser");

            switch(browserType){

                //selenium grid icin remote olanlari ekliyoruz.
                //personal ip adresi girilerek baglanti saglanir.

                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "52.90.101.17";
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub"); //import java.net
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "remote-firefox":
                    try {
                        // assign your grid server address
                        String gridAddress = "52.90.101.17";
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;


                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver()); //driver = new ChromeDriver();
                    driverPool.get().manage().window().maximize();//driver.manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }

        return driverPool.get(); //driver;
    }

    // This method will make sure our driver value is always null after using quit() method
    public static void closeDriver(){
        if(driverPool.get() != null){ // (driver != null)
            driverPool.get().quit(); // driver.quit(); //this line will terminate the existing driver session. with using this driver will not be even null
            driverPool.remove(); //driver = null;
        }

    }
}

