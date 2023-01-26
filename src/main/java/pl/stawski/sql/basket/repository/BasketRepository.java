package pl.stawski.sql.basket.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.stawski.sql.basket.model.BasketEntity;
import pl.stawski.sql.products.model.ProductEntity;

@Repository
public interface BasketRepository extends JpaRepository<BasketEntity, Long> {


}
