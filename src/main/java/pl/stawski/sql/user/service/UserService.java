package pl.stawski.sql.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stawski.sql.user.repository.UserRepository;
import pl.stawski.sql.user.dao.UserEntity;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserEntity userEntity){
        UserEntity user = new UserEntity();
        user.setAddress(userEntity.getAddress());
        user.setEmail(userEntity.getEmail());
        user.setBirthDate(userEntity.getBirthDate());
        user.setPassword(userEntity.getPassword());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        userRepository.save(user);
    }
}
