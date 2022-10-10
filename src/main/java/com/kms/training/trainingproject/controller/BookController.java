package com.kms.training.trainingproject.controller;

import com.kms.training.trainingproject.dto.BookDTO;
import com.kms.training.trainingproject.entity.UserEntity;
import com.kms.training.trainingproject.repository.UserRepository;
import com.kms.training.trainingproject.service.BookService;
import com.kms.training.trainingproject.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordService passwordService;

    @PostMapping("/new")
    public BookDTO createNewBook(@RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    @PostMapping("/admin")
    public void createAdminAccount() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("admin");
        userEntity.setPassword(passwordService.passwordEncoder().encode("123123"));
        userRepository.save(userEntity);
    }

    @PutMapping("/update")
    public BookDTO updateBook(@RequestBody BookDTO bookDTO) {
        return bookService.updateBook(bookDTO);
    }

    @GetMapping("/list")
    public List<BookDTO> getBookList() {
        return bookService.getAllBooks();
    }

    @GetMapping("{bookId}")
    public BookDTO getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }
}
