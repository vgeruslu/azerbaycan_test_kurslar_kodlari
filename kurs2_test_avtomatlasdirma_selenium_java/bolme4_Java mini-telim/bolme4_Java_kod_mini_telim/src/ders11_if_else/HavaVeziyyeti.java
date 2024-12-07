package ders11_if_else;

import java.util.Scanner;

public class HavaVeziyyeti {

    public static void main(String[] args) {
        //int temperatur = 28; // hard coding
        // "Hard coding" can be translated into Azerbaijani as "sabit kodlaşdırma" or "daşlaşmış kodlaşdırma"

        // İstifadəçidən temperatur məlumatı almaq
        Scanner scanner; //Scanner = sinif . scanner = obyekt
        scanner= new Scanner(System.in);
        System.out.print("Hava temperaturunu daxil edin (°C): ");
        int temperatur = scanner.nextInt();


        // Hava vəziyyətini təyin etmək

        if (temperatur >= 30)
            System.out.println("Hava çox istidir.");

        else if (temperatur >= 20)// && temperatur < 30)
            System.out.println("Hava istidir.");

            else if (temperatur >= 10)
                System.out.println("Hava yaxşıdır.");

                else if (temperatur >= 0)
                    System.out.println("Hava soyuqdur.");

                    else
                        System.out.println("Hava çox soyuqdur.");
        /*
        if (temperatur >= 30) {
            System.out.println("Hava çox istidir.");
            System.out.println("Hava soyuducunu açıram");
        }
        else if (temperatur >= 20) {
            System.out.println("Hava istidir.");
            System.out.println("Hava soyuducunu açıram");
        }
        else if (temperatur >= 10) {
            System.out.println("Hava yaxşıdır.");
            System.out.println("Qızdırıcı və ya soyuducuya ehtiyac yoxdur !!");
        }
        else if (temperatur >= 0) {
            System.out.println("Hava soyuqdur.");
            System.out.println("Qızdırıcını açıram");
        }
        else {
            System.out.println("Hava çox soyuqdur.");
            System.out.println("Qızdırıcını açıram");
        }
        */

        // Scanner-ı bağla
        //scanner.close();
    }
}
