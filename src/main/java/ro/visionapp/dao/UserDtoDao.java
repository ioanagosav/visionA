package ro.visionapp.dao;


import ro.visionapp.entities.UserDto;

public interface UserDtoDao {

    void save(UserDto user);

    UserDto getUserById(String id);

}
