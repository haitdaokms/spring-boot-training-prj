package com.kms.training.trainingproject.mapper;

import com.kms.training.trainingproject.dto.BookDTO;
import com.kms.training.trainingproject.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO entityToDto(BookEntity bookEntity);

    @Mapping(target = "id", ignore = true)
    BookEntity dtoToEntity(BookDTO dto);
}
