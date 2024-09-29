package model;

public class İstifadəçi {
	private String istifadəçi_adı; // e-poçt ünvanı
	private String şifrə;
	private String ad;
	private String soyad;
	private String mobil_nömrə;

	public String getİstifadəçiAdı() {
		return istifadəçi_adı;
	}

	public void setİstifadəçiAdı(String istifadəçi_adı) {
		this.istifadəçi_adı = istifadəçi_adı;
	}

	public String getŞifrə() {
		return şifrə;
	}

	public void setŞifrə(String şifrə) {
		this.şifrə = şifrə;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getMobilNömrə() {
		return mobil_nömrə;
	}

	public void setMobilNömrə(String mobil_nömrə) {
		this.mobil_nömrə = mobil_nömrə;
	}

	public İstifadəçi(String istifadəçi_adı, String şifrə,
					  String ad, String soyad, String mobil_nömrə) {
		super();
		this.istifadəçi_adı = istifadəçi_adı;
		this.şifrə = şifrə;
		this.ad = ad;
		this.soyad = soyad;
		this.mobil_nömrə = mobil_nömrə;
	}

	public String toString() {
		//return istifadəçi_adı  + ", "  + şifrə + ", "  + ad + ", "  + soyad + ", "  + mobil_nömrə;

		return String.format("%-25s| %-15s| %-15s| %-15s| %-15s",
				istifadəçi_adı, şifrə, ad, soyad, mobil_nömrə);
	}
}
