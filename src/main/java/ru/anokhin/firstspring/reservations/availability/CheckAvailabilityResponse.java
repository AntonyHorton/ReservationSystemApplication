package ru.anokhin.firstspring.reservations.availability;

public record CheckAvailabilityResponse(
        String message,
        AvailabilityStatus status

) {
}
