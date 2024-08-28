package com.example.lakeSide_Hotel.repository;

import com.example.lakeSide_Hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoomRepository extends JpaRepository<Room, Long> {
    // tươpng tác với cơ sở dữ liệu
}
