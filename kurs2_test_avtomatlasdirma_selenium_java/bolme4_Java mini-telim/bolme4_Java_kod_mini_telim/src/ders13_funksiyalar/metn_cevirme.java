package ders13_funksiyalar;

public class metn_cevirme {


    /*public static String kiçikHərflərəÇevir(String mətn) {
        return mətn.toUpperCase();
    }*/

    /*public static String tərsəÇevir(String mətn) {
        return new StringBuilder(mətn).reverse().toString();
    }*/

    public static String böyükHərflərəÇevir(String mətn) {
        return mətn.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println("-------------------" );
        String böyükMətn = böyükHərflərəÇevir("Salam Dünya");
        System.out.println("Böyük hərflərlə mətn: " + böyükMətn);

        System.out.println(böyükHərflərəÇevir("Java dilini çox istəyirəm!"));

        //System.out.println("Tərs mətn: " + tərsəÇevir(mətn));

        //System.out.println("Böyük hərflərlə mətn: " +
                //böyükHərflərəÇevir("Java dilini sevirəm"));

    }

}
