package com.klwork.example.ch02;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
@PreserveOnRefresh
public class NavigationtestUI extends UI {

    Navigator navigator;

    String loggedInUser;

    @Override
    public void init(VaadinRequest request) {
        // Create Navigator, make it control the ViewDisplay
        navigator = new Navigator(this, this);

        // Add some Views
        navigator.addView(MainView.NAME, new MainView(navigator)); // no fragment

        // #count will be a new instance each time we navigate to it, counts:
        navigator.addView(CountView.NAME, CountView.class);
        
        // #message adds a label with whatever it receives as a parameter
        navigator.addView(MessageView.NAME, new MessageView());

        // #secret works as #message, but you need to be logged in
        navigator.addView(SecretView.NAME, new SecretView());
        
        navigator.addView(LoginView.NAME, new LoginView(navigator, MainView.NAME));

        // we'll handle permissions with a listener here, you could also do
        // that in the View itself.
        //视图进行转变进行触发
        navigator.addViewChangeListener(new ViewChangeListener() {

            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {
                if (((NavigationtestUI)UI.getCurrent()).getLoggedInUser() == null) {
                    // Show to LoginView instead, pass intended view
                    String fragmentAndParameters = event.getViewName();
                    if (event.getParameters() != null) {
                        fragmentAndParameters += "/";
                        fragmentAndParameters += event.getParameters();
                    }
                    navigator.getDisplay().showView(new LoginView(navigator,
                            fragmentAndParameters));
                    return false;

                } else {
                    return true;
                }
            }

            @Override
            public void afterViewChange(ViewChangeEvent event) {

            }          
        });
    }

    public String getLoggedInUser(){
         return loggedInUser;
    } 

    public void setLoggedInUser(String user){
         loggedInUser = user;
   }
}
