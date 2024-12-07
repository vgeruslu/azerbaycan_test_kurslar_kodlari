package ders11_if_else;

import java.util.Scanner;

public class MagazaSatis_dersde_yazilir {

    public static void main (String[] args) {
        // qiymetler
        double almaQiymet = 2.10;
        double bananQiymet = 2.10;
        double kartofQiymet = 2.10;

        Scanner scan = new Scanner(System.in);
        System.out.print("Alma KG miqdarini daxil et: ");
        double almaKG = scan.nextDouble();

        System.out.print("Banan KG miqdarini daxil et: ");
        double bananKG = scan.nextDouble();

        System.out.print("Kartof KG miqdarini daxil et: ");
        double kartofKG = scan.nextDouble();

        double cəm_ədv_siz = (almaQiymet * almaKG) + (bananQiymet * bananKG) + (kartofQiymet * kartofKG);
        // 1992 den men kod yaziram !!

        double ƏDV = cəm_ədv_siz * 0.2;

        double ədv_li_cəm = cəm_ədv_siz + ƏDV;

        System.out.println("\n--- Qəbz ---");
        /*
            --- Qəbz ---
            Alma:   2 x 1.50 = 3.00 AZN
            Banan:  3 x 2.00 = 6.00 AZN
            Kartof: 1 x 0.80 = 0.80 AZN
            -------------------------
            Ümumi cəm (ƏDV-siz): 9.80 AZN
            ƏDV: 1.96 AZN
            Yekun cəmi (ƏDV daxil): 11.76 AZN
            --- Qəbz Sonu ---
         */
        System.out.printf("Alma:   %.2f KG x %.2f = %.2f AZN ₼\n", almaKG, almaQiymet, almaKG *almaQiymet ); // \n: ENTER (yeni xet)
        System.out.printf("Banan:  %.2f KG x %.2f = %.2f AZN ₼\n", bananKG, bananQiymet, bananKG* bananQiymet);
        System.out.printf("Kartof: %.2f KG x %.2f = %.2f AZN ₼\n", kartofKG, kartofQiymet, kartofKG* kartofQiymet);
        System.out.println("-------------------------");
        System.out.printf("Ümumi cəm (ƏDV-siz) = %.2f AZN ₼\n", cəm_ədv_siz);
        System.out.printf("ƏDV = %.2f AZN ₼\n", ƏDV);
        System.out.printf("Ümumi cəm (ƏDV-siz): %.2f AZN\n", ədv_li_cəm);

    }
}
