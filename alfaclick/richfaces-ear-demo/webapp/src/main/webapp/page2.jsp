<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<f:view>
	<!DOCTYPE html>
	<html>
<head>
<!--[if IE]>
	<script language="javascript" type="text/javascript" src="libs/flotr2/flotr2.ie.min.js"></script>
<![endif]-->
<a4j:loadScript src="libs/jquery/jquery-1.8.2.js" />
<a4j:loadScript src="libs/jquery/jquery-ui.js" />
<a4j:loadScript src="libs/flotr2/flotr2.js" />
<a4j:loadScript src="libs/jquery-sDashboard.js" />
<a4j:loadStyle src="css/sDashboard.css" />
<script type="text/javascript">
	$(function() {
		var dashboardJSON = [
				<c:forEach items="${widgetService.widgetList}" var="item">
				{
					widgetTitle : "${item.label}",
					widgetId : "${item.widgetid}",
					enableRefresh : false,
					refreshCallBack : function(widgetId) {
						return randomString + new Date();
					},
					widgetContent :''
				},</c:forEach>
				];
		$("#myDashboard").sDashboard({
			dashboardData : dashboardJSON
		});
		
		$("#myDashboard").bind("sdashboardwidgetmaximized", function(e,data) {
			 console.log("maximized");
		});
		$("#myDashboard").bind("sdashboardorderchanged", function(e, data) {
		    console.log(data.sortedDefinitions);
		});
	});
</script>
</head>
<body style="background-color: gray;">
	<hr />
	<ul id="myDashboard"></ul>
<%--     <ui:include src="WEB-INF/pages/widgetForm.xhtml">
        <ui:param name="iterableItems" value="#{item}"></ui:param>
        <ui:param name="mode" value="SIMPLE"></ui:param>
    </ui:include> --%>
</body>
	</html>
</f:view>