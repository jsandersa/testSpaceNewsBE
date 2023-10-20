package com.jsa.news.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsa.news.springboot.model.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

}
