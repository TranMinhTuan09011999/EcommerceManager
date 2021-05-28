package com.minhtuan.commercemanager.services;

import com.minhtuan.commercemanager.model.Category;
import com.minhtuan.commercemanager.model.DTO.CategoryDTO;
import com.minhtuan.commercemanager.model.DTO.ProductDTO;

import java.util.List;

public interface CategoryService {
    public List<CategoryDTO> getCategory();

    public CategoryDTO getCategoryByName(String name);
}
