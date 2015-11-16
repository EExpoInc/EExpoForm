package eexpoform.field;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;


public class ChooseOneValueField extends MultiValueField{

	
	public ChooseOneValueField(Field originalBeanField, LinkedHashMap<String, String> allValuesMap, String selectedValue) {
		super(originalBeanField, allValuesMap, Arrays.asList(selectedValue));
	}
	
	public String selectedValue(){
		
		return this.selectedValues.get(0);
	}
	
	
}
