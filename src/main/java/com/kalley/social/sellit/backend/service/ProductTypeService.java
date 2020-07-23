package com.kalley.social.sellit.backend.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.kalley.social.sellit.backend.entity.ProductType;
import com.kalley.social.sellit.backend.repository.ProductTypeRepository;

/**
 * Defines service methods to access the {@link ProductType} database.
 * 
 * @author Kálley Wilkerson
 */
@Service
public class ProductTypeService {

	/**
	 * To log information.
	 */
	private static final Logger LOGGER = Logger.getLogger(ProductTypeService.class.getName());
	
	/**
	 * Repository of {@link ProductType}.
	 */
	private ProductTypeRepository prodTypeRepo;

	public ProductTypeService(ProductTypeRepository prodTypeRepo) {
		this.prodTypeRepo = prodTypeRepo;
	}
	
	public List<ProductType> findAll() {
		return prodTypeRepo.findAll();
	}
	
	public List<ProductType> findAll(String name) {
		if (name == null || name.isEmpty()) {
			return prodTypeRepo.findAll();
		} else {
			return prodTypeRepo.search(name);
		}
	}
	
	public long count() {
		return prodTypeRepo.count();
	}
	
	public void delete(ProductType type) {
		prodTypeRepo.delete(type);
	}
	
	public void save(ProductType type) {
		if (type == null) {
			LOGGER.log(Level.SEVERE, "Product type is null.");
		}
		prodTypeRepo.save(type);
	}
	
	@PostConstruct
	public void populateTestData() {
		if (prodTypeRepo.count() == 0) {
			prodTypeRepo.saveAll(
					Stream.of("Books", "Eletronics", "Transport").map(ProductType::new).collect(Collectors.toList()));
		}
	}

}
