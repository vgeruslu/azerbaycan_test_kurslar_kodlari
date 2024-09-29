package tests;

import model.İstifadəçi;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IstifadeçiTest {
    İstifadəçi testİstifadəçi;

    // test data
    String test_istifadəçi_adı = "Eldar Miyanali";
    String test_şifrə = "şifrə";
    String test_ad = "Mikayıl";
    String test_soyad = "Səmədov";
    String test_mobil_nömrə = "07771234567";

    @Before
    public void setUp() throws Exception {
        testİstifadəçi = new İstifadəçi(test_istifadəçi_adı, test_şifrə, test_ad,
                test_soyad, test_mobil_nömrə);
    }
    @Test
    public void getİstifadəçiAdı() {
        assertEquals("getİstifadəçiAdı()-da xəta var",
                testİstifadəçi.getİstifadəçiAdı(), test_istifadəçi_adı);
    }
}