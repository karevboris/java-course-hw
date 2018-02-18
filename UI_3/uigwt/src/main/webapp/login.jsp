<html>
<head>
	<title>
		Login Page
	</title>
</head>
<body onload="document.f.username.focus();">
<h1><i>Welcome</i></h1>
<i>Welcome to the educational portal designed for passing tests. This system allows you to create tests on various topics.</i>
<h3>Login with Username and Password</h3>
<form name="f" action="/uigwt-1.0-SNAPSHOT/login" method="POST">
	<table>
		<tbody>
		<tr>
			<td>User:</td>
			<td><input type="text" name="username" value=""></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan="2"><input name="submit" type="submit" value="Login"></td>
		</tr>
		</tbody>
	</table>
</form>
</body>
</html>