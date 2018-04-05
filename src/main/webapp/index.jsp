<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<table align="center" width="50%" border="1">
  		<c:forEach items="${list }" var="map">
  			<tr>
	  			<c:forEach items="${map }" var="entry">
	  				<td>${entry.value }</td>
	  			</c:forEach>
  			</tr>
  		</c:forEach>
  	</table>
  	<hr/>
    <form action="mvc/news/save" method="post">
    	id:<input type="text" name="id"/><br/>
    	author:<input type="text" name="author"/><br/>
    	title:<input type="text" name="title"/><br/>
    	content:<textarea rows="5" name="content" cols="30"></textarea>
    	<input type="submit">
    </form>
    <a href="web/index.html">index.html</a>
  </body>
</html>
