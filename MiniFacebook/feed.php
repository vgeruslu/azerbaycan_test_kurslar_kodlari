<!DOCTYPE html>
<html lang="en">
<div class="div_center">
<head>
    <?php

        require_once "headers_all.php";
        require_once "üst_istifadəçi_menyu.php";
    ?>
    <meta charset="UTF-8">
        
</head>

<body>


    <?php
        // Welcome message to identify user
        // Xoş gəldin:
        
        $şəkil_fayl = "istifadəçi_üz_şəkilləri\\" . $_SESSION['epoçt']. ".jpg";
        if (!file_exists($şəkil_fayl )) {
            $şəkil_fayl  = "istifadəçi_üz_şəkilləri\\şəkil_yox_ag.jpg";
        }
        echo "<p><img src='" . $şəkil_fayl . "'><br>".
            $_SESSION['ad']. " " . $_SESSION['soyad'] .
            "</p>";
    ?>

        <!--New post submit-->
        <form action="feed.php" method="POST">
                <p>
                    <input type="text" 
                        placeholder="<?php echo $UI_mətnləri['yeni_paylaşım_mətn_qutusu'][$_COOKIE['system_language_dil']] ?>" class="input_text" name="yeni_paylaşım" size="50">
                    
                    <input type="submit" 
                        value="<?php echo $UI_mətnləri['yeni_paylaşım_düyməsi'][$_COOKIE['system_language_dil']] ?>" 
                        class="submit">
                    
                </p>
        </form>
        <hr> 
        
        

    <?php

        $cari_user_ID_epoçt = $_SESSION["epoçt"];
        $ad = $_SESSION["ad"];
        $soyad = $_SESSION["soyad"];

        // post_id to be deleted
        //$URL = $_SERVER['HTTP_HOST'];
        //$URL .= $_SERVER['REQUEST_URI'];
        $URL = $_SERVER['HTTP_HOST'] . $_SERVER['REQUEST_URI'];

        // Process data when form is submitted
        $url_components = parse_url($URL);
        if(isset($url_components['query'])){
            parse_str($url_components['query'], $params);

            // Deleting user's post
            if(isset($params['silinəcək_post_İD'])){ // post_idToBeDeleted
                //echo 'silinəcək_post_İD: '. $params['silinəcək_post_İD']. '<br>';
                $stmt = $db_link->stmt_init();
                $query = "DELETE FROM tbl_paylaşım 
                            WHERE post_id=". $params['silinəcək_post_İD'];
                $stmt->prepare($query);
                $stmt->execute();
            }

            // Friend/unfriend people
            if(isset($params['silinəcək_dost_İD'])){
                echo 'silinəcək_dost_İD: '. $params['silinəcək_dost_İD']. "<br>";
                $stmt = $db_link->stmt_init();
                
                // If user logged in is in 1st column 'x'
                $query = "DELETE FROM tbl_dostluq_münasibətləri 
                            WHERE istifadəçi2_epoçt='". $params['silinəcək_dost_İD'].        
                            "' AND istifadəçi1_epoçt='". $cari_user_ID_epoçt. "'";
                $stmt->prepare($query);
                $stmt->execute();
                
                // If user logged in is in 2nd column 'y'
                $query = "DELETE FROM tbl_dostluq_münasibətləri
                            WHERE istifadəçi1_epoçt='". $params['silinəcək_dost_İD'].
                            "' AND istifadəçi2_epoçt='". $cari_user_ID_epoçt. "'";
                $stmt->prepare($query);
                $stmt->execute();
            }
        }

        // Submitting new post
        if($_SERVER["REQUEST_METHOD"] == "POST"){
            $new_post = $_POST["yeni_paylaşım"];

            // Ordering new/latest posts
            $post_id=rand(100, 1000000);
            date_default_timezone_set('Europe/London');
            $time_now = date("Y-m-d H:i:s"); 

            // Inserting new post into database
            $stmt = $db_link->stmt_init();
            $query = "INSERT INTO tbl_paylaşım
                (post_id, istifadəçi_epoçt, tarix_saat, paylaşım_mətni) 
                VALUES (". $post_id . ", '" . $cari_user_ID_epoçt . "','" . $time_now . "' , '" . $new_post ."')";
            //echo $query . "<br>";
            $stmt->prepare($query);
            $stmt->execute();
        }

        // Get COUNT of users 
        $stmt = $db_link->stmt_init();
        $query="SELECT count(*) as dostlar_sayi
                FROM tbl_istifadəçi
                WHERE tbl_istifadəçi.epoçt IN(
                        SELECT istifadəçi2_epoçt as friend_ID FROM tbl_dostluq_münasibətləri
                            WHERE istifadəçi1_epoçt = '" . $cari_user_ID_epoçt . 
                "' UNION
                SELECT istifadəçi1_epoçt as dost_ID FROM tbl_dostluq_münasibətləri
                    WHERE istifadəçi2_epoçt = '" . $cari_user_ID_epoçt ."') ";
                " ORDER BY ad";
        //echo 'query: '. $query. "<br>";
        $stmt->prepare($query);
        $stmt->execute();
        $stmt->store_result();

        // Bind variables to prepared statement
        $stmt->bind_result($dostlar_sayi);
 
        $stmt->fetch();
            
            
        // Display all posts who user is friends with ???
        $stmt = $db_link->stmt_init();
        $query = "SELECT tbl_paylaşım.istifadəçi_epoçt, post_id, ad, paylaşım_mətni, tarix_saat
                    FROM tbl_istifadəçi, tbl_paylaşım
                    WHERE tbl_istifadəçi.epoçt = tbl_paylaşım.istifadəçi_epoçt AND
                        (tbl_paylaşım.istifadəçi_epoçt ='" . $cari_user_ID_epoçt . "' OR
                        tbl_paylaşım.istifadəçi_epoçt IN
                            (SELECT istifadəçi2_epoçt as dost_ID FROM tbl_dostluq_münasibətləri
                                WHERE istifadəçi1_epoçt = '". $cari_user_ID_epoçt ."' 
                            UNION
                            SELECT istifadəçi1_epoçt as dost_ID FROM tbl_dostluq_münasibətləri
                                WHERE istifadəçi2_epoçt = '" .$cari_user_ID_epoçt .
                            "')
                        ) ".
                        "ORDER BY tarix_saat DESC";
        //echo 'query: '. $query. "<br>";
        $stmt->prepare($query);
        $stmt->execute();
        $stmt->store_result();

        // Bind variables to prepare statement
        $stmt->bind_result($paylaşımın_user_ID_si, $post_id, $ad, $paylaşım_mətni, $tarix_saat);

        // Inputting data into table format   style= 'width: 100%'
        echo "<table  class='center' >
            <tr>
                <th>".$UI_mətnləri['feed_başlığı'][$_COOKIE['system_language_dil']] .":</th>
                <th>".$UI_mətnləri['dostlar_başlığı'][$_COOKIE['system_language_dil']] ." (". $dostlar_sayi. "):</th>
            </tr>";
        
        echo "
            <tr>
                <td style='vertical-align:top'>";

            // Display news feed column in table
            while($stmt->fetch()){
                printf("<div>%s:<br>", $ad);
                echo "<font style='color:#5C4033' size='-1'>". $paylaşım_mətni. "</font>";
                
                echo "<br><font style='color:#6C757D' size='-1'>". $tarix_saat. "&nbsp&nbsp</font>";
                if($cari_user_ID_epoçt == $paylaşımın_user_ID_si) // user sadece OZ paylaşımlarıni sil biler
                    echo "<font size='-1'><a href='feed.php?silinəcək_post_İD=". $post_id. "'>".
                    $UI_mətnləri['paylaşımı_sil'][$_COOKIE['system_language_dil']] . 
                    "</a>";
                    
                    echo "</font><hr></div>";
            }

        echo "</td>";

        // Display friends column in table
        echo "
                <td style='vertical-align:top'>";

        // Get user's friends list
        $query="SELECT ad, soyad, epoçt
                FROM tbl_istifadəçi
                WHERE tbl_istifadəçi.epoçt IN(
                        SELECT istifadəçi2_epoçt as friend_ID FROM tbl_dostluq_münasibətləri
                            WHERE istifadəçi1_epoçt = '" . $cari_user_ID_epoçt . 
                "' UNION
                SELECT istifadəçi1_epoçt as dost_ID FROM tbl_dostluq_münasibətləri
                    WHERE istifadəçi2_epoçt = '" . $cari_user_ID_epoçt ."') ";
                " ORDER BY ad";
        //echo 'query: '. $query. "<br>";
        $stmt->prepare($query);
        $stmt->execute();
        $stmt->store_result();

        // Bind variables to prepared statement
        $stmt->bind_result($dost_ad, $dost_soyad, $dost_userID);
        
        // Display friends list
        while($stmt->fetch()){
            $şəkil_fayl = "istifadəçi_üz_şəkilləri\\" . $dost_userID. ".jpg";
            if (!file_exists($şəkil_fayl )) {
                $şəkil_fayl  = "istifadəçi_üz_şəkilləri\\şəkil_yox_ag.jpg";
            }
            
            echo "<div name='dost_karti'>
            <input type='hidden' name='dost_epoçt' value='" . $dost_userID."'>
            <a href='istifadəçi_profili.php?istifadəçi_epoçt=". $dost_userID . "'>
                <img src=' " . $şəkil_fayl . "' ><br>";
                
                echo "<div name='dost_ad_soyad'>" . $dost_ad . " "  .$dost_soyad . "</div>"; 
            printf("</a>
                   </div>");
            
            echo " <font size='-1'><div name='dostu_cixar'><a href='feed.php?silinəcək_dost_İD=". $dost_userID. "'>" .
                $UI_mətnləri['dostluqdan_çıxar_düyməsi'][$_COOKIE['system_language_dil']] .
                "</a></div></font>";
            echo "<hr>";//<br>";
        }
        mysqli_close($db_link);

        //Close table column and row for friends list
        echo "</td>
            </tr>";

        echo "</table>";
    ?>

</div>

</html>