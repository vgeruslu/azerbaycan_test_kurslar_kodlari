package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Əməliyyat {
	String hesab_nömrəsi;
	double əməliyyat_məbləği;
	Date əməliyyat_tarixi;

	public Əməliyyat(String hesab_nömrəsi, double əməliyyat_məbləği, Date əməliyyat_tarixi) {
		super();
		this.hesab_nömrəsi = hesab_nömrəsi;
		this.əməliyyat_məbləği = əməliyyat_məbləği;
		this.əməliyyat_tarixi = əməliyyat_tarixi;
	}

	public String toString() {
		SimpleDateFormat formatter4=new SimpleDateFormat("(MMM dd, yyyy)");

		return hesab_nömrəsi  + ", "  + əməliyyat_məbləği + ", "  + formatter4.format(əməliyyat_tarixi);
	}

	public String getHesabNömrəsi() {
		return hesab_nömrəsi;
	}

	public void setgetHesabNömrəsi(String hesab_nömrəsi) {
		this.hesab_nömrəsi = hesab_nömrəsi;
	}

	public double getƏməliyyatMəbləği() {
		return əməliyyat_məbləği;
	}

	public void setƏməliyyatMəbləği(double əməliyyat_məbləği) {
		this.əməliyyat_məbləği = əməliyyat_məbləği;
	}

	public Date getƏməliyyat_tarixi() {
		return əməliyyat_tarixi;
	}

	public void setƏməliyyat_tarixi(Date əməliyyat_tarixi) {
		this.əməliyyat_tarixi = əməliyyat_tarixi;
	}
}
