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
	
	protected List<String> selectedValues;
//	protected Set<SimpleValueLabel> allValueLabelSet;
	public Map<String, String> allValuesMap;
	
	public MultiValueField(Field originalBeanField, LinkedHashMap<String, String> allValuesMap, List<String> selectedValues) {
		super(originalBeanField);
		this.selectedValues = selectedValues;
		this.allValuesMap = allValuesMap;
	}
	
	
	public List<String>  selectedValues(){
		return selectedValues;
	}
	
//	public MultiValueField selectedValues(String... selectedValues){
//		this.selectedValues = (ArrayList<String>) Arrays.asList(selectedValues);		
//		
//		return this;
//	}
	

}
