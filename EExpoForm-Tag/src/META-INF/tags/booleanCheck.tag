<%@tag import="eexpoform.field.BooleanValueField"%>
<%@tag import="eexpoform.field.MultiValueField"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="field" required="true" type="eexpoform.field.BooleanValueField"%>
<%@ attribute name="readOnly" required="false" type="java.lang.Boolean"%>
<div class="form-group">
	<div class="checkbox">
		<label><input type="checkbox" name="<%=field.name%>" 
			<%=field.value? "checked" : "" %>
			<%=readOnly ? "disabled" : "" %>
			value="true"><%=field.label%></label>
	</div>
</div>

