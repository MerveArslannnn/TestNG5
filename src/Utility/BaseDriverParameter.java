package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BaseDriverParameter {
    public WebDriver driver;
    public static WebDriverWait wait; //bayatlamış elementler için yaptık

    @BeforeClass
    @Parameters("browserTipi")
    public void baslangicIslemler(String browser)
    {
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        switch (browser.toLowerCase()){
            case "firefox":
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver=new FirefoxDriver();
                System.out.println("firefox started");  break;
            case "safari":
                driver=new SafariDriver();
                System.out.println("safari started");break;
            case "edge":
                driver=new EdgeDriver();
                System.out.println("edge started");break;
            default:
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
        }

        //driver.manage().window().maximize(); // Ekranı max yapıyor.
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);

        wait=new WebDriverWait(driver,Duration.ofSeconds(30));//bayatlamış elementler için yaptık
        loginTest();
    }
     void loginTest()
    {
        System.out.println("Login Test");
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("mervegz263@gmail.com");
        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("Armin12345");
        WebElement loginButton=driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));
        //Assert.assertEquals(driver.getTitle(),"My Account","Login olamadı");


    }

    @AfterClass
    public void bitisIslemleri()
    {
        Tools.Bekle(5);
        driver.quit();
    }
}


