package com.kms.training.trainingproject.service;

import com.kms.training.trainingproject.dto.BookDTO;
import com.kms.training.trainingproject.entity.BookEntity;
import com.kms.training.trainingproject.mapper.BookMapper;
import com.kms.training.trainingproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookMapper mapper;

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        return mapper.entityToDto(bookRepository.save(mapper.dtoToEntity(bookDTO)));
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        BookEntity oldBook = bookRepository.getById(bookDTO.getBookId());
        BookEntity newBook = mapper.dtoToEntity(bookDTO);
        oldBook.setBookName(newBook.getBookName());
        oldBook.setAuthor(newBook.getAuthor());
        oldBook.setDeleted(newBook.isDeleted());
        return mapper.entityToDto(bookRepository.save(oldBook));
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookEntity -> mapper.entityToDto(bookEntity))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long bookId) {
        return mapper.entityToDto(bookRepository.getById(bookId));
    }
}
