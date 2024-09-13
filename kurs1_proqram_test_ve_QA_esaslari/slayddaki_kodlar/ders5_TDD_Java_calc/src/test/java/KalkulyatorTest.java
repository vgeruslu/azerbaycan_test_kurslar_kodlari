import org.example.Kalkulyator;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class KalkulyatorTest {

    @Test
    public void İkiMüsbətNömrəƏlavəEtməlidir() {
        // itShouldAddTwoPositiveNumbers

        // setup (arrange)= Quraşdırma Hazırlamaq
        int gözlənilənDəyər = 8; // 5+3 = 8 -- expected value
        Kalkulyator testOlanKalkulyatorObyekti = new Kalkulyator();
        // calculatorUnderTest

        // exercise (act)= Testi keçirt / icra et
        int cəm = testOlanKalkulyatorObyekti.əlaveEt(5, 3);

        // verify (assert)= Yoxlama
        assertEquals(gözlənilənDəyər, cəm);
    }
}