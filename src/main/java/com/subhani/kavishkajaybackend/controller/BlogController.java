package com.subhani.kavishkajaybackend.controller;

import com.subhani.kavishkajaybackend.dto.BlogDTO;
import com.subhani.kavishkajaybackend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    // GET all blogs
    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getAllBlogs() {
        List<BlogDTO> blogs = blogService.getAllBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    // GET a specific blog
    @GetMapping("/blogs/{blogId}")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable Long blogId) {
        BlogDTO blogDTO = blogService.getBlog(blogId);
        if (blogDTO != null) {
            return new ResponseEntity<>(blogDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // POST (Add) a new blog
    @PostMapping("/blogs/{blogId}")
    public ResponseEntity<BlogDTO> addBlog(@RequestBody BlogDTO blogDTO) {
        BlogDTO newBlog = blogService.addBlog(blogDTO);
        return new ResponseEntity<>(newBlog, HttpStatus.CREATED);
    }

    // PUT (Update) a specific blog
    @PutMapping("/blogs/{blogId}")
    public ResponseEntity<BlogDTO> updateBlog(@PathVariable Long blogId, @RequestBody BlogDTO blogDTO) {
        BlogDTO updatedBlog = blogService.updateBlog(blogId, blogDTO);
        if (updatedBlog != null) {
            return new ResponseEntity<>(updatedBlog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE a specific blog
    @DeleteMapping("/blogs/{blogId}")
    public ResponseEntity<String> deleteBlog(@PathVariable Long blogId) {
        String message = blogService.deleteBlog(blogId);
        if (message.equals("Blog deleted successfully")) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
