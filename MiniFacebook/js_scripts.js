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