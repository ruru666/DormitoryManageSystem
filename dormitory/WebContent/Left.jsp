<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link href="Style/Style.css" rel="stylesheet" type="text/css" />
<table width="155" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="31" align="center" background="Images/left1.jpg"><strong>系统选项</strong></td>
            </tr>
            <tr>
              <td height="50" align="center" valign="top"><table width="150" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="Index.jsp">后台首页</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%if(session.getAttribute("type").toString().equals("1")){%>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="buildingAdminAction_tolist">楼宇管理员管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="studentAction_tolist">学生管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="buildingAction_tolist">楼宇管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="dormitoryAction_tolist">宿舍管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="StudentRZ.jsp">学生入住登记</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="StudentDH.jsp">学生寝室调换</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="StudentQC.jsp">学生迁出登记</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="sleepRecordsAction_tolist">学生缺寝记录</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="leaveSchoolAction_tolist">迁出记录</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                   <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="AdminPasswordUpdate.jsp">修改密码</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="Login.jsp" onclick="return confirm('确定要退出系统吗？')">退出系统</a></td>
                </tr>
              </table>
              </td>
            </tr>
                <%}%>
                <%if(session.getAttribute("type").toString().equals("2")){%>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="MyStudent.action">学生管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="MyLog.action">学生缺寝记录</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                   <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="BuildingChangePwd.jsp">修改密码</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="Login.jsp" onclick="return confirm('确定要退出系统吗？')">退出系统</a></td>
                </tr>
              </table>
              </td>
            </tr>
                <%}%>
                <%if(session.getAttribute("type").toString().equals("3")){%>
                <tr>
                 <!--  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="sleeprecords_FindAllBySid.action">我的缺寝记录</a></td> -->
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="sleeprecords_FindAllBySid.action">我的缺寝记录</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="RepairAdd.jsp">上报维修信息</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="maintainAction_FindAllBySid.action">我的维修记录</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                   <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="PasswordUpdate.jsp">修改密码</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/lefttwo.jpg" style="text-align:left; padding-left:40px;"><a href="Login.jsp" onclick="return confirm('确定要退出系统吗？')">退出系统</a></td>
                </tr>
              </table>
              </td>
            </tr>
                <%}%>
             
          </table>