package lib.Language;

import lib.Element.AbstractIElementFactory;

public abstract class AbstractLanguageElementFactory {
    public abstract AbstractIElementFactory create(String type);
    public abstract String[] getLanguages();
}
