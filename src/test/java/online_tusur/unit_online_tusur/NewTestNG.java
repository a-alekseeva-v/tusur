package online_tusur.unit_online_tusur;

import org.testng.annotations.* ;

public class NewTestNG {
    	  
  @Test()	  
	  public void test1() {
	  System.out.println("test1");
  }
  
  @Test()	  
  public void test2() {
  System.out.println("test2");
}
  
  @BeforeMethod()	  
  public void testBeforeMethod() {
  System.out.println("BeforeMethod");
}
  
  @AfterMethod()	  
  public void testAfterMethod() {
  System.out.println("AfterMethod");
}
  
  
  @BeforeClass()	  
  public void testBeforeClass() {
  System.out.println("BeforeClass");
}
  
  @AfterClass()	  
  public void testAfterClass() {
  System.out.println("AfterClass");
}
  
  
  @BeforeTest()	  
  public void testBeforeTest() {
  System.out.println("BeforeTest");
}
  
  @AfterTest()	  
  public void testAfterTest() {
  System.out.println("AfterTest");
}
  
  
  @BeforeSuite()	  
  public void testBeforeSuite() {
  System.out.println("BeforeSuite");
}
  
  @AfterSuite()	  
  public void testAfterSuite() {
  System.out.println("AfterSuite");
}
  
  
  
  
  
  
  
  
  
  
  
}
