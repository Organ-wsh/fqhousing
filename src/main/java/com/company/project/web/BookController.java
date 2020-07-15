package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Book;
import com.company.project.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2020/05/15.
*/
@RestController
@RequestMapping("/book")
@Api(value = "书籍controller",tags = {"书籍操作接口"})
public class BookController {
    @Resource
    private BookService bookService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @ApiOperation(value = "添加书籍信息接口",notes = "提示接口使用者注意事项",httpMethod = "POST")
    /*@ApiImplicitParam( dataType = "string",name = "book",value = "book实体类信息",paramType = "body",required = true)*/
    @PostMapping("/add")
    public Result add(@RequestBody Book book) {
        bookService.save(book);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除书籍信息接口",notes = "根据Id删除书籍",httpMethod = "DELETE")
    public Result delete(@PathVariable Integer id) {
        bookService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ApiOperation(value = "更新书籍信息接口",notes = "更新书籍信息",httpMethod = "PUT")
    public Result update(@RequestBody Book book) {
        bookService.update(book);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取书籍信息接口",notes = "根据书籍Id获取书籍信息",httpMethod = "GET")
    @Cacheable(cacheNames = "c1")
    public Result detail(@PathVariable Integer id) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>数据库中获取数据<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Book book = bookService.findById(id);
        return ResultGenerator.genSuccessResult(book);
    }

    @GetMapping
    @ApiOperation(value = "获取书籍信息集合接口",notes = "获取书籍信息集合接口",httpMethod = "GET")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Book> list = bookService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @PostMapping("/getBookByQuery")
    @ApiOperation(value = "获取书籍信息接口",notes = "根据书籍Id获取书籍信息",httpMethod = "GET")
    public Result getBookByQuery(@RequestBody Book queryBook) {
        System.out.println("测试6");
        Book book = bookService.findByBook(queryBook);
        return ResultGenerator.genSuccessResult(book);
    }
}
