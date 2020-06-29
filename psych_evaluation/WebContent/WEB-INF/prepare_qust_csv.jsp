<!DOCTYPE html>
<html>
<head>
	<title>preparer questionnaire</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div id = "container">
		<header>
			<div id = "home_link">
				<a href = "index.html"><img src="home.png" alt="home_link"></a>
			</div>
			<h1> Auto-Shrink </h1>
			
		</header>
		<main>
			<br><br>
			<form class = "form" method ="post" action="ajouter_csv" enctype="multipart/form-data">
				<br> <br> <br>
				<label for="fichier">uploader votre fichier</label>
				<input type="file" name="fichier" id="fichier"/>
				<br> <br>
				<br>
				<input type="submit" value = "valider">
			</form>
			<br><br><br>
			
		</main>
		
		<footer>
			<p>copyright &copy 2020</p>
		</footer>
	</div>
</body>


</html>