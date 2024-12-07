package ders14_test_funksiyalar;

public class test_metn_cevirme {

    public static String böyükHərflərəÇevir(String mətn) {
        return mətn.toUpperCase();
    }

    public static void testBöyükHərflərəÇevir_TC1_normal_mətn() {
        SadeTestKitabxana.YoxlaBərabərOlduqlarını("testBöyükHərflərəÇevir_TC1_normal_mətn",
                "JAVA DILINI SEVIRƏM",
                böyükHərflərəÇevir("Java dilini sevirəm"));
    }

    public static void testBöyükHərflərəÇevir_TC2_bütov_kicik_hərflər() {
        SadeTestKitabxana.YoxlaBərabərOlduqlarını(
                "testBöyükHərflərəÇevir_TC2_bütov_kicik_hərflər",
                "BURASI BAKI",
                böyükHərflərəÇevir("burasi baki"));
    }

    public static void testBöyükHərflərəÇevir_TC3_bütov_boyuk_hərflər() {
        SadeTestKitabxana.YoxlaBərabərOlduqlarını(
                "testBöyükHərflərəÇevir_TC3_bütov_boyuk_hərflər",
                "JAVA DİLİNİ SEVİRƏM",
                böyükHərflərəÇevir("JAVA DİLİNİ SEVİRƏM"));
    }

    public static void testBöyükHərflərəÇevir_TC4_bos_metn() {
        SadeTestKitabxana.YoxlaBərabərOlduqlarını(
                "testBöyükHərflərəÇevir_TC4_bos_metn",
                "",
                böyükHərflərəÇevir(""));
    }

    public static void testBöyükHərflərəÇevir_TC5_herfleri_olmayan_metn() {
        SadeTestKitabxana.YoxlaBərabərOlduqlarını(
                "testBöyükHərflərəÇevir_TC5_herfleri_olmayan_metn",
                "...+-$",
                böyükHərflərəÇevir("...+-$"));
    }
    /*public static String kiçikHərflərəÇevir(String mətn) {
        return mətn.toUpperCase();
    }*/

    /*public static String tərsəÇevir(String mətn) {
        return new StringBuilder(mətn).reverse().toString();
    }*/

    public static void main(String[] args) {
        System.out.println("-------------------" );


        testBöyükHərflərəÇevir_TC1_normal_mətn();
        testBöyükHərflərəÇevir_TC2_bütov_kicik_hərflər();
        testBöyükHərflərəÇevir_TC3_bütov_boyuk_hərflər();
        testBöyükHərflərəÇevir_TC4_bos_metn();
        testBöyükHərflərəÇevir_TC5_herfleri_olmayan_metn();
    }

}
