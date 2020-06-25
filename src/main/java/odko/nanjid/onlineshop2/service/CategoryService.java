package odko.nanjid.onlineshop2.service;

import odko.nanjid.onlineshop2.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(int id);
}
