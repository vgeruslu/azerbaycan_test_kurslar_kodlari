package tests;

import org.junit.Test;
import src.Riyaziyyat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class RiyaziyyatTest {


    @Test
    public void testÜstegel() {
        int nəticə = Riyaziyyat.Üstegel(4, 6);
        assertEquals(nəticə, 10);
    }

    @Test
    public void testVur() {
        int nəticə = Riyaziyyat.Vur(4, 6);
        assertEquals(nəticə, 24);
    }

    @Test
    public void testMinus() {
        int nəticə = Riyaziyyat.Minus(4, 6);
        assertEquals(nəticə, -2);
    }

    @Test
    public void testKvadratTənlikİkiKök() { // QuadraticEquation
        try {
            double [] nəticə = src.Riyaziyyat.QuadraticEquation(1, -2, -3);
            assertEquals(3.0, nəticə[0], 0.0000001);
            assertEquals(-1.0, nəticə[1],  0.0000001);
        } catch (Exception e) {
            fail("Kod bura gəlməməli ...");
        }
    }

    @Test
    public void testKvadratTənlikBirKök() { // QuadraticEquation
        try {
            double [] nəticə = src.Riyaziyyat.QuadraticEquation(4, -12, 9);
            assertEquals(1, nəticə.length);
            assertEquals(1.5, nəticə[0], 0.0000001);
        } catch (Exception e) {
            fail("Kod bura gəlməməli ...");
        }
    }
    /*
    @Test
    public void testKvadratTənlikHeçHəqiqiƏdədKök() {
        try {
            double [] nəticə = src.Riyaziyyat.QuadraticEquation(4, 1, 9);
            fail("Heç həqiqi-ədəd kök olmaması üçün, kod Exception verməməli idi, və bura gəlməməli idi...");
        } catch (Exception e) {
            // Uğurlu ... ! PASS !
        }
    }
     */
}