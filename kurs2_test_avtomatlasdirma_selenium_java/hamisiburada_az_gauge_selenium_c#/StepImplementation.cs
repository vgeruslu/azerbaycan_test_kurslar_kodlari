using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using Excel = Microsoft.Office.Interop.Excel;

using Gauge.CSharp.Lib.Attribute;
//using System.Text.RegularExpressions;
using OpenQA.Selenium;
//using OpenQA.Selenium.Remote;//.UnreachableBrowserException;
//using OpenQA.Selenium.Firefox;

using OpenQA.Selenium.Chrome;
//using OpenQA.Selenium.DevTools;
using OpenQA.Selenium.Support.UI;
using SeleniumExtras.WaitHelpers;
using OpenQA.Selenium.Interactions;

using NUnit.Framework;
using System.IO;
using System.Text;
using System.Diagnostics;
using System.Net;
using System.Linq.Expressions;
using System.Globalization;
//using System.Text.Json;

/*using FluentAssertions;
using System.Linq.Expressions;
using FluentAssertions.Execution;
using System.Configuration;
*/
namespace netcore.template
{
    
    public class StepImplementation
    {

        // DISABLE: X is never used
        // #pragma warning disable 0169
        
        #pragma warning disable //ALL
        
        // DISABLE: initialized (either inline or inside of a constructor) but never reassigned.
        //#pragma warning disable IDE0044 

        //------------------------------------------------------------
        readonly int _______DƏYİŞƏNLƏR;

        IWebDriver driver ;

        String  GLOBAL_test_case_adı = "TC_AD_YOXDUR";
        String GLOBAL_test_case_içində_addım = "X";

        String GLOBAL_project_working_dir;

        String GLOBAL_test_calisdirma_baslama_tarix_zamani="--";
        /*
        protected IDevToolsSession session;
        protected DevToolsSessionDomains devToolsSession;
        */
        String tablar_arası_geçiş_əvvəlki_tab_burda_yadda_saxlanır;

          int test_senaryosunda_xeta_sayısı=0;

        Boolean browser_bağlanmış = false;

        IDictionary<string, string> Əsnək_String_Dəyişgənlər_Cədvəli = new Dictionary<string, string>();

        //------------------------------------------------------------



        
        //------------------------------------------------------------
        readonly int _______BEFORE_AFTER_SUITE_SCENARIO;

        [BeforeSuite] 
        public void Before_Test_Suite(){
            Console.WriteLine("===== Before_Test_Suite =====");

            Console.OutputEncoding = System.Text.Encoding.UTF8;

            GLOBAL_project_working_dir = Directory.GetCurrentDirectory();
            Console.WriteLine("===== GLOBAL_project_working_dir = " + GLOBAL_project_working_dir);

            
        }

        [AfterSuite] 
        public void After_Test_Suite(){
            //
            Console.WriteLine("===== After_Test_Suite ---- Butov test suit tamamlandı. Test otomasyon durur =====");
        }

        [BeforeScenario]
        public void Before_Each_Test_Scenario(){
            //Console.OutputEncoding = System.Text.Encoding.UTF8;
            //MP3_oyna("Yeni bir test senaryo başlayır");

            Console.WriteLine("===== Before_Each_Test_Scenario ---- YENI Bir test senaryo başlayır =====");
            //ƏsasSəhifəPage = new ƏsasSəhifəPage(driver);
            test_senaryosunda_xeta_sayısı = 0;
            Console.WriteLine("ChromeDriver process sayısı = " + Process.GetProcessesByName("chromedriver").Length);
            GLOBAL_project_working_dir = Directory.GetCurrentDirectory();

            /*foreach (var process in Process.GetProcessesByName("chromedriver"))
            {
                Console.WriteLine("ChromeDriver processləri kill edirəm");
                process.Kill();
            }*/
        }      

