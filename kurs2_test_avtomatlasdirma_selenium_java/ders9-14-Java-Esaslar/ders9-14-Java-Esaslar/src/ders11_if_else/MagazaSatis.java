package ders11_if_else;

// MagazaSatis

import java.util.Scanner;

public class MagazaSatis {

    public static void main(String[] args) {
        // Məhsulların qiymətləri
        double almaQiymət = 1.5;
        double bananQiymət = 2.0;
        double kartofQiymət = 0.8;

        // İstifadəçidən məhsul miqdarı məlumatları almaq
        Scanner scanner = new Scanner(System.in);

        System.out.print("Almanın miqdarını daxil edin: ");
        int almaMiqdar = scanner.nextInt();

        System.out.print("Bananın miqdarını daxil edin: ");
        int bananMiqdar = scanner.nextInt();

        System.out.print("Kartofun miqdarını daxil edin: ");
        int kartofMiqdar = scanner.nextInt();

        // Məhsullar üzrə ümumi qiymətləri hesabla
        double almaÜmumi = almaQiymət * almaMiqdar;
        double bananÜmumi = bananQiymət * bananMiqdar;
        double kartofÜmumi = kartofQiymət * kartofMiqdar;

        // Ümumi qiyməti hesabla
        double ümumiCəmi = almaÜmumi + bananÜmumi + kartofÜmumi;

        // ƏDV
        double ƏDV = ümumiCəmi * 0.2;

        // 20% ƏDV əlavə et
        double ümumiQiymətƏDVİlə = ümumiCəmi * 1.2;
        double yekunCəmi = ümumiQiymətƏDVİlə;

        // Endirim tətbiq et
        double endirimMəbləği = 0.0;
        if (ümumiQiymətƏDVİlə > 50) {
            endirimMəbləği =  ümumiQiymətƏDVİlə * 0.1;
            yekunCəmi = ümumiQiymətƏDVİlə * 0.9; // 10% endirim
            System.out.println("50 AZN-dən çox alış-veriş etdiyiniz üçün, 10% endirim tətbiq edildi.");
        } else {
            System.out.println("Endirim tətbiq edilmədi.");
        }
        
        // Ətraflı çıxışı göstər
        System.out.println("\n--- Qəbz ---");
        System.out.printf("Alma: %d x %.2f = %.2f AZN\n", almaMiqdar, almaQiymət, almaÜmumi);
        System.out.printf("Banan: %d x %.2f = %.2f AZN\n", bananMiqdar, bananQiymət, bananÜmumi);
        System.out.printf("Kartof: %d x %.2f = %.2f AZN\n", kartofMiqdar, kartofQiymət, kartofÜmumi);
        System.out.println("-------------------------");
        System.out.printf("Ümumi cəm (ƏDV-siz): %.2f AZN\n", ümumiCəmi);
        System.out.printf("ƏDV: %.2f AZN\n", ƏDV);

        System.out.printf("Endirim məbləği: %.2f AZN\n", endirimMəbləği);
        System.out.printf("Yekun cəmi (ƏDV və endirim daxil): %.2f AZN\n", yekunCəmi);
        System.out.println("--- Qəbz Sonu ---");

        // Scanner-ı bağla
        scanner.close();
    }
}

