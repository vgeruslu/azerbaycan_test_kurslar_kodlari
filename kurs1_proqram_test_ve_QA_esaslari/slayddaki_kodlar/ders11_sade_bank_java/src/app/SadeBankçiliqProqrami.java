package app;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import controller.İstifadəçiNəzarətçisi;
import model.Hesab;
import model.Əməliyyat;
import model.İstifadəçi;

public class SadeBankçiliqProqrami {
	public static Vector<Hesab> hesablar = new Vector<Hesab>();
	public static Vector<Əməliyyat> əməliyyatlar = new Vector<Əməliyyat>();

	public static void hesabMəlumatlarınıDoldur() {
		// hər qeyd strukturu:
		// hesab nömrəsi, İstifadəçi adı (email), hesab tipi (Standart və ya Yığım), hesab açılış tarixi

		Hesab birHesab;
		try {
			birHesab = new Hesab("5495-1234", "mike", "Standart", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
			hesablar.add(birHesab);

			birHesab = new Hesab("5495-1239", "mike", "Standart", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
			hesablar.add(birHesab);

			birHesab = new Hesab("5495-1291", "mike", "Yığım", new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2019"));
			hesablar.add(birHesab);

			birHesab = new Hesab("5495-6789", "David.McDonald@gmail.com", "Yığım", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
			hesablar.add(birHesab);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void bütünHesablarıÇapEt() {
		System.out.println("Sistemdə: " + hesablar.size() + " hesab var.");
		System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| %-15s",
				"Hesab #", "hesab sahibi", "tip", "açılış tarixi", "Balans"));
		System.out.println("--------------------------------------------------------------------------------");
		for (int i = 0; i < hesablar.size(); i++)
			System.out.println(hesablar.get(i).toString() + "| £" + balansıAl(hesablar.get(i).getHesabNömrəsi()));
		System.out.println();
	}

	public static void əməliyyatƏlavəEt(String hesab_nömrəsi, double məbləğ) {
		Əməliyyat birƏməliyyat = new Əməliyyat(hesab_nömrəsi, məbləğ, Calendar.getInstance().getTime());
		əməliyyatlar.add(birƏməliyyat);
	}

	public static double balansıAl(String hesab_nömrəsi) {
		double balans = 0.0;

		for (int i = 0; i < əməliyyatlar.size(); i++)
			if (əməliyyatlar.get(i).getHesabNömrəsi().equals(hesab_nömrəsi))
				balans += əməliyyatlar.get(i).getƏməliyyatMəbləği();

		return balans;
	}

	public static void main(String[] args) {
        try {
            İstifadəçiNəzarətçisi.istifadəçiMəlumatlarınıDoldur();
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }
        İstifadəçiNəzarətçisi.bütünİstifadəçiləriÇapEt();

		hesabMəlumatlarınıDoldur();
		System.out.println("Hesab: ilkin vəziyyət, yükləndikdən sonra...");
		bütünHesablarıÇapEt();

		əməliyyatƏlavəEt("5495-1234", -50.21);
		System.out.println("Hesab: 1-ci əməliyyatdan sonra...");
		bütünHesablarıÇapEt();

		əməliyyatƏlavəEt("5495-1234", 520.00);
		əməliyyatƏlavəEt("9999-1111", 21.00);
		System.out.println("Hesab: 2-ci/3-cü əməliyyatdan sonra...");
		bütünHesablarıÇapEt();
	}
}
