<%@tag import="eexpoform.tag.TagHelper.OutputTag"%>
<%@tag import="eexpoform.field.MultiValueField"%>
<%@tag import="eexpoform.field.OpenMultiValueField"%>
<%@tag import="eexpoform.field.BooleanValueField"%>
<%@tag import="eexpoform.field.ChooseOneValueField"%>
<%@tag import="eexpoform.field.OpenValueField"%>
<%@tag import="eexpoform.FormFieldBase"%>
<%@tag import="eexpoform.tag.TagHelper"%>
<%@tag import="eexpoform.FormBase"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="eexpoform" required="false" type="eexpoform.FormBase"%>
<%@taglib prefix="eexpoform" uri="http://eexponews.com/eexpoform"%>

<!-- START EExpoFORM  -->
<%TagHelper tagHelper = new TagHelper(eexpoform, request, response); %>
<form role="form" action="<%=eexpoform.action%>">

<%while(tagHelper.hasNextField()){  
	FormFieldBase ffb = tagHelper.nextField();
	switch(TagHelper.analyseField(ffb)){
		case check: 
			%><eexpoform:checkGroup field=<%=(MultiValueField) ffb %>/> <% 
			break;
		case checkOne: 
			%><eexpoform:booleanCheck field=<%=(BooleanValueField) ffb %>/> <% 
			break;
		case combo: 
			%><eexpoform:comboBox field=<%=(ChooseOneValueField) ffb %>/> <%
			break;
		case radio: 
			%><eexpoform:radioGroup field=<%=(ChooseOneValueField) ffb %>/> <%
			break;
		case inputText: 
			%><eexpoform:inputText field=<%=(OpenValueField) ffb %>/> <%
			break;
		default:
				break;
	}

}%>




<!-- 	<div class="form-group">
		<label for="email">Email address:</label> <input type="email"
			class="form-control" id="email">
	</div>
	<div class="form-group">
		<label for="pwd">Password:</label> <input type="password"
			class="form-control" id="pwd">
	</div>
	<div class="checkbox">
		<label><input type="checkbox"> Remember me</label>
	</div>
 -->	
 
 <button type="submit" class="btn btn-default"><%=eexpoform.confirmBtnLabel %></button>
</form>
<!-- END EExpoFORM  -->

