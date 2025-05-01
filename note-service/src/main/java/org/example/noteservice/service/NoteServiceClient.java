package org.example.noteservice.service;

import org.example.noteservice.domain.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "note-service")
public interface NoteServiceClient {
    @GetMapping()
    ResponseEntity<Iterable<Note>> getNotes();

    @GetMapping("/{id}")
    ResponseEntity<Note> getNote(@PathVariable Long id);

    @PostMapping
    ResponseEntity<Note> createNote(@RequestBody Note note);

    @PutMapping("/{id}")
    ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteNote(@PathVariable Long id);

}
