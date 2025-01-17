package com.jtavarez.springbootcrudexamplethymeleafmysql.controller;

import com.jtavarez.springbootcrudexamplethymeleafmysql.models.Product;
import com.jtavarez.springbootcrudexamplethymeleafmysql.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
  @Autowired
  private ProductService service;

  // handler methods...
  @RequestMapping("/")
  public String viewHomePage(Model model) {
    List<Product> listProducts = service.listAllProducts();
    model.addAttribute("listProducts", listProducts);
    return "index";
  }
  @RequestMapping("/new")
  public String showNewProductPage(Model model) {
    Product product = new Product();
    model.addAttribute("product", product);

    return "new_product";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveProduct(@ModelAttribute("product") Product product) {
    service.saveProduct(product);

    return "redirect:/";
  }

  @RequestMapping("/edit/{id}")
  public ModelAndView showEditProductPage(@PathVariable(name = "id") long id) {
    ModelAndView mav = new ModelAndView("edit_product");
    Product product = service.findProductById(id);
    mav.addObject("product", product);

    return mav;
  }

  @RequestMapping("/delete/{id}")
  public String deleteProduct(@PathVariable(name = "id") long id) {
    service.deleteProduct(id);
    return "redirect:/";
  }

}
