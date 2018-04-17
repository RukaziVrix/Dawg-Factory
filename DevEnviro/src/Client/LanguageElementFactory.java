package Client;

import Client.HTML.HTMLElementFactory;
import Client.Java.JUIElementFactory;
import lib.Element.AbstractIElementFactory;
import lib.Language.AbstractLanguageElementFactory;

public class LanguageElementFactory extends AbstractLanguageElementFactory {

    public AbstractIElementFactory create(String type) {
        switch (type) {
            case "Java":
                return new JUIElementFactory();
            case "HTML":
                return new HTMLElementFactory();
        }
        return null;
    }

    public String[] getLanguages() {
        return new String[] { "Java", "HTML" };
    }
}
