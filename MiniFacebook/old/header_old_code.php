    if ($_COOKIE['system_language_dil'] == "AZ") {
        $system_name = "Facebook-Azərbaycan dilində";
        $current_language= "Dil: Azərbaycanca 🇦🇿";
        $change_language_text = "Change to English 🇬🇧...";
        $logo_file = "logo_az.png";
        
        $UI_username_text = "Email adresini daxil edin";
        $UI_signup_button = "Qeydiyyatdan keç";
    }
    else {
        $system_name = "Facebook-English";
        $current_language= "Language: English 🇬🇧";
        $change_language_text = "Azərbaycan dilinə dəyiş 🇦🇿...";
        $logo_file = "logo_en.png";
        $UI_username_text = "Enter email address";
        $UI_signup_button = "Sign up";        
    }