package zw.co.afrosoft.junittest.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.junittest.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
