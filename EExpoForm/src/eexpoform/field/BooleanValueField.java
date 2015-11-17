package eexpoform.field;

import java.lang.reflect.Field;

import eexpoform.FormFieldBase;


public class BooleanValueField extends FormFieldBase{

	public boolean value = false;
	
	public BooleanValueField(Field originalBeanField, boolean selectedValue) {
		super(originalBeanField);
		this.value = selectedValue;
	}


	
	
}
