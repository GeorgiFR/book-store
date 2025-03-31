package com.example.book_store.mapper;

import com.example.book_store.dto.request.BookRequest;
import com.example.book_store.dto.response.BookResponse;
import com.example.book_store.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    BookEntity requestToEntity(BookRequest request);

    BookEntity updateEntityFromRequest(BookRequest request, @MappingTarget BookEntity entity);

    BookResponse entityToResponse(BookEntity entity);
}
