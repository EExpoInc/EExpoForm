package eexpoforms.field;

import java.util.LinkedHashSet;

import eexpoforms.FormFieldBase;

class MultiValueField extends FormFieldBase {
	public class SimpleValueLabel {
		String value, label;
	}
	
	protected LinkedHashSet<SimpleValueLabel> valueLabelSet;
	
	public MultiValueField(LinkedHashSet<SimpleValueLabel> valueLabelSet) {
		this.valueLabelSet = valueLabelSet;
	}
	
}
