package com.project.book.repository;

import com.project.book.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books,Integer>{
    Optional<Books> getBooksByName(String bookName);
}
