# Tətbiq URL-si
tətbiq_url = "https://mobil-bank-tətbiqi.com"

# İstifadəçi məlumatları
istifadəçi_adı = "etibarlıİstifadəçi"
şifrə = "etibarlıŞifrə"

# WebDriver-ın başlatılması
sürücü = webdriver.Chrome()

try:
    # Tətbiqi açın
    sürücü.get(tətbiq_url)

    # Daxil olma sahələrini tapın
    istifadəçi_adı_sahəsi = sürücü.find_element(By.NAME, "istifadəçi_adı")
    şifrə_sahəsi = sürücü.find_element(By.NAME, "şifrə")
    daxil_ol_düyməsi = sürücü.find_element(By.NAME, "daxil_ol")

    # Etibarlı məlumatları daxil edin
    istifadəçi_adı_sahəsi.send_keys(istifadəçi_adı)
    şifrə_sahəsi.send_keys(şifrə)

    # Daxil ol düyməsinə klikləyin
    daxil_ol_düyməsi.click()

    # Yüklənməni gözləyin
    time.sleep(5)  # Gözləmə müddətini dəyişə bilərsiniz

    # Baş panelin açıldığını yoxlayın
    if "Baş panel" in sürücü.title:
        print("Test Uğurlu: İstifadəçi uğurla daxil olub.")
    else:
        print("Test Uğursuz: İstifadəçi daxil ola bilmir.")

finally:
    # Sürücünü bağlayın
    sürücü.quit()