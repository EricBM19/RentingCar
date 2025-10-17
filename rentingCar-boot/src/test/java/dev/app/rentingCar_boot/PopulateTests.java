package dev.app.rentingCar_boot;

import dev.app.rentingCar_boot.utils.PopulateBooking;
import dev.app.rentingCar_boot.utils.PopulateCar;
import dev.app.rentingCar_boot.utils.PopulateClient;
import dev.app.rentingCar_boot.utils.PopulateDrivingCourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PopulateTests {

    @Autowired
    PopulateCar populateCar;

    @Autowired
    PopulateClient populateClient;

    @Autowired
    PopulateBooking populateBooking;

    @Autowired
    PopulateDrivingCourse populateDrivingCourse;

    @Test
    void populateAllTables () {
        populateCar.populateCar(10);
        populateClient.populateClient(10);
        populateBooking.populateBooking(10);
        populateDrivingCourse.populateDrivingCourse(10);
    }
}
