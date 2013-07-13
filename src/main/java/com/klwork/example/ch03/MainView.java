package com.klwork.example.ch03;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class MainView extends Panel implements View {

    public static final String NAME = "";

    public MainView(final Navigator navigator) {
    	VerticalLayout layout = new VerticalLayout();
        Link lnk = new Link("Settings", new ExternalResource("#!"
                + SettingsView.NAME));
        layout.addComponent(lnk);
        setContent(layout);
    }
   
    @Override
    public void enter(ViewChangeEvent event) {
              
    }
}