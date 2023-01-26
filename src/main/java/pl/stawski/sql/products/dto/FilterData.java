package pl.stawski.sql.products.dto;

import lombok.Data;

@Data
public class FilterData {

    private String token;
    private String name;
    private Integer from;
    private Integer to;


    // Wszystkie
    // Sauna
    // Kapie
    // Masaz
    private String category;

    private String sortType;
}
