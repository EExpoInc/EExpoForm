<%@tag import="eexpoform.field.OpenValueField"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="field" required="true" type="eexpoform.field.OpenValueField"%>

<!-- START EExpoFORM  -->

	<div class="form-group">
		<label for="<%=field.id()%>"><%=field.label%></label>  
		<input type="text" class="form-control" id="<%=field.id()%>" value="<%=field.selectedValue()%>">
	</div>

<!-- END EExpoFORM  -->

