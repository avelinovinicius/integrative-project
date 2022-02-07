package com.meli.bootcamp.integrativeproject.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meli.bootcamp.integrativeproject.dto.response.ProductBatchResponseDTO;
import com.meli.bootcamp.integrativeproject.dto.response.ProductResponseDTO;
import com.meli.bootcamp.integrativeproject.entity.Product;
import com.meli.bootcamp.integrativeproject.service.ProductService;

@RestController
@RequestMapping("/fresh-products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        List<Product> products = service.findAll();

        return ResponseEntity.ok(ProductResponseDTO.entityListToDtoList(products));
    }
    
    @GetMapping("/list/page")
    public ResponseEntity<Page<ProductResponseDTO>> findAllPaged(Pageable pageable)
    {
    	Page<ProductResponseDTO> list = service.findAllPage(pageable);
    	return ResponseEntity.ok().body(list);
    }

    @GetMapping("/list/byCategory")
    public ResponseEntity<List<ProductResponseDTO>> findAllByCategory(@RequestParam String category) {
        List<Product> products = service.findAllByCategory(category);

        return ResponseEntity.ok(ProductResponseDTO.entityListToDtoList(products));
    }

    @GetMapping("/list/byName")
    public ResponseEntity<List<ProductBatchResponseDTO>> findAllByNameAndDueDate(@RequestParam String name, @RequestParam(required = false) String orderBy) {
        List<Product> products = service.findAllByNameAndDueDate(name, orderBy);

        return ResponseEntity.ok(ProductBatchResponseDTO.entityListToDtoList(products));
    }

    @GetMapping(value = "/warehouse")
    public ResponseEntity<Object> getProductQuantityByName(@RequestParam(name = "product_name") String name){
        return ResponseEntity.ok().body(service.findAllByNameInWarehouse(name));
    }
    
}
