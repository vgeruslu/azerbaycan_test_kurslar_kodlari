<!DOCTYPE html>
<html lang="en">
<head>
    <?php

        require_once "headers_all.php";
        require_once "üst_istifadəçi_menyu.php";
    ?>
    <meta charset="UTF-8">
        
</head>

<body>
<div class="div_center">
	<h2>
		<?php echo $UI_mətnləri['profilim_üst_mətn'][$_COOKIE['system_language_dil']] ?>
	</h2>
		
	<?php

		$cari_user_ID_epoçt = $_SESSION["epoçt"];

        if($_SERVER["REQUEST_METHOD"] == "POST") {
			if(isset($_POST['yeni_ad']) && isset($_POST['yeni_soyad'])) {
				//printf("yeni_ad or soy verilmis<br>");
				// car deyerleri oxu, eger 
				$stmt = $db_link->stmt_init();
				$query = "UPDATE tbl_istifadəçi 
							SET    ad = '" . $_POST['yeni_ad'] .
							"' , soyad = '" . $_POST['yeni_soyad'] .
							"' WHERE epoçt = '". $cari_user_ID_epoçt . "';";
				//printf("%s<br>", $query);
				
				$stmt->prepare($query);
				$stmt->execute();
				mysqli_close($db_link);

				$_SESSION["ad"] = $_POST['yeni_ad'];
				$_SESSION["soyad"] = $_POST['yeni_soyad'];
								
				echo "<div id='div_məlumat_mesajı' class='məlumat_mesajı'>" . 
					$UI_mətnləri['ad_soyad_yeniləndi_mesajı'][$_COOKIE['system_language_dil']] 	
					. "</div>";					
			}
							
            /*$new_post = $_POST["yeni_paylaşım"];
			if(isset($url_components['query']));*/


			if(isset($_POST['cari_şifrə'] ) && $_POST['cari_şifrə'] != "")
			{
				// yoxla cari_şifrə
				$stmt = $db_link->stmt_init();
				$query = "SELECT şifrə
							FROM tbl_istifadəçi 
							WHERE epoçt = '". $cari_user_ID_epoçt . "';";

				//printf("%s", $query);
				
				$stmt->prepare($query);
				$stmt->execute();
				
				$stmt->bind_result($sistemde_olan_cari_şifrə);
				$stmt->fetch();	
				mysqli_close($db_link);

				if ($_POST['cari_şifrə'] != $sistemde_olan_cari_şifrə) 
					echo "<div id='div_məlumat_mesajı' class='etibarsız'>" . 
						$UI_mətnləri['cari_şifrə_yalnışdır_mesajı'][$_COOKIE['system_language_dil']] 	
						. "</div>";	
				else {
					$stmt = $db_link->stmt_init();
					$query = "UPDATE tbl_istifadəçi 
								SET    şifrə = '" . $_POST['yeni_şifrə'] .
								"' WHERE epoçt = '". $cari_user_ID_epoçt . "';";
					printf("%s", $query);
					
					$stmt->prepare($query);
					$stmt->execute();
					
					$db_link->commit();
					mysqli_close($db_link);

					echo "<div id='div_məlumat_mesajı' class='məlumat_mesajı'>" . 
						$UI_mətnləri['şifrə_yeniləndi_mesajı'][$_COOKIE['system_language_dil']] 	
						. "</div>";	
				}				
			}
			
		} 

		$ad = $_SESSION["ad"];
		$soyad = $_SESSION["soyad"];


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
				<label class="etibarsız_kiçik" id = "xeta_mesaj_ad"></label>				
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
				<label class="etibarsız_kiçik" id ="xeta_mesaj_soyad"></label>	
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
			<td align="left">
				<input type="password" name="cari_şifrə" value="">
				<label class="etibarsız_kiçik" id ="xeta_mesaj_cari_şifrə"></label>					
			</td>	
		</tr>			


		<tr>
			<td align="right">
				<label>
					<?php echo $UI_mətnləri['yeni_şifrə_label'][$_COOKIE['system_language_dil']] ?>
				</label>
			</td>	
			<td align="left">
				<input type="password" name="yeni_şifrə" value="">
				<label class="etibarsız_kiçik" id ="xeta_mesaj_yeni_şifrə"></label>					
			</td>	
		</tr>			

		<tr>
			<td align="right">
				<label>
					<?php echo $UI_mətnləri['yeni_şifrə_təkrar_label'][$_COOKIE['system_language_dil']] ?>
				</label>
			</td>	
			<td align="left">
				<input type="password" name="yeni_şifrə_təkrar" value="">
				<label class="etibarsız_kiçik" id ="xeta_mesaj_yeni_şifrə_təkrar"></label>			
			</td>
		</tr>			

	</table>	
	
	<input type="submit" class="btn btn-primary" 
		value="<?php echo $UI_mətnləri['redaktə_et_düyməsi'][$_COOKIE['system_language_dil']] ?>"
	>
	</form>
		
    </body>
</html>
