<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论坛主页</title>
</head>
<body>
	<table border="1px" width="100%">
		<tr>
			<td>版块ID</td>
			<td>版块名称</td>
			<td>版块介绍</td>
			<td>版块管理员</td>
		</tr>
		<!--输出用户列表-->
		<c:forEach var="board" items="${boards}">
			<tr>
				<td><a
					href="<c:url value="/boards/boardtopics?boardId=${board.boardId}"/>">${board.boardId}</a></td>
				<td><a
					href="<c:url value="/boards/boardtopics?boardId=${board.boardId}"/>">${board.boardName}</a></td>
				<td><a
					href="<c:url value="/boards/boardtopics?boardId=${board.boardId}"/>">${board.boardDesc}</a></td>
				<td><a
					href="<c:url value="/boards/boardtopics?boardId=${board.boardId}"/>">${board.userId}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>