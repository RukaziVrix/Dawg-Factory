package elements;


public class CustomFooter implements IElements{

	private String definition;
	private String language;
	
	public CustomFooter(String language) {
		setLanguage(language);
	}
	
	@Override
	public void draw() {
		switch(getLanguage()) {
		case "html":
			setDefinition("<footer>Alibaba was Here</footer>");
			break;
//		case "fx":
//			TextArea newTextArea = new TextArea();
//			setTextArea(newTextArea);
//			break;
		default:
			setDefinition("");
			break;
		}
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
