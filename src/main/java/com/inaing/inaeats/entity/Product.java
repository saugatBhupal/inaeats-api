package com.inaing.inaeats.entity;

import java.util.List;

import org.hibernate.annotations.Formula;

import com.inaing.inaeats.entity.enums.DietType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "product_type")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "shelf_life")
    private Integer shelfLife;
    private Integer portion;
    private Integer price;

    @Column(name = "diet_type")
    @Enumerated(EnumType.STRING)
    private DietType dietType;

    @Formula("product_type")
    private String productType;

    private Integer weight;
    private Integer calories;
    private Integer fats;
    private Integer protein;
    private Integer carbs;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "product_tag", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @OneToMany(mappedBy = "product", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<Image> images;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "product_allergen", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "allergen_id"))
    private List<Allergen> allergens;
}
