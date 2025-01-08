package fr.isen.projet;

import fr.isen.projet.apartment.interfaces.services.apartmentService;
import fr.isen.projet.apartment.implement.apartmentServiceImpl;
import fr.isen.projet.apartment.interfaces.models.apartmentModel;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/apartment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class apartmentResource {
    @Inject
    private apartmentService apartmentService;

    @GET
    public List<apartmentModel> getAllAppartements() { return apartmentService.getAllAppartements();
    }

    @GET
    @Path("/{id}")
    public Response getAddressById(@PathParam("id") String id) {
        apartmentModel address = apartmentService.getAppartementById(id);
        if (address == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Adresse non trouvée").build();
        }
        return Response.ok(address).build();
    }
}
