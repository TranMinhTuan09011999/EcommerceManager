package com.minhtuan.commercemanager.model.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Float price;
    private Integer promotion;
    private String description;
    private String image;
    private Integer deletestatus;
}
