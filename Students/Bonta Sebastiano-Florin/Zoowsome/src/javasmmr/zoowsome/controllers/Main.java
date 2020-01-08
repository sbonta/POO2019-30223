package javasmmr.zoowsome.controllers;

import javasmmr.zoowsome.views.MainMenuFrame;

public class Main {
    public static void main(String[] args) {
        try {
            new MainMenuController(Class.forName("javasmmr.zoowsome.models.interfaces.XML_Parsable"),
                    new MainMenuFrame(Class.forName("javasmmr.zoowsome.models.interfaces.XML_Parsable"),
                            "Main menu"),
                    false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
