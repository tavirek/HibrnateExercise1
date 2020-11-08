package com.example.inqoo.springbootcamp.hibernate.exercise1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ISBN;
    private String title;
    private Integer edition;
    private LocalDate editionDate;
    private String  coverType;
    private Integer pageCount;

    public Book(){

    }

    public Book(String ISBN, String title, Integer edition, LocalDate editionDate, String coverType, Integer pageCount) {
        this.ISBN = ISBN;
        this.title = title;
        this.edition = edition;
        this.editionDate = editionDate;
        this.coverType = coverType;
        this.pageCount = pageCount;
    }

    public Long getId() {
        return id;
    }

    public String getISBN() {
        return ISBN;
    }

    public Integer getEdition() {
        return edition;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getEditionDate() {
        return editionDate;
    }

    public String getCoverType() {
        return coverType;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEditionDate(LocalDate editionDate) {
        this.editionDate = editionDate;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", edition=" + edition +
                ", editionDate=" + editionDate +
                ", coverType='" + coverType + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }
}
