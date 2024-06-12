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
		<div>
			<input type="hidden" name="fileSn" value="1" />
			<input type="file" name="imgFile" id="imgFile_1" />
		</div>
		<div>
			<input type="hidden" name="fileSn" value="2" />
			<input type="file" name="imgFile" id="imgFile_2" />
		</div>
		<div>
			<input type="hidden" name="fileSn" value="3" />
			<input type="file" name="imgFile" id="imgFile_3" />
		</div>
		<div>
			<button type="button" id="btn">전송</button>
		</div>
	</div>

<script>
	document.querySelector('#btn').addEventListener('click', function() {
		const formData = setFormData();

		fetch("${contextPath}/files/result", {
			method: "POST",
			headers: {
			},
			body: formData
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

	function setFormData() {
		const formData = new FormData();

		const arrData = [];
		document.querySelectorAll('[id^="imgFile"]').forEach(function(item, idx) {
			const objData = {};

			if ( item.value ) {
				formData.append('imgFile', item.files[0]);

				objData.fileSn = item.closest('div').querySelector('input[name="fileSn').value;
				objData.isExistFile = 'Y';
			} else {
				objData.fileSn = item.closest('div').querySelector('input[name="fileSn').value;
				objData.isExistFile = 'N';
			}

			arrData.push(objData);
		});

		formData.append('jsonData', JSON.stringify(arrData));

		return formData;
	}
</script>

</body>
</html>