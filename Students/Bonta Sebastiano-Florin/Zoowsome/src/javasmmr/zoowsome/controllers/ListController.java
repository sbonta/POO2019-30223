package javasmmr.zoowsome.controllers;

import javasmmr.zoowsome.views.ListFrame;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ListController extends AbstractController {

    public ListController(Class<?> model, ListFrame listFrame, @NotNull Boolean hasBackButton) {
        super(model, listFrame, hasBackButton);
        listFrame.setComboBoxItemListener(new ComboBoxItemListener(listFrame));
    }

    private static class ComboBoxItemListener implements ItemListener {
        private ListFrame listFrame;

        private ComboBoxItemListener(ListFrame listFrame) {
            this.listFrame = listFrame;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            listFrame.setTableContent(listFrame.getSelectedClass());
        }
    }
}
