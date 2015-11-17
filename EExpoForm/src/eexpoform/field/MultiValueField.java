package eexpoform.field;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import eexpoform.FormFieldBase;

public class MultiValueField extends FormFieldBase {
//	public class SimpleValueLabel {
//		String value, label;
//	}
	
	protected List<Object> selectedValues;
//	protected Set<SimpleValueLabel> allValueLabelSet;
	public Map<Object, String> allValuesMap;
	
	public MultiValueField(Field originalBeanField, LinkedHashMap<Object, String> allValuesMap, List<Object> selectedValues) {
		super(originalBeanField);
		this.selectedValues = selectedValues;
		this.allValuesMap = allValuesMap;
	}
	
	
	public List<Object>  selectedValues(){
		return selectedValues;
	}
	
//	public MultiValueField selectedValues(String... selectedValues){
//		this.selectedValues = (ArrayList<String>) Arrays.asList(selectedValues);		
//		
//		return this;
//	}
	

}
