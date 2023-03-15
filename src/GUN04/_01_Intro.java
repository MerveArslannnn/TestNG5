package GUN04;

import org.testng.annotations.*;

public class _01_Intro {
  /*  @BeforeSuite
    @BeforeTest--> smoke Test
    @BeforeGroups
    @BeforeClass
    @BeforeMethod
    @Test--> method
    @Test--> method
    @AfterMethod
    @AfterClass
    @AfterGroups
    @AfterTest
    @AfterSuite

   */
  @BeforeSuite
  void bSuite(){System.out.println("Before Suite");}

  @BeforeTest
  void bTest(){System.out.println("Befor Test");}

  @BeforeGroups
  void bGroups(){System.out.println("Befor Groups");}

  @BeforeClass
  void bClass(){System.out.println("Befor Class");}

  @BeforeMethod
  void bMethod(){System.out.println("Befor Method");}

  @Test
  void Intro_1_Test1(){System.out.println("_01_Intro_Test1-> Test 1");}

  @Test
  void Intro_1_Test2(){System.out.println("_01_Intro_Test2-> Test 1");}

  @AfterMethod
  void aMethod(){System.out.println("After Method");}

  @AfterClass()
  void aClass(){System.out.println("After Class");}

  @AfterGroups
  void aGroups(){System.out.println("After Groups");}

  @AfterTest
  void aTest(){System.out.println("After Test");}

  @AfterSuite
  void aSuite(){System.out.println("After Suite");}





}
