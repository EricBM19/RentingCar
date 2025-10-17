package dev.app.rentingCar_boot;

import dev.app.rentingCar_boot.utils.PopulateDrivingCourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DrivingCourseTests {

    @Autowired
    PopulateDrivingCourse populateDrivingCourse;

    @Test
    void courseTest() {
        populateDrivingCourse.populateDrivingCourse(10);
    }
}
