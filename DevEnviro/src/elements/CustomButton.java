package elements;

import javafx.scene.control.Button;

public class CustomButton implements IElements {

	private String definition;
	private Button button;
	private String language;
	
	public CustomButton(String language) {
		setLanguage(language);
	}
	
	@Override
	public void draw() {
		switch(getLanguage()) {
		case "html":
			setDefinition("<button type=\"button\">Click Me!</button>");
			break;
		case "fx":
			Button newButton = new Button();
			setButton(newButton);
			break;
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
	public Button getButton() {
		return button;
	}
	public void setButton(Button button) {
		this.button = button;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

}
