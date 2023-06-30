package lt.javau5.warehouse.repo.repositories;

import lt.javau5.warehouse.repo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
