package ro.visionapp.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("/user")
public class LoggedUserService {

    private static final Logger LOG = Logger.getLogger(LoggedUserService.class.getName());

    @POST
    @Path("/save")
    //@Consumes(MediaType.APPLICATION_JSON)
    public void saveUser() {
        //get logged in user using userService, put it in UserDTo, save it with userdao

    }

}
