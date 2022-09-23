package com.api.hotelcontrol.services;

import com.api.hotelcontrol.models.HotelRoomModel;
import com.api.hotelcontrol.repositories.HotelRoomRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelRoomService {

    final
    HotelRoomRepository hotelRoomRepository;

    public HotelRoomService(HotelRoomRepository hotelRoomRepository) {
        this.hotelRoomRepository = hotelRoomRepository;
    }

    @Transactional
    public HotelRoomModel save(HotelRoomModel hotelRoomModel) {
        return hotelRoomRepository.save(hotelRoomModel);
    }

    public boolean existsByRoomName(int roomName){
        return hotelRoomRepository.existsByRoomNumber(roomName);
    }

    public boolean existsByClientName(String clientName){
        return hotelRoomRepository.existsByClientName(clientName);
    }

    public boolean existsByClientDocument(String clientDocument){
        return hotelRoomRepository.existsByClientDocument(clientDocument);
    }

    public List<HotelRoomModel> findAll(){
        return hotelRoomRepository.findAll();
    }

    public Optional<HotelRoomModel> findById(UUID id) {
        return hotelRoomRepository.findById(id);
    }

    @Transactional
    public void delete(HotelRoomModel hotelRoomModel) {
        hotelRoomRepository.delete(hotelRoomModel);
    }
}
