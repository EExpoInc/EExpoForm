package eexpoform.field;

import java.lang.reflect.Field;
import java.util.List;

import eexpoform.FormFieldBase;

//input type text ou textarea
public class OpenMultiValueField extends FormFieldBase{

	
	protected List<Object> selectedValues;
	public OpenMultiValueField(Field originalBeanField, List<Object> selectedValues) {
		super(originalBeanField);
		this.selectedValues = selectedValues;
	}
	public List<Object> selectedValues(){
		return this.selectedValues;
	}
	

	
}
