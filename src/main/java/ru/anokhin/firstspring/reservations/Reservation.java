package ru.anokhin.firstspring.reservations;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.time.LocalDate;

public record Reservation(

        @Null
        Long id,    //PRIMARY KEY id
        @NotNull
        Long userId, //Users id who was created order
        @NotNull
        Long roomId, //id of room
        @FutureOrPresent
        @NotNull
        LocalDate startDate,    //start of order
        @FutureOrPresent
        @NotNull
        LocalDate endDate,      //end of order

        ReservationStatus status
) {
}
        