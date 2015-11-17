<%@tag import="eexpoform.field.BooleanValueField"%>
<%@tag import="eexpoform.field.MultiValueField"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="field" required="true" type="eexpoform.field.BooleanValueField"%>
<div class="form-group">
	<div class="checkbox">
		<label><input type="checkbox" name="<%=field.name%>" 
			<%=field.value? "checked" : "" %>
			value="true"><%=field.label%></label>
	</div>
</div>

