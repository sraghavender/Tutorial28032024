package com.raghavender.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghavender.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

}

