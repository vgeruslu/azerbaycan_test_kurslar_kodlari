package tests.if_ile;

import app.SadeBankçiliqProqrami;
import controller.İstifadəçiNəzarətçisi;

public class SadeBankçiliqProqramiTesti {
	// test olunan sistem (SUT):
	static SadeBankçiliqProqrami əsasProqram = new SadeBankçiliqProqrami();

	// bu test metodu (test işi) sinifin (unit və ya komponentin) məlumat yükləmə funksiyasının düzgün işləyib-işləmədiyini yoxlayır
	public static void testMəlumatYükləməsi() {
		// Xatırlatma: Klassik Dörd Faza test modeli (Hazırlıq-İcra-Yoxlama-Təmizləmə)
		// http://xunitpatterns.com/Four%20Phase%20Test.html

		// Hazırlıq fazası: yoxdur

		// İcra fazası
        try {
            İstifadəçiNəzarətçisi.istifadəçiMəlumatlarınıDoldur();
        } catch (Exception e) {
			//throw new RuntimeException(e);
        }

        // Yoxlama fazası
		// UUT-un yükləmə funksiyasında 3 istifadəçinin yükləndiyini görürük, buna görə yoxlayaq
		assert İstifadəçiNəzarətçisi.istifadəçilər.size() == 3;
		System.out.println("testMəlumatYükləməsi: istifadəçiMəlumatlarınıDoldur: TC1 keçdi.");
		// Yuxarıdakı yoxlama sadədir (sadə, zəif)
		// Daha güclü yoxlama etmək üçün istifadəçi adları və hesab balansları üçün daha çox assertion lazım olardı.

		əsasProqram.hesabMəlumatlarınıDoldur();
		assert əsasProqram.hesablar.size() == 4;
		System.out.println("testMəlumatYükləməsi: hesabMəlumatlarınıDoldur: TC1 keçdi.");

		// Təmizləmə fazası: Bu test işində heç bir dəyişiklik edilmədiyi üçün Təmizləməyə ehtiyac yoxdur.
	}

	// bu test metodu (test işi) Əmanət funksiyasının düzgün işləyib-işləmədiyini yoxlayır
	public static void testƏmanətlər() {
		// Hazırlıq fazası
		double balansƏvvəl = əsasProqram.balansıAl("5495-1234");
		double əmanətMiqdarı = 50.21;

		// İcra fazası
		əsasProqram.əməliyyatƏlavəEt("5495-1234", əmanətMiqdarı);
		double balansSonra = əsasProqram.balansıAl("5495-1234");
		assert balansƏvvəl + əmanətMiqdarı == balansSonra;
		System.out.println("testƏmanətlər: TC1 keçdi.");

		// təmizləmə: sistemi əvvəlki vəziyyətinə qaytar
		// test işlərinin təmizləmə fazası haqqında daha çox oxuyun: http://xunitpatterns.com/Four%20Phase%20Test.html
		əsasProqram.əməliyyatƏlavəEt("5495-1234", -əmanətMiqdarı);
	}

	// bu test metodu (test işi) Çıxarma funksiyasının düzgün işləyib-işləmədiyini yoxlayır
    /* TODO
    public static void testÇıxarmalar() {
        ...
    }
    */

	public static void main(String[] args) {
		testMəlumatYükləməsi();
		testƏmanətlər();
		// testÇıxarmalar(); -- bu çağırışı şərhdən çıxarın, test metodunu (test işini) inkişaf etdirdiyiniz zaman
	}

}
