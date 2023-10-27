package com.productReview.productReview.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String Price;
    private LocalDateTime cDate;

    private LocalDateTime uDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews=new ArrayList<>();


    public void addSingleReview(Review review){
        this.reviews.add(review);
    }

}
