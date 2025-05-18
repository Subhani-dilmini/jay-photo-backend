package com.subhani.kavishkajaybackend.service;

import com.subhani.kavishkajaybackend.dto.BlogDTO;
import com.subhani.kavishkajaybackend.entity.Blog;
import com.subhani.kavishkajaybackend.mapper.BlogMapper;
import com.subhani.kavishkajaybackend.repo.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepo blogRepository;

    @Autowired
    private BlogMapper blogMapper;

    // GET all blogs
    public List<BlogDTO> getAllBlogs() {
        return blogRepository.findAll().stream()
                .map(blogMapper::blogToBlogDTO)
                .toList();
    }

    // GET a specific blog by ID
    public BlogDTO getBlog(Long blogId) {
        Optional<Blog> blog = blogRepository.findById(blogId);
        return blog.map(blogMapper::blogToBlogDTO).orElse(null);
    }

    // POST (Add) a new blog
    public BlogDTO addBlog(BlogDTO blogDTO) {
        Blog blog = blogMapper.blogDTOToBlog(blogDTO);
        blog = blogRepository.save(blog);
        return blogMapper.blogToBlogDTO(blog);
    }

    // PUT (Update) a specific blog
    public BlogDTO updateBlog(Long blogId, BlogDTO blogDTO) {
        Optional<Blog> existingBlog = blogRepository.findById(blogId);
        if (existingBlog.isPresent()) {
            Blog blog = existingBlog.get();
            blog.setTitle(blogDTO.getTitle());
            blog.setDescription(blogDTO.getDescription());
            blog.setPublishedDate(blogDTO.getPublishedDate());
            blog = blogRepository.save(blog);
            return blogMapper.blogToBlogDTO(blog);
        }
        return null; // Blog not found
    }

    // DELETE a specific blog
    public String deleteBlog(Long blogId) {
        if (blogRepository.existsById(blogId)) {
            blogRepository.deleteById(blogId);
            return "Blog deleted successfully";
        }
        return "Blog not found";
    }
}
