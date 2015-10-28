package br.managecomputer.ws;

import br.managecomputer.dao.ComputerUserDao;
import br.managecomputer.model.ComputerUser;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("computer-user")
public class ComputerUserResource {

    @Context
    private UriInfo context;
    private ComputerUserDao dao;

    /**
     * Creates a new instance of PessoaResource
     */
    public ComputerUserResource() {
    }

    /**
     * Retrieves representation of an instance of br.unisal.ws.PessoaResource
     * @return an instance of br.unisal.model.Pessoa
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComputerUser() {
        GenericEntity<List<ComputerUser>> computersUser = 
                new GenericEntity<List<ComputerUser>>(this.getDao().getAll()){};
        
        return Response
            .ok(computersUser)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
            .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getComputerUser(@PathParam("id") String id) {
        ComputerUser c = new ComputerUser();
        c.setUserId(Integer.parseInt(id));
        
        return Response
            .ok(getDao().getById(c))
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
            .build();
    }
    
    
    /**
     * DELETE method for deleting an instance of PessoaResource     * 
     * @param id
     * @return message of deleted pessoa with error or not
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteComputerUser(@PathParam("id") String id) {
        ComputerUser c = new ComputerUser();
        c.setUserId(Integer.parseInt(id));        
        getDao().remove(c);
        String msg = "{\"msg\":\"Exclusão realizada com sucesso!\"}";
        
        return Response
            .ok(msg)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
            .build();
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateComputerUser(ComputerUser c, @PathParam("id") String id) {
        c.setUserId(Integer.parseInt(id));
        getDao().update(c);
        String msg = "{\"msg\":\"Atualização realizada com sucesso!\"}";
        
        return Response
            .ok(msg)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
            .build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createComputerUser(ComputerUser c) {        
        getDao().insert(c);
        String msg = "{\"msg\":\"Inserção realizada com sucesso!\"}";
        
        return Response
            .ok(msg)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
            .build();
    }
    
    /**
     * PUT method for updating or creating an instance of PessoaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    public void putJson(ComputerUser content) {
    }
    
    public ComputerUserDao getDao() {
        if (this.dao == null) {
            this.dao = new ComputerUserDao();
        }
        
        return this.dao;
    }
}
