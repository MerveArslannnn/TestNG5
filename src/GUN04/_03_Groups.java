package GUN04;

import org.testng.annotations.Test;

public class _03_Groups {

    @Test(groups = {"SmokeTest"})
    void Test1(){System.out.println("test1");}

    @Test(groups = {"Regression"})
    void Test3(){System.out.println("test3");}

    @Test(groups = {"Regression"})
    void Test5(){System.out.println("test5");}

    @Test(groups = {"Regression"})
    void Test2(){System.out.println("test2");}

    @Test(groups = {"SmokeTest"})
    void Test4(){System.out.println("test4");}

    @Test(groups = {"SmokeTest"})
    void Test6(){System.out.println("test6");}

    @Test
    void Test7(){System.out.println("test7");}
}
