package ru.anokhin.firstspring.reservations.availability;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.anokhin.firstspring.reservations.ReservationRepository;
import ru.anokhin.firstspring.reservations.ReservationStatus;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationAvailabilityService {

    private final ReservationRepository reservationRepository;

    private static final Logger log = LoggerFactory.getLogger(ReservationAvailabilityService.class);

    public ReservationAvailabilityService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    //Метод для проверка персечений бронирования
    public boolean isReservationAvailable(
            Long roomId,
            LocalDate startDate,
            LocalDate endDate
    ) {
        if(!endDate.isAfter(startDate)){
            throw new IllegalArgumentException("Start date should be after end date");
        }

        List<Long> conflictingIds = reservationRepository.findConflictReservationIds(
                roomId,
                startDate,
                endDate,
                ReservationStatus.APPROVED
        );
        if (conflictingIds.isEmpty()) {
            return true;
        }
        log.info("Conflict with ids = {}", conflictingIds);
        return false;
    }

}
