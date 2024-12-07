package ders12_dongüler_for_while;

import java.util.Random;

public class RandomCoxSade {

    public static void main(String[] args) {
        Random təsadüfi = new Random();

        int i= 0;
        while (i<50) {
            System.out.println(  təsadüfi.nextInt(6)+1);
            i++;
        }
        // 2 -> "2"

    }
}
