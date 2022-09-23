package com.api.hotelcontrol.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_HOTEL_ROOM")
public class HotelRoomModel implements Serializable {

    public static final long serialVersionIUD = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 4)
    private int roomNumber;
    @Column(nullable = false, unique = true, length = 130)
    private String clientName;
    @Column(nullable = false, unique = true, length = 4)
    private int clientAge;
    @Column(nullable = false, unique = true, length = 30)
    private String clientProfession;
    @Column(nullable = false, unique = true, length = 70)
    private String clientDocument;
    @Column(nullable = false)
    private LocalDateTime registrationDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientAge() {
        return clientAge;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    public String getClientProfession() {
        return clientProfession;
    }

    public void setClientProfession(String clientProfession) {
        this.clientProfession = clientProfession;
    }

    public String getClientDocument() {
        return clientDocument;
    }

    public void setClientDocument(String clientDocument) {
        this.clientDocument = clientDocument;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
