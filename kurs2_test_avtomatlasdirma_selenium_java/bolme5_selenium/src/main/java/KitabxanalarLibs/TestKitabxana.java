package KitabxanalarLibs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Point;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestKitabxana {

    public static boolean MP3_SES_OYNA = true; // Parameter to toggle sound playback
    public static final String VLC_EXE_PATH = "C:\\Program Files\\VideoLAN\\VLC\\vlc.exe"; // Path to VLC executable
    public static final String MP3_QOVLUGU = "D:\\Code\\Azerbaijan_Code\\azerbaycan_test_kurslar_kodlari\\test_avto_resurslar\\mp3\\"; // Path to VLC executable


    public static void Brauzeri_orta_monitora_dasi(WebDriver sürücü, int monitor_numresi) {

        try {
            // 1. Monitorlar haqqında məlumat əldə edirik
            GraphicsEnvironment mühit = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice[] monitorlar = mühit.getScreenDevices();

            if (monitorlar.length < 2) {
                System.out.println("İki və ya daha çox monitor tələb olunur!");
                sürücü.quit();
                return;
            }

            for (int i=0; i < monitorlar.length; i++) {
                Rectangle monitorKoordinatları = monitorlar[i].getDefaultConfiguration().getBounds();
                int x = monitorKoordinatları.x;
                int y = monitorKoordinatları.y;
                int w = monitorKoordinatları.width;
                int h = monitorKoordinatları.height;

                System.out.println("monitor Koordinatları[" + i +"]: x=" + x + ", y=" + y + ", w=" + w + ", h=" + h);
            }
            // 2. İkinci monitorun koordinatlarını tapırıq
            Rectangle ikinciMonitorunKoordinatları = monitorlar[1].getDefaultConfiguration().getBounds();
            int x2 = ikinciMonitorunKoordinatları.x; // İkinci monitorun başlanğıc X koordinatı
            int y2 = ikinciMonitorunKoordinatları.y; // İkinci monitorun başlanğıc Y koordinatı

            System.out.println("2ci monitorun koordinatları: x2=" + x2 + ", y2=" + y2);

            int monitor2_zoom_level = 125; //%
            x2 =( x2 * 100)/ monitor2_zoom_level;
            System.out.println("2ci monitorun koordinatları (ZOOM dan sonra): x2=" + x2 + ", y2=" + y2);

            //ucuncuMonitorunKoordinatları
            Rectangle ucuncuMonitorunKoordinatları = monitorlar[2].getDefaultConfiguration().getBounds();
            int x3 = ucuncuMonitorunKoordinatları.x; // İkinci monitorun başlanğıc X koordinatı
            int y3 = ucuncuMonitorunKoordinatları.y; // İkinci monitorun başlanğıc Y koordinatı

            System.out.println("3cu monitorun koordinatları: x3=" + x3 + ", y3=" + y3);

            int monitor3_zoom_level = 125; //%
            x3 =( x3 * 100)/ monitor2_zoom_level;
            System.out.println("3cu monitorun koordinatları (ZOOM dan sonra): x3=" + x3 + ", y3=" + y3);

            if (monitor_numresi == 2)
                sürücü.manage().window().setPosition(new Point(x2, y2));
            else if (monitor_numresi == 3)
                sürücü.manage().window().setPosition(new Point(x3, y3));

            //sürücü.manage().window().maximize();

        } catch (Exception e) {
            System.out.println("Xəta baş verdi: " + e.getMessage());
        } finally {

        }
    }// end func

    public static void MP3_oyna(String mp3_fayl_ismi) {
        if (MP3_SES_OYNA) {
            System.out.println("mp3_fayl_ismi = " + mp3_fayl_ismi);
            //String mp3_fayl_full_path = System.getProperty("user.dir")
            //        + "\\src\\main\\resources\\mp3\\" + mp3_fayl_ismi + ".mp3";
            String mp3_fayl_full_path = MP3_QOVLUGU + mp3_fayl_ismi + ".mp3";

            //System.out.println("mp3_fayl_full_path = " + mp3_fayl_full_path);

            // Prepare VLC command arguments
            String[] command = {
                    VLC_EXE_PATH,
                    "-I", "null",               // Run VLC without interface
                    "--play-and-exit",          // Play and exit automatically
                    // "--volume-step", "256",     // Volume step
                    // "--gain", "8",              // Audio gain
                    mp3_fayl_full_path               // File to play
            };

            try {
                // Start VLC process
                ProcessBuilder processBuilder = new ProcessBuilder(command);
                processBuilder.redirectErrorStream(true); // Redirect error stream
                Process process = processBuilder.start();

                // Read and clean error stream buffer
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String line;
                while ((line = errorReader.readLine()) != null) {
                    // Handle or ignore error messages if needed
                }

                // Wait for VLC to finish
                process.waitFor();
            } catch (Exception e) {
                System.out.println("MP3 oxunarkən xəta baş verdi: " + e.getMessage());
            }
            System.out.println("--MP3 oynatmağı tamamladı");
        } // end if
    } // end func

    /*public static void MP3Oynat(String MP3_fayl_ismi) {
        System.out.println("MP3_fayl_ismi = " + MP3_fayl_ismi);

        String MP3_ful_yol_qovluğu = System.getProperty("user.dir")
                + "\\src\\main\\resources\\mp3\\" + MP3_fayl_ismi + ".mp3";

        System.out.println("MP3_ful_yol_qovluğu = " + MP3_ful_yol_qovluğu);

        try {

            Platform.startup(() -> {
                // This block will be executed on the JavaFX thread
                Media mp3_media = new Media(new File(MP3_ful_yol_qovluğu).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(mp3_media);

                mediaPlayer.play();

                // Flag for checking playback completion
                final boolean[] isMediaEnded = {false};

                // Media playback completion handler
                mediaPlayer.setOnEndOfMedia(() -> {
                    System.out.println("Media oynatma tamamlandı!");
                    isMediaEnded[0] = true;
                    Platform.exit(); // Properly shut down JavaFX runtime
                });

                // Error handler
                mediaPlayer.setOnError(() -> {
                    System.out.println("Xəta baş verdi: " + mediaPlayer.getError().getMessage());
                    isMediaEnded[0] = true;
                    Platform.exit(); // Exit in case of an error
                });

                mediaPlayer.setOnReady(() -> {
                    System.out.println("Media faylı hazırdır.");
                });

                // Thread to monitor MediaPlayer status
                new Thread(() -> {
                    try {
                        // Wait for media to start playing
                        while (mediaPlayer.getStatus() != MediaPlayer.Status.PLAYING &&
                                mediaPlayer.getStatus() != MediaPlayer.Status.PAUSED) {
                            Thread.sleep(100); // Short sleep interval
                        }

                        // Monitor until playback ends
                        while (!isMediaEnded[0]) {
                            if (mediaPlayer.getStatus() == MediaPlayer.Status.STOPPED ||
                                    mediaPlayer.getStatus() == MediaPlayer.Status.UNKNOWN) {
                                System.out.println("Media dayandırıldı və ya bilinməyən status oldu.");
                                isMediaEnded[0] = true;
                                Platform.exit();
                            }
                            Thread.sleep(100); // Short sleep interval
                        }

                    } catch (InterruptedException e) {
                        System.out.println("Proses dayandırıldı: " + e.getMessage());
                        Platform.exit();
                    }
                }).start();
            }); // end Platform.startup

        } catch (Exception e) {
            System.out.println("Istisna hali bas versi. Problem = " + e.toString()
                    + " -- Detal = " + e.getMessage());
        } // end try
        System.out.println("------- MP3Oynat funksiya bitdi -------");
    }  // end fun*/



    public static boolean IsElementVisibleInViewport(WebDriver driver, WebElement element) {
        return
                (boolean) ((JavascriptExecutor) driver).executeScript(
                        "var elem = arguments[0], " +
                                "box = elem.getBoundingClientRect(), " +
                                "cx = box.left + box.width / 2,  " +
                                "cy = box.top + box.height / 2, " +
                                "e = document.elementFromPoint(cx, cy); " +
                                "for (; e; e = e.parentElement) " +
                                "     { if (e === elem) return true;}" +
                                "return false;",
                        element);
    } // func

    public static void YoxlamaUğurlu() {
        System.out.println("✅ Yoxlama uğurlu");
        MP3_oyna("Yoxlama uğurlu");
    }

    public static void YoxlamaUğursuz() {
        System.out.println("❌ Yoxlama uğursuz");
        MP3_oyna("Yoxlama uğursuz");
    }
} //class
