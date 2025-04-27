package com.subhani.kavishkajaybackend.mapper;

import com.subhani.kavishkajaybackend.dto.*;
import com.subhani.kavishkajaybackend.entity.PhotoAlbum;
import com.subhani.kavishkajaybackend.entity.PortfolioCategory;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PortfolioMapper {

    // Category Mappings
    @Mapping(target = "categoryName", source = "categoryName")
    CategoryDTO toCategoryDTO(PortfolioCategory category);

    // Album Mappings
    @Mapping(target = "albumId", source = "albumId")
    @Mapping(target = "albumName", source = "name")
    @Mapping(target = "publishedDate", source = "publishedDate")
    AlbumDTO toAlbumDTO(PhotoAlbum album);

    @Mapping(target = "albumId", source = "albumId")
    @Mapping(target = "albumName", source = "name")
    AlbumDetailsDTO toAlbumDetailsDTO(PhotoAlbum album);

    @Mapping(target = "name", source = "albumName")
    PhotoAlbum toPhotoAlbum(CreateAlbumDTO dto, @Context PortfolioCategory categoryName);


    // For a single category with list of albums
    @Mapping(target = "categoryId", source = "id")
    @Mapping(target = "categoryName", source = "categoryName")
    @Mapping(target = "albums", expression = "java(toAlbumDTOList(category.getAlbums()))")
    CategoryWithAlbumsDTO toCategoryWithAlbumsDTO(PortfolioCategory category);

    // List conversions
    List<CategoryDTO> toCategoryDTOList(List<PortfolioCategory> categories);
    List<AlbumDTO> toAlbumDTOList(List<PhotoAlbum> albums);


}
