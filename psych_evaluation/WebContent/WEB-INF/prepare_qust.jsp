<!DOCTYPE html>
<html>
<head>
	<title>preparer questionnaire</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/primeui/4.1.15/primeui.min.css" />
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/primeui/4.1.15/primeui.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/x-tag/1.5.11/x-tag-core.min.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/primeui@4.1.15/primeelements.js"></script>
</head>
<body>
	<div id = "container">
		<header>
			<div id = "home_link">
				<a href = "index.html"><button is="p-button" icon="fa-home">Home</button></a>
			</div>
			<h1> Auto-Shrink </h1>
			
		</header>
		<main>
			<br><br>
			<form class = "form" method ="post" action="show">
				<label for="title">title</label>
				<input type="text" name="title" id="title"/>
				<br> <br> <br>
				<div id ="question1">
					<label for="q1">Q1</label>
					<input type="text" name="q1"/>
				</div>
				<br>
				<input type="submit" value = "valider">
			</form>
			<br><br><br>
			<div id="add_remove_quest">
				<button id = "add"><img src="add.png"/></button>
				<button id = "remove"><img src="remove.png"/></button>
				<br><br>
			</div>
		</main>
		
		<footer>
			<p>copyright &copy 2020</p>
		</footer>
	</div>
</body>
<script type="text/javascript">
$('#title').puiinputtext(); 
</script>
<script src = "ajouter.js">

</script>

</html>