<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/taglib.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
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

		const param = {};
		param.jsonData = JSON.stringify(arr);

		axios.post("${contextPath}/objects/result2", param, {
			headers: {
				"Content-Type": "application/x-www-form-urlencoded"
			}
		})
		.then((res) => {
			console.log(res);
		})
		.catch((err) => {
			console.log(err);
		});
	});
</script>

</body>
</html>