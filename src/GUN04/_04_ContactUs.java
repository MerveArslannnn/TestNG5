package GUN04;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _04_ContactUs extends BaseDriver {
    /*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */

    @Test
    @Parameters("mesaj")//xmk deki parametre adı aynı olmak zorunda
    void contactUs(String gelenMesaj){
        //String gelen mesaj:method için gerekli tanımlama aynı olmak zorunda değil
        WebElement contactUs=driver.findElement(By.linkText("Contact Us"));
        contactUs.click();
        WebElement enquayArea= driver.findElement(By.xpath("//div[@class='col-sm-10']/textarea"));
        enquayArea.sendKeys(gelenMesaj);
        WebElement submit= driver.findElement(By.xpath("//div[@class='pull-right']/input"));
        submit.click();
        Assert.assertTrue(driver.getTitle().equals("Contact Us"));

    }
}
