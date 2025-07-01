package com.inaing.inaeats.dto.allergen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllergenCreationDto {
    private String name;
    private String description;
    private String productId;
}
