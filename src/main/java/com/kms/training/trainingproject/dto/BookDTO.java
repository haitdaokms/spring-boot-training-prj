package com.kms.training.trainingproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private Long bookId;
    private String bookName;
    private String author;
    private boolean isDeleted;
}
