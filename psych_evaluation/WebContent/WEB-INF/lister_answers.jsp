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
			<c:forEach items="${list_answers}" var="answers" varStatus="status">
				<div class = "questionnaire"> 
					<p class = "titre_questionnaire">${answers.title_questionnaire}</p>
					<form   class = "diagnostiquer" method = "post" action="/psych_evaluation/donner_recommendation">
						<input type = "text" name = "id_answers" value ="${answers.id_answers}" style = "display : none;">
						<input type="image"  src="diagnostiquer.png" alt="diagnostiquer">
					</form>
					<p class = "date_creation">${answers.date}</p>
					<p class = "passe_par">passé par : ${answers.id_employe} </p>
				</div>
				<br>
			</c:forEach>
		</main>
		
		<footer>
			<p>copyright &copy 2020</p>
		</footer>
	</div>
</body>
</html>