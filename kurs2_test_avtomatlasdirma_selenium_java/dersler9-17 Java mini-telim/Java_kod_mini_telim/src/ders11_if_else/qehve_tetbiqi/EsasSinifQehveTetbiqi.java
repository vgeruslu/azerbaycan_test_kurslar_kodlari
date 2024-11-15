package ders11_if_else.qehve_tetbiqi;

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