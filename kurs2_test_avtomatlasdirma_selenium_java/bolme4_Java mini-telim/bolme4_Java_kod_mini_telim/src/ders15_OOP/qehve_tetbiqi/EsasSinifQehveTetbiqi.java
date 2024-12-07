package ders15_OOP.qehve_tetbiqi;

public class EsasSinifQehveTetbiqi {
    public static void main(String[] args) {

        Qəhvə qəhvə = new Qəhvə();
        Proqramçı proqramçı = new Proqramçı("Vəhid Gəruslu");

        if (qəhvə.boşdur())
            qəhvə.doldur();
        else
            proqramçı.iç(qəhvə);
    }
}