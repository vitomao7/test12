<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加场次</title>
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css"/>
    <script src="js/jquery-1.11.1.min.js"> </script>
    <script src="js/bootstrap.js"> </script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div style="margin-top:50px">
               <form action="AddSessionServlet.do"  class="bs-example bs-example-form" role="form">
                    <div class="input-group col-md-4 col-md-offset-4">
                         <span class="input-group-addon">电影</span>
                         <select class="form-control" name="movieId" id="">
	                        <c:forEach var="mov" items="${requestScope.movies }">
	                        <option value="${mov.MOVIE_ID }">${mov.MOVIE_NAME }</option>
	                        </c:forEach>
                         </select>
                    </div>                 
               		<br />
                    <div class="input-group col-md-4 col-md-offset-4">
                         <span class="input-group-addon">影院</span>
                         <select class="form-control" name="cinemaId" id="cinemaId">
                         		
							<c:forEach var="ci" items="${requestScope.cinemas }">
								<option value="${ci.CINEMA_ID }">${ci.CINEMA_NAME }</option>
							</c:forEach>
                         </select>
                    </div>                 
               		<br />
                    <div class="input-group col-md-4 col-md-offset-4">
                         <span class="input-group-addon">影厅</span>
                         <select class="form-control" name="hallId" id="hallId">

                         </select>
                    </div>      
               		<br />      
                    <div class="input-group col-md-4 col-md-offset-4">
                         <span class="input-group-addon">语言</span>
                         <select class="form-control" name="lan" id="">
                         	<option value="国语">国语</option>
                         	<option value="英语">英语</option>
                         </select>
                    </div>                
               		<br />               		         		               
                    <div class="input-group col-md-4 col-md-offset-4">
                         <span class="input-group-addon">票价</span>
                         <input type="text" name="price" class="form-control" placeholder="请输入用户名">
                    </div>          
                    <br>
                    <div class="input-group col-md-4 col-md-offset-4 date form_date"
                    data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                         <span class="input-group-addon">播放日期</span>
                         <input name="date"  type="text" readonly value=""  class="form-control" placeholder="请选择日期">
                         <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    	 <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                         
                    </div>          
                    <br>
                    <div class="input-group col-md-4 col-md-offset-4 date form_time"
                    data-date="" data-date-format="hh:ii" data-link-field="dtp_input3" data-link-format="hh:ii">
                         <span class="input-group-addon">开始时间</span>
                         <input name="start"  type="text"  readonly class="form-control" placeholder="选择开始时间">
                         <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    	 <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                    </div>          
                    <br>       
                    
                    <div class="input-group col-md-4 col-md-offset-4">
                         <input type="submit" class="form-control" value="提交">
                    </div> 
               </form>			
			
			</div>
		</div>
	</div>    
<script src="bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
<script src="bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
    $('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
    //级联效果，选择影院后，自动出现该影院的影厅
    $(function(){
    	var cid = $("#cinemaId").val();
    	$.get("QueryHallsServlet.do",{"cid":cid},function(data){
    		//先把之前显示的所有option删除
    		$("#hallId").html("");
    		
    		
    		for(index in data){
    			$("#hallId")[0].options[index] = new Option(data[index].HALL_NAME,data[index].HALL_ID);
    		}
    		
    	},'json');
    	
    });
    
    
    $("#cinemaId").change(function(){
    	//获得被选中的影院id
    	var cid = $(this).val();
    	$.get("QueryHallsServlet.do",{"cid":cid},function(data){
    		//先把之前显示的所有option删除
    		$("#hallId").html("");
    		
    		
    		for(index in data){
    			$("#hallId")[0].options[index] = new Option(data[index].HALL_NAME,data[index].HALL_ID);
    		}
    		
    	},'json');
    	
    	
    });
    
    
</script>	
	
</body>
</html>