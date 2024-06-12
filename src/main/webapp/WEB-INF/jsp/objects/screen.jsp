<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/taglib.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<button type="button" id="btn">전송</button>
	</div>

<script>
	document.querySelector('#btn').addEventListener('click', function() {
		const arr = [];
		var obj;

		obj = {};
		obj.postSn = 1;
		obj.postTitle = 'abc';
		arr.push(obj);

		obj = {};
		obj.postSn = 2;
		obj.postTitle = 'def';
		arr.push(obj);

		const param = JSON.stringify(arr);

		fetch("${contextPath}/objects/result", {
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: param
		})
		.then((res) => {
			return res.json();
		})
		.then((data) => {
			console.log(data);
		})
		.catch((err) => {
			console.log(err);
		});
	});
</script>

</body>
</html>