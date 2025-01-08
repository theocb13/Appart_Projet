package fr.isen.projet;

import fr.isen.projet.apartment.interfaces.services.apartmentService;
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
    public Response getApartmentById(@PathParam("id") String id) {
        apartmentModel address = apartmentService.getAppartementById(id);
        if (address == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Adresse non trouvée").build();
        }
        return Response.ok(address).build();
    }

    @POST
    public Response addApartment(apartmentModel apartment) {
        apartmentModel createdApartment = apartmentService.addAppartement(apartment);
        return Response.status(Response.Status.CREATED).entity(createdApartment).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAddress(@PathParam("id") String id) {
        apartmentService.removeAppartement(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAddress(@PathParam("id") String id, apartmentModel updatedApartment) {
        apartmentModel apartment = apartmentService.updateApartment(id, updatedApartment);
        if (apartment == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Adresse non trouvée").build();
        }
        return Response.ok(apartment).build();
    }
}
