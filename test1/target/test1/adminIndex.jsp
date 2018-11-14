<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/bootstrap.css" />
    <script src="js/jquery-1.11.1.min.js"> </script>
    <script src="js/bootstrap.js"> </script>
    <style>
        .divborder{
            border: 1px solid #0f0f0f;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <div class="row" >
            <div class="col-md-12 " style="height: 200px;background-image: url('img/bg.jpg');">
                <h1 class="h1" style="color: white;font-size: 60px;margin-top: 70px">影片订购系统</h1>
                <span style="color: whitesmoke;float: right">欢迎：${sessionScope.users.get(0).USER_NAME }登录</span>
                <a href="ExitServlet.do">退出登录</a> <a href="<%=response.encodeURL("new.jsp")%>">newJsp</a>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2 bg-info" style="height: 700px;padding: 0">
               <!--设置折叠菜单-->
                <div class="panel-group" id="accordion" >
					<c:forEach var="right" varStatus="index" items="${requestScope.rights }">
                    <div class="panel panel-default" style="margin: 0px">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion"
                                   href="#collapseOne${index.count }">
                                 	${right.right_name }
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne${index.count }" class="panel-collapse collapse in">
                                <ul class="list-group">
                                	<c:forEach var="secRight" items="${right.secRights }">
                         
                                	 	<li class="list-group-item"><a href="${secRight.right_url }" target="main">${secRight.right_name }</a></li>
                                	</c:forEach>
                                </ul>
                        </div>
                    </div>
					</c:forEach>
                </div>





            </div>
            <div class="col-md-10" style="height: 100%" style="height: 700px">
                <iframe name="main" src="UserInfoServlet.do" frameborder="0" marginheight="0" marginwidth="0" style="width: 100%;height: 700px">

                </iframe>
            </div>
        </div>

    </div>

</body>
</html>