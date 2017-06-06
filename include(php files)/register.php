<?php
 
		require "Config.php";


 
    // receiving the post params
    $name = $_POST["name"];
    $email = $_POST["email"];
    $password = $_POST["password"];
 
    // check if user is already existed with the same email
    
    $mysql_qry="INSERT INTO register(name,email,password) Values('$name','$email','$password')";

    if ($conn->query($mysql_qry)==TRUE) 
    {
    	echo "Insert Successful";
    }
     else if ($conn->query($mysql_qry)==NULL) 
    {
        echo "Insert Successful";
    }
    else
    {
    	echo "Erro :".$mysql_qry. "<br>". $conn->error;
    }

    $conn->close();
?>