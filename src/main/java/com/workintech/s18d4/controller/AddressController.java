package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    // Tüm adresleri getir
    @GetMapping
    public List<Address> getAll() {
        return addressService.findAll();
    }

    // Belirli ID'ye sahip adresi getir
    @GetMapping("/{id}")
    public Address getById(@PathVariable long id) {
        return addressService.find(id);
    }

    // Yeni adres ekle
    @PostMapping
    public Address save(@RequestBody Address address) {
        return addressService.save(address);
    }

    // Adresi güncelle
    @PutMapping("/{id}")
    public Address update(@PathVariable long id, @RequestBody Address address) {
        return addressService.update(id, address);
    }

    // Adresi sil
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        addressService.delete(id);
        return "Address with id " + id + " has been deleted successfully.";
    }
}
