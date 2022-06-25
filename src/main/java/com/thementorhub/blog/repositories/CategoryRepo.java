package com.thementorhub.blog.repositories;

import com.thementorhub.blog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
