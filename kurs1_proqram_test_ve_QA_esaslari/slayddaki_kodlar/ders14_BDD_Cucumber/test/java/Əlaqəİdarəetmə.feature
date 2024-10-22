# language: az
Özəllik: Əlaqə İdarəetmə
"""
given	=  Tutaq ki , Verilir
when	= Əgər , Nə vaxt ki
then	= O halda
and	    = Və , Həm
but	    = Amma , Ancaq
"""
  Ssenari: Yeni əlaqə əlavə etmək
    Tutaq ki İstifadəçinin indiyə qədər 2 qeydiyyatdan keçmiş kontaktı var
    Əgər İstifadəçi "Sadiq" adlı yeni kontakt əlavə etsə
    O halda Əlaqə siyahısında "Sadiq" adlı kontakt var
    Və Əlaqə siyahısında 3 dənə qeyd var


  Ssenari: Əlaqə silmək
    Tutaq ki İstifadəçinin indiyə qədər 5 qeydiyyatdan keçmiş kontaktı var
    Əgər İstifadəçi "Sadiq" adlı yeni kontakt əlavə etsə
    O halda Əlaqə siyahısında "Sadiq" adlı kontakt var
      Və Əlaqə siyahısında 6 dənə qeyd var
    Əgər İstifadəçi "Sadiq" adlı kontakti silir
    O halda Əlaqə siyahısında "Sadiq" adlı kontakt yox
      Və Əlaqə siyahısında 5 dənə qeyd var


