package elements;

import javafx.scene.control.TextArea;

public class CustomTextArea implements IElements {

	private String definition;
	private TextArea textArea;
	private String language;
	
	public CustomTextArea(String language) {
		setLanguage(language);
	}
	
	
	@Override
	public void draw() {
		switch(getLanguage()) {
		case "html":
			setDefinition("<textarea rows=\"4\" cols=\"50\">\r\n" + 
					"Place holder string for the text area. #TeamSharena \r\n" + 
					"</textarea>");
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

	public TextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(TextArea textArea) {
		this.textArea = textArea;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
