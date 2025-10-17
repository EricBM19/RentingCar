package dev.app.rentingCar_boot;

import dev.app.rentingCar_boot.repository.DrivingCourseRepository;
import dev.app.rentingCar_boot.utils.PopulateDrivingCourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class drivingCourseTests {

    @Autowired
    DrivingCourseRepository drivingCourseRepository;

    @Autowired
    PopulateDrivingCourse populateDrivingCourse;

    @Test
    void courseTest() {
        populateDrivingCourse.populateDrivingCourse(10);
    }
}
