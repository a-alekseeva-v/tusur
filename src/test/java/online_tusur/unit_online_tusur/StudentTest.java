package online_tusur.unit_online_tusur;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class StudentTest {
	/*объект тестового класса  Student*/
	private Student s = new Student();	 	   

	    
/* проверка возраста студента, 
 выходящего за диапазон */
	  @Test  /*помечаем тестовой аннотацией*/
	  @Tag("positive")
	  void test1_assert() {
		/*секция подготовки*/
	    int age = 26;
		s.setAge(age);
	    int expectedAge = 26;
	    /*секция действия, получаем фактическое*/
	    int actualsAge=s.getAge();
	    /*секция проверки*/
	    assertEquals(expectedAge, actualsAge);	

	  }
	  
	  @Test 
	  @Tag("positive")
	  void test2_assert() {
		int age = 0;
		s.setAge(age);
	    int expectedAge = 18;
	    int actualsAge=s.getAge();
	     assertEquals(expectedAge, actualsAge);	
	  }
	  
	 	  
		  
	  @Test 
	  @Tag("positive")
	  void test3_assert() {
		int age = 50;
		s.setAge(age);
	    int expectedAge = 50;
	    int actualsAge=s.getAge();
	     assertEquals(expectedAge, actualsAge);	
	  }
	  
		  
	 
	 	  
	  @Test
	  @Tag("negative")
	  void testAgeInvalid1() {
		  int age = -17;
		  s.setAge(age);
		  int expectedAge = 18;
		  int actualsAge=s.getAge();
		  assertEquals(expectedAge, actualsAge);	  
	  }
	  
	  @Test
	  @Tag("negative")
	  void testAgeInvalid2() {
		  int age =025;
		  s.setAge(age);
		  int expectedAge = 25;
		  int actualsAge=s.getAge();
		  assertEquals(expectedAge, actualsAge);	  
	  }
	  
	  @Test
	  @Tag("negative")
	  void testAgeInvalid3() {
		  int age =-0;
		  s.setAge(age);
		  int expectedAge = 18;
		  int actualsAge=s.getAge();
		  assertEquals(expectedAge, actualsAge);	  
	  }
	  
	 
	  @Test  
	  @Tag("positive")
	  void testLastName1() {
		String fio = "Петров-Иванов";
		s.setLastName(fio);
	    String expectedName = "Петров-Иванов";
	    String actualsName=s.getLastName();
	    assertEquals(expectedName, actualsName);	
	  }
	  
	  @Test  
	  @Tag("positive")
	  void testLastName2() {
		String fio = "Гомес де ла Серна";
		s.setLastName(fio);
	    String expectedName = "Гомес де ла Серна";
	    String actualsName=s.getLastName();
	    assertEquals(expectedName, actualsName);	
	  }
	  
	  @Test  
	  @Tag("positive")
	  void testLastName3() {
		String fio = "ivanov";
		s.setLastName(fio);
	    String expectedName = "Ivanov";
	    String actualsName=s.getLastName();
	    assertEquals(expectedName, actualsName);	
	  }
	  
	  
	  @Test  
	  @Tag("negative")
	  void testLastNameInvalid1() {
		String fio = "true";
		s.setLastName(fio);
	    String expectedName = "True";
	    String actualsName=s.getLastName();
	    assertEquals(expectedName, actualsName);	
	  }
	  
	  @Test  
	  @Tag("negative")
	  void testLastNameInvalid2() {
		String fio = "ID12345";
		s.setLastName(fio);
	    String expectedName = "Id12345";
	    String actualsName=s.getLastName();
	    assertEquals(expectedName, actualsName);	
	  }
	  
	  @Test  
	  @Tag("negative")
	  void testLastNameInvalid3() {
		String fio = "";
		s.setLastName(fio);
	    String expectedName = "";
	    String actualsName=s.getLastName();
	    assertEquals(expectedName, actualsName);	
	  }
	  
	  
	  @Test  
	  @Tag("positive")
	  void testName1() {
		String imena = "Анна-Мария";
		s.setFirstName(imena);
	    String expectedName = "Анна-Мария";
	    String actualsName=s.getFirstName();
	    assertEquals(expectedName, actualsName);	
	  }
	  
	  @Test  
	  @Tag("positive")
	  void testName2() {
		String imena = "Флоренс Луиза";
		s.setFirstName(imena);
	    String expectedName = "Флоренс Луиза";
	    String actualsName=s.getFirstName();
	    assertEquals(expectedName, actualsName);	
	  } 
	  
	  @Test  
	  @Tag("positive")
	  void testName3() {
		String imena = "anna";
		s.setFirstName(imena);
	    String expectedName = "Anna";
	    String actualsName=s.getFirstName();
	    assertEquals(expectedName, actualsName);	
	  } 
	  
	  @Test  
	  @Tag("negative")
	  void testNameInvalid1() {
		String imena = "";
		s.setFirstName(imena);
	    String expectedName = "";
	    String actualsName=s.getFirstName();
	    assertEquals(expectedName, actualsName);	
	  }
	  
	  @Test  
	  @Tag("negative")
	  void testNameInvalid2() {
		String imena = "   ";
		s.setFirstName(imena);
	    String expectedName = "   ";
	    String actualsName=s.getFirstName();
	    assertEquals(expectedName, actualsName);	
	  }
	  
	  @Test  
	  @Tag("negative")
	  void testNameInvalid3() {
		String imena = "123456";
		s.setFirstName(imena);
	    String expectedName = "123456";
	    String actualsName=s.getFirstName();
	    assertEquals(expectedName, actualsName);	
	  }
	  
}