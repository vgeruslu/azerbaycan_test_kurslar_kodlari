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

        <h2><?php echo $UI_mətnləri['dost_əlavə_et_üst_mətn'][$_COOKIE['system_language_dil']] ?></h2>
		
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

		// Deleting user's own posts
		if(isset($params['əlavə_olunacaq_dost_İD'])){
			$əlavə_olunacaq_dost_İD = $params['əlavə_olunacaq_dost_İD'];
			
			$stmt = $db_link->stmt_init();
			$query = "INSERT INTO tbl_dostluq_münasibətləri (istifadəçi1_epoçt, istifadəçi2_epoçt) 
						VALUES ('$cari_user_ID_epoçt', '$əlavə_olunacaq_dost_İD')";
			//printf("query: %s<br>", $query);
			
			$stmt->prepare($query);
			$stmt->execute();
		}
	}

	// butov istifadecileri, istisna olmaqla cari user, listele
	$query="SELECT count(*) AS istifadeciler_sayi_bu_user_yox
			FROM tbl_istifadəçi
			WHERE epoçt != '" . $cari_user_ID_epoçt . "'";

	$stmt = $db_link->stmt_init();
	$stmt->prepare($query);
	$stmt->execute();
	$stmt->store_result();

	$stmt->bind_result($istifadeciler_sayi_bu_user_yox);
	$stmt->fetch();
	
	echo "<div>". $UI_mətnləri['bütün_istifadəçilərin_siyahısı_mətn'][$_COOKIE['system_language_dil']] ." (" . $istifadeciler_sayi_bu_user_yox . "):</div><br>";

	// butov istifadecileri, istisna olmaqla cari user, listele
	$query="SELECT ad, soyad, epoçt
			FROM tbl_istifadəçi
			WHERE epoçt != '" . $cari_user_ID_epoçt . 
			"' ORDER BY ad";

	$stmt = $db_link->stmt_init();
	$stmt->prepare($query);
	$stmt->execute();
	$stmt->store_result();

	// Bind variables to prepared statement
	$stmt->bind_result($digər_istifadəçi_ad, $digər_istifadəçi_soyad, $digər_istifadəçi_epoçt);

	// Display friends list
	while($stmt->fetch()){
		$şəkil_fayl = "istifadəçi_üz_şəkilləri\\" . $digər_istifadəçi_epoçt. ".jpg";
		if (!file_exists($şəkil_fayl )) {
			$şəkil_fayl  = "istifadəçi_üz_şəkilləri\\şəkil_yox_ag.jpg";
		}

		  
		echo "<div name='istifadəçi'><a href='istifadəçi_profili.php?istifadəçi_epoçt=". $digər_istifadəçi_epoçt . "'>
			<img src=' " . $şəkil_fayl . "'><br>
				<div name='istifadəçi_tam_adi'>".  
				$digər_istifadəçi_ad . " " . $digər_istifadəçi_soyad. 
				"</div>
			</a>";
		
		// check if te user in this loop iteration is already a friend of the logged in user or not
		$query2 = 	"SELECT * FROM tbl_dostluq_münasibətləri
							WHERE istifadəçi1_epoçt = '$cari_user_ID_epoçt' AND
							istifadəçi2_epoçt = '$digər_istifadəçi_epoçt'
						UNION
						SELECT *  FROM tbl_dostluq_münasibətləri
							WHERE istifadəçi2_epoçt = '$cari_user_ID_epoçt' AND
							istifadəçi1_epoçt = '$digər_istifadəçi_epoçt'";
							
		$stmt2 = $db_link->stmt_init();
		$stmt2->prepare($query2);
		$stmt2->execute();
		$stmt2->store_result();
		
		echo "<input type='hidden' name='dost_epoçt' value='" . $digər_istifadəçi_epoçt."'>";

		if($stmt2->num_rows==1)  // yeni iki nefer dostdurlar
			echo "<font style='color:#6C757D' size='-1'><div name='dostdurlar_ya_yox'>".
				$UI_mətnləri['artıq_dostunuz'][$_COOKIE['system_language_dil']].
				"</div></font>";			
		else // dost deyiller
			echo "<font size='-1'> <a href='dost_əlavə_et.php?əlavə_olunacaq_dost_İD=$digər_istifadəçi_epoçt'>
				<div name='dostdurlar_ya_yox'>".
				$UI_mətnləri['dostluq_sorğusu_düyməsi'][$_COOKIE['system_language_dil']].
				"</div></a></font>";
			
		echo"</div><hr>";
	}
?>

    </body>
</html>
