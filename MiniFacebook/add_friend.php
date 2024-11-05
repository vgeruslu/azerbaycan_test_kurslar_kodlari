<!DOCTYPE html>
<html lang="en">
<style>
table, th, td {
  border:1px solid black;
}
</style>
    <head>
        <title>Add Friends</title>
	    <link rel="stylesheet" href="style.css">
    </head>

    <body>
	    <!--<h1>--php echo $system_name --</h1>-->
<table style="width:100%">
	<tbody>
		<tr>
			<td><a href='feed.php'>Home</a></td>
			<td><a href='add_friend.php'>Add Friend</a></td>
			<td><a href='my_profile.php'>My Profile</a></td>
			<td><a href='change_password.php'>Change Password</a></td>
			<td><a href='logout.php'>Logout</a></td>
		</tr>
	</tbody>
</table>


        <h2>Add Friends</h2>
		
<?php
	require_once "headers_all.php";

	$userID = $_SESSION["userID"];

	$URL = $_SERVER['HTTP_HOST']; 
	$URL .= $_SERVER['REQUEST_URI'];

	// Process data when form is submitted
	$url_components = parse_url($URL);
	if(isset($url_components['query'])){
		parse_str($url_components['query'], $params);

		// Deleting user's own posts
		if(isset($params['friendIdToBeAdded'])){
			$friendIdToBeAdded = $params['friendIdToBeAdded'];
			
			$stmt = $db_link->stmt_init();
			$query = "INSERT INTO tbl_friends (userIDx, userIDy) 
						VALUES ($userID, $friendIdToBeAdded)";
			//printf("query: %s<br>", $query);
			
			$stmt->prepare($query);
			$stmt->execute();
		}
	}


	echo "List of all users in the system:<br><br>";

	// Get all 's friends list
	$query="SELECT firstName, lastName, userID
			FROM tbl_user
			WHERE userID != " . $userID . 
			" ORDER BY firstName";

	$stmt = $db_link->stmt_init();
	$stmt->prepare($query);
	$stmt->execute();
	$stmt->store_result();

	// Bind variables to prepared statement
	$stmt->bind_result($third_firstName, $third_lastName, $third_userID);

	// Display friends list
	while($stmt->fetch()){
		printf("%s %s", $third_firstName, $third_lastName);
		
		// check if te user in this loop iteration is already a friend of the logged in user or not
		$query2 = 	"SELECT * FROM tbl_friends
							WHERE userIDx =  $userID AND
							userIDy = $third_userID
						UNION
						SELECT *  FROM tbl_friends
							WHERE userIDy = $userID AND
							userIDx = $third_userID";
							
		$stmt2 = $db_link->stmt_init();
		$stmt2->prepare($query2);
		$stmt2->execute();
		$stmt2->store_result();
		
		if($stmt2->num_rows==1)  // meaning that at least a friend relationship
							// so do NOT show the "Add Friend"
			echo "<font style='color:#6C757D' size='-1'>Already your friend</font>";			
		else
			echo " <a href='AddFriend.php?friendIdToBeAdded=$third_userID'>Add Friend</a>";
		echo"<br>";
	}
?>

    </body>
</html>
