package com.example.lakeSide_Hotel.controller;

import com.example.lakeSide_Hotel.model.Room;
import com.example.lakeSide_Hotel.response.RoomResponse;
import com.example.lakeSide_Hotel.service.IRoomSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/rooms") // ánh xạ tới controller
public class RoomController {
    private final IRoomSevice roomSevice;




    @PostMapping("/add/new-room") // ánh xạ phương thức cụ thể trong controller
    public ResponseEntity<RoomResponse> addNewRoom(
                @RequestParam("photo") MultipartFile photo,
                @RequestParam("roomType") String roomType,
                @RequestParam("roomPrice") BigDecimal roomPrice) throws SQLException, IOException {
            Room savedRoom = roomSevice.addNewRoom(photo, roomType, roomPrice);
            RoomResponse responce = new RoomResponse(savedRoom.getId(), savedRoom.getRoomType(), savedRoom.getRoomPrice());

            return ResponseEntity.ok(responce);
        }
}
