//пример1
/*TestNG также поддерживает динамические тесты, которые можно создавать с помощью аннотации @Factory*/
package online_tusur.unit_online_tusur;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

class NewTestMethod {
	private int k;
	public NewTestMethod (int param) {
		 
		  this.k=param;
	  }
	
  @Test
  public void SimpleTest1() {
	  System.out.println("Simple test1 method"+(k+1));
	  
  }
  
  @Test
  public void SimpleTest2() {
	  System.out.println("Simple test2 method"+(k+2));
  }
}
//фабричный метод возвращает массив объектов
//тест выполнится 2 раза
public class NewTestNGFactory {
	@Factory public Object[] FactoryMethod () {
		
	return new Object[]
			{new NewTestMethod(0),new NewTestMethod(1)};
				}
		
}