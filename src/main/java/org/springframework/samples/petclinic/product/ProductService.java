package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ProductService {
	
	private ProductRepository productRepository;	

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}	
	
	
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return this.productRepository.findByPriceLessThan(price);
    }


	 public ProductType getProductType(String typeName) { 
		 return this.productRepository.findProductTypeByName(typeName);
		 
	 }
	 
	 public List<ProductType> findAllProductTypes(){
		 return this.productRepository.findAllProductTypes();
	 }
	 

  /*  public void save(Product p){
        productRepository.save(p);       
    } */
    public Product save(Product p){
        return productRepository.save(p);       
    }

    
}
