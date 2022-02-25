/*Тест NG.
 * Практическое задание 6. Фабрики тестов в TestNG
 * проверяем, что правильность нахождения: средний возраст, максимальный и минимальный возраст.
  * Создадим фабрику. Фабрика и конструктор создаются отдельно.*/
package online_tusur.unit_online_tusur;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestNGFactory3 {
//будем использовать фабричный метод	
@Factory public Object[] TestFactory()
 { return new Object[] {new MyTest()	};
 
 
 }}
	
//создаём класс, где будем прописывать тесты	
class MyTest	{
	
	private Student[] studenties;
	private int minimum;
	private int maximum;

	@DataProvider(name="MyTestProvider")
	public Object[][] MyTestProvider()
	{
		return new Object[][] {
			{new Student("Sergey", "Nasedkin", 0), new Student("Ivan", "Nesterov", 1), new Student("polina", "tukina", 10)},
			{new Student("ivan", "Silvian", 17), new Student("IvaN", "Nesterov-Shepkin", 18), new Student("Gleba", "Petrova", 25)},
			{new Student("maksim", "Petrov", 35), new Student("ivAn", "nestErov", 50), new Student("roza", "rozova", 51)},
			{new Student("mike", "Saltykov-Shedrin", 99), new Student("ivan de ivan", "Pupkin", 98), new Student("Roza Flora Luna", "Lopez", 100)},
			{new Student("Anna-Maria", "Sil de Royz", 25), new Student("Ivan-Vandam", "sterov", 35), new Student("pasha", "Petrov", 45)},
			{new Student("sacha", "ivanov", -99), new Student("anna", "Nesterova", 0), new Student("Gleb", "Petrov", 99)}
		};
	}

	
@Test(dataProvider="MyTestProvider")
	public void students(Student s1, Student s2, Student s3 )
	{	
	studenties = new Student[] { s1,s2,s3};
	int ag1=s1.getAge();
	int ag2=s2.getAge();
	int ag3=s3.getAge();
	Assert.assertEquals((ag1+ag2+ag3)/3, Student.avgAge(studenties));
    minimum = ag1;
    maximum = ag1;
    if(minimum>ag2) minimum=ag2;
    if(minimum>ag3) minimum=ag3;
    if (maximum<ag2) maximum=ag2;
    if (maximum<ag3) maximum=ag3;
    Assert.assertEquals(minimum, Student.minAge(studenties));
    Assert.assertEquals(maximum, Student.maxAge(studenties));
        
	}

}