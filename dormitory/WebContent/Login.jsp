<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>"> 
  <title>平顶山学院宿舍管理系统</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="Style/Style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="styles/edumis.css">
    <link rel="stylesheet" type="text/css" href="styles/login.css">
    <script src="script/jquery-1.11.1.min.js"></script>
    <script src="script/edumis_function.js"></script>
    <script src="script/jquery.md5.js"></script>
  <style>
    body{
      background-image: url("Images/bg11.jpg");
    }
    #Mycanvas{
      text-align: center;
      overflow: hidden;
    }
    .text1{
      width: 55%;
      height: 90%;
    }
  </style>
</head>
<body>
<div id="body-bg"></div>
<div class="clear"></div>
<canvas id="Mycanvas"></canvas>
<center class="panel login center-block">
 <img src="Images/title.png" style="width: 100%;height: 20%;"/> 
  <table width="400" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="400" align="center" valign="top" background="">
      <table width="350" height="200" border="0" cellpadding="0" cellspacing="0" style="display: block;margin-top: 45px;margin-left: -20px;">
        <tr>
          <td align="center" valign="top">
             <form name="form1" action="login.action" method="post" onSubmit="return mycheck()&&check()">
              <table width="100%" border="0" cellspacing="0" cellpadding="0" >
                <tr class="form1">
                  <td  height="30"  colspan="2" align="center" class="STYLE2"><span style="color:red;">
                    <%if(request.getAttribute("Msg")!=null){%>
                    <%=request.getAttribute("Msg")%>
                    <%}%>
                  </span></td>
                  </tr>
                <tr>
                  <td height="50" align="right" class="STYLE2" style="font-size: 20px">身份：</td>
                  <td align="left"><select style="width:200px;height:32px;border:none;border-radius:9px" name="Type" id="Type" class="text1">
                    <option value="" style="font-size: 1.3em">请选择</option>
                    <option value="系统管理员" style="font-size: 1.3em">系统管理员</option>
                    <option value="楼宇管理员" style="font-size: 1.3em">楼宇管理员</option>
                    <option value="学生" style="font-size: 1.3em">学生</option>
                  </select></td>
                  </tr>
                <tr>
                  <td width="37%" height="50" align="right" class="STYLE2" style="font-size:20px">用户名：</td>
                  <td width="300" align="left"><input placeholder="请输入用户名" style="width:200px;height:32px;border:none;border-radius:9px" type="text" name="uname" id="Username" class="text1" /></td>
                  </tr>
                <tr>
                  <td height="50" align="right" class="STYLE2" style="font-size: 20px">密码：</td>
                  <td align="left"><input placeholder="请输入密码" style="width:200px;height:32px;border:none;border-radius:9px" type="password" name="pwd" id="Password" class="text1" /></td>
                  </tr>
                <tr>
                <tr>
                  <td height="50" colspan="2" align="center"><label>
                    <input style="width:160px;height:35px;border:none;border-radius:9px;background-color:floralwhite;font-size:16px" type="submit" name="button" id="button" value="登录">
                  </label></td>
                  </tr>
              </table>
              </form>
          
          </td>
        </tr>
      </table></td>
    </tr>
  </table>


</center>

