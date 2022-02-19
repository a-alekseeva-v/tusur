//пример2 тест NG
//параметры берутся из провайдера
/*@DataProvider позволяет запускать одни и те же тестовые методы множество раз с разными наборами данных.*/
package online_tusur.unit_online_tusur;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class NewTestNGdata {
	private int k;
	//контсруктор тестового класса помечен аннотацией фабрика
	@Factory(dataProvider="dataMethod")
	public NewTestNGdata(int param) 
    {  this.k=param; }
	//аннотация фабрика использует data провайдер, то есть данные из метода dataMethod
	@DataProvider
	public static Object[][] dataMethod () {
		
	return new Object[][] {{0},{1}};
				}
	 @Test
	  public void SimpleTest1() {
		  System.out.println("test1 method"+(k+1));
		  
	  }
	  
	  @Test
	  public void SimpleTest2() {
		  System.out.println("test2 method"+(k+2));
	  }
	}	
	
	
	
	
