package com.project.book.service;


import com.project.book.model.Books;
import com.project.book.repository.BookRepository;
import com.project.commonModule.models.Role;
import com.project.commonModule.services.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;
    private final CommonService commonService= new CommonService(new RestTemplate());


    public List<Books> viewBooks(String token){

        String workflowName="read-book";
        if(commonService.isEligable(workflowName,token)){
            return repository.findAll();
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    public List<Books> createBook(List<Books> books,String token){
        String workflowName="create-book";
        if(commonService.isEligable(workflowName, token)){
            return repository.saveAll(books);
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    public void deleteBooks(List<String> bookNames,String token){
        String workflowName="delete-book";
        if(commonService.isEligable(workflowName, token)){
            List<Books> booksList = null;
            for(String bookName: bookNames) {
                booksList.add(repository.getBooksByName(bookName).get());
            }
            repository.deleteAll(booksList);
        }
    }

}
