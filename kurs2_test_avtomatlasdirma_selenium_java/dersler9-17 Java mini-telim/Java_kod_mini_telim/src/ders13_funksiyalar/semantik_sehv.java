package ders13_funksiyalar;

public class semantik_sehv {

   // DuzbucaqlınınSahəsi
   public static void main(String[] args) {
       int uzunluq = 4;
       int en = 3;

       System.out.println("Düzbucaqlının sahəsi: "
               + duzbucaqlınınSahəsiniHesabla(uzunluq, en));
   }
   public static int duzbucaqlınınSahəsiniHesabla(int uzunluq, int en) {
       return 2 * (uzunluq + en);
   }

    // Səhv məntiq - əslində perimetri hesablayır
    // Sahəni tapmaq üçün (uzunluq * en) istifadə edilməlidir
    // 4 və 3 üçün, doğru cavab 12 olmalı idi
}
