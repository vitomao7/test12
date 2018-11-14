<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加电影</title>
    <link rel="stylesheet" href="css/bootstrap.css" />
        <link rel="stylesheet" href="bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css"/>
    <script src="js/jquery-1.11.1.min.js"> </script>
    <script src="js/bootstrap.js"> </script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div style="margin-top:50px">
               <form  class="bs-example bs-example-form" role="form">
                    <div class="input-group col-md-4 col-md-offset-4">
                         <span class="input-group-addon">电影名</span>
                         <input type="text" class="form-control" placeholder="请输入用户名">
                    </div>          
                    <br>
                    <div class="input-group col-md-4 col-md-offset-4">
                         <span class="input-group-addon">国家</span>
                         <input type="text" class="form-control" placeholder="请输入用户名">
                    </div>          
                    <br>
                    <div class="input-group col-md-4 col-md-offset-4">
                         <span class="input-group-addon">时长</span>
                         <input type="text" class="form-control" placeholder="请输入用户名">
                    </div>          
                    <br>
                    <div class="input-group col-md-4 col-md-offset-4 date form_date"
                    data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                         <span class="input-group-addon">上映时间</span>
                         <input type="text" class="form-control" placeholder="请选择上映时间">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </div>          
                    <br>
                    <div class="input-group col-md-4 col-md-offset-4">
                         <span class="input-group-addon">主演</span>
                         <input type="text" class="form-control" placeholder="请输入用户名">
                    </div>          
                    <br>
                    <div class="input-group col-md-4 col-md-offset-4 check">
                         <span class="input-group-addon">类型</span>
						<div class="checkbox form-control" style="float:left">
						    <label><input type="checkbox" value="">选项 1</label>
						</div>
						<div class="checkbox form-control" style="float:left">
						    <label><input type="checkbox" value="">选项 1</label>
						</div>
						<div class="checkbox form-control" style="float:left">
						    <label><input type="checkbox" value="">选项 2</label>
						</div>
                    </div>
                    <br>  
                    <div class="input-group col-md-4 col-md-offset-4">
                         <span class="input-group-addon">图片</span>
                         <input type="file" class="form-control" placeholder="请输入用户名">
                    </div> 
                    <br />
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
</script>	
	
	
</body>
</html>