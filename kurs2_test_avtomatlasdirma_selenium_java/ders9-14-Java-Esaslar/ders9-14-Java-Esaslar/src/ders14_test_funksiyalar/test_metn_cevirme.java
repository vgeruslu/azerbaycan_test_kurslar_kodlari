package ders14_test_funksiyalar;

public class test_metn_cevirme {

    public static String böyükHərflərəÇevir(String mətn) {
        return mətn.toUpperCase();
    }

    public static void YoxlaBərabərOlduqlarını
            (String test_hal_adı, String gözlənən_dəyər, String gələn_dəyər) {
        if (gözlənən_dəyər.equals(gələn_dəyər))
            System.out.println("Test hal keçdi: " + test_hal_adı);
        else
            System.out.println("Test hal UĞURSUZ oldu: " + test_hal_adı +
                    " | gözlənən_dəyər = " + gözlənən_dəyər +
                    " | gələn_dəyər = " + gələn_dəyər);
    }

    public static void testBöyükHərflərəÇevir_TC1_normal_mətn() {
        YoxlaBərabərOlduqlarını("testBöyükHərflərəÇevir_TC1_normal_mətn",
                "JAVA DILINI SEVIRƏM",
                böyükHərflərəÇevir("Java dilini sevirəm"));
    }

    // public static String testBöyükHərflərəÇevir_TC1_boş_mətn()
    public static void testBöyükHərflərəÇevir_TC2_bütov_boyuk_hərflər() {
        YoxlaBərabərOlduqlarını("testBöyükHərflərəÇevir_TC2_bütov_boyuk_hərflər",
                "JAVA DİLİNİ SEVİRƏM",
                böyükHərflərəÇevir("JAVA DİLİNİ SEVİRƏM"));
    }
    /*public static String kiçikHərflərəÇevir(String mətn) {
        return mətn.toUpperCase();
    }*/

    /*public static String tərsəÇevir(String mətn) {
        return new StringBuilder(mətn).reverse().toString();
    }*/

    public static void main(String[] args) {
        String mətn = "Salam Dünya";
        String böyükMətn = böyükHərflərəÇevir(mətn);
        System.out.println("Böyük hərflərlə mətn: " + böyükMətn);
        //System.out.println("Tərs mətn: " + tərsəÇevir(mətn));

        //System.out.println("Böyük hərflərlə mətn: " +
                //böyükHərflərəÇevir("Java dilini sevirəm"));

        // avtomatlaşdırılmış testlər
        testBöyükHərflərəÇevir_TC1_normal_mətn();
        testBöyükHərflərəÇevir_TC2_bütov_boyuk_hərflər();
    }

}
