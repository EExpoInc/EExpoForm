package eexpoforms;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;
import java.util.Set;

public class FormBase {

	public String action;
	public Charset encode = StandardCharsets.UTF_8;
	public Set<FormFieldBase> id_FieldMap = new LinkedHashSet<>();
	
	
}
