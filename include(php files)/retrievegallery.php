<?php
	
		require "Config.php";


	$mysql_qry="SELECT * FROM gallery";

	$result=mysqli_query($conn,$mysql_qry);

	if ($result) 
	{
		# code...
		while ( $row = mysqli_fetch_array($result)) 
		{
			$flag[]=$row;	# code...
		}
	}

	print(json_encode($flag));

	$conn->close();


?>