package ders13_funksiyalar;

import java.util.Random;

public class HavaProqnozu {
    // Weather Forecast
    public static void main(String[] args) {
        // Proqram 5 günlük *təsadüfi* hava proqnozunu yaradır
        System.out.println("5-günlük *təsadüfi* hava proqnozu:");

        for (int gün = 1; gün <= 5; gün++) {
            int temperatur = temperaturYarat();
            String təsvir = havaTəsviriYarat(temperatur);
            proqnozGöstər(gün, temperatur, təsvir);
        }
    }

    // Təsadüfi temperatur yaradan funksiya
    public static int temperaturYarat() {
        Random təsadüfi = new Random();
        return təsadüfi.nextInt(41) - 10; // -10 ilə 30 arasında temperatur yaradır
    }

    // Temperatur əsasən hava təsviri yaradan funksiya
    public static String havaTəsviriYarat(int temperatur) {
        if (temperatur < 0) {
            return "Çox soyuq və qarlı";
        } else if (temperatur < 10) {
            return "Soyuq və küləkli";
        } else if (temperatur < 20) {
            return "Sərin və buludlu";
        } else if (temperatur < 30) {
            return "İsti və günəşli";
        } else {
            return "Çox isti və günəşli";
        }
    }

    // Proqnozu göstərən funksiya
    public static void proqnozGöstər(int gün, int temperatur, String təsvir) {
        System.out.printf("Gün %d: Temperatur %d°C, %s\n", gün, temperatur, təsvir);
    }
}
