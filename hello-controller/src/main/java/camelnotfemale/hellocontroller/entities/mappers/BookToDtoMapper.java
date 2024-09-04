package camelnotfemale.hellocontroller.entities.mappers;

import camelnotfemale.hellocontroller.entities.Book;
import camelnotfemale.hellocontroller.entities.AddBookRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToDtoMapper {
    Book AddBookRequestToBook(AddBookRequest addBookRequest);
}