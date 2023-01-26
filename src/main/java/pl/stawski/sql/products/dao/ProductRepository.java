package pl.stawski.sql.products.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.stawski.sql.products.model.ProductEntity;
import pl.stawski.sql.user.dao.UserEntity;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {



    @Query(value = "SELECT * FROM product WHERE name = :name", nativeQuery = true)
    List<ProductEntity> getAllByName(@Param("name") String name);

    @Query(value = "SELECT * FROM product WHERE category = :category", nativeQuery = true)
    List<ProductEntity> getAllByCategory(@Param("category") String category);

    @Query(value = "SELECT * FROM product WHERE category = :category and name = :name", nativeQuery = true)
    List<ProductEntity> getAllByFilters(@Param("name") String name, @Param("category") String category);


}
