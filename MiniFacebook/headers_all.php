<?php
    // Initialise session
    //session_start();
    if(session_id() == '' || !isset($_SESSION) || session_status() === PHP_SESSION_NONE) {
        // session isn't started
        session_start();
    }
    
    if(!isset($_COOKIE['system_language_dil'])) {
        echo "Setting the cookie (system_language_dil)";
        setcookie("system_language_dil", "AZ", time() + (86400 * 30), "/");
    } 
    
    require_once "verilənlər_bazası_bağlantısı.php";
    
    require_once "ui_mətnləri.php";

    echo "  <title>".$UI_mətnləri['sistem_ismi'][$_COOKIE['system_language_dil']]."</title>".
         "  <link rel='stylesheet' href='style.css'>".
         "  <script type='text/javascript' src='js_scripts.js'></script>";

    //var_dump($_COOKIE);
    
         

    echo "<div align='center'>
                <img src='images/" 
                .$UI_mətnləri['sistem_loqo_faylı'][$_COOKIE['system_language_dil']].
             "'></div>";
          
    echo "<div align='center'><h2>"
            .$UI_mətnləri['sistem_ismi'][$_COOKIE['system_language_dil']].
        "</h2></div>";  
                  
    echo "<div align='center'>"
            .$UI_mətnləri['cari_dil'][$_COOKIE['system_language_dil']].
        "</div>";                

    echo "<div align='center'><a href='#' onclick='change_language();'>"
            .$UI_mətnləri['dil_dəyişmə'][$_COOKIE['system_language_dil']].
        "</a></div>";                
    
    echo "<hr> ";   
?>