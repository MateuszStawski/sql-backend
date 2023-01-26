package pl.stawski.sql.basket.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import pl.stawski.sql.products.model.ProductEntity;

import java.util.List;

@Entity
@Table(name = "bakset")
@Data
public class BasketEntity {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @ManyToMany
    private List<ProductEntity> productEntityList;


}
