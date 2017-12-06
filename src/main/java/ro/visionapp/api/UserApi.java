package ro.visionapp.api;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("/user")
public class UserApi {

    private static final Logger LOG = Logger.getLogger(UserApi.class.getName());

    // private

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public String registerUser() {
        //get logged in user using userService, put it in UserDTo, save it with userdao
        //UserServiceFactory userServiceFactory
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();

        return user.getNickname();

    }

    @GET
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User getLoggedInUser() {
        //get logged in user using userService, put it in UserDTo, save it with userdao
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();

        return user;
    }

}
