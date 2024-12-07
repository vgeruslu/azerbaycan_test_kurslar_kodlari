package ders15_OOP.sade_avtomobil_tetbiqi;

public class avtomobil_tetbiqi {
    public static void main(String[] args) {
        // Avtomobil sinifindən bir obyekt yaradırıq
        Avtomobil mənimJiquliAvtomobilim =
                new Avtomobil("Lada", "Vaz", 1995, 22000);

        // Avtomobil obyektinin məlumatını göstəririk
        mənimJiquliAvtomobilim.avtomobilMəlumatınıÇapEt();

        // digər bir obyekt yaradırıq
        Avtomobil eldarınToyotası =
                new Avtomobil("Toyota", "Camry", 2020, 15000);

        // digər obyektinin məlumatını göstəririk
        eldarınToyotası.avtomobilMəlumatınıÇapEt();

        // digər bir obyekt yaradırıq
        Avtomobil yeniMercedes =
                new Avtomobil("Mercedes", "C220", 2025, 65000);

        // digər obyektinin məlumatını göstəririk
        yeniMercedes.avtomobilMəlumatınıÇapEt();

    }

}
