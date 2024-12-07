package ders13_funksiyalar;

public class giris_ve_cixis_deyerler {

    public static void main(String[] args) {
        System.out.println("-------------------" );
        // 1. Girişsiz və çıxışsız funksiya çağırışı
        girişsizÇıxışsızFunksiya();

        // 2. Bir girişli və çıxışsız funksiya çağırışı
        salamla("Leyla");

        // 3. Üç girişli və bir çıxışlı funksiya çağırışı
        int ənBöyük = ənBöyükƏdədiTap(12, 45, 32);
        System.out.println("Ən böyük ədəd: " + ənBöyük);

        // 4. Çıxışı int olan, ve girişli olmayan  funksiya çağırışı
        int təsadüfiRəqəm = təsadüfiRəqəmYarat0_100Arası();
        System.out.println("Təsadüfi rəqəm: " + təsadüfiRəqəm);

        // 5. Çıxışı String olan funksiya çağırışı
        String günSalamı = günəSalam();
        System.out.println(günSalamı);
    }// end of main()

    // 1. Girişsiz (no input) və çıxışsız (no output) funksiya
    // Girişsiz: ()
    // çıxışsız: void
    public static void girişsizÇıxışsızFunksiya() {
        System.out.println("Bu funksiya heç nə etmir, sadece bu print-i yazir.");
    }

    // 2. Bir girişli və çıxışsız funksiya
    public static void salamla(String ad) {
        System.out.println("Salam, " + ad + "!");
    }

    // 3. Üç girişli və bir int çıxışlı funksiya - üç ədəddən ən böyüyünü tapır
    public static int ənBöyükƏdədiTap(int a, int b, int c) {
        /*int ənBöyük = a; // ferq edek "a" en boyukdur
        if (b > ənBöyük) {
            ənBöyük = b;
        }
        if (c > ənBöyük) {
            ənBöyük = c;
        }
        return ənBöyük;*/

        if (a>b && a>c)
            return a;
        else if (b>a && b>c)
            return b;
        else
            return c;
    }

    // 4. Çıxışı int olan funksiya - təsadüfi rəqəm yaradır
    public static int təsadüfiRəqəmYarat0_100Arası() {
        return (int) (Math.random() * 100); // 0 ilə 99 arasında təsadüfi rəqəm
    }

    // 5. Çıxışı String olan funksiya - sabah salamlama mətni qaytarır
    public static String günəSalam() {
        return "Sabahınız xeyir!";
    }

} // end class
