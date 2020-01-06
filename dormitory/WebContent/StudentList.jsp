<%-- <%@ page language="java" import="org.apache.struts2.ServletActionContext" pageEncoding="UTF-8"%> --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>平顶山学院宿舍管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">校园宿舍管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">学生管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="studentAction_findByName">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="28%" height="30" style="padding-left:20px;"> 功能导航： <a href="studentAction_toadd">添加学生</a></td>
                    <td width="72%">
                     <%--  <select name="State" id="State">
                        <option value="入住">入住</option>
                        <option value="未入住">未入住</option>
                        <option value="迁出">迁出</option>
                      </select> --%>
                      <%-- <select name="SearchRow" id="SearchRow">
                        <option value="Student_Name">姓名</option>
                        <option value="Student_Username">学号</option>
                        <option value="Student_Class">班级</option>
                      </select> --%>
                      姓名：
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="点击查询"></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>学号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>姓名</strong></td>
                    <td bgcolor="#D5E4F4"><strong>性别</strong></td>
                    <td bgcolor="#D5E4F4"><strong>电话</strong></td>
                    <td bgcolor="#D5E4F4"><strong>寝室号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                 <c:forEach items="${list}" var="s">
                    <tr align="center">
                      <td height="25" align="center">${s.s_uname}</td>
                      <td>${s.s_name}</td>
                      <td>${s.s_sex}</td>
                      <td>${s.s_tel}</td>
                      <td align="center">${s.s_dormitory}</td>
                      <td align="center"><a href="studentAction_toupd?sid=${s.id}">修改</a> <a href="studentAction_del?sid=${s.id}" onClick="return confirm('确定要删除该学生吗？')">删除</a></td>
                    </tr>
                 </c:forEach>
              <%--     <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center">

                    <%
                      for (int i=0;i<240/16;i++){
//                        HttpSession session = ServletActionContext.getRequest().getSession();
                    %><td><a href="StudentManager.action?a=<%=i%>" <%session.setAttribute("number111", i*16);%>><%if(i<9){%>
                    <%=0+Integer.toString(i+1)%>
                  <%}%>
                    <%if(i>=9){%>
                    <%=i+1%>
                  <%}%>
                  </a></td>
                    <%
                      }
                    %>

                  </tr>
                </table> --%>

            </td>
            </tr>

          </table>

          </td>

        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
