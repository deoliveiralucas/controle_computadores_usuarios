package br.managecomputer.ws;

import br.managecomputer.dao.ComputerDao;
import br.managecomputer.model.Computer;
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

@Path("computer")
public class ComputerResource {

    @Context
    private UriInfo context;
    private ComputerDao dao;

    /**
     * Creates a new instance of PessoaResource
     */
    public ComputerResource() {
    }

    /**
     * Retrieves representation of an instance of br.unisal.ws.PessoaResource
     * @return an instance of br.unisal.model.Pessoa
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComputer() {
        GenericEntity<List<Computer>> computers = 
                new GenericEntity<List<Computer>>(this.getDao().getAll()){};
        
        return Response
            .ok(computers)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With")
            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD")
            .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getComputer(@PathParam("id") String id) {
        Computer c = new Computer();
        c.setComputerId(Integer.parseInt(id));
        
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
    public Response deleteComputer(@PathParam("id") String id) {
        Computer c = new Computer();
        c.setComputerId(Integer.parseInt(id));        
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
    public Response updateComputer(Computer c, @PathParam("id") String id) {
        c.setComputerId(Integer.parseInt(id));
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
    public Response createComputer(Computer c) {        
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
    public void putJson(Computer content) {
    }
    
    public ComputerDao getDao() {
        if (this.dao == null) {
            this.dao = new ComputerDao();
        }
        
        return this.dao;
    }
}
