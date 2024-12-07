package ders16_istisna_idare_etmesi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IstisnaHallar {

    public static void main(String[] args) {

        //SıfıraBölməIstisnaNümunəsi();
        //RəqəmFormatıIstisnaNümunəsi();
        //FaylOxumaIstisnaNümunəsi();
        //MassivArrayİndeksIstisnaNümunəsi();
        //BirdənÇoxİstisnaIstisnaNümunəsi();
        NullPointerIstisnaNümunəsi ();

    }

    public static void SıfıraBölməIstisnaNümunəsi() {
        System.out.println("------------------\n" +
                "Sıfıra bölmə nümunəsi: ");

        try {
            int rəqəm1 = 10;
            int rəqəm2 = 0;
            int nəticə = rəqəm1 / rəqəm2; // Bu kod sətri istisna hal atacaq
            System.out.println("Nəticə: " + nəticə);
        } catch (ArithmeticException e) {
            System.out.println("❌İstisna hal: Sıfıra bölmə mümkün deyil.");
        }
    }
    //--------------------------------------------------------------
    public static void RəqəmFormatıIstisnaNümunəsi () {
        System.out.println("------------------\n" +
                "Rəqəm Formatı nümunəsi: ");

        Scanner scanner = new Scanner(System.in);
        boolean tam_ədəd_daxil_edildi = false;

        while (! tam_ədəd_daxil_edildi) { // ! = NOT = menfi
            try {
                System.out.print("Bir tam ədəd daxil edin: "); // 2, 3 ... 1.2 QEBUL deyil!
                String istifadəçiGirişi = scanner.nextLine();
                int rəqəm = Integer.parseInt(istifadəçiGirişi);
                        // Istisna burada yarana biler..
                        // eger yaransa, kod icrasi burada durub,
                        // ve icra CATCH blok'a atilacaq
                System.out.println("Daxil etdiyiniz ədəd: " + rəqəm);
                tam_ədəd_daxil_edildi = true;
            } catch (NumberFormatException e) {
                System.out.println("❌İstisna hal: Düzgün formatda rəqəm daxil etmədiniz.");
            }
        } // end of while
    }
    //--------------------------------------------------------------
    private static void textFayldanOxuVəƏkranaYaz(String fayl_ismi){
        try {
            File fayl = new File(fayl_ismi);
            Scanner faylOxuyucu = new Scanner(fayl); // bu kod sətri İSTİSNA ata bilər !
            // əgər yaransa, direkt sətir 68 gedəcək kod icrası
            System.out.println("✅Fayl (" + fayl_ismi + ") tapıldı. " +
                    "Onun məzmununu oxuyub, ekranda yazıram...");
            while (faylOxuyucu.hasNextLine())
                System.out.println(faylOxuyucu.nextLine());

            faylOxuyucu.close();
        } catch (FileNotFoundException e) {
            System.out.println("❌ İstisna hal: Fayl (" + fayl_ismi + ") tapılmadı. ");
        }
    }
    //--------------------------------------------------------------
    public static void FaylOxumaIstisnaNümunəsi () {
        System.out.println("------------------\n" +
                "Fayl Oxuma nümunəsi: ");

        textFayldanOxuVəƏkranaYaz("mövcud_olmayan_fayl.txt");
        textFayldanOxuVəƏkranaYaz(
                "src\\ders16_istisna_idare_etmesi\\mövcud_fayl.txt");
    }
    //--------------------------------------------------------------
    public static void MassivArrayİndeksIstisnaNümunəsi() {
        System.out.println("------------------\n" +
                "Massiv (array) indeks nümunəsi: "); // Array Index Example

        char[] massiv = {'B', 'a', 'k', 'ı'};
            // 4-xanalı bir hərf (Character) array yaradırıq
        int i=0;
        try {
            for (i=0; i<6; i++)
                System.out.println("Massivin [" + i + "]-cu elementi: "
                        + massiv[i]); // Səhv burda baş verir
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌İstisna hal: Verilen massiv indeksi ("
                    + i + "), həddindən artıqdir.");
        }
    }
    //--------------------------------------------------------------
    public static void BirdənÇoxİstisnaIstisnaNümunəsi () {
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
            System.out.println("❌İstisna hal: Fayl tapılmadı.");
        } catch (Exception e) {
            System.out.println("❌İstisna hal: Gözlənilməyən bir problem baş verdi: " + e.getMessage());
        }
    }
    //--------------------------------------------------------------
    public static void NullPointerIstisnaNümunəsi () {
        System.out.println("------------------\n" +
                "Sıfıra bölmə nümunəsi: ");

        String mətn = null; // "Gəncə";
        try {
            System.out.println("Mətn uzunluğu: " + mətn.length() + " hərf"); // Səhv atacaq
        } catch (NullPointerException e) {
            System.out.println("❌İstisna hal: Mətn NULL olduğu üçün, uzunluğu yoxlanıla bilməz.");
        }
    } // end funk

} // class
