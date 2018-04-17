package lib.Element;

public abstract class AbstractIElementFactory {

    public abstract UIElement create(String type);

    public abstract String[] getSupportedElements();

    public abstract ElementWriter getWriter();

}
