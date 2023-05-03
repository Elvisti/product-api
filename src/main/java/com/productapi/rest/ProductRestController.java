package com.productapi.rest;

import com.productapi.repository.ProductRepository;
import com.productapi.repository.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("product")
@RestController
public class ProductRestController {
    private static final Logger LOGGER = LogManager.getLogger(ProductRestController.class);

    private ProductRepository repository;

    public ProductRestController(ProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<List<Product>> createProduct(@RequestBody List<Product> products) {
        LOGGER.info("Adding a product...");
        ArrayList<Product> productSave = new ArrayList<>();

        for(Product pd : products) {
            Product save = repository.save(pd);
            productSave.add(save);
        }

        return ResponseEntity.ok().body(productSave);
    }

//    @GetMapping()
//    public List<Product> getProducts(@RequestParam("search") String search) {
//        List<Product> byName = repository.findByNameLike(search);
//        LOGGER.info("Name finded --- {}", byName);
//
//        return byName;
//    }

    @GetMapping("/{search}")
    public List<Product> getProducts(@PathVariable("search") String search) {
        List<Product> byName = repository.findByProductLikeCaseInsensitive(search);
        LOGGER.info("Name found --- {}", byName);

        return byName;
    }

}
