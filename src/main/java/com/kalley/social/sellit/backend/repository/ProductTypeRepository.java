package com.kalley.social.sellit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kalley.social.sellit.backend.entity.ProductType;

/**
 * Defines the connection with the repository for the class {@link ProductType}.
 * 
 * @author Kálley Wilkerson
 */
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

}
