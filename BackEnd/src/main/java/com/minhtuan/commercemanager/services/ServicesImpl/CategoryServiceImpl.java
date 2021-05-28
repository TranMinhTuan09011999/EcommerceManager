package com.minhtuan.commercemanager.services.ServicesImpl;

import com.minhtuan.commercemanager.converter.CategoryConverter;
import com.minhtuan.commercemanager.model.Category;
import com.minhtuan.commercemanager.model.DTO.CategoryDTO;
import com.minhtuan.commercemanager.model.DTO.ProductDTO;
import com.minhtuan.commercemanager.repository.CategoryRepository;
import com.minhtuan.commercemanager.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public List<CategoryDTO> getCategory() {
        List<Category> list = categoryRepository.findAll();
        List<CategoryDTO> listDTO = new ArrayList<CategoryDTO>();
        list.stream().forEach(s -> {
            CategoryDTO dto = categoryConverter.toDTO(s);
            listDTO.add(dto);
        });
        return listDTO;
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        Category category = categoryRepository.findCategoryByCategoryname(name);
            CategoryDTO dto = categoryConverter.toDTO(category);
        return dto;
    }
}
