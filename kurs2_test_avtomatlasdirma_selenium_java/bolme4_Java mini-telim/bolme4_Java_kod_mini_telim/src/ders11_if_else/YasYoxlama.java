package ders11_if_else;

import javax.swing.*;
import java.util.Scanner;

public class YasYoxlama {

    public static void main(String[] args) {
        // versiya 1-en sade: hard-code:
        // int yaş = 68; // İstifadəçinin yaşı

        // versiya 2-command-line'dan deyer oxumaq:
        /*  System.out.print("Zəhmət olmasa yaşınızı daxil edin: ");
        String yaş_string = new Scanner(System.in).nextLine();
        int yaş = Integer.valueOf(yaş_string);
        */

        // versiya 3- UI ile deyer oxumaq:
        ImageIcon icon = new ImageIcon("src/ders11_if_else/azerbaycan_icon_kicik.png");
        String yaş_string = (String) JOptionPane.showInputDialog
                (null, "Zəhmət olmasa yaşınızı daxil edin",
                        "Mobil bankçılıq tətbiqi", JOptionPane.INFORMATION_MESSAGE,
                        icon,null,"");
        int yaş = Integer.valueOf(yaş_string);

        if (yaş < 18)
            //System.out.println("Siz hələ yetkin deyilsiniz.");
            JOptionPane.showMessageDialog(null, "Siz hələ yetkin deyilsiniz.");

        else if (yaş >= 18 && yaş < 65)
            System.out.println("Siz yetkinsiniz.");
        else
            System.out.println("Siz təqaüd yaşındasınız."); // retirement

    } // end of func
} // end of class
