<!DOCTYPE html>
<html>
<head>
	<title>preparer questionnaire</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/Questionnaire.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!-- String Functions ->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
 
<!-- Formatting Tags -->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div id = "container">
		<header>
			<div id = "home_link">
			<a href = "index.html"><img src="home.png" alt="home_link"></a>
			</div>
			<h1> Auto-Shrink </h1>
			
		</header>
		<main>
			<br> <br> <br>
			<p style ="text-align:center; font-style: italic;">${title}</p>
				<!--<p class="numquestion">${title}</p>-->
				<form action = "SubmitAnswer" method= "get">
				  <c:forEach items="${questions}" var="item">
				  
				<div class ="question" style="width: 100%;">
					<p class="questioncontent"><c:out value="${item.content}"/></p>					
					<input type="radio" name="${item.id_question}" value="true" checked> True</input>
 			 		<input type="radio" name="${item.id_question}" value="false"> False</input>
 			 	
				</div>
				</c:forEach>
				<button type="submit">submit</button>
				</form>
				
				
			
		</main>
		
		<footer>
			<p>copyright &copy 2020</p>
		</footer>
	</div>
</body>

</html>