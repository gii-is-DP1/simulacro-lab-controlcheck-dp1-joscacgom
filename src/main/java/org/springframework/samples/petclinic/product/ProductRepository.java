package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;




public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
    @Query("SELECT productType FROM ProductType productType")
    public List<ProductType> findAllProductTypes();
    
    Optional<Product> findById(int id);
    Product findByName(String name);

	
	  @Query("SELECT productType FROM ProductType productType WHERE productType.name = ?1")
	  ProductType findProductTypeByName(String name);
	
    @Query("SELECT product  FROM Product product WHERE product.price <?1")
    List<Product> findByPriceLessThan(double price);
}
