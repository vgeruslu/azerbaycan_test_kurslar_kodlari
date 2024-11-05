<?php
    require_once "headers_all.php";


    // Processing form when submitted
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        $email = $_POST["email"];
        $password = $_POST["password"];
        $motherMaidenName = $_POST["motherMaidenName"];
        
        if ($email == '') {
            echo "<font style='color:red'>Username cannot be empty.</font>";
            exit("");
        }
        if ($password == '') {
            echo "<font style='color:red'>Password cannot be empty.</font>";
            exit("");
        }
        if ($motherMaidenName == '') {
            echo "<font style='color:red'>motherMaidenName cannot be empty.</font>";
            exit("");
        }
        
        // Database login check
        $stmt = $db_link->stmt_init();
        $query = "SELECT userID FROM tbl_user WHERE emailAddress = '" . 
                        $email. "'";
                        
        //printf("query: %s<br>", $query); 
        $stmt->prepare($query);
        $stmt->execute();
        $stmt->store_result();
        //printf("number of rows: %d<br>", $stmt->num_rows);

        // If num_rows==1, it means the email is taken already, exit the script
        if($stmt->num_rows==1) {
            echo "<font style='color:red'>The email is taken already. Enter another email address.</font>";
            exit("");
        }
        
        // we need to get $userID
        $userID=rand(100, 10000000);
        
        $stmt = $db_link->stmt_init();
        $query = "INSERT INTO tbl_user (userID, emailAddress, password, mothersMaidenName)".
                    "VALUES (" . $userID . ", '" . $email . "', '" . $password . "', '" . $motherMaidenName. "')";
                        
        //printf("query: %s<br>", $query); 
        $stmt->prepare($query);
        $stmt->execute();
        // End connection
        mysqli_close($db_link);
        echo "<font style='color:green'>A new account was created. You can <a href='login.php'>login now</a>.</font><br>";
        exit("");
    }
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Register</title>
	    <link rel="stylesheet" href="style.css">
    </head>

    <body>
        <h2>Sign Up</h2>
		<p>Please fill in the information to create an account:</p>
		
		<!--Start form-->   <!--Change username to tbl_user ?!!!-->
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
                <label>Username (email)</label>
                <input type="text" name="email"><br>

                <label>Password</label>
                <input type="password" name="password" value=""><br>

                <label>Mother maiden name</label>
                <input type="text" name="motherMaidenName"><br>

                <input type="submit" class="btn btn-primary" value="Submit">
            </div>
        </form>
    </body>
</html>