package lib.GUI;

import lib.Element.AbstractIElementFactory;
import lib.Element.ElementWriter;
import lib.Element.UIElement;
import lib.GUI.Canvas;
import lib.GUI.Sidepanel;
import lib.Language.AbstractLanguageElementFactory;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Application extends JFrame {

    public static AbstractLanguageElementFactory languageFactory;
    protected static AbstractIElementFactory elementFactory;

    protected Canvas m_canvas;
    protected JComponent m_sidepanel;
    protected JComponent m_textPanel;
    protected JLabel label;

    public Application(AbstractLanguageElementFactory factory) {
        languageFactory = factory;

        String defaultLanguage = factory.getLanguages()[0];
        elementFactory = languageFactory.create(defaultLanguage);
    }

    public static void setElementFactory(AbstractIElementFactory factory) {
        elementFactory = factory;
    }

    public void start() {
        createAndShowGUI();
    }

    public Canvas getCanvas() {
        return m_canvas;
    }

    protected void updateText(String text) {
        m_canvas.getSelection().setText(text);
        m_canvas.repaint();
    }

    protected void build() {
        ArrayList<UIElement> elements = m_canvas.getUIElements();
        ElementWriter writer = elementFactory.getWriter();
        elements.forEach(e -> {
            writer.addLine(e.generateSourceCode());
        });
        writer.writeFile(writer.getFileName() + writer.getExtension());
    }

    protected void runButton() {
        ElementWriter writer = elementFactory.getWriter();
        writer.run();
    }

    public void addElement(String type) {
        UIElement element = elementFactory.create(type);
        if (element != null) {
            m_canvas.addUIElement(element);
            System.out.println("Added element: " + element);
        }
    }

    protected void createAndShowGUI() {
        JComponent mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        m_canvas = new Canvas();
        mainPanel.add(m_canvas, BorderLayout.CENTER);

        m_sidepanel = new Sidepanel(this);
        mainPanel.add(m_sidepanel, BorderLayout.WEST);

        m_textPanel = createTextField();
        mainPanel.add(m_textPanel, BorderLayout.NORTH);

        add(mainPanel);

        setSize(600, 600);
        setLocationRelativeTo(null);
        setTitle("GUI for DawgFactory by Alfonso & Esteban & Mason");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    protected JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                m_canvas.updateSelectionText(textField.getText());
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                m_canvas.updateSelectionText(textField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                m_canvas.getSelection().setText(textField.getText());
            }
        });
        return textField;
    }
}
