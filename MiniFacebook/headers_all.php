<?php
    // Initialise session
    session_start();
    
    echo "<script type='text/javascript' src='js_scripts.js'></script>";

    var_dump($_COOKIE);
    
    // Connect to the database
    require_once "database_connection.php";
    
    
         
    if(!isset($_COOKIE['system_language_dil'])) {
        echo "Setting the cookie (system_language_dil)";
        setcookie("system_language_dil", "AZ", time() + (86400 * 30), "/");
    } 
                
    //$_SESSION['system_language_dil'] = "AZ"; 
    //$system_language_dil = "EN";

    if ($_COOKIE['system_language_dil'] == "AZ") {
        $system_name = "Facebook-Azərbaycan dilində";
        $change_language_text = "Dil: 🇦🇿<br>
                                <a href='#' onclick='change_language();'>Change to English 🇬🇧</a>";
        $logo_file = "logo_az2.png";
        
        $UI_username_text = "Email adresini daxil edin";
        $UI_signup_button = "Qeydiyyatdan keç";
    }
    else {
        $system_name = "Facebook-English";
        $change_language_text = "Language: 🇬🇧<br>
                                <a href='#' onclick='change_language();'>Azərbaycan dilinə dəyiş 🇦🇿</a>";
        $logo_file = "logo_en2.png";
        $UI_username_text = "Enter email address";
        $UI_signup_button = "Sign up";        
    }

    echo "<div align='center'>
                <img src='images/" . $logo_file . "'>
          </div>";

    echo "<div align='center'><h1> $system_name </h1></div>";                
    echo "<div align='center'>$change_language_text</div>";                

?>