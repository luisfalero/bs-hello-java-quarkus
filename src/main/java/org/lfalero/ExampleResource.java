package org.lfalero;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/bs")
public class ExampleResource {

    @ConfigProperty(name="system.user1")
    private String user1;

    @ConfigProperty(name="system.user2")
    private String user2;

    @ConfigProperty(name="system.password1")
    private String password1;

    @ConfigProperty(name="system.password2")
    private String password2;

    @GET
    @Path("v0/environment")
    @Produces(MediaType.TEXT_PLAIN)
    public String environmentV0() {
        log.info("Endpoint = [{}]:", "/v0/environment");
        log.info("Message = [{}, {}, {}, {}]:", new Object[] {user1, user2, password1, password2});
        return user1.concat(" - ").concat(user1).concat(" - ")
                .concat(password1).concat(" - ").concat(password2);
    }

    @GET
    @Path("v1/environment")
    @Produces(MediaType.APPLICATION_JSON)
    public Response environmentV1() {
        log.info("Endpoint = [{}]:", "/v1/environment");
        log.info("Message = [{}, {}, {}, {}]:", new Object[] {user1, user2, password1, password2});
        return Response.ok(new BsEnvironmentResponseDto(user1, user2, password1, password2, "v1")).build();
    }

    @GET
    @Path("v2/environment")
    @Produces(MediaType.APPLICATION_JSON)
    public BsEnvironmentResponseDto environmentV2() {
        log.info("Endpoint = [{}]:", "/v2/environment");
        log.info("Message = [{}, {}, {}, {}]:", new Object[] {user1, user2, password1, password2});
        return new BsEnvironmentResponseDto(user1, user2, password1, password2, "v2");
    }
}