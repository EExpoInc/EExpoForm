package eexpoform;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import eexpocrud.CrudfyUtils;
import eexpoform.field.BooleanValueField;
import eexpoform.field.ChooseOneValueField;
import eexpoform.field.MultiValueField;
import eexpoform.field.OpenMultiValueField;
import eexpoform.field.OpenValueField;

public class FormBuilder {
	
	
	public <E> FormBase createForm(E entity){
		List<FormFieldBase> formFieldList= new ArrayList<>();
		Field[] fields = entity.getClass().getFields();
		for (Field f : fields) {
			FormFieldBase ffb = buildField(f, entity);
			formFieldList.add(ffb); 
		}
		return new FormBase(formFieldList);

	}
	
//	public <E> List<FormFieldBase> createForm(E entity){
//		List<FormFieldBase> formFieldList= new ArrayList<>();
//		Field[] fields = entity.getClass().getFields();
//		for (Field f : fields) {
//			FormFieldBase ffb = buildField(f, entity);
//			formFieldList.add(ffb); 
//		}
//		return formFieldList;		
//	}
	
	public FormFieldBase buildField(Field f, Object obj){
//		FormFieldBase result = new FormFieldBase(f);
		f.setAccessible(true); 
		
		FormFieldBase result = resolveFieldType(f, obj);
		result.label = resolveLabel(f);
		
		return result;
	}
	

	@SuppressWarnings("unchecked")
	private LinkedHashMap<String, String> resolveAllValues(Field f, Object obj) {
		String allValuesMethodName = f.getName()+"All";
		Method allValuesMethod;
		LinkedHashMap<String, String> result;
		try { 
			allValuesMethod = obj.getClass().getMethod(allValuesMethodName);
			if(allValuesMethod!= null){
				Object _return = allValuesMethod.invoke(obj, (Object[])null);
				if(_return instanceof Map){
					result = (LinkedHashMap<String,String>) _return;
					return result;	
				}else if(_return instanceof List){
					List<String> allValuesList = (List<String>) _return;
					result = new LinkedHashMap<>();
					for (String s : allValuesList) {
						result.put(s, s);
					}
					
					return result;	
				}
				
				
			}
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//			e.printStackTrace();
		}
		
		if(f.getType().isEnum()){
			Class<?> c = f.getType();
			Object[] enums = c.getEnumConstants();
			result = new LinkedHashMap<String, String>();
			for (Object o : enums) {
				Enum<?> e = (Enum<?>) o;
				result.put(e.toString(), e.name());
			}
			return result;
		}
		
		return null; 
		
	}

	private FormFieldBase resolveFieldType(Field f, Object obj) {
		FormFieldBase result;
		List<String> selectedValues = this.resolveSeletedValues(f, obj);
		
		if(Collection.class.isAssignableFrom(f.getType())){
//		if(f.getType().isAssignableFrom(Collection.class)){
			LinkedHashMap<String, String> allValues =  this.resolveAllValues(f, obj);			
			if(allValues != null){				
				result = new MultiValueField(f, allValues, selectedValues);	
			}else {
				result = new OpenMultiValueField(f, selectedValues); 
			}
			
		}else if(f.getType().isEnum()){ 
			LinkedHashMap<String, String> allValues =  this.resolveAllValues(f, obj);
			result = new ChooseOneValueField(f, allValues, resolveOneValue(selectedValues));
		}else {
			Class<?> c = CrudfyUtils.isSupportedClass(f.getType());
			if(c.equals(Boolean.class)){
				result = new BooleanValueField(f, resolveBooleanValue(selectedValues));
			}else{ 
				result = new OpenValueField(f, resolveOneValue(selectedValues));
			}
		}
		return result;
	}
	
	
	private List<String> resolveSeletedValues(Field f, Object obj) {
		List<String> result = new ArrayList<>();
		try {
			Object value = f.get(obj);
			if(value instanceof Collection<?>){
				Collection<?> coll = (Collection<?>) value;
				for (Object o : coll) {
					 result.add(o.toString());
				}
			}else{
				if(value != null){
					result.add(value.toString());	
				}
				
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
//	private List<String> resolveMultipleValues(Field f, Object obj) {
//		
//	}
	private String resolveOneValue(List<String> selectedValues) {
		if(selectedValues.size() == 1){
			return selectedValues.get(0);
		}
		return null;
	}
	
	private boolean resolveBooleanValue(List<String> selectedValues) {
		String s = resolveOneValue(selectedValues);
		if(s != null){
			return Boolean.parseBoolean(s);
		}else{
			return false;
		}
	}

	private String resolveLabel(Field f){
		return f.getName();
	}
	
	
	
	
	
	
//	public boolean 
	
	
	

}
