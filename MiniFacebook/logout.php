<?php
    require_once "headers_all.php";
    // Unset all session variables
    $_Session = array();

    // End session
    session_destroy();

    // Redirect to login page
    header("location: login.php");
    exit;
?>