package zw.co.afrosoft.junittest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zw.co.afrosoft.junittest.model.Product;
import zw.co.afrosoft.junittest.persistence.ProductRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JunitTestApplicationTests {
    @Autowired
    ProductRepository repo;
    @Test
    @Order(1)
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
    @Order(2)
    public void testReadAll(){
        List<Product> list = repo.findAll();
        assertThat(list).size().isGreaterThan(0);
    }
    @Test
    @Order(3)
    public void testSingleProduct(){
        Product product = repo.findById(1L).get();
        assertEquals(500.00,product.getPrice());
    }
    @Test
    @Order(4)
    public void testUpdate(){
        Product product = repo.findById(1L).get();
        product.setPrice(200.00);
        repo.save(product);
        assertNotEquals(500.00, repo.findById(1L).get().getPrice());
    }
    @Test
    @Order(5)
    public void testDelete(){
        repo.deleteById(1L);
        assertThat(repo.existsById(1L)).isFalse();
    }

}
