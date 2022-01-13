package org.springframework.samples.petclinic.product;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.product.Product;
import org.springframework.samples.petclinic.product.ProductService;
import org.springframework.samples.petclinic.product.ProductType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
	private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";
	
	@Autowired
	private  ProductService productService;

	 @GetMapping(path="/product/create")
		public String initCreationForm(Map<String, Object> model) {
			Product p = new Product();
			List<ProductType>ls=this.productService.findAllProductTypes();
			model.put("product", p);
			model.put("productType", ls);
			return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
		}

		@PostMapping(path="/product/create")
		public String processCreationForm(@Valid Product p, BindingResult result,ModelMap modelMap) {
			String view="welcome";
			if (result.hasErrors()) {
				modelMap.addAttribute("product",p);
				modelMap.addAttribute("productType",productService.findAllProductTypes());
				return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
			}
			else {
				//creating owner, user and authorities
				this.productService.save(p);
				modelMap.addAttribute("message","Product succesfully saved!");
				
			}
			return view;
		}
}