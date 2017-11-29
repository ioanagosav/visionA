package ro.visionapp.di;

import com.google.inject.AbstractModule;
import ro.visionapp.dao.DrawingDao;
import ro.visionapp.dao.UserDtoDao;
import ro.visionapp.dao.impl.DrawingDaoImpl;
import ro.visionapp.dao.impl.UserDtoDaoImpl;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserDtoDao.class).to(UserDtoDaoImpl.class);
        bind(DrawingDao.class).to(DrawingDaoImpl.class);
    }
}