package tests;

import model.İstifadəçi;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IstifadeçiTest {
    İstifadəçi testİstifadəçi;

    // test data
    String test_ad = "Eldar";
    String test_soyad = "Miyanalı";
    String test_epoçt = "eldar@gmail.com";
    String test_şifrə = "şifrə";
    String test_mobil_nömrə = "07771234567";

    @Before
    public void setUp() throws Exception {
        testİstifadəçi = new İstifadəçi(test_epoçt, test_şifrə, test_ad,
                test_soyad, test_mobil_nömrə);
    }
    // get TESTler
    @Test
    public void getEpoçt() {
        assertEquals("Xəta var",
                testİstifadəçi.getEpoçt(), test_epoçt);
    }

    @Test
    public void getŞifrə() {
        assertEquals("Xəta var",
                testİstifadəçi.getŞifrə(), test_şifrə);
    }

    @Test
    public void getAd() {
        assertEquals("Xəta var",
                testİstifadəçi.getAd(), test_ad);
    }

    @Test
    public void getSoyad() {
        assertEquals("Xəta var",
                testİstifadəçi.getSoyad(), test_soyad);
    }

    @Test
    public void getMobilNömrə() {
        assertEquals("Xəta var",
                testİstifadəçi.getMobilNömrə(), test_mobil_nömrə);
    }

    @Test
    public void setEpoçt() {
        testİstifadəçi.setEpoçt("test@gmail.com");
        assertEquals("Xəta var",
                testİstifadəçi.getEpoçt(), "test@gmail.com");
    }
}