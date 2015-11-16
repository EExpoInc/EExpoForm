package eexpoform;


public abstract class  FormFieldCustomRender {
	protected FormFieldBase formField;
	public String submitBtnLabel = "Confirm";
	public String cancelBtnLabel = "Cancel";
	
	public abstract String render();
	
	
}
