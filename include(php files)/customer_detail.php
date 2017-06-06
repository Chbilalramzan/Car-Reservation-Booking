<?php
 
		require "Config.php";

    // receiving the post params
    $title=$_POST["title"];
    $fname = $_POST["fname"];
    $lname = $_POST["lname"];
    $p_no = $_POST["p_no"];
    $cnic=$_POST["cnic"];
    $address=$_POST["address"];
    $city=$_POST["city"];
    $post_code=$_POST["post_code"];
    $country=$_POST["country"];
 
    // check if user is already existed with the same email
    
    $mysql_qry="INSERT INTO customer_details(title,fname,lname,p_no,cnic,address,city,post_code,country) Values('$title','$fname','$lname','$p_no','$cnic','$address','$city','$post_code','$country')";

    if ($conn->query($mysql_qry)==TRUE) 
    {
    	echo "Insert Successful";
    }

    else
    {
    	echo "Erro :".$mysql_qry. "<br>". $conn->error;
    }

    $conn->close();
?>