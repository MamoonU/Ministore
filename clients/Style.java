package clients;

import javax.swing.*;
import java.awt.*;

public class Style {

    public static final Font TITLE_FONT = new Font("", Font.BOLD, 12);


    public static final Color BACKGROUND_COLOR = new Color(172, 172, 172);
    public static final Color FIELD_COLOR = new Color(110, 110, 110);
    public static final Color TEXT_COLOR = new Color(0, 0, 0);
    public static final Color BUTTON_COLOR = new Color(50, 50, 50);
    public static final Color BUTTON_TEXT_COLOR = new Color(255, 255, 255);

    public static void stylePanel(JPanel panel) {
        panel.setBackground(BACKGROUND_COLOR);
    }

    public static void styleButton(JButton button) {
        button.setBackground(BUTTON_COLOR);
        button.setForeground(BUTTON_TEXT_COLOR);
        button.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    }

    public static void styleTextField(JTextField field) {
        field.setBackground(FIELD_COLOR);
        field.setForeground(BUTTON_TEXT_COLOR);

    }










}

