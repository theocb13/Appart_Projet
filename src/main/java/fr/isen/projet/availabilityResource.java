package fr.isen.projet;

import fr.isen.projet.apartment.interfaces.models.apartmentModel;
import fr.isen.projet.apartment.interfaces.services.apartmentService;
import fr.isen.projet.apartment.interfaces.services.availabilityService;
import fr.isen.projet.apartment.interfaces.models.availabilityModel;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/availability")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class availabilityResource {
    @Inject
    private availabilityService availabilityService;

    @GET
    public List<availabilityModel> getAllDispo() { return availabilityService.getAllDispo();
    }

    @GET
    @Path("/{id}")
    public Response getApartmentById(@PathParam("id") int id) {
        availabilityModel availability = availabilityService.getDispoById(id);
        if (availability == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("avaiability non trouvée").build();
        }
        return Response.ok(availability).build();
    }

    @POST
    public Response addAvailability(availabilityModel dispo) {
        availabilityModel createdAvailability = availabilityService.addDispo(dispo);
        return Response.status(Response.Status.CREATED).entity(createdAvailability).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAvailability(@PathParam("id") int id) {
        availabilityService.removeDispo(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAvailability(@PathParam("id") int id, availabilityModel updatedAvailability) {
        availabilityModel availability = availabilityService.updateDispo(id, updatedAvailability);
        if (availability == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("availability non trouvée").build();
        }
        return Response.ok(availability).build();
    }
}
