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
		BlogPostEntity bpf = genEntity();
		
		FormBuilder<BlogPostEntity> fb = new FormBuilder<BlogPostEntity>();
		List<FormFieldBase> ffbs = fb.createForm(bpf, false).fieldList;
		for (FormFieldBase ffb : ffbs) {
//			getValue(ffb);

			System.out.println(ffb.label + ": " +getValue(ffb)); 
			System.out.println( getValuesAll(ffb) + "\n"); 
		}
		
		
	}

	
	public static BlogPostEntity genEntity(){
		return new BlogPostForm() {
			{
				this.id = 10;
				this.authorId = 2;
				this.content = "Meu conteudo "+id;
				this.archived = true;
//				this.meuStatus = Status.published;
				this.catList = Arrays.asList(1, 2,7);
				this.tagList = Arrays.asList("tag-1", "tag-5");
			}
		};
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
		Map<Object, String>  _result = null;
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
