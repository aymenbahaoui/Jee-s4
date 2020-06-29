
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/User.css" />

<title>Shrink</title>
</head>
<body >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!-- String Functions ->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
 
<!-- Formatting Tags -->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
<h1 class="Header__name"> Auto-Shrink </h1>
<a href="/">
         <img alt="Home" src="${pageContext.request.contextPath}/images/home_icon.jpg"
         width="80" height="80">
      </a>
</div>
<br/>
<br/>

<div class= "body">
  <c:forEach items="${Answers}" var="item">
<div class="Questionnaire"> 
<h2 class="Questionnaire-elements-number"> <c:out value="${item.title_questionnaire}" /></h2>
<h2 class="Questionnaire-elements-date"> <c:out value="${item.id_employe}" /> </h2>
<h2 class="Questionnaire-elements-date"> Passé le: <c:out value="${item.date}" /> </h2>

<a class="Questionnaire-elements-redo" href ="/"></a>
</div>
 </c:forEach>
</div>
<div class= "footer"> <h1> copyright</h1></div>
</body>
</html>