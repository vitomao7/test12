<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	//掉service实现层List<User> users = new UserServiceImpl().queryAllUsers();

%>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>用户信息</title>
    <link rel="stylesheet" href="css/bootstrap.css" />
    <script src="js/jquery-1.11.1.min.js"> </script>
    <script src="js/bootstrap.js"> </script>
</head>
<body>
    <div class="container-fluid">

        <div class="btn-group" style="margin-top: 30px">
            <button type="button" class="btn btn-default"  data-toggle="modal" data-target="#userdiv"><span class="glyphicon glyphicon-plus"></span>添加</button>
            <button id="update" type="button" class="btn btn-default" data-toggle="modal" data-target="#updateuser"><span class="glyphicon glyphicon-pencil"></span>修改</button>
            <button type="button" id="remove" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span>删除</button>
            <button type="button" class="btn btn-default" onclick="location.href='UserInfoServlet.do?nowPage=1&pageCount=10'"><span class="glyphicon glyphicon-refresh"></span>刷新</button>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th >全选  <input id="all" type="checkbox" name="users"/></th>
                <th>序号</th>
                <th>电影名</th>
                <th>评分</th>
                <th>国家</th>
                <th>票房</th>
                <th>上映时间</th>
                <th>时长</th>
                <th>主演</th>
                <th>想看数</th>
                <th>图片路径</th>
            </tr>
            </thead>
            
            <tbody>
            
            
           
            <c:forEach varStatus="i" var="mov" items="${requestScope.model.models }">
           
            <tr>
                <td><input type="checkbox" name="userItem"/><input type="hidden" value="${mov.MOVIE_ID  }"/></td>
                <td>${i.count }</td>
                <td>${mov.MOVIE_NAME }</td>
                <td>${mov.MOVIE_SCORE }</td>
                <td>${mov.MOVIE_LCOU }</td>
                <td>${mov.MOVIE_BOX }</td>
                <td>${mov.MOVIE_SHOW }</td>
                <td>${mov.MOVIE_DUR }</td>
                <td>${mov.MOVIE_ACTOR }</td>
                <td>${mov.MOVIE_LOOK }</td>
                <td>${mov.MOVIE_PIC }</td>
            </tr>
            </c:forEach>		    	
         

            
            
            
            </tbody>
        </table>
        <ul class="pagination">

            <li><a href="javaScript:void(0)">共${requestScope.model.totalPages }页</a></li>
            <li><a href="MovieInfoServlet.do?nowPage=1&pageCount=10">首页</a></li>
            
            
            <c:choose>
            	<c:when test="${requestScope.model.nowPage==1 }">
            	<li><a href="javaScript:void(0)">&laquo;</a></li>
            	</c:when>
            	<c:otherwise>
            	<li><a href="MovieInfoServlet.do?nowPage=${requestScope.model.nowPage-1 }&pageCount=10">&laquo;</a></li>
            	</c:otherwise>
            </c:choose>
            
            
            <c:forEach var="x" begin="1" end="${requestScope.model.totalPages }">
            	<c:choose>
            		<c:when test="${requestScope.model.nowPage == x }">
            		 <li class="active"><a  href="MovieInfoServlet.do?nowPage=${x }&pageCount=10">${x }</a></li>
            		</c:when>
            		<c:otherwise>
            		<li><a href="MovieInfoServlet.do?nowPage=${x }&pageCount=10">${x }</a></li>
            		</c:otherwise>
            	</c:choose>

            </c:forEach>
 
 			<c:choose>
 				<c:when test="${requestScope.model.nowPage==requestScope.model.totalPages}">
 					<li><a href="javaScript:void(0)">&raquo;</a></li>
 				</c:when>
 				<c:otherwise>
 					<li><a href="MovieInfoServlet.do?nowPage=${requestScope.model.nowPage+1 }&pageCount=10">&raquo;</a></li>
 				</c:otherwise>
 			</c:choose>
            
            
            
            
            <li><a href="MovieInfoServlet.do?nowPage=${requestScope.model.totalPages }&pageCount=10">尾页</a></li>
        </ul>

        <!-- 模态框（Modal） -->
        <div class="modal fade" id="userdiv" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                                aria-hidden="true">×
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            用户信息
                        </h4>
                    </div>
                    <div class="modal-body">
                        <!--输入用户信息-->
                        <div >
                            <form  class="bs-example bs-example-form" role="form">
                                <div class="input-group col-md-6 col-md-offset-3">
                                    <span class="input-group-addon">用户名</span>
                                    <input type="text" class="form-control" placeholder="请输入用户名">
                                </div>
                                
                                <br>
                                <div class="input-group col-md-6 col-md-offset-3">
                                    <span class="input-group-addon">密码</span>
                                    <input type="text" class="form-control" placeholder="请输入用户密码">
                                </div>
                          
                                <br>
                                <div class="input-group col-md-6 col-md-offset-3">
                                    <span class="input-group-addon">类型</span>
                                    <select name="sex" id="sex" class="form-control">
                                        <option value="0">管理员</option>
                                        <option value="1">普通会员</option>
                                    </select>
                                </div>
                                <br>
                                <div class="input-group col-md-6 col-md-offset-3">
                                    <span class="input-group-addon">余额</span>
                                    <input type="text" class="form-control" placeholder="请输入用户充值余额">
                                </div>
                          
                                <br>
                                
                                
                                
                            </form>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">关闭
                        </button>
                        <button data-dismiss="modal" id="subBtn" type="button" class="btn btn-primary">
                            			确认
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        
        
              <!-- 模态框（Modal） -->
        <div class="modal fade" id="updateuser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                                aria-hidden="true">×
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            用户信息
                        </h4>
                    </div>
                    <div class="modal-body">
                        <!--输入用户信息-->
                        <div >
                            <form  class="bs-example bs-example-form" role="form">
                                <div class="input-group col-md-6 col-md-offset-3">
                                    <span class="input-group-addon">用户名</span>
                                    <input type="text" class="form-control" placeholder="请输入用户名">
                                </div>
                                
                                <br>
                                <div class="input-group col-md-6 col-md-offset-3">
                                    <span class="input-group-addon">类型</span>
                                    <select name="sex" id="sex" class="form-control">
                                        <option value="0">管理员</option>
                                        <option value="1">普通会员</option>
                                    </select>
                                </div>
                                <br>
                                <div class="input-group col-md-6 col-md-offset-3">
                                    <span class="input-group-addon">余额</span>
                                    <input type="text" class="form-control" placeholder="请输入用户充值余额">
                                </div>
                          
                                <br>
                       
                            </form>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">关闭
                        </button>
                        <button data-dismiss="modal" id="updateBtn" type="button" class="btn btn-primary">
                            			确认
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        
        
        
    </div>
	<script type="text/javascript">
		$("#all").click(function() {
			if($("#all").prop("checked")){
				$("input[type=checkbox]").prop("checked",true);
			}else{
				$("input[type=checkbox]").prop("checked",false);
			}	
		});
		
		$("input[type=checkbox]:gt(0)").click(function() {
			var b = false;
			$.each($("input[type=checkbox]:gt(0)"),function(i){
				if(!$("input[type=checkbox]:gt(0)").eq(i).prop("checked")){
					b = true;
				}
			});
			if(b){
				$("#all").prop("checked",false);
			}else{
				$("#all").prop("checked",true);
			}
			
		});
	
	
	
		$("#subBtn").click(function() {
			//提交数据的获得
			var name = $("#userdiv form input:eq(0)").val();
			var pwd = $("#userdiv form input:eq(1)").val();
			var extra = $("#userdiv form input:eq(2)").val();
			var type = $("#userdiv form select").val();
			
			//alert(name+","+pwd+","+extra+","+type);
			var data = {'name':name,'pwd':pwd,'extra':extra,'type':type};
			$.get('InsertUserServlet.do',data,function(mess){
				alert(mess);
			},'html');
		});
		
		//删除数据
		$("#remove").click(function(){
			//获得被选中这一行中的id
			//$("input[type=checkbox]").filter(":checked").parent().next().text();
			var ids = "";
			$.each($("input[type=checkbox]").filter(":checked").parent().next(),function(i){
				ids = ids +$("input[type=checkbox]").filter(":checked").parent().next().eq(i).text()+",";
				
			});
			$.get("DeleteUserServlet.do",{'ids':ids},function(mess){
				alert(mess);
				
			},'html')
		});
		//修改数据
		$("#update").click(function() {
			//
			var name = $("input[type=checkbox]").filter(":checked").parent().next().next().eq(0).text();
			var type = $("input[type=checkbox]").filter(":checked").parent().next().next().next().eq(0).text();
			type = type.trim();
			var extra = $("input[type=checkbox]").filter(":checked").parent().next().next().next().next().eq(0).text()
			$("#updateuser input:eq(0)").val(name);
			$("#updateuser input:eq(1)").val(extra);
			
			if("管理员"==type){
				$("#updateuser select option:eq(0)").prop("selected",true);
			}else{
				$("#updateuser select option:eq(1)").prop("selected",true);
			}


		});
	
		$("#updateBtn").click(function() {
			var id = $("input[type=checkbox]").filter(":checked").parent().next().eq(0).text();
			var name = $("#updateuser input:eq(0)").val();
			var extra = $("#updateuser input:eq(1)").val();
			var type = $("#updateuser select").val();
			var data = {'id':id,'name':name,'extra':extra,'type':type};
			alert(type);
/* 			$.get("UpdateUserServlet.do",data,function(mess){
				alert(mess);
			},'html');	 */
		});
	</script>
</body>
</html>