        [AfterScenario]     
        public void After_Each_Test_Scenario (){
            Console.WriteLine("===== After_Each_Test_Scenario --- Test senaryo tamamlandı =====");
            //MP3_oyna("Çalışan test senaryo tamamlandı");
            
            Console.WriteLine("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            Console.WriteLine("XETA: Bu test senaryosunda, xeta sayısı=");
            Console.WriteLine(test_senaryosunda_xeta_sayısı);
            Console.WriteLine("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            
            // Chromeu bağla
            if (driver == null);             
                //Console.WriteLine("===== Selenium Driver ARTIQ bağlanıb, tekrar bağlana bilmez! =====");
            else {
                Console.WriteLine("===== Selenium Driveri tamanen bağlayıram =====");
                driver.Quit();
            }
        } 

        [BeforeSpec]
        public void BeforeSpec() {
            Console.WriteLine("===== BeforeSpec =====");

            DateTime indikiTarixVeSaat_DateObject = DateTime.Now;
            GLOBAL_test_calisdirma_baslama_tarix_zamani = indikiTarixVeSaat_DateObject.ToString("yyyy.MM.dd-HH.mm");
            Console.WriteLine("===== GLOBAL_test_calisdirma_baslama_tarix_zamani = " + GLOBAL_test_calisdirma_baslama_tarix_zamani);
        }

        [AfterSpec]
        public void AfterSpec() {
            Console.WriteLine("===== AfterSpec =====");
        }

        //------------------------------------------------------------
        readonly int _______TEST_LIB_FONKSIYALAR;

        [Step("Test case adı budur: <test_case_adı>")]
        public void Test_case_adı_budur (String test_case_adı){
            GLOBAL_test_case_adı = test_case_adı;
        }

        [Step("Test-case içində addım = <addım>")]
        public void test_case_içində_addım_budur (String addım){
            GLOBAL_test_case_içində_addım = addım;

            //if (!GLOBAL_test_case_adı.Equals("TC_AD_YOXDUR")) 
            Console.WriteLine("-------------\nTest: " + GLOBAL_test_case_adı + "- addım: " + GLOBAL_test_case_içində_addım + "\n-------------\n");

        }

        readonly int ___EKRAN_PƏNCƏRƏ_FRAME_əməliyyatları;

        [Step("Açılan Alert pəncərəsində OK'yə vur")]
        public void Alert_pəncərəsində_OK_yə_vur (){
            try {
                MP3_oyna("Açılan Alert pəncərəsini bağlayıram");

                driver.SwitchTo().Alert().Accept();
                TestLogaYaz("Alert pəncərəsində OK'yə vurdum");
            }
            catch (Exception e) {
                Xatayı_Xata_Faylına_Yaz("Alert_pəncərəsində_OK_yə_vur. XATA=" + e.Message);
                // ise devam et
            }
        } 

        [Step("Butov frame'lerin listini yaz")]
        public void Butov_framelerin_listini_yaz() {
            try {
                IList<IWebElement> All_iframes = driver.FindElements(By.TagName("iframe"));
                TestLogaYaz("----------------------------");
                TestLogaYaz("iframe'lerin sayisi=" + All_iframes.Count);
                TestLogaYaz("iframe'lerin siyahisi:");
                foreach (IWebElement iframe in All_iframes) 
                        TestLogaYaz("iframe ID: " +  iframe.GetAttribute("id") + "--src: " + iframe.GetAttribute("src"));
                TestLogaYaz("----------------------------");
            }
            catch (Exception e) {
                    Xatayı_Xata_Faylına_Yaz("XƏTA: Butov_framelerin_listini_yaz. Mesaj=" + e.Message);
                }
        }

        [Step("Ekran başına scroll et")]
        public void Ekran_başına_scroll_et(){
                    // Scroll to the top of the web page
                    ((IJavaScriptExecutor) driver).
                        ExecuteScript("window.scrollTo(0, 0)");
        }

        [Step("Ekran sonuna scroll et")]
        public void Ekran_sonuna_scroll_et(){
                    // Scroll to the top of the web page
                    ((IJavaScriptExecutor) driver).
                        ExecuteScript("window.scrollTo(0, 1000)");
                         TestLogaYaz("Ekran sonuna scroll et");
        }



        [Step("Sistemin əsas səhifəsini aç")]
        public void Sistemin_əsas_səhifəsini_aç()
        {
            TestLogaYaz("===== Sistemin əsas səhifəsi açılır =====");
            driver.Navigate().GoToUrl(CONSTANTlar.Sistemin_əsas_səhifə_URLi);

            // əsas səhifə acildiginiz yoxla
            String səhifə_başlıgi = driver.Title;

            /*if (səhifə_başlıgi.Equals("FMS PRO Login"))
                TestLogaYaz("===== Sistemin əsas səhifəsi duzgun açıldı =====");
            else
                Xatayı_Xata_Faylına_Yaz("Sistemin_əsas_səhifəsini_aç: Sistemin əsas səhifəsi duzgun açılmadı" );*/
        }



        [Step("Sistem'dən Çıxış et (logout)")]
        public void Logout_Sistem_dən_Çıxış_et()
        {
            MP3_oyna("Sistem'dən Çıxış edirəm");
            
            //OBYEKTƏ_vur_mətn_ilə("admin");
            OBYEKTƏ_vur_mətn_ilə("Admin Adminov");

            OBYEKTƏ_vur_mətn_ilə("Çıxış"); 
            //Saniyə_Gözlə(2);

            // Chrome_u_bağla(); 
        }



        readonly int ___BROWSER_SELENİUM_əməliyyatları;

        [Step("YOXLA: Əgər son test addımda xata göründü, testi xatalı durdur")]
        public void Əgər_son_test_addımda_xata_göründü_testi_xatalı_durdur() {
            Console.WriteLine("Əgər_son_test_addımda_xata_göründü_testi_xatalı_durdur ...");

            string son_test_addımda_xata_göründü_mu;
            if (Əsnək_String_Dəyişgənlər_Cədvəli.ContainsKey("Son test addımda xata göründü"))
                son_test_addımda_xata_göründü_mu = Əsnək_String_Dəyişgənlər_Cədvəli["Son test addımda xata göründü"];
            else
                son_test_addımda_xata_göründü_mu = "Xeyr";

            //"Son test addımda xata göründü", "Bəli"
            Console.WriteLine("Son test addımda xata göründümu = " + son_test_addımda_xata_göründü_mu);

            if (son_test_addımda_xata_göründü_mu == "Bəli") {
                MP3_oyna("Son test addımda kritik bir xata göründü. Həmin xataya görə, test otomasyonun davam etməsi mümkün deyil və durur.");
                //Saniyə_Gözlə(5);
                driver.Quit();
                Assert.Fail();
            }


        }           
        public void Browser_Bağlanıbsa_Testi_də_durdur(IWebDriver driver)
        {
            //Boolean isClosed = false;
            try {
                String title = driver.Title;
            } 
            catch(UnhandledAlertException uae) {
                // do nothing
            }
            /*catch(UnreachableBrowserException uae) {

            }*/
            catch(Exception e) { 
                if (browser_bağlanmış == false) {
                    Console.WriteLine("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                    Console.WriteLine("---> İnternet browser bağlanmış. Test otomasyon də çıxış edir. XATA=" + e.Message);
                    Console.WriteLine("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                    //MP3_oyna("İnternet browser bağlanmış. Test otomasyon də çıxış edir");
                    
                    //Saniyə_Gözlə(5);
                    browser_bağlanmış = true;
                    
                    //.Inconclusive("");

                    try {
                        driver.Quit();
                        Assert.Fail();
                        //driver.Close(); 
                    }             
                    catch(Exception e2) {
                        Console.WriteLine("Browser_Bağlanıbsa_Testi_də_durdur -- Exception2: " + e2.Message);
                        driver.Quit();
                        Assert.Fail();
                    }
                    Assert.Fail();
                }
            }
            //return isClosed;
        }
        
        [Step("Chrome'u aç")]
        public void Chrome_u_aç_və_ChromeDriver_i_başlat()
        {
            Console.WriteLine("===== Chrome açılır =====");

            // Fayl əndirmə diyalogunu söndür və direkt soruşmadan əndir
            // Disable_the_Save_As_functionality
            ChromeOptions options = new ChromeOptions();
            /*
            options.AddUserProfilePreference("download.default_directory", @"C:\temp");
            options.AddUserProfilePreference("download.prompt_for_download", false);
            options.AddUserProfilePreference("download.download_restrictions", false);
            options.AddUserProfilePreference("download.open_pdf_in_system_reader", false);*/

            options.AddUserProfilePreference("profile.default_content_settings.popups", true);

            options.AddUserProfilePreference("download.prompt_for_download", true);

            options.AddUserProfilePreference("safebrowsing_for_trusted_sources_enabled", true);
            options.AddUserProfilePreference("safebrowsing.enabled", true);
            //options.AddUserProfilePreference("profile.default_content_settings.popups", 0);

            //DesiredCapabilities dc;

            // https://stackoverflow.com/questions/26772793/org-openqa-selenium-unhandledalertexception-unexpected-alert-open
            /*options.AddUserProfilePreference("unhandledAlertBehavior", "ignore");
            options.AddAdditionalOption("unhandledAlertBehavior", "ignore");
            options.UnhandledPromptBehavior = UnhandledPromptBehavior.Ignore;//.Dismiss;
            */            
            //options.AddAdditionalCapability(CapabilityType.UnexpectedAlertBehavior, "ignore");   

            // https://stackoverflow.com/questions/60247155/how-to-bypass-the-message-your-connection-is-not-private-on-non-secure-page-us
            options.AddArgument("--ignore-ssl-errors=yes");
            options.AddArgument("--ignore-certificate-errors");
            // GOLDEN:
            //options.AddUserProfilePreference("plugins.always_open_pdf_externally", true);

            // added: March 28, 2024
            options.SetLoggingPreference("performance", LogLevel.All);
            //options.AddArgument("user-data-dir=C:\\");

            // BEGIN --->> ADDED: April 9, 2024
            // https://stackoverflow.com/questions/74237983/chromedriver-not-detecting-gps-location-as-insecure-origins-treated-as-secure
            //options.AddArgument("--unsafely-treat-insecure-origin-as-secure=http://10.100.10.152:8057");   
            options.AddArgument("--unsafely-treat-insecure-origin-as-secure="+CONSTANTlar.Sistemin_əsas_səhifə_URLi);   
            

            // END <<<--- ADDED: April 9, 2024 

            // BEGIN --->> ADDED: April 9, 2024
            /*
            // https://stackoverflow.com/questions/67492446/python-3-chrome-selenium-keep-downloaded-jar-file
            //options.AddArgument("--no-sandbox");
            //options.AddArgument("--ignore-certificate-errors");
            //options.AddArgument("--disable-infobars");
            //options.AddArgument("--disable-gpu"); // applicable to windows os only
            //options.AddArgument("start-maximized");
            //options.AddArgument("--disable-extensions");
            options.AddArgument("--disable-popup-blocking");
            options.AddArgument("--safebrowsing-disable-download-protection");
            //options.AddUserProfilePreference("safebrowsing", "disabled");

            // disable the banner "Chrome is being controlled by automated test software"
            // https://stackoverflow.com/questions/57298901/unable-to-hide-chrome-is-being-controlled-by-automated-software-infobar-within
            options.AddExcludedArgument("enable-automation");
            options.AddAdditionalOption("useAutomationExtension", false);

            // https://stackoverflow.com/questions/50642308/webdriverexception-unknown-error-devtoolsactiveport-file-doesnt-exist-while-t
            //options.AddArgument("--disable-dev-shm-usage"); // overcome limited resource problems
            //options.AddArgument("--remote-debugging-port=9222");

            // END <<<--- ADDED: April 9, 2024 
            */

            //Console.WriteLine("===== new ChromeDriver() setirden ONCE =====");
            driver = new ChromeDriver(CONSTANTlar.CHROME_DRIVER_PATH, options);
            //Console.WriteLine("===== new ChromeDriver() setirden SONRA =====");
            //driver = new FirefoxDriver("D:\\Code\\GeckoFirefoxDriver");
            
            driver.Manage().Window.Maximize();
            System.Drawing.Size fullScreenSize = driver.Manage().Window.Size; 

            if (CONSTANTlar.NUM_OF_MONITORS == 2 ) {
                driver.Manage().Window.Position = new System.Drawing.Point(-fullScreenSize.Width, 0);
                driver.Manage().Window.Maximize();
                //Saniyə_Gözlə(2);

                System.Drawing.Size size = driver.Manage().Window.Size; 
                size.Width = (int) (size.Width * 0.75);
                driver.Manage().Window.Size = size;
            }
            else if  (CONSTANTlar.NUM_OF_MONITORS == 1 ) {
               // driver.Manage().Window.Position = new System.Drawing.Point(0, 0);
                //driver.Manage().Window.Maximize();

                System.Drawing.Size size = driver.Manage().Window.Size; 
                size.Width = (int) (size.Width * 0.75);
                driver.Manage().Window.Position = new System.Drawing.Point(0, 0);
                driver.Manage().Window.Size = size;
            }
            //driver.Manage().Window.Position = new System.Drawing.Point(-1000, 0);
            //driver.Manage().Window.Maximize();
            TestLogaYaz("===== Chrome açıldı ve maksimize oldu=====");

        }

        [Step("Chrome'u bağla")]
        public void Chrome_u_bağla()
        {
            TestLogaYaz("===== Chrome bağlanır =====");
            // Chromeu bağla
            //MP3_oyna("Bu test bitdi. Kırom brauzer pəncərəsini bağlayıram");
            driver.Quit();
        }
        [Step("Cari Chrome ekranini bağla")]
        public void Cari_Chrome_ekranini_bağla()//Chrome_u_bağla()
        {
            TestLogaYaz("===== Cari Chrome ekranini bağlayıram =====");
            // Chromeu bağla
            //MP3_ona("Bu test bitdi. Kırom brauzer pəncərəsini bağlayıram");
            if (driver == null)             
                TestLogaYaz("===== Chrome əvvəlden ARTIQ bağlanıb, tekrar bağlana bilmez! =====");
            else {
                if (!driver.ToString().Contains("(null)")) {
                    TestLogaYaz("===== Chrome əvvəlden bağlanmayıb. INDI bağlanır =====");
                    // close() closes only the current window on which Selenium is running automated tests. The WebDriver session, however, remains active. 
                    // On the other hand, the driver. quit() method closes all browser windows and ends the WebDriver session

                    driver.Close();
                    //driver.Quit();
                }
            }
               
        }

        public static List<int> string_all_indexes_of_substring(string str, string value) {
            if (String.IsNullOrEmpty(value))
                throw new ArgumentException("the string to find may not be empty", "value");
            List<int> indexes = new List<int>();
            for (int index = 0;; index += value.Length) {
                index = str.IndexOf(value, index);
                if (index == -1)
                    return indexes;
                indexes.Add(index);
            }
        }        

        // https://stackoverflow.com/questions/2571716/find-nth-occurrence-of-a-character-in-a-string
        public int StringGetNthIndexOfCharFromIndex(string str, char ch, int n, int fromIndex)
        {
            int count = 0;
            for (int i = fromIndex; i < str.Length; i++)
            {
                if (str[i] == ch)
                {
                    count++;
                    if (count == n)
                    {
                        return i;
                    }
                }
            }
            return -1; // did not find it
        } 

        [Step("Raporlama ekranının dataları üçün-XHR requestləri təhlil et: raporlama_ekranı=<raporlama_ekranı>")]
        public void XHR_requestləri_təhlil_et(String raporlama_ekranı) {
            // https://stackoverflow.com/questions/77425823/get-the-headers-of-requests-in-selenium-at-c-sharp
            var performanceLogs = driver.Manage().Logs.GetLog("performance");
            // Find Specific Request
            //var jsonText = performanceLogs.Where(p => p.Message.Contains("DXXRDV?actionKey=getPage")).FirstOrDefault(); // "some of the api url or the header name"
            
            Console.WriteLine("-----------------\nRaporlama ekranının dataları üçün-XHR requestləri təhlil et\nRaporlama_ekranı = " + raporlama_ekranı +  "\n-----------------");
            
            int num=0;
            string JSON_file_URLi = "bosh";
            foreach  (OpenQA.Selenium.LogEntry entry in performanceLogs) {
                // https://chromedriver.chromium.org/logging/performance-log
                String entry_string = entry.ToString();
                if (entry_string.Contains("Atrue%7D")) {
                    Console.WriteLine("--------------------------------------------------------------------\n");
                    /*Console.WriteLine(entry_string);
                    Console.WriteLine("--------------------------------------------------------------------\n");
                    Console.WriteLine("entry_string length = " + entry_string.Length);
                    Console.WriteLine("--------------------------------------------------------------------\n");*/
                    
                    // http://10.100.10.62:649/DXXRDV?actionKey
                    int position_start = entry_string.IndexOf("http://10.100.10.62:649/DXXRDV?actionKey");
                    int position_len = entry_string.IndexOf("Atrue%7D") + 8 - position_start;

                    Console.WriteLine("position_start="+ position_start);
                    Console.WriteLine("position_len="+ position_len);

                    JSON_file_URLi = entry_string.Substring(position_start, position_len);

                    Console.WriteLine("JSON_file_URLi="+ JSON_file_URLi);

                }
                num++;
            }
            Console.WriteLine("\nXHR requestlərin sayi (# of performanceLogs) = "+ num);
            //Console.WriteLine("XHR_requestləri_təhlil_et-JSON text: " + jsonText);

            Console.WriteLine("-----------------");
            if (! JSON_file_URLi.Equals("bosh")) {
                // yeni bir URL almis yuxari koddan
                string JSON_faylin_məzmunu;
                Console.WriteLine("JSON fayli server'den oxuyuram...");

                using(System.Net.WebClient client = new WebClient()) {
                    JSON_faylin_məzmunu = client.DownloadString(JSON_file_URLi);
                }
                Console.WriteLine("JSON fayli server'den oxudum");

                //https://stackoverflow.com/questions/62429809/is-there-a-more-elegant-way-to-get-specific-value-from-json-object-using-system
                
                //Console.WriteLine("JSON_faylin_məzmunu = "+ JSON_faylin_məzmunu);

                /* bizim istedigimiz deyerler bunlar:
                ...
                    "content": [
                        {
                          "Key": "text",
                          "Value": "Hesab"
                        }
                        ...
                */
                Console.WriteLine("JSON'da 'value' deyerlerini axtariram...");

                List<int> value_deyerlerin_indeksleri = string_all_indexes_of_substring(JSON_faylin_məzmunu, "\"Value\"");

                Console.WriteLine("JSON'da 'value' deyerlerin sayisi = " + value_deyerlerin_indeksleri.Count);

                foreach  (int index in value_deyerlerin_indeksleri) {
                    //Console.WriteLine("'value' indeksi = "+ index);

                    // index+8 den sonra ""-i axtar
                    //   --> "Value": "Kart hesabı :"
                    //   cunku, "Value":-in uzunlugu 8 char'dir
                    //   
                    // ikiqat sitatlar = double quote
                    int ilk_double_quote_indeksi_value_dan_sonra = 
                    StringGetNthIndexOfCharFromIndex(JSON_faylin_məzmunu, '\"', 1, index+8);
                    int ikinci_double_quote_indeksi_value_dan_sonra = 
                    StringGetNthIndexOfCharFromIndex(JSON_faylin_məzmunu, '\"', 2, index+8);

                    if (ikinci_double_quote_indeksi_value_dan_sonra == ilk_double_quote_indeksi_value_dan_sonra+1) // yeni "", ve metn bosdur
                        ;
                        // ekrana metni yazma
                    else  {// ekrana metni yaz
                        
                        string value_qarşısında_mətn=JSON_faylin_məzmunu.Substring(ilk_double_quote_indeksi_value_dan_sonra+1, ikinci_double_quote_indeksi_value_dan_sonra - ilk_double_quote_indeksi_value_dan_sonra-1); //  (int startIndex, int length);

                        Console.WriteLine("'value' indeksi = "+ index);
                        Console.WriteLine("\t'value' qarşısında mətn = "+ value_qarşısında_mətn);
                        Console.WriteLine("\n");
                    }
                }
                
                // https://stackoverflow.com/questions/61497025/c-sharp-iterate-over-a-json-object

                //another method:
                // https://stackoverflow.com/questions/1048199/easiest-way-to-read-from-a-url-into-a-string-in-net
                
                    
            }

        }

        [Step("Yeni acilan browser tab'ini bagla")]
        public void Yeni_acilan_browser_tab_ini_bagla() {
            String ataPencere = driver.WindowHandles[0]; // parent
            TestLogaYaz("ataPencere=" + ataPencere);
            try {
                String usaqPencere  = driver.WindowHandles[1]; // child
                TestLogaYaz("usaqPencere=" + usaqPencere);
                driver.SwitchTo().Window(usaqPencere);  // child
                TestLogaYaz("Uşaq pəncərə'yə keçirəm");
                driver.Close();
                TestLogaYaz("Uşaq pəncərə bağlandı");            
            }
            catch (Exception e) {
                Xatayı_Xata_Faylına_Yaz("yeni_acilan_tab_i_bagla=Usaq pencere ya acilmamis, ya gec acilmis, ya yavasdi... xeta=" + e.Message);
            }


            driver.SwitchTo().Window(ataPencere); 
            TestLogaYaz("Ata pencereye gecirem");

        }
        [Step("Yeni açılan browser tab'inə geç")]
        public void Yeni_açılan_browser_tab_ina_geç() {
            tablar_arası_geçiş_əvvəlki_tab_burda_yadda_saxlanır = driver.WindowHandles[0]; // parent

            Test_Logda_Xet_Yaz();
            TestLogaYaz("Yeni_açılan_browser_tab_ina_geç  --  Əvvəlki_tab=" + tablar_arası_geçiş_əvvəlki_tab_burda_yadda_saxlanır);
            try {
                String yeni_açılan_tab  = driver.WindowHandles[1]; // child
                TestLogaYaz("yeni_açılan_tab=" + yeni_açılan_tab);

                TestLogaYaz("Yeni açılan tab'ə keçirəm");

                driver.SwitchTo().Window(yeni_açılan_tab);  // child

                TestLogaYaz("Yeni açılan tab'ə UĞURLU keçdim");

            }
            catch (Exception e) {
                Xatayı_Xata_Faylına_Yaz("Yeni_açılan_browser_tab_e_geç=Usaq pencere ya acilmamis, ya gec acilmis, ya yavasdi... xeta=" + e.Message);
            }
        }

        [Step("Yeni açılan browser tab'i bağla, və əvvəlki taba gəri dön")]
        public void Yeni_açılan_browser_tabini_bağla_və_əvvəlki_taba_gəri_dön() {
            // Yeni açılan browser tab'i bağla    
     
            TestLogaYaz("əvvəlki_tab=" + tablar_arası_geçiş_əvvəlki_tab_burda_yadda_saxlanır);
            TestLogaYaz("Yeni açılan tabı bağlayıram"); 
            //driver.SwitchTo().Window(driver.WindowHandles[1]); 
            driver.Close();
            driver.SwitchTo().Window(tablar_arası_geçiş_əvvəlki_tab_burda_yadda_saxlanır);            
            TestLogaYaz("Yeni açılan tabı bağladım"); 

            //TestLogaYaz("Biraz dözub və ana (əvvəlki) taba gəri dönürəm indi...");
            //Thread.Sleep(1000); 


            //driver.SwitchTo().Window(tablar_arası_geçiş_əvvəlki_tab_burda_yadda_saxlanır);
            TestLogaYaz("Əvvəlki taba gəri döndüm");
        }

        [Step("XPath ilə verilən obyekti səhifəyə gəlməsini gözlə: <obyekt_XPathi>")]
        public void XPath_ilə_verilən_obyekti_səhifəyə_gəlməsini_gözlə(String obyekt_XPathi) 
        {
            TestLogaYaz("XPath ilə verilən obyekti səhifəyə gəlməsini gözlə: obyekt_XPathi");
            //MP3_oyna("Ekranın açılmasını gözləyirəm");

            new WebDriverWait(driver, TimeSpan.FromSeconds(30)).Until(
                    ExpectedConditions.ElementIsVisible(By.XPath(obyekt_XPathi)));
            TestLogaYaz("XPath ilə verilən obyekti səhifəyə gəlməsini gözlədim və obyekt GELDI"); 
        }   

        [Step("Yeni açılan browser tab'i aç, heç bir iş etmədən bağla, və əvvəlki taba gəri dön")]
        public void Yeni_acilan_browser_tabi_aç_heç_iş_etmədən_bağla_və_əvvəlki_taba_gəri_dön() {
            String əvvəlki_tab = driver.WindowHandles[0]; // parent
            TestLogaYaz("əvvəlki_tab=" + əvvəlki_tab);
            try {
                String yeni_açılan_tab  = driver.WindowHandles[1]; // child
                TestLogaYaz("yeni_açılan_tab=" + yeni_açılan_tab);
                driver.SwitchTo().Window(yeni_açılan_tab);  // child
                TestLogaYaz("yeni_açılan_tab'a geçirəm");
                driver.Close();
                TestLogaYaz("yeni_açılan_tabi bağladım");            
            }
            catch (Exception e) {
                Xatayı_Xata_Faylına_Yaz("yeni_acilan_tab_i_bagla= yeni_açılan_tab ya açılmamış, ya geç açılmış, ya yavaşdı... xeta=" + e.Message);
            }

            driver.SwitchTo().Window(əvvəlki_tab); 
            TestLogaYaz("Əvvəlki taba gəri döndüm");

        }

        readonly int ___AutoIt_əməliyyatları;      


        [Step("AutoIt test faylını calışdır: <EXE_fayl_pathi>; test_case_adı=<test_case_adı>; parameter=<parameter>; əlavə iş=<əlavə_iş>")]
        public void AutoIt_test_faylını_calışdır (string AutoIt_EXE_fayl_ismi, string test_case_adı, string parameter, string əlavə_iş){   
 
Console.WriteLine("AutoIt_test_faylını_calışdır... ");
 
            if (parameter == "indiki tarix ve saat") {
                DateTime indi_tarix_ve_saat = DateTime.UtcNow;
                parameter = indi_tarix_ve_saat.ToString("yyyy-MM-dd--HH-mm-ss");
            }

            /*if (parameter.Contains("Yüklənəcək input fayl=")) {
                parameter = parameter.Substring( parameter.IndexOf("=")+1 );
            }*/
            
            Console.WriteLine("parameter = " + parameter);

            //MP3_oyna("Oto it test faylını calışdırıram");
            //Console.WriteLine("current_directory 1 = " + Directory.GetCurrentDirectory());

            String AutoIt_file_to_run = GLOBAL_project_working_dir + "\\AUTOIT_otomasyon_kodlari\\" + AutoIt_EXE_fayl_ismi;
            
            Console.WriteLine("\nAutoIt_file_to_run = " + AutoIt_file_to_run);

            Directory.SetCurrentDirectory(GLOBAL_project_working_dir + "\\AUTOIT_otomasyon_kodlari\\");

            String current_working_dir = Directory.GetCurrentDirectory();
            //Console.WriteLine("current_working_dir = " + current_working_dir);

            ProcessStartInfo startInfo = new ProcessStartInfo(AutoIt_file_to_run);

            startInfo.Arguments = test_case_adı + " " + parameter;
            Console.WriteLine("process startInfo.Arguments = " + test_case_adı + " " + parameter);

            Dəyişgən_və_dəyərini_yadda_saxla("test_case_adı", test_case_adı);

            //startInfo.WindowStyle = ProcessWindowStyle.Hidden;
            //startInfo.UseShellExecute = false;
            //startInfo.RedirectStandardError = true;

            // run AutoIt file
            // cd D:\ŞİRKETLER\ProSys\Code\Gauge\FMS\AUTOIT_otomasyon_kodlari
            using Process exeProcess = Process.Start(startInfo);
            exeProcess.WaitForExit();
            
            string XLS_file_full_path = "";

            if (parameter != "") {
                //MP3_oyna("Oto it test faylı calışması tamamlandı");

                string project_working_dir_IKI_SLASH = GLOBAL_project_working_dir.Replace(@"\", @"\\");
                
                //parameter = "2023-10-30--11-13";
                XLS_file_full_path = project_working_dir_IKI_SLASH + "\\\\TESTLƏRDƏ_ƏNDİRİLƏN_VƏ_YOXLANAN_XLS_FAYLLAR\\\\" + test_case_adı + "--" + parameter + ".xlsx";

                Console.WriteLine("\n\nFonksyon AutoIt_test_faylını_calışdır: XLS_file_full_path = " + XLS_file_full_path+"\n");

            }
            if (əlavə_iş == "Excel fayl ismini 'Əndirilmiş Excel fayl-Full path' dəyişgəndə saxla")
                    Dəyişgən_və_dəyərini_yadda_saxla("Əndirilmiş Excel fayl-Full path", XLS_file_full_path);
                    
            Console.WriteLine("AutoIt_test_faylını_calışdır : Orijinal project_working_dir ə geri dönürəm ..."); 
            
            Directory.SetCurrentDirectory(GLOBAL_project_working_dir);
            //current_working_dir = Directory.GetCurrentDirectory();
            //Console.WriteLine("current_working_dir = " + current_working_dir);
            
        }

        readonly int ___XANALAR_əməliyyatları;      

        [Step("Cari xananı təmizlə")]
        public void Cari_xananı_təmizlə()
        {
                Actions actions = new Actions(driver); 
                actions.KeyDown(Keys.Control);
                actions.SendKeys("a");
                actions.KeyUp(Keys.Control);

                actions.SendKeys(Keys.Delete);
                actions.Perform();
        }

        [Step("Əgər bu siyahi xanası boşsa (XPath = <siyahi_XPathi> ), digər XPath = <digər_xana_XPathi> olan xananın dəyərini dəyiş və təkrar cəhd et")]
        public void Əgər_siyahi_xana_boşsa_digər_xananın_dəyərini_dəyiş(string siyahi_XPathi, string digər_siyahi_xana_XPathi)
        {
                System.Console.WriteLine("Əgər_siyahi_xana_boşsa_digər_xananın_dəyərini_dəyiş: siyahi_XPathi = " + siyahi_XPathi);                
                System.Console.WriteLine("Əgər_siyahi_xana_boşsa_digər_xananın_dəyərini_dəyiş: digər_siyahi_xana_XPathi = " + digər_siyahi_xana_XPathi);

                bool hele_de_siyahi_xanasi_bosdu;
                int secilecek_elementin_indeksi= 1;
                do
                {
                    // siyahi_XPathi boş oldugunu yoxla
                    IList <IWebElement> məlumat_yoxdur_var_mi_yox_mu = driver.FindElements(
                    By.XPath("//*[@id= //input[@id='cmbContracts']/@aria-owns]//*[text()='Məlumat yoxdur']"));
                    if (məlumat_yoxdur_var_mi_yox_mu.Count > 0) { // yani siyahi xana boşdu
                        MP3_oyna("Cari siyahı xana boşdur, çünki Məlumat Yoxdur ifadəsi göründü. Siyahı xananı müəyyən edən digər xananı dəyişdirib və təkrar cəhd edirəm");
                        hele_de_siyahi_xanasi_bosdu = true;

                        // Siyahı xananı müəyyən edən digər siyahiye klik et
                        OBYEKTƏ_vur_XPath_ilə_1_KLIK(digər_siyahi_xana_XPathi);
                        
                        // digər siyahide, random bir secim et
                        
                        string XPath_indiki = "//*[@id= "+  digər_siyahi_xana_XPathi+ "/@aria-owns]//*[@role='option']";

                        System.Console.WriteLine("-----------\nƏgər_siyahi_xana_boşsa_digər_xananın_dəyərini_dəyiş: digər_siyahinin_elementleri = " + XPath_indiki);

                        IList <IWebElement> digər_siyahinin_elementleri = 
                        driver.FindElements(By.XPath(XPath_indiki));

                        System.Console.WriteLine("-----------\nƏgər_siyahi_xana_boşsa_digər_xananın_dəyərini_dəyiş: digər_siyahinin_elementler sayisi = " + digər_siyahinin_elementleri.Count);

                        secilecek_elementin_indeksi ++;
                        // secilecek_elemente klik et
                        XPath_indiki = "//*[@id= "+  digər_siyahi_xana_XPathi+ "/@aria-owns]//*[@role='option'][" + secilecek_elementin_indeksi.ToString() + "]";

                        System.Console.WriteLine("-----------\nƏgər_siyahi_xana_boşsa_digər_xananın_dəyərini_dəyiş: secilecek_elementin_indeksi = " + XPath_indiki);

                        OBYEKTƏ_vur_XPath_ilə_1_KLIK(XPath_indiki);

                        Saniyə_Gözlə(3); // ki esas siyahi update olsun

                        // tekrar siyahiye click et, ki acilsin
                        OBYEKTƏ_vur_XPath_ilə_1_KLIK(siyahi_XPathi);
                    }
                    else //  məlumat_yoxdur_var_mi_yox_mu.Count = 0
                        hele_de_siyahi_xanasi_bosdu = false;

                } while (hele_de_siyahi_xanasi_bosdu);
        }

        readonly int ___DƏYİŞGƏN_əməliyyatları;      

        [Step("Dinamik dəyər hesabla və dəyişgən olaraq yadda saxla: dinamik dəyər tipi = <dinamik_dəyər_tipi>; dəyişgən = <dəyişgən>")]
        public void Dinamik_dəyər_hesabla_və_dəyişgən_olaraq_yadda_saxla(string dinamik_dəyər_tipi, string dəyişgən) {
            if (dinamik_dəyər_tipi == "Indiki-tarix-və-zaman") {
                    DateTime indikiTarixVeSaat_DateObject = DateTime.Now;
                    string dəyər = indikiTarixVeSaat_DateObject.ToString(
                        "yyyy/MM/dd-HH:mm");                      
                    
                    Dəyişgən_və_dəyərini_yadda_saxla(dəyişgən, dəyər);
            }
            else
                Xatayı_Xata_Faylına_Yaz("Dinamik_dəyər_hesabla_və_dəyişgən_olaraq_yadda_saxla: yalnış dinamik_dəyər_tipi = " + dinamik_dəyər_tipi + "---- dəyişgən = " + dəyişgən);
        }

        [Step("Dəyişgən və dəyərini yadda saxla: <Dəyişgən> = <dəyər>")]
        public void Dəyişgən_və_dəyərini_yadda_saxla(string Dəyişgən, string dəyər) {
            
            Test_Logda_Xet_Yaz();
            if (Əsnək_String_Dəyişgənlər_Cədvəli.ContainsKey(Dəyişgən)) {
                        Console.WriteLine("Dəyişgən_və_dəyərini_yadda_saxla --- Dəyişgən_və_dəyərini_yadda_saxla: Dəyişgən hafizədə VAR ZATEN.");

                        Console.WriteLine("Eski dəyəri=" + Əsnək_String_Dəyişgənlər_Cədvəli[Dəyişgən]);

                        Əsnək_String_Dəyişgənlər_Cədvəli[Dəyişgən] = dəyər;
                        Console.WriteLine("Dəyişgən_və_dəyərini_yadda_saxla --- Dəyişgən və dəyəri hafizəde UPDATE edildi: " + Dəyişgən + "=" + dəyər);
                    }
                    else {
                        Əsnək_String_Dəyişgənlər_Cədvəli.Add(Dəyişgən, dəyər);
                        Console.WriteLine("Dəyişgən_və_dəyərini_yadda_saxla --- Dəyişgən və dəyəri hafizəyə ƏLAVƏ edildi: " + Dəyişgən + "=" + dəyər);
                    }
        }


        readonly int ___FAYL_əməliyyatları;   

        [Step("Faylı OS'də aç: path_ve_file_ismi = <path_ve_file_ismi>")]
        public void Faylı_OS_də_aç_full_path(string path_ve_file_ismi)
        {
            Test_Logda_Xet_Yaz();
            System.Console.WriteLine("Faylı_OS_də_aç_full_path: path_ve_file_ismi = " + path_ve_file_ismi);
            // path ve file_ismi ayirt
            // d:\\ŞİRKETLER\\ProSys\\Code\\Gauge\\FMS\\TESTLƏRDƏ_ƏNDİRİLƏN_VƏ_YOXLANAN_XLS_FAYLLAR\\2023-12-09--10-34-06.xlsx
            int pathFromIndex = 0;
            //path_ve_file_ismi.IndexOf("key : ") + "key : ".Length;
            int pathToIndex = path_ve_file_ismi.LastIndexOf("\\");
            String path = path_ve_file_ismi.Substring(pathFromIndex, pathToIndex - pathFromIndex);
            System.Console.WriteLine("Faylı_OS_də_aç_full_path: path = " + path);

            String file_ismi = path_ve_file_ismi.Substring(pathToIndex+1, path_ve_file_ismi.Length - (pathToIndex+1));
            
            System.Console.WriteLine("Faylı_OS_də_aç_full_path: file_ismi = " + file_ismi);

            Faylı_OS_də_aç(path, file_ismi);

        }
        
        [Step("Faylı OS'də aç: full_fayl_path, bu dəyişgəndə: <dəyişgən>")]
        public void Faylı_OS_də_aç__fayl_adi_bu_dəyişgəndə(string dəyişgən)
        {
            Test_Logda_Xet_Yaz();
            Faylı_OS_də_aç_full_path(Əsnək_String_Dəyişgənlər_Cədvəli[dəyişgən]);
        }  

        [Step("Faylı OS'də aç: projə_folderindən başlayan path = <path>; file_ismi=<file_ismi>")]
        public void Faylı_OS_də_aç_projə_folderindən_başlayan_path(string projə_folderindən_başlayan_path, string file_ismi)
        {
            Test_Logda_Xet_Yaz();
            System.Console.WriteLine("Faylı_OS_də_aç_projə_folderindən_başlayan_path: path = " + projə_folderindən_başlayan_path);
            System.Console.WriteLine("Faylı_OS_də_aç_projə_folderindən_başlayan_path: file_ismi = " + file_ismi);
            //MP3_oyna("İstənilən faylı açıram");
            String current_working_dir ;

            try {

                Directory.SetCurrentDirectory(GLOBAL_project_working_dir + projə_folderindən_başlayan_path);
                
                //current_working_dir = Directory.GetCurrentDirectory();
                //Console.WriteLine("current_working_dir = " + current_working_dir);

                new Process
                        {
                            StartInfo = new ProcessStartInfo(file_ismi)
                            {
                                UseShellExecute = true
                            }
                        }.Start();
            }
            catch (Exception e) {
                System.Console.WriteLine("Faylı_OS_də_aç_projə_folderindən_başlayan_path: XATA = " + e.Message);
                MP3_oyna("İstənilən faylı açmaqda xata baş verdi");
            }

            //Console.WriteLine("Faylı_OS_də_aç_projə_folderindən_başlayan_path : Orijinal project_working_dir ə geri dönürəm ..."); 

            Directory.SetCurrentDirectory(GLOBAL_project_working_dir);
            //current_working_dir = Directory.GetCurrentDirectory();
            //Console.WriteLine("current_working_dir = " + current_working_dir);
        }

        [Step("Faylı OS'də aç: path = <path>; file_ismi=<file_ismi>")]
        public void Faylı_OS_də_aç(string path, string file_ismi)
        {
            Test_Logda_Xet_Yaz();
            System.Console.WriteLine("faylı_OS_də_aç: full_path = " + path);
            System.Console.WriteLine("faylı_OS_də_aç: file_ismi = " + file_ismi);
            //MP3_oyna("İstənilən faylı açıram");

            Console.WriteLine("faylı_OS_də_aç : project_working_dir = " + GLOBAL_project_working_dir);   

            String current_working_dir;

            try {

                Directory.SetCurrentDirectory(path);
                
                current_working_dir = Directory.GetCurrentDirectory();
                //Console.WriteLine("current_working_dir = " + current_working_dir);

                /* Aprel 4, 2024de Vehid refactor etdi
                new Process
                        {
                            StartInfo = new ProcessStartInfo(file_ismi)
                            {
                                UseShellExecute = true
                            }
                        }.Start();
                */
                
                ProcessStartInfo processStartInfo= new ProcessStartInfo(file_ismi)
                            {
                                UseShellExecute = true
                            };
                using Process exeProcess = Process.Start(processStartInfo);

                exeProcess.WaitForExit(20000);
            }
            catch (Exception e) {
                System.Console.WriteLine("Faylı_OS_də_aç: XATA = " + e.Message);
                MP3_oyna("İstənilən faylı açmaqda xata baş verdi");
            }

            //Console.WriteLine("faylı_OS_də_aç : Orijinal project_working_dir ə geri dönürəm ..."); 
            
            Directory.SetCurrentDirectory(GLOBAL_project_working_dir);
            //current_working_dir = Directory.GetCurrentDirectory();
            //Console.WriteLine("current_working_dir = " + current_working_dir);

        }

        [Step("JavaScript kodu çalışdır: <JavaScript_kodu>")]
        public void JavaScript_kodu_çalışdır(string JavaScript_kodu) {
            TestLogaYaz("JavaScript_kodu_çalışdır: JavaScript_kodu = " + JavaScript_kodu);

            ((IJavaScriptExecutor) driver).ExecuteScript(JavaScript_kodu); 
            
            TestLogaYaz("JavaScript kodu çalışdırıldı: " + JavaScript_kodu);
        }

        readonly int ___VURMAQ_KLİKLMƏK_əməliyyatları;   

        [Step("Dəyişgən ilə, dinamik XPath yarat: dəyişgən=<dəyişgən>; XPath_tipi=<XPath_tipi>; yeni_XPath_dəyişgən=<yeni_XPath_dəyişgən>")]
        public void Dəyişgən_ilə_dinamik_XPath_yarat(string dəyişgən, string XPath_tipi, string yeni_XPath_dəyişgən) {
            //IWebElement element;
            string yeni_XPath = "";

            Console.WriteLine("Dəyişgən_ilə_dinamik_XPath_yarat --- dəyişgən dəyəri=" + Əsnək_String_Dəyişgənlər_Cədvəli[dəyişgən]);

            // if (XPath_tipi.CompareTo("14.1-Xərclər soraqçası-Redaktə düyməsi") == 0)
            if (XPath_tipi.Contains("Redaktə düyməsi") || XPath_tipi.Contains("Edit düyməsi"))

                yeni_XPath = "//td[text()[contains(., '" + Əsnək_String_Dəyişgənlər_Cədvəli[dəyişgən] + "')]]/parent::tr//app-cell-edit";

            //if (XPath_tipi.CompareTo("14.1-Xərclər soraqçası-SIL düyməsi") == 0)
            else if  (XPath_tipi.Contains("Sil düyməsi"))
                yeni_XPath = "//td[text()[contains(., '" + Əsnək_String_Dəyişgənlər_Cədvəli[dəyişgən] + "')]]/parent::tr//app-cell-delete";

            Dəyişgən_və_dəyərini_yadda_saxla(yeni_XPath_dəyişgən, yeni_XPath);

        }


        [Step("Düyməyə vur (mətn ilə): <düymə_mətni>")]
        public void Düyməyə_vur_mətn_ilə(string düymə_mətni) {
            IWebElement element;

            TestLogaYaz("Düyməyə vururam (mətn ilə): " + düymə_mətni);

            try {

                element= new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI * 3)).Until(
                    ExpectedConditions.ElementToBeClickable(
                        By.XPath("//*[contains(text(), '" + düymə_mətni + "')]")));
                
                TestLogaYaz("\t->Düymə tapıldı...");

                if (!IsElementVisibleInViewport(element))
                    ((IJavaScriptExecutor) driver).ExecuteScript(
                        "arguments[0].scrollIntoView();", element);

                element =new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI * 3)).Until(
                    ExpectedConditions.ElementToBeClickable(
                        By.XPath("//*[contains(text(), '" + düymə_mətni + "')]")));

                ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid "+ CONSTANTlar.UI_DA_DUYMEYE_VURMA_KƏNAR_RƏNGI +"'", element);

                TestLogaYaz("\t->Düymə renglendirildi...");

                element = new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI * 3)).Until(
                    ExpectedConditions.ElementToBeClickable(
                        By.XPath("//*[contains(text(), '" + düymə_mətni + "')]")));
                        
                Saniyə_Gözlə(1);
                
                try {
                    ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid white'", element);
                    }
                catch (Exception) {

                }  
                element = new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI * 3)).Until(
                    ExpectedConditions.ElementToBeClickable(
                        By.XPath("//*[contains(text(), '" + düymə_mətni + "')]")));          
            
