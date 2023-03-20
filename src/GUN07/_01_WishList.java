package GUN07;
/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */
import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_WishList extends BaseDriver {
   @Test
   @Parameters("searchText")
    void addToWishlist(String text){
       WebElement seach= driver.findElement(By.xpath("//div[@id='search']/input"));
       seach.sendKeys(text);
       WebElement button= driver.findElement(By.xpath("//div[@id='search']/span"));
       button.click();
      List<WebElement>searchResult=driver.findElements(By.cssSelector("div[class='caption']>h4>a"));
      int randomSecim=Tools.RandomGenerator(searchResult.size());
      String wishItemText=searchResult.get(randomSecim).getText();//tıklanacak elemanın ismini aldık
      System.out.println("wishItemText = " + wishItemText);

      List<WebElement>wishButtonList=driver.findElements(By.xpath("//button[@data-original-title='Add to Wish List']"));
      wishButtonList.get(randomSecim).click();//random elementin wish listenide tıklattık

      WebElement wishbtnProducts= driver.findElement(By.id("wishlist-total"));
      wishbtnProducts.click();

      List<WebElement>wishTableNames=driver.findElements(By.xpath("//td[@class='text-left']/a"));
      //wishItemText i wishTableNames in gettext lerini var mı diye kontrol edeceğiz
      Tools.listContainsString(wishTableNames,wishItemText);






}


}
