<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> Sign in </title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/Signin.css" />


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }
      body{
      	text-align : center;
      	background : rgb(102, 204, 255);
      	
      }
      

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
</head>
<body class="text-center">
     <form action="SignIn" method = "get" class="form-signin" >
	<br/>
  <h1 class="h3 mb-3 font-weight-normal">Sign in</h1>
	<br/>
    <label for="uname" class="sr-only" ><b>Username</b></label>
    <input type="text" placeholder="Username" class="form-control" name="login" required>
	<br/>
    <label for="psw" class="sr-only" ><b>Password</b></label>
    <input type="password" placeholder="Password" class="form-control" name="password" required>
  	<br/>
  

  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  <p class="mt-5 mb-3 text-muted">© 2017-2019</p>
</form>
</body>
</html>