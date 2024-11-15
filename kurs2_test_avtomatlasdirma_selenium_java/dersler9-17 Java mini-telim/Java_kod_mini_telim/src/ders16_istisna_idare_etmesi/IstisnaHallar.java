package ders16_istisna_idare_etmesi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IstisnaHallar {

    public static void main(String[] args) {

        SıfıraBölməNümunəsi();
        RəqəmFormatıNümunəsi();
        FaylOxumaNümunəsi();
        MassivİndeksNümunəsi();
        BirdənÇoxİstisnaNümunəsi();
        NullPointerNümunəsi ();
    }

    public static void SıfıraBölməNümunəsi() {
        System.out.println("------------------\n" +
                "Sıfıra bölmə nümunəsi: ");

        try {
            int rəqəm1 = 10;
            int rəqəm2 = 0;
            int nəticə = rəqəm1 / rəqəm2; // Bu kod sətri istisna hal atacaq
            System.out.println("Nəticə: " + nəticə);
        } catch (ArithmeticException e) {
            System.out.println("Xəta: Sıfıra bölmə mümkün deyil.");
        }
    }
    //--------------------------------------------------------------
    public static void RəqəmFormatıNümunəsi () {
        System.out.println("------------------\n" +
                "Rəqəm Formatı nümunəsi: ");

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Bir tam ədəd daxil edin: ");
            String istifadəçiGirişi = scanner.nextLine();
            int rəqəm = Integer.parseInt(istifadəçiGirişi); // Xəta atacaqsa, bu sətirdədir
            System.out.println("Daxil etdiyiniz ədəd: " + rəqəm);
        } catch (NumberFormatException e) {
            System.out.println("Xəta: Düzgün formatda rəqəm daxil etmədiniz.");
        }
    }
    //--------------------------------------------------------------
    public static void FaylOxumaNümunəsi () {
        System.out.println("------------------\n" +
                "Fayl Oxuma nümunəsi: ");

        try {
            File fayl = new File("mövcud_olmayan_fayl.txt");
            Scanner faylOxuyucu = new Scanner(fayl);
            while (faylOxuyucu.hasNextLine()) {
                System.out.println(faylOxuyucu.nextLine());
            }
            faylOxuyucu.close();
        } catch (FileNotFoundException e) {
            System.out.println("Xəta: Fayl tapılmadı. " +
                    "Zəhmət olmasa düzgün fayl adı daxil edin.");
        }
    }
    //--------------------------------------------------------------
    public static void MassivİndeksNümunəsi () {
        System.out.println("------------------\n" +
                "Massiv (array) indeks nümunəsi: "); // Array Index Example

        int[] massiv = {1, 2, 3, 4, 5};
        try {
            System.out.println("Massivin 10-cu elementi: " + massiv[10]); // Xəta burda baş verir
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Xəta: Massivin göstərilən indeksi mövcud deyil.");
        }
    }
    //--------------------------------------------------------------
    public static void BirdənÇoxİstisnaNümunəsi () {
        System.out.println("------------------\n" +
                "Birdən çox istisna nümunəsi: ");

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Bir fayl adı daxil edin: ");
            String faylAdi = scanner.nextLine();

            File fayl = new File(faylAdi);
            Scanner faylOxuyucu = new Scanner(fayl);
            while (faylOxuyucu.hasNextLine()) {
                System.out.println(faylOxuyucu.nextLine());
            }
            faylOxuyucu.close();
        } catch (FileNotFoundException e) {
            System.out.println("Xəta: Fayl tapılmadı.");
        } catch (Exception e) {
            System.out.println("Xəta: Gözlənilməyən bir problem baş verdi: " + e.getMessage());
        }
    }
    //--------------------------------------------------------------
    public static void NullPointerNümunəsi () {
        System.out.println("------------------\n" +
                "Sıfıra bölmə nümunəsi: ");

        String mətn = null;
        try {
            System.out.println("Mətn uzunluğu: " + mətn.length()); // Xəta atacaq
        } catch (NullPointerException e) {
            System.out.println("Xəta: Mətn null olduğu üçün uzunluğu yoxlanıla bilməz.");
        }
    }

} // class
