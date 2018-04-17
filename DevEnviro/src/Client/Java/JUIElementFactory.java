package Client.Java;

import Client.Java.JUIElement;
import Client.Java.JavaWriter;
import lib.Element.AbstractIElementFactory;
import lib.Element.ElementWriter;
import lib.Element.UIElement;

import javax.swing.*;

public class JUIElementFactory extends AbstractIElementFactory {

    @Override
    public UIElement create(String type) {
        switch (type) {
            case "JLabel":
                return new JUIElement(new JLabel());
            case "JButton":
                return new JUIElement(new JButton());
            case "JTextField":
                return new JUIElement(new JTextField());
            case "JCheckBox":
                return new JUIElement(new JCheckBox());
        }
        return null;
    }

    @Override
    public String[] getSupportedElements() {
        return new String[] { "JLabel", "JButton", "JTextField", "JCheckBox" };
    }

    @Override
    public ElementWriter getWriter() {
        return new JavaWriter();
    }
}
