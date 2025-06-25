package com.inaing.inaeats.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inaing.inaeats.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {

    @Query
    Optional<Tag> findByName(String name);

    @Query
    List<Tag> findAllByNameIn(Set<String> names);
}