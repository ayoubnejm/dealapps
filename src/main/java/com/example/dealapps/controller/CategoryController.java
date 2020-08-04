package com.example.dealapps.controller;

import com.example.dealapps.dto.CategoryDto;
import com.example.dealapps.exception.MyResourceNotFoundException;
import com.example.dealapps.model.Category;
import com.example.dealapps.service.CategoryService;
import com.example.dealapps.util.RestPreconditions;
import com.google.api.client.util.Preconditions;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author NEJMEDDINE Ayoub
 * @created 04/08/2020 -10:13
 */
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ApiOperation(value="Return all categorys.", notes="This is a public API", response= List.class)
    public List<CategoryDto> findAll() {
        List<Category> categorys =  categoryService.findAll();
        return categorys.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Get a category by id.", notes="This is a public API", response=CategoryDto.class)
    @ResponseStatus(HttpStatus.OK)
    public CategoryDto getById(@PathVariable long id) throws MyResourceNotFoundException {
        Category category = categoryService.findById(id);
        RestPreconditions.checkFound(category);
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }


    @PostMapping
    @ApiOperation(value="Create a category and return his id ", notes="This is a public API", response=Long.class)
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@Valid @RequestBody CategoryDto categoryDto) {
        Preconditions.checkNotNull(categoryDto);
        return categoryService.saveOrUpdate(categoryDto).getId();
    }


    @PutMapping(value = "/{id}")
    @ApiOperation(value="Update a category", notes="This is a public API")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @Valid @RequestBody CategoryDto categoryDto) {
        categoryDto.setId(id);
        Preconditions.checkNotNull(categoryDto);
        Preconditions.checkNotNull(categoryService.getById(categoryDto.getId()));
        categoryService.saveOrUpdate(categoryDto);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value="Delete a category", notes="This is a public API")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        categoryService.getById(id);
        categoryService.deleteById(id);
    }


    private CategoryDto convertToDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }
}
