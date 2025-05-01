package org.example.noteservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.noteservice.domain.Note;
import org.example.noteservice.repository.NoteRepository;
import org.example.noteservice.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteRepository noteRepository;
    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<Iterable<Note>> getNotes() {
        Iterable<Note> notes = noteRepository.findAll();
        return new ResponseEntity<>(notes, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id) {
        return noteService.findById(id)
                .map(note -> new ResponseEntity<>(note, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.add(note), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) {
        return noteService.update(id, note)
                .map(UpdateNote -> new ResponseEntity<>(UpdateNote, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
