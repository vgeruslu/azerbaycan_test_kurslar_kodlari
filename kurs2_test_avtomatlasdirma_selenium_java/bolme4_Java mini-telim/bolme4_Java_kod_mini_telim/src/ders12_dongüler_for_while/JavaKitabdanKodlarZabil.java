package ders12_dongüler_for_while;

import java.util.Scanner;

public class JavaKitabdanKodlarZabil {

    public static void main(String[] args) throws InterruptedException {
        //sobanı_yandır();
        kofet_ye();

    }
    public static void kofet_ye() throws InterruptedException {
        int konfet = 5;
        int aclıq = 1;
        while (aclıq <= konfet) {
            System.out.println("Konfetin " + aclıq + "-ni yedim.");
            aclıq ++;
        }
    }

    public static void AclıqSimulyasiyası() throws InterruptedException {
        // Dolğunluq göstəricisinin başlanğıc dəyəri
        int dolğunluqGöstəricisi = 0;

        // Yeməklərin dolğunluq dəyərləri
        int çörəkDolğunluq = 10; // Çörək 10 dəyər artırır
        int meyvəDolğunluq = 20; // Meyvə 20 dəyər artırır
        int ətDolğunluq = 30; // Ət 30 dəyər artırır

        Scanner scanner = new Scanner(System.in);

        System.out.println("Aclıq Ölçəri və Dolğunluq Ölçü Cihazı Simulyasiyasına xoş gəldiniz!");
        System.out.println("Dolğunluq göstəricisi 0 ilə 100 arasında dəyişir. Hazırda: " + dolğunluqGöstəricisi);

        // Yemək yemə prosesi
        while (dolğunluqGöstəricisi < 100) {
            System.out.println("\nHazırkı dolğunluq göstəricisi: " + dolğunluqGöstəricisi);
            if (dolğunluqGöstəricisi >= 40 && dolğunluqGöstəricisi <= 60) {
                System.out.println("Siz hazırda Məmnun (satisfied) vəziyyətdəsiniz.");
            } else if (dolğunluqGöstəricisi < 40) {
                System.out.println("Siz hələ də Aclıq hiss edirsiniz.");
            } else if (dolğunluqGöstəricisi > 60) {
                System.out.println("Siz çox dolğun hiss edirsiniz.");
            }

            System.out.println("\nSeçimləriniz:");
            System.out.println("1. Çörək yemək (10 artırır)");
            System.out.println("2. Meyvə yemək (20 artırır)");
            System.out.println("3. Ət yemək (30 artırır)");
            System.out.println("0. Yeməyi dayandırmaq");

            System.out.print("Seçiminizi daxil edin: ");
            int seçim = scanner.nextInt();

            if (seçim == 0) {
                System.out.println("Simulyasiyanı dayandırdınız.");
                break;
            }

            switch (seçim) {
                case 1:
                    dolğunluqGöstəricisi += çörəkDolğunluq;
                    System.out.println("Çörək yediniz. Dolğunluq göstəricisi: " + dolğunluqGöstəricisi);
                    break;
                case 2:
                    dolğunluqGöstəricisi += meyvəDolğunluq;
                    System.out.println("Meyvə yediniz. Dolğunluq göstəricisi: " + dolğunluqGöstəricisi);
                    break;
                case 3:
                    dolğunluqGöstəricisi += ətDolğunluq;
                    System.out.println("Ət yediniz. Dolğunluq göstəricisi: " + dolğunluqGöstəricisi);
                    break;
                default:
                    System.out.println("Yanlış seçim etdiniz. Zəhmət olmasa 0-3 arasında bir rəqəm daxil edin.");
            }

            // Dolğunluq göstəricisini 100-dən yuxarı keçməməsi üçün idarə edir
            if (dolğunluqGöstəricisi > 100) {
                dolğunluqGöstəricisi = 100;
                System.out.println("Dolğunluq göstəricisi maksimum həddə çatdı (100).");
            }
        }

        System.out.println("\nYemək yemə prosesi bitdi. Son dolğunluq göstəricisi: " + dolğunluqGöstəricisi);
        if (dolğunluqGöstəricisi == 100) {
            System.out.println("Siz tamamilə dolusunuz! Artıq yemək yemək olmaz.");
        }
        scanner.close();
    }
    public static void sobanı_yandır() throws InterruptedException {
        int hava = -20;

        while (hava < 0) {
            System.out.println("Sobanı yandırıram (yanıq saxlayıram)...");
            Thread.sleep(1000); // her saniyede bir defe havani oxu
            hava = hava + 1; // real sistemdə, SENSOR dan oxuymalıyıq !
            System.out.println("Cari temperatur = " + hava);
        }
        System.out.println("Sobanı bağlayıram");
    }
}
