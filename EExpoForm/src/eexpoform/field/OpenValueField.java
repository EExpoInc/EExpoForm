package eexpoform.field;

import java.lang.reflect.Field;
import java.util.Arrays;

//input type text ou textarea
public class OpenValueField extends OpenMultiValueField{

	public OpenValueField(Field originalBeanField, Object selectedValue) {
		super(originalBeanField, Arrays.asList(selectedValue));
	}
	
	public String selectedValue(){
		if(this.selectedValues.get(0) == null){
			return "";
		}else{
			return this.selectedValues.get(0).toString().trim();	
		}
		
	}


	
}
