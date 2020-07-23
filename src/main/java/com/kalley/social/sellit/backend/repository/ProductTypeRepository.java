package com.kalley.social.sellit.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kalley.social.sellit.backend.entity.ProductType;

/**
 * Defines the connection with the repository for the class {@link ProductType}.
 * 
 * @author Kálley Wilkerson
 */
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

	@Query("select p from ProductType p where lower(p.name) like lower(concat('%', :typeName, '%'))")
	public List<ProductType> search(@Param("typeName") String typeName);

}
