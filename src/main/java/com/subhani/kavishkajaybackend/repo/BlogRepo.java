package com.subhani.kavishkajaybackend.repo;

import com.subhani.kavishkajaybackend.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long> {

}
