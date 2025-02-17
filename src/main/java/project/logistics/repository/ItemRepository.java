package project.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.logistics.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
