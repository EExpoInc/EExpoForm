package eexpoform.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eexpoform.FormBase;
import eexpoform.FormFieldBase;
import eexpoform.field.BooleanValueField;
import eexpoform.field.ChooseOneValueField;
import eexpoform.field.MultiValueField;
import eexpoform.field.OpenValueField;

public class TagHelper {
	HttpServletRequest req;
	HttpServletResponse resp;
	FormBase formBase;
	int fieldIdx = 0;
	
	public enum OutputTag {
		check, checkOne, combo, inputText, radio
	}
	
	public TagHelper(FormBase formBase, HttpServletRequest req, HttpServletResponse resp) {
		this.formBase = formBase;
		this.req = req;
		this.resp = resp;
	}
	
	public boolean hasNextField() {
		return fieldIdx < formBase.fieldList.size() ? true : false;
	}
	
	public FormFieldBase nextField() {
		return formBase.fieldList.get(fieldIdx++);
	}
	
	public static OutputTag analyseField(FormFieldBase ffb) {
		
		OutputTag result;
		if (OpenValueField.class.isInstance(ffb)) {
			result = OutputTag.inputText;
			
		} else if (BooleanValueField.class.isInstance(ffb)) {
			result = OutputTag.checkOne;
			
		} else if (ChooseOneValueField.class.isInstance(ffb)) {
			ChooseOneValueField f = (ChooseOneValueField) ffb;
			
			if (f.allValuesMap.size() > FormFieldBase.MIN_TO_COMBO) {
				result = OutputTag.combo;
			} else {
				result = OutputTag.radio;
			}
			
		} else if (MultiValueField.class.isInstance(ffb)) {
			result = OutputTag.check;
			
		} else { //if (OpenMultiValueField.class.isInstance(ffb)) {
			result = OutputTag.inputText;
		}
		return result;
		
	}
	
}
