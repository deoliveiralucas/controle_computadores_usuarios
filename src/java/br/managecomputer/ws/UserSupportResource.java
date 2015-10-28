package br.managecomputer.ws;

import br.managecomputer.dao.UserSupportDao;
import br.managecomputer.model.ComputerUser;
import br.managecomputer.model.UserSupport;
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

@Path("user-support")
public class UserSupportResource {

    @Context
    private UriInfo context;
    private UserSupportDao dao;

    /**
     * Creates a new instance of PessoaResource
     */
    public UserSupportResource() {
    }

    /**
     * Retrieves representation of an instance of br.unisal.ws.PessoaResource
     * @return an instance of br.unisal.model.Pessoa
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserSupport() {
        GenericEntity<List<UserSupport>> userSupport = 
                new GenericEntity<List<UserSupport>>(this.getDao().getAll()){};
        
        return Response
            .ok(userSupport)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
            .build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/open")
    public Response getUserSupportOpen() {
        GenericEntity<List<UserSupport>> userSupport = 
                new GenericEntity<List<UserSupport>>(this.getDao().getAllOpen()){};
        
        return Response
            .ok(userSupport)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
            .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getUserSupport(@PathParam("id") String id) {
        UserSupport us = new UserSupport();
        us.setSupportId(Integer.parseInt(id));
        
        return Response
            .ok(getDao().getById(us))
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
    public Response deleteUserSupport(@PathParam("id") String id) {
        UserSupport us = new UserSupport();
        us.setSupportId(Integer.parseInt(id));
        
        getDao().remove(us);
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
    public Response updateUserSupport(UserSupport us, @PathParam("id") String id) {
        us.setSupportId(Integer.parseInt(id));
        
        getDao().update(us);
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
    public Response createUserSupport(UserSupport us) {        
        getDao().insert(us);
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
    
    public UserSupportDao getDao() {
        if (this.dao == null) {
            this.dao = new UserSupportDao();
        }
        
        return this.dao;
    }
}
