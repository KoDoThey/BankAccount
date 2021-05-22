
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class JerseyApplication {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/test")
    public Response verify(@QueryParam("name") String id) {

        String result = "Rest Test Services successfully started";
        System.out.println(result);
        return Response.status(200).entity(result).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response index(String content) {
        String result = "Rest Test Services successfully started";
        System.out.println(result);
        return Response.status(200).entity(result).build();
    }
}

