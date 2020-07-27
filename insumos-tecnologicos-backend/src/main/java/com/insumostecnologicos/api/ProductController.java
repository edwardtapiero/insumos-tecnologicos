package com.insumostecnologicos.api;

import com.insumostecnologicos.entity.ProductInfo;
import com.insumostecnologicos.service.CategoryService;
import com.insumostecnologicos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Product controller.
 */
@CrossOrigin
@RestController
public class ProductController {
    /**
     * The Category service.
     */
    @Autowired
    CategoryService categoryService;
    /**
     * The Product service.
     */
    @Autowired
    ProductService productService;

    /**
     * Find all page.
     *
     * @param page the page
     * @param size the size
     * @return the page
     */
    @GetMapping("/product")
    public Page<ProductInfo> findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "3") Integer size) {
        PageRequest request = PageRequest.of(page - 1, size);
        return productService.findAll(request);
    }

    /**
     * Show one product info.
     *
     * @param productId the product id
     * @return the product info
     */
    @GetMapping("/product/{productId}")
    public ProductInfo showOne(@PathVariable("productId") String productId) {

        ProductInfo productInfo = productService.findOne(productId);

        return productInfo;
    }

    /**
     * Create response entity.
     *
     * @param product       the product
     * @param bindingResult the binding result
     * @return the response entity
     */
    @PostMapping("/seller/product/new")
    public ResponseEntity create(@Valid @RequestBody ProductInfo product,
                                 BindingResult bindingResult) {
        ProductInfo productIdExists = productService.findOne(product.getProductId());
        if (productIdExists != null) {
            bindingResult
                    .rejectValue("productId", "error.product",
                            "There is already a product with the code provided");
        }
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }
        return ResponseEntity.ok(productService.save(product));
    }

    /**
     * Edit response entity.
     *
     * @param productId     the product id
     * @param product       the product
     * @param bindingResult the binding result
     * @return the response entity
     */
    @PutMapping("/seller/product/{id}/edit")
    public ResponseEntity edit(@PathVariable("id") String productId,
                               @Valid @RequestBody ProductInfo product,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }
        if (!productId.equals(product.getProductId())) {
            return ResponseEntity.badRequest().body("Id Not Matched");
        }

        return ResponseEntity.ok(productService.update(product));
    }

    /**
     * Delete response entity.
     *
     * @param productId the product id
     * @return the response entity
     */
    @DeleteMapping("/seller/product/{id}/delete")
    public ResponseEntity delete(@PathVariable("id") String productId) {
        productService.delete(productId);
        return ResponseEntity.ok().build();
    }

}
