package com.glowcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.glowcare.dto.ArticleDto;
import com.glowcare.dto.ProductDto;
import com.glowcare.dto.ReviewDto;
import com.glowcare.dto.RoutineDto;
import com.glowcare.dto.UserDto;
import com.glowcare.service.ArticleService;
import com.glowcare.service.ProductService;
import com.glowcare.service.ReviewService;
import com.glowcare.service.RoutineService;
import com.glowcare.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class GlowCareController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private RoutineService routineService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ArticleService articleService;


    // ================= USER =================

    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody UserDto user) {
        return userService.login(user);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public UserDto updateUser(@PathVariable Long id,
                              @RequestBody UserDto user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }


    // ================= PRODUCTS =================

    @PostMapping("/products")
    public ProductDto addProduct(@RequestBody ProductDto product) {
        return productService.addProduct(product);
    }

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/products/search/{name}")
    public List<ProductDto> searchProducts(@PathVariable String name) {
        return productService.searchProducts(name);
    }

    @GetMapping("/products/category/{category}")
    public List<ProductDto> getByCategory(@PathVariable String category) {
        return productService.getByCategory(category);
    }

    @GetMapping("/products/skin/{skinType}")
    public List<ProductDto> getBySkinType(@PathVariable String skinType) {
        return productService.getBySkinType(skinType);
    }

    @PutMapping("/products/{id}")
    public ProductDto updateProduct(@PathVariable Long id,
                                    @RequestBody ProductDto product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }


    // ================= ROUTINES =================

    @PostMapping("/routines")
    public RoutineDto addRoutine(@RequestBody RoutineDto routine) {
        return routineService.addRoutine(routine);
    }

    @GetMapping("/routines")
    public List<RoutineDto> getAllRoutines() {
        return routineService.getAllRoutines();
    }

    @GetMapping("/routines/user/{userId}")
    public List<RoutineDto> getUserRoutines(@PathVariable Long userId) {
        return routineService.getUserRoutines(userId);
    }

    @PutMapping("/routines/{id}")
    public RoutineDto updateRoutine(@PathVariable Long id,
                                    @RequestBody RoutineDto routine) {
        return routineService.updateRoutine(id, routine);
    }

    @DeleteMapping("/routines/{id}")
    public String deleteRoutine(@PathVariable Long id) {
        routineService.deleteRoutine(id);
        return "Routine deleted successfully";
    }


    // ================= REVIEWS =================

    @PostMapping("/reviews")
    public ReviewDto addReview(@RequestBody ReviewDto review) {
        return reviewService.addReview(review);
    }

    @GetMapping("/reviews/product/{productId}")
    public List<ReviewDto> getProductReviews(@PathVariable Long productId) {
        return reviewService.getProductReviews(productId);
    }

    @DeleteMapping("/reviews/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "Review deleted successfully";
    }


    // ================= ARTICLES =================

    @PostMapping("/articles")
    public ArticleDto addArticle(@RequestBody ArticleDto article) {
        return articleService.addArticle(article);
    }

    @GetMapping("/articles")
    public List<ArticleDto> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/articles/{id}")
    public ArticleDto getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @PutMapping("/articles/{id}")
    public ArticleDto updateArticle(@PathVariable Long id,
                                    @RequestBody ArticleDto article) {
        return articleService.updateArticle(id, article);
    }

    @DeleteMapping("/articles/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "Article deleted successfully";
    }
}