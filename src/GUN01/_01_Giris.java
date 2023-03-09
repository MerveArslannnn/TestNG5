package GUN01;

import org.testng.annotations.Test;

public class _01_Giris {
  // public static void main(String[] args) {
  //     webSitesiniAc();
  //     LoginIsleminiYap();
  //     driveriKapat();
  // }

  // @Test JUnit di
  //  public void Test1(){
  //     webSitesiniAc();
  //     LoginIsleminiYap();
  //     driveriKapat();
  //  }

    //Eğer herhangi bir sıralama vermezse metod isimlerinin alfabetik sırasına göre çalışıyor
    @Test(priority = 1)
    public void webSitesiniAc(){

        System.out.println("driver tanımlandı ve web sitesi açıldı");
    }

    @Test(priority = 2)
    public void loginIsleminiYap(){

        System.out.println("Login test işlemi yapıldı");
    }
    @Test(priority = 3)
    public void driveriKapat(){

        System.out.println("driver kapatıldı");
    }


}
