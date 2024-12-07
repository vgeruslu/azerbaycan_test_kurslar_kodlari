package ders13_funksiyalar;

import java.util.Random;

public class HavaProqnozu {
    // Weather Forecast
    public static void main(String[] args) {
        // Proqram 5 günlük *təsadüfi* hava proqnozunu yaradır
        System.out.println("-------------------" );
        System.out.println("5-günlük *təsadüfi* hava proqnozu:");

        for (int gün = 1; gün <= 14; gün++) {
            int temperatur = təsadüfiTemperaturYarat();
            String təsvir = temperaturdanHavaTəsviriYarat(temperatur);
            proqnozGöstər(gün, temperatur, təsvir);
        }
    }

    // Təsadüfi temperatur yaradan funksiya
    public static int təsadüfiTemperaturYarat() {
        Random təsadüfi = new Random();
        return təsadüfi.nextInt(51) - 10; // -10 ilə 40 arasında temperatur yaradır
    }

    // Temperatur əsasən hava təsviri yaradan funksiya
    public static String temperaturdanHavaTəsviriYarat(int temperatur) {
        if (temperatur < 0) {
            return "Çox soyuq və qarlı";
        } else if (temperatur < 10) {
            return "Soyuq və küləkli";
        } else if (temperatur < 20) {
            return "Sərin və buludlu";
        } else if (temperatur < 30) {
            return "İsti və günəşli";
        } else { // 30 dan cox
            return "Çox isti və günəşli";
        }
    }

    // Proqnozu göstərən funksiya
    public static void proqnozGöstər(int gün, int temperatur,
                                     String təsvir) {
        System.out.printf("Gün %d: Temperatur %d°C, %s\n",
                gün, temperatur, təsvir);
    }
}
