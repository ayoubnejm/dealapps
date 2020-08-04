package com.example.dealapps.service.impl;

import com.example.dealapps.dto.CategoryDto;
import com.example.dealapps.model.Category;
import com.example.dealapps.repository.CategoryRepository;
import com.example.dealapps.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author NEJMEDDINE Ayoub
 * @created 04/08/2020 -10:11
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id)  {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()) {
            return category.get();
        }
        return null;
    }

    @Override
    public Category saveOrUpdate(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        return categoryRepository.save(category);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
