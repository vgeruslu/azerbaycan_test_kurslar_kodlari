<?php
    require_once "headers_all.php";

	// Processing form when submitted
	if($_SERVER["REQUEST_METHOD"] == "POST"){
		$email = $_POST["email"];
		$motherMaidenName = $_POST["motherMaidenName"];
		
		if ($email == '') {
			echo "<font style='color:red'>Email cannot be empty.</font>";
			exit("");
		}
		if ($motherMaidenName == '') {
			echo "<font style='color:red'>motherMaidenName cannot be empty.</font>";
			exit("");
		}
		

		
		// check if email and motherMaidenName match to account
		$stmt = $db_link->stmt_init();
		$query = "SELECT password 
						FROM tbl_user 
						WHERE emailAddress = '". $email . "'
							AND mothersMaidenName = '". $motherMaidenName . "'";
		
		//printf("query: %s<br>", $query); 
		$stmt->prepare($query);
		$stmt->execute();
		$stmt->store_result();
		
			
		if($stmt->num_rows==0) { // not matched
			echo "<font style='color:red'>Either the email or the mother maiden name was incorrect.</font>";
			exit("");
		}
		// if we are here, we can proceed
		$stmt->bind_result($password_from_db);
		$stmt->fetch();
		
		echo "Your password is: " . $password_from_db . "<br>";
		echo "You can <a href='login.php'>login now</a>.<br>";
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
        <title>Forgot password</title>
	    <link rel="stylesheet" href="style.css">
    </head>

    <body>
	    <!--<h1>--php echo $system_name --</h1>-->



        <h2>Forgot password</h2>
		
		<!--Start form-->   <!--Change username to tbl_user ?!!!-->
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
                <label>Email</label>
                <input type="text" name="email"><br>

                <label>Mother maiden name</label>
                <input type="text" name="motherMaidenName"><br>

                <input type="submit" class="btn btn-primary" value="Reset my password">
            </div>
        </form>
    </body>
</html>