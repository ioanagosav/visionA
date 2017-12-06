package ro.visionapp.di;

import com.google.inject.servlet.ServletModule;
import ro.visionapp.auth.AppengineAuth;
import ro.visionapp.auth.OAuth2Callback;

public class CustomServletModule extends ServletModule {

    @Override
    public void configureServlets() {
        //filter("/*").through(CORSResponseFilter.class);
        serve("/oauth2callback").with(OAuth2Callback.class);
        serve("/").with(AppengineAuth.class);
    }


}
