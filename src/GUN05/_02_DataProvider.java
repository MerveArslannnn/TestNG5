package GUN05;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider {
    /**
     * Aşağıdaki ikili ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
     * data sayısı kadar test çalıştırılır, dataların olduğu yere DataProvider annottion ı konur.
     * çalıştırılacak teste ise dataProvider = "getData"  bölümü eklenir.
     * Dataprovider bir testi birden fazla DATA ile çok çalıştırmak için kullanılır.
     * XML filer file gruplama, pararalel, ve farklı tesleri koordine edip birarada çalıştırmak için kullanılır.
     */

    @Test(dataProvider = "datalarim")
    void UserNameTest(String useradi){
        System.out.println("useradi = " + useradi);
    }
    @DataProvider //bu metoda dataprovider görevi verildi
    public Object[] datalarim(){//DataProvider olarak kullanılacak metodun tipi object olmak zorunda
      Object[] userlar={"Nurhayat","Alper","Uğur","Hakan"};
       return userlar;
    }

    /*****************************/

    @Test(dataProvider = "datalarim1")
    void UserNameTest1(int id){
        System.out.println("id = " + id);
    }
    @DataProvider //bu metoda dataprovider görevi verildi
    public Object[] datalarim1(){//DataProvider olarak kullanılacak metodun tipi object olmak zorunda
        Object[] userlar={1,2,3,4};
        return userlar;


    }

}
