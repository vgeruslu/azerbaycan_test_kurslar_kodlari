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

        <h2>
			<?php echo $UI_mətnləri['profilim_üst_mətn'][$_COOKIE['system_language_dil']] ?>
		</h2>
		
	<?php

		$cari_user_ID_epoçt = $_SESSION["epoçt"];
		$ad = $_SESSION["ad"];
		$soyad = $_SESSION["soyad"];

        if($_SERVER["REQUEST_METHOD"] == "POST") {
			if(isset($_POST['yeni_ad']) || isset($_POST['yeni_soyad']))
				printf("yeni_ad or soy verilmis<br>");
            /*$new_post = $_POST["yeni_paylaşım"];

			if(isset($url_components['query']));

			$stmt = $db_link->stmt_init();
			$query = "INSERT INTO tbl_dostluq_münasibətləri (istifadəçi1_epoçt, istifadəçi2_epoçt) 
						VALUES ('$cari_user_ID_epoçt', '$əlavə_olunacaq_dost_İD')";
			//printf("query: %s<br>", $query);
			
			$stmt->prepare($query);
			$stmt->execute();*/
			if(isset($_POST['cari_şifrə'] ) && $_POST['cari_şifrə'] != "")
				printf("şifrə verilmis<br>");
			
		}



	?>

	<!--datalar dəyişmək-->
	
	<form name="ad_soyad_form"  action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" 
		onsubmit="return doğrulamaq_profil_ad_dəyişmək_form()" 
		method="post">
	<table  class='center' >
		<tr>
			<td align="right">
				<label>	
					<?php echo $UI_mətnləri['epoçt_label'][$_COOKIE['system_language_dil']] ?> 
				</label>
			</td>	
			<td align="left">
				<?php echo $cari_user_ID_epoçt ?> 
			</td>
		</tr>

		<tr>
			<td align="right">
				<label>
					<?php echo $UI_mətnləri['ad_label'][$_COOKIE['system_language_dil']] ?>
				</label>
			</td>	
			<td align="left">
				<input name="yeni_ad" 
					value="<?php echo $ad ?>"
				>
			</td>	
		</tr>	

		<tr>
			<td align="right">
				<label>
					<?php echo $UI_mətnləri['soyad_label'][$_COOKIE['system_language_dil']] ?>
				</label>
			</td>	
			<td align="left">
				<input name="yeni_soyad" 
					value="<?php echo $soyad ?>"
				>
			</td>	
		</tr>
	</table>	
	
	<input type="submit" class="btn btn-primary" 
		value="<?php echo $UI_mətnləri['redaktə_et_düyməsi'][$_COOKIE['system_language_dil']] ?>"
	>
	</form>
	
	<!--Şifrə dəyişmək-->
	<h3>
		<?php echo $UI_mətnləri['şifrə_redaktə_label'][$_COOKIE['system_language_dil']] ?>
	</h3>
		
	<form name="şifrə_dəyişmək_form"  
		action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" 
		onsubmit="return doğrulamaq_profil_şifrə_dəyişmək_form()" 
		method="post">
	<table  class='center' >
		
		<tr>
			<td align="right">
				<label>
				<?php echo $UI_mətnləri['cari_şifrə_label'][$_COOKIE['system_language_dil']] ?>
				</label>
			</td>	
			<td align="left"><input type="password" name="cari_şifrə" value=""></td>	
		</tr>			


		<tr>
			<td align="right">
				<label>
					<?php echo $UI_mətnləri['yeni_şifrə_label'][$_COOKIE['system_language_dil']] ?>
				</label>
			</td>	
			<td align="left"><input type="password" name="yeni_şifrə" value=""></td>	
		</tr>			

		<tr>
			<td align="right">
				<label>
					<?php echo $UI_mətnləri['yeni_şifrə_təkrar_label'][$_COOKIE['system_language_dil']] ?>
				</label>
			</td>	
			<td align="left"><input type="password" name="yeni_şifrə_təkrar" value=""></td>
		</tr>			

	</table>	
	
	<input type="submit" class="btn btn-primary" 
		value="<?php echo $UI_mətnləri['redaktə_et_düyməsi'][$_COOKIE['system_language_dil']] ?>"
	>
	</form>
		
    </body>
</html>
