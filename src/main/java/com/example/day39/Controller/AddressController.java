package com.example.day39.Controller;

import com.example.day39.DTO.AddressDTO;
import com.example.day39.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/address")
public class AddressController {



    private final AddressService addressService;
    Logger logger = LoggerFactory.getLogger(TeacherController.class);


    @GetMapping("get")
    public ResponseEntity getAllAddress(){
        logger.info("get all address");

        return ResponseEntity.ok(addressService.getAll());
    }

    @PostMapping("add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        logger.info("add address");
        addressService.add(addressDTO);
        return ResponseEntity.ok("address added");
    }

    @PutMapping("update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO){
        logger.info("update address");

        addressService.update(addressDTO);
        return ResponseEntity.status(200).body("address updated");


    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        logger.info("delete address");

        addressService.delete(id);
        return ResponseEntity.status(200).body("address deleted");
    }

}