                element.Click();
                
                TestLogaYaz("\t->Düymə vuruldu...");

            }
            catch (Exception) {

            } 

        }

        public void OBYEKTƏ_sag_klik_et_element_ilə(IWebElement element) {
            TestLogaYaz("OBYEKTƏ_sag_klik_et_element_ilə: " );

            MP3_oyna("Obyektə sağ klikləyirəm");
            Actions actions = new Actions(driver);
            //IWebElement element = driver.FindElement(By.Id(obyekt_id));
            actions.ContextClick(element).Perform();
        }

        [Step("Obyektə sag-klik et (XPath ilə): <obyekt_XPath>")]
        public void OBYEKTƏ_sag_klik_et_XPath_ilə(string obyekt_XPath) {
            TestLogaYaz("OBYEKTƏ_sag_klik_et_XPath_ilə: " );
            TestLogaYaz("obyekt_XPath= " + obyekt_XPath);

            try {
                OBYEKTƏ_sag_klik_et_element_ilə(driver.FindElement(By.XPath(obyekt_XPath)));
            }
            catch(Exception e){
                    //TestLogaYaz("OBYEKTƏ_sag_klik_et_XPath_ilə -> XATA: " + e.Message );  
                    Xatayı_Xata_Faylına_Yaz("OBYEKTƏ_sag_klik_et_XPath_ilə: obyekt_XPath = " + obyekt_XPath + "-- XATA: " + e.Message);
                    MP3_oyna("Ciddi xata göründü. OBYEKTƏ klikləmə funksiyasında obyekt tapılmadı-... test otomasyon durmaq məcburiyyətindədir");    
                    //driver.Quit();
                    if (CONSTANTlar.CIDDI_XATALARDA_TESTI_FAIL_ET)
                        Assert.Fail();
                }
        }


        [Step("Obyektə vur (class ilə): <class_ismi>")]
        public void OBYEKTƏ_vur_Class_ilə(string class_ismi) {
            //string class_ismi = UI_IDs.Class_ID_cədvəli[class_IDsi];

            TestLogaYaz("OBYEKTƏ_vur_Class_ID_ilə:" );
            TestLogaYaz("class_ismi=" + class_ismi);

            try {
                new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                ExpectedConditions.ElementToBeClickable(By.ClassName(class_ismi)));
                    //By.Id("PageControlAddEdit_richEditDescription_View")));
                TestLogaYaz("OBYEKTƏ_vur_Class_ilə:" + class_ismi + " tapildi...");
                driver.FindElement(By.ClassName(class_ismi)).Click();
            }
            catch (Exception e) {
                Console.Write("OBYEKTƏ_vur_Class_ilə: Obyekt tapilmadi: " + e.Message);
            }
        }


        //ANAR BELE YAZMISDI: [Step("Obyektə vur CSS label ilə: <cssLabel>")]
        [Step("Obyektə vur (CSS label ilə): <cssLabel>")]
        // kod daha consistent olsun, Vahidminor revize etdi fonksyon adini
        public void OBYEKTƏ_vur_CSS_label_ile(string cssLabel)
        {
            try
            {
                driver.FindElement(By.CssSelector(cssLabel)).Click();
            }
            catch (NoSuchElementException)
            {
                throw new NoSuchElementException($"Element with CSS selector '{cssLabel}' not found");
            }
            catch (Exception ex)
            {
                throw new Exception($"An error occurred: {ex.Message}");
            }
        }

        // OLD NAME: [Step("Obyektə vur (CSS label ilə): <CSS_label>; click sayısı=<neçə_click>")]
        // OBYEKTƏ_vur_CSS_label_ile
        [Step("Obyektə vur (CSS aria label ilə): <CSS_label>; click sayısı=<neçə_click>")]
        public void OBYEKTƏ_vur_CSS_aria_label_ile(string CSS_label) 
        {
            Test_Logda_Xet_Yaz();
            TestLogaYaz("OBYEKTƏ_vur_CSS_label_ile: " );
            TestLogaYaz(CSS_label);
            try {
                driver.FindElement(By.CssSelector("[aria-label="+ CSS_label+ "]")).Click();
            }
            catch(TimeoutException toe){
                    MP3_oyna("Vurmaq istədiyim obyekt, ekranda tapılmadı");
                    TestLogaYaz("OBYEKTƏ_vur_CSS_label_ile -> TimeoutException: " + toe.Message );                       
            }
            catch(Exception e){
                TestLogaYaz("OBYEKTƏ_vur_CSS_label_ile -> XATA: " + e.Message );      
            }
        }

        [Step("Obyektə vur (XPath ilə): <obyekt_XPath>")]
        public void OBYEKTƏ_vur_XPath_ilə_1_KLIK(string obyekt_XPath) {
            OBYEKTƏ_vur_XPath_ilə(obyekt_XPath, "1-click");
        }

        [Step("Obyektə 2-KLIK vur (XPath ilə): <obyektə_XPath>")]
        public void OBYEKTƏ_vur_XPath_ilə_2_KLIK(string obyekt_XPath) {
            OBYEKTƏ_vur_XPath_ilə(obyekt_XPath, "2-click");
        }

        public void OBYEKTƏ_vur_XPath_ilə(string obyekt_XPath, string neçə_click="1-click") {
            
            //MP3_oyna("Mouse click");

            Test_Logda_Xet_Yaz();
            TestLogaYaz("OBYEKTƏ_vur_XPath_ilə: " );
            TestLogaYaz("OBYEKT_XPathi = " + obyekt_XPath);

            try { 
                new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                    ExpectedConditions.ElementToBeClickable(
                        By.XPath(obyekt_XPath)));

                IWebElement obyekt = driver.FindElement(By.XPath(obyekt_XPath));

                if (!IsElementVisibleInViewport(obyekt)) {
                    TestLogaYaz("OBYEKTƏ_vur_XPath_ilə: Axtarılan obyektə ekran var, amma görünmür. Ona scroll edirəm: " + obyekt_XPath);

                    ((IJavaScriptExecutor) driver).ExecuteScript(
                        "arguments[0].scrollIntoView();", obyekt);

                }

                TestLogaYaz("OBYEKTƏ_vur_XPath_ilə: Obyekt tapıldı...");

                OBYEKTƏ_fokuslaş_və_kənarin_rəngləndir(obyekt, CONSTANTlar.UI_DA_YAZI_YOXLAMA_KƏNAR_RƏNGI);
                
                MP3_oyna_durmadan("Mouse click");


                // asagidaki "MoveToElement", "move target out of bounds" xatasi verrirdi...
                // cozum: https://stackoverflow.com/questions/69975806/org-openqa-selenium-interactions-movetargetoutofboundsexception-move-target-out


                obyekt = driver.FindElement(By.XPath                
                            (obyekt_XPath));
                if (neçə_click == "1-click" || neçə_click == "1") {
                        //Actions actions = new Actions(driver);
                        //actions.MoveToElement(obyekt).Click().Build().Perform();
                        try {
                            obyekt.Click();
                        }
                        catch(StaleElementReferenceException){
                                TestLogaYaz("OBYEKTƏ_vur_XPath_ilə: Obyektə_vur_XPath_ilə: StaleElementReferenceException verdi");
                                
                                obyekt = driver.FindElement(By.XPath   (obyekt_XPath));

                                obyekt.Click();
                        }
                        //MP3_oyna("Obyektə vurdum");
                        TestLogaYaz("OBYEKTƏ_vur_XPath_ilə: Obyekt 1-click vuruldu: " + obyekt_XPath);
                    }
                else
                    { // neçə_click == "2-click"

                    // stale element reference: stale element not found
                    // https://stackoverflow.com/questions/18225997/stale-element-reference-element-is-not-attached-to-the-page-document
                        try {
                            new Actions(driver).MoveToElement(obyekt).DoubleClick().Build().Perform();
                            TestLogaYaz("OBYEKTƏ_vur_XPath_ilə: Obyekt 2-click vuruldu: " + obyekt_XPath);
                        }
                        catch(StaleElementReferenceException){
                                TestLogaYaz("Obyektə_vur_XPath_ilə: StaleElementReferenceException verdi");
                                obyekt = driver.FindElement(By.XPath                
                                (obyekt_XPath));

                                new Actions(driver).MoveToElement(obyekt).DoubleClick().Build().Perform();
                            }
                    }
                }
                catch(TimeoutException toe){
                    MP3_oyna("Vurmaq istədiyim obyekt, ekranda tapılmadı");
                    TestLogaYaz("Obyektə_vur_XPath_ilə -> TimeoutException: " + toe.Message );    

                }
                catch(Exception e){
                    //TestLogaYaz("Obyektə_vur_XPath_ilə -> XATA: " + e.Message );  
                    Xatayı_Xata_Faylına_Yaz("Obyektə_vur_XPath_ilə: obyekt_XPath =  " + obyekt_XPath + "--XATA: " + e.Message);
                    MP3_oyna("Ciddi xata göründü. OBYEKTƏ klikləmə funksiyasında obyekt tapılmadı-... test otomasyon durmaq məcburiyyətindədir");    
                    //driver.Quit();
                    if (CONSTANTlar.CIDDI_XATALARDA_TESTI_FAIL_ET)
                        Assert.Fail();
                }
            }

        [Step("Obyektə vur (ID ilə): <obyekt_ID>")]
        public void OBYEKTƏ_vur_ID_ilə_1_KLIK(string obyekt_ID) {
            OBYEKTƏ_vur_ID_ilə(obyekt_ID, "1-click");
        }

        [Step("Obyektə 2-KLIK vur (ID ilə): <obyekt_ID>")]
        public void OBYEKTƏ_vur_ID_ilə_2_KLIK(string obyekt_ID) {
            OBYEKTƏ_vur_ID_ilə(obyekt_ID, "2-click");
        }

        public void OBYEKTƏ_vur_ID_ilə(string obyekt_ID, string neçə_click="1-click") {
            
            TestLogaYaz("OBYEKTƏ_vur_ID_ilə: Bu obyekt tapılıp ve vurulacaq: " + obyekt_ID);
            MP3_oyna_durmadan("Mouse click");
            //MP3_oyna("Mouse click");

            try {
                    IWebElement element = new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                        ExpectedConditions.ElementToBeClickable(
                            (By.Id(obyekt_ID))));
                            //.Click();
                    TestLogaYaz("OBYEKTƏ_vur_ID_ilə: Obyekt TAPILDI");

                    if (!IsElementVisibleInViewport(element))
                        ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].scrollIntoView();", 
                            element);

                    ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid "+ CONSTANTlar.UI_DA_DUYMEYE_VURMA_KƏNAR_RƏNGI +"'", element);

                    TestLogaYaz("\t->Obyekt rəngləndirildii...");
                    //Saniyə_Gözlə(1);
                    MilliSaniyə_Gözlə(100);

                    try {
                        ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid white'", element);
                    }
                    catch (Exception e) {
                        TestLogaYaz("OBYEKTƏ_vur_ID_ilə: qəribə xata: " + e.Message);
                    }

                    if (neçə_click == "1-click" || neçə_click == "1") 
                        element.Click();
                    else { // 2 click
                        new Actions(driver).MoveToElement(element).DoubleClick().Build().Perform();
                        TestLogaYaz("Obyekt tapıldı və 2-click vuruldu: " + obyekt_ID);
                    }

            }
            catch (Exception e) {
                try {
                    TestLogaYaz("OBYEKTƏ_vur_ID_ilə: DEFAULT MODE 1: ID ile tapiram. XATA: " + e.Message);

                    TestLogaYaz("OBYEKTƏ_vur_ID_ilə: DEFAULT MODE 2: XPath TEXT CONTAIN ile tapiram...");
                    new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                        ExpectedConditions.ElementToBeClickable(
                            By.XPath("//*[contains(text(), '" + obyekt_ID + "')]"))).Click();

                }
                catch (Exception) {
                    try {
                        // ustdekinin duplikasi, iki defe olsa, reliable olar
                        TestLogaYaz("OBYEKTƏ_vur_ID_ilə: DEFAULT MODE 3-a: ID ile tapiram ve 'click' edirem(2/2)");
                        new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                            ExpectedConditions.ElementToBeClickable(
                                (By.Id(obyekt_ID)))).Click();
                    }
                    catch (Exception)  {
                        try {
                            // https://stackoverflow.com/questions/11908249/debugging-element-is-not-clickable-at-point-error
                            TestLogaYaz("OBYEKTƏ_vur_ID_ilə: DEFAULT MODE 3-b: 'Action' ile click edirem");
                            IWebElement element = driver.FindElement(
                                By.Id(obyekt_ID));
                            new Actions(driver).MoveToElement(element).Click().Build().Perform();
                        }
                        catch (Exception e2)  {
                            //Assert.Fail();
                            Xatayı_Xata_Faylına_Yaz("OBYEKTƏ_vur_ID_ilə: obyekt_ID = "+ obyekt_ID + "-- XƏTA: " + e2.Message);
                        }
                    }
                }
            }

            TestLogaYaz("Obyekt (" + obyekt_ID + ") səhifədə tapıldı və vuruldu...");            
        }


        [Step("Obyektə vur (qismən ID ilə): <obyektin_qismən_ID_si>")] 
        public void OBYEKTƏ_1_KILK_vur_qismən_ID_si(string obyektin_qismən_ID_si) {
            OBYEKTƏ_vur_qismən_ID_si(obyektin_qismən_ID_si, "1-click");
        }
        
        [Step("Obyektə vur (qismən ID ilə): <obyektin_qismən_ID_si>; click sayısı=<neçə_click>")]
        public void OBYEKTƏ_vur_qismən_ID_si(string obyektin_qismən_ID_si, string neçə_click="1-click") {
            
            TestLogaYaz("OBYEKTƏ_vur_qismən_ID_si= " + obyektin_qismən_ID_si);
            
            MP3_oyna_durmadan("Mouse click");
            //MP3_oyna("Mouse click");

            String XPath_string = "//*[@id[contains(.,'" + obyektin_qismən_ID_si + "')]]";
            TestLogaYaz("XPath_string = " + XPath_string);

            try {
                    IWebElement element = 
                    new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                                            ExpectedConditions.ElementToBeClickable(
                                                By.XPath(XPath_string)));

                    TestLogaYaz("OBYEKTƏ_vur_qismən_ID_si: Obyekt TAPILDI");

                    if (!IsElementVisibleInViewport(element))
                        ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].scrollIntoView();", 
                            element);

                    ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid "+ CONSTANTlar.UI_DA_DUYMEYE_VURMA_KƏNAR_RƏNGI +"'", element);

                    TestLogaYaz("\t->Obyekt rəngləndirildii...");
                    Saniyə_Gözlə(1);

                    element =   
                    new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                                            ExpectedConditions.ElementToBeClickable(
                                                By.XPath(XPath_string)));

                    try {
                        ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid white'", element);
                    }
                    catch (Exception e) {
                        TestLogaYaz("OBYEKTƏ_vur_qismən_ID_si: qəribə xata: " + e.Message);
                    }

                    if (neçə_click == "1-click" || neçə_click == "1")  {
                        element.Click();

                        TestLogaYaz("OBYEKTƏ_vur_qismən_ID_si: obyekt tapıldı və 1-click vuruldu: " + obyektin_qismən_ID_si);
                    }
                    else { // 2 click

                        new Actions(driver).MoveToElement(element).DoubleClick().Build().Perform();

                        TestLogaYaz("OBYEKTƏ_vur_qismən_ID_si: obyekt tapıldı və 2-click vuruldu: " + obyektin_qismən_ID_si);
                    }

            }
            catch (Exception e) {
                try {
                    MP3_oyna("Xata. OBYEKTƏ kliklə funksiyasında obyekt tapılmadı. Obyekti başqa bir üsul ilə axtarıram");

                    TestLogaYaz("OBYEKTƏ_vur_qismən_ID_si: DEFAULT MODE 1: ID ile tapiram. XATA: " + e.Message);

                    TestLogaYaz("OBYEKTƏ_vur_qismən_ID_si: DEFAULT MODE 2: XPath TEXT CONTAIN ile tapiram...");

                    new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                        ExpectedConditions.ElementToBeClickable(
                            By.XPath(XPath_string))).Click();

                }
                catch (Exception) {
                    try {
                        // ustdekinin duplikasi, iki defe olsa, reliable olar
                        MP3_oyna("Xata. OBYEKTƏ kliklə funksiyasında obyekt tapılmadı. Obyekti başqa bir üsul ilə axtarıram");
                        TestLogaYaz("OBYEKTƏ_vur_ID_ilə: DEFAULT MODE 3-a: ID ile tapiram ve 'click' edirem(2/2)");

                        IWebElement element =  new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                        ExpectedConditions.ElementToBeClickable(
                            By.XPath(XPath_string)));
                    }
                    catch (Exception)  {
                        try {
                            // https://stackoverflow.com/questions/11908249/debugging-element-is-not-clickable-at-point-error
                            TestLogaYaz("OBYEKTƏ_vur_qismən_ID_si: DEFAULT MODE 3-b: 'Action' ile click edirem");
                            IWebElement element = driver.FindElement(
                                By.XPath(XPath_string));
                            new Actions(driver).MoveToElement(element).Click().Build().Perform();
                        }
                        catch (Exception e2)  {
                            //Assert.Fail();
                            Xatayı_Xata_Faylına_Yaz("OBYEKTƏ_vur_qismən_ID_si: obyektin_qismən_ID_si = "+ obyektin_qismən_ID_si + "--XƏTA: " + e2.Message);
                        }
                    }
                }
            }

            TestLogaYaz("OBYEKTƏ_vur_qismən_ID_si (" + obyektin_qismən_ID_si + ") səhifədə tapıldı və vuruldu...");

        }

        [Step("Obyektə vur (mətn ilə): <obyek_mətni>")] 
        public void OBYEKTƏ_vur_mətn_ilə_dəqiq_uyğunluq(string obyek_mətni) {
            // click sayısı="1"; cagirma_modu=""; ehtiva_edir_ya_dəqiq_uyğunluq="dəqiq_uyğunluq"
            OBYEKTƏ_vur_mətn_ilə(obyek_mətni, "1-click", "", "dəqiq_uyğunluq");
        }

        [Step("Obyektə 2-KLIK vur (mətn ilə): <obyek_mətni>")]
        public void OBYEKTƏ_vur_obyek_mətn_ilə_2_KLIK(string obyek_mətni) {
            OBYEKTƏ_vur_mətn_ilə(obyek_mətni, "2-click", "", "dəqiq_uyğunluq");
        }

        [Step("Obyektə vur (mətn ilə): <obyek_mətni>; click sayısı=<neçə_click>; cagirma_modu=<cagirma_modu>; ehtiva_edir_ya_dəqiq_uyğunluq=<dəqiq_uyğunluq>")]  
        // ehtiva_edir = contains
        // dəqiq_uyğunluq = exact match 
        public void OBYEKTƏ_vur_mətn_ilə(string obyek_mətni, string neçə_click="1-click", string cagirma_modu = "exception return etme", string ehtiva_edir_ya_dəqiq_uyğunluq= "ehtiva_edir") {

            Test_Logda_Xet_Yaz();
            TestLogaYaz("Obyektə vur (bu mətn ilə): Bu mətni olan obyekt tapılıp və vurulacaq: " + obyek_mətni);
            TestLogaYaz("Neçə_click=" + neçə_click);
            TestLogaYaz("cagirma_modu=" + cagirma_modu);
            
            MP3_oyna_durmadan("Mouse click");
            //MP3_oyna("Mouse click");

            string XPath_string = "";
            if (ehtiva_edir_ya_dəqiq_uyğunluq.Equals("ehtiva_edir")) 
                 XPath_string = "//*[contains(text(), '" + obyek_mətni + "')]";
            else // dəqiq_uyğunluq
                 XPath_string = "//*[text()='" + obyek_mətni + "']";
            
            TestLogaYaz("XPath_string= "+ XPath_string); 

            try {
                if (neçə_click == "1-click" || neçə_click == "1") {

                    new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                        ExpectedConditions.ElementToBeClickable(
                        By.XPath(XPath_string)));
                    
                    IWebElement element = driver.FindElement(
                            By.XPath(XPath_string));

                    // https://stackoverflow.com/questions/45183797/element-not-interactable-exception-in-selenium-web-automation

                    if (!IsElementVisibleInViewport(element)) {
                        TestLogaYaz("OBYEKTƏ_vur_mətn_ilə: Element ekranda gorunmur, ona scroll edirem..."); 

                        ((IJavaScriptExecutor) driver).ExecuteScript(
                           "arguments[0].scrollIntoView();", element);

                        /*
                        Actions actions = new Actions(driver);
                        TestLogaYaz("OBYEKTƏ_vur_mətn_ilə: scroll-1/3"); 
                        actions.MoveToElement(element);
                        TestLogaYaz("OBYEKTƏ_vur_mətn_ilə: scroll-2/3"); 
                        actions.Build().Perform();
                        TestLogaYaz("OBYEKTƏ_vur_mətn_ilə: scroll-3/3"); 
                        */
                        TestLogaYaz("OBYEKTƏ_vur_mətn_ilə: Element gorunsun diye, scroll ettim..."); 
                    }
                    try {
                        ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid "+ CONSTANTlar.UI_DA_DUYMEYE_VURMA_KƏNAR_RƏNGI +"'", element);
                        
                        //Saniyə_Gözlə(1);
                        MilliSaniyə_Gözlə(200);

                        element = driver.FindElement(
                            By.XPath(XPath_string));
                        TestLogaYaz("Düymə səhifədə tapıldı...");                              
                        //element = driver.FindElement(
                          // By.XPath(XPath_string));

                        try {
                            ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid white'", element);
                            TestLogaYaz("OBYEKTƏ_vur_mətn_ilə: obyekt agardildi..."); 
                        }
                        catch (Exception e) { 
                             TestLogaYaz("OBYEKTƏ_vur_mətn_ilə: XATA / 1-click / '2px solid white': " + e.Message);
                        }
                        element = driver.FindElement(
                            By.XPath(XPath_string));
                        element.Click();
                        TestLogaYaz("Düymə vuruldu...");                        

                    }
                    catch (Exception e) { 
                        // bezi zaman, 1-click bu xatayi vere biler:
                        //stale element reference: stale element not found
                        TestLogaYaz("OBYEKTƏ_vur_mətn_ilə: Exception: " + e.Message);

                        TestLogaYaz("OBYEKTƏ_vur_mətn_ilə: diger yontem (JS click) ile 1-click edirem: ");

                        try {
                            element = driver.FindElement(
                                By.XPath(XPath_string));

                            ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid "+ CONSTANTlar.UI_DA_DUYMEYE_VURMA_KƏNAR_RƏNGI +"'", element);
                            
                            Saniyə_Gözlə(1);

                            element = driver.FindElement(
                                By.XPath(XPath_string));

                            ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid white'", element);

                            element = driver.FindElement(
                                By.XPath(XPath_string));

                            ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].click();", element);
                            //new Actions(driver).MoveToElement(element).Click().Build().Perform();
                            
                            TestLogaYaz("Obyekt tapıldı və 1-click vuruldu: " + obyek_mətni);
                        }
                        catch (Exception e2) { 
                            if (cagirma_modu == "Exception return et")
                                throw  e2;
                            else {
                                Xatayı_Xata_Faylına_Yaz("OBYEKTƏ_vur_mətn_ilə: obyek_mətni = "+ obyek_mətni + "-- neçə_click = " + neçə_click  + " -- XATA2: " + e.Message);
                                MP3_oyna("Ciddi xata göründü. OBYEKTƏ klikləmə funksiyasında obyekt tapılmadı-... test otomasyon durmaq məcburiyyətindədir");
                                
                                //driver.Quit();
                                if (CONSTANTlar.CIDDI_XATALARDA_TESTI_FAIL_ET)
                                    Assert.Fail();                                
                            }
                        }
                    }                    
                }
                else { // neçə_click == "2-click"
                    new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                        ExpectedConditions.ElementToBeClickable(
                        //ExpectedConditions.ElementIsVisible(
                        By.XPath(XPath_string)));
                    Saniyə_Gözlə(1);
                    IWebElement element = driver.FindElement(
                            By.XPath(XPath_string));

                    ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid "+ CONSTANTlar.UI_DA_DUYMEYE_VURMA_KƏNAR_RƏNGI +"'", element);
                                            
                    Saniyə_Gözlə(1);

                    element = driver.FindElement(
                            By.XPath(XPath_string));
                                            
                    /*Actions act = new Actions(driver);
                    act.DoubleClick(element).Perform();*/

                    try {
                            ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid white'", element);
                        }
                        catch (Exception e) { 
                            TestLogaYaz("OBYEKTƏ_vur_mətn_ilə: XATA / 2-click / '2px solid white': " + e.Message);
                        }

                    element = driver.FindElement(
                            By.XPath(XPath_string));

                    new Actions(driver).MoveToElement(element).DoubleClick().Build().Perform();

                    TestLogaYaz("Obyekt tapıldı və 2-click vuruldu: " + obyek_mətni);
                }

            }
            catch (Exception e) {
                //TestLogaYaz
                if (cagirma_modu == "Exception return et")
                    throw  e;
                else {
                    Xatayı_Xata_Faylına_Yaz("OBYEKTƏ_vur_mətn_ilə: obyek_mətni = "+ obyek_mətni + "--neçə_click=" + neçə_click  + "--XATA3: " + e.Message);
                    MP3_oyna("Ciddi xata göründü. OBYEKTƏ klikləmə funksiyasında obyekt tapılmadı-... test otomasyon durmaq məcburiyyətindədir");
                    //driver.Quit();
                    if (CONSTANTlar.CIDDI_XATALARDA_TESTI_FAIL_ET)
                        Assert.Fail();

                }
                if (driver.PageSource.Contains(obyek_mətni))
                    TestLogaYaz("obyek_mətni PageSource da VAR");
                else
                    TestLogaYaz("obyek_mətni PageSource da YOX");

                //print_all_IDs();
                //Console.Write();
            }            
        }

        [Step("Obyektə vur (mətni=bu dəyişgənin dəyəri): <dəyişgən_ismi>; click sayısı=<PARAM_neçə_click>; ehtiva_edir_ya_dəqiq_uyğunluq=<PARAM_ehtiva_edir_ya_dəqiq_uyğunluq>")]
        public void OBYEKTƏ_vur_mətni_bu_dəyişgənin_dəyəri(string dəyişgən_ismi, string PARAM_neçə_click="1-click", string PARAM_ehtiva_edir_ya_dəqiq_uyğunluq= "ehtiva_edir") {

            TestLogaYaz("OBYEKTƏ_vur_mətni_bu_dəyişgənin_dəyəri ilə:" + dəyişgən_ismi );
            string dəyişgənin_dəyəri = Əsnək_String_Dəyişgənlər_Cədvəli[dəyişgən_ismi];

            TestLogaYaz("Dəyişgən=" + dəyişgən_ismi); 
            TestLogaYaz("Dəyişgənin_dəyəri=" + dəyişgənin_dəyəri);
            
            OBYEKTƏ_vur_mətn_ilə(dəyişgənin_dəyəri, neçə_click: PARAM_neçə_click, ehtiva_edir_ya_dəqiq_uyğunluq: PARAM_ehtiva_edir_ya_dəqiq_uyğunluq);
        }

        [Step("Obyektə vur (XPathi=bu dəyişgənin dəyəri): <dəyişgən_ismi>")]
        public void OBYEKTƏ_vur_XPathi_bu_dəyişgənin_dəyəri(string dəyişgən_ismi) {

            TestLogaYaz("OBYEKTƏ_vur_XPathi_bu_dəyişgənin_dəyəri ilə:" + dəyişgən_ismi );
            string dəyişgənin_dəyəri = Əsnək_String_Dəyişgənlər_Cədvəli[dəyişgən_ismi];

            TestLogaYaz("Dəyişgən=" + dəyişgən_ismi); 
            TestLogaYaz("Dəyişgənin_dəyəri=" + dəyişgənin_dəyəri);
            
            OBYEKTƏ_vur_XPath_ilə(dəyişgənin_dəyəri);
        }



        public void OBYEKTƏ_fokuslaş_və_kənarin_rəngləndir(
            IWebElement Obyekt, string rəng) {

            try {
                if (!IsElementVisibleInViewport(Obyekt)) 
                                ((IJavaScriptExecutor) driver).ExecuteScript(
                                    "arguments[0].scrollIntoView();", Obyekt);

                ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid "+ rəng +"'", Obyekt);      

                //MilliSaniyə_Gözlə(500);
                Saniyə_Gözlə(1);

                ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='1px white'", Obyekt);
            }
            catch (Exception e){
                // Xatayı_Xata_Faylına_Yaz("OBYEKTƏ_fokuslaş_və_kənarin_rəngləndir--XƏTA: " + e.Message);       
            }
        }

    readonly int ___EKRANDA_YAZMAQ_əməliyyatları;   

    [Step("Obyekti XPath ilə tap və onda dəyər yaz: XPath = <XPath>; dəyər = <dəyər>")]
        public void obyekti_XPath_ilə_tap_və_onda_dəyər_yaz(string XPath, string dəyər) {
            TestLogaYaz("obyekti_XPath_ilə_tap_və_onda_dəyər_yaz: ");
            TestLogaYaz("XPath = " + XPath);
            TestLogaYaz("dəyər = " + dəyər);

            try { 
                IWebElement obyekt = driver.FindElement(By.XPath(XPath));
                obyekt.SendKeys(dəyər);
            }
            catch (Exception e) {
                    Xatayı_Xata_Faylına_Yaz("XƏTA: obyekti_XPath_ilə_tap_və_onda_dəyər_yaz. XPath = " + XPath + " -- Xata=" + e.Message);
            }
        }
    
        
        [Step("Dinamik olaraq, bu dəyəri yarat, klaviatura ilə yaz, və dəyişgən olaraq yadda saxla: <dəyər_ismi>")]
        public void dinamik_bu_dəyəri_yaz_klaviaturar_ilə_və_dəyişgən_yadda_saxla(string dəyər_ismi) {
            // * Mətn yaz []
            TestLogaYaz("dinamik_bu_dəyəri_yaz_klaviaturar_ilə_və_dəyişgən_yadda_saxla: " + dəyər_ismi);

            Actions actions = new Actions(driver);
            String yazi="";
            DateTime tarixVeSaat_DateTimeObject;
            switch (dəyər_ismi)  {
                case "Indiki-tarix-və-zaman":
                    tarixVeSaat_DateTimeObject = DateTime.Now;
                    yazi = tarixVeSaat_DateTimeObject.ToString("yyyy/MM/dd-HH:mm");   

                    break;

                case  "Bu gündən 60 gün əvvəlki tarix":
                    tarixVeSaat_DateTimeObject = DateTime.Now;
                    tarixVeSaat_DateTimeObject = tarixVeSaat_DateTimeObject.AddDays(-60);
                    yazi = tarixVeSaat_DateTimeObject.ToString("dd.MM.yyyy");
                    break;

                case    "Bu günün tarixi":
                    tarixVeSaat_DateTimeObject = DateTime.Now;
                    yazi = tarixVeSaat_DateTimeObject.ToString("dd.MM.yyyy");
                    break;
            }
            TestLogaYaz("dinamik_bu_dəyəri_yaz_klaviaturar_ilə_və_dəyişgən_yadda_saxla -- yazi DEYERI = " + yazi);

            Dəyişgən_və_dəyərini_yadda_saxla(dəyər_ismi, yazi);
            actions.SendKeys(yazi);
            actions.Perform();
        }

        [Step("Klaviatura ilə, reserved düyməyi vur: <düymə>")]
        public void klaviatura_ilə_reserved_düyməyi_vur(string düymə) {
            TestLogaYaz("klaviatura_ilə_reserved_düyməyi_vur: düymə = " + düymə);

            Actions actions = new Actions(driver);
            
            if (düymə.Equals("Keys.PageDown"))
                actions.SendKeys(Keys.PageDown);
                
            actions.Perform();            
        }

        [Step("Mətn yaz, klaviatura ilə: <mətn>")]
        public void Mətn_yaz_klaviatura_ilə(string mətn) {
            TestLogaYaz("Mətn yazıram: " + mətn);

            //MP3_oyna_durmadan("Keyboard Typing");

            Actions actions = new Actions(driver);
            
            actions.SendKeys(mətn);
            actions.Perform();
            // yavaş yavaş yaz...
            /*foreach (char c in mətn) {
                actions.SendKeys(c.ToString());
                actions.Perform();
                MilliSaniyə_Gözlə(50);
            }*/
            TestLogaYaz("Mətnı yazdım: " + mətn);
        }
        readonly int ___GÖZLƏMƏ_BƏKLƏMƏ_əməliyyatları;   

        [Step("OBYEKTİN səhifəyə gəldiyini gözlə: obyekt_XPath = <obyekt_XPath>; saniyə_gözlə = <neçə_saniyə_gözlə>; gəlsə_səs_faylı = <gəlsə_səs_faylı>; gəlməzsə_səs_faylı= <gəlməzsə_səs_faylı>")]
        public void OBYEKTİN_səhifəyə_gəldiyini_gözlə(
            string obyekt_XPath, 
            string saniyə_gözlə,
            string gəlsə_səs_faylı,
            string gəlməzsə_səs_faylı
            ) {

            int saniyə_gözlə_int = Int32.Parse(saniyə_gözlə);

            try {
                IWebElement element =  new WebDriverWait(driver, TimeSpan.FromSeconds(saniyə_gözlə_int)).Until(
                    ExpectedConditions.ElementIsVisible(
                        By.XPath(obyekt_XPath)));

                OBYEKTƏ_fokuslaş_və_kənarin_rəngləndir(driver.FindElement(By.XPath(obyekt_XPath)), CONSTANTlar.UI_DA_YAZI_YOXLAMA_KƏNAR_RƏNGI);   
                
                TestLogaYaz("\tObyekt ekranda tapıldı");
                if (gəlsə_səs_faylı !="")
                    MP3_oyna(gəlsə_səs_faylı);
            }
            catch (Exception e){
                 Xatayı_Xata_Faylına_Yaz("OBYEKTİN_səhifəyə_gəldiyini_gözlə--TAPILMADI: " + obyekt_XPath + " -- XƏTA: " + e.Message);      
                
                TestLogaYaz("\tObyekt ekranda tapılMAdı");
                if (gəlməzsə_səs_faylı !="")
                    MP3_oyna(gəlməzsə_səs_faylı);
            }
        }


        public void MilliSaniyə_Gözlə(int milli_saniyə) {
            //Console.Write(milli_saniyə + " milli saniyə gözləmə...");
            Thread.Sleep(milli_saniyə);
        }
        [Step("<sayı> saniyə gözlə <mesaj>")]
        public void Saniyə_Gözlə(int NeçəSaniyə, string mesaj) {
            TestLogaYaz("Gözləyirəm: " + mesaj);
            Saniyə_Gözlə(NeçəSaniyə);
        }
        
        /*
        [Step("<NeçəSaniyə> saniyə gözlə SESLI")]
        public void Saniyə_Gözlə_sesli(int NeçəSaniyə) {
            Saniyə_Gözlə(NeçəSaniyə, ses: true);
        }
        */

        [Step("<NeçəSaniyə> saniyə gözlə")]
        public void Saniyə_Gözlə(int NeçəSaniyə
                            //,Boolean ses=false
                            ) {
            Console.Write("----" + NeçəSaniyə + " saniyə gözləmə başlayır:");
            for (int i=0; i<NeçəSaniyə; i++)
                try {
                    //Console.SetCursorPosition(0, Console.CursorTop);
                    Console.Write(i);

                    Thread.Sleep((int) (1000.0 / CONSTANTlar.GÖZLƏMƏ_ORANI));
                    //if (ses)
                    //    MP3_oyna("", bəklə: false); 
                    // Thread.Sleep(500 * NeçəSaniyə);
                    //Thread.Sleep(1000 * NeçəSaniyə);
                } 
                catch (ThreadInterruptedException) {
                    //throw new RuntimeException(e);
                }
            //Console.Write("-gözləmə bitdi.");
            Console.WriteLine();

        }

        [Step("Bəkləmə-animasyonu getməsini gözlə")]
        // Bəkləmə_animasyonu_  Yüklənir_getməsini_gözlə
        public void Bəkləmə_animasyonun_getməsini_gözlə(){
            YÜKLƏNİR_YAZİ_animasyonun_getməsini_gözlə();
            DÖNƏR_animasyonun_getməsini_gözlə();
        }

        public void DÖNƏR_animasyonun_getməsini_gözlə (){
            Test_Logda_Xet_Yaz();
            TestLogaYaz("DÖNƏR_animasyonun_getməsini_gözlə");

            /* 
            --> display: none 
            <div id="Loading" style="... display: none">
                    <img id="loading-image" src="/images/ajax_loader_blue_512.gif" >
                </div>                
            */

            try { 
                Saniyə_Gözlə(1);

                IList <IWebElement> nece_dene_DÖNƏR_animasyon_elements = driver.FindElements(
                By.XPath("//div[@id='Loading' and not(contains(@style,'display: none'))] "));
                int num_of_DÖNƏR_animasyon_visible = 0;

                IWebElement visible_olan_DÖNƏR_animasyon= null;

                for(int i= 0; i<nece_dene_DÖNƏR_animasyon_elements.Count; i++)
                    if (nece_dene_DÖNƏR_animasyon_elements[i].Displayed) {
                        visible_olan_DÖNƏR_animasyon = nece_dene_DÖNƏR_animasyon_elements[i];
                        num_of_DÖNƏR_animasyon_visible++;
                    }
                
                TestLogaYaz("num_of_DÖNƏR_animasyon_visible=" + num_of_DÖNƏR_animasyon_visible);

                if (num_of_DÖNƏR_animasyon_visible == 0) {
                    TestLogaYaz("'HEC BIR DÖNƏR_animasyon TAPILMADI" );
                    return;
                }
                // else, yani num_of_DÖNƏR_animasyon_visible > 0

                DateTime dateTime1 = DateTime.UtcNow;
                TestLogaYaz("DÖNƏR_animasyon TAPILDI");
                
                int nece_2000_ms=0;

                try { 
                    while (visible_olan_DÖNƏR_animasyon.Displayed) {
                        MP3_oyna("Gözləyirəm");
                        TestLogaYaz("DÖNƏR_animasyon hele ekran'da... "+ (nece_2000_ms*2) + " saniye oldu...");
                        nece_2000_ms++;
                        Thread.Sleep(2000);
                    }
                }
                catch (Exception) {
                    // ignore ve DEVAM
                }

                TestLogaYaz("DÖNƏR_animasyon GETDI");

                DateTime dateTime2 = DateTime.UtcNow;
                double diffInSeconds = (dateTime2-dateTime1).TotalMilliseconds;

                TestLogaYaz("Bu qeder saniye cekdi (ms):" + diffInSeconds);
                //Thread.Sleep(1000);
    
            }
            catch (Exception e) {
                TestLogaYaz("'DÖNƏR_animasyonu TAPILMADI--- XATA:" + e.Message);
            }
        }

        // // <div class="dx-loadpanel-message">Yüklənir...</div>
        public void YÜKLƏNİR_YAZİ_animasyonun_getməsini_gözlə (){
            Test_Logda_Xet_Yaz();
            TestLogaYaz("YÜKLƏNİR_YAZİ_animasyonun_getməsini_gözlə");

            try { 
                Saniyə_Gözlə(1);

                IList <IWebElement> nece_dene_yüklənir_elements = driver.FindElements(
                By.XPath("//div[text()[contains(., 'Yüklənir')]]"));
                int num_of_yüklənir_visible = 0;

                IWebElement visible_olan_yüklənir= null;

                for(int i= 0; i<nece_dene_yüklənir_elements.Count; i++)
                    if (nece_dene_yüklənir_elements[i].Displayed) {
                        visible_olan_yüklənir = nece_dene_yüklənir_elements[i];
                        num_of_yüklənir_visible++;
                    }
                
                TestLogaYaz("Yüklənirin_getməsini_gözlə -- num_of_yüklənir_visible=" + num_of_yüklənir_visible);

                if (num_of_yüklənir_visible == 0) {
                    TestLogaYaz("'Yüklənir' bəkləmə-animasyon'u TAPILMADI" );
                    return;
                }
                // else, yani num_of_yüklənir_visible > 0

                DateTime dateTime1 = DateTime.UtcNow;
                TestLogaYaz("Yüklənir popup TAPILDI");
                
                int nece_2000_ms=0;

                try { 
                    while (visible_olan_yüklənir.Displayed) {
                        MP3_oyna("Gözləyirəm");
                        TestLogaYaz("Yüklənir hele ekran'da... "+ (nece_2000_ms*2) + " saniye oldu...");
                        nece_2000_ms++;
                        Thread.Sleep(2000);
                    }
                }
                catch (Exception) {
                    // ignore ve DEVAM
                }

                TestLogaYaz("Yüklənir popup GETDI");

                DateTime dateTime2 = DateTime.UtcNow;
                double diffInSeconds = (dateTime2-dateTime1).TotalMilliseconds;

                TestLogaYaz("Bu qeder saniye cekdi (ms):" + diffInSeconds);
                //Thread.Sleep(1000);
    
            }
            catch (Exception e) {
                TestLogaYaz("'Yüklənir' bəkləmə-animasyon'u TAPILMADI--- XATA:" + e.Message);
            }

        }

        [Step("'Bəkləmə-animasyonu LOADING getməsini gözlə")]
        public void Loading_getməsini_gözlə (){
            TestLogaYaz("'Bəkləmə-animasyonu LOADING getməyini gözləyirəm...");

            /* LOADING YUVARLAGI

                <div id="Loading" style="width: 100%; height: 100%; top: 0px; left: 0px; position: fixed; z-index: 99; background-color: rgba(255, 255, 255, 0.8);">
                        <img id="loading-image" src="/images/ajax_loader_blue_512.gif" style="position: absolute;top: 40%;left: 50%;z-index: 100;height:50px;width:50px;font-size:larger">
                    </div>            
            */
            
            try { 
                Thread.Sleep(1000);

                IList <IWebElement> nece_dene_yüklənir_elements = driver.FindElements(
                By.XPath("//span[text()[contains(., 'Yüklənir')]]"));
                int num_of_yüklənir_visible = 0;

                IWebElement visible_olan_yüklənir= null;

                for(int i= 0; i<nece_dene_yüklənir_elements.Count; i++)
                    if (nece_dene_yüklənir_elements[i].Displayed) {
                        visible_olan_yüklənir = nece_dene_yüklənir_elements[i];
                        num_of_yüklənir_visible++;
                    }
                
                TestLogaYaz("Yüklənirin_getməsini_gözlə -- num_of_yüklənir_visible=" + num_of_yüklənir_visible);
                if (num_of_yüklənir_visible == 0) {
                    TestLogaYaz("'Yüklənir' bəkləmə-animasyon'u TAPILMADI" );
                    return;
                }
                // else, yani num_of_yüklənir_visible > 0

                DateTime dateTime1 = DateTime.UtcNow;
                TestLogaYaz("Yüklənir popup TAPILDI");
                
                int nece_500_ms=0;

                try { 
                    while (visible_olan_yüklənir.Displayed) {
                        TestLogaYaz("Yüklənir hele ekran'da... "+ (nece_500_ms/2) + " saniye oldu...");
                        nece_500_ms++;
                        Thread.Sleep(500);
                    }
                }
                catch (Exception) {
                    // ignore ve DEVAM
                }

                //new WebDriverWait(driver, TimeSpan.//FromSeconds(30)).Until(
                    //InvisibilityOfElementLocated(By.Equals//(visible_olan_yüklənir)));

                      //  By.XPath("//span[text()[contains////(., 'Yüklənir')]]")));

                //IWebElement nece_dene_yüklənir_element = driver.FindElement(By.XPath("//table[@id='gridNewViza_LPV']//span[@id='gridNewViza_TL']"));

                //new WebDriverWait(driver, TimeSpan.FromSeconds(3)).Until(
                //    ExpectedConditions.ElementIsVisible(
                //      nece_dene_yüklənir_elements[0]  ));

                TestLogaYaz("Yüklənir popup GETDI");

                DateTime dateTime2 = DateTime.UtcNow;
                double diffInSeconds = (dateTime2-dateTime1).TotalMilliseconds;

                TestLogaYaz("Bu qeder saniye cekdi (ms):" + diffInSeconds);
                //Thread.Sleep(1000);
    
            }
            catch (Exception e) {
                TestLogaYaz("'Yüklənir' bəkləmə-animasyon'u TAPILMADI--- XATA:" + e.Message);
            }
        }
        
        readonly int ___MP3_əməliyyatları;   

        [Step("MP3 oyna (durmadan): <mp3_fayl_ismi>")]
        public void MP3_oyna_durmadan(string mp3_fayl_ismi) {

            Test_Logda_Xet_Yaz();

            if (CONSTANTlar.MP3_SES_OYNA == true) {
                String mp3_fayl_path = "\".\\SƏSLƏR\\"+ mp3_fayl_ismi + ".mp3\"";

                Console.WriteLine("MP3 faylı səsləndırırəm (durmadan)=" + mp3_fayl_path);

                ProcessStartInfo startInfo = new ProcessStartInfo(CONSTANTlar.VLC_EXE_PATH);

                startInfo.Arguments = "-I null --play-and-exit --volume-step 256 --gain 8 " + mp3_fayl_path;

                startInfo.WindowStyle = ProcessWindowStyle.Hidden;

                startInfo.UseShellExecute = false;
                startInfo.RedirectStandardError = true;
                using Process exeProcess = Process.Start(startInfo);
            }
        }

        [Step("MP3 oyna: <mp3_fayl_ismi>")]
        public void MP3_oyna(string mp3_fayl_ismi
                    //, Boolean bəklə = true 
                    ) {
            Test_Logda_Xet_Yaz();
            Console.WriteLine("MP3 oynama baslayir...");

            if (CONSTANTlar.MP3_SES_OYNA == true) {
                //GLOBAL_project_working_dir = Directory.GetCurrentDirectory();
                string project_working_dir_IKI_SLASH = GLOBAL_project_working_dir.Replace(@"\", @"\\");

                String mp3_fayl_path = "\".\\SƏSLƏR\\"+ mp3_fayl_ismi + ".mp3\"";
                
                Console.WriteLine("MP3 fayli oynadıram (wait ile)=" + mp3_fayl_path);

                //String project_working_dir = Directory.GetCurrentDirectory();
                //Console.WriteLine("project_working_dir = " + project_working_dir);

                Directory.SetCurrentDirectory(GLOBAL_project_working_dir+ "\\SƏSLƏR\\");
                String current_working_dir = Directory.GetCurrentDirectory();
                //Console.WriteLine("current_working_dir = " + current_working_dir);
                //Console.WriteLine("MP3 fayli oynadıram - FULL PATH (wait ile)=" + mp3_fayl_path);

                if (!File.Exists(mp3_fayl_ismi + ".mp3") ) {
                    Console.WriteLine("---->>> XATA: PARAMETRDƏ VERİLƏN MP3 SƏS FAYLI TAPILMADI");

                    //Console.WriteLine("MP3 oyna : Orijinal project_working_dir ə geri dönürəm ...");
                    Directory.SetCurrentDirectory(GLOBAL_project_working_dir);
                    current_working_dir = Directory.GetCurrentDirectory();
                    //Console.WriteLine("current_working_dir = " + current_working_dir);

                    MP3_oyna("Parametrdə verilən MP3 səs faylı tapılmadı");
                    Xatayı_Xata_Faylına_Yaz("MP3_oyna: Parametrdə verilən MP3 səs faylı tapılmadı -> " + mp3_fayl_ismi + ".mp3");
                    return;
                }
                //Console.WriteLine("MP3_oyna: Orijinal project_working_dir ə geri dönürəm ..."); 
                Directory.SetCurrentDirectory(GLOBAL_project_working_dir);     
                current_working_dir = Directory.GetCurrentDirectory();
                //Console.WriteLine("current_working_dir = " + current_working_dir);

                // file exists, play it
                ProcessStartInfo startInfo = new ProcessStartInfo(CONSTANTlar.VLC_EXE_PATH);

                startInfo.Arguments = "-I null --play-and-exit --volume-step 256 --gain 8 " + mp3_fayl_path;

                startInfo.WindowStyle = ProcessWindowStyle.Hidden;

                startInfo.UseShellExecute = false;
                startInfo.RedirectStandardError = true;
                //Console.WriteLine("startInfo = " + startInfo);

                //Console.WriteLine("Starting the process...");
                using Process exeProcess = Process.Start(startInfo);

                String clean_and_ignore_the_buffer = exeProcess.StandardError.ReadToEnd();

                //Console.WriteLine("Wait for process exit ...");
                exeProcess.WaitForExit(20000);


                
                
            }

            /*

            Test_Logda_Xet_Yaz();

            if (CONSTANTlar.MP3_SES_OYNA == true) {
                String mp3_fayl_path = "\".\\SƏSLƏR\\"+ mp3_fayl_ismi + ".mp3\"";

                Console.WriteLine("MP3 faylı səsləndırırəm =" + mp3_fayl_path);

                ProcessStartInfo startInfo = new ProcessStartInfo(CONSTANTlar.VLC_EXE_PATH);

                startInfo.Arguments = "-I null --play-and-exit --volume-step 256 --gain 8 " + mp3_fayl_path;

                startInfo.WindowStyle = ProcessWindowStyle.Hidden;

                startInfo.UseShellExecute = false;
                startInfo.RedirectStandardError = true;
                using Process exeProcess = Process.Start(startInfo);
                String clean_and_ignore_the_buffer = exeProcess.StandardError.ReadToEnd();

                Console.WriteLine("MP3_oyna: Wait for process exit ...");
                exeProcess.WaitForExit(20000);
            }*/            
        }

        readonly int ___SƏHİFƏDƏN_DƏYƏR_OXYUMAQ_əməliyyatları;   

        [Step("Səhifə gridində sətir sayı ədədini bu XPath'dan çixar=<sətir_sayı_XPathi>, və bu dəyişgəndə saxla: <dəyişgən_ismi>")]
        public void Səhifə_gridində_sətir_sayı_ədədını_çixar_və_bu_dəyişgəndə_saxla(string sətir_sayı_XPathi, string dəyişgən_ismi)
        {
            Console.WriteLine("Səhifə_gridində_sətir_sayı_ədədını_çixar_və_bu_dəyişgəndə_saxla...");

            try {
                //IWebElement sətir_sayı_element = driver.FindElement(By.XPath("//*[contains(text(), 'Sətir sayı')]"));
                IWebElement sətir_sayı_element = driver.FindElement(By.XPath(sətir_sayı_XPathi)); // "//*[contains(text(), 'məlumat)')]"

                string sətir_sayı_butov_mətni =  sətir_sayı_element.GetAttribute("innerHTML");

                TestLogaYaz("sətir_sayı_butov_mətni= " + sətir_sayı_butov_mətni);
                // MISAL: Səhifə 1/26 (388 məlumat)

                //sətir_sayı_element = driver.FindElement(By.XPath("//*[contains(text(), 'məlumat)')]"));

                OBYEKTƏ_fokuslaş_və_kənarin_rəngləndir(sətir_sayı_element, CONSTANTlar.UI_DA_YAZI_YOXLAMA_KƏNAR_RƏNGI);

                // ədədi çixar
                // MISAL: sətir_sayı_butov_mətni = Səhifə 1/26 (388 məlumat) 
                // --> sətir_sayı_ədədi = 388
                //sətir_sayı_butov_mətni = sətir_sayı_butov_mətni.Replace("Sətir sayı: ", "");
                int aciq_parantez_indeksi = sətir_sayı_butov_mətni.IndexOf("(");
                TestLogaYaz("aciq_parantez_indeksi= " + aciq_parantez_indeksi);

                String sətir_sayı_parantez_arasi_metn = sətir_sayı_butov_mətni.Substring(aciq_parantez_indeksi);
                TestLogaYaz("sətir_sayı_parantez_arasi_metn= " + sətir_sayı_parantez_arasi_metn);
                // (388 məlumat)

                int bosluq_indeksi = sətir_sayı_parantez_arasi_metn.IndexOf(" ");
                
                String sətir_sayı_ədədi = sətir_sayı_parantez_arasi_metn.Substring(1, bosluq_indeksi);

                //int sətir_sayı_ədədi = int. Parse(sətir_sayı_butov_mətni);
                TestLogaYaz("sətir_sayı_ədədi= " + sətir_sayı_ədədi);

                // yadda saxla
                //Əsnək_String_Dəyişgənlər_Cədvəli.Add(dəyişgən_ismi, sətir_sayı_butov_mətni);
                Dəyişgən_və_dəyərini_yadda_saxla(dəyişgən_ismi, sətir_sayı_ədədi);

                MP3_oyna("Səhifə gridində, sətir sayı ədədi oxundu və sonra yoxlamaq üçün test hafizəsində saxlanıldı");
            }
            catch (Exception e) {
                Xatayı_Xata_Faylına_Yaz("Səhifə_gridində_sətir_sayı_ədədını_çixar_və_bu_dəyişgəndə_saxla /.. XATA = "  + e.Message);
            }
        }

        [Step("Səhifədə xananı XPath ilə tap və dəyərini, dəyişgən olaraq yadda saxla: XPath = <Xananın_XPathi>, dəyişgən = <dəyişgən>, xana_ismi_MP3 = <xana_ismi_MP3>")]
        public void Xananı_XPath_ilə_tap_və_dəyərini_dəyişgən_olaraq_yadda_saxla(string Xananın_XPathi, string dəyişgən, string xana_ismi_MP3) {
            
            Test_Logda_Xet_Yaz();
            TestLogaYaz("Xananın_dəyərini_dəyişgən_olaraq_yadda_saxla_XPath:");
            
            MP3_oyna("Xananın dəyərini sonra yoxlamada istifadə etmək üçün, yadda saxlayıram");
            if (xana_ismi_MP3 != "")
                MP3_oyna(xana_ismi_MP3); 

            IWebElement element = driver.FindElement(By.XPath(Xananın_XPathi));
            
            OBYEKTƏ_fokuslaş_və_kənarin_rəngləndir(element, CONSTANTlar.UI_DA_YAZI_YOXLAMA_KƏNAR_RƏNGI);

            element = driver.FindElement(By.XPath(Xananın_XPathi));
            
            string Xananın_dəyəri = "";
            TestLogaYaz("\telement.TagName = " + element.TagName);
            if (element.TagName == "input") 
                Xananın_dəyəri = element.GetAttribute("value");//.Text;
            else if (element.TagName == "td")
                Xananın_dəyəri = element.GetAttribute("innerHTML");
            
            TestLogaYaz("\tXananın_XPathi = " + Xananın_XPathi);
            TestLogaYaz("\tXananın_dəyəri = " + Xananın_dəyəri);
            TestLogaYaz("\tdəyişgən = " + dəyişgən);

            Dəyişgən_və_dəyərini_yadda_saxla(dəyişgən, Xananın_dəyəri);
        }

        readonly int ___TEST_LOG_əməliyyatları;   

        public void Test_Logda_Xet_Yaz() {
            Console.WriteLine("----------------" );
        }

        public void TestLogaYaz(int mesaj_int)
        {
            TestLogaYaz(mesaj_int.ToString());
        }

        [Step("Log'da mətn yaz: <dəyər>")]
        public void TestLogaYaz(string mesaj)
        {
            if (mesaj.Contains("TC") || mesaj.Contains("Bölmə")) {
                ((IJavaScriptExecutor) driver).ExecuteScript("top.document.title = \"" + mesaj + "\"");
            }

            if (mesaj.Contains("ADDIM"))
                Console.WriteLine("-----------");

            /*if (!GLOBAL_test_case_adı.Equals("TC_AD_YOXDUR")) 
                Console.WriteLine("-------------\nTest: " + GLOBAL_test_case_adı + "- addım: " + GLOBAL_test_case_içində_addım + "\n-------------\n");*/
                
            ((IJavaScriptExecutor) driver).ExecuteScript("top.document.title = \"" + GLOBAL_test_case_adı + "--addım: " + GLOBAL_test_case_içində_addım + "\"");

            Console.WriteLine(mesaj );//+ "  \n");

            if (mesaj.Contains("ADDIM"))
                Console.WriteLine("-----------");
            
            if (mesaj.Contains("ADDIM") || mesaj.Contains("Bölmə") || mesaj.Contains("bölmə")) {
                ((IJavaScriptExecutor) driver).ExecuteScript("top.document.title = \"" + mesaj + "\"");
            }

            Browser_Bağlanıbsa_Testi_də_durdur(driver);

        }   

        readonly int ___YOXLAMALAR;   

        [Step("YOXLA: Açılan alertdə bu mətnin olduğunu: <bəklənən_mətn>")]
        public void YOXLA_Açılan_alertdə_bu_mətnin_olduğunu (string bəklənən_mətn){
            try {
                string görunən_metn = driver.SwitchTo().Alert().Text;
                if (görunən_metn.CompareTo(bəklənən_mətn) == 0) {
                    // beraber
                    MP3_oyna("Açılan alertin mətni gözlənildiyi kimidir");
                    TestLogaYaz("Açılan alertin mətni gözlənildiyi kimidir");
                }
                else {
                    MP3_oyna("XATA. Açılan alertin mətni gözlənildiyi mətn deyil");
                    Xatayı_Xata_Faylına_Yaz("YOXLA_Açılan_alertdə_bu_mətnin_olduğunu. Açılan alertin mətni gözlənildiyi kimi DEYİL. bəklənən_mətn = " + bəklənən_mətn + "--görunən metn = " + görunən_metn);
                }

            }
            catch (Exception e) {
                Xatayı_Xata_Faylına_Yaz("YOXLA_Açılan_alertdə_bu_mətnin_olduğunu. XATA=" + e.Message);
            }
        } 

        [Step("YOXLA: Alert pəncərə açıldığını")]
        public void YOXLA_Alert_pəncərə_açıldığını (){
            try {
                driver.SwitchTo().Alert();
                TestLogaYaz("Test Alert pəncərəsi açılmış");
                MP3_oyna("Təsdiqləndi. Alert pəncərəsi açılmış");
            }
            catch (Exception e) {
                MP3_oyna("Xata. Alert pəncərəsi açılmalı idi");
                Xatayı_Xata_Faylına_Yaz("YOXLA_Alert_pəncərə_açıldığını. XATA=Alert_pəncərə_YOX... " + e.Message);
            }
            //   driver.SwitchTo().Alert().Accept();
        } 

         
        [Step("YOXLA: Dəyişgənin dəyərinin səhifədə METN olaraq: Dəyişgən=<Dəyişgən>; Olduğunu_olmadığını=<olduğunu_olmadığını>; tapilsa_ses=<tapilsa_ses>; tapilmazsa_ses=<tapilmazsa_ses>")]
        public void YOXLA_Dəyişgənin_dəyərinin_Səhifədə_METN_olaraq_olduğunu_olmadığını(string Dəyişgən, string olduğunu_olmadığını, string tapilsa_ses="", string tapilmazsa_ses= "")
        {
            string Dəyişgənin_dəyəri = Əsnək_String_Dəyişgənlər_Cədvəli[Dəyişgən];
            TestLogaYaz("YOXLA_Dəyişgənin_dəyərinin_Səhifədə_olduğunu_olmadığını:");
            TestLogaYaz("Dəyişgən="+ Dəyişgən); 
            TestLogaYaz("Dəyişgənin dəyəri="+ Dəyişgənin_dəyəri); 

            // (string olduğunu_olmadığını, string mətn, string mətn_ismi_ses_fayli, string sesli_veya_sessiz= "sessiz", string ehtiva_edir_ya_dəqiq_uyğunluq= "ehtiva_edir")
            YOXLA_Mətnin_Səhifədə_olduğunu_olmadığını(
                        olduğunu_olmadığını: olduğunu_olmadığını, 
                        mətn : Dəyişgənin_dəyəri, 
                        axtarma_yoxlama_ilk_səs_faylı: "",mətn_ismi_ses_fayli: "", 
                        tapildi_ses_fayli: tapilsa_ses,
                        tapilmadi_ses_fayli: tapilmazsa_ses,
                        ehtiva_edir_ya_dəqiq_uyğunluq: "ehtiva_edir",
                        tapilmazsa_testi_fail_et: "xeyr" );


            /*Boolean tapildi_ya_yox = YOXLA_Mətnin_Səhifədə_olduğunu_olmadığını(olduğunu_olmadığını, Dəyişgənin_dəyəri, "");

            if (tapilsa_ses !="" && tapildi_ya_yox == true)
                    MP3_oyna(tapilsa_ses);

            if (tapilsa_ses !="" && tapildi_ya_yox == false)
                    MP3_oyna(tapilmazsa_ses);
            */
        }

        [Step("YOXLA: Dəyişgənin dəyərini XPath olaraq al, və o XPathdə obyekt səhifədə olduğunu: Dəyişgən=<Dəyişgən>; Olduğunu_olmadığını=<olduğunu_olmadığını>; tapilsa_ses=<tapilsa_ses>; tapilmazsa_ses=<tapilmazsa_ses>")]
        public void YOXLA_Dəyişgənin_dəyərinin_Səhifədə_XPath_olaraq_olduğunu_olmadığını(string Dəyişgən, string olduğunu_olmadığını, string tapilsa_ses="", string tapilmazsa_ses= "")
        {
            TestLogaYaz("YOXLA_Dəyişgənin_dəyərinin_Səhifədə_XPath_olaraq_olduğunu_olmadığını: Dəyişgən="+ Dəyişgən);

            try { 
                string axtarılan_obyektin_XPathi =  Əsnək_String_Dəyişgənlər_Cədvəli[Dəyişgən];

                TestLogaYaz("YOXLA_Dəyişgənin_dəyərinin_Səhifədə_XPath_olaraq_olduğunu_olmadığını: Axtarılan_obyektin_XPathi="+ axtarılan_obyektin_XPathi); 

                YOXLA_Obyekt_ekranda_OLDUĞUNU_XPath_ilə(axtarılan_obyektin_XPathi, tapilsa_ses: tapilsa_ses, tapilmazsa_ses: tapilmazsa_ses);                
            } catch (Exception e) {
                Xatayı_Xata_Faylına_Yaz("YOXLA_Dəyişgənin_dəyərinin_Səhifədə_XPath_olaraq_olduğunu_olmadığını: Dəyişgən = " + Dəyişgən + "--- XATA = " + e.Message);
                return;
            }
 

        }

        [Step("YOXLA: Dəyişgənin dəyərinin səhifədə BOLD <olduğunu_olmadığını>: <Dəyişgən>")]
        public void 
        YOXLA_Dəyişgənin_dəyərinin_Səhifədə_BOLD_olduğunu_olmadığını(string olduğunu_olmadığını, string Dəyişgən){

            string Dəyişgənin_dəyəri = Əsnək_String_Dəyişgənlər_Cədvəli[Dəyişgən];
            TestLogaYaz("YOXLA: Dəyişgənin dəyərinin səhifədə BOLD " + olduğunu_olmadığını + " yoxlanir. Dəyişgən=" + Dəyişgən + "--Dəyişgənin_dəyəri=" + Dəyişgənin_dəyəri);

            try {
                Saniyə_Gözlə(1);

                IWebElement səhifə_element= driver.FindElement(By.XPath("//*[contains(text(), '" + Dəyişgənin_dəyəri + "')]"));

                ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid "+ CONSTANTlar.UI_DA_YAZI_YOXLAMA_KƏNAR_RƏNGI+ "'", səhifə_element);
        

                Saniyə_Gözlə(2);
                
                səhifə_element= driver.FindElement(By.XPath("//*[contains(text(), '" + Dəyişgənin_dəyəri + "')]"));

                String fontWeight = səhifə_element.GetCssValue("font-weight");
                if (fontWeight.Equals("700"))
                    fontWeight = "Bold";
                else if (fontWeight.Equals("400"))
                    fontWeight = "Normal";
                // 700 = bold
                // 400=Normal

                TestLogaYaz("\tFont weight (700 = bold; 400=Normal)="+ fontWeight);           
                // https://www.seleniumeasy.com/selenium-tutorials/how-to-get-css-values-using-webdriver
                // https://developer.mozilla.org/en-US/docs/Web/CSS/@font-face/font-weight
                if (olduğunu_olmadığını == "OLDUĞUNU")  {
                    //Assert.True(fontWeight.Equals("Bold"), "X TEST UGURSUZ: YOXLA_Mətnin_Səhifədə_BOLD_Olub_Olmadigni: mətn BOLD deyil");
                    if (fontWeight.Equals("Bold")) // PASS
                        TestLogaYaz("✓ TEST GEÇTI: mətn BOLD OLMALI, VE BOLD DUR"); 
                    else // FAIL
                        Xatayı_Xata_Faylına_Yaz("YOXLA_Dəyişgənin_dəyərinin_Səhifədə_BOLD_olduğunu_olmadığını: mətn **BOLD OLMALI, AMA deyil**. metn=" + Dəyişgənin_dəyəri);
                }
                else if (olduğunu_olmadığını == "OLMADIĞINI") {
                    //ssert.True(fontWeight.Equals("Normal"), "X TEST UGURSUZ: YOXLA_Mətnin_Səhifədə_BOLD_Olub_Olmadigni: mətn NORMAL (unbold) deyil");
                    if (fontWeight.Equals("Normal")) // PASS
                        TestLogaYaz("✓ TEST GEÇTI: mətn BOLD OLMAMALI, VE BOLD DEYIL"); 
                    else // FAIL
                        Xatayı_Xata_Faylına_Yaz("YOXLA_Dəyişgənin_dəyərinin_Səhifədə_BOLD_olduğunu_olmadığını: mətn **BOLD OLMAMALI, AMA bold'DUR**. metn=" + Dəyişgənin_dəyəri);
                }
                else 
                    Assert.Fail("Kod bura gelmemeli");

                səhifə_element= driver.FindElement(By.XPath("//*[contains(text(), '" + Dəyişgənin_dəyəri + "')]"));
                ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid white'", səhifə_element);

            }
            catch (Exception e) {
                Xatayı_Xata_Faylına_Yaz("YOXLA_Dəyişgənin_dəyərinin_Səhifədə_BOLD_olduğunu_olmadığını. Mesaj=" + e.Message);
            }
        }

        [Step("YOXLA: Səhifə URLi bumu: <beklenen_URL>")]
        public void YOXLA_sehife_URLi_bumu(String beklenen_URL) 
        {



        }

        [Step("YOXLA: Excel fayl yoxlaması: XLS_fayl_path_bu_dəyişgəndə = <XLS_fayl_path_dəyişgəni>; yoxlama=<yoxlama_əmri>")]
        public void YOXLA_Excel_fayl(string XLS_fayl_path_dəyişgəni, string yoxlama_əmri) {
            System.Console.WriteLine("-----------------------------");
            System.Console.WriteLine("YOXLA_Excel_fayl:");            
            System.Console.WriteLine("-----------------------------");

            string XLS_fayl_full_path_name = Əsnək_String_Dəyişgənlər_Cədvəli[XLS_fayl_path_dəyişgəni];

            System.Console.WriteLine("YOXLA_Excel_fayl: faylı açıram = " + XLS_fayl_full_path_name);

            try {

                Microsoft.Office.Interop.Excel.Application xlApp = new  Microsoft.Office.Interop.Excel.Application();
                
                xlApp.DisplayAlerts = false;

                Excel.Workbook xlWorkbook = xlApp.Workbooks.Open(@XLS_fayl_full_path_name);

                //MP3_oyna("Eksel fayl uğurla proqram içində açıldı");

                Excel._Worksheet birinci_worksheet = (Excel._Worksheet) xlWorkbook.Sheets[1];

                int rowCount;
                int last_used_row ;
                rowCount = birinci_worksheet.UsedRange.Rows.Count;

                last_used_row = birinci_worksheet.Cells.Find("*",System.Reflection.Missing.Value, 
                        System.Reflection.Missing.Value, System.Reflection.Missing.Value, 
                        Excel.XlSearchOrder.xlByRows,Excel.XlSearchDirection.xlPrevious, 
                        false,System.Reflection.Missing.Value,System.Reflection.Missing.Value).Row;

                System.Console.WriteLine("");
                System.Console.WriteLine("XLS'de rowCount = " + rowCount);

                System.Console.WriteLine("XLS'de last_used_row = " + last_used_row);

                int bəklənən_deyer_ekrandakı_sətir_sayısı = 0;
                int XLS_fayldaki_sətir_sayısı = 0;

                switch (yoxlama_əmri) {
                    //case "XLS sətir sayısı butov_təşkilatlar_konfiqurasiyalar_sətir_sayısı dəyişgəni ilə bərabər di?": 

                    case "Eksel fayldakı sətir sayı == Ekrandakı sətir sayı?":
                        bəklənən_deyer_ekrandakı_sətir_sayısı=Int32.Parse( Əsnək_String_Dəyişgənlər_Cədvəli["Ekrandakı sətir sayısı"]);

                        XLS_fayldaki_sətir_sayısı = rowCount - 1; // XLS failda, 1ci setir header'dir: "Adi" ...

                        System.Console.WriteLine("-----------------------------");
                        System.Console.WriteLine("bəklənən_deyer_ekrandakı_sətir_sayısı = " + bəklənən_deyer_ekrandakı_sətir_sayısı);

                        if ( bəklənən_deyer_ekrandakı_sətir_sayısı == XLS_fayldaki_sətir_sayısı)
                            MP3_oyna("YOXLAMA UĞURLU. Müqayisə olan iki dəyər birdirlər");
                        else {
                            MP3_oyna("YOXLAMA UĞURSUZ. XATA. Müqayisə olan iki dəyər bir deyillər");

                            Xatayı_Xata_Faylına_Yaz("Eksel fayldakı sətir sayı <> Ekrandakı sətir sayı ->\n " + 

                            "bəklənən_deyer_ekrandakı_sətir_sayısı = " + bəklənən_deyer_ekrandakı_sətir_sayısı + "--AMMA:\n " + 
                            
                            "XLS_fayldaki_sətir_sayısı = " + XLS_fayldaki_sətir_sayısı);
                        }
                        break;

                    case "TC5.11.6-Eksel fayldakı sətir sayı == Ekrandakı sətir sayı?":
                        bəklənən_deyer_ekrandakı_sətir_sayısı=Int32.Parse( Əsnək_String_Dəyişgənlər_Cədvəli["Ekrandakı sətir sayısı"]);

                        XLS_fayldaki_sətir_sayısı = rowCount - 2; 
                        // XLS faylda, 1ci setir header'dir: "Adi" ...
                        // TC5.11.6 ucun, XLS faylda, 2ci setir de 0.00 deyeri var

                        System.Console.WriteLine("-----------------------------");
                        System.Console.WriteLine("TC5.11.6-bəklənən_deyer_ekrandakı_sətir_sayısı = " + bəklənən_deyer_ekrandakı_sətir_sayısı);

                        if ( bəklənən_deyer_ekrandakı_sətir_sayısı == XLS_fayldaki_sətir_sayısı)
                            MP3_oyna("YOXLAMA UĞURLU. Müqayisə olan iki dəyər birdirlər");
                        else {
                            MP3_oyna("YOXLAMA UĞURSUZ. XATA. Müqayisə olan iki dəyər bir deyillər");

                            Xatayı_Xata_Faylına_Yaz("Eksel fayldakı sətir sayı <> Ekrandakı sətir sayı ->\n " + 

                            "bəklənən_deyer_ekrandakı_sətir_sayısı = " + bəklənən_deyer_ekrandakı_sətir_sayısı + "--AMMA:\n " + 
                            
                            "XLS_fayldaki_sətir_sayısı = " + XLS_fayldaki_sətir_sayısı);
                        }                    
                        break;
                    //----------------------------------------------------------------

                    case "1.4.2-Dəyişgəndəki təşkilatin sətir sayısı ('Ekrandakı təşkilat adı') == Bu dəyişgəndəki dəyər ('Konfiqurasiyaların sətir sayısı')?":

                    // ="15.0.4795.1001"
                    //           "lib/netstandard2.0/Microsoft.Office.Interop.Excel.dll": {}
                        string təşkilatın_adı = Əsnək_String_Dəyişgənlər_Cədvəli["Ekrandakı təşkilat adı"];

                    //if (!File.Exists(XLS_fayl_full_path_name)) 


                        // https://learn.microsoft.com/en-us/dotnet/api/microsoft.office.interop.excel.range.find?view=excel-pia
                        
                        // Find (object What, object After, object LookIn, object LookAt, object SearchOrder, Microsoft.Office.Interop.Excel.XlSearchDirection SearchDirection = Microsoft.Office.Interop.Excel.XlSearchDirection.xlNext, object MatchCase, object MatchByte, object SearchFormat);

                        rowCount = birinci_worksheet.UsedRange.Rows.Count;

                        last_used_row = birinci_worksheet.Cells.Find("*",System.Reflection.Missing.Value, 
                                System.Reflection.Missing.Value, System.Reflection.Missing.Value, 
                                Excel.XlSearchOrder.xlByRows,Excel.XlSearchDirection.xlPrevious, 
                                false,System.Reflection.Missing.Value,System.Reflection.Missing.Value).Row;

                        System.Console.WriteLine("");
                        System.Console.WriteLine("rowCount = " + rowCount);

                        System.Console.WriteLine("last_used_row = " + last_used_row);

                        // TBD: Assert 
                        Excel.Range currentFind = null; 
                        Excel.Range firstFind = null; 

                        Excel.Range ŞİRKƏT_RANGI = birinci_worksheet.UsedRange;
                        // You should specify all these parameters every time you call this method,
                        // since they can be overridden in the user interface. 

                        // "PROSYS MMC"

                        currentFind = ŞİRKƏT_RANGI.Find(təşkilatın_adı, System.Reflection.Missing.Value,
                            Excel.XlFindLookIn.xlValues, Excel.XlLookAt.xlPart, 
                            Excel.XlSearchOrder.xlByRows, Excel.XlSearchDirection.xlNext, false,
                            System.Reflection.Missing.Value, System.Reflection.Missing.Value); 

                        int nece_dene_find_ŞİRKƏT_ismi = 0;
                        while(currentFind != null) 
                        { 
                            nece_dene_find_ŞİRKƏT_ismi ++;
                            // Keep track of the first range you find. 
                            if (firstFind == null)
                            {
                                firstFind = currentFind; 
                            }

                            // If you didn't move to a new range, you are done.
                            else if (currentFind.get_Address(Excel.XlReferenceStyle.xlA1)
                                == firstFind.get_Address(Excel.XlReferenceStyle.xlA1))
                            {
                                break;
                            }

                            currentFind.Font.Color = System.Drawing.ColorTranslator.ToOle(System.Drawing.Color.Red);
                            currentFind.Font.Bold = true; 
                            currentFind = ŞİRKƏT_RANGI.FindNext(currentFind); 
                        }

                        System.Console.WriteLine("nece_dene_find_ŞİRKƏT_ismi = " + nece_dene_find_ŞİRKƏT_ismi);
                        System.Console.WriteLine("");

                        int XLS_fayldaki_təşkilatın_konfiqurasiyaların_sətir_sayısı = nece_dene_find_ŞİRKƏT_ismi;

                        int bəklənən_təşkilatın_konfiqurasiyaların_sətir_sayısı=Int32.Parse( Əsnək_String_Dəyişgənlər_Cədvəli["Konfiqurasiyaların sətir sayısı"]);

                        System.Console.WriteLine("-----------------------------");
                        System.Console.WriteLine("bəklənən_təşkilatın_konfiqurasiyaların_sətir_sayısı = " + bəklənən_təşkilatın_konfiqurasiyaların_sətir_sayısı);
                        
                        System.Console.WriteLine("XLS_fayldaki_təşkilatın_konfiqurasiyaların_sətir_sayısı = " + XLS_fayldaki_təşkilatın_konfiqurasiyaların_sətir_sayısı);
                                                
                        System.Console.WriteLine("-----------------------------");
                        if ( bəklənən_təşkilatın_konfiqurasiyaların_sətir_sayısı == XLS_fayldaki_təşkilatın_konfiqurasiyaların_sətir_sayısı)
                            MP3_oyna("YOXLAMA UĞURLU. Müqayisə olan iki dəyər birdirlər");
                        else {
                            MP3_oyna("YOXLAMA UĞURSUZ. XATA. Müqayisə olan iki dəyər bir deyillər");

                            Xatayı_Xata_Faylına_Yaz("1.4.2-Dəyişgəndəki təşkilatin sətir sayısı ('Ekrandakı təşkilat adı') == Bu dəyişgəndəki dəyər ('Konfiqurasiyaların sətir sayısı') ->\n " + 

                            "bəklənən_təşkilatın_konfiqurasiyaların_sətir_sayısı = " + bəklənən_təşkilatın_konfiqurasiyaların_sətir_sayısı + "--AMMA:\n " + 
                            
                            "XLS_fayldaki_təşkilatın_konfiqurasiyaların_sətir_sayısı = " + XLS_fayldaki_təşkilatın_konfiqurasiyaların_sətir_sayısı);
                        }
                    break;

                } // of switch-case

                xlWorkbook.Close(false, false, false);

                xlApp.Workbooks.Close();
                xlApp.Quit();
                System.Runtime.InteropServices.Marshal.ReleaseComObject(xlApp);
                //MP3_oyna("Eksel fayl avtomat test proqramı içində bağlandı");
            }

            catch (Exception e) {
                //System.Console.WriteLine("--- XATA: YOXLA_Excel_fayl: file = " + XLS_fayl_full_path_name + " --- XATA = " + e.Message);
                
                Xatayı_Xata_Faylına_Yaz("YOXLA_Excel_fayl - Excel fayli analiz etmekde xata gorundu. XLS_fayl_full_path_name = " + XLS_fayl_full_path_name + " XATA = "  + e.Message);
            }

        }

        
        [Step("YOXLA: Excel fayl yoxlaması deyer ile: XLS_fayl_path_bu_dəyişgəndə = <XLS_fayl_path_dəyişgəni_deyer_ile>; yoxlama=<yoxlama_əmri_deyer_ile>")]
        public void YOXLA_Excel_fayl_deyer_ile(string XLS_fayl_path_dəyişgəni_deyer_ile, string yoxlama_əmri_deyer_ile) {
            System.Console.WriteLine("-----------------------------");
            System.Console.WriteLine("YOXLA_Excel_fayl:");            
            System.Console.WriteLine("-----------------------------");

            string XLS_fayl_full_path_name_deyer = Əsnək_String_Dəyişgənlər_Cədvəli[XLS_fayl_path_dəyişgəni_deyer_ile];

            System.Console.WriteLine("YOXLA_Excel_fayl: faylı açıram = " + XLS_fayl_full_path_name_deyer);

            try {

                Microsoft.Office.Interop.Excel.Application xlApp = new  Microsoft.Office.Interop.Excel.Application();
                
                xlApp.DisplayAlerts = false;

                Excel.Workbook xlWorkbook = xlApp.Workbooks.Open(@XLS_fayl_full_path_name_deyer);

                MP3_oyna("Eksel fayl uğurla proqram içində açıldı");

                Excel._Worksheet birinci_worksheet = (Excel._Worksheet) xlWorkbook.Sheets[1];

                int mebleg;
                int last_used_row ;
                mebleg = birinci_worksheet.Cells[1, 17].Value;
                last_used_row = birinci_worksheet.Cells.Find("*",System.Reflection.Missing.Value, 
                        System.Reflection.Missing.Value, System.Reflection.Missing.Value, 
                        Excel.XlSearchOrder.xlByRows,Excel.XlSearchDirection.xlPrevious, 
                        false,System.Reflection.Missing.Value,System.Reflection.Missing.Value).Row;

                System.Console.WriteLine("");

                switch (yoxlama_əmri_deyer_ile) {
                    //case "XLS sətir sayısı butov_təşkilatlar_konfiqurasiyalar_sətir_sayısı dəyişgəni ilə bərabər di?": 

                    case "Eksel fayldakı qiymet  == Mebleg?":
                        
                        string meblegStr = Əsnək_String_Dəyişgənlər_Cədvəli["Mebleg"];
                        int bəklənən_deyer_ekrandakı_qiymet = int.Parse(meblegStr.Split(',')[0].Replace(" ", ""));


                        int XLS_fayldaki_qiymet = mebleg; 

                        System.Console.WriteLine("-----------------------------");
                        System.Console.WriteLine("bəklənən_deyer_ekrandakı_qiymet = " + bəklənən_deyer_ekrandakı_qiymet);

                        if ( bəklənən_deyer_ekrandakı_qiymet == XLS_fayldaki_qiymet)
                            MP3_oyna("YOXLAMA UĞURLU. Müqayisə olan iki dəyər birdirlər");
                        else {
                            MP3_oyna("YOXLAMA UĞURSUZ. XATA. Müqayisə olan iki dəyər bir deyillər");

                            Xatayı_Xata_Faylına_Yaz("Eksel fayldakı sətir sayı <> Ekrandakı sətir sayı ->\n " + 

                            "bəklənən_deyer_ekrandakı_qiymet = " + bəklənən_deyer_ekrandakı_qiymet + "--AMMA:\n " + 
                            
                            "XLS_fayldaki_sətir_sayısı = " + XLS_fayldaki_qiymet);
                        }
                        break;
   

                } // of switch-case

                xlWorkbook.Close(false, false, false);

                xlApp.Workbooks.Close();
                xlApp.Quit();
                System.Runtime.InteropServices.Marshal.ReleaseComObject(xlApp);
                //MP3_oyna("Eksel fayl avtomat test proqramı içində bağlandı");
            }

            catch (Exception e) {
                System.Console.WriteLine("--- XATA: \n YOXLA_Excel_fayl: file = " + XLS_fayl_full_path_name_deyer + " --- XATA = " + e.Message);
            }

        }

        [Step("YOXLA: Iki dəyişgənin bərabər olduğunu: <dəyişgən1>, <dəyişgən2>; bərabərlik_MP3=<bərabərlik_MP3>; qeyri_bərabərlik_MP3=<qeyri_bərabərlik_MP3>")]
        public void YOXLA_Iki_dəyişgənin_bərabər_olduğunu(string dəyişgən1, string dəyişgən2, string bərabərlik_MP3, string qeyri_bərabərlik_MP3)
        {
            if (Əsnək_String_Dəyişgənlər_Cədvəli[dəyişgən1].CompareTo(Əsnək_String_Dəyişgənlər_Cədvəli[dəyişgən2]) == 0) { // beraber dirler 
                MP3_oyna("Test passed-SUCCESS");
                MP3_oyna(bərabərlik_MP3);
            }
            else {// beraber DEYILLER
                MP3_oyna("Test failed-WIN ERROR SOUND");
                MP3_oyna(qeyri_bərabərlik_MP3);
                Xatayı_Xata_Faylına_Yaz("YOXLA_Iki_dəyişgənin_bərabər_olduğunu: beraber DEYILLER ->" + Əsnək_String_Dəyişgənlər_Cədvəli[dəyişgən1] + "--ve--" + Əsnək_String_Dəyişgənlər_Cədvəli[dəyişgən2]);
            }
        }

        [Step("YOXLA: mətnin səhifədə <olduğunu_olmadığını>: mətn = <mətn>; axtarma_yoxlama_ilk_səs_faylı = <axtarma_yoxlama_ilk_səs__faylı>; mətn_ismi_ses_fayli = <mətn_ismi_ses_fayli>; tapildi_ses_fayli = <tapildi_ses_fayli>; tapilmadi_ses_fayli = <tapilmadi_ses_fayli>; ehtiva_edir_ya_dəqiq_uyğunluq = <dəqiq_uyğunluq>; tapilmazsa_testi_fail_et=<tapilmazsa_testi_fail_et>")]
        // Olub_Olmadigni_Yoxla
        public Boolean YOXLA_Mətnin_Səhifədə_olduğunu_olmadığını(
            string olduğunu_olmadığını, 
            string mətn, 
            string axtarma_yoxlama_ilk_səs_faylı, 
            string mətn_ismi_ses_fayli, 
            string tapildi_ses_fayli,
            string tapilmadi_ses_fayli,
            string ehtiva_edir_ya_dəqiq_uyğunluq,
            string tapilmazsa_testi_fail_et){

            TestLogaYaz("Mətnin səhifədə " + olduğunu_olmadığını + " yoxlanır: " + mətn);

            string XPath_string = "";
            if (ehtiva_edir_ya_dəqiq_uyğunluq.Equals("ehtiva_edir")) 
                 XPath_string = "//*[contains(text(), '" + mətn + "')]";
            else // dəqiq_uyğunluq
                 XPath_string = "//*[text()='" + mətn + "']";
            
            TestLogaYaz("XPath_string= "+ XPath_string); 

            if (axtarma_yoxlama_ilk_səs_faylı != "")
                //MP3_oyna("");
                MP3_oyna(axtarma_yoxlama_ilk_səs_faylı);


            try {
                IWebElement element;
                if (olduğunu_olmadığını.ToUpper() == "OLDUĞUNU") {

                    Boolean tapildi = false;

                    //if (driver.FindElement(By.TagName("body")).Text.Contains(mətn)) {
                    try {
                        
                        //driver.FindElement(By.XPath("//*[contains(text(), '" + mətn + "')]");

                        element = driver.FindElement(       
                            //By.XPath("//*[text()[contains(., '" + mətn + "')]]")
                            By.XPath(XPath_string)
                        );

                        if (!IsElementVisibleInViewport(element)){
                            ((IJavaScriptExecutor) driver).ExecuteScript(
                                "arguments[0].scrollIntoView();", element);
                            
                            TestLogaYaz("Mətnin_Səhifədə_olduğunu_olmadığını_YOXLA: Element gorunsun diye, scroll ettim..."); 
                        }



                        ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid "+ CONSTANTlar.UI_DA_YAZI_YOXLAMA_KƏNAR_RƏNGI+"'", element);


                        if (mətn_ismi_ses_fayli != "")
                            MP3_oyna(mətn_ismi_ses_fayli);

                        TestLogaYaz("\t ✓ TEST GEÇTI: Mətn səhifədə tapıldı");
                        tapildi = true;
                        if (tapildi_ses_fayli != "") 
                            MP3_oyna(tapildi_ses_fayli);

                        /*if (sesli_veya_sessiz== "sesli")
                            MP3_oyna("Mətn tapıldı");
                        */
                        //if (sesli_veya_sessiz == "sesli")  {
                            // tapildi
                            //MP3_oyna("Test passed-SUCCESS");
                            //else 
                            //    MP3_oyna("Mətn tapıldı");
                        //}
                      
                        //Saniyə_Gözlə(1);
                        MilliSaniyə_Gözlə(200);

                        ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid white'", element);
                        return true;
                    }
                    catch (Exception) {

                        if (!tapildi) {
                            TestLogaYaz("\t X: TEST UĞURSUZ OLDU: Mətn səhifədə tapılMAdı.");
                            
                            if (tapilmadi_ses_fayli != "") 
                                MP3_oyna(tapilmadi_ses_fayli);

                            Xatayı_Xata_Faylına_Yaz("Mətn səhifədə tapılmadı. Metn=" + mətn);

                            if (tapilmazsa_testi_fail_et == "bəli") {
                                MP3_oyna("Çünki testin bu addımı uğursuz oldu, və testin davam etməsi mümkün deyil, test indi uğursuz FEYL statusda durur.");
                                driver.Quit();
                                Assert.Fail();

                            }
                        }

                    }
                }
                else { // olmadığını
                    TestLogaYaz("YOXLA_Mətnin_Səhifədə_olduğunu_olmadığını I By.TagName(body) cagirmadan once...");

                    Boolean olmamali_ama_tapildi = driver.FindElement(By.TagName("body")).Text.Contains(mətn);

                    TestLogaYaz("YOXLA_Mətnin_Səhifədə_olduğunu_olmadığını I By.TagName(body) cagirmadan sonra...");

                    /*if (sesli_veya_sessiz == "sesli")   
                        MP3_oyna("Mətnin səhifədə olmadığını yoxlayıram");
*/
                    if (mətn_ismi_ses_fayli != "")
                        MP3_oyna(mətn_ismi_ses_fayli);

                    //if (!driver.PageSource.Contains(mətn))
                    if (olmamali_ama_tapildi) {
                        TestLogaYaz("\t X: TEST UĞURSUZ OLDU: Mətn səhifədə var, ama olmamali.");

                            if (tapildi_ses_fayli != "") 
                                MP3_oyna(tapildi_ses_fayli);

/*
                        if (sesli_veya_sessiz == "sesli")  {
                            MP3_oyna("Test failed-WIN ERROR SOUND");

                            else 
                                MP3_oyna("Mətn səhifədə var, amma olmamalı idi");
                        }                        
*/
                        //File.WriteAllText(@"C:\driver_PageSource_dump.txt", driver.PageSource);
                        //TestLogaYaz("\t Sehife metni C:\\driver_PageSource_dump.txt faylina yazildi");
                        //Assert.Fail(); 
                        Xatayı_Xata_Faylına_Yaz("Mətn səhifədə var, ama olmali di. Metn=" + mətn);
                    }
                    else {
                        TestLogaYaz("\t ✓ TEST GEÇTI: Mətn səhifədə yoxdur, ve olmamali");

                        if (tapilmadi_ses_fayli != "") 
                            MP3_oyna(tapilmadi_ses_fayli);

                        /*if (sesli_veya_sessiz == "sesli")  {
                            MP3_oyna("Test passed-SUCCESS");

                            else 
                                MP3_oyna("Mətn səhifədə yox, və olmamalı idi");
                        }*/


                    }                    
                      
                        
                }
            }
            catch (Exception e) {
                    Xatayı_Xata_Faylına_Yaz("Mətnin_Səhifədə_olduğunu_olmadığını_Yoxla. XƏTA = " + e.Message);
            }
            return false;

           
        }  

        [Step("YOXLA: Mətnin səhifədə BOLD <olduğunu_olmadığını>: <mətn>")]
        public void YOXLA_Mətnin_Səhifədə_BOLD_Olub_Olmadigni(string olduğunu_olmadığını, string mətn){
             TestLogaYaz("Mətnin səhifədə BOLD " + olduğunu_olmadığını + " yoxlanir. Mətn=" + mətn);
             MP3_oyna("Mətnin səhifədə BOLD olub olmadığını yoxluram");
             Saniyə_Gözlə(2);

            if (mətn == "Yeni daxil-olan sənədin nömrəsi") {
                mətn = Əsnək_String_Dəyişgənlər_Cədvəli["Yeni daxil-olan sənədin nömrəsi"];
                TestLogaYaz("Yeni_sənədin_nömrəsi="+ mətn); 
            }

            //Mətnin_Səhifədə_olduğunu_olmadığını_Yoxla("OLDUĞUNU", mətn);
            
            try {
                Saniyə_Gözlə(1);

                IWebElement səhifə_element= driver.FindElement(By.XPath("//*[contains(text(), '" + mətn + "')]"));

                ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid "+ CONSTANTlar.UI_DA_YAZI_YOXLAMA_KƏNAR_RƏNGI+ "'", səhifə_element);
        

                Saniyə_Gözlə(2);
                
                səhifə_element= driver.FindElement(By.XPath("//*[contains(text(), '" + mətn + "')]"));

                String fontWeight = səhifə_element.GetCssValue("font-weight");
                if (fontWeight.Equals("700"))
                    fontWeight = "Bold";
                else if (fontWeight.Equals("400"))
                    fontWeight = "Normal";
                // 700 = bold
                // 400=Normal

                TestLogaYaz("\tFont weight (700 = bold; 400=Normal)="+ fontWeight);           
                // https://www.seleniumeasy.com/selenium-tutorials/how-to-get-css-values-using-webdriver
                // https://developer.mozilla.org/en-US/docs/Web/CSS/@font-face/font-weight
                if (olduğunu_olmadığını == "OLDUĞUNU")  {
                    //Assert.True(fontWeight.Equals("Bold"), "X TEST UGURSUZ: YOXLA_Mətnin_Səhifədə_BOLD_Olub_Olmadigni: mətn BOLD deyil");
                    if (fontWeight.Equals("Bold")) { // PASS 
                        MP3_oyna("Test geçti-mətn bold olmali və bolddur");
                        TestLogaYaz("✓ TEST GEÇTI: mətn BOLD OLMALI, VE BOLD DUR"); 
                    }
                    else {// FAIL
                        MP3_oyna("XATA-Mətn bold olmali- amma deyil");
                        Xatayı_Xata_Faylına_Yaz("YOXLA_Mətnin_Səhifədə_BOLD_Olub_Olmadigni: mətn **BOLD OLMALI, AMA deyil**. metn=" + mətn);
                    }
                }
                else if (olduğunu_olmadığını == "OLMADIĞINI") {
                    //ssert.True(fontWeight.Equals("Normal"), "X TEST UGURSUZ: YOXLA_Mətnin_Səhifədə_BOLD_Olub_Olmadigni: mətn NORMAL (unbold) deyil");
                    if (fontWeight.Equals("Normal")) { // PASS
                        TestLogaYaz("✓ TEST GEÇTI: mətn BOLD OLMAMALI, VE BOLD DEYIL"); 
                    }
                    else // FAIL
                        Xatayı_Xata_Faylına_Yaz("YOXLA_Mətnin_Səhifədə_BOLD_Olub_Olmadigni: mətn **BOLD OLMAMALI, AMA bold'DUR**. metn=" + mətn);
                }
                else 
                    Assert.Fail("Kod bura gelmemeli");

                səhifə_element= driver.FindElement(By.XPath("//*[contains(text(), '" + mətn + "')]"));
                ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid white'", səhifə_element);

            }
            catch (Exception e) {
                Xatayı_Xata_Faylına_Yaz("XƏTA: YOXLA_Mətnin_Səhifədə_BOLD_Olub_Olmadigni. Mesaj=" + e.Message);
            }
        }


        [Step("YOXLA: Ekranda obyektin mətni, dəyişgənin dəyəri ilə bərabərdi? obyekt_tapma_modu = <mod_ID_ya_XPath_ya_XPath_cədvəl_ID>;  object_ID_ya_XPath = <object_ID_ya_XPath>; dəyişgən = <dəyişgən_adı>; bərabər_səs = <bərabər_səs>; bərabər_olmazsa_səs = <bərabər_olmazsa_səs>")]        
        
        public void YOXLA_Obyektin_Mətni_dəyişgən_ilə_bərabərdi(
                                string mod_ID_ya_XPath_ya_XPath_cədvəl_ID, 
                                string object_ID_ya_XPath, 
                                string dəyişgən_adı, 
                                string bərabər_səs="", 
                                string bərabər_olmazsa_səs= "") {

            TestLogaYaz("----------------------------");
            TestLogaYaz("YOXLA_Obyektin_Mətni_dəyişgən_ilə_bərabərdi?");

            TestLogaYaz("mod_ID_ya_XPath_ya_XPath_cədvəl_ID = " + mod_ID_ya_XPath_ya_XPath_cədvəl_ID);
            TestLogaYaz("object_ID_ya_XPath = " + object_ID_ya_XPath);
            TestLogaYaz("dəyişgən_adı = " + dəyişgən_adı);
            
            string dəyişgənin_dəyəri = Əsnək_String_Dəyişgənlər_Cədvəli[dəyişgən_adı];
            
            TestLogaYaz("dəyişgənin_dəyəri = " + dəyişgənin_dəyəri);

            YOXLA_Obyektin_Mətnini_gözlənən_mətn        
                            (mod_ID_ya_XPath_ya_XPath_cədvəl_ID, 
                                object_ID_ya_XPath, 
                                gözlənən_mətn : dəyişgənin_dəyəri,
                                bərabər_səs,
                                bərabər_olmazsa_səs);
        }

        [Step("YOXLA: ekranda obyektin mətnini (<mod_ID_ya_XPath> ilə): object_ID_ya_XPath = <object_ID_ya_XPath>; gözlənən mətn = <gözlənən mətn>; bərabər_səs = <bərabər_səs>; bərabər_olmazsa_səs = <bərabər_olmazsa_səs>")]
        public void YOXLA_Obyektin_Mətnini_gözlənən_mətn(
                                string mod_ID_ya_XPath, 
                                string object_ID_ya_XPath, 
                                string gözlənən_mətn, 
                                string bərabər_səs="", 
                                string bərabər_olmazsa_səs= "") {
            
            TestLogaYaz("----------------------------");
            TestLogaYaz("YOXLA_Obyektin_Mətnini_gözlənən_mətn: " + 
                    " mod_ID_ya_XPath = " + mod_ID_ya_XPath + 
                    " -- object_ID_ya_XPath = " + object_ID_ya_XPath +
                    " -- gözlənən_mətn = "+  gözlənən_mətn);
            //Boolean  bəklənən_mətn_tapıldı = false;

            string Səhifədəki_Mətn="";
            
            try {
                IWebElement element;
                
                //TestLogaYaz("10 saniyə'yə qədər bəkləyəcəm...");
                TestLogaYaz("\tObyekti axtarıram / gözlyirəm...");

                OpenQA.Selenium.By Obyekt_locator_BY = By.Id(object_ID_ya_XPath);                

                if (mod_ID_ya_XPath == "ID")
                    Obyekt_locator_BY = By.Id(object_ID_ya_XPath);

                else if (mod_ID_ya_XPath == "XPath") 
                    Obyekt_locator_BY = By.XPath(object_ID_ya_XPath);


                element = new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                        ExpectedConditions.ElementIsVisible(Obyekt_locator_BY));

                TestLogaYaz("\tObyekt tapıldı...");
                                               
                //if (!IsElementVisibleInViewport(element)) {
                    ((IJavaScriptExecutor) driver).ExecuteScript(
                        "arguments[0].scrollIntoView();", element);

                    TestLogaYaz("\tObyektə scroll etdim: ");
                //}

                ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='2px solid " + CONSTANTlar.UI_DA_YAZI_YOXLAMA_KƏNAR_RƏNGI + "'", element);
                TestLogaYaz("\t->Obyekt rəngləndirildii...");

                Saniyə_Gözlə(1);

                // visible olmasini gozle

                element = new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                    ExpectedConditions.ElementIsVisible(
                        Obyekt_locator_BY));
                        
                // səhifədəki metnini ali
                Səhifədəki_Mətn = element.GetAttribute("innerHTML"); 
                Saniyə_Gözlə(1);

                ((IJavaScriptExecutor) driver).ExecuteScript("arguments[0].style.border='1px solid white'", element);

                TestLogaYaz("\tSəhifədəki mətn="+ Səhifədəki_Mətn);

                //StringAssert.AreEqualIgnoringCase(bəklənən_mətn, Səhifədəki_Mətn, "Bəklənən mətn tapılMAdı");
                //int müqayisə_nəticəsi = bəklənən_mətn.ToUpper().CompareTo(Səhifədəki_Mətn.ToUpper());

                Boolean müqayisə_nəticəsi = gözlənən_mətn.ToUpper().Contains(Səhifədəki_Mətn.ToUpper()) || Səhifədəki_Mətn.ToUpper().Contains(gözlənən_mətn.ToUpper()); // cunku bezi zamanlar, ekstra character'ler, misal: SPACE, olur

                if (müqayisə_nəticəsi == true) {
                    TestLogaYaz("✓ TEST GEÇTI: Bəklənən mətn və Səhifədəki mətn AYNI");
                    if (bərabər_səs != "") {
                        MP3_oyna("Test passed-SUCCESS");
                        MP3_oyna(bərabər_səs);
                    }   
                }                 
                else { // bərabər DEYILLER

                    if (bərabər_olmazsa_səs != "") {
                        MP3_oyna("Test failed-WIN ERROR SOUND");
                        MP3_oyna(bərabər_olmazsa_səs);
                    } 
                    Xatayı_Xata_Faylına_Yaz("X TEST UGURSUZ: Yazını_yoxla_Check_if_text_of_item_equals_to: Bəklənən mətn və səhifədəki mətn ayni DEYIL. Müqayisə_nəticəsi=" + "--len__gözlənən_mətn=" + gözlənən_mətn.Length + "--len__Səhifədəki_Mətn=" + Səhifədəki_Mətn.Length);       
                }             
            }
            catch (Exception e) {
                if (bərabər_olmazsa_səs != "") {
                        MP3_oyna("Test failed-WIN ERROR SOUND");
                        MP3_oyna(bərabər_olmazsa_səs);
                    } 
                Xatayı_Xata_Faylına_Yaz("Yazını_yoxla_Check_if_text_of_item_equals_to...XATA=" + e.Message);
            }
        }


        [Step("YOXLA: obyekt ekranda OLDUĞUNU (XPath ilə): <obyekt_XPathi>; tapilsa_ses=<tapilsa_ses>; tapilmazsa_ses=<tapilmazsa_ses>")]
        public int YOXLA_Obyekt_ekranda_OLDUĞUNU_XPath_ilə(string obyekt_XPathi, string tapilsa_ses="", string tapilmazsa_ses= "") {
            Test_Logda_Xet_Yaz();
            TestLogaYaz("YOXLA_Obyekt_ekranda_OLDUĞUNU_XPath_ilə: " + obyekt_XPathi);
            
            try {
                IWebElement element =  new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                    ExpectedConditions.ElementIsVisible(
                        By.XPath(obyekt_XPathi)));
                TestLogaYaz("\tObyekt ekranda tapıldı");

                OBYEKTƏ_fokuslaş_və_kənarin_rəngləndir(driver.FindElement(By.XPath(obyekt_XPathi)), CONSTANTlar.UI_DA_YAZI_YOXLAMA_KƏNAR_RƏNGI);

                if (tapilsa_ses !="") {
                    MP3_oyna("Test passed-SUCCESS");
                    MP3_oyna(tapilsa_ses);
            }

                return 1;

            }
            catch (Exception e) {
                TestLogaYaz("\tObyekt ekranda tapılMAdı");
                Xatayı_Xata_Faylına_Yaz("YOXLA_Obyekt_ekranda_OLDUĞUNU_ID_ismi_ilə --XATA: " + e.Message);

                if (tapilmazsa_ses !="") {
                    MP3_oyna("Test failed-WIN ERROR SOUND");
                    MP3_oyna(tapilmazsa_ses);
                }
            }  

            return 0;
        }      

