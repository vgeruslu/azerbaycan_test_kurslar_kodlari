package ders15_OOP.avtomobil_satis_merkezi;

public class SatiliqAvtomobil {
    private String marka;
    private String model;
    private int istehsalIli;
    private int satışQiyməti;
    boolean satıldı;

    public SatiliqAvtomobil() {

    }

    public SatiliqAvtomobil(String marka, String model,
                            int istehsalIli, int satışQiyməti) {
        this.marka = marka;
        this.model = model;
        this.istehsalIli = istehsalIli;
        this.satışQiyməti = satışQiyməti;
        this.satıldı = false; // satilMAMIS
    }

    public void avtomobilMəlumatınıÇapEt() {
        System.out.println("Marka: " + marka + " --- Model: " + model);
        System.out.println("İstehsal ili: " + istehsalIli + " --- Satış qiyməti: " + satışQiyməti + " ₼ AZN");

        System.out.print("Satış vəziyyəti: ");
        if (satıldı)
            System.out.println("SATILDI");
        else
            System.out.println("SATILMAMIŞ");

        System.out.println("-----------------------" );
    }

    // Sürəti artıran metod
    public void satışQiymətiniArtır(int miqdar) {
        //satışQiyməti += miqdar;
        satışQiyməti = satışQiyməti + miqdar;
        //System.out.println("Satış qiyməti artırıldı: " + satışQiyməti + " AZN");
    }

    // Sürəti azaldan metod
    public void satışQiymətiniAzalt(int miqdar) {
        //satışQiyməti -= miqdar;
        satışQiyməti = satışQiyməti - miqdar;
        //System.out.println("Satış qiyməti azaldıldı: " + satışQiyməti + " AZN");
    }

    public void satıldığınıQeydEt() {
        this.satıldı = true;
    }
}

