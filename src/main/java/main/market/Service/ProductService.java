package main.market.Service;

import main.market.Entity.Product;
import main.market.Repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product save(Product product){
        return repo.save(product);
    }

    public Product findOne(Long id) {
        Optional<Product> optional = repo.findById(id);
        if (optional.isPresent()) {
            Product product = optional.get();
            return product;
        }
        return null;
    }

    public Page<Product> findAll(Pageable pageable){
        Page<Product> page = repo.findAll(pageable);
        return page;
    }


    public void delete(Long id){
        repo.deleteById(id);

    }
}
