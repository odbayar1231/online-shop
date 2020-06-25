package odko.nanjid.onlineshop2.service;

import odko.nanjid.onlineshop2.domain.Category;
import odko.nanjid.onlineshop2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {return (List<Category>) categoryRepository.findAll(); }

    @Override
    public Category getCategoryById(int id) {return categoryRepository.findById(id).get(); }

}
