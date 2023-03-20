package GUN05;

import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _05_Task2 extends BaseDriverParameter {
    /**
     * Bir önceki task da yapılan testi PARAMETERDRIVER ile yapınız
     * sonrasında fakrlı tarayıcılar ile çalıştırınız. (crossbrowser)
     * sonrasında paralel çalıştırınız.(parallel)
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
