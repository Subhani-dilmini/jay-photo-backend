package com.subhani.kavishkajaybackend.mapper;

import com.subhani.kavishkajaybackend.dto.BlogDTO;
import com.subhani.kavishkajaybackend.entity.Blog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BlogMapper {

    BlogMapper INSTANCE = Mappers.getMapper(BlogMapper.class);

    BlogDTO blogToBlogDTO(Blog blog);

    Blog blogDTOToBlog(BlogDTO blogDTO);
}
