<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>用户管理</title>

</head>
<body>
	<table border="1px" width="100%">
		<tr>
			<td><input type="checkbox" onclick="switchSelectBox()" /></td>
			<td>用户ID</td>
			<td>用户名</td>
			<td>用户类型</td>
			<td>积分</td>
			<td>锁定状态</td>
			<td>更改</td>
		</tr>

		<!--输出用户列表-->
		<c:forEach var="user" items="${users}">
			<tr>
				<td><input type="checkbox" name="userIds"
					value="${user.userId}"></td>
				<td>${user.userId}</td>
				<td>${user.userName}</td>
				<td>${user.userType}</td>
				<td>${user.credit}</td>
				<td>${user.locked}</td>
				<td><input type="button" id="${user.userId}" value="更改"
					onclick="updateUser(this.id)" /></td>
			</tr>
		</c:forEach>

	</table>
	<br/>
	<input type="button" value="删除用户" onclick="deleteUsers()" />
	<input type="button" value="新建用户" onclick="addUser()" />
</body>

<!-- Script函数 -->
<script>
<!--全选函数-->
	function switchSelectBox() {
		var selectBoxs = document.all("userIds");
		if (!selectBoxs)
			return;
		//only one checkbox
		if (typeof (selectBoxs.length) == "undefined") {
			selectBoxs.checked = event.srcElement.checked;
		}
		//many checkbox ,so is a array 
		else {
			for (var i = 0; i < selectBoxs.length; i++) {
				selectBoxs[i].checked = event.srcElement.checked;
			}
		}
	}
	<!--获取选择的用户对象集-->
	function getSelectedUserIds() {
		var selectBoxs = document.all("userIds");
		if (!selectBoxs)
			return null;
		if (typeof (selectBoxs.length) == "undefined" && selectBoxs.checked) {
			return selectBoxs.value;
		} else {//many checkbox ,so is a array 
			var ids = "";
			var split = ""
			for (var i = 0; i < selectBoxs.length; i++) {
				if (selectBoxs[i].checked) {
					ids += split + selectBoxs[i].value;
					split = ",";
				}
			}
			return ids;
		}
	}
	<!--跳转到用户删除页面-->
	function deleteUsers() {
		var ids = getSelectedUserIds();
		if (ids) {
			var url = "<c:url value="/usersmanager/deleteusers"/>?userIds="
					+ ids + "";
			//alert(url);
			location.href = url;
		}
	}
	<!--跳转到用户更新页面-->
	function updateUser(id) {
		var nId = id;
		var url = "<c:url value="/usersmanager/updateform"/>?userId=" + id + "";
		location.href = url;
	}
	<!--跳转到用户更新页面-->
	function addUser() {
		var url = "<c:url value="/usersmanager/addform"/>" ;
		location.href = url;
	}
</script>
</html>
