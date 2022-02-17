package online_tusur.unit_online_tusur;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGparamZadanie5 {
 
	
	//параметры передаём через конфигурационный файл
	/*в этом тесте каждому возрасту должно возвращаться 18, поэтому среднее значение  должно быть 18*/
	 
	  @Test
	  @Parameters({"ag1","ag2","ag3"})
	  public void paramsAge(@Optional("0")int ag1,@Optional("0")int ag2,@Optional("0")int ag3) {
		  Student s1 = new Student();
		  Student s2 = new Student();
		  Student s3 = new Student();
		   s1.setAge(ag1);
		   s2.setAge(ag2);
		   s3.setAge(ag3);
		   Student[] students = { s1,s2,s3};
		   int agsr=Student.avgAge(students);
		   assertEquals( 18 , agsr);
		     }
	
	  //параметры передаём через провайдер
	  @DataProvider(name="Mydata")
		public static Object[][] getData()
		{
		return new Object[][] {
			{"petr","Petr","petrov-vodkin","Petrov-Vodkin",18},
			{"ivan","Ivan","ivanov","Ivanov",10},
			{"sidor","Sidor","sidorov","Sidorov",50}	,};
		}
	  @Test(dataProvider="Mydata")
		void testNames (String firstname,String ExpectedName,String secondname,String ExpectedSurname,int age)
		{ 
		  Student s=new Student();
		  s.setFirstName(firstname);
		  s.setLastName(secondname);
		  s.setAge(age);
		  String actual_name=s.getFirstName();
		  String actual_surname=s.getLastName();
		  int actual_age=s.getAge();
			assertEquals(ExpectedName,actual_name);
			assertEquals(ExpectedSurname,actual_surname);
			assertEquals(18,actual_age);
	  
		}
	
	
}
