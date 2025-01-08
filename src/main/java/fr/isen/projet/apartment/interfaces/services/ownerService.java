package fr.isen.projet.apartment.interfaces.services;

import java.util.List;
import fr.isen.projet.apartment.interfaces.models.ownerModel;

//begin of modifiable zone(Javadoc).......C/f6a5a4ed-38b6-401a-8793-4dfa66a0d293

//end of modifiable zone(Javadoc).........E/f6a5a4ed-38b6-401a-8793-4dfa66a0d293
public interface ownerService {
//begin of modifiable zone(Javadoc).......C/a364d82e-c006-44c0-ad75-622e51bfd10a

//end of modifiable zone(Javadoc).........E/a364d82e-c006-44c0-ad75-622e51bfd10a
    List<ownerModel> getAllProprio();

//begin of modifiable zone(Javadoc).......C/33e3c045-98cf-4a0d-aa3a-976ed782fa62

//end of modifiable zone(Javadoc).........E/33e3c045-98cf-4a0d-aa3a-976ed782fa62
    ownerModel getProprioById(final String uuid);

//begin of modifiable zone(Javadoc).......C/588cd973-2dbf-4f8e-8a9a-ed8fbf3a1792

//end of modifiable zone(Javadoc).........E/588cd973-2dbf-4f8e-8a9a-ed8fbf3a1792
    ownerModel addProprio(final ownerModel proprio);

//begin of modifiable zone(Javadoc).......C/35cb3232-48d6-4d0b-89a4-56fbf6c4ff85

//end of modifiable zone(Javadoc).........E/35cb3232-48d6-4d0b-89a4-56fbf6c4ff85
    void removeProprio(final String uuid);

//begin of modifiable zone(Javadoc).......C/bed2427a-1381-4498-8cd7-bfcd3342737f

//end of modifiable zone(Javadoc).........E/bed2427a-1381-4498-8cd7-bfcd3342737f
    ownerModel updateProprio(String uuid, ownerModel proprio);

}
