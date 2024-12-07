package ders12_dongüler_for_while;

public class EdedleriSayma {
    public static void main(String[] args) {

        //System.out.println("Ədədləri sayma, WHILE döngüsü ilə:");
        // azdan, coxa saymaq
        /*int ədəd = 3;
        while (ədəd <=20)
        {
            System.out.println("--Ədəd: " + ədəd);
            //ədəd++; //ədəd = ədəd + 1 (sagdaki deyer hesablanib, ve soldaki
                    // deyisene yeni deyer olaraq, teyin edilir
            ədəd = ədəd + 5 ;
        }*/

        // COXdan, az saymaq (ters)
        double ədəd = 30.25;
        while (ədəd >= 5)
        {
            System.out.println("--Ədəd: " + ədəd);
            ədəd = ədəd - 1.5;
        }

        /*
        System.out.println("Ədədləri sayma, FOR döngüsü ilə:");
        for (int ədəd2 = 0; ədəd2 <5; ədəd2 ++)
            System.out.println("\tƏdəd: " + ədəd2);
        */
    }
}
