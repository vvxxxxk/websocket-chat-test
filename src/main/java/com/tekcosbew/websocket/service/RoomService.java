package com.tekcosbew.websocket.service;

import com.tekcosbew.websocket.model.entity.Room;
import com.tekcosbew.websocket.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public void createRoom(String name) {
        Room room = new Room();
        room.setName(name);
        roomRepository.save(room);
    }

    public List<Room> findAll() {

        return roomRepository.findAll();
    }

    public Room findByRoomNo(long roomNo) {

        return roomRepository.findByRoomNo(roomNo);
    }
}
