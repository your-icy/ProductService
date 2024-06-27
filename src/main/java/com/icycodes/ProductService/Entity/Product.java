package com.icycodes.ProductService.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(name = "Product_Name")
    private String productName;

    @Column(name = "Product_Price")
    @PositiveOrZero
    private Long price;


    @Column(name = "Product_Quantity")
    @PositiveOrZero
    private Long quantity;

}
