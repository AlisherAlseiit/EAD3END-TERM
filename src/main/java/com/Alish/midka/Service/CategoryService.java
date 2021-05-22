package com.Alish.midka.Service;

import com.Alish.midka.model.Category;
import com.Alish.midka.model.Product;
import com.Alish.midka.repository.CategoryRepository;
import com.Alish.midka.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;





    public void createCategory(Category category) {

        Category newCategory = new Category();
        newCategory.setId(category.getId());
        newCategory.setCategoryName(category.getCategoryName());

        categoryRepository.saveAndFlush(newCategory);

    }





    public void deleteAddress(Long id) {
        categoryRepository.deleteById(id);
    }
}
