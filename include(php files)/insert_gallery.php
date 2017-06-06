<?php
		
		require "Config.php";
		$msg=" ";
		

		if(isset($_POST['upload']))
		{
			$target="iamges/";
			$target=$target.basename($_FILES['image']['name']);

			$image=$_FILES['image']['name']; 

			$sql="INSERT INTO gallery(image) VALUES('$image')";

			mysqli_query($conn,$sql);

		if (move_uploaded_file($_FILES['image']['tmp_name'], $target))
		{
				$msg="image upload Successfully";
		}
		else
		{

			$msg="problem";
		}

		}
		
  $conn->close();

 ?>

<!DOCTYPE html>
<html>
<head>
	<title>image upload</title>
</head>
<body>
	<div	id="connect">
	<form method="POST" action="gallery.php" enctype="multipart/form-data">
		<input type="hidden" name="size" value="1000000">
			<input type="file" name="image">

		<div>
			<input type="submit" name="upload" value="upload">
		</div>
	</form>
	</div>
</body>
</html>