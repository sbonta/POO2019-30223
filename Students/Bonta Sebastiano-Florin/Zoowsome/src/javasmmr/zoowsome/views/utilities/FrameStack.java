package javasmmr.zoowsome.views.utilities;

import javasmmr.zoowsome.views.ZooFrame;

import java.util.ArrayList;

public class FrameStack {

    private static FrameStack instance;
    private ArrayList<ZooFrame> stack;

    private FrameStack() {
        stack = new ArrayList<>();
    }

    public static FrameStack getInstance() {
        if (null == instance) {
            instance = new FrameStack();
        }
        return instance;
    }

    public ZooFrame peek() {
        return stack.get(0);
    }

    public void push(ZooFrame zooFrame) {
        if (!stack.isEmpty()) {
            peek().setVisible(false);
        }
        zooFrame.setVisible(true);
        stack.add(0, zooFrame);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            peek().dispose();
            stack.remove(0);
            if (!stack.isEmpty()) {
                peek().setVisible(true);
            }
        }
    }
}
