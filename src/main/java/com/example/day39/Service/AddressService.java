package com.example.day39.Service;

import com.example.day39.Api.ApiException;
import com.example.day39.DTO.AddressDTO;
import com.example.day39.Model.Address;
import com.example.day39.Model.Teacher;
import com.example.day39.Repository.AddressRepository;
import com.example.day39.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }


    public void add(AddressDTO addressDTO) {

        if (!teacherRepository.existsById(addressDTO.getTeacher_id())) {
            throw new ApiException("address id not found");
        }
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    public void update( AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address == null){
            throw new ApiException("address not found");
        }

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(address);
    }

    public void delete(Integer id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
        } else {
            throw new ApiException("address not found");
        }


    }




}
