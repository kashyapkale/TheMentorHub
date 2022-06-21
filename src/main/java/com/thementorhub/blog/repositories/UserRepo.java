package com.thementorhub.blog.repositories;

import com.thementorhub.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
