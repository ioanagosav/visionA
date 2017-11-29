package ro.visionapp.dao;

import ro.visionapp.entities.Drawing;

public interface DrawingDao {

    void save(Drawing drawing);

    Drawing getByUser(String userId);

    Drawing getByName(String name);

}
