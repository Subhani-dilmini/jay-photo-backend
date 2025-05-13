package com.subhani.kavishkajaybackend.service;

import com.subhani.kavishkajaybackend.dto.*;
import com.subhani.kavishkajaybackend.entity.PhotoAlbum;
import com.subhani.kavishkajaybackend.entity.PortfolioCategory;
import com.subhani.kavishkajaybackend.mapper.PortfolioMapper;
import com.subhani.kavishkajaybackend.repo.PhotoAlbumRepo;
import com.subhani.kavishkajaybackend.repo.PortfolioCategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    private final PortfolioCategoryRepo categoryRepository;
    private final PhotoAlbumRepo albumRepository;
    private final PortfolioMapper mapper;


    public PortfolioService(PortfolioCategoryRepo categoryRepository,
                            PhotoAlbumRepo albumRepository,
                            PortfolioMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.albumRepository = albumRepository;
        this.mapper = mapper;
    }

    public List<CategoryDTO> getAllCategories() {
        return mapper.toCategoryDTOList(categoryRepository.findAll());
    }

    public CategoryDTO getCategoryDetails(Long categoryId) {
        return mapper.toCategoryDTO(categoryRepository.findById( categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found")));

    }

    public CategoryWithAlbumsDTO getAlbumsByCategoryId(Long categoryId) {
        PortfolioCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return mapper.toCategoryWithAlbumsDTO(category);
    }


    public void addAlbum(Long categoryId, CreateAlbumDTO dto) {
        PortfolioCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        PhotoAlbum album = mapper.toPhotoAlbum(dto, category);
        albumRepository.save(album);
    }

    public void addCategory(CreateCategoryDTO dto) {
        PortfolioCategory category = mapper.toCategory(dto);
        categoryRepository.save(category);
    }

    public AlbumDetailsDTO getAlbum(Long albumId) {
        PhotoAlbum album = albumRepository.findById(albumId)
                .orElseThrow(() -> new RuntimeException("Album not found"));
        return mapper.toAlbumDetailsDTO(album);
    }

    public void deleteAlbum(Long albumId) {
        if (!albumRepository.existsById(albumId)) {
            throw new RuntimeException("Album not found");
        }
        albumRepository.deleteById(albumId);
    }


}