// YOXLA: obyekt ekranda OLMADIĞINI (XPath ilə): "(//span[@class='dx-datagrid-nodata'])[1]"; tapilsa_ses_XATA="1.1-Yeni əlavə olan Müvəqqəti Hesab Növü siyahıda tapıldı"; tapilmazsa_ses_PASS="1.1-Yeni əlavə olan Müvəqqəti Hesab Növü siyahıda tapılmadı"; xatada_testi_durdur="Xeyr"

        [Step("YOXLA: obyekt ekranda OLMADIĞINI (XPath ilə): <obyekt_XPathi>; tapilsa_ses_XATA=<tapilsa_ses>; tapilmazsa_ses_PASS=<tapilmazsa_ses>; xatada_testi_durdur=<xatada_testi_durdur>")]
        public int YOXLA_Obyekt_ekranda_OLMADIĞINI_XPath_ilə(string obyekt_XPathi, string tapilsa_ses, string tapilmazsa_ses, string xatada_testi_durdur) {
            Test_Logda_Xet_Yaz();
            TestLogaYaz("YOXLA_Obyekt_ekranda_OLMADIĞINI_XPath_ilə: " + obyekt_XPathi);
            
            try {
                IWebElement element =  new WebDriverWait(driver, TimeSpan.FromSeconds(CONSTANTlar.SELENIUM_ELEMENT_GOZLEME_SANIYESI)).Until(
                    ExpectedConditions.ElementIsVisible(
                        By.XPath(obyekt_XPathi)));
                TestLogaYaz("\tObyekt ekranda tapıldı");

                OBYEKTƏ_fokuslaş_və_kənarin_rəngləndir(driver.FindElement(By.XPath(obyekt_XPathi)), CONSTANTlar.UI_DA_YAZI_YOXLAMA_KƏNAR_RƏNGI);

                Xatayı_Xata_Faylına_Yaz("YOXLA_Obyekt_ekranda_OLMADIĞINI_XPath_ilə ");

                // tapıldı, AMMA olmamali
                if (tapilsa_ses !="") {
                    MP3_oyna("Test failed-WIN ERROR SOUND");
                    MP3_oyna(tapilsa_ses);
                }

                if (xatada_testi_durdur == "Bəli") {
                    Assert.Fail();
                }

                return 0;

            }
            catch (Exception e) {
                TestLogaYaz("\tObyekt ekranda tapılMAdı");


                // tapılMAdı, ve olmamali
                if (tapilmazsa_ses !="") {
                    MP3_oyna("Test passed-SUCCESS");
                    MP3_oyna(tapilmazsa_ses);
                }
            }  

            return 1;
        }   

