package tests;

import controller.İstifadəçiNəzarətçisi;
import model.İstifadəçi;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IstifadeçiTest {
    İstifadəçi testİstifadəçi;

    // test data
    String test_ad = "Eldar";
    String test_soyad = "Miyanalı";
    String test_epoçt = "eldar@gmail.com";
    String test_şifrə = "şifrə";
    String test_mobil_nömrə = "00447771234567";

    @Before
    public void setUp() throws Exception {
        testİstifadəçi = new İstifadəçi(test_epoçt, test_şifrə, test_ad,
                test_soyad, test_mobil_nömrə);
    }

    @After
    public void tearDown() throws Exception {
        İstifadəçiNəzarətçisi.buEpoçtİləİstifadəçiniSil(test_epoçt);
    }


    // get TESTler
    @Test
    public void testGetEpoçt() {
        assertEquals(testİstifadəçi.getEpoçt(), test_epoçt);
    }

    @Test
    public void testGetŞifrə() {
        assertEquals( testİstifadəçi.getŞifrə(), test_şifrə);
    }

    @Test
    public void testGetAd() {
        assertEquals(testİstifadəçi.getAd(), test_ad);
    }

    @Test
    public void testGetSoyad() {
        assertEquals(testİstifadəçi.getSoyad(), test_soyad);
    }

    @Test
    public void testGetMobilNömrə() {
        assertEquals(testİstifadəçi.getMobilNömrə(), test_mobil_nömrə);
    }

    //@Test
    public void testSetEpoçt() {
        testİstifadəçi.setEpoçt("test@gmail.com");
        assertEquals(testİstifadəçi.getEpoçt(), "test@gmail.com");
        testİstifadəçi.setEpoçt(test_epoçt);
    }

    @Test
    public void testKonstruktorDublikatEpoçt() { // konstruktor constructor
        try {
            İstifadəçi dublikatİstifadəçi = new İstifadəçi(test_epoçt, test_şifrə, test_ad,
                    test_soyad, test_mobil_nömrə);

            fail("Dublikat istifadəçi ilə Konstruktor, Exception (İstisna) döndərməli idi");
        } catch (Exception e) {
            // pass !
            //System.out.println("PASS oldu");
        }
    }
}