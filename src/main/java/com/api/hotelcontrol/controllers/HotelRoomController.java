package com.api.hotelcontrol.controllers;

import com.api.hotelcontrol.dtos.HotelRoomDto;
import com.api.hotelcontrol.models.HotelRoomModel;
import com.api.hotelcontrol.services.HotelRoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/hotel-room")
public class HotelRoomController {

    final HotelRoomService hotelRoomService;

    public HotelRoomController(HotelRoomService hotelRoomService) {
        this.hotelRoomService = hotelRoomService;
    }

    @PostMapping
    public ResponseEntity<Object> saveHotelRoom(@RequestBody @Valid HotelRoomDto hotelRoomDto){

        if(hotelRoomService.existsByRoomName(hotelRoomDto.getRoomNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This room already in use");
        }
        if(hotelRoomService.existsByClientName(hotelRoomDto.getClientName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This client already exists");
        }
        if(hotelRoomService.existsByClientDocument(hotelRoomDto.getClientDocument())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This document already in use");
        }
        var hotelRoomModel = new HotelRoomModel();
        BeanUtils.copyProperties(hotelRoomDto, hotelRoomModel);
        hotelRoomModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(hotelRoomService.save(hotelRoomModel));
    }

    @GetMapping
    public ResponseEntity<List<HotelRoomModel>> getAllHotelRooms(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelRoomService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneHotelRoom(@PathVariable(value = "id") UUID id){
        Optional<HotelRoomModel> hotelRoomModelOptional = hotelRoomService.findById(id);
        if(!hotelRoomModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel Room not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(hotelRoomModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteHotelRoom(@PathVariable(value = "id") UUID id){
        Optional<HotelRoomModel> hotelRoomModelOptional = hotelRoomService.findById(id);
        if(!hotelRoomModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel Room not found");
        }
        hotelRoomService.delete(hotelRoomModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Hotel Room deleted successfully");
    }
}
