package com.Alish.midka.controller;

import com.Alish.midka.Service.CategoryService;
import com.Alish.midka.Service.ProductService;
import com.Alish.midka.model.Address;
import com.Alish.midka.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public void createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
    }




    @DeleteMapping("/{id}")
    public void deleteCategory(@RequestParam Long id){
        categoryService.deleteAddress(id);
    }

}
