package dev.app.rentingcarvaadin.repository;

import dev.app.rentingcarvaadin.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, String> {}
