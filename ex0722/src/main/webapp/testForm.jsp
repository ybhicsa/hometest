<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>testForm</title>
		<style type="text/css">
			table,th,td{border: 1px solid black; border-collapse: collapse; }
		</style>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			//alert("test");
			var count=1;
			
			//삭제
			function subInput(){
				//$("input:checkbox[name=filecheck]").length
				//alert("checkbox개수 : "+$("input:checkbox[name=filecheck]").length);
				//$("input:checkbox[name=filecheck]:checked").length
				//alert($("input:checkbox[name=filecheck]:checked").length);
				if($("input:checkbox[name=filecheck]:checked").length<=0){
					alert("체크되어 있어야 합니다");
					return ;
				}
				
				
				$("input:checkbox[name=filecheck]").each(
					function () {
		                 if (this.checked) {
		                  alert("체크되어 있습니다");
		                  $("#"+this.value).remove();
		                 }
	            	}
				);

				
				
			}
			
			//추가
			function addInput(){
				
				alert("파일업로드 행 추가 : "+count);
				var addHtml="";
				
				//addHtml = addHtml + '<tr id="1">';
				//addHtml = addHtml + '<td>'+$("#name").val()+'</td>';
				//addHtml = addHtml + '<td>'+$("#title").val()+'</td>';
				//addHtml = addHtml + '</tr>';
				
				addHtml = addHtml + '<tr id="'+count+'">';
				addHtml = addHtml + '<td><input type="checkbox" name="filecheck" id="ch'+count+'" value="'+count+'"></td>';
				addHtml = addHtml + '<td><input type="file" name="file'+count+'" id="file1"></td>';
				addHtml = addHtml + '</tr>';
				
				$("#tbodyTr").append(addHtml);//추가하면 아래저장
				count++;
				//$("#tbodyTr").prepend(addHtml);	//추가하면 위로저장
				//$("#name").val("");
				//$("#title").val("");
				//$("#name").focus();
			}
			
			function submitForm(){
				$("#fileCount").val($("input:checkbox[name=filecheck]:checked").length);
				$("#testForm").submit();
				
			}
			
			
		</script>
	</head>
	<body>
		<h3>다중파일 업로드</h3>
		<form action="testFormOk.jsp" id="testForm" name="testForm" method="post" enctype="multipart/form-data" >
			<input type="hidden" id="fileCount" name="fileCount" ><br>
			<label>작성자</label>	
			<input type="text" id="name" name="name" ><br>
			<label>제목</label>	
			<input type="text" id="title" name="title" ><br>

			<input type="button" onclick="submitForm()" value="파일전송"><br>
			
			<br><br>
			
			<button type="button" onclick="addInput()">파일 업로드 행추가</button>
			<button type="button" onclick="subInput()">파일 업로드 행삭제</button><br>
			<table>
				<tr>
					<th>체크</th>
					<th>파일첨부</th>
				</tr>
				<tbody id="tbodyTr">
					<!-- Html소스 들어감 -->
				</tbody>
				
			</table>
						
		</form>
	
	</body>
</html>