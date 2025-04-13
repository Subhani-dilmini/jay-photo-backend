package com.subhani.kavishkajaybackend.dto;

import java.time.LocalDate;

public class AlbumDTO {

    private Long albumId;
    private String albumName;
    private LocalDate publishedDate;

    public AlbumDTO() {
    }

    public AlbumDTO(Long albumId, String albumName, LocalDate publishedDate) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.publishedDate = publishedDate;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
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
