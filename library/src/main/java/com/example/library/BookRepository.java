package com.example.library;

import org.springframework.data.jpa.repository.JpaRepository;
//JpaRepository interface contain inbuilt methods like save,findbyId,delete,etc.
public interface BookRepository extends JpaRepository<Book, Long> {
}
