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
<%@ attribute name="bean" required="true" type="java.lang.Object"%>
<%@ attribute name="readOnly" required="false" type="java.lang.Boolean"%>
<%@ attribute name="action" required="true" type="java.lang.String"%>

<%@taglib prefix="ex" tagdir="/WEB-INF/tags"%>
 
 
 <%readOnly = readOnly==null?false: readOnly;%>
 
 <style>
div.group {
	border: 1px solid #ccc;
	padding: 1em;
	margin-top: 10px;
	margin-bottom: 10px;
	border-radius: 4px;
	
}
div.group > div.group-inner{
	height:10em;
	overflow:scroll;
	border: 1px solid #eee;
	border-radius: 4px;
	padding: 0.5em;
}
div.group label{
	display: block;
}

div.group div.checkbox label:HOVER, div.group div.radio label:HOVER{
	display: block;
	background-color: #f8fafd;
	border-radius: 4px;
	
}


</style>
 
 
<!-- START EExpoFORM  -->
<% TagHelper tagHelper = new TagHelper(bean, request, response); %>
<form role="form" action="<%=action%>" method="post" accept-charset="UTF-8" >
<%-- <form role="form" action="<%=tagHelper.formBase().action%>"> --%>

<%while(tagHelper.hasNextField()){  
	FormFieldBase ffb = tagHelper.nextField();
	/* System.out.println(ffb.label);
	System.out.println(ffb.originalBeanField); */
	switch(TagHelper.analyseField(ffb)){
		case check: 
			%><ex:checkGroup field="<%=(MultiValueField) ffb %>" readOnly="<%=readOnly%>"/> <% 
			break;
		case checkOne: 
			%><ex:booleanCheck field="<%=(BooleanValueField) ffb %>" readOnly="<%=readOnly%>"/> <% 
			break;
		case combo: 
			%><ex:comboBox field="<%=(ChooseOneValueField) ffb %>" readOnly="<%=readOnly%>"/> <%
			break;
		case radio: 
			%><ex:radioGroup field="<%=(ChooseOneValueField) ffb %>" readOnly="<%=readOnly %>"/> <%
			break;
		case inputText: 
			%><ex:inputText field="<%=(OpenValueField) ffb %>" readOnly="<%=readOnly %>"/> <%
			break;
		default:
				break;
	}

}%>

 <%if(!readOnly){ %>
 <button type="submit" class="btn btn-default"><%=tagHelper.formBase().confirmBtnLabel %></button>
 <%} %>
 
</form>
<!-- END EExpoFORM  -->

