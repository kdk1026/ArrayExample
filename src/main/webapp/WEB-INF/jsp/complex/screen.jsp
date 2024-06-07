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
		var temp;

		temp = {};
		temp.seq = 1;
		temp.name = "a";
		arr.push(temp);

		temp = {};
		temp.seq = 2;
		temp.name = "b";
		arr.push(temp);

		var obj;

		obj = {};
		obj.postSn = 1;
		obj.postTitle = 'abc';
		obj.listJson = JSON.stringify(arr);

		const param = obj;

		axios.post("${contextPath}/complex/result", param, {
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