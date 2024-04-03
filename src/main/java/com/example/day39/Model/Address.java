package com.example.day39.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Address {

    @Id
    private Integer id;
    @NotEmpty(message = "area must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;
    @NotEmpty(message = "street must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;
    @NotNull(message = "building number must not be empty")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
