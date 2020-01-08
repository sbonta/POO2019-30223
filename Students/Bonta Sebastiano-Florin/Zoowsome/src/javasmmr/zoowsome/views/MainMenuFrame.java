package javasmmr.zoowsome.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuFrame extends ZooFrame {

    private JButton addButton;
    private JButton listButton;
    private JButton saveAndExitButton;
    private JLabel errorLabel;

    public MainMenuFrame(Class<?> model, String title) {
        super(title);
        contentPanel.setLayout(new GridLayout(0, 3, 0, 0));
        JPanel panel = new JPanel();
        contentPanel.add(panel);
        JPanel panel1 = new JPanel();
        contentPanel.add(panel1);
        SpringLayout springLayout = new SpringLayout();
        panel1.setLayout(springLayout);

        addButton = new JButton("Add");
        springLayout.putConstraint(SpringLayout.NORTH, addButton, 65, SpringLayout.NORTH, panel1);
        springLayout.putConstraint(SpringLayout.WEST, addButton, 93, SpringLayout.WEST, panel1);
        panel1.add(addButton);

        listButton = new JButton("List");
        springLayout.putConstraint(SpringLayout.NORTH, listButton, 150, SpringLayout.NORTH, panel1);
        springLayout.putConstraint(SpringLayout.WEST, listButton, 94, SpringLayout.WEST, panel1);
        panel1.add(listButton);

        saveAndExitButton = new JButton("Save and Exit");
        springLayout.putConstraint(SpringLayout.NORTH, saveAndExitButton, 264, SpringLayout.NORTH, panel1);
        springLayout.putConstraint(SpringLayout.WEST, saveAndExitButton, 69, SpringLayout.WEST, panel1);
        panel1.add(saveAndExitButton);

        errorLabel = new JLabel("");
        springLayout.putConstraint(SpringLayout.SOUTH, errorLabel, -120, SpringLayout.SOUTH, panel1);
        springLayout.putConstraint(SpringLayout.WEST, errorLabel, 20, SpringLayout.WEST, panel1);
        panel1.add(errorLabel);

        JPanel panel2 = new JPanel();
        contentPanel.add(panel2);
        setVisible(true);
    }

    public void setErrorLabelText(String text) {
        errorLabel.setText(text);
    }

    public void setAddButtonActionListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void setListButtonActionListener(ActionListener actionListener) {
        listButton.addActionListener(actionListener);
    }

    public void setSaveAndExitButtonActionListener(ActionListener actionListener) {
        saveAndExitButton.addActionListener(actionListener);
    }
}
