<%@taglib prefix="alfaTag" uri="http://alfaclick.ru/taglib"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<html>
<head>
<title>Alfa</title>
</head>
<body style="background-color: gray">
	<f:view>
		<ui:repeat var="widget" value="#{widgetService.widgetList}">
			<div class="column">
				<div class="portlet">
					<div class="portlet-header" id="#{widget.widgetid}">#{widget.label}</div>
					<div class="portlet-content">
						<ui:repeat var="parametVar" value="#{widget.params.param}">
							<h:panelGroup rendered="#{parametVar.mode =='SIMPLE'}">
								<alfaTag:field label="#{parametVar.label}"
									paramid="#{parametVar.paramid}" type="#{parametVar.type}"
									hint="#{parametVar.hint}" value="#{parametVar.default}"></alfaTag:field>
							</h:panelGroup>
						</ui:repeat>
					</div>
				</div>
			</div>
		</ui:repeat>
	</f:view>
</body>