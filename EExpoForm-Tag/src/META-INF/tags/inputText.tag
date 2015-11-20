<%@tag import="eexpoform.field.OpenValueField"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="field" required="true" type="eexpoform.field.OpenValueField"%>
<%@ attribute name="readOnly" required="false" type="java.lang.Boolean"%>

	<div class="form-group">
		<label for="<%=field.id()%>"><%=field.label%></label>  
		<input type="text" class="form-control" 
				id="<%=field.id()%>"
				<%=readOnly != null ? "readonly" : "" %> 
				value="<%=field.selectedValue()%>" name="<%=field.name%>">
	</div>


