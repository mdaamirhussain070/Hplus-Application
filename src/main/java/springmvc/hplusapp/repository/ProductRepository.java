package springmvc.hplusapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.hplusapp.bean.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

    @Query("select p from Product p where p.name like %:name%")
     List<Product> searchByName(@RequestParam("name") String name);
}
