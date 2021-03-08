package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmdb.business.Actor;
import com.bmdb.db.ActorRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/actors")

public class ActorController {

	@Autowired
	private ActorRepo actorRepo;
	
	@GetMapping("/")
	public List<Actor> getAll() {
		return actorRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Actor getById(@PathVariable int id) {
		return actorRepo.findById(id).get();
		
	}
	@PostMapping("/") 
	public Actor create(@RequestBody Actor actor) {
		return actorRepo.save(actor);
		
	}
		
	@PutMapping("/") 
	public Actor update(@RequestBody Actor actor) {
		return actorRepo.save(actor);
		
	}
		
	@DeleteMapping("/{id}") 
	public Actor delete(@PathVariable int id) {
		Optional<Actor> actor = actorRepo.findById(id);
		if (actor.isPresent()) {
			actorRepo.delete(actor.get());
		}
		else {
			System.out.println("Delete Error - actor not found for id: "+id);
		}
		return actor.get();
		
	}
}
