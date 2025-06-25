package com.inaing.inaeats.service;

import java.util.List;

import com.inaing.inaeats.entity.Tag;

public interface TagService {

    Tag findOrCreateByName(String tagName);

    List<Tag> findOrCreateByName(List<String> tagNames);
}
