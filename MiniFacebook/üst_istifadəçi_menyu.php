<?php
 echo "
  	<table class='center'>
		<tbody>
			<tr class='menu_td_hover'>
				<td><a href='feed.php'>".
					$UI_mətnləri['menyu_əsas_səhifə'][$_COOKIE['system_language_dil']]	
				."</a></td>
				
				<td ><a href='dost_əlavə_et.php'>".
					$UI_mətnləri['menyu_dost_əlavə_et'][$_COOKIE['system_language_dil']		]
				."</a></td>
				
				<td ><a href='profilim.php'>".
					$UI_mətnləri['menyu_profilim'][$_COOKIE['system_language_dil']	]	
				."</a></td>
				
				<td ><a href='çıxış.php'>".
					$UI_mətnləri['menyu_çıxış'][$_COOKIE['system_language_dil']	]	
				."</a></td>
			</tr>
		</tbody>
	</table>";

?>