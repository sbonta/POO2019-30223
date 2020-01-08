package javasmmr.zoowsome.controllers;

import javasmmr.zoowsome.views.ZooFrame;
import javasmmr.zoowsome.views.utilities.FrameStack;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbstractController {

    protected ZooFrame zooFrame;
    private Class<?> model;

    public AbstractController(Class<?> model, ZooFrame zooFrame, @NotNull Boolean hasBackButton) {
        this.model = model;
        this.zooFrame = zooFrame;
        if (hasBackButton) {
            zooFrame.setBackButtonActionListener(new BackButtonListener());
        }
    }

    public Class<?> getModel() {
        return model;
    }

    private static class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameStack.getInstance().pop();
        }
    }
}