<script type="text/javascript" src="script/layer_edumis/layer.js" ></script>
<script src="scripts/login.js"></script>
<script type="text/javascript" src="script/logReg.js" ></script>
<script type="text/javascript">
    var mes="";
    mes="";
    if(mes.length>0){
        layer.alert("本系统无此用户，请联系所在学院。", {icon: 5});
    };
    var date = new Date();
    date = date.getFullYear();
    window.onload=function(){
        var year = document.getElementById("year");
        year.innerHTML = date;
    }
    //定义画布宽高和生成点的个数
    var WIDTH = window.innerWidth, HEIGHT = window.innerHeight, POINT = 35;

    var canvas = document.getElementById('Mycanvas');
    canvas.width = WIDTH,
        canvas.height = HEIGHT;
    var context = canvas.getContext('2d');
    context.strokeStyle = 'rgba(255,255,255,0.4)',
        context.strokeWidth = 1,
        context.fillStyle = 'rgba(255,255,255,0.4)';
    var circleArr = [];

    //线条：开始xy坐标，结束xy坐标，线条透明度
    function Line (x, y, _x, _y, o) {
        this.beginX = x,
            this.beginY = y,
            this.closeX = _x,
            this.closeY = _y,
            this.o = o;
    }
    //点：圆心xy坐标，半径，每帧移动xy的距离
    function Circle (x, y, r, moveX, moveY) {
        this.x = x,
            this.y = y,
            this.r = r,
            this.moveX = moveX,
            this.moveY = moveY;
    }
    //生成max和min之间的随机数
    function num (max, _min) {
        var min = arguments[1] || 0;
        return Math.floor(Math.random()*(max-min+1)+min);
    }
    // 绘制原点
    function drawCricle (cxt, x, y, r, moveX, moveY) {
        var circle = new Circle(x, y, r, moveX, moveY)
        cxt.beginPath()
        cxt.arc(circle.x, circle.y, circle.r, 0, 2*Math.PI)
        cxt.closePath()
        cxt.fill();
        return circle;
    }
    //绘制线条
    function drawLine (cxt, x, y, _x, _y, o) {
        var line = new Line(x, y, _x, _y, o)
        cxt.beginPath()
        cxt.strokeStyle = 'rgba(255,255,255,'+ o +')'
        cxt.lineWidth = 2;
        cxt.moveTo(line.beginX, line.beginY)
        cxt.lineTo(line.closeX, line.closeY)
        cxt.closePath()
        cxt.stroke();
    }
    //初始化生成原点
    function init () {
        circleArr = [];
        for (var i = 0; i < POINT; i++) {
            circleArr.push(drawCricle(context, num(WIDTH), num(HEIGHT), num(15, 2), num(10, -10)/40, num(10, -10)/40));
        }
        draw();
    }

    //每帧绘制
    function draw () {
        context.clearRect(0,0,canvas.width, canvas.height);
        for (var i = 0; i < POINT; i++) {
            drawCricle(context, circleArr[i].x, circleArr[i].y, circleArr[i].r);
        }
        for (var i = 0; i < POINT; i++) {
            for (var j = 0; j < POINT; j+=3) {
                if (i + j < POINT) {
                    var A = Math.abs(circleArr[i+j].x - circleArr[i].x),
                        B = Math.abs(circleArr[i+j].y - circleArr[i].y);
                    var lineLength = Math.sqrt(A*A + B*B);

                    var C = 1/lineLength*40-0.03;
                    var lineOpacity = C > 0.2 ? 0.2 : C;
                    if (lineOpacity > 0) {
                        drawLine(context, circleArr[i].x, circleArr[i].y, circleArr[i+j].x, circleArr[i+j].y, lineOpacity);
                    }
                }
            }
        }
    }

    //调用执行
    window.onload = function () {
        init();
        setInterval(function () {
            for (var i = 0; i < POINT; i++) {
                var cir = circleArr[i];
                cir.x += cir.moveX;
                cir.y += cir.moveY;
                if (cir.x > WIDTH) cir.x = 0;
                else if (cir.x < 0) cir.x = WIDTH;
                if (cir.y > HEIGHT) cir.y = 0;
                else if (cir.y < 0) cir.y = HEIGHT;

            }
            draw();
        }, 16);
    }
