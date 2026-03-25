package com.app.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.app.model.RepairShop;
import com.app.repository.RepairShopRepository;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
@CrossOrigin(origins = "http://localhost:3000")
public class RepairShopController {

    @Autowired
    private RepairShopRepository repository;

    @GetMapping
    public List<RepairShop> getAllShops() {
        return repository.findAll();
    }

    @PostMapping
    public RepairShop createShop(@RequestBody RepairShop shop) {
        return repository.save(shop);
    }

    @PutMapping("/{id}")
    public RepairShop updateShop(@PathVariable int id, @RequestBody RepairShop shopDetails) {
        RepairShop shop = repository.findById(id).orElseThrow();
        shop.setShopName(shopDetails.getShopName());
        shop.setLocation(shopDetails.getLocation());
        shop.setContactNumber(shopDetails.getContactNumber());
        shop.setServiceType(shopDetails.getServiceType());
        return repository.save(shop);
    }

    @DeleteMapping("/{id}")
    public String deleteShop(@PathVariable int id) {
        repository.deleteById(id);
        return "Shop deleted successfully!";
    }
}

