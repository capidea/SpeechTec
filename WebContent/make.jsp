<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sound Maker</title>
</head>
<body>
	<form action="make" method="post"  name="usrform">
		输入一行文字：<input type="text" name="text">
		<br>
		<input type="submit" value="提交">
	</form>
	<form action="synth" method="post">
   		输入一段文字：<textarea rows="4" cols="50"  name="comment" >请在这里输入文本...</textarea>
   		<input type="submit" value="提交">
	</form> 
</body>
</html>