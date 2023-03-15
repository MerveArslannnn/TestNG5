package GUN04;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _05_SeachFunctionality extends BaseDriver {
    /*
      Senaryo ;
      1- Siteyi açınız.
      2- mac kelimeini göndererek aratınız.
      3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
      4- aynı işlemi samsung için de yapınız
    */
    @Test
    @Parameters("arama")
    void SeachFunctionality(String ara){
        WebElement seach= driver.findElement(By.xpath("//div[@id='search']/input"));
        seach.sendKeys(ara);
        WebElement button= driver.findElement(By.xpath("//div[@id='search']/span"));
        button.click();
        List<WebElement>captions=driver.findElements(By.cssSelector("div[class='caption']>h4"));
        for (WebElement e:captions) {
            Assert.assertTrue(e.getText().toLowerCase().contains(ara));
        }

    }
}
