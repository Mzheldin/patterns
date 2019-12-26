package java.homework3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.homework3.client.ClientImpl;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientImpl, UUID> {

}
