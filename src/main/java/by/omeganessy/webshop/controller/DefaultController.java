package by.omeganessy.webshop.controller;

import by.omeganessy.webshop.entity.Category;
import by.omeganessy.webshop.entity.Product;
import by.omeganessy.webshop.repository.CategoryRepository;
import by.omeganessy.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DefaultController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<Category> categories = categoryRepository.findAll();
        Map<Category, List<Product>> map = new HashMap<>();
        categories.forEach(category -> map.put(category,productRepository.findByCategory(category)));
        model.addAttribute("categories",categories);
        model.addAttribute("map",map);
        return "index";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        return "cart";
    }
}
