package com.jsa.news.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsa.news.springboot.model.Noticia;
import com.jsa.news.springboot.repository.NoticiaRepository;


@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/api/noticias")
public class NoticiaController {
	
	@Autowired
	private NoticiaRepository noticiaRepository;
	
	@GetMapping(value = "")
	public List<Noticia> getAll() {
		return this.noticiaRepository.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Noticia> getById(@PathVariable long id) {
		Optional<Noticia> noticia = noticiaRepository.findById(id);

		if (noticia.isPresent()) {
			return new ResponseEntity<Noticia>(noticia.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Noticia>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Noticia> save(@RequestBody Noticia noticia) {
		Noticia obj = noticiaRepository.save(noticia);
		return new ResponseEntity<Noticia>(obj, HttpStatus.OK);
	}

	@PutMapping(value = "/save/{id}")
	public ResponseEntity<Noticia> saveById(@RequestBody Noticia noticia, @PathVariable long id) {

		Optional<Noticia> noticiaOpt = noticiaRepository.findById(id);

		if (!noticiaOpt.isPresent())
			return ResponseEntity.notFound().build();

		noticia.setId(id);
		noticiaRepository.save(noticia);

		return new ResponseEntity<Noticia>(noticia, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Noticia> delete(@PathVariable long id) {
		Optional<Noticia> noticia = noticiaRepository.findById(id);

		if (noticia.isPresent()) {
			noticiaRepository.delete(noticia.get());
		}
		else {
			return new ResponseEntity<Noticia>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Noticia>(noticia.get(), HttpStatus.OK);
	}
	
}
