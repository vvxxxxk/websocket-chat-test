package com.tekcosbew.websocket.repository;

import com.tekcosbew.websocket.model.entity.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoomRepository {

    private static final Map<Long, Room> store = new HashMap<>();
    private static long sequence = 0L;

    public Room save(Room room) {
        room.setRoomNo(++sequence);
        store.put(room.getRoomNo(), room);
        return room;
    }

    public Room findByRoomNo(Long roomNo) {
        return store.get(roomNo);
    }

    public List<Room> findAll() {
        return new ArrayList<>(store.values());
    }
}
