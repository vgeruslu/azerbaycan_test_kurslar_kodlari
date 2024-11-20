
function change_language() {
    //var phpVariable = "<?php if ($_SESSION['system_language_dil'] == 'AZ') $_SESSION['system_language_dil'] = 'EN' else $_SESSION['system_language_dil'] = 'AZ';  ?>";
    var system_language_dil = readCookie("system_language_dil");
    //document.cookie.split(';').find(row => row.startsWith('system_language_dil=')).split('=')[1];
    console.log(system_language_dil); // JavaScript can use this PHP variable
    
    if (system_language_dil == "AZ")
        system_language_dil = "EN";
    else
        system_language_dil = "AZ";
       
       
    //console.log(listCookies()); 
    console.log(document.cookie);
    
    const expires_date = new Date();
    expires_date.setTime(expires_date.getTime() + (30 *24*60*60*1000));
    
    eraseCookie("system_language_dil");
    createCookie("system_language_dil",system_language_dil,30);
    
    //document.cookie = "system_language_dil=" + system_language_dil+ "; expires=" + expires_date + "; path=/";
    
    console.log(listCookies()); 

    location.reload();
    
}

function createCookie(name,value,days) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 *1000));
        var expires = "; expires=" + date.toGMTString();
    } else {
        var expires = "";
    }
    document.cookie = name + "=" + value + expires + "; path=/";
}

function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') {
            c = c.substring(1,c.length);
        }
        if (c.indexOf(nameEQ) == 0) {
            return c.substring(nameEQ.length,c.length);
        }
    }
    return null;
}

function eraseCookie(name) {
    createCookie(name,"",-1);
}

function listCookies() {
    var theCookies = document.cookie.split(';');
    var aString = '';
    for (var i = 1 ; i <= theCookies.length; i++) {
        aString += i + '-' + theCookies[i-1] + "\n";
    }
    return aString;
}

function doğrulamaq_profil_ad_dəyişmək_form() {
    var system_language_dil = readCookie("system_language_dil");
    
    var yeni_ad_xana = document.forms["ad_soyad_form"]["yeni_ad"];
    document.getElementById("ad_soyad_məlumat_mesajı").innerHTML ="";
        
    var xeta_var = false;
    if (yeni_ad_xana.value == "") {
        yeni_ad_xana.style.border = '1px solid';
        yeni_ad_xana.style.borderColor = 'red';

        if (system_language_dil == "AZ")
            //alert("Ad doldurulmalıdır");
            document.getElementById("xeta_mesaj_ad").innerHTML ="Ad doldurulmalıdır";
        else // EN
            //alert("Name must be filled out");
            document.getElementById("xeta_mesaj_ad").innerHTML ="Name must be filled out";

        //return false;
        xeta_var = true;
    }
    else {
        yeni_ad_xana.style.border = '1px solid';
        yeni_ad_xana.style.borderColor = 'default';
        document.getElementById("xeta_mesaj_ad").innerHTML="";
    }
    
    var yeni_soyad_xana = document.forms["ad_soyad_form"]["yeni_soyad"];
    if (yeni_soyad_xana.value == "") {
        yeni_soyad_xana.style.border = '1px solid';
        yeni_soyad_xana.style.borderColor = 'red';
        
        if (system_language_dil == "AZ") 
            //alert("Soyad doldurulmalıdır");
            document.getElementById("xeta_mesaj_soyad").innerHTML ="Soyad doldurulmalıdır";
        else // EN
            //alert("Last name must be filled out");
            document.getElementById("xeta_mesaj_soyad").innerHTML ="Last name must be filled out";
      
      //
      xeta_var = true;
     
    }
    else {
        yeni_soyad_xana.style.border = '1px solid';
        yeni_soyad_xana.style.borderColor = 'default';    
        document.getElementById("xeta_mesaj_soyad").innerHTML="";
    }        
    
    if (xeta_var)
        return false;
    
} // doğrulamaq_profil_ad_dəyişmək_form

function doğrulamaq_profil_şifrə_dəyişmək_form() {
    var system_language_dil = readCookie("system_language_dil");
    
    var cari_şifrə_xana = document.forms["şifrə_dəyişmək_form"]["cari_şifrə"];
    var yeni_şifrə_xana = document.forms["şifrə_dəyişmək_form"]["yeni_şifrə"];
    var yeni_şifrə_təkrar_xana = document.forms["şifrə_dəyişmək_form"]["yeni_şifrə_təkrar"];
    
    var xeta_var = false;
    
    // cari sifre "" di?
    if (cari_şifrə_xana.value == "") {
        xeta_var = true;
        cari_şifrə_xana.style.border = '1px solid';
        cari_şifrə_xana.style.borderColor = 'red';

        if (system_language_dil == "AZ") 
            document.getElementById("xeta_mesaj_cari_şifrə").innerHTML ="Cari şifrə doldurulmalıdır";
        else // EN
            document.getElementById("xeta_mesaj_cari_şifrə").innerHTML ="Current password must be filled out";
    }
    else {
        cari_şifrə_xana.style.border = '1px solid';
        cari_şifrə_xana.style.borderColor = 'default';    
        document.getElementById("xeta_mesaj_cari_şifrə").innerHTML="";        
    }
    
    // yeni_şifrə_xana
    if (yeni_şifrə_xana.value == ""  ) {
        xeta_var = true;
        
        yeni_şifrə_xana.style.border = '1px solid';
        yeni_şifrə_xana.style.borderColor = 'red';

        if (system_language_dil == "AZ") 
            document.getElementById("xeta_mesaj_yeni_şifrə").innerHTML ="Yeni şifrə doldurulmalıdır";
        else // EN
            document.getElementById("xeta_mesaj_yeni_şifrə").innerHTML ="New password must be filled out";
    }
    else {
        yeni_şifrə_xana.style.border = '1px solid';
        yeni_şifrə_xana.style.borderColor = 'default';    
        document.getElementById("xeta_mesaj_yeni_şifrə").innerHTML="";        
    }
        
    // yeni_şifrə : Password Validation and requirements
    
    // ⚠️Parolun Təsdiqlənməsi və tələbləri
    // ⚠️https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_password_val
    
    // 2 sifre eyni mi?
    if (yeni_şifrə_xana.value != yeni_şifrə_təkrar_xana.value) {
        xeta_var = true;
        
        yeni_şifrə_təkrar_xana.style.border = '1px solid';
        yeni_şifrə_təkrar_xana.style.borderColor = 'red';
        
        if (system_language_dil == "AZ")
            //alert("Yeni şifrə və təkrarı eyni olmalıdırlar");
            document.getElementById("xeta_mesaj_yeni_şifrə_təkrar").innerHTML ="Yeni şifrə və təkrarı eyni olmalıdırlar";            
        else // EN
            //alert("The two passwords must match");
            document.getElementById("xeta_mesaj_yeni_şifrə_təkrar").innerHTML ="The two passwords must match";
    } else {
        yeni_şifrə_təkrar_xana.style.border = '1px solid';
        yeni_şifrə_təkrar_xana.style.borderColor = 'default';
    }
    
    if (xeta_var)
        return false;    
} // doğrulamaq_profil_şifrə_dəyişmək_form

