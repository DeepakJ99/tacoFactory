package com.example.tacofactory.repo;


import com.example.tacofactory.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    public User findByEmail(String email);
}
