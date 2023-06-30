package lt.javau5.warehouse.repo.repositories;

import lt.javau5.warehouse.repo.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
