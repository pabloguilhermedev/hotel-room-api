package com.api.hotelcontrol.repositories;

import com.api.hotelcontrol.models.HotelRoomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoomModel, UUID> {

    boolean existsByRoomNumber(int roomNumber);
    boolean existsByClientName(String clientName);
    boolean existsByClientDocument(String clientDocument);
}
