<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<!--${pageContext.request.contextPath} el表达式获得项目根目录  -->
	<form action="${pageContext.request.contextPath}/LoginServlet.do" method="post">
		用户名： <input type="text"  name="userName"/> <br />
		密码： <input type="password" name="userPwd" /> <br />
		
		<input type="submit" value="提交"/>
	</form>
</body>
</html>