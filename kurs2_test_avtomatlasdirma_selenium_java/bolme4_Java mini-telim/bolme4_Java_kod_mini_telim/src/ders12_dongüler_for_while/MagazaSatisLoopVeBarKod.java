package ders12_dongüler_for_while;

import java.util.Scanner;

public class MagazaSatisLoopVeBarKod {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Məhsul qiymətləri və barkodlar
        double almaKGQiymət = 1.20;
        double xiyarKGQiymət = 2.30;
        double pendirQiymət = 4.50;
        double qatıqQiymət = 2.50;

        // Ümumi qiyməti sifirla
        double ümumiQiymət = 0;

        System.out.println("-----------------------\nMağazaya xoş gəlmisiniz! Məhsul kodunu daxil edin. " +
                "Tamamlamaq üçün '0' daxil edin.");

        while (true) {
            System.out.println("Məhsuların barkodları: ");
            System.out.println("    101: Alma (KG)");
            System.out.println("    102: Xiyar (KG)");
            System.out.println("    103: Pendir (qutu ile)");
            System.out.println("    104: Qatıq (qutu ile)");
            
            System.out.print("Məhsulun barkodunu daxil edin: ");
            int barkod = scanner.nextInt();

            if (barkod == 0) {
                break; //İstifadəçi 0 daxil olduqda dövrəni bitir
            }

            if (barkod < 101 || 104 < barkod)   {
                // Yanlış barkod; yenidən giriş tələb edin
                System.out.println("❌ Yanlış barkod! Yenidən cəhd edin.");
                continue;
            }

            System.out.print("Miqdarı daxil edin: ");
            int miqdar = scanner.nextInt();

            // Barkoda əsasən məhsulu müəyyənləşdirin və cəmi yenile
            if (barkod == 101) {
                ümumiQiymət += almaKGQiymət * miqdar;
                System.out.printf("Alma KG əlavə edildi: %d x %.2f = %.2f AZN\n",
                        miqdar, almaKGQiymət, almaKGQiymət * miqdar);

            } else if (barkod == 102) {
                ümumiQiymət += xiyarKGQiymət * miqdar;
                System.out.printf("Xiyar KG əlavə edildi: %d x %.2f = %.2f AZN\n",
                        miqdar, xiyarKGQiymət, xiyarKGQiymət * miqdar);

            } else if (barkod == 103) {
                ümumiQiymət += pendirQiymət * miqdar;
                System.out.printf("Pendir əlavə edildi: %d x %.2f = %.2f AZN\n",
                        miqdar, pendirQiymət, pendirQiymət * miqdar);

            } else if (barkod == 104) {
                ümumiQiymət += qatıqQiymət * miqdar;
                System.out.printf("Qatıq əlavə edildi: %d x %.2f = %.2f AZN\n",
                        miqdar, qatıqQiymət, qatıqQiymət * miqdar);
            }

        } //  while'in bitisi (end of while)

        // ƏDV tətbiq et və yekun məbləği hesabla
        double ƏDV = ümumiQiymət * 0.2;
        double ümumiQiymətƏDV = ümumiQiymət + ƏDV;

        // Ətraflı qəbz çıxışı
        System.out.println("\n--- Qəbz ---");
        System.out.printf("Cəmi (ƏDV-siz): %.2f AZN\n", ümumiQiymət);
        System.out.printf("ƏDV (20%%): %.2f AZN\n", ƏDV);
        System.out.printf("Cəmi (ƏDV daxil olmaqla): %.2f AZN\n", ümumiQiymətƏDV);
        System.out.println("--- Qəbz Sonu ---");

        scanner.close();
    } // end of func
} // end of class
