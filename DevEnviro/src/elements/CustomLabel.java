package elements;
import javafx.scene.control.Label;

public class CustomLabel implements IElements {

	private String definition;
	private Label label;
	private String language;
	
	public CustomLabel(String language) {
		setLanguage(language);
	}
	
	@Override
	public void draw() {
		switch(getLanguage()) {
		case "html":
			setDefinition("<label for=\"male\">Male</label>");
			break;
		case "fx":
			Label newLabel = new Label();
			setLabel(newLabel);
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
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

}
