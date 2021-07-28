<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>삭제부분</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			
			if(${result}==1){
				alert("게시물이 삭제 되었습니다.");
				location.href="bList.do";
			} else {
				alert("게시물이 삭제 되지 않았습니다.");
				location.href="bviwe.do?bid="${bVo.bid };
			}
			
		
		</script>
	</head>
	<body>
	
	</body>
</html>