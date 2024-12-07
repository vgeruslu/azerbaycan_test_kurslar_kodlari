<!DOCTYPE html>
<html lang="en">
<head>

<div class="div_center">

<?php
    require_once "headers_all.php";

    // Processing form when submitted
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        $epoçt = $_POST["epoçt"];
        $şifrə = $_POST["şifrə"];
        $ad = $_POST["ad"];
        $soyad = $_POST["soyad"];
       
        $giriş_dəyərlərdə_etibarlıdır = true;
        
        if ($epoçt == '') {
            echo "<font style='color:red'>". 
                $UI_mətnləri['epoçt_boş_xəta_mesajı'][$_COOKIE['system_language_dil']] . 
                "</font><br>";
            $giriş_dəyərlərdə_etibarlıdır = false;
        }
        if ($şifrə == '') {
            echo "<font style='color:red'>". 
                $UI_mətnləri['şifrə_boş_xəta_mesajı'][$_COOKIE['system_language_dil']] . 
                "</font><br>";            
            $giriş_dəyərlərdə_etibarlıdır = false;
            }
        if ($ad == '') {
            echo "<font style='color:red'>". 
                $UI_mətnləri['ad_boş_xəta_mesajı'][$_COOKIE['system_language_dil']] . 
                "</font><br>";
            //exit("");
            $giriş_dəyərlərdə_etibarlıdır = false;

        }        
        if ($soyad == '') {
            echo "<font style='color:red'>". 
                $UI_mətnləri['soyad_boş_xəta_mesajı'][$_COOKIE['system_language_dil']] . 
                "</font><br>";
            //exit("");
            $giriş_dəyərlərdə_etibarlıdır = false;
        }
        
        if ( $giriş_dəyərlərdə_etibarlıdır ) {

            // yoxla gor eyni email istifade olunub?
            $stmt = $db_link->stmt_init();
            $query = "SELECT epoçt 
                        FROM tbl_istifadəçi 
                        WHERE epoçt = '" . 
                           $epoçt. "'";
                            
            //printf("query: %s<br>", $query); 
            $stmt->prepare($query);
            $stmt->execute();
            $stmt->store_result();

            // If num_rows==1, it means the email is taken already, exit the script
            if($stmt->num_rows==1) {
                echo "<font style='color:red'>" .
                    $UI_mətnləri['xəta_mesajı_epoçt_artıq_götürülüb'][$_COOKIE['system_language_dil']] . 
                    "</font>";
            }
            else {
                
                $query = "INSERT INTO tbl_istifadəçi 
                            (epoçt, şifrə, ad, soyad)".
                            "VALUES ('" . $epoçt . "', '" . $şifrə . "', '" . $ad . "', '" . $soyad. "')";
                                
                //printf("query: %s<br>", $query); 
                $stmt = $db_link->stmt_init();
                $stmt->prepare($query);
                $stmt->execute();
                mysqli_close($db_link);
                echo "<font style='color:green'>"  .
                        $UI_mətnləri['yeni_hesab_yaradıldı_mesaj'][$_COOKIE['system_language_dil']] . 
                        "</font><br>";
            }
        }
    }
?>
</div>

<meta charset="UTF-8">
</head>

<body>
    <div class="div_center">

        <h2>
            <div><?php echo $UI_mətnləri['qeydiyyat_keçin_səhifə_başlığı'][$_COOKIE['system_language_dil']] ?></div>
        </h2>
        
		<!--Start form-->   <!--Change username to tbl_user ?!!!-->
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
                
                <p>
                <label>
                <?php echo $UI_mətnləri['epoçt'][$_COOKIE['system_language_dil']] ?>
                </label>
                <input type="text"  
                    placeholder="<?php echo $UI_mətnləri['epoçt_qutu_işarəsi'][$_COOKIE['system_language_dil']] ?>"  
                    class="input_text" name="epoçt" autocomplete="off" >
                </p>                
                
                <p>
                <label>
                <?php echo $UI_mətnləri['şifrə'][$_COOKIE['system_language_dil']] ?>
                </label>
                <input type="password" 
                        placeholder="<?php echo $UI_mətnləri['şifrə_qutu_işarəsi'][$_COOKIE['system_language_dil']] ?>"  
                        class="input_text" name="şifrə" autocomplete="off" >
                </p> 

                <p>
                <label>
                <?php echo $UI_mətnləri['ad_label'][$_COOKIE['system_language_dil']] ?>
                </label>
                <input type="text"  
                        placeholder="<?php echo $UI_mətnləri['ad_label'][$_COOKIE['system_language_dil']] ?>"  
                        class="input_text" name="ad" autocomplete="off" >
                </p> 

                <p>
                <label>
                <?php echo $UI_mətnləri['soyad_label'][$_COOKIE['system_language_dil']] ?>
                </label>
                <input type="text"  
                        placeholder="<?php echo $UI_mətnləri['soyad_label'][$_COOKIE['system_language_dil']] ?>"  
                        class="input_text" name="soyad" autocomplete="off" >
                </p> 
                                                
                <p>
                    <input type="submit" value="<?php echo $UI_mətnləri['qeydiyyat_keç_düyməsi'][$_COOKIE['system_language_dil']] ?>" class="submit">                
                </p> 
                
                <p><a href="daxil_ol.php">
                    <?php echo $UI_mətnləri['daxil_ol_link_adı'][$_COOKIE['system_language_dil']] ?>
                    </a>
                </p>
                                
        </form>
    </div>
        
</body>
</html>