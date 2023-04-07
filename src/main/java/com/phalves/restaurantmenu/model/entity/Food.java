package com.phalves.restaurantmenu.model.entity;

import com.phalves.restaurantmenu.model.dto.FoodRequestDTO;
import com.phalves.restaurantmenu.model.dto.FoodResponseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "foods")
@Entity(name = "foods")
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Float price;
    private String description;

//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;


    public Food(FoodRequestDTO data){
        this.title = data.title();
        this.image = data.image();
        this.description = data.description();
        this.price = data.price();
    }

    public Food(FoodResponseDTO data){
        this.id = data.id();
        this.title = data.title();
        this.image = data.image();
        this.description = data.description();
        this.price = data.price();
    }
}
