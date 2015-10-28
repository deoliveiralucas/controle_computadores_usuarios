package br.managecomputer.ws;

import br.managecomputer.dao.ResponsibleDao;
import br.managecomputer.model.Responsible;
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

@Path("responsible")
public class ResposibleResource {

    @Context
    private UriInfo context;
    private ResponsibleDao dao;

    /**
     * Creates a new instance of UsuarioResource
     */
    public ResposibleResource() {
    }

    /**
     * Retrieves representation of an instance of br.unisal.ws.UsuarioResource
     * @return an instance of br.managecomputer.model.Responsible
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponsible() {
        GenericEntity<List<Responsible>> responsibles = 
                new GenericEntity<List<Responsible>>(this.getDao().getAll()){};
        
        return Response.ok(responsibles).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getResponsible(@PathParam("id") String id) {
        Responsible r = new Responsible();
        r.setResponsibleId(Integer.parseInt(id));
        
        return Response.ok(getDao().getById(r)).build();
    }
    
    
    /**
     * DELETE method for deleting an instance of UsuarioResource     * 
     * @param id
     * @return message of deleted usuario with error or not
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteResponsible(@PathParam("id") String id) {
        Responsible r = new Responsible();
        r.setResponsibleId(Integer.parseInt(id));        
        getDao().remove(r);
        String msg = "{\"msg\":\"Exclusão realizada com sucesso!\"}";
        return Response.ok(msg).build();
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateResponsible(Responsible r, @PathParam("id") String id) {
        r.setResponsibleId(Integer.parseInt(id));
        getDao().update(r);
        String msg = "{\"msg\":\"Atualização realizada com sucesso!\"}";
        return Response.ok(msg).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUsuario(Responsible r) {        
        getDao().insert(r);
        String msg = "{\"msg\":\"Inserção realizada com sucesso!\"}";
        
        return Response.ok(msg).build();
    }
    
    /**
     * PUT method for updating or creating an instance of UsuarioResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    public void putJson(Responsible content) {
    }
    
    public ResponsibleDao getDao() {
        if (this.dao == null) {
            this.dao = new ResponsibleDao();
        }
        
        return this.dao;
    }
}
