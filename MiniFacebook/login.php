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
        $username = $_POST["username"];
        $password = $_POST["password"];

        // Database login check
        $stmt = $db_link->stmt_init();
        $query = "SELECT user_ID, first_name FROM tbl_user WHERE email_address = '" . 
                        $username."' AND " . "password = '" . $password. "'";
                        
        printf("query: %s<br>", $query); 
        $stmt->prepare($query);
        $stmt->execute();
        $stmt->store_result();
        printf("number of rows: %d<br>", $stmt->num_rows);

        // If login is successful, forward user to News Feeds page
        if($stmt->num_rows==1) {
            $stmt->bind_result($userID, $firstName);
            $stmt->fetch();
            //printf("userId: %d<br>", $userId);
            //printf("firstName: %s<br>", $firstName);
            $_SESSION["userID"] = $userID;
            $_SESSION["firstName"] = $firstName;
            
            header("location: newsFeed.php");
        }

        // If login is unsuccessful
        else printf("Invalud username/password, please try again<br>");
    }

    //else echo "First time login page";
?>

<!--Webpage setup-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Login Page" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">
    <!--  <script src="wizard.js"></script>  -->
</head>

<!--Webpage content-->
<body>
    <!--Header-->
    <!--<h1>--php echo $system_name --</h1>-->

    <!--Login box-->
    <form action="login.php" method="POST" autocomplete="off" >
        <div class="input">
            <input type="text"  placeholder="<?php echo $UI_username_text ?>" class="input_text" name="username" autocomplete="off" ></p>
            <input type="password"  placeholder="Enter password" class="input_text" name="password" autocomplete="off" ></p>
            <input type="submit" value="Login" class="submit"></p>
            <a href="forgot_password.php">Forgotten password?</a></p>
            <a href="register.php"><?php echo $UI_signup_button ?></a>
			</p>
        </div>
    </form>
</body>
</html>