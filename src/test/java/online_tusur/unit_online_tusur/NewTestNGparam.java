/*параметризированные тесты*/
/*тестNG позволяет пользователям передавать значения параметров тестовым методам как аргументы. 
 * Это возможно сделать с помощью аннотации @Parameters*/

package online_tusur.unit_online_tusur;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


//параметры через провайдер
public class NewTestNGparam {
	
	@DataProvider(name="data")
	public static Object[][] getData()
	{
	return new Object[][] {
		{"petr","Petr"},
		{"ivan","Ivan"},
		{"sidor","Sidor"}	,};
	}
	
	@Test(dataProvider="data")
	void testNames (String input,String ExpectedName)
	{ Student s=new Student();
	  s.setFirstName(input);
		String actual=s.getFirstName();
		assertEquals(ExpectedName,actual);
	}
	//параметры передаём через конфигурационный файл	
  @Test
  @Parameters({"a","fn","sn"})
  public void params(@Optional("0")int a,@Optional("null")String fn,@Optional("null")String sn) {
     Student p= new Student();
     p.setAge(a);
     p.setFirstName(fn);
     p.setLastName(sn);
     assertEquals("Men Piter", p.getFullName());
     
  
  
  }
}
