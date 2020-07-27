package com.insumostecnologicos.vo.response;

import com.insumostecnologicos.entity.ProductInfo;
import org.springframework.data.domain.Page;

/**
 * The type Category page.
 */
public class CategoryPage {
    private String category;
    private Page<ProductInfo> page;

    /**
     * Instantiates a new Category page.
     *
     * @param category the category
     * @param page     the page
     */
    public CategoryPage(String category, Page<ProductInfo> page) {
        this.category = category;
        this.page = page;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets page.
     *
     * @return the page
     */
    public Page<ProductInfo> getPage() {
        return page;
    }

    /**
     * Sets page.
     *
     * @param page the page
     */
    public void setPage(Page<ProductInfo> page) {
        this.page = page;
    }
}
