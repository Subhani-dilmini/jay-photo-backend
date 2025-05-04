package com.subhani.kavishkajaybackend.mapper;

import com.subhani.kavishkajaybackend.dto.PackageAvailableItemDto;
import com.subhani.kavishkajaybackend.entity.PackageItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PackageMapper {

    // Single object mappings
    PackageAvailableItemDto toDto(PackageItem item);
    PackageItem toEntity(PackageAvailableItemDto dto);

    // List mappings
    List<PackageAvailableItemDto> toDtoList(List<PackageItem> items);
    List<PackageItem> toEntityList(List<PackageAvailableItemDto> dtos);
}
