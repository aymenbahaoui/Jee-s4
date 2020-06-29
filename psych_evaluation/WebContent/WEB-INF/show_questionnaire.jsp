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
				<a href ="/psych_evaluation/lister"><img src="retour.png" alt="retour_link"></a>
			</div>
			<h1> Auto-Shrink </h1>
			
		</header>
		<main>
			<br><br>
			<br> <br> <br>
			<p style ="text-align:center; font-style: italic;">${questionnaire.title}</p>
				<c:forEach var="i" begin="0" end="${questionnaire.length-1}" step="1">
					<div class ="question" style="width: 100%; margin-left : 15%;">
						<p class="numquestion">Q${i+1}</p>
						<p class="questioncontent">${questionnaire.questions.get(i).getContent()}</p>
					</div>
				</c:forEach>
		</main>
		
		<footer>
			<p>copyright &copy 2020</p>
		</footer>
	</div>
</body>
</html>