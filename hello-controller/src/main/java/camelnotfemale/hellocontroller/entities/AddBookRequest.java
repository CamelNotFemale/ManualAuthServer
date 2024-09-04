package camelnotfemale.hellocontroller.entities;

import lombok.Data;

@Data
public class AddBookRequest {
    private String author;
    private String title;
    private Double price;
}