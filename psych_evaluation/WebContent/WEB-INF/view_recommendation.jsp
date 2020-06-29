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
			<div id = "retour_link">
				<a href ="/psych_evaluation/lister_answers"><img src="retour.png" alt="retour_link"></a>
			</div>
			<h1> Auto-Shrink </h1>
			
		</header>
		<main>
			<br><br>
			<br> <br> <br>
			<p style ="text-align:center; font-style: italic;">recommendation numero : ${recommendation.id_recommendation}</p>
			<p style ="font-style: bold; border : solid 1px ; max-width : 80% ;margin-left : 10%; min-height : 200px; padding-left:2%;"> ${recommendation.content}</p>
				
				
		</main>
		
		<footer>
			<p>copyright &copy 2020</p>
		</footer>
	</div>
</body>
</html>