package GUN03;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son adresi siliniz.
 */
public class _02_AddressFunctionality extends BaseDriver {

    @Test
    void addAddress(){
        WebElement addAddress= driver.findElement(By.linkText("Address Book"));
        addAddress.click();
        WebElement newAddress=driver.findElement(By.linkText("New Address"));
        newAddress.click();
        WebElement firstname=driver.findElement(By.id("input-firstname"));
        firstname.sendKeys("Buğra");
        WebElement lastname=driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Arslan");
        WebElement company=driver.findElement(By.id("input-company"));
        company.sendKeys("Arslan Tic. LTD");
        WebElement adress1=driver.findElement(By.id("input-address-1"));
        adress1.sendKeys("Cumhuriyet mah kule caddesi");
        WebElement adress2=driver.findElement(By.id("input-address-2"));
        adress2.sendKeys("Cumhuriyet mah kule caddesi");
        WebElement city=driver.findElement(By.id("input-city"));
        city.sendKeys("İstanbul");
        WebElement postCode=driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("152639");
        WebElement webcountry=driver.findElement(By.id("input-country"));
        Select country=new Select(webcountry);
        country.selectByVisibleText("Turkey");
        //2. seçenek
        wait.until(ExpectedConditions.elementToBeClickable(webcountry));//seçildikten sonra kendine gelene kadar bekle ki
        //state i seçebileyim dedik yani state i kendine gelmesi için bekletmiş oluyoruz

        //state yani şehir seçimi;
        //2. seçenek
      // WebElement options=driver.findElement(By.cssSelector("select[id='input-zone']>option"));//bu element geçene kadar bekle dedik
      // wait.until(ExpectedConditions.stalenessOf(options));
        WebElement webState=driver.findElement(By.id("input-zone"));
        Select state=new Select(webState);
        //state.selectByVisibleText("İstanbul");
        //state.selectByValue("3354");
        //selectByVisibleText---> findElement gibi çalıştığından implictly wait i kullanır.yani element görünene kadar
        //elemanı bulamaz ve NoSuchElementException(element bulunamadı hatası verir)
        state.selectByIndex(40);//StaleElementReferenceException--> bayat element demek eskisi gibi olmayan demek,
        // Yenilenmiş demek.  Tez buldum erken kaybettim demek :D
        //selectByIndex--> implicitly wait ile ÇALIŞMIYOR.ancak ExplicitWait ile çalışır.


        WebElement defaultaddress=driver.findElement(By.xpath("//input[@value='1']"));
        defaultaddress.click();
        WebElement kaydet=driver.findElement(By.xpath("//input[@value='Continue']"));
        kaydet.click();
        Tools.succesMessageValidation();
    }
    @Test(dependsOnMethods = {"addAddress"})
    void editAddress(){
        WebElement addAddress= driver.findElement(By.linkText("Address Book"));
        addAddress.click();
        List<WebElement>editAll=driver.findElements(By.linkText("Edit"));
        WebElement sonEdit=editAll.get(editAll.size()-1);//son edit
        sonEdit.click();

        WebElement firstname=driver.findElement(By.id("input-firstname"));
        firstname.clear();
        firstname.sendKeys("Armin");
        WebElement lastname=driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Arslan");

        WebElement defaultaddress=driver.findElement(By.xpath("//input[@value='1']"));
        defaultaddress.click();
        WebElement kaydet=driver.findElement(By.xpath("//input[@value='Continue']"));
        kaydet.click();
        Tools.succesMessageValidation();

    }
    @Test(dependsOnMethods = {"addAddress","editAddress"})
    void deleteAddress(){
        WebElement addAddress= driver.findElement(By.linkText("Address Book"));
        addAddress.click();

        List<WebElement>deleteAll=driver.findElements(By.linkText("Delete"));
        WebElement silinebilir=deleteAll.get(deleteAll.size()-2);//son edit
        silinebilir.click();

        Tools.succesMessageValidation();

    }

}
