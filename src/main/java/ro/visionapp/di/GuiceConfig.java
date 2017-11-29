package ro.visionapp.di;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.googlecode.objectify.ObjectifyService;
import com.squarespace.jersey2.guice.JerseyGuiceModule;
import com.squarespace.jersey2.guice.JerseyGuiceUtils;

public class GuiceConfig extends GuiceServletContextListener {

    static {

        //ObjectifyService.register(Order.class);
    }

    @Override
    protected Injector getInjector() {
        Injector injector = Guice.createInjector(
                new JerseyGuiceModule("__HK2_Generated_0"),
                new CustomServletModule(),
                new ApplicationModule()
        );
        JerseyGuiceUtils.install(injector);

        return injector;
    }
}
