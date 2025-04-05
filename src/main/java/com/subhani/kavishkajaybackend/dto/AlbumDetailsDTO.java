package com.subhani.kavishkajaybackend.dto;

public class AlbumDetailsDTO {

    private Long albumId;
    private String albumName;

    public AlbumDetailsDTO() {
    }

    public AlbumDetailsDTO(Long albumId, String albumName) {
        this.albumId = albumId;
        this.albumName = albumName;
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
}
