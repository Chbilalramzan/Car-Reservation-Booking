<?php

require 'Config.php';

    $email = $_POST['email'];
    $password = $_POST['password'];

    $mysql_qry="SELECT * FROM register WHERE email like '$email' and password like '$password'";

    $result=mysqli_query($conn,$mysql_qry);
    if(mysqli_num_rows($result)>0)
    {
        echo "Login Successful";
    }
    else
    {
        echo "Error :".$mysql_qry. "<br>". $conn->error;
    }

/*if(null!==$_POST['email'] && null!==$_POST['password'])
{
    echo "Enter emial and password ";
}

if(null!==$_POST['email'])
{
    echo "Enter Email Address";
}
if(null!==$_POST['password'])
{
    echo "Enter password";
}*/

    $conn->close();
 
?>