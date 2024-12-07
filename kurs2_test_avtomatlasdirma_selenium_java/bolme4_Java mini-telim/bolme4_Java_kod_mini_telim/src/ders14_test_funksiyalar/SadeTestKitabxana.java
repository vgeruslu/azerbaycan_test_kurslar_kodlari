package ders14_test_funksiyalar;

public class SadeTestKitabxana {
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

    public static void YoxlaBərabərOlduqlarını
            (String test_hal_adı, double gözlənən_dəyər, double gələn_dəyər) {
        if (gözlənən_dəyər == gələn_dəyər)
            System.out.println("Test-hal keçdi: " + test_hal_adı);
        else
            System.out.println("Test-hal UĞURSUZ oldu: " + test_hal_adı +
                    " | gözlənən_dəyər = " + gözlənən_dəyər +
                    " | faktiki_gələn_dəyər = " + gələn_dəyər);
    }
}
