<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style>
form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
} /* Change styles
for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>

<body>
	<!-- <p>Login</p>
	<form action="HelloForm" method="Get">
		UserId <input type="text" name="first_name"> <br /> Last
		Password <input type="password" name="last_name" /> <input
			type="submit" value="Submit" />
	</form> -->

	<h2>Login Form</h2>

	<form action="login" method="post">
		<div class="imgcontainer">
			<img src="./photo_bg.jgp" alt="Avatar" class="avatar">
		</div>

		<div class="container">
			<label><b>UserID</b></label> <input type="text"
				placeholder="Enter Username" name="uname" required> <label><b>Password</b></label>
			<input type="password" placeholder="Enter Password" name="psw"
				required>

			<button type="submit" onmouseover="red">Login</button>
			<input type="checkbox" checked="checked"> Remember me
		</div>

		<div class="container" style="background-color:#f1f1f1">
			<button type="button" class="cancelbtn">Cancel</button>
			<span class="psw">Forgot <a href="#">password?</a></span>
		</div>
	</form>
	<!-- <p>Post Form</p>
	<form action="HelloForm" method="Post">
		First Name: <input type="text" name="first_name"> <br /> Last
		Name: <input type="text" name="last_name" /> <input type="submit"
			value="Submit" />
	</form>

	<p>Check boxes</p>
	<form action="ReadParams" method="Post" target="_blank">
		<input type="checkbox" name="maths" checked="checked" /> Math <input
			type="checkbox" name="physics" /> Physics <input type="checkbox"
			name="chemistry" checked="checked" /> Chemistry <input type="submit"
			value="Select Subject" />
	</form> -->
</body>
</html>
