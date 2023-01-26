package pl.stawski.sql.basket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.stawski.sql.basket.dto.AddBasket;
import pl.stawski.sql.basket.repository.BasketRepository;

@RestController
@CrossOrigin
public class BasketController {

    @Autowired
    BasketRepository basketRepository;

    // list
    @GetMapping("/basket/list")
    public ResponseEntity<Object> getUsers(){
        return ResponseEntity.status(200).body(basketRepository.findAll());
    }

    @PostMapping("/basket/add")
    public ResponseEntity<Object> addUser(@RequestBody AddBasket addBasket){
        return ResponseEntity.status(200).body(basketRepository.findAll());
    }

    @DeleteMapping("/basket/delete")
    public ResponseEntity<Object> delete(){
        return ResponseEntity.status(200).body(basketRepository.findAll());
    }

    // add



    // delete all
}