</script>
</body>
</html>
<script src="script/Jquery/Jquery.js"></script>
<script>
    $(function() {
        // 登录界面生成验证码
        (function create_code() {
          function shuffle() {
            var arr = ['1', 'r', 'Q', '4', 'S', '6', 'w', 'u', 'D', 'I', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', '2', 's', 't', '8', 'v', '7', 'x', 'y', 'z', 'A', 'B', 'C', '9', 'E', 'F', 'G', 'H', '0', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '3', 'R', '5', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
            return arr.sort(function() {
              return(Math.random() - .5);
            });
          };
          shuffle();

          function showAuthCode() {
            var ar1 = '';
            var code = shuffle();
            for(var i = 0; i < 6; i++) {
              ar1 += code[i];
            };
            $(".check").text(ar1);
          };
          showAuthCode();
          $(".check").click(function() {
            showAuthCode();
          });
        })();
        //登录界面账户输入框失去焦点
      });
</script>
<script type="text/javascript">
    var mes="";
    mes="";
    if(mes.length>0){
        layer.alert("本系统无此用户，请联系所在学院。", {icon: 5});
    };
    var date = new Date();
    date = date.getFullYear();
    window.onload=function(){
        var year = document.getElementById("year");
        year.innerHTML = date;
    }
    //定义画布宽高和生成点的个数
    var WIDTH = window.innerWidth, HEIGHT = window.innerHeight, POINT = 35;

    var canvas = document.getElementById('Mycanvas');
    canvas.width = WIDTH,
        canvas.height = HEIGHT;
    var context = canvas.getContext('2d');
    context.strokeStyle = 'rgba(255,255,255,0.4)',
        context.strokeWidth = 1,
        context.fillStyle = 'rgba(255,255,255,0.4)';
    var circleArr = [];

    //线条：开始xy坐标，结束xy坐标，线条透明度
    function Line (x, y, _x, _y, o) {
        this.beginX = x,
            this.beginY = y,
            this.closeX = _x,
            this.closeY = _y,
            this.o = o;
    }
    //点：圆心xy坐标，半径，每帧移动xy的距离
    function Circle (x, y, r, moveX, moveY) {
        this.x = x,
            this.y = y,
            this.r = r,
            this.moveX = moveX,
            this.moveY = moveY;
    }
    //生成max和min之间的随机数
    function num (max, _min) {
        var min = arguments[1] || 0;
        return Math.floor(Math.random()*(max-min+1)+min);
    }
    // 绘制原点
    function drawCricle (cxt, x, y, r, moveX, moveY) {
        var circle = new Circle(x, y, r, moveX, moveY)
        cxt.beginPath()
        cxt.arc(circle.x, circle.y, circle.r, 0, 2*Math.PI)
        cxt.closePath()
        cxt.fill();
        return circle;
    }
    //绘制线条
    function drawLine (cxt, x, y, _x, _y, o) {
        var line = new Line(x, y, _x, _y, o)
        cxt.beginPath()
        cxt.strokeStyle = 'rgba(255,255,255,'+ o +')'
        cxt.lineWidth = 2;
        cxt.moveTo(line.beginX, line.beginY)
        cxt.lineTo(line.closeX, line.closeY)
        cxt.closePath()
        cxt.stroke();

    }
    //初始化生成原点
    function init () {
        circleArr = [];
        for (var i = 0; i < POINT; i++) {
            circleArr.push(drawCricle(context, num(WIDTH), num(HEIGHT), num(15, 2), num(10, -10)/40, num(10, -10)/40));
        }
        draw();
    }

    //每帧绘制
    function draw () {
        context.clearRect(0,0,canvas.width, canvas.height);
        for (var i = 0; i < POINT; i++) {
            drawCricle(context, circleArr[i].x, circleArr[i].y, circleArr[i].r);
        }
        for (var i = 0; i < POINT; i++) {
            for (var j = 0; j < POINT; j+=3) {
                if (i + j < POINT) {
                    var A = Math.abs(circleArr[i+j].x - circleArr[i].x),
                        B = Math.abs(circleArr[i+j].y - circleArr[i].y);
                    var lineLength = Math.sqrt(A*A + B*B);

                    var C = 1/lineLength*40-0.03;
                    var lineOpacity = C > 0.2 ? 0.2 : C;
                    if (lineOpacity > 0) {
                        drawLine(context, circleArr[i].x, circleArr[i].y, circleArr[i+j].x, circleArr[i+j].y, lineOpacity);
                    }
                }
            }
        }
    }

    //调用执行
    window.onload = function () {
        init();
        setInterval(function () {
            for (var i = 0; i < POINT; i++) {
                var cir = circleArr[i];
                cir.x += cir.moveX;
                cir.y += cir.moveY;
                if (cir.x > WIDTH) cir.x = 0;
                else if (cir.x < 0) cir.x = WIDTH;
                if (cir.y > HEIGHT) cir.y = 0;
                else if (cir.y < 0) cir.y = HEIGHT;

            }
            draw();
        }, 16);
    }
</script>
<script language="JavaScript">

  function mycheck(){
    if(isNull(form1.Type.value)){
      alert("请选择身份！");
      return false;
    }
    if(isNull(form1.Username.value)){
      alert("请输入用户名！");
      return false;
    }
    if(isNull(form1.Password.value)){
      alert("请输入密码！");
      return false;
    }
    if(isNull(form1.check.value)){
      alert("输入验证码！");
      return false;
    }
    alert(type(form1.check.value)+":"+form1.check.value);
    alert(type($(".check").value)+":"+$(".check").value);
    if(!(form1.check.value.toString()==$(".check").value)){
      alert("验证码输入错误！");
      return false;
    }

  }

  function isNull(str){
    if ( str == "" ) return true;
    var regu = "^[ ]+$";
    var re = new RegExp(regu);
    return re.test(str);
  }


</script>