package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again")
    private String contactEmail;

    private EventType type;

    @NotBlank(message = "Location required")
    private String location;

    @Min(value = 1, message = "At least one attendee required")
    private int attendees;

    @AssertTrue(message = "Registration required")
    private boolean registration;

    public Event(String name, String description, String contactEmail,
                 EventType type, String location, int attendees,
                 boolean registration) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.type = type;
        this.location = location;
        this.attendees = attendees;
        this.registration = registration;
    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    // Getters and Setters:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public int getId() {
        return id;
    }

    // toString, equals, and hashCode methods
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
