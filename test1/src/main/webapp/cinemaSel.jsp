<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/index.css"/>
    <link rel="stylesheet" href="css/cinemasel.css"/>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
<!--设置顶部菜单栏部分-->
<div id="menu">
    <div class="center">
        <img src="img/logo.png" style="float: left" alt=""/>
        <div id="city">
            <a href="#" >秦皇岛</a>
            <div id="citys">
                北京。。。。。
            </div>
        </div>
        <ul>
            <li class="firstli"><a href="">首页</a> </li>
            <li><a href="">电影</a></li>
            <li><a href="">影院</a></li>
            <li><a href="">榜单</a></li>
            <li><a href="">热点</a></li>
        </ul>
        <div id="app">
            <a href="#" >app下载</a>
        </div>
        <div class="form">
            <form action="#">
                <input id="text" type="text" placeholder="找影视剧，影院"/><input id="sub" type="submit" value=""/>
            </form>
        </div>
        <div id="login">
            <img src="img/peo.png" style="width: 60px;height: 60px" alt=""/>
        </div>
    </div>
</div>
</div>
</div>

    <!--设置back部分-->
    <div id="back">
        <div class="center">
            <img src="${requestScope.movie.get(0).MOVIE_PIC }" alt=""/>
            
            <div class="font">
                <h1>${requestScope.movie.get(0).MOVIE_NAME }</h1>
                <h2>scert super star</h2>
                <h6>
				
				<c:forEach var="t" varStatus="in" items="${requestScope.movie }">
					<c:choose>
					<c:when test="${in.index == 0 }">
						${t.TYPE_NAME }
					</c:when>
					<c:otherwise>
						,${t.TYPE_NAME }
					</c:otherwise>
					</c:choose>
				</c:forEach>
				
                	
                	
                </h6>
                <h6>${requestScope.movie.get(0).MOVIE_LCOU } /
                ${requestScope.movie.get(0).MOVIE_DUR }分钟</h6>
                <h6>${requestScope.movie.get(0).MOVIE_SHOW }</h6>
                <div class="left">
                    <button class="btn1">想看</button>
                    <button class="btn1">评分</button>
                    <button class="btn2">查看更多电影详情</button>
                </div>
                <div class="right">
                    <h6>想看数</h6>
                    <span class="span1">${requestScope.movie.get(0).MOVIE_LOOK }</span>
                    <h6>累计票房</h6>
                    <span class="span2">${requestScope.movie.get(0).MOVIE_BOX }</span>

                </div>
            </div>
            
        </div>
    </div>


