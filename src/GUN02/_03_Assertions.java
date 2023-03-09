package GUN02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {

    @Test
    void EqualsOrnek(){
        String s1="Merhaba";
        String s2="Merhaba1";
        //Actual(oluşan),Expected(beklenen),Mesaj(opsiyonel)
        Assert.assertEquals(s1,s2,"Oluşanla beklenen eşit değil");

    }

    @Test
    void notEqualsOrnek(){
        String s1="Merhaba";
        String s2="Merhaba1";
        Assert.assertNotEquals(s1,s2,"Oluşan ve beklenen eşit oldu");
    }
    @Test
    void TrueOrnek(){
        int s1=55;
        int s2=66;
        Assert.assertTrue(s1 == s2,"Oluşan ve Beklenen eşit olmadı");
    }
    @Test
    void NullOrnek(){
        String s1=null;
        Assert.assertNull(s1,"Oluşan null olmadı");
    }
    @Test
    void direkFail(){
        int a=55;
        if (a == 55)
            Assert.fail();
    }
}
