<%@tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="field" required="true" type="eexpoform.field.ChooseOneValueField"%>
<%@ attribute name="readOnly" required="false" type="java.lang.Boolean"%>

<div class="control-group group" > 
<label><%=field.label%></label>  

<%
	for (Object k : field.allValuesMap.keySet()) {
		
%>

<div class="radio">
	<label><input type="radio" name="<%=field.name%>" 
		<%=readOnly != null ? "readonly" : "" %>
		<%=(field.selectedValue().equals(k) ? "checked" : "" )%>
		value="<%=k%>"><%=field.allValuesMap.get(k)%></label>
</div>
<%
	}
%>
</div>



