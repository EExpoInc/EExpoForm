package eexpoforms.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import eexpoform.FormBuilder;
import eexpoform.FormFieldBase;
import eexpoform.field.BooleanValueField;
import eexpoform.field.ChooseOneValueField;
import eexpoform.field.MultiValueField;
import eexpoform.field.OpenMultiValueField;
import eexpoform.field.OpenValueField;

public class Main {
	
	public static void main(String[] args) {
//		BlogPostForm bpf = new BlogPostForm() {
		BlogPostEntity bpf = new BlogPostForm() {
			{
				this.id = 10;
				this.author = "joao";
				this.content = "Meu conteudo "+id;
				this.archived = true;
				this.meuStatus = Status.deleted;
				this.catList = Arrays.asList(1, 2);
				this.tagList = Arrays.asList("tag-1", "tag-2");
			}
		};
		
		FormBuilder fb = new FormBuilder();
		List<FormFieldBase> ffbs = fb.createForm(bpf).fieldList;
		for (FormFieldBase ffb : ffbs) {
//			getValue(ffb);

			System.out.println(ffb.label + ": " +getValue(ffb)); 
			System.out.println( getValuesAll(ffb) + "\n"); 
		}
		
		
	}

	private static String getValue(FormFieldBase ffb) {
		Object _result="";
		if(OpenValueField.class.isInstance(ffb)){
			_result = ((OpenValueField) ffb).selectedValue();
			
		}else if(BooleanValueField.class.isInstance(ffb)){
			_result = ((BooleanValueField) ffb).value + "";
			
		}else if(ChooseOneValueField.class.isInstance(ffb)){
			_result = ((ChooseOneValueField) ffb).selectedValue();
			
		}else if(MultiValueField.class.isInstance(ffb)){
			_result = ((MultiValueField) ffb).selectedValues();
			
		}else if(OpenMultiValueField.class.isInstance(ffb)){
			_result = ((OpenMultiValueField) ffb).selectedValues();
		}		
		if(_result != null){
			return _result.toString();
		}else{
			return null;
		}
	}
	
	
	private static String getValuesAll(FormFieldBase ffb) {
		Map<String, String>  _result = null;
		if(MultiValueField.class.isInstance(ffb)){
			_result = ((MultiValueField) ffb).allValuesMap;
		}
		
		if(_result != null){
			return _result.toString();
		}else{
			return null;
		}
	}
}
