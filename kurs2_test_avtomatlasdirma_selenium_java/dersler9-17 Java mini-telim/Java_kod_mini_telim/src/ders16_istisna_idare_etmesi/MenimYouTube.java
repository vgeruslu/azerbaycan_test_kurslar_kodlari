package ders16_istisna_idare_etmesi;

import java.awt.Desktop;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;

public class MenimYouTube {
    public static void main(String[] args) {
        //String youtubeURL = "https://www.youtube.com/watch?v=ehvBXLy3hyY";
        String youtubeURL = "Necesen"; //"https://www.youtube.com/watch?v=ehvBXLy3hyY";
        try {
            System.out.println("\nYouTube videosu açılmağa çalışılır: " + youtubeURL);
            // URL-i açmaq üçün, java.awt kitabxanasının "Desktop" API-dən istifadə edirik
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(youtubeURL));
                System.out.println("OS-də YouTube videosunu açma və oynatma tətbiqini çağırdım. " +
                        "Video uğurla açılmalı bu zamanda...");
            } else {
                System.out.println("\uD83D\uDC1E XƏTA: Bu platformada URL açmaq üçün heç bir tətbiq təyin olmamış.");
            }
        } catch (ConnectException e) { // 🐞 Bağlantı problemi zamanı bu blok işləyir
            System.out.println("\uD83D\uDC1E İSTİSNA baş verdi: Bağlantı uğursuz oldu! İnternetə qoşulmağı yoxlayın.");
            return;
        } catch (URISyntaxException e) { // 🐞 URL düzgün formatda deyilsə
            System.out.println("\uD83D\uDC1EİSTİSNA baş verdi: Verilən URL düzgün formatda deyil: " + youtubeURL);
            return;
        } catch (IOException e) { // 🐞 Digər I/O problemləri
            System.out.println("\uD83D\uDC1E İSTİSNA baş verdi: Bir I/O problemi baş verdi: " + e.getMessage());
            return;
        }
        System.out.println("Proqramda heç istisna baş vermədi. Proqram bitdi və bağlanır...");
    }
}


