package pl.stawski.sql.products.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.stawski.sql.products.dao.ProductRepository;
import pl.stawski.sql.products.dto.FilterData;
import pl.stawski.sql.products.model.ProductEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/product/list")
    public ResponseEntity<Object> getProducts(@RequestBody FilterData filterData) throws IOException {

        if(!filterData.getToken().equals("34ljk5nbmvxc@#!^*$%a")){
            return ResponseEntity.status(400).body("BAD TOKEN");
        }
        else if(filterData.getName() == null && filterData.getCategory() == null && filterData.getSortType() == null){
            return ResponseEntity.status(200).body(productRepository.findAll());
        }
        List<ProductEntity> list = new ArrayList<>();
        // NAME
        if(filterData.getName()!=null && filterData.getCategory()==null){
            list = productRepository.getAllByName(filterData.getName());
        }
        // CATEGORY
        else if(filterData.getName()==null && filterData.getCategory()!=null){
            list = productRepository.getAllByCategory(filterData.getName());
        }
        // BOTH
        else if(filterData.getName()==null && filterData.getCategory()!=null){
            list = productRepository.getAllByFilters(filterData.getName(),filterData.getCategory());
        }
        // NONE
        else if(filterData.getName()==null && filterData.getCategory()==null){
            list = productRepository.findAll();
        }



        if(filterData.getSortType()!=null){
            // TYPES
            if(filterData.getSortType().equals("A-Z")){
                Collections.sort(list,new SortById());
            }
            if(filterData.getSortType().equals("Z-A")){
                Collections.reverseOrder();
            }
        }

        return ResponseEntity.status(200).body(list);
    }

    class SortById implements Comparator<ProductEntity> {
        // Used for sorting in ascending order of ID
        public int compare(ProductEntity a, ProductEntity b)
        {
            return a.getName().compareTo(b.getName());
        }
    }

}

