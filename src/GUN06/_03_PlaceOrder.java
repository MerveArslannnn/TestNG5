package GUN06;
/*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_PlaceOrder extends BaseDriver {
    @Test
    void ProceedToCheckout() {
        _03_PlaceOrderElements elements=new _03_PlaceOrderElements();

      elements.searchBox.sendKeys("ipod");
      elements.searchButton.click();
      elements.addToChart.click();
      elements.shoppingChart.click();
      elements.checkOut.click();

       wait.until(ExpectedConditions.elementToBeClickable(elements.continue1)).click();
       wait.until(ExpectedConditions.elementToBeClickable(elements.continue2)).click();
       wait.until(ExpectedConditions.elementToBeClickable(elements.continue3)).click();
       elements.agree.click();
       wait.until(ExpectedConditions.elementToBeClickable(elements.continue4)).click();
       wait.until(ExpectedConditions.elementToBeClickable(elements.confirm)).click();
       wait.until(ExpectedConditions.urlContains("success"));

        Assert.assertEquals(elements.msg.getText(),"Your order has been placed!","Onay texti bulunamadi");

    }

}
