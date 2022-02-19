/*Тест NG.
 * * Практическое задание 6. Фабрики тестов в TestNG
 * Проверяем , что возвращают геттеры
 * Создадим фабрику. Фабрика и конструктор создаются отдельно.*/
package online_tusur.unit_online_tusur;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestNGFactory {
//будем использовать фабричный метод	
@Factory public Object[] TestFactory()
 { return new Object[] {new FirstNameTest()	};
 
 
 }}
	
//создаём класс, где будем прописывать тесты	
class FirstNameTest	{
	
	@DataProvider(name="firstNameProvider")
	public Object[][] firstNameProvider()
	{
		return new Object[][] {
			{"Ivanov","Alex", 18,new Student("Alex","Ivanov",10)},
			{"Petrov","Piter", 35,new Student("Piter","Petrov",35)},
			{"Silvian","Roza Flora Luna", 18,new Student("Roza Flora Luna", "Silvian", 17)},
			{"Ivanov","Ivan", 18,new Student("ivan", "ivanov", 18)},
			{"Saltykov-Shedrin","Mike", 50,new Student("Mike", "Saltykov-Shedrin", 50)},
			{"Sil de Royz","Anna-Maria", 18,new Student("Anna-Maria", "Sil de Royz", 51)}
		};
	}
/*нащи данные будем передавать конструктору*/
	
@Test(dataProvider="firstNameProvider")
	public void firstName(String surname,String name,int age, Student t )
	{	
	Assert.assertEquals(name, t.getFirstName());

	}
@Test(dataProvider="firstNameProvider")
public void SecondName(String surname,String name,int age, Student t )
{
Assert.assertEquals(surname, t.getLastName());
	
}
@Test(dataProvider="firstNameProvider")
public void age_student(String surname,String name,int age, Student t )
{	
Assert.assertEquals(age, t.getAge());

}

}