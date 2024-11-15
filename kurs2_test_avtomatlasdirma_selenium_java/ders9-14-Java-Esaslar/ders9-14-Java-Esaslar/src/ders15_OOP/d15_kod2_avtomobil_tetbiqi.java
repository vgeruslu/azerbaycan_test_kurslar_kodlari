package ders15_OOP;

public class d15_kod2_avtomobil_tetbiqi {
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
    }

}
