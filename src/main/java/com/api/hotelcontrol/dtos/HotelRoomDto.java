package com.api.hotelcontrol.dtos;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HotelRoomDto {

    @NotNull
    private int roomNumber;

    @NotBlank
    private String clientName;

    @NotNull
    private int clientAge;

    @NotBlank
    private String clientProfession;

    @NotBlank
    private String clientDocument;

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
}
