package eexpoform.field;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;


public class ChooseOneValueField extends MultiValueField{

	
	public ChooseOneValueField(Field originalBeanField, LinkedHashMap<Object, String> allValuesMap, Object selectedValue) {
		super(originalBeanField, allValuesMap, Arrays.asList(selectedValue));
	}
	
	public Object selectedValue(){
		
		return this.selectedValues.get(0);
	}
	
	
}
