package KitabxanalarLibs;

import old.KOHNE_EsasSehifeTestleri;
import old.KOHNE_GirisSehifeTestleri;
import org.openqa.selenium.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestKitabxana {

    public static boolean MP3_SƏS_OYNA = true; // Parameter to toggle sound playback
    public static final String VLC_EXE_PATH = "C:\\Program Files\\VideoLAN\\VLC\\vlc.exe"; // Path to VLC executable
    public static final String MP3_QOVLUĞU = "D:\\Code\\Azerbaijan_Code\\azerbaycan_test_kurslar_kodlari\\resurslar\\mp3\\"; // Path to VLC executable


    public static void brauzerin_mövqe_və_ölçüsünü_dəyiş(WebDriver sürücü,
                                                         int mövqe_x,
                                                         int mövqe_y,
                                                         int ölçü_en,
                                                         int ölçü_boy) {
        //System.out.println("ⓘ Əvvəl: Mövqeyi (position) = " + sürücü.manage().window().getPosition());
        //System.out.println("ⓘ Əvvəl: Pencere ölçüsü = " + sürücü.manage().window().getSize());

        sürücü.manage().window().setPosition(new Point(mövqe_x, mövqe_y));
        //System.out.println("ⓘ Sonra: Mövqeyi (position) = " + sürücü.manage().window().getPosition());
        sürücü.manage().window().setSize(new Dimension(ölçü_en, ölçü_boy));
        //System.out.println("ⓘ Sonra: Pencere ölçüsü = " + sürücü.manage().window().getSize());

        /*
        try {
            // 1. Monitorlar haqqında məlumat əldə edirik
            GraphicsEnvironment mühit = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice[] monitorlar = mühit.getScreenDevices();

            if (monitorlar.length < 2) {
                System.out.println("İki və ya daha çox monitor tələb olunur!");
                //sürücü.quit();
                return;
            }

            for (int i=0; i < monitorlar.length; i++) {
                Rectangle monitorKoordinatları = monitorlar[i].getDefaultConfiguration().getBounds();
                int x = monitorKoordinatları.x;
                int y = monitorKoordinatları.y;
                int w = monitorKoordinatları.width;
                int h = monitorKoordinatları.height;

                System.out.println("ⓘ Monitor Koordinatları[" + i +"]: x=" + x + ", y=" + y + ", w=" + w + ", h=" + h);
            }
            // 2. İkinci monitorun koordinatlarını tapırıq
            Rectangle ikinciMonitorunKoordinatları = monitorlar[1].getDefaultConfiguration().getBounds();
            int x2 = ikinciMonitorunKoordinatları.x; // İkinci monitorun başlanğıc X koordinatı
            int y2 = ikinciMonitorunKoordinatları.y; // İkinci monitorun başlanğıc Y koordinatı

            System.out.println("ⓘ 2ci monitorun koordinatları: x2=" + x2 + ", y2=" + y2);

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
            System.out.println("❌Brauzeri_orta_monitora_dasi - Xəta baş verdi: " + e.getMessage());
        } finally {

        }*/
    }// end func

    public static Connection db_bağlantısı_yarat() {
        // MySQL bağlantı detalları
        String url = "jdbc:mysql://localhost:3306/mini_facebook"; // Məlumat bazası URL-i
        String username = "root"; // MySQL istifadəçi adı
        String password = ""; // MySQL parolu

        try {
            // MySQL-ə bağlantı yaradılır
            Connection bağlantı = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Bağlantı uğurla quruldu!");
            return bağlantı;

        } catch (Exception e) {
            // Xətaları idarə edir
            System.out.println("❌ DB bağlantısında xəta yaşandı: " + e.getMessage());
        } finally {
        }
        return null;
    }  // end func

    public static void ekran_loqunda_yaz(String mətn) {
        System.out.println(mətn);
    }

    public static boolean element_ekranda_görünür_mu(WebDriver driver, WebElement element) {
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

    public static void mətnin_səhifədə_olduğunu_yoxla(WebDriver sürücü, String metn)  throws Exception {
        System.out.println("❓ Axtarılan mətn: " + metn);
        mp3_oyna("Mətnin səhifədə olduğunu yoxlayıram");
        WebElement axtarılan_element = sürücü.findElement(
                By.xpath("//*[contains(text(),'" + metn + "')]"));
        System.out.println("✅ Mətn tapıldı: " + metn);
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, axtarılan_element);
    }

    public static void mp3_oyna(String mp3_fayl_ismi) {
        if (MP3_SƏS_OYNA) {
            System.out.println(mp3_fayl_ismi);
            //System.out.println("mp3_fayl_ismi = " + mp3_fayl_ismi);
            //String mp3_fayl_full_path = System.getProperty("user.dir")
            //        + "\\src\\main\\resources\\mp3\\" + mp3_fayl_ismi + ".mp3";
            String mp3_fayl_full_path = MP3_QOVLUĞU + mp3_fayl_ismi + ".mp3";

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
                System.out.println("❌MP3 oxunarkən xəta baş verdi: " + e.getMessage());
            }
            //System.out.println("--MP3 oynatmağı tamamladı");
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

    public static void obyektın_kənarını_rəng_ilə_vurğula(WebDriver sürücü, WebElement obyekt) {
        obyektın_kənarını_rəng_ilə_vurğula(sürücü, obyekt, 1);
    }

    public static void obyektın_kənarını_rəng_ilə_vurğula(WebDriver sürücü, WebElement obyekt, int gozleme_saniye) {
        if (!element_ekranda_görünür_mu(sürücü, obyekt))
            ((JavascriptExecutor) sürücü).executeScript(
                    "arguments[0].scrollIntoView();", obyekt);

        ((JavascriptExecutor) sürücü).executeScript(
                "arguments[0].style.border='2px solid green'", obyekt);
        try {
            Thread.sleep(gozleme_saniye * 1000); // 1 saniyə
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) sürücü).executeScript(
                "arguments[0].style.border='2px solid white'", obyekt);
    }

    public static void test_seti_icra_et(
            String test_setin_ismi, String[] testlər) throws Exception {
        int uğurlu_testlər_sayı = 0;
        int uğursuz_testlər_sayı = 0;
        int test_sayğacı = 1;
        System.out.println("\uD83D\uDDC3\uFE0F Test-set icrasina başlayıram: " +  test_setin_ismi + "...");

        for (String test : testlər) {
            try {
                // Test metodunu refleksiya vasitəsilə çağırırıq
                // https://www.baeldung.com/java-reflection
                System.out.println("\uD83D\uDD04 Test-setin " + test_sayğacı + "-ci testi başlayır (toplam: " +
                        testlər.length + "): " + test + "...");
                if (test_setin_ismi == "Giriş səhifənin testləri")
                    KOHNE_GirisSehifeTestleri.class.getDeclaredMethod(test).invoke(null);
                else if (test_setin_ismi == "Əsas səhifənin testləri")
                    KOHNE_EsasSehifeTestleri.class.getDeclaredMethod(test).invoke(null);

                System.out.println("✅ Test uğurlu bitdi: " + test );
                uğurlu_testlər_sayı ++;
            }
            catch (InvocationTargetException ite) {
                // https://stackoverflow.com/questions/6020719/what-could-cause-java-lang-reflect-invocationtargetexception
                Throwable cause = ite.getCause();
                if(ite.getCause().getClass().equals(NoSuchWindowException.class)){
                    System.out.println("❌ İnternet browser bağlanmış. Test otomasyon də çıxış edir");
                    mp3_oyna("İnternet browser bağlanmış. Test otomasyon də çıxış edir");
                    return;
                }
                else {
                    System.out.println("❌ Test uğursuz oldu: " + test + " - " + cause.toString() + "--DETAL: " +
                            cause.getMessage());
                    uğursuz_testlər_sayı++;
                }
            }

            test_sayğacı ++;
        } // end for

        // qissa test icra hesabati
        int testler_toplam = uğurlu_testlər_sayı + uğursuz_testlər_sayı;
        System.out.println("-----------------------------\nTest nəticə hesabatı:");
        System.out.println("✅ Uğurlu testlərin sayı = " + uğurlu_testlər_sayı + "/" + testler_toplam);
        System.out.println("❌ Uğursuz testlərin sayı = " + uğursuz_testlər_sayı + "/" + testler_toplam);

        //Thread.sleep(5000);
    } // end func

    public static void daxil_ol(WebDriver sürücü, String istifadəçiEmaili, String şifrə) throws Exception {
        mp3_oyna("Verilən istifadəçi email və şifrə ilə daxil oluram"); //Quqıl səhifəsini açıram

        WebElement mətnQutusuİstifadəçiEmail = sürücü.findElement(
                By.xpath("//*[@name = 'epoçt']"));
        mətnQutusuİstifadəçiEmail.sendKeys(istifadəçiEmaili);
        // Etibarlı bir İstifadəçi adı və etibarlı Şifrə daxil edir (verilən email və şifrə birgə, sistem DB-sində bir hesab ilə "match" edirlər)
        WebElement mətnQutusuŞifrə = sürücü.findElement(
                By.xpath("//*[@name = 'şifrə']"));
        mətnQutusuŞifrə.sendKeys(şifrə);

        mp3_oyna("Düyməyə vururam");
        sürücü.findElement(By.xpath("//*[@class = 'submit']")).click();
    }

    public static void yoxlama_uğurlu() {
        System.out.println("✅ ");
        mp3_oyna("Yoxlama uğurlu");
    }

    public static void yoxlama_uğursuz() {
        System.out.print("❌ ");
        mp3_oyna("Yoxlama uğursuz");
    }

} //class
