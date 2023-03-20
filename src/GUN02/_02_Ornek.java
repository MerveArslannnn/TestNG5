package GUN02;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class _02_Ornek extends BaseDriver {
    @Test
    void loginTest(){
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
}
