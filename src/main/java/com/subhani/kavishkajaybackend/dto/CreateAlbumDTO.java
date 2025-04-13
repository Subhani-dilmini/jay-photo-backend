package com.subhani.kavishkajaybackend.dto;

import java.time.LocalDate;

public class CreateAlbumDTO {

    private String albumName;
    private LocalDate publishedDate;

    public CreateAlbumDTO() {
    }

    public CreateAlbumDTO(String albumName, LocalDate publishedDate) {
        this.albumName = albumName;
        this.publishedDate = publishedDate;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
