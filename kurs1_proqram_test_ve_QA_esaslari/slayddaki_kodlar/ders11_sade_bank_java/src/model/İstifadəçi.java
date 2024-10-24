package model;

import controller.İstifadəçiNəzarətçisi;

import static org.junit.Assert.*;

public class İstifadəçi {
	private String epoçt; // istifadəçi_adı e-poçt ünvanı
	private String şifrə;
	private String ad;
	private String soyad;
	private String mobil_nömrə;

	// constructor: funksiyon ki bu sifindan (class'den) yeni bir OBYEKT yaradir
	public İstifadəçi(String epoçt, String şifrə,
					  String ad, String soyad, String mobil_nömrə) throws Exception {
		super();

		// yoxla ki bu
		if (İstifadəçiNəzarətçisi.buEpoçtİləİstifadəçiVarMı(epoçt))
			throw new Exception("XƏTA: Verilen epoçt ilə başqa bir istifadəçi var");
		//System.out.println("XƏTA: Verilen epoçt ilə başqa bir istifadəçi var");

		this.epoçt = epoçt;
		this.şifrə = şifrə;
		this.ad = ad;
		this.soyad = soyad;
		this.mobil_nömrə = mobil_nömrə;

		İstifadəçiNəzarətçisi.istifadəçilər.add(this);
	}

	public String getŞifrə() {
		return şifrə;
	}

	public void setŞifrə(String şifrə) {
		this.şifrə = şifrə;
	}

	public String getEpoçt() {
		return epoçt;
	}

	public void setEpoçt(String epoçt) {
		this.epoçt = epoçt;
	}


	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		// ver soyad deyerini (isteyirem)
		return soyad;
	}

	public void setSoyad(String soyad) {
		// deyis Soyad
		this.soyad = soyad;
	}

	public String getMobilNömrə() {
		return mobil_nömrə;
	}

	public void setMobilNömrə(String mobil_nömrə) {
		this.mobil_nömrə = mobil_nömrə;
	}

	public String toString() {
		//return istifadəçi_adı  + ", "  + şifrə + ", "  + ad + ", "  + soyad + ", "  + mobil_nömrə;

		return String.format("%-25s| %-15s| %-15s| %-15s| %-15s",
				epoçt, şifrə, ad, soyad, mobil_nömrə);
	}
}
