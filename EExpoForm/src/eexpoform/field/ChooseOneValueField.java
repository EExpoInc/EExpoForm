package eexpoform.field;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;


public class ChooseOneValueField extends MultiValueField{

	
	public ChooseOneValueField(Field originalBeanField, LinkedHashMap<Object, String> allValuesMap, Object selectedValue) {
		super(originalBeanField, allValuesMap, Arrays.asList(selectedValue));
	}
	
	public Object selectedValue(){
		Object obj = this.selectedValues.get(0);
		if(obj == null){
			obj = "NO_OBJECT_TO_SE_HERE_"+Math.random();
		}
//		return this.selectedValues.get(0);
		return obj;
	}
	
	
}
