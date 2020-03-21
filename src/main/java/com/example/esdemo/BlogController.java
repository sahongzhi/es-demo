package com.example.esdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: SaHongzhi
 * @Date: 2020-03-21 9:50
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogService blogService;

    @PostMapping("/add")
    public Map add(@RequestBody BlogModel blogModel) {
        BlogModel blogModel1=blogRepository.save(blogModel);
        return Result.success(blogModel1);
    }


    @GetMapping("/get/{id}")
    public Map getById(@PathVariable String id) {
        if (StringUtils.isEmpty(id))
            return Result.error();
        Optional<BlogModel> blogModelOptional = blogRepository.findById(id);
        if (blogModelOptional.isPresent()) {
            BlogModel blogModel = blogModelOptional.get();
            return Result.success(blogModel);
        }
        return Result.error();
    }

    @GetMapping("/get")
    public Map getAll() {
        Iterable<BlogModel> iterable = blogRepository.findAll();
        List<BlogModel> list = new ArrayList<>();
        iterable.forEach(list::add);
        return Result.success(list);
    }

    @PostMapping("/update")
    public Map updateById(@RequestBody BlogModel blogModel) {
        String id = blogModel.getId();
        if (StringUtils.isEmpty(id))
            return Result.error();
        blogRepository.save(blogModel);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Map deleteById(@PathVariable String id) {
        if (StringUtils.isEmpty(id))
            return Result.error();
        blogRepository.deleteById(id);
        return Result.success();
    }

    /**
     * 根据条件查询
     * @param title
     * @return
     */
    @GetMapping("/findByCondition/{title}")
    public Map findByCondition(@PathVariable String title) {
        return Result.success(blogService.getBlogs(title));
    }


}
