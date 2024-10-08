package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hesab {
	String hesab_nömrəsi;
	String hesab_sahibinin_istifadəçi_adı;
	String hesab_növü; // "Standard" və ya "Yığım"
	Date hesab_açılış_tarixi;

	public Hesab(String hesab_nömrəsi, String hesab_sahibinin_istifadəçi_adı, String hesab_növü,
				 Date hesab_açılış_tarixi) {
		super();
		this.hesab_nömrəsi = hesab_nömrəsi;
		this.hesab_sahibinin_istifadəçi_adı = hesab_sahibinin_istifadəçi_adı;
		this.hesab_növü = hesab_növü;
		this.hesab_açılış_tarixi = hesab_açılış_tarixi;
	}

	public String getHesabNömrəsi() {
		return hesab_nömrəsi;
	}

	public void setHesabNömrəsi(String hesab_nömrəsi) {
		this.hesab_nömrəsi = hesab_nömrəsi;
	}

	public String getHesabSahibininİstifadəçiAdı() {
		return hesab_sahibinin_istifadəçi_adı;
	}

	public void setHesabSahibininİstifadəçiAdı(String hesab_sahibinin_istifadəçi_adı) {
		this.hesab_sahibinin_istifadəçi_adı = hesab_sahibinin_istifadəçi_adı;
	}

	public String getHesab_növü() {
		return hesab_növü;
	}

	public void setHesab_növü(String hesab_növü) {
		this.hesab_növü = hesab_növü;
	}

	public Date getHesab_açılış_tarixi() {
		return hesab_açılış_tarixi;
	}

	public void setHesab_açılış_tarixi(Date hesab_açılış_tarixi) {
		this.hesab_açılış_tarixi = hesab_açılış_tarixi;
	}

	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("(MMM dd, yyyy)");
		return String.format("%-10s| %-30s| %-10s| %-15s",
				hesab_nömrəsi, hesab_sahibinin_istifadəçi_adı, hesab_növü, format.format(hesab_açılış_tarixi));
	}
}
