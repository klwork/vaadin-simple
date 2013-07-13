package com.klwork.example.ch03;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
public class NavigationtestUI extends UI {

    @Override
    public void init(VaadinRequest request) {
        // Create Navigator, make it control the ViewDisplay
         Navigator navigator = new Navigator(this, this);

        // no fragment for main view
        navigator.addView(MainView.NAME, new MainView(navigator));

        // #settings
        navigator.addView(SettingsView.NAME, new SettingsView(navigator));
    }
}