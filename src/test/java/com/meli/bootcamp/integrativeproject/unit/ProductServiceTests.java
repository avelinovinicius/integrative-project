package com.meli.bootcamp.integrativeproject.unit;

import com.meli.bootcamp.integrativeproject.dto.response.ProductResponseDTO;
import com.meli.bootcamp.integrativeproject.entity.Product;
import com.meli.bootcamp.integrativeproject.exception.NotFoundException;
import com.meli.bootcamp.integrativeproject.repositories.ProductRepository;
import com.meli.bootcamp.integrativeproject.service.ProductService;
import com.meli.bootcamp.integrativeproject.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    private PageImpl<Product> page;
    private PageImpl<Product> emptyPage;
    private Product product;
    private Pageable pageable;

    @BeforeEach
    void SetUp()
    {
        product = Factory.createProduct();
        page = new PageImpl<>(List.of(product));
        emptyPage = new PageImpl<>(Collections.emptyList());
        pageable = PageRequest.of(0,10);

    }

    @Test
    public void findAllPagedShouldReturnPage()
    {
        Mockito.when(repository.findAll((Pageable) ArgumentMatchers.any())).thenReturn(page);

        Page<ProductResponseDTO> result = service.findAllPaged(pageable);

        Assertions.assertNotNull(result);
        Mockito.verify(repository, Mockito.times(1)).findAll(pageable);
    }

    @Test
    public void findAllPagedShouldThrowNotFoundExceptionWhenProductNotFound()
    {
        Mockito.when(repository.findAll((Pageable) ArgumentMatchers.any())).thenReturn(emptyPage);

        Assertions.assertThrows(NotFoundException.class, ()->{
           service.findAllPaged(pageable);
        });
    }
}
