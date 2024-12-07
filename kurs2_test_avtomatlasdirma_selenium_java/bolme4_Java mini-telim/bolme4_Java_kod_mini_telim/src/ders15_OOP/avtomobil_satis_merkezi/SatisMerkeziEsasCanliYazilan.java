package ders15_OOP.avtomobil_satis_merkezi;

import java.util.Scanner;
import java.util.Vector;

public class SatisMerkeziEsasCanliYazilan {

    static Vector<SatiliqAvtomobil> satılıqMaşınlar = new Vector<SatiliqAvtomobil>();
    // SIYAHI ... SatiliqAvtomobil class tipinden bir Vector (esnek array, boyuyen, kicilen) yaradiriq

    public static void demo_masinlar_melumatlarini_load_et() {
        SatiliqAvtomobil jiquli1995 =
                new SatiliqAvtomobil("Lada", "Vaz", 1995, 22000);

        SatiliqAvtomobil toyota2020 =
                new SatiliqAvtomobil("Toyota", "Camry", 2020, 15000);

        satılıqMaşınlar.add(jiquli1995);
        satılıqMaşınlar.add(toyota2020);
        System.out.println("✅Sistem işə salınır indi, və iki demo maşının məlumatları sistem bazasında yükləndi");
    }

    public static void istifadeci_menyusunu_goster() {
        System.out.println("\n--- Əsas Menyu ---"); // \n: YENI XETte gel
        System.out.println("1. System bazasına maşın əlavə et");
        System.out.println("2. Maşının satış qiymətini artır");
        System.out.println("3. Maşının satış qiymətini azalt");
        System.out.println("4. Maşının satıldığını qeyd et");
        System.out.println("--------------------");
        System.out.println("5. Satılmış maşınların siyahısı");
        System.out.println("6. Satılmamış maşınların siyahısı");
        System.out.println("7. Bütov maşınların siyahısı");
        /*
        System.out.println("8. Diger Əməliyyat");
        System.out.println("9. Diger Əməliyyat");*/
        System.out.println("--------------------");
        System.out.println("0. Çıxış");
    }

    public static void main(String[] args) {
        System.out.println("------------------------------");
        // iki demo (test) masin melumati load et
        demo_masinlar_melumatlarini_load_et();

        // menyu
        Scanner scanner = new Scanner(System.in);
        int menyudan_seçim;

        // Proqramın əsas döngüsü
        do {
            // Menyunu göstərin
            istifadeci_menyusunu_goster();

            // İstifadəçidən seçim alırıq
            System.out.print("Seçiminizi daxil edin (0 çıxmaq üçün): ");
            menyudan_seçim = scanner.nextInt();

            if (menyudan_seçim == 1)
                m1_system_bazasına_maşın_əlavə_et();
            else if (menyudan_seçim == 2)
                m2_maşının_satış_qiymətini_artır();
            else if (menyudan_seçim == 3)
                m3_maşının_satış_qiymətini_azalt();
            else if (menyudan_seçim == 4)
                m4_maşının_satıldığını_qeyd_et();
            else if (menyudan_seçim == 5)
                m5_satılmış_maşınların_siyahısı();
            else if (menyudan_seçim == 6)
                m6_satılmamış_maşınların_siyahısı();
            else if (menyudan_seçim == 7)
                m7_bütov_maşınların_siyahısı();
            else if (menyudan_seçim == 0) {
                System.out.println("Proqramdan çıxılır.");
                break;
            }
            else
                System.out.println("❌ Yanlış seçim! Yenidən cəhd edin.");

        } while (menyudan_seçim != 0);


    } // end main

    private static void m1_system_bazasına_maşın_əlavə_et() {
        // klaviyatordan oxumaq ucun, bele bir obyekte her zaman eytiyacimiz var
        Scanner scanner = new Scanner(System.in);

        System.out.print("Marka daxil edin: ");
        String marka = scanner.nextLine();

        System.out.print("Model daxil edin: ");
        String model = scanner.nextLine();

        System.out.print("İstehsal ilini daxil edin: ");
        int istehsalIli = scanner.nextInt();

        System.out.print("Satış qiymətini daxil edin (AZN): ");
        int satışQiyməti = scanner.nextInt();

        SatiliqAvtomobil yeniAvtomobil = new SatiliqAvtomobil(
                marka, model, istehsalIli, satışQiyməti);

        // Add the new object to the satiliqAvtomobillər Vector
        satılıqMaşınlar.add(yeniAvtomobil);
        System.out.println("✅Yeni avtomobil uğurla əlavə edildi!");
        System.out.println("Hal-hazirda, sistem verilenler-bazasinda " + satılıqMaşınlar.size() + " avtomobil vardir");

    }


    private static void m2_maşının_satış_qiymətini_artır() {
    }

    private static void m3_maşının_satış_qiymətini_azalt() {
    }
    private static void m4_maşının_satıldığını_qeyd_et() {
    }
    private static void m5_satılmış_maşınların_siyahısı() {
    }
    private static void m6_satılmamış_maşınların_siyahısı() {
    }

    private static void m7_bütov_maşınların_siyahısı() {
    }
} // end class
