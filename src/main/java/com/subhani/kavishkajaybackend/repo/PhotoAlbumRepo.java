package com.subhani.kavishkajaybackend.repo;

import com.subhani.kavishkajaybackend.entity.PhotoAlbum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoAlbumRepo extends JpaRepository<PhotoAlbum, Long>
{
    List<PhotoAlbum> findByCategoryId(Long categoryId);
}
