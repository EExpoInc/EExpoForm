package eexpoforms;

import java.util.Arrays;
import java.util.List;


/***
 * {@link http://www.w3schools.com/tags/tag_input.asp}
 * Suporte a:  <br>
 * - private static final  
 * - campos com inputMask / outputMask pattern <br>
 * - um de um conjunto <br>
 * - subconjunto de um conjunto <br>
 * - inclusao de um novo elemento em um conjunto <br>
 * - validacao stateless (digito verificador) e statefull (existe no DB) <br>
 * - gravacao do upload numa pasta predeterminada <br>
 * - uso de um BeanForm extends Bean <br>
 * - Map<K,V> p mostrar label e marcar o valor em bg <br>
 * - List<V> qdo o label for igual valor <br>
 * - enum p conjunto <br>
 * - annotations p definir qual <br> 
 * 		eh o conjunto possivel de um campo <br>
 * 		um custom label <br>
 *  		
 * - convencao p pegar primeiro do getMyField(), myField(), public myField <br>
 * - convencao p pegar o grupo por annotation, getMyFieldAll(), myFieldAll() <br>
 * 
 * - 6230711075864576
 * - 20151112.1517.123456789
 * 
 * MVP 1.0:
 * - Valores unitario como texto, check (sem mascara de in out)
 * - Unidade de conjunto fechado (enum) ou aberto (myFieldAll() ou annotation) sera mostrado 
 * 			como radio (ate 10 elem), ou combobox
 * - Subconjunto sera mostrado uma lista de checkbox (http://stackoverflow.com/a/12586084/260925)
 * - booleano = check
 * - data (https://github.com/Eonasdan/bootstrap-datetimepicker e https://github.com/eternicode/bootstrap-datepicker)
 *   
 * 
 * 
 * 
 * @author Fulvius
 *
 */
public class FormFieldBase {
	public enum FormInputType{
		text, date, num, currency
	}
	
	public enum FormInputAspect{
		hidden, disable, normal
	}
	
	public enum FormInputDisplay{
		text, textarea, radio, check, password, file  
	}
	
	
	public String id;
	public FormInputType inputType;
	public String label;
	public String errMsg;
	public String hint;
	
	private List<String> values; 
	public List<String> allPossibleValues;
	public String inputPattern;
	public String outputPattern;
	private FormFieldCustomRender ffcr;
	
	 
	public FormFieldBase values(String... values){
		this.values = Arrays.asList(values);
		return this;
	}
	public String value(){
		return this.values.get(0);
	}
	
	public List<String> values(){
		return this.values;
	}
	
	
	public FormFieldBase FormFieldCustomRender(FormFieldCustomRender ffcr){
		this.ffcr = ffcr;
		this.ffcr.formField = this;
		return this;
	}

}
