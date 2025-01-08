package fr.isen.projet.apartment.interfaces.services;

import java.util.List;
import fr.isen.projet.apartment.interfaces.models.availability;

//begin of modifiable zone(Javadoc).......C/d3e1f6e0-0064-4bc5-a8c6-08bbcae88c0c

//end of modifiable zone(Javadoc).........E/d3e1f6e0-0064-4bc5-a8c6-08bbcae88c0c
public interface availabilityService {
//begin of modifiable zone(Javadoc).......C/8d48ef7a-38e2-466a-9f8a-a3d11a18f941

//end of modifiable zone(Javadoc).........E/8d48ef7a-38e2-466a-9f8a-a3d11a18f941
    List<availability> getAllDispo();

//begin of modifiable zone(Javadoc).......C/3d2f8e2c-c7bd-412d-a1fe-78d9702dfc6c

//end of modifiable zone(Javadoc).........E/3d2f8e2c-c7bd-412d-a1fe-78d9702dfc6c
    availability getDispoById(final int id);

//begin of modifiable zone(Javadoc).......C/316f1471-1aff-4c63-8390-db7d5b1266e6

//end of modifiable zone(Javadoc).........E/316f1471-1aff-4c63-8390-db7d5b1266e6
    availability addDispo(final availability dispo);

//begin of modifiable zone(Javadoc).......C/c81a277b-03a9-4bdc-ba4f-23b9f57fcefa

//end of modifiable zone(Javadoc).........E/c81a277b-03a9-4bdc-ba4f-23b9f57fcefa
    boolean removeDispo(final availability dispoId);

//begin of modifiable zone(Javadoc).......C/45750a8e-4607-4bf7-a190-019980ed28d4

//end of modifiable zone(Javadoc).........E/45750a8e-4607-4bf7-a190-019980ed28d4
    availability updateDispo(final availability newDispo);

}
