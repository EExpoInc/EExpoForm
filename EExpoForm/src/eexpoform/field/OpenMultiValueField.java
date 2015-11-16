package eexpoform.field;

import java.lang.reflect.Field;
import java.util.List;

import eexpoform.FormFieldBase;

//input type text ou textarea
public class OpenMultiValueField extends FormFieldBase{

	
	protected List<String> selectedValues;
	public OpenMultiValueField(Field originalBeanField, List<String> selectedValues) {
		super(originalBeanField);
		this.selectedValues = selectedValues;
	}
	public List<String> selectedValues(){
		return this.selectedValues;
	}
	

	
}
