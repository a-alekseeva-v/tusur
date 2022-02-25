/*TestNG*/
/*Группы и зависимости тестов для проекта Студент*/
package online_tusur.unit_online_tusur;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

public class NewTestNG1 {
 
	Student s=new Student();
	ArrayList <Student> arrstudents;	
	
	
	
	@BeforeClass()
	public void setUp() {
		  long id=Thread.currentThread().getId();
		  System.out.print("thread="+id);
		  System.out.println("setUp");
		arrstudents=new ArrayList<Student>();
				
	}
	//очистка нашей коллекции
	@AfterClass()
	public void teamDown () {
		  long id=Thread.currentThread().getId();
		  System.out.print("thread="+id);
		  System.out.println("teamDown");
		arrstudents.clear();
	}
	
	@Test(groups={"StudentTest"})
	public void testAge1() {
		  long id=Thread.currentThread().getId();
		  System.out.print("thread="+id);
		  System.out.println("testAge1");
		int age=30;
		s.setAge(age);
		int expectedage=30;
		AssertJUnit.assertEquals(expectedage,s.getAge());
	}
	
	@Test(groups={"StudentTest"},enabled=false)
	public void testAge2() {
		  long id=Thread.currentThread().getId();
		  System.out.print("thread="+id);
		  System.out.println("testAge2");
		int age=50;
		s.setAge(age);
		int expectedage=50;
		AssertJUnit.assertEquals(expectedage,s.getAge());
	}
	
	/*проверим, что коллекция пустая*/
	@Test(priority=0,groups={"StudentCollection"})
	public void testEmptyCollection() {
		  long id=Thread.currentThread().getId();
		  System.out.print("thread="+id);
		  System.out.println("testEmptyCollection");
	assertTrue(arrstudents.isEmpty());
	}
	
	
	/*добавляем студентов*/
	@Test(priority=1,groups= {"StudentCollection"})
	public void testItemCollection() {
		  long id=Thread.currentThread().getId();
		  System.out.print("thread="+id);
		  System.out.println("testItemCollection");
	 int k=arrstudents.size();
	 arrstudents.add(new Student("Piter","Men",35));
	 assertEquals(k+1,arrstudents.size());
	 			}
	
	/*проверим, что коллекция непустая*/
	@Test(priority=2,groups= {"StudentCollection"},dependsOnMethods= {"testItemCollection"})
	public void testNotEmptyCollection() {
		  long id=Thread.currentThread().getId();
		  System.out.print("thread="+id);	
		  System.out.println("testNotEmptyCollection");
	assertFalse(arrstudents.isEmpty())	;
	}
	
	/*@Test(priority=0,groups= {"StudentCollection"},expectedExceptions= {NullPointerException.class})
	public void testExceptionCollection() {
		arrstudents=null;
		int size=arrstudents.size();
	}*/	
	
	
	
}
