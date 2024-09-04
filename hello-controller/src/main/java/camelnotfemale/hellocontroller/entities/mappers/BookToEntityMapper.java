package camelnotfemale.hellocontroller.entities.mappers;

import camelnotfemale.hellocontroller.entities.Book;
import camelnotfemale.hellocontroller.entities.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToEntityMapper {
    BookEntity bookToBookEntity(Book book);
    Book bookEntityToBook(BookEntity bookEntity);
}