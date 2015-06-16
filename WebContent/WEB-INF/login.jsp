<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="j_spring_security_check">
		<div id="conteneur"
			style="height: 200px; position: relative; left: 400px; top: 200px; width: 600px; box-shadow: 2px 2px 2px 2px; border: 1px solid">
			<div id="image"
				style="height: 200px; width: 140px; float: left; position: relative;">
				<img src="resources/images/lock.jpg"
					style="width: 100px; height: 160px; margin-top: 20px; margin-left: 20px;" />
			</div>
			<div id="form">
				<fieldset
					style="background-color: #F0FFF0; width: 375px; border-radius: 10px 10px 10px 10px; left: 25px; top: 20px; position: relative; font-family: candara;">
					<legend>
						<strong>CONNEXION UTILISATEUR</strong>
					</legend>
					<table>
						<tr>
							<td><strong>Identifiant :</strong></td>
							<td><input name="j_username" value="" type="text"
								style="height: 30px; font-size: 20px; font-weight: lighter;" /></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td><strong>Mot de passes :</strong></td>
							<td><input name="j_password" type="password"
								style="height: 30px; font-size: 20px; font-weight: lighter;" /></td>
						</tr>
					</table>
					<input value="Valider" type="submit"
						style="width: 100px; height: 30px; font-size: 15px; font-weight: lighter; font-family: candara;" />
				</fieldset>
			</div>
		</div>
	</form>
</body>
</html>