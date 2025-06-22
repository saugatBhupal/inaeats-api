package com.inaing.inaeats.entity;

import com.inaing.inaeats.entity.enums.DifficultyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MealKit extends Product {

    @Column(name = "recipe_video")
    private String recipeVideo;

    private Integer duration;

    @Enumerated(EnumType.STRING)
    private DifficultyType difficulty;
}
