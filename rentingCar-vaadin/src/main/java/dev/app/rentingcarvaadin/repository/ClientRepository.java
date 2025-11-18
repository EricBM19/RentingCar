package dev.app.rentingcarvaadin.repository;

import dev.app.rentingcarvaadin.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository <Client, String> {
}
