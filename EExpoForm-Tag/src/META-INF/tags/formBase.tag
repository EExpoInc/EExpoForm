<%@tag import="eexpocrud.CrudfyUtils"%>
<%@tag import="eexpoform.field.DateValueField"%>
<%@tag import="eexpoform.tag.TagHelper.ButtonBootstrapCssClass"%>
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
<%@ attribute name="editableIdOnCreate" required="false" type="java.lang.Boolean"%>
<%@ attribute name="action" required="true" type="java.lang.String"%>
<%@ attribute name="btnCss" required="false" type="eexpoform.tag.TagHelper.ButtonBootstrapCssClass"%>

<%@taglib prefix="ex" uri="http://eexponews.com/eexpoform"%>
 
 
 <%
 editableIdOnCreate = editableIdOnCreate==null?false: editableIdOnCreate;
 readOnly = readOnly==null?false: readOnly;
 btnCss = btnCss==null?ButtonBootstrapCssClass.success : btnCss;
 %>
 
 <style type="text/css">

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
  
<!--     <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
 -->
 
 
 
 
 
<!-- START EExpoFORM  -->
<% TagHelper tagHelper = new TagHelper(bean, request, response, editableIdOnCreate); %>
<form role="form" action="<%=action%>" method="post" accept-charset="UTF-8"  enctype="application/x-www-form-urlencoded">
<%-- <form role="form" action="<%=tagHelper.formBase().action%>"> --%> 

<%while(tagHelper.hasNextField()){  
	FormFieldBase ffb = tagHelper.nextField();
	/* System.out.println(ffb.label);
	System.out.println(ffb.originalBeanField); */
	boolean _readOnly = readOnly ? readOnly : ffb.readOnly();
	switch(TagHelper.analyseField(ffb)){
		case check: 
			%><ex:checkGroup field="<%=(MultiValueField) ffb %>" readOnly="<%=_readOnly%>"/> <% 
			break;
		case checkOne: 
			%><ex:booleanCheck field="<%=(BooleanValueField) ffb %>" readOnly="<%=_readOnly%>"/> <% 
			break;
		case combo: 
			%><ex:comboBox field="<%=(ChooseOneValueField) ffb %>" readOnly="<%=_readOnly%>"/> <%
			break;
		case radio: 
			%><ex:radioGroup field="<%=(ChooseOneValueField) ffb %>" readOnly="<%=_readOnly %>"/> <%
			break;
		case inputText: 
			%><ex:inputText field="<%=(OpenValueField) ffb %>" readOnly="<%=_readOnly %>"/> <%
			break;
		case date: 
			%><ex:inputDate field="<%=(DateValueField) ffb %>" readOnly="<%=_readOnly %>"/> <%
			break;
		default:
				break;
	}

}%>
<div class="form-group text-right">
 <%if(action != null){ %>
 <button type="submit" class="<%=btnCss %> "><%=tagHelper.formBase().confirmBtnLabel %></button>
 <%} %>
 </div>

	<script type="text/javascript">
		$('.form_date').datetimepicker({format:"<%=CrudfyUtils.PATTERN_FULLDATE_JS%>"});
	</script>



</form>
<!-- END EExpoFORM  -->

