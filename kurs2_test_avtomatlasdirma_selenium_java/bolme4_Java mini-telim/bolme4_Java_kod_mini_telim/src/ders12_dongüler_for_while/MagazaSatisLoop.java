package ders12_dongüler_for_while;

import java.util.Scanner;

public class MagazaSatisLoop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Product prices and barcodes
        double süd1LQiymət = 1.2;
        double süd2LQiymət = 2.3;
        double pendirQiymət = 4.5;
        double qatıqQiymət = 1.5;

        // Initialize the total price
        double ümumiQiymət = 0;

        System.out.println("Mağazaya xoş gəlmisiniz! Məhsul kodunu daxil edin. Tamamlamaq üçün '0' daxil edin.");

        while (true) {
            System.out.print("Məhsulun barkodunu daxil edin (101..104): ");
            int barkod = scanner.nextInt();

            if (barkod == 0) {
                break; // End the loop when user enters 0
            }

            System.out.print("Miqdarı daxil edin: ");
            int miqdar = scanner.nextInt();

            // Determine the product based on barcode and calculate the total
            if (barkod == 101) {
                ümumiQiymət += süd1LQiymət * miqdar;
                System.out.printf("Süd 1L əlavə edildi: %d x %.2f = %.2f AZN\n", miqdar, süd1LQiymət, süd1LQiymət * miqdar);

            } else if (barkod == 102) {
                ümumiQiymət += süd2LQiymət * miqdar;
                System.out.printf("Süd 2L əlavə edildi: %d x %.2f = %.2f AZN\n", miqdar, süd2LQiymət, süd2LQiymət * miqdar);

            } else if (barkod == 103) {
                ümumiQiymət += pendirQiymət * miqdar;
                System.out.printf("Pendir əlavə edildi: %d x %.2f = %.2f AZN\n", miqdar, pendirQiymət, pendirQiymət * miqdar);

            } else if (barkod == 104) {
                ümumiQiymət += qatıqQiymət * miqdar;
                System.out.printf("Qatıq əlavə edildi: %d x %.2f = %.2f AZN\n", miqdar, qatıqQiymət, qatıqQiymət * miqdar);

            } else {
                System.out.println("Yanlış barkod! Yenidən cəhd edin.");
                continue; // Invalid barcode; ask for input again
            }
        }

        // Apply VAT and calculate the final total
        double ƏDV = ümumiQiymət * 0.2;
        double ümumiQiymətƏDV = ümumiQiymət + ƏDV;

        // Detailed receipt output
        System.out.println("\n--- Qəbz ---");
        System.out.printf("Cəmi (ƏDV-siz): %.2f AZN\n", ümumiQiymət);
        System.out.printf("ƏDV: %.2f AZN\n", ƏDV);
        System.out.printf("Cəmi (ƏDV daxil olmaqla): %.2f AZN\n", ümumiQiymətƏDV);
        System.out.println("--- Qəbz Sonu ---");

        scanner.close();
    }
}
