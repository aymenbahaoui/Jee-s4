
<!DOCTYPE html>
<html>
<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/primeui/4.1.15/primeui.min.css" />
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/primeui/4.1.15/primeui.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/x-tag/1.5.11/x-tag-core.min.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/primeui@4.1.15/primeelements.js"></script>
	<title>preparer questionnaire</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div id = "container">
		<header>
			<div id = "home_link">
				<a href = "index.html"><button is="p-button" icon="fa-home">Home</button></a>
			</div>
			<div id = "add_quest_link">
				<a href ="/psych_evaluation/ajouter"><button id="right" type="button">New Questionnaire</button></a>
			</div>
			<div id = "add_quest_link">
				<a href ="/psych_evaluation/ajouter_csv"><button id="left" type="button">add csv</button><</a>
			</div>
			<h1> Auto-Shrink </h1>
			
		</header>
		
		<main>
			<br><br>
			<c:forEach items="${ questionnaires }" var="questionnaire" varStatus="status">
				<div class = "questionnaire">
					
					<form onclick = "deleteFunction('${questionnaire.title}')" class = "delete" method = "post" action="/psych_evaluation/lister">
						<input type = "text" name = "delete" value ="${questionnaire.title}" style = "display : none;">
						<input type="image"  src="delete.png" alt="delete">
					</form>
					<!--<div class = "delete" onclick = "deleteFunction('${questionnaire.title}')"><img src="delete.png"></div> -->
					<div class = "show"><a href ="/psych_evaluation/show?title=${questionnaire.title}"><img src="show.png"></a></div>
					<p class = "date_creation">${questionnaire.date_creation }</p>
					<p class = "titre_questionnaire">${questionnaire.title }</p>
				</div>
				<br>
			</c:forEach>
		</main>
		
		<footer>
			<p>copyright &copy 2020</p>
		</footer>
	</div>
</body>
<script type="text/javascript">
$('#right').puibutton({
    icon: 'fa-plus-square'
    , iconPos: 'left'
});
$('#left').puibutton({
    icon: 'fa-upload'
    , iconPos: 'left'
});

</script>
<script>
	function deleteFunction(title){
		if (confirm("Are you sure you want to delete "+title)) {
		  } else {
			  location.replace("/psych_evaluation/lister");
		  }
	}

</script>



</html>