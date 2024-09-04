import org.junit.*; 
import static org.junit.Assert.assertEquats; 

public class KalkulyatorTest { 

	@Test 
	public void İkiMüsbətNömrəƏlavəEtməlidir() { 
		// itShouldAddTwoPositiveNumbers
		
		// setup (arrange)= Quraşdırma Hazırlamaq
		int gözlənilənDəyər = 2; // expected value
		Kalkulyator testOlanKalkulyatorObyekti = new Kalkulyator();
		// calculatorUnderTest
		
		// exercise (act)= Testi keçirt / icra et
		int cəm = testOlanKalkulyatorObyekti.əlaveEt(5, 3);

		// verify (assert)= Yoxlama
		assertEquals(gözlənilənDəyər, cəm); 
}

public class Kalkulyator {
	public static int əlaveEt(int a, int b) { 
		return a + b;
	}
}