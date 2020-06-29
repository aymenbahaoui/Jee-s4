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
		<main >
			<br><br>
			<br> <br> <br>
			<p style ="text-align:center; font-style: italic;">${answers.title_questionnaire}</p>
			
				<c:forEach items="${answers.list_answers}" var="answer" varStatus="status">
					<div class ="question" style="width: 100%; margin-left : 15%;">
						<p class="numquestion">Q${status.count}</p>
						<p class="questioncontent">${answer.question_content}</p>
						<p class="val">${answer.value}</p>
					</div>
					<br>
				</c:forEach>
				<p style ="text-align:center; font-style: italic;">Recommendation</p>
					<form method="post" action="/psych_evaluation/view_recommendation" style="width: 100%; text-align:center; ">
					<input type = "text" name = "id_answers" value ="${answers.id_answers}" style = "display : none;">
					<textarea name="content" rows="10" cols="70"></textarea>
					  <br>
					  <input type="submit">
					</form>
		</main>
		
		<footer>
			<p>copyright &copy 2020</p>
		</footer>
	</div>
</body>

</html>