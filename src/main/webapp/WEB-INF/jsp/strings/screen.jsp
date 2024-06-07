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
		<input type="checkbox" id="one" name="checkSn" value="1"  />
		<label for="one">one</label>

		<input type="checkbox" id="two" name="checkSn" value="2"  />
		<label for="two">two</label>

		<input type="checkbox" id="three" name="checkSn" value="3"  />
		<label for="three">three</label>

		<button type="button" id="btn">전송</button>
	</div>

<script>
	document.querySelector('#btn').addEventListener('click', function() {
		const reviews = [];
		document.querySelectorAll('input[type="checkbox"][name="checkSn"]:checked').forEach(function(item, idx) {
			reviews.push( item.value );
		});

		const param = {};
		param.reviews = reviews;

		axios.post("${contextPath}/strings/result", param, {
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