/*
        public int YOXLA_Obyekt_ekranda_OLDUĞUNU_element_ilə(IWebElement element) {
            Test_Logda_Xet_Yaz();
            TestLogaYaz("YOXLA_Obyekt_ekranda_OLDUĞUNU_element_ilə: Obyekt ekranda olduğu yoxlanır");

            try {

                TestLogaYaz("\tObyekt ekranda tapıldı");
                return 1;

            }
            catch (Exception e) {
                TestLogaYaz("\tObyekt ekranda tapılMAdı");
                Xatayı_Xata_Faylına_Yaz("YOXLA_Obyekt_ekranda_OLDUĞUNU_element_ilə --XATA: " + e.Message);

            }  
            return 0;
        }
*/

        [Step("YOXLA: Xananın açılan siyahısında 'Məlumat yoxdur' yazısı var? xana_siyahısının_XPathi = <xana_siyahısının_XPathi>")]
        public void YOXLA_Xananın_açılan_siyahısında_MəlumatYoxdur_yazısı_var(string xana_siyahısının_XPathi) {
            // //*[@id= //input[contains(@id, 'TransactionConfigurationID')]/@aria-owns]//*[text()='Məlumat yoxdur']
            TestLogaYaz("YOXLA_Xananın_açılan_siyahısında_MəlumatYoxdur_yazısı_var: xana_siyahısının_XPathi = " + xana_siyahısının_XPathi);

            IList <IWebElement> Elementler_MəlumatYoxdur_yazısı_ilə  = driver.FindElements(By.XPath(xana_siyahısının_XPathi + "//*[text()='Məlumat yoxdur']"));
            
            int neçə_dənə = Elementler_MəlumatYoxdur_yazısı_ilə.Count;
            TestLogaYaz("YOXLA_Xananın_açılan_siyahısında_MəlumatYoxdur_yazısı_var: neçə_dənə = " + neçə_dənə.ToString());

            if (neçə_dənə > 0) { // problem var
                Xatayı_Xata_Faylına_Yaz("YOXLA_Xananın_açılan_siyahısında_MəlumatYoxdur_yazısı_var: Ciddi bir problem ilə üzləşdim. Cari tələb olunan qırmızı ilə vurğulanan xananın açılan siyahısında Məlumat Yoxdur yazısı var, və həmin siyahıda heç bir dəyər seçmək mümkün deyil. Buna görə, test otomasyonun davam etməsi mümkün deyil və durmaq məcburiyyətində ");

                MP3_oyna("Ciddi bir problem-Cari tələb olunan xananın açılan siyahısında Məlumat Yoxdur yazısı var");
                // Ciddi bir problem ilə üzləşdim. Cari tələb olunan qırmızı ilə vurğulanan xananın açılan siyahısında Məlumat Yoxdur yazısı var, və həmin siyahıda heç bir dəyər seçmək mümkün deyil. Buna görə, test otomasyonun davam etməsi mümkün deyil və durmaq məcburiyyətində

                driver.Quit();
                Assert.Fail();
            }  
        }

        [Step("YOXLA: SAXLAMADAN ONCƏ YOXLAMA: Səhifədə heçbir xana xata qırmızı ikonun olub olmadığını")]
        public void YOXLA_Səhifədə_heçbir_xana_xata_qırmızı_ikonun_olub_olmadığını() {//(string optional_xata_varsa_əmr) {
            
            IList <IWebElement> Elementler_xana_xata_qırmızı_ikonu = driver.FindElements(By.XPath("//*[@aria-invalid='true']"));
            
            int neçə_dənə = Elementler_xana_xata_qırmızı_ikonu.Count;
            TestLogaYaz("YOXLA_Səhifədə_heçbir_xana_xata_qırmızı_ikonun_olub_olmadığını: neçə_dənə = " + neçə_dənə.ToString());

            if (neçə_dənə > 0) { // problem var
                MP3_oyna("Problemlə üzləşdim. Səhifədə ən az bir xanada, verilməmiş qırmızı xata ikonası göründü");
                // Yadda saxlama düyməsindən öncə yoxlamada bir problemlə üzləşdim. Test otomasyon səhifənin bütöv tələb olunan xanalarını doldurmaya çalışdı, amma səhifədə ən az bir xanada, verilməmiş qırmızı xata ikonası göründü. Buna görə, test otomasyonun davam etməsi mümkün deyil və durmaq məcburiyyətində
                driver.Quit();
                Assert.Fail();
            }            

        }

        [Step("YOXLA: Siyahıda ən azı bir itemin olduğunu: siyahi_içərik_XPath = <siyahi_içərik_XPath>")]
        public void YOXLA_Siyahıda_ən_azı_bir_itemin_olduğunu(String siyahi_içərik_XPath)   {
            TestLogaYaz("YOXLA_Siyahidə_ən_azı_bir_itemin_olduğunu: siyahi_içərik_XPath = " + siyahi_içərik_XPath);

            IList<IWebElement> siyahinin_içəri_itemleri = driver.FindElements(By.XPath(siyahi_içərik_XPath));
            
            TestLogaYaz("siyahinin_içəri_itemleri sayisi=" + siyahinin_içəri_itemleri.Count);

            if (siyahinin_içəri_itemleri.Count == 0) {
                //driver.Quit();
                MP3_oyna("XATA. Testin davam etməsi üçün, siyahıda ən azı bir element olmalı. Test otomasyon feyl olub və durmaq məcburiyyətindədir.");
                if (CONSTANTlar.CIDDI_XATALARDA_TESTI_FAIL_ET)
                    Assert.Fail();
            }
        }

        readonly int ___XATA_RAPORLAMA_əməliyyatları;   

        [Step("Xatayı xata faylına yaz: <xeta_mesaji>; sesli_veya_sessiz = <sesli_veya_sessiz>")]
        public void Xatayı_Xata_Faylına_Yaz(string xeta_mesaji, string sesli_veya_sessiz= "sessiz")
        {
            Dəyişgən_və_dəyərini_yadda_saxla("Son test addımda xata göründü", "Bəli");

            Console.WriteLine("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            Console.WriteLine("XETA.... Testi durdurmayan bir xata gorundu:");
            Console.WriteLine(xeta_mesaji);
            test_senaryosunda_xeta_sayısı ++;
            
            if (sesli_veya_sessiz== "sesli") {
                // MP3_oyna("Testi durdurmayan bir xata göründü və fayla yazıldı");
                MP3_oyna("Bir xata göründü və xatalar log faylına yazıldı");
            }

            FileStream file = null;
            DateTime indikiTarixVeSaat_DateObject;
            if (CONSTANTlar.XETA_METNINI_FAYLA_YAZ) {
                /* ESKI yanasim:
                string xeta_file_name = ".//XATALAR//OTOMASYON_TAPAN_XATALAR//bugs.txt";
                
                if (!File.Exists(xeta_file_name)) 
                {
                    // Create the file 
                    using FileStream fs = File.Create(xeta_file_name);

                    TestLogaYaz("Xatayı_Xata_Faylına_Yaz:" + xeta_file_name + " fayli yarattim...");
                }

                file = File.Open(xeta_file_name, FileMode.Open, FileAccess.ReadWrite);
                */
                if (GLOBAL_test_calisdirma_baslama_tarix_zamani == null) {
                    indikiTarixVeSaat_DateObject = DateTime.Now;
                    GLOBAL_test_calisdirma_baslama_tarix_zamani = indikiTarixVeSaat_DateObject.ToString("yyyy.MM.dd-HH.mm");
                    Console.WriteLine("===== Xatayı_Xata_Faylına_Yaz -- GLOBAL_test_calisdirma_baslama_tarix_zamani = " + GLOBAL_test_calisdirma_baslama_tarix_zamani);
                }
               
                string xeta_file_name = ".//XATALAR//OTOMASYON_TAPAN_XATALAR//Xatalar-Test run zamani=" + GLOBAL_test_calisdirma_baslama_tarix_zamani + ".txt";
                
                if (!File.Exists(xeta_file_name)) 
                {
                    // Create the file 
                    using FileStream fs = File.Create(xeta_file_name);

                    Console.WriteLine("Xatayı_Xata_Faylına_Yaz:" + xeta_file_name + " fayli yarattim...");
                }

                file = File.Open(xeta_file_name, FileMode.Open, FileAccess.ReadWrite);            
            }

            indikiTarixVeSaat_DateObject = DateTime.Now;
            
            string indikiTarixVeSaat_String = indikiTarixVeSaat_DateObject.ToString("yyyy.MM.dd-HH.mm");//("dddd, MMMM dd, yyyy-hh.mm tt");

            string yazilacaq_butov_xata_mesac_ve_tarix = indikiTarixVeSaat_String + "---" + GLOBAL_test_case_adı + "-addim: " + GLOBAL_test_case_içində_addım + "---" + xeta_mesaji;
            
            Console.WriteLine("--- yazilacaq_butov_xata_mesac_ve_tarix = " + yazilacaq_butov_xata_mesac_ve_tarix); 

            if (CONSTANTlar.XETA_METNINI_FAYLA_YAZ) {
                Prepend_String_To_File(yazilacaq_butov_xata_mesac_ve_tarix + "\n", file);
                file.Close();
                Console.WriteLine("XETA, xeta faylina yazildi...");
            }

            // Ekran görüntüsü / Screenshot
            if (CONSTANTlar.XETA_SCREENSHOT_AL_VE_FAYLA_YAZ && driver != null) {

                string xeta_mesaji_qissa = TruncateString(xeta_mesaji, 20);
                xeta_mesaji_qissa = SanitizeText(xeta_mesaji_qissa);

                string Ekran_görüntüsü_fayl_ismi = ".//XATALAR//OTOMASYON_TAPAN_XATALAR//Ekran Görüntüleri//" + indikiTarixVeSaat_String + "---" + GLOBAL_test_case_adı + "-addim: " + GLOBAL_test_case_içində_addım + "---" + xeta_mesaji_qissa +".png";


                Screenshot ss = ((ITakesScreenshot)driver).GetScreenshot();
                            ss.SaveAsFile(Ekran_görüntüsü_fayl_ismi, 
                ScreenshotImageFormat.Png);

                Console.WriteLine("Xeta Ekran görüntüsü / Screenshot'i fayla yazildi: "+ Ekran_görüntüsü_fayl_ismi);
            }
            Console.WriteLine("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            
        }


        //------------------------------------------------------------
        readonly int _______SUT_SPESIFIK_FONKSIYALAR;
        
        [Step("YOXLA: Ekrandakı bütöv məhsulların adında bu yazı olmalı: <məhsul_adı>")]
        public void YOXLA_Ekrandakı_bütöv_məhsulların_adında_bu_yazı_olmalı(String məhsul_adı)   {
            IList<IWebElement> ekrandakı_bütöv_məhsullar = driver.FindElements(
                    By.XPath("//*[@id= 'ajax-products']//div[contains (@class, 'product-card')] "));

            // ekrandakı_bütöv_məhsullar.Count()
            for (int məhsul_index = 0; məhsul_index < 3; məhsul_index++) {
                IWebElement məhsul = ekrandakı_bütöv_məhsullar.ElementAt(məhsul_index);

                /*IWebElement məhsul_qiymeti_span = driver.FindElement(
                        By.XPath("(//div[contains (@class, 'product-card')]//div[contains (@class, 'product-price')]//span)[" + (məhsul_index + 1) + "]"));*/
                if (!IsElementVisibleInViewport(məhsul))
                    ((IJavaScriptExecutor) driver).ExecuteScript(
                            "arguments[0].scrollIntoView();", məhsul);

                OBYEKTƏ_fokuslaş_və_kənarin_rəngləndir(məhsul, CONSTANTlar.UI_DA_YAZI_YOXLAMA_KƏNAR_RƏNGI);

                String məhsul_başlığı = driver.FindElement(
                        By.XPath("(//div[contains (@class, 'product-card')]//div[contains (@class, 'product-title1')]//a)[" + (məhsul_index + 1) + "]")).GetAttribute("innerHTML");

                TestLogaYaz("məhsul_başlığı = " + məhsul_başlığı); 

                if (məhsul_başlığı.ToUpper().Contains(məhsul_adı.ToUpper())){ 
                        TestLogaYaz("TEST KEÇTI. Bu məhsulun adında, axtarılan kəlimə var");

                        MP3_oyna("BU SİSTEMİN-TEST KEÇTI. Bu məhsulun adında, axtarılan kəlimə var");
                }
                else { 
                        TestLogaYaz("XƏTA. Bu məhsulun adında, axtarılan kəlimə YOXDUR");

                        MP3_oyna("BU SİSTEMİN-XƏTA. Bu məhsulun adında, axtarılan kəlimə YOXDUR");
                }
            }            
        }



        readonly int _______SADƏCƏ_TEST_KOD_ÇAĞIRILAN_FONKSIYALAR;

        private bool IsElementVisibleInViewport(IWebElement element) {
            //WebDriver driver = ((RemoteWebElement)element).GetWrappedDriver();

            return
            (bool)((IJavaScriptExecutor) driver).ExecuteScript(
                "var elem = arguments[0], "+
                "box = elem.getBoundingClientRect(), "+
                "cx = box.left + box.width / 2,  "+
                "cy = box.top + box.height / 2, "+
                "e = document.elementFromPoint(cx, cy); "+
                "for (; e; e = e.parentElement) "+
                "     { if (e === elem) return true;}"+ 
                "return false;", 
            element);
        }

        public void Prepend_String_To_File(string value, FileStream file)
        {
            var buffer = new byte[file.Length];

            while (file.Read(buffer, 0, buffer.Length) != 0)
            {
            }
            try {
                if(!file.CanWrite)
                    throw new ArgumentException("The specified file cannot be written.", "file");

                file.Position = 0;
                var data = Encoding.Unicode.GetBytes(value);
                file.SetLength(buffer.Length + data.Length);
                file.Write(data, 0, data.Length);
                file.Write(buffer, 0, buffer.Length);
            }
            catch (Exception e) {
                // ignore it
                TestLogaYaz("XETA: Prepend_String_To_File: " + e.Message);
                Xatayı_Xata_Faylına_Yaz("XƏTA: Prepend_String_To_File=" + e.Message);
            }
        }
        
        private static string SanitizeText( string name )
        {
            string invalidChars = System.Text.RegularExpressions.Regex.Escape( new string( System.IO.Path.GetInvalidFileNameChars() ) );
            string invalidRegStr = string.Format( @"([{0}]*\.+$)|([{0}]+)", invalidChars );

            return System.Text.RegularExpressions.Regex.Replace( name, invalidRegStr, "_" );
        }
        

        public string TruncateString(string value, int maxLength)
        {
            if (string.IsNullOrEmpty(value)) 
                return value;
            
            //return value.Length <= maxLength ? value : value.Substring(0, maxLength); 
            if (value.Length <= maxLength)
                return value;
            else 
                #pragma warning disable IDE0057
                return value.Substring(0, maxLength); 
                #pragma warning restore IDE0057

        } // END func
        

    } // END class

} // END namespace