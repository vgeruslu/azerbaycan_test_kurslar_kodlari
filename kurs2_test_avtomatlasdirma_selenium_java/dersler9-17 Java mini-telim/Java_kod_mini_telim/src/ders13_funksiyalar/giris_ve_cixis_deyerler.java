package ders13_funksiyalar;

public class giris_ve_cixis_deyerler {

    //public class MənaDoluFunksiyalar {

        public static void main(String[] args) {
            // 1. Girişsiz və çıxışsız funksiya çağırışı
            heçNəEt();

            // 2. Bir girişli və çıxışsız funksiya çağırışı
            salamla("Leyla");

            // 3. Üç girişli və bir çıxışlı funksiya çağırışı
            int ənBöyük = ənBöyüyüTap(12, 45, 32);
            System.out.println("Ən böyük ədəd: " + ənBöyük);

            // 4. Çıxışı int olan funksiya çağırışı
            int təsadüfiRəqəm = təsadüfiRəqəmYarat();
            System.out.println("Təsadüfi rəqəm: " + təsadüfiRəqəm);

            // 5. Çıxışı String olan funksiya çağırışı
            String günSalamı = günəSalam();
            System.out.println(günSalamı);
        }

        // 1. Girişsiz və çıxışsız funksiya
        public static void heçNəEt() {
            System.out.println("Bu funksiya heç nə etmir.");
        }

        public static void testHeçNəEt() {
            System.out.println("Bu funksiya heç nə etmir.");
        }

        // 2. Bir girişli və çıxışsız funksiya
        public static void salamla(String ad) {
            System.out.println("Salam, " + ad + "!");
        }

        // 3. Üç girişli və bir int çıxışlı funksiya - üç ədəddən ən böyüyünü tapır
        public static int ənBöyüyüTap(int a, int b, int c) {
            int ənBöyük = a;
            if (b > ənBöyük) {
                ənBöyük = b;
            }
            if (c > ənBöyük) {
                ənBöyük = c;
            }
            return ənBöyük;
        }

        // 4. Çıxışı int olan funksiya - təsadüfi rəqəm yaradır
        public static int təsadüfiRəqəmYarat() {
            return (int) (Math.random() * 100); // 0 ilə 99 arasında təsadüfi rəqəm
        }

        // 5. Çıxışı String olan funksiya - sabah salamlama mətni qaytarır
        public static String günəSalam() {
            return "Sabahınız xeyir!";
        }

}
