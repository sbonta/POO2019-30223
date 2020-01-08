package javasmmr.zoowsome.controllers;

import javasmmr.zoowsome.repositories.RepositoryHelper;
import javasmmr.zoowsome.views.AddFrame;
import javasmmr.zoowsome.views.ListFrame;
import javasmmr.zoowsome.views.MainMenuFrame;
import org.jetbrains.annotations.NotNull;

import javax.xml.stream.XMLStreamException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainMenuController extends AbstractController {
    private ArrayList<Object> items;
    private MainMenuFrame mainMenuFrame;

    public MainMenuController(Class<?> model, MainMenuFrame mainMenuFrame, @NotNull Boolean hasBackButton) {
        super(model, mainMenuFrame, hasBackButton);
        this.items = RepositoryHelper.importAll();
        this.mainMenuFrame = mainMenuFrame;
        mainMenuFrame.setAddButtonActionListener(new AddButtonActionListener());
        mainMenuFrame.setListButtonActionListener(new ListButtonActionListener());
        mainMenuFrame.setSaveAndExitButtonActionListener(new SaveAndExitButtonActionListener());
    }

    private class AddButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new AddController(getModel(),
                    new AddFrame(getModel(), "Add"),
                    true,
                    items);
        }
    }

    private class ListButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ListController(getModel(),
                    new ListFrame(getModel(), "List", items),
                    true
            );
        }
    }

    private class SaveAndExitButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                RepositoryHelper.exportAll(items);
                System.exit(0);
            } catch (FileNotFoundException | XMLStreamException ex) {
                mainMenuFrame.setErrorLabelText("Something went wrong please try again !");
            }
        }
    }
}
