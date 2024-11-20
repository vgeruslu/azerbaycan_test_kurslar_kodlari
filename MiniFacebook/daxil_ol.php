<!DOCTYPE html>
<html lang="en">
<head>

<div class="div_center">

<?php
    require_once "headers_all.php";

    // Check user is already logged in. If so, forward to News Feeds page
    if(isset($_SESSION["loggedin"]) && $_SESSION["loggedin"] == TRUE){
        header("location: newsFeed.php");
    }

    // Define variables & initialise with empty values
    $username = $password = "";
    $username_err = $password_err = $login_err = "";

    // Process data when form is submitted
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        $epoçt = $_POST["epoçt"];
        $şifrə = $_POST["şifrə"];

        // Database login check
        $stmt = $db_link->stmt_init();
        $query = "SELECT ad, soyad
                        FROM tbl_istifadəçi 
                        WHERE epoçt = '" . 
                        $epoçt."' AND " . "şifrə = '" . $şifrə. "'";
                        
        //printf("Query: %s<br>", $query); 
        $stmt->prepare($query);
        $stmt->execute();
        $stmt->store_result();
        //printf("DB-den gelen setir sayi = %d<br>", $stmt->num_rows);

        if($stmt->num_rows==1) {
            $stmt->bind_result($ad, $soyad);
            $stmt->fetch();
            //printf("userId: %d<br>", $userId);
            //printf("firstName: %s<br>", $firstName);
            session_start();
            mysqli_close($db_link);

            $_SESSION["epoçt"] = $epoçt;
            $_SESSION["ad"] = $ad;
            $_SESSION["soyad"] = $soyad;
            
            header("location: feed.php");
        }
        else 
            printf("<p style='color:red'>" .$UI_mətnləri['yanlış_istifadəçi_adı_parol'][$_COOKIE['system_language_dil']]."</p>");
    }

    //else echo "First time login page";
?>
</div>

    <meta charset="UTF-8">
</head>

    <body>
        <form action="daxil_ol.php" method="POST" autocomplete="off" >
            <div class="div_center">
                
                <p><input type="text"  placeholder="<?php echo $UI_mətnləri['epoçt_qutu_işarəsi'][$_COOKIE['system_language_dil']] ?>"  
                    class="input_text" name="epoçt" autocomplete="off" >
                </p>                
                
                <p><input type="password" placeholder="<?php echo $UI_mətnləri['şifrə_qutu_işarəsi'][$_COOKIE['system_language_dil']] ?>"  
                    class="input_text" name="şifrə" autocomplete="off" >
                </p> 
                
                <p>
                    <input type="submit" value="<?php echo $UI_mətnləri['daxil_ol_düyməsi'][$_COOKIE['system_language_dil']] ?>" class="submit">                
                </p> 
                
                <!-- 
                <p><a href="şifrəmi_unutdum.php">
                    echo $UI_mətnləri['şifrəmi_unutdum'][$_COOKIE['system_language_dil']] 
                    </a>
                </p>-->
                
                <p><a href="qeydiyyat.php">
                    <?php echo $UI_mətnləri['qeydiyyat_düyməsi'][$_COOKIE['system_language_dil']] ?>
                    </a>
                </p>
                
            </div>
        </form>
    </body>
    
</html>