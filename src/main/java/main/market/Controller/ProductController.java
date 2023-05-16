package main.market.Controller;

import main.market.Entity.Product;
import main.market.Service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product newProduct = service.save(product);
        return ResponseEntity.ok(newProduct);
    }
    @PutMapping("/product")
    public ResponseEntity<Product> update(@RequestBody Product product){
        Product newProduct = service.save(product);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getOne(@PathVariable Long id){
        Product data = service.findOne(id);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/products")
    public Page<Product> getAll(Pageable pageable ){
        Page<Product> data = service.findAll(pageable);
        return data;
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("Delated");
    }




}
