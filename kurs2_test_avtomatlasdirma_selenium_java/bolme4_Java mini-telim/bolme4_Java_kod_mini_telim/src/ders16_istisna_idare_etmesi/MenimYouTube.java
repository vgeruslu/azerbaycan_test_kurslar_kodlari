package ders16_istisna_idare_etmesi;

import java.awt.Desktop;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;

public class MenimYouTube {
    public static void main(String[] args) {
        // etirbarli URL
        //String youtubeURL = "https://www.youtube.com/watch?v=ehvBXLy3hyY";

        // etirbarsiz URL
        String youtubeURL = "Necesen";
        try {
            System.out.println("\nYouTube videosu açılmağa çalışılır: " + youtubeURL);
            // URL-i açmaq üçün, java.awt kitabxanasının "Desktop" API-dən istifadə edirik
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(youtubeURL));
                System.out.println("✅ OS-də YouTube videosunu açma və oynatma tətbiqini (brauzeri) çağırdım. " +
                        "Video uğurla açılmalı olmalı indi...");
            } else {
                System.out.println("❌ XƏTA: Bu platformada URL açmaq üçün, " +
                        "heç bir tətbiq / brauzer təyin olmamış.");
            }
        } catch (ConnectException e) { // Bağlantı problemi zamanı bu blok işləyir
            System.out.println("❌ İSTİSNA baş verdi: Bağlantı uğursuz oldu! İnternetə qoşulmağı yoxlayın.");
            return;
        } catch (URISyntaxException e) { // URL düzgün formatda deyilsə
            System.out.println("❌ İSTİSNA baş verdi: Verilən URL düzgün formatda deyil: " + youtubeURL);
            return;
        } catch (IOException e) { //  Digər I/O problemləri
            System.out.println("❌ İSTİSNA baş verdi: input/output (İ/O) problemi: " + e.getMessage());
            return;
        }
        System.out.println("✅ Proqramda heç istisna baş vermədi. Proqram bitdi və bağlanır...");
    }
}


