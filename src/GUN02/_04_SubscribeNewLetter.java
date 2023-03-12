package GUN02;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

//siteyi açın
//Newsletter Subscribe işlemini abone olunuz(yes)
//ayrı bir test ile Newaletter Subscribe işleminden çıkın(no)
//ayrı bir test ile Newaletter Subscribe durumunu kontrol edin Yes ise No ,No ise Yes yapın

public class _04_SubscribeNewLetter extends BaseDriver {
    By link=By.xpath("(//a[text()='Newsletter'])[1]");
    By YesButton=By.xpath("(//input[@type='radio'])[1]");
    By submit=By.xpath("//input[@type='submit']");
    By NoButton=By.xpath("(//input[@type='radio'])[2]");
    @Test(priority = 1)
    void subscribeFunctionYes(){



        WebElement newsLetterButton=driver.findElement(link);
        newsLetterButton.click();
        WebElement yessButton=driver.findElement(YesButton);
        yessButton.click();
        WebElement submitt=driver.findElement(submit);
        submitt.click();
        Tools.succesMessageValidation();


    }
    @Test(priority = 2)
    void subscribeFunctionNo(){
        WebElement newsLetterButton=driver.findElement(link);
        newsLetterButton.click();
        WebElement NooButton=driver.findElement(NoButton);
        NooButton.click();
        WebElement submitt=driver.findElement(submit);
        submitt.click();
        Tools.succesMessageValidation();

    }
    @Test(priority = 3)
    void subscribeFunctionForBoth(){
        WebElement newsLetterButton=driver.findElement(link);
        newsLetterButton.click();
        WebElement NooButton=driver.findElement(NoButton);
        WebElement YessButton=driver.findElement(YesButton);
        if (YessButton.isSelected())
            NooButton.click();
        else
            YessButton.click();

        WebElement submitt=driver.findElement(submit);
        submitt.click();
       Tools.succesMessageValidation();




    }

}
