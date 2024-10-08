package tests.if_ile;

import model.İstifadəçi;

import java.util.Objects;

public class IstifadeçiTesti {

	public static void main(String[] args) {
		/* KÖHNƏ: manual test
		İstifadəçi testİstifadəçi = new İstifadəçi("mike", "şifrə", "Mikayıl", "Səmədov", "07771234567");
		System.out.println(testİstifadəçi);
		*/

		// avtomatlaşdırılmış test

		// 1- Objekti və test məlumatlarını qurmaq, ilkinləşdirmək
		// Dörd addımı baxın:
		String test_İstifadəçi_adı = "mike";
		String test_şifrə = "şifrə";
		String test_ad = "Mikayıl";
		String test_soyad = "Səmədov";
		String test_mobil_nömrə = "07771234567";

		// 2- İcra et, test olunan obyekti işə sal
        İstifadəçi testİstifadəçi = null;
        try {
            testİstifadəçi = new İstifadəçi(test_İstifadəçi_adı, test_şifrə, test_ad,
                    test_soyad, test_mobil_nömrə);
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }

        // 3- Təsdiq et (Assert)

		boolean keçdi = true;

		if (!Objects.equals(testİstifadəçi.getEpoçt(), test_İstifadəçi_adı)) {
			System.out.println("TC1 uğursuz oldu: İstifadəçi adı uyğun gəlmədi");
			keçdi = false;
		}
		if (testİstifadəçi.getŞifrə() != test_şifrə) {
			System.out.println("TC2 uğursuz oldu: şifrə uyğun gəlmədi");
			keçdi = false;
		}
		
		/* TODO: yuxarıdakı iki if-kod blokuna bənzər üç başqa kod blokları əlavə edin,
		sinfin digər üç sahəsini yoxlamaq üçün 
			
			-- AŞAĞIDA YERİNƏ YETİRİLDİ
			
		*/

		if (testİstifadəçi.getAd() != test_ad) {
			System.out.println("TC3 uğursuz oldu: ad uyğun gəlmədi");
			keçdi = false;
		}

		if (testİstifadəçi.getSoyad() != test_soyad) {
			System.out.println("TC4 uğursuz oldu: soyad uyğun gəlmədi");
			keçdi = false;
		}

		if (testİstifadəçi.getMobilNömrə() != test_mobil_nömrə) {
			System.out.println("TC5 uğursuz oldu: mobil nömrə uyğun gəlmədi");
			keçdi = false;
		}

		if (keçdi)
			System.out.println("Bütün TC-lər uğurla keçdi.");

		// assert'lərdən istifadə

		assert testİstifadəçi.getEpoçt() == test_İstifadəçi_adı;
		//assert 1==2;
		
		/* TODO: yuxarıdakı assert kimi DİGƏR DÖRD təsdiqi əlavə edin,
		sinfin digər dörd sahəsini yoxlamaq üçün 
		
		-- AŞAĞIDA YERİNƏ YETİRİLDİ
		
		*/
		assert testİstifadəçi.getŞifrə() == test_şifrə;
		assert testİstifadəçi.getAd() == test_ad;
		assert testİstifadəçi.getSoyad() == test_soyad;
		assert testİstifadəçi.getMobilNömrə() == test_mobil_nömrə;

		System.out.println("Test dəstindəki bütün Java assertləri uğurla keçdi (heç biri uğursuz olmadı).");
	}
}
