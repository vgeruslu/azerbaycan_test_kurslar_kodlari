package ders13_funksiyalar;

public class metn_cevirme {

    public static String böyükHərflərəÇevir(String mətn) {
        return mətn.toUpperCase();
    }

    /*public static String kiçikHərflərəÇevir(String mətn) {
        return mətn.toUpperCase();
    }*/

    /*public static String tərsəÇevir(String mətn) {
        return new StringBuilder(mətn).reverse().toString();
    }*/

    public static void main(String[] args) {
        String mətn = "Salam Dünya";
        String böyükMətn = böyükHərflərəÇevir(mətn);
        System.out.println("Böyük hərflərlə mətn: " + böyükMətn);

        //System.out.println("Tərs mətn: " + tərsəÇevir(mətn));

        //System.out.println("Böyük hərflərlə mətn: " +
                //böyükHərflərəÇevir("Java dilini sevirəm"));

    }

}
