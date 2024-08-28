package com.example.lakeSide_Hotel.service;

import com.example.lakeSide_Hotel.model.Room;
import com.example.lakeSide_Hotel.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class RoomService implements IRoomSevice{
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) throws IOException, SQLException {
        Room room = new Room();
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);
        if(!file.isEmpty()) {
            byte[] phoBytes = file.getBytes();
            Blob photoBlob = new SerialBlob(phoBytes);
            room.setPhoto(photoBlob);
        }

        return roomRepository.save(room); // lưu vào cơ sở dữ liệu
    }
}
