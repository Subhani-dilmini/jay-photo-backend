package com.subhani.kavishkajaybackend.mapper;

import com.subhani.kavishkajaybackend.dto.AddPackageRequestDto.ItemDto;
import com.subhani.kavishkajaybackend.dto.AddPackageRequestDto.PackageItemDto;
import com.subhani.kavishkajaybackend.entity.PackageItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PackageMapper {

    ItemDto toDto(PackageItem item);
    PackageItem toEntity(ItemDto dto);

    List<ItemDto> toDtoList(List<PackageItem> items);
    List<PackageItem> toEntityList(List<ItemDto> dtos);

    PackageItemDto toPackageItemDto(PackageItem item);
}
