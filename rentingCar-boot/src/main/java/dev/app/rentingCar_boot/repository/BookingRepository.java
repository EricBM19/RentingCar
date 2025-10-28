package dev.app.rentingCar_boot.repository;

import dev.app.rentingCar_boot.model.Booking;
import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends CrudRepository <Booking, String> {

    @Query("SELECT b FROM Booking b WHERE b.carFK = :car AND b.isActive = true AND " +
            "((b.bookingDate <= :endDate) AND (b.bookingDate + b.qtyDays >= :startDate))")
    List<Booking> findOverlappingBookingsForCar(@Param("car") Car car,
                                                @Param("startDate") int startDate,
                                                @Param("endDate") int endDate);

    List<Booking> findTop10ByOrderByTotalAmountDesc();

    @Query("SELECT b FROM Booking b WHERE b.carFK = :car")
    List<Booking> findByCarFK(@Param("car") Car car);

    @Query("SELECT b FROM Booking b WHERE b.clientFK = :client")
    List<Booking> findByClientFK(@Param("client") Client client);

}
