package com.dbmsproject;

/**
 * @author akhil
 */

import java.util.Map;

public class Event extends DBObject {
    final static String table = "events";

    int id;
    int organizer;
    String name;
    String location;

    Event(int id, int organizer, String name, String location) {
        this.id = id;
        this.organizer = organizer;
        this.name = name;
        this.location = location;
    }


    Event(Map<String, Object> event) {
        this(Integer.parseInt(event.get("id").toString()), Integer.parseInt(event.get("organizer").toString()), event.get("name").toString(), event.get("location").toString());
    }

    @Override
    String getValues() {
        return String.format("values (%s, %s, \'%s\', \'%s\');", id, organizer, name, location);
    }

    @Override
    String getTableName() {
        return table;
    }
}
