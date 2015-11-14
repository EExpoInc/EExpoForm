package eexpoforms;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FormBuilder {
	Map<String, String> fieldnameValueMap = new HashMap<>();
	
	public <E> void createForm(E entity){
		
	}
	
	public FormFieldBase buildField(Field f, Object obj){
		FormFieldBase result = new FormFieldBase();
		f.setAccessible(true); 
		
		result.label = resolveLabel(f);
		result.values(resolveValue());
		
		return result;
	}
	
	
	public String resolveLabel(Field f){
		return f.getName();
	}
	
//	public boolean 
	
	
	

}
