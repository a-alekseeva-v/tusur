/*тест NG,Основные аннотации */
package online_tusur.unit_online_tusur;

import org.testng.annotations.* ;

public class NewTestNG {
    	  
  @Test()	  
	  public void test1() {
	  long id=Thread.currentThread().getId();
	  System.out.print("thread="+id);	
	  System.out.println("  test1");
  }
  
  @Test()	  
  public void test2() {
	  long id=Thread.currentThread().getId();
	  System.out.print("thread="+id);		  
  System.out.println("  test2");
}
  
  @BeforeMethod()	  
  public void testBeforeMethod() {
	  long id=Thread.currentThread().getId();
	  System.out.print("thread="+id);	
  System.out.println("  BeforeMethod");
}
  
  @AfterMethod()	  
  public void testAfterMethod() {
	  long id=Thread.currentThread().getId();
	  System.out.print("thread="+id);	
  System.out.println("  AfterMethod");
}
  
  
  @BeforeClass()	  
  public void testBeforeClass() {
	  long id=Thread.currentThread().getId();
	  System.out.print("thread="+id);	
  System.out.println("  BeforeClass");
}
  
  @AfterClass()	  
  public void testAfterClass() {
	  long id=Thread.currentThread().getId();
	  System.out.print("thread="+id);	
  System.out.println("  AfterClass");
}
  
  
  @BeforeTest()	  
  public void testBeforeTest() {
	  long id=Thread.currentThread().getId();
	  System.out.print("thread="+id);	
  System.out.println("  BeforeTest");
}
  
  @AfterTest()	  
  public void testAfterTest() {
	  long id=Thread.currentThread().getId();
	  System.out.print("thread="+id);	
  System.out.println("  AfterTest");
}
  
  
  @BeforeSuite()	  
  public void testBeforeSuite() {
	  long id=Thread.currentThread().getId();
	  System.out.print("thread="+id);	
  System.out.println("  BeforeSuite");
}
  
  @AfterSuite()	  
  public void testAfterSuite() {
	  long id=Thread.currentThread().getId();
	  System.out.print("thread="+id);	
  System.out.println("  AfterSuite");
}
  
  
  
  
  
  
  
  
  
  
  
}
