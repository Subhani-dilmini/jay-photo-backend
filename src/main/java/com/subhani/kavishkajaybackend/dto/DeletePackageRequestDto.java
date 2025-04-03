package com.subhani.kavishkajaybackend.dto;

//Deleting a Package (Delete DTO)
public class DeletePackageRequestDto {

    private Long packageId;

    public DeletePackageRequestDto(Long packageId) {
        this.packageId = packageId;
    }

    public DeletePackageRequestDto() {
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }
}
