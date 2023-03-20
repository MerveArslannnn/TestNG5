package GUN05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProvider_CokBoyutlu {
    @Test(dataProvider = "UserData")
    void UsernameTest(String username,String password){
        System.out.println("username = " + username+" "+password);
    }

    @DataProvider
    public Object[][]UserData(){
        Object[][]data={
                {"Nurhayat","12345"},
                {"Alper","254678"},
                {"Uğur","748596"},
                {"Hakan","859674"}
        };
        return data;
    }

}
