<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帖子</title>
</head>
<body>
	<table border="1px">
		<tr>
			<td>帖子ID</td>
			<td>帖子名称</td>
		</tr>
		<c:forEach var="topic" items="${topics}">
			<tr>
				<td>${topic.topicId}</td>
				<td>${topic.topicTittle}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>