package ru.anokhin.firstspring.web;

import java.time.LocalDateTime;

public record ErrorResponseDto(
    String message,
    String detailedMessage, //errorMessages
    LocalDateTime errorTime
){

}