<!--设置主要内容部分-->
  
    <div id="content"><!-- #content>.sel>ul>li -->
    <input type="hidden" name="movieId" value=""/>
        <div class="sel">	
      	
            <ul>
                <li class="un"><label >日期：</label>
                <span class="selected"></span> <input type="hidden" />
                <span></span><input type="hidden" />
                <span></span><input type="hidden" />
                </li>
				<input id="seldate" type="hidden" value="${requestScope.date}"/>
                <script>
                	var date = new Date();
                	var seldate = $("#seldate").val();
                	$(".sel ul li:eq(0) span:eq(0)").text("今天"+(date.getMonth()+1)+"月"+date.getDate()+"日");
                	$(".sel ul li:eq(0) span:eq(0)").next().val(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
                	$(".sel ul li:eq(0) span:eq(1)").text("明天"+(date.getMonth()+1)+"月"+(date.getDate()+1)+"日");
                	$(".sel ul li:eq(0) span:eq(1)").next().val(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getDate()+1));
                	$(".sel ul li:eq(0) span:eq(2)").text("后天"+(date.getMonth()+1)+"月"+(date.getDate()+2)+"日");
                	$(".sel ul li:eq(0) span:eq(2)").next().val(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getDate()+2));
                	$.each($(".sel ul li:eq(0) span"),function(i){
                		if(seldate == $(".sel ul li:eq(0) span").eq(i).next().val()){
                			$(".sel ul li:eq(0) span").removeClass("selected");
                			$(".sel ul li:eq(0) span").eq(i).addClass("selected");
                		}
                	});
                	
                </script>
             
                <li class="un">
                <label >品牌</label> 
                 <span class="selected">全部</span>
                </li>
         		
         		<!-- 设置行政区 -->
                <li class="un">
                <label >行政区：</label>
                <c:if test="${requestScope.areaId ==-1}">
                   <span class="selected">全部  </span><input type="hidden" name="areaId" value="-1"/> 
                </c:if>
                <c:if test="${requestScope.areaId !=-1}">
                   <span>全部 </span><input type="hidden" name="areaId" value="-1"/>
                </c:if>
                <c:forEach var="a" items="${requestScope.areas }">
                	<c:choose>
                		<c:when test="${a.AREA_ID ==requestScope.areaId }">
                		<span class="selected">${a.AREA_NAME }</span><input type="hidden" name="areaId" value="${a.AREA_ID }"/>
                		</c:when>
                		<c:otherwise>
                		<span>${a.AREA_NAME }</span><input type="hidden" name="areaId" value="${a.AREA_ID }"/>
                		</c:otherwise>
                	</c:choose>
                </c:forEach>
                
                </li>
                <li><label >特殊厅：</label>
                <c:if test="${requestScope.hallId ==-1}">
                <span class="selected">全部</span><input type="hidden" name="hallId" value="-1"/>
                </c:if>
                <c:if test="${requestScope.hallId !=-1}">
                <span >全部</span><input type="hidden" name="hallId" value="-1"/>
                </c:if>
                <c:forEach var="h" items="${requestScope.halls }">
                	<c:choose>
                		<c:when test="${requestScope.hallId==h.HALL_ID }">
                		<span class="selected">${h.HALL_NAME }</span> <input type="hidden"  name="hallId" value="${h.HALL_ID}"/> 
                		</c:when>
                		<c:otherwise>
                		<span>${h.HALL_NAME }</span><input type="hidden"  name="hallId" value="${h.HALL_ID}"/>
                		</c:otherwise>
                	</c:choose>
                	
                </c:forEach>
                </li>
            </ul>
        </div>
        <script charset="utf-8">
        $(".sel ul li:eq(0) span").click(function() {
        	 $(".sel ul li:eq(0) span").removeClass("selected");
			$(this).addClass("selected");
			
			var movieId = ${requestScope.movie.get(0).MOVIE_ID}
			var date = $(".sel ul li:eq(0) span").filter(".selected").next().val();
        	var areaid =  $(".sel ul li:eq(2) span").filter(".selected").next().val();
			var hallid = $(".sel ul li:eq(3) span").filter(".selected").next().val();
			location.href = "CinemaSelServlet.do?id="+movieId+"&date="+date+"&areaId="+areaid+"&hallId="+hallid;
			
		});
        $(".sel ul li:eq(2) span").click(function() {
       	 	$(".sel ul li:eq(2) span").removeClass("selected");
			$(this).addClass("selected");
			
			var movieId = ${requestScope.movie.get(0).MOVIE_ID}
			var date = $(".sel ul li:eq(0) span").filter(".selected").next().val();
        	var areaid =  $(".sel ul li:eq(2) span").filter(".selected").next().val();
			var hallid = $(".sel ul li:eq(3) span").filter(".selected").next().val();
			location.href = "CinemaSelServlet.do?id="+movieId+"&date="+date+"&areaId="+areaid+"&hallId="+hallid;
		});
        $(".sel ul li:eq(3) span").click(function() {
	       	$(".sel ul li:eq(3) span").removeClass("selected");
			$(this).addClass("selected");

			var movieId = ${requestScope.movie.get(0).MOVIE_ID}
			var date = $(".sel ul li:eq(0) span").filter(".selected").next().val();
        	var areaid =  $(".sel ul li:eq(2) span").filter(".selected").next().val();
			var hallid = $(".sel ul li:eq(3) span").filter(".selected").next().val();
			location.href = "CinemaSelServlet.do?id="+movieId+"&date="+date+"&areaId="+areaid+"&hallId="+hallid;			
		});

        
        </script>
        

        <div class="cinemalist">
            <h3>影院列表</h3>
            <ul>
            <c:if test="${empty requestScope.sessions }">
           		 没有相关场次的电影
            </c:if>
            <c:forEach var="s" items="${requestScope.sessions }">
               <li>
                    <h5><a href="">${s.CINEMA_NAME }</a></h5>
                    <span >地址：${s.CINEMA_ADDRESS }</span>
                    <button>选座购票</button>
                    <span style="float: right"><label >￥${s.PRICE }</label> 起</span>

               </li>
            </c:forEach>


            </ul>
        </div>

    </div>

    <!--设置footer-->
<div id="footer">

</div>

</body>
</html>