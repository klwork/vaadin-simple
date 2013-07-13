package com.klwork.example.urltest;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
@PreserveOnRefresh
public class NavigationtestUI extends UI {

    @Override
    public void init(VaadinRequest request) {
        // Create Navigator, make it control the ViewDisplay
        Navigator navigator = new Navigator(this, this);

        // Add some Views
        navigator.addView(MainView.NAME, new MainView()); // no fragment

        // #count will be a new instance each time we navigate to it, counts:
        //以为每次viewClass.newInstance();
        navigator.addView(CountView.NAME, CountView.class);

        // #message adds a label with whatever it receives as a parameter
        navigator.addView(MessageView.NAME, new MessageView());
    }
}

