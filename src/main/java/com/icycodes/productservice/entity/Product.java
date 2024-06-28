package com.icycodes.productservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import static jakarta.persistence.GenerationType.TABLE;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @TableGenerator(
            name = "productGen",
            table = "PRODUCT_ID_GEN",
            pkColumnName = "GEN_KEY",
            valueColumnName = "GEN_VALUE",
            pkColumnValue = "PRODUCT_ID",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy=TABLE, generator="productGen")
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
