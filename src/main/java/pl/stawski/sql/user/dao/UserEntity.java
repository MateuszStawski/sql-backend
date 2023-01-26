package pl.stawski.sql.user.dao;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String address;

    public UserEntity(String email, String password, String firstName, String lastName, Date birthDate, String address) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public UserEntity() {

    }
}
