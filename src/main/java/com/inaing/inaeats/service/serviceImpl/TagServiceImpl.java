package com.inaing.inaeats.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.inaing.inaeats.entity.Tag;
import com.inaing.inaeats.repository.TagRepository;
import com.inaing.inaeats.service.TagService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Override
    public Tag findOrCreateByName(String tagName) {
        return tagRepository.findByName(tagName)
                .orElseGet(() -> tagRepository.save(
                        Tag.builder().name(tagName).build()));
    }

    @Override
    public List<Tag> findOrCreateByName(List<String> tagNames) {

        Set<String> distinctNames = tagNames.stream().filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toSet());

        List<Tag> existingTags = tagRepository.findAllByNameIn(distinctNames);

        Set<String> existingNames = existingTags.stream()
                .map(Tag::getName)
                .collect(Collectors.toSet());

        List<Tag> newtags = distinctNames.stream()
                .filter(name -> !existingNames.contains(name))
                .map(name -> Tag.builder().name(name).build())
                .toList();
        List<Tag> savedTags = tagRepository.saveAll(newtags);

        List<Tag> resultTags = new ArrayList<>();
        resultTags.addAll(existingTags);
        resultTags.addAll(savedTags);
        return resultTags;

    }

}
