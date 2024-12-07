package project.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.logistics.entity.Receiving;

public interface ReceivingRepository extends JpaRepository<Receiving,Long> {

}
