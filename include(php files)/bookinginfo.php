<?php
	require 'Config.php';

	 // receiving the post params
    $pdate = $_POST["pdate"];
    $ptime = $_POST["ptime"];
    $ddate = $_POST["ddate"];
    $dtime= $_POST["dtime"];
    $acar =$_POST["car"];
    $title=$_POST["title"];
 
    // check if user is already existed with the same email
    
    $mysql_qry="INSERT INTO booking(p_date,p_time,d_date,d_time,car,title) Values('$pdate','$ptime','$ddate','$dtime','$acar','$title')";

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