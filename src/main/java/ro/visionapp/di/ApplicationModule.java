package ro.visionapp.di;

import com.google.inject.AbstractModule;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {

        //bind(OrderDAO.class).to(ro.foodApp.dao.impl.objectify.OrderDAOImpl.class);
    }
}