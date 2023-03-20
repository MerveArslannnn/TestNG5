package GUN05;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _04_Task extends BaseDriver {
    /**
     * Daha önceki derslerde yaptğımız Search fonksiyonunu
     * mac,ipod ve samsung için Dataprovider ile yapınız.
     */
    @Test(dataProvider = "getData")
    void SeachFunctionality(String ara) {
        WebElement seach = driver.findElement(By.xpath("//div[@id='search']/input"));
        seach.clear();
        seach.sendKeys(ara);
        WebElement button = driver.findElement(By.xpath("//div[@id='search']/span"));
        button.click();
        List<WebElement> captions = driver.findElements(By.cssSelector("div[class='caption']>h4"));
        for (WebElement e : captions) {
            Assert.assertTrue(e.getText().toLowerCase().contains(ara.toLowerCase()));
        }

    }

    @DataProvider
    Object[] getData() {
        Object[] data = {"mac", "ipod", "samsung"};
        return data;
    }
}
