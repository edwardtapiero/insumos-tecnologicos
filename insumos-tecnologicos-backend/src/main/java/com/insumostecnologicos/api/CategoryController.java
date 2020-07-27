package com.insumostecnologicos.api;


import com.insumostecnologicos.entity.ProductCategory;
import com.insumostecnologicos.entity.ProductInfo;
import com.insumostecnologicos.service.CategoryService;
import com.insumostecnologicos.service.ProductService;
import com.insumostecnologicos.vo.response.CategoryPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * The type Category controller.
 */
@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    /**
     * The Product service.
     */
    @Autowired
    ProductService productService;

    /**
     * Show one category page.
     *
     * @param categoryType the category type
     * @param page         the page
     * @param size         the size
     * @return the category page
     */
    @GetMapping("/category/{type}")
    public CategoryPage showOne(@PathVariable("type") Integer categoryType,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "3") Integer size) {

        ProductCategory cat = categoryService.findByCategoryType(categoryType);
        PageRequest request = PageRequest.of(page - 1, size);
        Page<ProductInfo> productInCategory = productService.findAllInCategory(categoryType, request);
        CategoryPage tmp = new CategoryPage("", productInCategory);
        tmp.setCategory(cat.getCategoryName());
        return tmp;
    }
}
