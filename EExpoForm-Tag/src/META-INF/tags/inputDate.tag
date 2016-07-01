<%@tag import="eexpoform.field.DateValueField"%>
<%@tag import="eexpoform.field.OpenValueField"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="field" required="true" type="eexpoform.field.DateValueField"%>
<%@ attribute name="readOnly" required="false" type="java.lang.Boolean"%>


			<div class="form-group">
                <label for="<%=field.id()%>"><%=field.label%></label>
                <%if(!readOnly){ %>
                <div class="input-group date form_date" id="<%=field.id()%>"
                	data-date=""  data-min-view="2">
                    <input class="form-control" size="16" type="text" value="<%=field.formatedDate() %>" name="<%=field.name%>">
					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
                <%}else{ %>                
                	<input class="form-control" type="text" readonly="readonly" value="<%=field.formatedDate() %>"/>
                <%} %>
            </div>





