package ru.vtb.javapro.homework.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.javapro.homework.model.ProductResponse;
import ru.vtb.javapro.homework.service.UserProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    public ProductController(UserProductService userProductService) {
        this.userProductService = userProductService;
    }

    UserProductService userProductService;

    @GetMapping("/user")
    public ProductResponse getProductByUser(@RequestParam Integer userId) {
        return userProductService.getUserById(userId);
    }

    @GetMapping("/product")
    public ProductResponse getProductByProduct(@RequestParam Integer productId) {
        return userProductService.getProductsById(productId);
    }
}
