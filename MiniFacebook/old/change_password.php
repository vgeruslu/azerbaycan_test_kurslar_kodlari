<?php
// Register new user/member

// Link to database
require_once "databaseConnection.php";

session_start();

// Processing form when submitted
if($_SERVER["REQUEST_METHOD"] == "POST"){
	$old_password = $_POST["old_password"];
    $new_password = $_POST["new_password"];
	
	$userID = $_SESSION["userID"];


	// check if the old pass is correct
	if ($old_password == '') {
		echo "<font style='color:red'>old_password cannot be empty.</font>";
		exit("");
	}
    if ($new_password == '') {
		echo "<font style='color:red'>new_password cannot be empty.</font>";
		exit("");
	}
	
	// check if the old pass is correct
    $stmt = $db_link->stmt_init();
    $query = "SELECT password FROM tbl_user WHERE userID = '" . 
					$userID. "'";
					
    //printf("query: %s<br>", $query); 
    $stmt->prepare($query);
    $stmt->execute();
    $stmt->store_result();
	$stmt->bind_result($password_from_db);
	$stmt->fetch();
		
	//echo "$password_from_db: " . $password_from_db ."<br>";
	//echo "$old_password: " . $old_password ."<br>";
	
    if($password_from_db != $old_password) {
		echo "<font style='color:red'>You did not enter your old password correctly. Try again.</font>";
		exit("");
	}
	
 
    $stmt = $db_link->stmt_init();
    $query = "UPDATE tbl_user SET password = '".$new_password . "' WHERE userID = '" . 
					$userID. "'";
					
    //printf("query: %s<br>", $query); 
    $stmt->prepare($query);
    $stmt->execute();
    // End connection
    mysqli_close($db_link);
	echo "<font style='color:green'>Your password was updated.</font><br>";
	exit("");
}
?>

<!DOCTYPE html>
<html lang="en">
<style>
table, th, td {
  border:1px solid black;
}
</style>
    <head>
        <title>Change password</title>
	    <link rel="stylesheet" href="style.css">
    </head>

    <body>
	    <!--<h1>--php echo $system_name --</h1>-->
<table style="width:100%">
	<tbody>
		<tr>
			<td><a href='newsFeed.php'>Home</a></td>
			<td><a href='AddFriend.php'>Add Friend</a></td>
			<td><a href='MyProfile.php'>My Profile</a></td>
			<td><a href='ChangePassword.php'>Change Password</a></td>
			<td><a href='Logout.php'>Logout</a></td>
		</tr>
	</tbody>
</table>


        <h2>Change password</h2>
		
		<!--Start form-->   <!--Change username to tbl_user ?!!!-->
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
                <label>Old password</label>
                <input type="password" name="old_password"><br>

                <label>New Password</label>
                <input type="password" name="new_password" value=""><br>

                <input type="submit" class="btn btn-primary" value="Submit">
            </div>
        </form>
    </body>
</html>