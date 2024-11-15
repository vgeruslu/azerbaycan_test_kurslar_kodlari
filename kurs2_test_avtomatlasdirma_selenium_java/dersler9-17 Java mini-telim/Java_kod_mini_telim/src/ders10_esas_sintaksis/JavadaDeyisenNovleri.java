package ders10_esas_sintaksis;

public class JavadaDeyisenNovleri {

    public static void main(String[] args) {
        // Tam ədəd növü
        int əhali = 10123456; // 10,123,456
        //-2,147,483,648 ilə 2,147,483,647 arasında tam ədəd

        // Ondalık nömrə növü
        double böyükDəqiqlikləMaaş = 2789.123456;
        // Ondalık ədədlər üçün, dəqiqliyi 15 rəqəmə qədər

        // Mətn növü
        char hərf = 'A'; // Tək bir simvol saxlayır
        String mesaj = "Salam Azərbaycan!"; // Mətn sətiri

        // Məntiqi növ
        boolean azadliq = true; // true və ya false dəyəri ala bilər

        // Çap edirik
        System.out.println("Əhali: " + əhali);
        System.out.println("Böyük dəqiqliklə maaş: " + böyükDəqiqlikləMaaş);
        System.out.println("Hərf: " + hərf);
        System.out.println("Mesaj: " + mesaj);
        System.out.println("Azadlıq: " + azadliq);

        // ilin sonu gəldi, maaşlara 20% çoxlacaq
        /*böyükDəqiqlikləMaaş = böyükDəqiqlikləMaaş * 1.2;

        System.out.println("Böyük dəqiqliklə maaş: "
                + String.format("%.2f", böyükDəqiqlikləMaaş) + " ₼");
        */
    }
}