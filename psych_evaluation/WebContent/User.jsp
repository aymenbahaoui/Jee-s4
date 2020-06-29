
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/User.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/primeui/4.1.15/primeui.min.css" />
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/primeui/4.1.15/primeui.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/x-tag/1.5.11/x-tag-core.min.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/primeui@4.1.15/primeelements.js"></script>
<title>User</title>
</head>
<body >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!-- String Functions ->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
 
<!-- Formatting Tags -->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div id = "container">
		<header>
			<div id = "home_link">
				<a href = "index.html"><button is="p-button" icon="fa-home">Home</button></a>
			</div>
			<h1> Auto-Shrink </h1>
			
		</header>
		
		<main>
			<br><br>
			<h1 class = "hello" style="text-align:center">hello  ${user} </h1>
			<c:forEach items="${answers}" var="item">
				<div class="Answers"> 
				<h2 class="Questionnaire-elements-number"> <c:out value="${item.title_questionnaire}" /></h2>
				<h2 class="Questionnaire-elements-date">  <c:out value="${item.date}" /> </h2>
				<a class="Questionnaire-elements-redo" href ="${pageContext.request.contextPath}/TakeQuestionnaire?title=${item.title_questionnaire}"><button  type="button">Retake</button></a>
				<a class="Questionnaire-elements-recommendation" href ="${pageContext.request.contextPath}/Consulter_recommendation?id_answers=${item.id_answers}"> <button  type="button">View recommendation</button></a>
				</div>
				<br><br>
			</c:forEach>
					<br><br>
					<c:forEach items="${questionnaires}" var="item">
						<div class="Questionnaire"> 
						<h2 class="Questionnaire-elements-number"> <c:out value="${item.title}" /></h2>
						<a class="Questionnaire-elements-redo" href ="${pageContext.request.contextPath}/TakeQuestionnaire?title=${item.title}"><button  type="button">Take</button></a>
						</div>
						<br><br>
					</c:forEach>
					
		</main>
		
		<footer>
			<p>copyright &copy 2020</p>
		</footer>
	</div>		
	<script type="text/javascript">
	
	$('.Questionnaire-elements-redo button').puibutton();
	$('.Questionnaire-elements-recommendation button').puibutton();
	</script>
</body>
</html>
