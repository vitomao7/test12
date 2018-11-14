<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/index.css"/>
    <title>美团网</title>
</head>
<body>
    <!--设置顶部菜单栏部分-->
    <div id="menu">
        <div class="center">
            <img src="img/logo.png" style="float:left;" alt="logo"/>
            <div id="city">
                <a href="#">秦皇岛</a>
                <div id="citys">
                    北京………………
                </div>
            </div>
            <ul>
                <li class="firstli"><a href="">首页</a></li>
                <li><a href="">电影</a></li>
                <li><a href="">影院</a></li>
                <li><a href="">榜单</a></li>
                <li><a href="">热点</a></li>
              
            </ul>
            <div id="app">
                <a href="">app下载</a>
                <div id="apps">
                    北京………………
                </div>
            </div>
            <div class="form">
                <form action="#">
                    <input type="text" id="text"/><input type="submit" value="" id="sub"/>

                </form>
            </div>
            <div id="login">
                <img src="img/user.png" alt=""/>
            </div>
        </div>
    </div>
    <!--设置主体内容-->
    <div id="content">
        <div class="k"></div>
        <div class="banner">
            <img src="img/banner.png" alt=""/>
        </div>
     
        
        <div class="hot">
            <div class="left">
                <h1>全部热映25部</h1>
                <h3><a href="">全部</a></h3>
                <div class="clear"></div>
                
				<c:forEach var="m" items="${requestScope.movies }">
                <div class="movie">
                    <img style="" src="${m.MOVIE_PIC }" alt=""/><button onclick="location.href='CinemaSelServlet.do?id=${m.MOVIE_ID}'">购买</button>
                    <span class="movieName">${m.MOVIE_NAME }</span>
                    <span class="movieScore">${m.MOVIE_SCORE }</span>
                </div>    	
        		</c:forEach>
 

                
            </div>
            <div class="right">
                <h1>今日票房</h1>
                <ul>
                    <li class="firstli">
                        <img src="img/smjx.png" alt=""/>
                        <div>
                            <a href="">1 神秘巨星<br/><label>247.9万</label></a>
                        </div>
                    </li>
                    <div class="clear"></div>
                    <li><a href="">2 神秘巨星<span>247.9万</span></a></li>
                    <li><a href="">3 神秘巨星<span>247.9万</span></a></li>
                    <li><a href="">4 神秘巨星<span>247.9万</span></a></li>
                    <li><a href="">5 神秘巨星<span>247.9万</span></a></li>
                    <li><a href="">6 神秘巨星<span>247.9万</span></a></li>
                    <li><a href="">7 神秘巨星<span>247.9万</span></a></li>
                    <li><a href="">8 神秘巨星<span>247.9万</span></a></li>
                    <li><a href="">9 神秘巨星<span>247.9万</span></a></li>
                    <li><a href="">10神秘巨星<span>247.9万</span></a></li>
                </ul>
            </div>
        </div>
        欢迎：${sessionScope.users.get(0).USER_NAME }登录
        
        
        <!--即将上映-->
        <div class="release">
            <div class="left">
                <h1>即将上映（280部）</h1>
                <h3><a href="">全部&gt;</a></h3>
                <div class="clear"></div>
                <div class="movie">
                    <div class="movieborder">
                        <img src="img/smjx.png" alt=""/><div class="think">84362人想看</div>
                        <span class="movieName">深海越狱</span>
                        <div class="yugao"><span>预告片</span><a href="">预售</a></div>
                    </div>
                    <p>6月8号上映</p>
                </div>
                <div class="movie">
                    <div class="movieborder">
                        <img src="img/smjx.png" alt=""/><div class="think">84362人想看</div>
                        <span class="movieName">深海越狱</span>
                        <div class="yugao"><span>预告片</span><a href="">预售</a></div>
                    </div>
                    <p>6月8号上映</p>
                </div>
                <div class="movie">
                    <div class="movieborder">
                        <img src="img/smjx.png" alt=""/><div class="think">84362人想看</div>
                        <span class="movieName">深海越狱</span>
                        <div class="yugao"><span>预告片</span><a href="">预售</a></div>
                    </div>
                    <p>6月8号上映</p>
                </div>
                <div class="movie">
                    <div class="movieborder">
                        <img src="img/smjx.png" alt=""/><div class="think">84362人想看</div>
                        <span class="movieName">深海越狱</span>
                        <div class="yugao"><span>预告片</span><a href="">预售</a></div>
                    </div>
                    <p>6月8号上映</p>
                </div>
                <div class="movie">
                    <div class="movieborder">
                        <img src="img/smjx.png" alt=""/><div class="think">84362人想看</div>
                        <span class="movieName">深海越狱</span>
                        <div class="yugao"><span>预告片</span><a href="">预售</a></div>
                    </div>
                    <p>6月8号上映</p>
                </div>
                <div class="movie">
                    <div class="movieborder">
                        <img src="img/smjx.png" alt=""/><div class="think">84362人想看</div>
                        <span class="movieName">深海越狱</span>
                        <div class="yugao"><span>预告片</span><a href="">预售</a></div>
                    </div>
                    <p>6月8号上映</p>
                </div>
                <div class="movie">
                    <div class="movieborder">
                        <img src="img/smjx.png" alt=""/><div class="think">84362人想看</div>
                        <span class="movieName">深海越狱</span>
                        <div class="yugao"><span>预告片</span><a href="">预售</a></div>
                    </div>
                    <p>6月8号上映</p>
                </div>
                <div class="movie">
                    <div class="movieborder">
                        <img src="img/smjx.png" alt=""/><div class="think">84362人想看</div>
                        <span class="movieName">深海越狱</span>
                        <div class="yugao"><span>预告片</span><a href="">预售</a></div>
                    </div>
                    <p>6月8号上映</p>
                </div>
            </div>
            <div class="right">
                <h1>今日票房</h1>
                <ul>
                    <li class="firstli"><img src="img/smjx.png" alt=""/>
                        <div>
                            <a href="">
                                侏罗纪世界2<br/>
                                <label>上映时间：2018-06-15</label><br/>
                                <span>507907人想看</span></a>
                        </div>
                    </li>
                    <li class="second">
                        <img src="img/1.jpg" alt=""/>
                        <a href="">神秘巨星<span>507907人想看</span></a>
                    </li>
                    <li class="third">
                        <img src="img/1.jpg" alt=""/>
                        <a href="">神秘巨星<span>507907人想看</span></a>
                    </li>
                    <div class="clear"></div>
                    <li><a href="">4 神秘巨星<span>507907人想看</span></a></li>
                    <li><a href="">5 神秘巨星<span>507907人想看</span></a></li>
                    <li><a href="">6 神秘巨星<span>507907人想看</span></a></li>
                    <li><a href="">7 神秘巨星<span>507907人想看</span></a></li>
                    <li><a href="">8 神秘巨星<span>507907人想看</span></a></li>
                    <li><a href="">9 神秘巨星<span>507907人想看</span></a></li>
                    <li><a href="">10神秘巨星<span>507907人想看</span></a></li>
                </ul>
            </div>
        </div>

    </div>
    <div class="footer">
        <p class="friendly-links">
            违法和不良信息举报电话: 4006018900
            举报邮箱: jubao.maoyan@maoyan.com
        </p>
        <p class="friendly-links">
            友情链接 :
            <a href="#">美团网</a>
            <span></span>
            <a href="#">美团下载</a>
        </p>
        <p>
            &copy;2016
            猫眼电影 maoyan.com
            <a href="#">京ICP证160733号</a>
            <a href="#">京ICP备16022489号-1</a>
            京公网安备 11010502030881号
            <a href="#">网络文化经营许可证</a>
            <a href="#">电子公告服务规则</a>
        </p>
        <p>北京猫眼文化传媒有限公司</p>
    </div>
</body>
</html>