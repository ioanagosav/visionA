package ro.visionapp.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/drawing")
public class DrawingService {


    @POST
    @Path("/save")
    //@Consumes(MediaType.APPLICATION_JSON)
    public void saveDrawing() {
        //get logged in user using userService, put it in UserDTo, save it with userdao

    }

}
