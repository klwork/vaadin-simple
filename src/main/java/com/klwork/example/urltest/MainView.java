package com.klwork.example.urltest;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class MainView extends Panel implements View {

    public static final String NAME = "";

    public MainView() {

        VerticalLayout layout = new VerticalLayout();

        Link lnk = new Link("Count", new ExternalResource("#!" + CountView.NAME));
        layout.addComponent(lnk);

        lnk = new Link("Message: Hello", new ExternalResource("#!"
                + MessageView.NAME + "/Hello"));
        layout.addComponent(lnk);

        lnk = new Link("Message: Bye", new ExternalResource("#!"
                + MessageView.NAME + "/Bye/Goodbye"));
        layout.addComponent(lnk);
        setContent(layout);
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }
}

