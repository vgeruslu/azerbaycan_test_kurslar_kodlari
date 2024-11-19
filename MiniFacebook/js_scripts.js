
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
    if (yeni_ad_xana.value == "") {
        yeni_ad_xana.style.border = '1px solid';
        yeni_ad_xana.style.borderColor = 'red';
        
        if (system_language_dil == "AZ")
            alert("Ad doldurulmalıdır");
        else // EN
            alert("Name must be filled out");

        return false;
    }
    yeni_ad_xana.style.border = '1px solid';
    yeni_ad_xana.style.borderColor = 'default';
    
    var yeni_soyad_xana = document.forms["ad_soyad_form"]["yeni_soyad"];
    if (yeni_soyad_xana.value == "") {
        yeni_soyad_xana.style.border = '1px solid';
        yeni_soyad_xana.style.borderColor = 'red';
        
        if (system_language_dil == "AZ") 
            alert("Soyad doldurulmalıdır");
        else // EN
            alert("Last name must be filled out");
      
      return false;
    }
    yeni_soyad_xana.style.border = '1px solid';
    yeni_soyad_xana.style.borderColor = 'default';    
    
} // doğrulamaq_profil_ad_dəyişmək_form

function doğrulamaq_profil_şifrə_dəyişmək_form() {
    var system_language_dil = readCookie("system_language_dil");
    
    var yeni_şifrə_xana = document.forms["şifrə_dəyişmək_form"]["yeni_şifrə"];
    var yeni_şifrə_təkrar_xana = document.forms["şifrə_dəyişmək_form"]["yeni_şifrə_təkrar"];
    
    if (yeni_şifrə_xana.value != yeni_şifrə_təkrar_xana.value) {
        yeni_şifrə_təkrar_xana.style.border = '1px solid';
        yeni_şifrə_təkrar_xana.style.borderColor = 'red';
        
        if (system_language_dil == "AZ")
            alert("Yeni şifrə və təkrarı eyni olmalıdırlar");
        else // EN
            alert("The two passwords must match");

        return false;
    }
    yeni_şifrə_təkrar_xana.style.border = '1px solid';
    yeni_şifrə_təkrar_xana.style.borderColor = 'default';
    
} // doğrulamaq_profil_şifrə_dəyişmək_form

