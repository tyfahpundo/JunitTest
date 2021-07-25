package zw.co.afrosoft.junittest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zw.co.afrosoft.junittest.model.Product;
import zw.co.afrosoft.junittest.persistence.ProductRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class JunitTestApplicationTests {
    @Autowired
    ProductRepository repo;
    @Test
    public void testCreate(){
        Product product = new Product();
        product.setId(1L);
        product.setName("Sony Laptop");
        product.setPrice(500.00);
        product.setDecription("Brand New Laptop");
        repo.save(product);
        assertNotNull(repo.findById(1L).get());
    }
    @Test
    public void testReadAll(){
        List<Product> list = repo.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

}
