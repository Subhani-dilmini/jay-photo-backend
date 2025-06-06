package com.subhani.kavishkajaybackend.controller;

import com.subhani.kavishkajaybackend.dto.*;
import com.subhani.kavishkajaybackend.service.PortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    private final PortfolioService service;

    public PortfolioController(PortfolioService service) {
        this.service = service;
    }



    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/categories/{categoryId}")
    public CategoryDTO getCategoryDetails(@PathVariable Long categoryId) {
        return service.getCategoryDetails(categoryId);
    }


    @GetMapping("/categories/{categoryId}/albums")
    public CategoryWithAlbumsDTO getAlbumsByCategory(@PathVariable Long categoryId) {
        return service.getAlbumsByCategoryId(categoryId);
    }

    @PostMapping("/categories/{categoryId}/albums")
    public ResponseEntity<String> addAlbum(@PathVariable Long categoryId,
                                           @RequestBody CreateAlbumDTO dto) {
        service.addAlbum(categoryId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Album added");
    }

    @PostMapping("/categories")
    public ResponseEntity<String> addCategory(@RequestBody CreateCategoryDTO dto) {
        service.addCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category added");
    }

    @GetMapping("/albums/{albumId}")
    public AlbumDetailsDTO getAlbum(@PathVariable Long albumId) {
        return service.getAlbum(albumId);
    }



//    @DeleteMapping("/albums/{albumId}")
//    public ResponseEntity<String> deleteAlbum(@PathVariable Long albumId) {
//        service.deleteAlbum(albumId);
//        return ResponseEntity.ok("Album deleted");
//    }

}
