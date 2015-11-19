<%@tag import="eexpoform.FormFieldBase"%>
<%@tag import="eexpoform.field.ChooseOneValueField"%>
<%@tag import="eexpoform.field.MultiValueField"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="field" required="true" type="eexpoform.field.MultiValueField"%>
<%@ attribute name="readOnly" required="false" type="java.lang.Boolean"%>



<div class="control-group group" > 
	<label ><%=field.label%></label>  
	<div class="control-group <%=field.allValuesMap.size() > FormFieldBase.MIN_TO_COMBO ? "group-inner" : "" %>" >
<%
	for (Object k : field.allValuesMap.keySet()) {
%>
		<div class="checkbox">
			<label><input type="checkbox" name="<%=field.name%>" 
				<%=readOnly != null ? "readonly" : "" %>
				<%=field.selectedValues().contains(k) ? "checked" : "" %>
				value="<%=k%>"><%=field.allValuesMap.get(k)%></label>
		</div>
<% 
	}
%>
	</div>
</div>

