package project.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.logistics.entity.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
