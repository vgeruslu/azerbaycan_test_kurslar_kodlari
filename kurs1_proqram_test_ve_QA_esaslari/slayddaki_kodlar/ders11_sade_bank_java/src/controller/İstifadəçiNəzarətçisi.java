package controller;

import model.İstifadəçi;

import java.util.Vector;

public class İstifadəçiNəzarətçisi {
    public static Vector<İstifadəçi> istifadəçilər = new Vector<>();

    public static void istifadəçiMəlumatlarınıDoldur() throws Exception {
        // hər qeyd strukturu: İstifadəçi adı (email ünvanı), şifrə, ad, soyad, mobil nömrə

        // ideal halda (proqramın real yerləşdirilməsi zamanı) biz fayldan və ya bazadan oxuyacağıq, amma hələlik bunu kodla edək
        İstifadəçi birİstifadəçi = new İstifadəçi("mike", "mənim_şifrəm", "Mike", "Smith", "07771234567");
        istifadəçilər.add(birİstifadəçi);

        birİstifadəçi = new İstifadəçi("james.cameron@gmail.com", "mələk", "James", "Cameron", "07777654321");
        istifadəçilər.add(birİstifadəçi);

        birİstifadəçi = new İstifadəçi("julia.roberts@gmail.com", "dəyiş_məni", "Julia", "Roberts", "07770123456");
        istifadəçilər.add(birİstifadəçi); // --> GİZLİ SƏHV!
    }

    public static void bütünİstifadəçiləriÇapEt() {
        System.out.println("Sistemdə: " + istifadəçilər.size() + " İstifadəçi var.");
        System.out.printf("%-25s| %-15s| %-15s| %-15s| %-15s%n",
                "İstifadəçi adı", "şifrə", "ad", "soyad", "mobil nömrə");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (İstifadəçi i̇stifadəçi : istifadəçilər)
            System.out.println(i̇stifadəçi.toString());
        System.out.println();
    }

    public static boolean buEpoçtİləİstifadəçiVarMı(String Epoçt) {
        for (İstifadəçi i̇stifadəçi : istifadəçilər)
            if (i̇stifadəçi.getEpoçt().equals(Epoçt)) {
                //System.out.println("i̇stifadəçi.getEpoçt() = " + i̇stifadəçi.getEpoçt());
                return true;
            }

        return false;
    }

    public static void buEpoçtİləİstifadəçiniSil(String Epoçt) throws Exception {
        for (İstifadəçi i̇stifadəçi : istifadəçilər)
            if (i̇stifadəçi.getEpoçt().equals(Epoçt)) {
                istifadəçilər.remove(i̇stifadəçi);
                return;
            }
        throw new Exception("XƏTA: Verilen epoçt ilə bir istifadəçi taiplmadi");
    }

}
