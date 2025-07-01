package com.inaing.inaeats.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "allergen", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Allergen {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "allergen_name")
    private String name;

    @Column(name = "allergen_description")
    private String description;

    @ManyToMany(mappedBy = "allergens")
    private Set<Product> products;
}
