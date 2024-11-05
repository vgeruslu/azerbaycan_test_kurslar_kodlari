<!--Webpage setup-->
<!DOCTYPE html>
<html lang="en">
<style>
table, th, td {
  border:1px solid black;
}
</style>
<head>
    <meta charset="UTF-8">
    <meta name="Login Page" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--<link rel="stylesheet" href="style.css">-->
    <!--  <script src="wizard.js"></script>  -->
</head>

<!--Webpage content-->
<body>
    <!--Header-->
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

<?php

    require_once "headers_all.php";

    $firstName = $_SESSION["firstName"];

    // Welcome message to identify user
    echo "Welcome: $firstName <br>";

?>

    <!--New post submit-->
    <form action="newsFeed.php" method="POST">
        <div class="input">
            <input type="text" placeholder="Enter new post" class="input_text" name="new_post"></p>
            <input type="submit" value="send" class="submit"></p>
        </div>
    </form>
</body>
</html>


<?php
    require_once "headers_all.php";

    // Identify session user
    $userID = $_SESSION["userID"];
    $firstName = $_SESSION["firstName"];

    // postID to be deleted
    $URL = $_SERVER['HTTP_HOST'];
    $URL .= $_SERVER['REQUEST_URI'];

    // Process data when form is submitted
    $url_components = parse_url($URL);
    if(isset($url_components['query'])){
        parse_str($url_components['query'], $params);

        // Deleting user's own posts
        if(isset($params['postIdToBeDeleted'])){
            $stmt = $db_link->stmt_init();
            $query = "DELETE FROM tbl_post 
                        WHERE postID=". $params['postIdToBeDeleted'];
            $stmt->prepare($query);
            $stmt->execute();
        }

        // Friend/unfriend people
        if(isset($params['friendIdToBeDeleted'])){
            //echo 'friendIdToBeDeleted: '. $params['friendIdToBeDeleted']. "<br>";
            $stmt = $db_link->stmt_init();
            
            // If user logged in is in 1st column 'x'
            $query = "DELETE FROM tbl_friends 
                        WHERE userIDx=". $params['friendIdToBeDeleted'].        
                        " AND userIDy=". $userID;
            $stmt->prepare($query);
            $stmt->execute();
            
            // If user logged in is in 2nd column 'y'
            $query = "DELETE FROM tbl_friends
                        WHERE userIDy=". $params['friendIdToBeDeleted'].
                        " AND userIDx=". $userID;
            $stmt->prepare($query);
            $stmt->execute();
        }
    }

    // Submitting new post
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        $new_post = $_POST["new_post"];

        // Ordering new/latest posts
        $post_id=rand(100, 1000000);
        $time_now = date("Y-m-d H:i:s"); 

        // Inserting new post into database
        $stmt = $db_link->stmt_init();
        $query = "INSERT INTO tbl_post
            (`postID`, `userID`, `dateTime`, `description`) 
            VALUES (". $post_id . ", " . $userID . ",'" . $time_now . "' , '" . $new_post ."')";
        //echo $query . "<br>";
        $stmt->prepare($query);
        $stmt->execute();
    }


    // Display all posts who user is friends with ???
    $stmt = $db_link->stmt_init();
    $query = "SELECT tbl_post.userID, postID, firstName, description, dateTime
                FROM tbl_user, tbl_post
                WHERE tbl_user.userID = tbl_post.UserID AND
                    (tbl_post.userID =" . $userID . " OR
                    tbl_post.userID IN
                        (SELECT userIDy as friend_ID FROM tbl_friends
                            WHERE userIDx = ". $userID ."
                        UNION
                        SELECT userIDx as friend_ID FROM tbl_friends
                            WHERE userIDy = " .$userID .")) ".
                        "ORDER BY dateTime DESC";
    $stmt->prepare($query);
    $stmt->execute();
    $stmt->store_result();

    // Bind variables to prepare statement
    $stmt->bind_result($userIDofPost, $postID, $firstName, $description, $dateTime);

    // Inputting data into table format
    echo "<table style= 'width: 100%'>
        <tr>
            <th>News Feed:</th>
            <th>Friends:</th>
        </tr>";
    echo "
        <tr>
            <td>";

    // Display news feed column in table
    while($stmt->fetch()){
        printf("%s: %s", $firstName, $description);
        echo "<font style='color:#6C757D' size='-1'> ---". $dateTime. "</font>";
        if($userID == $userIDofPost)
            echo "<a href='newsFeed.php?postIdToBeDeleted=". $postID. "'>Delete Post</a>";
            echo "<br>";
    }

    echo "</td>";

    // Display friends column in table
    echo "
            <td>";

    // Get user's friends list
    $query="SELECT firstName, lastName, userID
            FROM tbl_user
            WHERE tbl_user.userID IN(
                    SELECT userIDy as friend_ID FROM tbl_friends
                        WHERE userIDx = " . $userID . "
            UNION
            SELECT userIDx as friend_ID FROM tbl_friends
                WHERE userIDy = " . $userID .") ";
            " ORDER BY firstName";
    $stmt->prepare($query);
    $stmt->execute();
    $stmt->store_result();

    // Bind variables to prepared statement
    $stmt->bind_result($friend_firstName, $friend_lastName, $friend_userID);

    // Display friends list
    while($stmt->fetch()){
        printf("%s %s", $friend_firstName, $friend_lastName);
        echo " <a href='newsFeed.php?friendIdToBeDeleted=". $friend_userID. "'>Unfriend</a>";
        echo"<br>";
    }

    //Close table column and row for friends list
    echo "</td>
        </tr>";

    // Close open ???
    echo "</table";
?>

