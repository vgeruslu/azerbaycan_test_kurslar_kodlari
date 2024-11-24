package ders14_test_funksiyalar;

public class kalkulyator_ve_testleri {

    // Çıxma funksiyası
    public static int çıx(int a, int b) {
        return a - b;
    }

    // Vurma funksiyası
    public static int vur(int a, int b) {
        return a * b;
    }

    // Bölmə funksiyası
    public static double böl(int a, int b) {
        if (b == 0) {
            System.out.println("Sıfıra bölmə mümkün deyil!");
            return 0; // Bölmə səhvini idarə edir
        }
        return (double) a / b;
    }

/*
    public static void YoxlaBərabərOlduqlarını
            (String test_hal_adı, String gözlənən_dəyər, String gələn_dəyər) {
        if (gözlənən_dəyər.equals(gələn_dəyər))
            System.out.println("Test hal keçdi: " + test_hal_adı);
        else
            System.out.println("Test hal UĞURSUZ oldu: " + test_hal_adı +
                    " | gözlənən_dəyər = " + gözlənən_dəyər +
                    " | faktiki_gələn_dəyər = " + gələn_dəyər);
    }

    public static void YoxlaBərabərOlduqlarını
            (String test_hal_adı, int gözlənən_dəyər, int gələn_dəyər) {
        if (gözlənən_dəyər == gələn_dəyər)
            System.out.println("Test-hal keçdi: " + test_hal_adı);
        else
            System.out.println("Test-hal UĞURSUZ oldu: " + test_hal_adı +
                    " | gözlənən_dəyər = " + gözlənən_dəyər +
                    " | faktiki_gələn_dəyər = " + gələn_dəyər);
    }
*/

    // Toplama funksiyası
    public static int topla(int a, int b) {
        return a + b;
    }

    public static void topla_testləri() {
        SadeTestKitabxana.YoxlaBərabərOlduqlarını("testTopla-TC1", 5, topla(2, 3));
        SadeTestKitabxana.YoxlaBərabərOlduqlarını("testTopla-TC2", 1503, topla(500, 1003));
        SadeTestKitabxana.YoxlaBərabərOlduqlarını("testTopla-TC3", 222, topla(222, 0));
        SadeTestKitabxana.YoxlaBərabərOlduqlarını("testTopla-TC4", -35, topla(0, -35));
    }

    public static void main(String[] args) {
        topla_testləri();
    }
}

