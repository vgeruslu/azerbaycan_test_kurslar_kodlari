package ders15_OOP.avtomobil_satis_merkezi;

import java.util.Scanner;
import java.util.Vector;

public class SatisMerkeziEsasTetbiq {

    static Vector<SatiliqAvtomobil> satiliqAvtomobillər = new Vector<SatiliqAvtomobil>();

    public static void ilkinMəlumatlarıYüklə() {
        // Verilənlər bazası istifadə etməyəcəyik. Sistem hər dəfə işə salındıqda, eyni iki maşının məlumatları sistem bazasında yüklənməlidir
        SatiliqAvtomobil avtomobil1 = new SatiliqAvtomobil(
                "Toyota", "Camry", 2020, 15000) ;
        SatiliqAvtomobil avtomobil2 = new SatiliqAvtomobil(
                "Honda", "Accord", 2021, 31000) ;

        satiliqAvtomobillər.add(avtomobil1);
        satiliqAvtomobillər.add(avtomobil2);
        System.out.print("Sistem işə salınır indi, və iki maşının məlumatları sistem bazasında yükləndi");
    }

    public static void main(String[] args) {
        ilkinMəlumatlarıYüklə();
        // menyu
        Scanner scanner = new Scanner(System.in);
        int seçim;

        // Proqramın əsas döngüsü
        do {
            // Menyunu göstərin
            menyunuGöstər();

            // İstifadəçidən seçim alırıq
            System.out.print("Seçiminizi daxil edin (0 çıxmaq üçün): ");
            seçim = scanner.nextInt();

            // Seçimə görə funksiyaları çağırırıq
            switch (seçim) {
                case 1:
                    m1_systemBazasınaMaşınƏlavəEt();
                    break;
                case 2:
                    m2_maşınSatışQiymətiniArtır();
                    break;
                case 3:
                    m3_maşınSatışQiymətiniAzalt();
                    break;
                case 4:
                    m4_maşınSatıldığınıQeydEt();
                    break;
                case 5:
                    m5_satılmışMaşınlarınSiyahısı();
                    break;
                case 6:
                    m6_satılmamışMaşınlarınSiyahısı();
                    break;
                case 7:
                    m7_bütovMaşınlarınSiyahısı();
                break;
                /* case 8:
                    break;
                case 9:
                    break;*/
                case 0:
                    System.out.println("Proqramdan çıxılır.");
                    break;
                default:
                    System.out.println("❌ Yanlış seçim! Yenidən cəhd edin.");
            }
        } while (seçim != 0);

        scanner.close();
    } // end main

    private static void m1_systemBazasınaMaşınƏlavəEt() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for each field of the Avtomobil class
        System.out.print("Marka daxil edin: ");
        String marka = scanner.nextLine();

        System.out.print("Model daxil edin: ");
        String model = scanner.nextLine();

        System.out.print("İstehsal ilini daxil edin: ");
        int istehsalIli = scanner.nextInt();

        System.out.print("Satış qiymətini daxil edin (AZN): ");
        int satışQiyməti = scanner.nextInt();

        // Create a new Avtomobil object
        SatiliqAvtomobil yeniAvtomobil = new
                SatiliqAvtomobil(marka, model, istehsalIli, satışQiyməti);

        // Add the new object to the satiliqAvtomobillər Vector
        satiliqAvtomobillər.add(yeniAvtomobil);
        System.out.println("✅ Yeni avtomobil uğurla əlavə edildi!");
    }
    private static void m2_maşınSatışQiymətiniArtır() {
        Scanner scanner = new Scanner(System.in);
        m7_bütovMaşınlarınSiyahısı();
        System.out.print("Qiyməti artırmaq üçün maşının nömrəsini daxil edin: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < satiliqAvtomobillər.size()) {
            System.out.print("Artırılacaq məbləği daxil edin: ");
            int miqdar = scanner.nextInt();
            satiliqAvtomobillər.get(index).satışQiymətiniArtır(miqdar);
            System.out.println("✅ Maşının satış qiyməti artırıldı.");
        } else {
            System.out.println("❌ Yanlış indeks! ❌");
        }
    }

    private static void m3_maşınSatışQiymətiniAzalt() {
        Scanner scanner = new Scanner(System.in);
        m7_bütovMaşınlarınSiyahısı();
        System.out.print("Qiyməti azaltmaq üçün maşının nömrəsini daxil edin: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < satiliqAvtomobillər.size()) {
            System.out.print("Azaldılacaq məbləği daxil edin: ");
            int miqdar = scanner.nextInt();
            satiliqAvtomobillər.get(index).satışQiymətiniAzalt(miqdar);
            System.out.println("✅ Maşının satış qiyməti azaldıldı.");
        } else {
            System.out.println("❌ Yanlış indeks! ❌");
        }
    }

    // maşın Satıldığını Qeyd Et
    private static void m4_maşınSatıldığınıQeydEt() {
        m7_bütovMaşınlarınSiyahısı();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Satılmış kimi qeyd etmək üçün maşının nömrəsini (siyahıdakı indeks) daxil edin: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < satiliqAvtomobillər.size()) {
            satiliqAvtomobillər.get(index).satıldığınıQeydEt();
            System.out.println("✅ Maşın satılmış kimi qeyd edildi.");
        } else {
            System.out.println("❌ Yanlış indeks! ❌");
        }
    }

    // satılmış Maşınların Siyahısı
    private static void m5_satılmışMaşınlarınSiyahısı() {
        System.out.println("\nSatılmış maşınlar:");
        for (SatiliqAvtomobil avtomobil : satiliqAvtomobillər) {
            if (avtomobil.satıldı) {
                avtomobil.avtomobilMəlumatınıÇapEt();
            }
        }
    }

    // satılmamış Maşınların Siyahısı
    private static void m6_satılmamışMaşınlarınSiyahısı() {
        System.out.println("\nSatılmamış maşınlar:");
        for (SatiliqAvtomobil avtomobil : satiliqAvtomobillər) {
            if (!avtomobil.satıldı) {
                avtomobil.avtomobilMəlumatınıÇapEt();
            }
        }
    }

    // bütov Maşınların Siyahısı
    private static void m7_bütovMaşınlarınSiyahısı() {
        System.out.println("\nBütün maşınlar:");
        int sayğac = 0;
        for (SatiliqAvtomobil avtomobil : satiliqAvtomobillər) {
            System.out.println("indeks = " + sayğac);
            avtomobil.avtomobilMəlumatınıÇapEt();
            sayğac ++;
        }
    }


    // Menyu göstərən funksiya
    public static void menyunuGöstər() {
        System.out.println("\n--- Əsas Menyu ---");
        System.out.println("1. System bazasına maşın əlavə et");
        System.out.println("2. Maşının satış qiymətini artır");
        System.out.println("3. Maşının satış qiymətini azalt");
        System.out.println("4. Maşının satıldığını qeyd et");
        System.out.println("--------------------");
        System.out.println("5. Satılmış maşınların siyahısı");
        System.out.println("6. Satılmamış maşınların siyahısı");
        System.out.println("7. Bütov maşınların siyahısı");
        /*System.out.println("6. Əməliyyat 6");
        System.out.println("7. Əməliyyat 7");
        System.out.println("8. Əməliyyat 8");
        System.out.println("9. Əməliyyat 9");*/
        System.out.println("--------------------");
        System.out.println("0. Çıxış");
    }
}
