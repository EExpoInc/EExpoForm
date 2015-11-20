package eexpoform;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FormBase {
	
	
	public enum Type{
		create, // n mostra o id 
		read, update // mostra o id mas só readOnly
	}
	
	

	public String action= "";
	public Charset encode = StandardCharsets.UTF_8;
	public String confirmBtnLabel = "Confirm";
	public List<FormFieldBase> fieldList;
	
	public FormBase(List<FormFieldBase> fieldList) {
		this.fieldList = fieldList;
	}
	
}
