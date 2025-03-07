package com.generation.projeto_integrador1_grupo1.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projeto_integrador1_grupo1.model.Colaborador;
import com.generation.projeto_integrador1_grupo1.repository.ColaboradorRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaboradores")
@CrossOrigin(allowedHeaders = "", origins = "")
public class ColaboradorController {

	@Autowired 
    private ColaboradorRepository colaboradorRepository;
	
	//GET
	@GetMapping
	public ResponseEntity<List<Colaborador>> getAll() {
		return ResponseEntity.ok(colaboradorRepository.findAll()); 
    
	}
	
	//GET ID
	@GetMapping("/{id}")
    public ResponseEntity<Colaborador> getById(@PathVariable Long id) {
        return colaboradorRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	//GET NOME
	@GetMapping("/nome/{nome}")
    public ResponseEntity<List<Colaborador>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(colaboradorRepository.findAllByNomeContainingIgnoreCase(nome));
    }
	
	//POST
	@PostMapping
    public ResponseEntity<Colaborador> post(@Valid @RequestBody Colaborador colaborador) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(colaboradorRepository.save(colaborador));
	}
	
	//PUT
	@PutMapping
    public ResponseEntity<Colaborador> put(@Valid @RequestBody Colaborador colaborador) { 
		return colaboradorRepository.findById(colaborador.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(colaboradorRepository.save(colaborador)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    } 

	@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isEmpty()) 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        	colaboradorRepository.deleteById(id); 
    }
}


