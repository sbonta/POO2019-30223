package javasmmr.zoowsome.views;

import javasmmr.zoowsome.services.constants.Constants;
import javasmmr.zoowsome.services.constants.ClassFinder;
import javasmmr.zoowsome.views.utilities.ReflectionHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class AddFrame extends ZooFrame {
    private JComboBox<String> comboBox;
    private JLabel[] labels;
    private JTextField[] textFields;
    private JButton addButton;
    private JLabel errorLabel;
    private ArrayList<String> classes;
    private Integer numberOfFields;


    public AddFrame(Class<?> model, String title) {
        super(title);
        this.classes = ClassFinder.getAllClasses(model);
        this.labels = new JLabel[Constants.MAX_NUMBER_OF_FIELDS];
        this.textFields = new JTextField[Constants.MAX_NUMBER_OF_FIELDS];
        this.numberOfFields = 0;

        contentPanel.setLayout(new GridLayout(0, 3, 0, 0));

        JPanel panel = new JPanel();
        contentPanel.add(panel);

        JPanel panel1 = new JPanel();
        contentPanel.add(panel1);
        SpringLayout springLayout = new SpringLayout();
        panel1.setLayout(springLayout);

        ArrayList<String> models = ClassFinder.getAllModels(model);
        String[] allModels = models.toArray(new String[0]);
        comboBox = new JComboBox<>(allModels);
        comboBox.setSelectedIndex(0);
        springLayout.putConstraint(SpringLayout.NORTH, comboBox, 65, SpringLayout.NORTH, panel1);
        springLayout.putConstraint(SpringLayout.WEST, comboBox, 93, SpringLayout.WEST, panel1);
        panel1.add(comboBox);

        for (int i = 0; i < Constants.MAX_NUMBER_OF_FIELDS; i++) {
            labels[i] = new JLabel("" + i);
            springLayout.putConstraint(SpringLayout.NORTH, labels[i], 94 + i * 30, SpringLayout.NORTH, panel1);
            springLayout.putConstraint(SpringLayout.WEST, labels[i], 0, SpringLayout.WEST, panel1);
            panel1.add(labels[i]);
            labels[i].setVisible(false);

            textFields[i] = new JTextField(10);
            springLayout.putConstraint(SpringLayout.NORTH, textFields[i], 94 + i * 30, SpringLayout.NORTH, panel1);
            springLayout.putConstraint(SpringLayout.WEST, textFields[i], 150, SpringLayout.WEST, panel1);
            panel1.add(textFields[i]);
            textFields[i].setVisible(false);
        }

        setViewableFields();

        addButton = new JButton("Add");
        springLayout.putConstraint(SpringLayout.SOUTH, addButton, -70, SpringLayout.SOUTH, panel1);
        springLayout.putConstraint(SpringLayout.WEST, addButton, 93, SpringLayout.WEST, panel1);
        panel1.add(addButton);

        errorLabel = new JLabel("");
        springLayout.putConstraint(SpringLayout.SOUTH, errorLabel, -120, SpringLayout.SOUTH, panel1);
        springLayout.putConstraint(SpringLayout.WEST, errorLabel, 20, SpringLayout.WEST, panel1);
        panel1.add(errorLabel);

        JPanel panel2 = new JPanel();
        contentPanel.add(panel2);
        setVisible(true);
    }

    public void setComboBoxItemListener(ItemListener itemListener) {
        comboBox.addItemListener(itemListener);
    }

    public void setAddButtonActionListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void setViewableFields() {
        ArrayList<String> fields = null;
        try {
            fields = ReflectionHelper.getAllFields(Class.forName(classes.get(comboBox.getSelectedIndex())));
        } catch (ClassNotFoundException ignored) {
        }

        assert fields != null;
        for (int i = 0; i < fields.size(); i++) {
            labels[i].setText(fields.get(i));
            labels[i].setVisible(true);
            textFields[i].setVisible(true);
        }
        numberOfFields = fields.size();
    }

    public void hideAllFields() {
        for (int i = 0; i < Constants.MAX_NUMBER_OF_FIELDS; i++) {
            labels[i].setVisible(false);
            textFields[i].setVisible(false);
        }
    }

    public String getSelectedClass() {
        return classes.get(comboBox.getSelectedIndex());
    }

    public ArrayList<String> getFields() {
        ArrayList<String> fields = new ArrayList<>();

        for (int i = 0; i < numberOfFields; i++) {
            fields.add(labels[i].getText());
        }

        return fields;
    }

    public void clearTextFields() {
        for (int i = 0; i < Constants.MAX_NUMBER_OF_FIELDS; i++) {
            textFields[i].setText("");
        }
    }

    public void setErrorLabelText(String text) {
        errorLabel.setText(text);
    }

    public ArrayList<String> getValues() {
        ArrayList<String> values = new ArrayList<>();

        for (int i = 0; i < numberOfFields; i++) {
            values.add(textFields[i].getText());
        }

        return values;
    }
}
