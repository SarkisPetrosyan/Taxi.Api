package me.salisuwy;

import me.salisuwy.entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

    final private BlogRepository blogRepository;

    @Autowired
    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping("/blog")
    public List<Blog> index(){
        return blogRepository.findAll();
    }

    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogRepository.findOne(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        //return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
        return null;
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body){
        Blog blog = new Blog();
        blog.setTitle(body.get("title"));
        blog.setDescription(body.get("content"));
        return blogRepository.save(blog);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
        int blogId = Integer.parseInt(id);
        Blog blog = blogRepository.findOne(blogId);
        blog.setTitle(body.get("title"));
        blog.setDescription(body.get("content"));
        return blogRepository.save(blog);
    }

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        blogRepository.delete(blogId);
        return true;
    }
}