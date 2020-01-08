package javasmmr.zoowsome.views;

import javasmmr.zoowsome.services.constants.ClassFinder;
import javasmmr.zoowsome.views.utilities.ObjectSelector;
import javasmmr.zoowsome.views.utilities.ReflectionHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class ListFrame extends ZooFrame {
    private JComboBox<String> comboBox;
    private JTable table;
    private ArrayList<String> classes;
    private ArrayList<Object> items;

    public ListFrame(Class<?> model, String title, ArrayList<Object> items) {
        super(title);
        this.classes = ClassFinder.getAllClasses(model);
        this.items = items;

        setSize(1200, 800);
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

        table = new JTable(new DefaultTableModel());
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 120, SpringLayout.NORTH, panel1);
        springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, panel1);
        panel1.add(scrollPane);

        setTableContent(classes.get(0));

        JPanel panel2 = new JPanel();
        contentPanel.add(panel2);
        setVisible(true);
    }

    public void setComboBoxItemListener(ItemListener itemListener) {
        comboBox.addItemListener(itemListener);
    }

    public void setTableContent(String className) {
        try {
            ArrayList<String> fields = ReflectionHelper.getAllFields(Class.forName(className));
            ArrayList<Object> selectedItems = ObjectSelector.selectObjects(className, items);
            DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
            defaultTableModel.setColumnCount(0);
            defaultTableModel.setRowCount(0);

            for (String field : fields) {
                defaultTableModel.addColumn(field);
            }

            for (Object object : selectedItems) {
                String[] data = ObjectSelector.getFieldValues(object);
                defaultTableModel.addRow(data);
            }

            defaultTableModel.fireTableDataChanged();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getSelectedClass() {
        return classes.get(comboBox.getSelectedIndex());
    }
}
