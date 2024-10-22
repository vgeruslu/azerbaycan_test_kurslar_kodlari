package bizimKod;

import java.util.Vector;
// Controls Controller: MVC
public  class ƏlaqəNəzarətçisi {
    //public static Vector<Əlaqə> istifadəçininƏlaqələri = new Vector<>();
    public static Vector<String> istifadəçininƏlaqələri = new Vector<String>();

    public static void əlaqəƏlavəEt(String yeniƏlaqə) {
        istifadəçininƏlaqələri.add(yeniƏlaqə);
        System.out.println("Yeni əlaqə = "+ yeniƏlaqə + " əlavə oldu");
    }

    public static void əlaqəSil(String silinəcəkƏlaqəİsmi) {
        for (int i = 0; i < istifadəçininƏlaqələri.size(); i++)
            if (istifadəçininƏlaqələri.get(i).equals(silinəcəkƏlaqəİsmi)) {
                istifadəçininƏlaqələri.remove(i);
                System.out.print("Silinəcək əlaqə = "+ silinəcəkƏlaqəİsmi + " sistemdən sildim");
                return;
            }
        System.out.println("XƏTA: Silinəcək əlaqə = "+ silinəcəkƏlaqəİsmi + " sistemdə tapılmadı");
    }
}
