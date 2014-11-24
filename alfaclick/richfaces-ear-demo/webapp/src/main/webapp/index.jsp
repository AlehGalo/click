<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!-- RichFaces tag library declaration -->
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/ext-all.css">
<script type="text/javascript" src="extjs/ext-all-debug.js"></script>
<title>Alfa Click</title>
<!--[if IE]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<!-- App Files -->
<link rel="stylesheet" type="text/css" href="resources/css/portal.css">
<script type="text/javascript" src="app.js"></script>
</head>
<body>
	<div id="loadingLogo" class="first-load"></div>
	<span id="app-msg" class="none-display"></span>
	<f:view>
		<c:forEach items="${widgets.widgetsList}" var="item">
			<div id="${item.widgetid}">
				<c:out value="${item.label}"></c:out>
				<br />
				<c:forEach items="${item.params.param}" var="paramet">
					<label for="${paramet.paramid}">${paramet.label}</label>
					<c:if test="${paramet.type == 'STRING'}">
						<input type="text" id="${paramet.paramid}"
							value="${paramet.default}" title="${paramet.hint}" />
					</c:if>
					<c:if test="${paramet.type == 'DATE'}">
						<input type="date" pattern="dd.MM.yyyy" id="${paramet.paramid}"
							value="${paramet.default}" title="${paramet.hint}" />
					</c:if>
					<c:if test="${paramet.type == 'AMOUNT'}">
						<input type="number" id="${paramet.paramid}"
							value="${paramet.default}" title="${paramet.hint}" />
					</c:if>
					<c:if test="${paramet.type == 'SELECT'}">
						<select id="${paramet.paramid}" title="${paramet.hint}">
							<c:forEach items="${paramet.selectItems.item}" var="selItem">
								<option>${selItem}</option>
							</c:forEach>
						</select>
					</c:if>
				</c:forEach>
			</div>
			<br />
		</c:forEach>
	</f:view>
</body>
</html>