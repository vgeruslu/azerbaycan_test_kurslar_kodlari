package ders15_OOP;

public class Avtomobil {
    private String marka;
    private String model;
    private int istehsalIli;
    private int satışQiyməti;

    public Avtomobil(String marka, String model,
                     int istehsalIli, int satışQiyməti) {
        this.marka = marka;
        this.model = model;
        this.istehsalIli = istehsalIli;
        this.satışQiyməti = satışQiyməti;
    }

    public void avtomobilMəlumatınıÇapEt() {
        System.out.println("Marka: " + marka);
        System.out.println("Model: " + model);
        System.out.println("İstehsal ili: " + istehsalIli);
        System.out.println("Satış qiyməti: " + satışQiyməti + " ₼ AZN\n");
    }
}

