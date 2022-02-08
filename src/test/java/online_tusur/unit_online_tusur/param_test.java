package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParamTest {
	
	Student s = new Student();
	Student s1 = new Student();
	Student s2 = new Student();
	Student s3 = new Student();
	Student[] students = { s1,s2,s3};

@ParameterizedTest
@Tag("positive")
@ValueSource(ints = {17,51,45, Integer.MAX_VALUE})
void testWithValueSourse(int param)
{
	s.setAge(param);
	assertTrue(s.getAge()>=18);	

}

@ParameterizedTest
@Tag("positive")
@MethodSource("intMethod2")
void testWithMethodSourse(Integer param)
{
	s.setAge(param);
	assertNotEquals(18, s.getAge());	

}

//провайдеры для теста testWithMethodSourse()
static Stream <Integer> intMethod1(){
	return Stream.of(25,50);}

static IntStream intMethod2(){
	return IntStream.range(18,50);}

//пример параметризированного теста с источником параметров из файла
@ParameterizedTest
@Tag("positive")
@CsvFileSource(resources="name.csv")
void testWithCsvSourse(String param)
{
s.setFirstName(param);
assertNotNull(s.getFirstName());
}

/*задание 3*/
/*в этом тесте каждому возрасту должно возвращаться 18, поэтому среднее значение у всех должно быть одинаковое*/
 /*в последнем тесте должна быть ошибка , так как 50 должно возвращаться 50  */
@ParameterizedTest
@Tag("positive")
@CsvSource({"0,17,18","-10,1,10","17,18,51","50,51,100"})
void testWithCsvSource(int ag1,int ag2,int ag3)
{  s1.setAge(ag1);
   s2.setAge(ag2);
   s3.setAge(ag3);
   assertEquals(18, Student.avgAge(students));	
}
/*тут проверяем те значения, которые лежат в промежутке от 18 до 50 и не меняются на 18 */
@ParameterizedTest
@Tag("positive")
@CsvSource({"18,19,25","36,38,40","40,45,50"})
void testWithCsvSource2(int ag1,int ag2,int ag3)
{  s1.setAge(ag1);
   s2.setAge(ag2);
   s3.setAge(ag3);
   
   assertEquals((ag1+ag2+ag3)/3, Student.avgAge(students));	
}


//пример динамического теста
@TestFactory
@Tag("negative")
Collection <DynamicTest> dynamicTest1()
{
s1.setAge(25);
s2.setAge(50);

return Arrays.asList(
		DynamicTest.dynamicTest("dTest1", ()->assertEquals(25,s1.getAge())),
		DynamicTest.dynamicTest("dTest2", ()->assertEquals(50,s2.getAge()))
		
		);
}
//пример динамического теста
@TestFactory
@Tag("negative")
Stream<DynamicTest> dynamicTestsGetters() {

  Student[] studentsObjects = {new Student("Sergey", "Nasedkin", 49), new Student("Ivan", "Nesterov", 38), new Student("Gleb", "Petrov", 18)};

  String[] firstNameTest = {"Sergey", "Ivan", "Gleb"};
  String[] lastNameTest = {"Nasedkin", "Nesterov", "Petrov"};
  Integer[] ageTest = {49, 38, 18};

  List<DynamicTest> dynamicTests = new ArrayList<>();

  for (int i = 0; i < studentsObjects.length; i++) {
      int k = i;
      DynamicTest dynamicTestFirstName = DynamicTest.dynamicTest("DynamicTest getFirstName(" + firstNameTest[k] + ")", 
      		() -> {assertEquals(firstNameTest[k], studentsObjects[k].getFirstName());
      });
      DynamicTest dynamicTestLastName = DynamicTest.dynamicTest("DynamicTest getLastName(" + lastNameTest[k] + ")", () -> {
          assertEquals(lastNameTest[k], studentsObjects[k].getLastName());
      });
      DynamicTest dynamicTestAge = DynamicTest.dynamicTest("DynamicTest getAge(" + ageTest[k] + ")", () -> {
          assertEquals(ageTest[k], studentsObjects[k].getAge());
      });

      dynamicTests.add(dynamicTestFirstName);
      dynamicTests.add(dynamicTestLastName);
      dynamicTests.add(dynamicTestAge);

  }

  return dynamicTests.stream();
}

/*задание 4*/
@TestFactory
@Tag("positive")
Stream<DynamicTest> dynamicTestsGetLastName() {
	Student[] studentsObjects = {new Student("sergey", "nasedkin", 17), new Student("ильЯ", "nesteroV", 18), new Student("Анна-Мария", "Сильвен де Роуз", 25),new Student("Михаил", "Салтыков-Щедрин", 50),new Student("ивАн", "ивАнов", 51),new Student("Розалинда Флоренс Луна", "сильвианс", 65)};
	 String[] lastNameTest = {"Nasedkin", "Nesterov", "Сильвен де Роуз","Салтыков-Щедрин","Иванов","Сильвианс"};
	 List<DynamicTest> dynamicTests = new ArrayList<>();

	  for (int i = 0; i < studentsObjects.length; i++) {
	      int k = i;
	   	      DynamicTest dynamicTestLastName = DynamicTest.dynamicTest("DynamicTest getLastName(" + lastNameTest[k] + ")", () -> {
	          assertEquals(lastNameTest[k], studentsObjects[k].getLastName());
	      });
	      dynamicTests.add(dynamicTestLastName);
		  }
	  return dynamicTests.stream();
}

@TestFactory
@Tag("positive")
Stream<DynamicTest> dynamicTestsGetFirstName() {
	Student[] studentsObjects = {new Student("sergey", "nasedkin", 17), new Student("ильЯ", "nesteroV", 18), new Student("Анна-Мария", "Сильвен де Роуз", 25),new Student("Михаил", "Салтыков-Щедрин", 50),new Student("ивАн", "ивАнов", 51),new Student("Розалинда Флоренс Луна", "сильвианс", 65)};
	 String[] firstNameTest = {"Sergey", "Илья", "Анна-Мария","Михаил","Иван","Розалинда Флоренс Луна"};
	 List<DynamicTest> dynamicTests = new ArrayList<>();

	  for (int i = 0; i < studentsObjects.length; i++) {
	      int k = i;
	   	      DynamicTest dynamicTestFirstName = DynamicTest.dynamicTest("DynamicTest getFirstName(" + firstNameTest[k] + ")", () -> {
	          assertEquals(firstNameTest[k], studentsObjects[k].getFirstName());
	      });
	      dynamicTests.add(dynamicTestFirstName);
		  }
	  return dynamicTests.stream();
}

@TestFactory
@Tag("positive")
Stream<DynamicTest> dynamicTestsGetAge() {
	Student[] studentsObjects = {new Student("sergey", "nasedkin", 17), new Student("ильЯ", "nesteroV", 18), new Student("Анна-Мария", "Сильвен де Роуз", 25),new Student("Михаил", "Салтыков-Щедрин", 50),new Student("ивАн", "ивАнов", 51),new Student("Розалинда Флоренс Луна", "сильвианс", 65)};
	Integer[] ageTest = {18, 18, 25, 50, 18, 18};
	List<DynamicTest> dynamicTests = new ArrayList<>();

	  for (int i = 0; i < studentsObjects.length; i++) {
	      int k = i;

	      DynamicTest dynamicTestAge = DynamicTest.dynamicTest("DynamicTest getAge(" + ageTest[k] + ")", () -> {
	          assertEquals(ageTest[k], studentsObjects[k].getAge());
	      });

	      dynamicTests.add(dynamicTestAge);

	  }

	  return dynamicTests.stream();
	}




}
