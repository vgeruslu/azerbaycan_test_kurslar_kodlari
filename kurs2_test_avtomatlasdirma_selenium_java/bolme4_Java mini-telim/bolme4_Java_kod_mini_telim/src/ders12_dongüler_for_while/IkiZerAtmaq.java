package ders12_dongüler_for_while;

import java.util.Random;

public class IkiZerAtmaq {
    public static void main(String[] args) {
        Random təsadüfi = new Random();
        int say = 1;

        int zar1_1=0, zar1_2=0, zar1_3=0,zar1_4=0,zar1_5=0,zar1_6=0;
        // daha yaxsi yol var bu is ucun, aray'leri istifade etmek..
        // amma hele o mefhumu oyrenmemisik

        while (say <= 100) {
            int zar1 = təsadüfi.nextInt(6) + 1; // 1-dən 6-ya qədər təsadüfi rəqəm
            int zar2 = təsadüfi.nextInt(6) + 1; // 1-dən 6-ya qədər təsadüfi rəqəm

            System.out.printf("Atış %d: Zar1 = %d, Zar2 = %d\n", say, zar1, zar2);
            say++;

            if (zar1 == 1)
                zar1_1 ++;
            if (zar1 == 2)
                zar1_2 ++;
            if (zar1 == 3)
                zar1_3 ++;
            if (zar1 == 4)
                zar1_4 ++;
            if (zar1 == 5)
                zar1_5 ++;
            if (zar1 == 6)
                zar1_6 ++;

        }

        System.out.printf("Sonra, Zar1-in dəyərlər sayılar:");
        System.out.printf("\tZar1_1= %d\n", zar1_1);
        System.out.printf("\tZar1_2= %d\n", zar1_2);
        System.out.printf("\tZar1_3= %d\n", zar1_3);
        System.out.printf("\tZar1_4= %d\n", zar1_4);
        System.out.printf("\tZar1_5= %d\n", zar1_5);
        System.out.printf("\tZar1_6= %d\n", zar1_6);


    }
}