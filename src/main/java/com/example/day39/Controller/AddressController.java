package com.example.day39.Controller;

import com.example.day39.DTO.AddressDTO;
import com.example.day39.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/address")
public class AddressController {



    private final AddressService addressService;


    @GetMapping("get")
    public ResponseEntity getAllProfile(){
        return ResponseEntity.ok(addressService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.add(addressDTO);
        return ResponseEntity.ok("address added");
    }

    @PutMapping("update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO){

        addressService.update(addressDTO);
        return ResponseEntity.status(200).body("address updated");


    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){

        addressService.delete(id);
        return ResponseEntity.status(200).body("address deleted");
    }

}
