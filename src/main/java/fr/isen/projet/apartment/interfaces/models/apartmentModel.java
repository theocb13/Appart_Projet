package fr.isen.projet.apartment.interfaces.models;

public class apartmentModel {
    private String id;
    private int nbPieces;
    private int price;
    private int area;
    private int nbPeople;
    private String address;
    private int ownerID;
    private int availabilityID;

    // Getter et Setter pour id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter et Setter pour nbPieces
    public int getNbPieces() {
        return nbPieces;
    }

    public void setNbPieces(int nbPieces) {
        this.nbPieces = nbPieces;
    }

    // Getter et Setter pour price
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Getter et Setter pour area
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    // Getter et Setter pour nbPeople
    public int getNbPeople() {
        return nbPeople;
    }

    public void setNbPeople(int nbPeople) {
        this.nbPeople = nbPeople;
    }

    // Getter et Setter pour address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter et Setter pour owner
    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int owner) {
        this.ownerID = ownerID;
    }

    // Getter et Setter pour availability
    public int getAvailabilityID() {
        return availabilityID;
    }

    public void setAvailabilityID(int availability) {
        this.availabilityID = availabilityID;
    }
}
