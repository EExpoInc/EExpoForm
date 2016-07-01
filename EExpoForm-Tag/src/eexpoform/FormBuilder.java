package eexpoform;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import eexpocrud.CrudfyUtils;
import eexpoform.field.BooleanValueField;
import eexpoform.field.ChooseOneValueField;
import eexpoform.field.DateValueField;
import eexpoform.field.MultiValueField;
import eexpoform.field.OpenMultiValueField;
import eexpoform.field.OpenValueField;

public class FormBuilder <E>{
	
	
	public  FormBase createForm(E entity){
		List<FormFieldBase> formFieldList= new ArrayList<>();
		ArrayList<Field> fieldList = new ArrayList<>();
		ArrayList<Field> fieldResult = new ArrayList<>();
		Map<String, Field> name_FieldMap = new HashMap<>();		
//		ArrayList<String> fieldNameList = new ArrayList<>();
		fieldList.addAll(Arrays.asList(entity.getClass().getDeclaredFields()));
		
		
		

		for(Field f:fieldList){
			name_FieldMap.put(f.getName(), f);
			fieldResult.add(f);
		}

//		fieldList.addAll(Arrays.asList(entity.getClass().getFields()));
		fieldList  = new ArrayList<>(Arrays.asList(entity.getClass().getFields()));

		for(Field f:fieldList){
			if(!name_FieldMap.keySet().contains(f.getName())){
				name_FieldMap.put(f.getName(), f);	
				fieldResult.add(f);
			}
			
		}

		
		
//		fieldList = new ArrayList<>(name_FieldMap.values()); 
		for (Field f : fieldResult) {
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
	
	public FormFieldBase buildField(Field f, E entity){
//		FormFieldBase result = new FormFieldBase(f);
		f.setAccessible(true); 
		
		FormFieldBase result = resolveFieldType(f, entity);
		result.label = resolveLabel(f);
//		result.readOnly = resolveReadOnly(f);
		
		return result;
	}
	

//	private boolean resolveReadOnly(Field f) {
//		if(CrudfyUtils.isIdField(f)){
//			
//		}
//		return false;
//	}

	@SuppressWarnings("unchecked")
	private LinkedHashMap<Object, String> resolveAllValues(Field f, E entity) {
		String allValuesMethodName = f.getName()+"All";
		Method allValuesMethod;
		LinkedHashMap<Object, String> result;
		try { 
			allValuesMethod = entity.getClass().getMethod(allValuesMethodName);
			if(allValuesMethod!= null){
				Object _return = allValuesMethod.invoke(entity, (Object[])null);
				if(_return instanceof Map){
					result = (LinkedHashMap<Object,String>) _return;
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
			result = new LinkedHashMap<Object, String>();
			for (Object o : enums) {
				Enum<?> e = (Enum<?>) o;
				result.put(e, e.name());
			}
			return result;
		}
		
		return null; 
		
	}

	private FormFieldBase resolveFieldType(Field f, E entity) {
		FormFieldBase result;
		
		List<Object> selectedValues = this.resolveSeletedValues(f, entity);
		LinkedHashMap<Object, String> allValues =  this.resolveAllValues(f, entity);
		if ((allValues != null)) {
			if(Collection.class.isAssignableFrom(f.getType())){				
				result = new MultiValueField(f, allValues, selectedValues);	
			} else if(f.getType().isEnum()){ 
				result = new ChooseOneValueField(f, allValues, resolveOneValue(selectedValues));
			} else {
				result = new ChooseOneValueField(f, allValues, resolveOneValue(selectedValues)); 
			}
		}else {
			Class<?> c = CrudfyUtils.isSupportedClass(f.getType());
			if(Collection.class.isAssignableFrom(f.getType())){
				result = new OpenMultiValueField(f, selectedValues);
			}else if(c.equals(Boolean.class)){
				result = new BooleanValueField(f, resolveBooleanValue(selectedValues));
			}else if(c.equals(Date.class)){
				result = new DateValueField(f, resolveDateValue(selectedValues));
			}else{ 
				result = new OpenValueField(f, resolveOneValue(selectedValues));
			}
		}
		result.name = f.getName();
		return result;
	}
	
	
	private List<Object> resolveSeletedValues(Field f, E entity) {
		List<Object> result = new ArrayList<>();
		try {
			Object value = f.get(entity);
			if(value instanceof Collection<?>){
				Collection<?> coll = (Collection<?>) value;
				for (Object item : coll) {
					 result.add(item);
				}
			}else{
				if(value != null){
					result.add(value);	
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
	private Object resolveOneValue(List<Object> selectedValues) {
		if(selectedValues.size() == 1){
			return selectedValues.get(0);
		}
		return null;
	}
	private Date resolveDateValue(List<Object> selectedValues) {
		if(selectedValues.size() == 1){
			return (Date) selectedValues.get(0);
		}
		return null;
	}
	
	private boolean resolveBooleanValue(List<Object> selectedValues) {
		Object s = resolveOneValue(selectedValues);
		if(s != null){
//			System.out.println(s);
			return Boolean.parseBoolean(s.toString()+"");
		}else{
			return false;
		}
	}

	private String resolveLabel(Field f){
		return f.getName();
	}
	
	
	
	
	
	
//	public boolean 
	
	
	

}
