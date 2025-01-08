package fr.isen.projet.apartment.interfaces.services;

import java.util.List;
import fr.isen.projet.apartment.interfaces.models.apartment;

//begin of modifiable zone(Javadoc).......C/86fb5c16-5ad6-4148-9300-a566fdad63cc

//end of modifiable zone(Javadoc).........E/86fb5c16-5ad6-4148-9300-a566fdad63cc
public interface apartmentService {
//begin of modifiable zone(Javadoc).......C/96115da2-13e1-42c4-9b7c-f6d641fa9bc8

//end of modifiable zone(Javadoc).........E/96115da2-13e1-42c4-9b7c-f6d641fa9bc8
    List<apartment> getAllAppartements();

//begin of modifiable zone(Javadoc).......C/9e53ecde-ff46-444d-84ac-01521e76cfc5

//end of modifiable zone(Javadoc).........E/9e53ecde-ff46-444d-84ac-01521e76cfc5
    apartment getAppartementById(final int id);

//begin of modifiable zone(Javadoc).......C/f759f6c7-b4b6-4712-8134-7b777b00590e

//end of modifiable zone(Javadoc).........E/f759f6c7-b4b6-4712-8134-7b777b00590e
    apartment addAppartement(final apartment appartement);

//begin of modifiable zone(Javadoc).......C/bd6a5024-d483-4551-a9f0-d91e1a1d92a7

//end of modifiable zone(Javadoc).........E/bd6a5024-d483-4551-a9f0-d91e1a1d92a7
    boolean removeAppartement(final apartment appartementId);

//begin of modifiable zone(Javadoc).......C/b2f24cc4-0a29-4c39-bad6-c004c43a4482

//end of modifiable zone(Javadoc).........E/b2f24cc4-0a29-4c39-bad6-c004c43a4482
    apartment updateAppartement(final apartment newAppartement);

}
