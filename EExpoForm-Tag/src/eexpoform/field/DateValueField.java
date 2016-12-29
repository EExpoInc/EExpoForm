package eexpoform.field;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;

import eexpocrud.CrudfyUtils;


public class DateValueField extends OpenMultiValueField{

	public boolean value = false;
	
	
	public DateValueField(Field originalBeanField, Object selectedValue) {
		super(originalBeanField, Arrays.asList(selectedValue));
	}

	public String formatedDate(){
		Date d = (Date) this.selectedValues.get(0);
		if(d == null){
			d = new Date(System.currentTimeMillis());
		}
		
//		System.out.println(CrudfyUtils.universalFullDateFormat.format(d));
		return CrudfyUtils.universalFullDateFormat.format(d);
		
//		return (new SimpleDateFormat(CrudfyUtils.DATE_FORMAT)).format(d);
	}
	
	public String selectedValue(){
		if(this.selectedValues.get(0) == null){
			return "";
		}else{
			return this.selectedValues.get(0).toString().trim();	
		}
		
	}

	

	
	
}
