package com.inaing.inaeats.dto.product.readyToEat;

import com.inaing.inaeats.dto.product.ProductCreationDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadyToEatCreationDto extends ProductCreationDto {
    private boolean requiresHeating;

    public ReadyToEatCreationDto() {
        super();
    }
}