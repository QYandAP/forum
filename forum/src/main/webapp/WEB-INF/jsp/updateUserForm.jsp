<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.userName}信息更新</title>
</head>
<body>
	<form action="/forum/usersmanager/updateuser" method="post">
		<table>
			<tr>
				<td>用户ID：</td>
				<td><input type="text" name="userId" default
					value="${user.userId}" /></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="userName" default
					value="${user.userName}" /></td>
			</tr>
			<tr>
				<td>用户类型：</td>
				<td><input type="text" name="userType" default
					value="${user.userType}" /></td>
			</tr>

			<tr>
				<td>用户密码：</td>
				<td><input type="text" name="password" default
					value="${user.password}" /></td>
			</tr>
			<tr>
				<td>积分：</td>
				<td><input type="text" name="credit" default
					value="${user.credit}" /></td>
			</tr>
			<tr>
				<td>用户状态：</td>
				<td><input type="text" name="locked" default
					value="${user.locked}" /></td>
			</tr>
		</table>
		<input type="submit" value="更新"/>
	</form>
</body>
</html>