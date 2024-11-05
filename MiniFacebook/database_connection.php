<?php
// Connecting MySQL database created in myPHPadmin to local host server using XAMPP > Apache 

// Database login details in process order
define('DB_Server', 'localhost');
define('DB_Username', 'root');
define('DB_Password', '');
define('DB_Name', 'facebook_EN');
// For the purposes of this assignmnet, the default username and password were not changed for ease of access/use

// Connect to database & check conneciton
$db_link = mysqli_connect(DB_Server, DB_Username, DB_Password, DB_Name);
if($db_link === false){
    die("ERROR: Could not connect to the database". mysqli_connect_err());
    }
?>