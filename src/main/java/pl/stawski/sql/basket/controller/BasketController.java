package pl.stawski.sql.basket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.stawski.sql.basket.dto.AddBasket;
import pl.stawski.sql.basket.dto.UpdateBasket;
import pl.stawski.sql.basket.model.BasketEntity;
import pl.stawski.sql.basket.repository.BasketRepository;
import pl.stawski.sql.products.dao.ProductRepository;
import pl.stawski.sql.products.model.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class BasketController {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ProductRepository productRepository;

    // list
    @GetMapping("/basket/list")
    public ResponseEntity<Object> getUsers(){
        return ResponseEntity.status(200).body(basketRepository.findAll());
    }

    @PostMapping("/basket/add")
    public ResponseEntity<Object> addUser(@RequestBody AddBasket addBasket){
        Optional<BasketEntity> basket = basketRepository.findById(1L);
        List<ProductEntity> productEntity = productRepository.getAllByName(addBasket.getName());
        List<ProductEntity> list = basket.get().getProductEntityList();
        list.add(productEntity.get(0));
        basket.get().setProductEntityList(list);
        return ResponseEntity.status(200).body(basketRepository.save(basket.get()));
    }

    @PostMapping("/basket/update")
    public ResponseEntity<Object> addUser(@RequestBody UpdateBasket updateBasket){
        Optional<BasketEntity> basket = basketRepository.findById(1L);
        Optional<ProductEntity> productEntity = productRepository.findById(updateBasket.getId());
        if(updateBasket.getAction().equals("plus")){
            productEntity.get().setAmount(productEntity.get().getAmount()+1);
        }
        else if (updateBasket.getAction().equals("minus")){
            productEntity.get().setAmount(productEntity.get().getAmount()-1);
        }
        productRepository.save(productEntity.get());
        return ResponseEntity.status(200).body("UPDATED");
    }

    @DeleteMapping("/basket/delete")
    public ResponseEntity<Object> delete(){
        Optional<BasketEntity> basket = basketRepository.findById(1L);
        basket.get().setProductEntityList(new ArrayList<>());
        basketRepository.save(basket.get());
        return ResponseEntity.status(200).body("DELETED");
    }

    // add



    // delete all
}
