package javasmmr.zoowsome.controllers;

import javasmmr.zoowsome.exceptions.InvalidInputException;
import javasmmr.zoowsome.validators.Validator;
import javasmmr.zoowsome.views.AddFrame;
import javasmmr.zoowsome.views.utilities.ConstructorHelper;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class AddController extends AbstractController {

    public AddController(Class<?> model, AddFrame addFrame, @NotNull Boolean hasBackButton, ArrayList<Object> items) {
        super(model, addFrame, hasBackButton);
        addFrame.setComboBoxItemListener(new ComboBoxItemListener(addFrame));
        addFrame.setAddButtonActionListener(new AddButtonActionListener(addFrame, items));
    }

    private static class ComboBoxItemListener implements ItemListener {
        private AddFrame addFrame;

        private ComboBoxItemListener(AddFrame addFrame) {
            this.addFrame = addFrame;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            addFrame.hideAllFields();
            addFrame.setViewableFields();
            addFrame.clearTextFields();
            addFrame.setErrorLabelText("");
        }
    }

    private static class AddButtonActionListener implements ActionListener {
        private AddFrame addFrame;
        private ArrayList<Object> items;

        private AddButtonActionListener(AddFrame addFrame, ArrayList<Object> items) {
            this.addFrame = addFrame;
            this.items = items;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object object = ConstructorHelper.createObject(addFrame.getSelectedClass(),
                        addFrame.getFields(),
                        addFrame.getValues());

                Validator.validateObject(object);
                Validator.validateExistingObject(object, items);
                items.add(object);
                addFrame.setErrorLabelText("Success");
                addFrame.clearTextFields();
            } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException |
                    InstantiationException | NoSuchMethodException ex) {
                addFrame.setErrorLabelText("Input data is incorrect, please try again !");
            } catch (InvalidInputException ex) {
                addFrame.setErrorLabelText(ex.getMessage());
            }
        }
    }
}
