<%@tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="field" required="false" type="eexpoform.field.ChooseOneValueField"%>
<%@ attribute name="readOnly" required="false" type="java.lang.Boolean"%>

<div class="form-group">
	
      <label for="<%=field.id()%>"><%=field.label%></label>
      <select class="form-control"
      		<%= readOnly ? "disabled" : "" %> 
      		id="<%=field.id()%>" 
      		name="<%=field.name%>" >
<%
	for (Object k : field.allValuesMap.keySet()) {
%>
	       <option value="<%=k%>" <%= field.selectedValue().equals(k)? "selected" : ""%>>
	       			<%=field.allValuesMap.get(k)%>
	       </option>
<%
	}
%>
	
	</select>
</div>

