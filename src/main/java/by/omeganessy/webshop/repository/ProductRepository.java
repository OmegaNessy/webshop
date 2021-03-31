package by.omeganessy.webshop.repository;

import by.omeganessy.webshop.entity.Category;
import by.omeganessy.webshop.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

    public List<Product> findByCategory(Category category);
}
