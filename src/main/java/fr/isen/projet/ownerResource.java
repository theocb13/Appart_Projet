package fr.isen.projet;

import fr.isen.projet.apartment.interfaces.models.apartmentModel;
import fr.isen.projet.apartment.interfaces.services.ownerService;
import fr.isen.projet.apartment.interfaces.models.ownerModel;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/owner")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ownerResource {
    @Inject
    private ownerService ownerService;

    @GET
    public List<ownerModel> getAllAppartements() { return ownerService.getAllProprio();
    }

    @GET
    @Path("/{uuid}")
    public Response getProprioById(@PathParam("uuid") String uuid) {
        ownerModel owner = ownerService.getProprioById(uuid);
        if (owner == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("owner non trouvée").build();
        }
        return Response.ok(owner).build();
    }

    @POST
    public Response addOwner(ownerModel owner) {
        ownerModel addOwner = ownerService.addProprio(owner);
        return Response.status(Response.Status.CREATED).entity(addOwner).build();
    }

    @DELETE
    @Path("/{uuid}")
    public Response deleteOwner(@PathParam("uuid") String uuid) {
        ownerService.removeProprio(uuid);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{uuid}")
    public Response updateAddress(@PathParam("uuid") String uuid, ownerModel updatedOwner) {
        ownerModel owner = ownerService.updateProprio(uuid, updatedOwner);
        if (owner == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("owner non trouvée").build();
        }
        return Response.ok(owner).build();
    }
}
