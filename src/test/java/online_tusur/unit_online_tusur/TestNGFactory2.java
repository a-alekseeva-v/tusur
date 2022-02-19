/*Тест NG.
 * Практическое задание 6. Фабрики тестов в TestNG
 * проверяем, что геттеры что-то возвращают
 * Создадим фабрику. Фабрику будем создавать через конструктор класса, а не отдельно!!!.*/
package online_tusur.unit_online_tusur;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestNGFactory2{

	@DataProvider(name="firstNameProvider")
	public static Object[]firstNameProvider()
	{		return new Object[] {
			new Student("Ivan","Ivanov",25),
			new Student("Piter","Petrov",51),
			new Student("Маша","Иванова",17),
			new Student("Alex","Алексеев",18),
			new Student("Саша-Паша","Петров-Иванов",50)};
	}

	private Student s;
	@Factory(dataProvider="firstNameProvider")
	public TestNGFactory2(Student t) {
		this.s=t;
	 }
     
	@Test
	public void firstName()
	{
	/*проверяем, что наши геттеры возвращают не нулевые значения*/		
	Assert.assertNotNull(s.getFirstName());
	Assert.assertNotNull(s.getLastName());
	Assert.assertNotNull(s.getFullName());
	Assert.assertNotNull(s.getAge());
		
	}
}