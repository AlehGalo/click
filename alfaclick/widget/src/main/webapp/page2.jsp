<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- load the dashboard css -->
<link href="css/sDashboard.css" rel="stylesheet">
<!-- load jquery library -->
<script src="libs/jquery/jquery-1.8.2.js" type="text/javascript">
</script>
<!-- load jquery ui library -->
<script src="libs/jquery/jquery-ui.js" type="text/javascript">
</script>
<!-- load flotr2 charting library -->
<!--[if IE]>
		<script language="javascript" type="text/javascript" src="libs/flotr2/flotr2.ie.min.js"></script>
		<![endif]-->
<script src="libs/flotr2/flotr2.js" type="text/javascript"> </script>
<script src="libs/jquery-sDashboard.js" type="text/javascript">
</script>
<script type="text/javascript">
	$(function() {
		var dashboardJSON = [
				<c:forEach items="${helloWorld.widgetsList}" var="item">
				{
					widgetTitle : "${item.label}",
					widgetId : "${item.widgetid}",
					enableRefresh : false,
					refreshCallBack : function(widgetId) {
						return randomString + new Date();
					},
					widgetContent : '<form><ul class="form-style-1"><c:forEach items="${item.params.param}" var="paramet"><c:if test="${paramet.mode == 'SIMPLE'}"><li><label for="${paramet.paramid}">${paramet.label}</label><c:if test="${paramet.type == 'STRING'}"><input type="text" class="field-long" id="${paramet.paramid}" value="${paramet.default}" title="${paramet.hint}" /></c:if><c:if test="${paramet.type == 'DATE'}"><input type="date" class="field-long" id="${paramet.paramid}" value="${paramet.default}" title="${paramet.hint}" /></c:if><c:if test="${paramet.type == 'AMOUNT'}"><input type="number" class="field-long" id="${paramet.paramid}" value="${paramet.default}" title="${paramet.hint}" /></c:if><c:if test="${paramet.type == 'SELECT'}"><select class="field-select" id="${paramet.paramid}" title="${paramet.hint}"><c:forEach items="${paramet.selectItems.item}" var="selItem"><option>${selItem}</option></c:forEach></select></c:if></li></c:if></c:forEach></ul></form>'.trim()
				},</c:forEach>
				];
		$("#myDashboard").sDashboard({
			dashboardData : dashboardJSON
		});
		$("#myDashboard").bind("sdashboardwidgetmaximized", function(e,data) {
			debugger;
			var widgetId = data.widgetDefinition.widgetId;
		});
	});
</script>
</head>
<body style="background-color: gray;">
	<hr />
	<ul id="myDashboard">
	</ul>
</body>
</html>