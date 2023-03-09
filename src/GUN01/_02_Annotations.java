package GUN01;

import org.testng.annotations.*;


public class _02_Annotations {
    @BeforeClass
    public void beforeClass(){ //driver ın çalıştığı yer
        System.out.println("before class çalıştı");
    }
    @AfterClass
    public void afterClass(){  //BekleKapat ın çalıştığı yer
        System.out.println("after class çalıştı");
    }

    @BeforeMethod
    public void beforeMethod(){// her methoddan önce çalışır
        System.out.println("before method çalıştı");
    }
    @AfterMethod
    public void afterMethod(){//her methoddan sonra çalışır
        System.out.println("after method çalıştı");
    }

    @Test
    public void test1(){
        System.out.println("test 1 çalıştı");
    }

    @Test
    public void test2(){
        System.out.println("test 2 çalıştı");
    }

}
