package dev.app.rentingcarvaadin.utils;

import dev.app.rentingcarvaadin.model.Client;
import dev.app.rentingcarvaadin.model.DrivingCourse;
import dev.app.rentingcarvaadin.repository.ClientRepository;
import dev.app.rentingcarvaadin.repository.DrivingCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PopulateDrivingCourse {

    @Autowired
    DrivingCourseRepository drivingCourseRepository;

    @Autowired
    ClientRepository clientRepository;


    public void populateDrivingCourse(int qty) {
        // let s populate this table: Driving Course
        // generate qty driving courses using generateDrivingCourses method
        List<DrivingCourse> drivingCourses = generateDrivingCourses(qty);
        // assign clients to driving courses using assignClientsToDrivingCourses method
        assignClientsToDrivingCourses(drivingCourses);
    }

    public List<DrivingCourse> generateDrivingCourses(int qty) {
        List<DrivingCourse> generatedDrivingCourses = new ArrayList<>();
        Random random = new Random();

        String [] courseNames = {"Car", "Motorbike", "Bus", "Truck"};
        String [] descriptions = {"Car course", "Moto course", "Bus course", "Truck course"};
        String [] instructors = {"John", "James", "Sonia", "Joseph"};
        String [] categories = {"Basic", "Advanced", "Defensive", "Commercial"};
        String [] locations = {"City A", "City B", "City C", "City D"};

        for(int i = 0; i < qty; i++) {
            String name = courseNames[random.nextInt(courseNames.length)];
            String description = descriptions[random.nextInt(descriptions.length)];
            String instructor = instructors[random.nextInt(instructors.length)];
            int duration = random.nextInt(10,30);
            double price = random.nextDouble(50,250);
            String category = categories[random.nextInt(categories.length)];
            int maxStudents = random.nextInt(5,20);
            boolean isActive = random.nextBoolean();
            String location = locations[random.nextInt(locations.length)];

            DrivingCourse drivingCourse = new DrivingCourse(name,description,instructor,duration,price,category,maxStudents,isActive,location);
            generatedDrivingCourses.add(drivingCourse);
            drivingCourseRepository.save(drivingCourse);
        }
        return generatedDrivingCourses;
    }

    public void assignClientsToDrivingCourses(List<DrivingCourse> drivingCourses){
        // to do
        Random random = new Random();
        List<Client> clients = (List<Client>) clientRepository.findAll();

        for(DrivingCourse drivingCourse: drivingCourses) {
            //todo
            int numClientsToAssign = random.nextInt(3,5);
            List<Client> clientsToAdd = new ArrayList<>();

            while (clientsToAdd.size() < numClientsToAssign && clientsToAdd.size() < clients.size()) {

                Client client = clients.get(random.nextInt(clients.size()));

                if (!clientsToAdd.contains(client)) {
                    clientsToAdd.add(client);
                }
            }

            drivingCourse.setClientFK(clientsToAdd);
            drivingCourseRepository.save(drivingCourse);
        }
    }
}