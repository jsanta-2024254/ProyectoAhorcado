package com.joshuasantacruz.Hanged.Project.controller;

import com.joshuasantacruz.Hanged.Project.model.Words;
import com.joshuasantacruz.Hanged.Project.service.WordsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/words")
public class WordsController {

    private final WordsService wordsService;

    public WordsController(WordsService wordsService) {
        this.wordsService = wordsService;
    }

    // Crear palabra con validaciones
    @PostMapping
    public ResponseEntity<?> createWord(@Valid @RequestBody Words word, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        try {
            wordsService.saveWord(word);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("word", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("Hola", "Palabra registrada correctamente");
        return ResponseEntity.ok(respuesta);
    }

    // Listar todas
    @GetMapping
    public List<Words> getAllWords() {
        return wordsService.getAllWords();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Words getWordById(@PathVariable Integer id) {
        return wordsService.getWordById(id);
    }

    // Actualizar palabra con validaciones
    @PutMapping("/{id}")
    public ResponseEntity<?> updateWord(@PathVariable Integer id, @Valid @RequestBody Words word, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        Words updated = wordsService.updateWord(id, word);
        return ResponseEntity.ok(updated);
    }

    // Eliminar palabra
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWord(@PathVariable Integer id) {
        boolean eliminado = wordsService.deleteWord(id);

        if (eliminado){
            return ResponseEntity.noContent().build();
        }else{
            Map<String, String> response = new HashMap<>();
            response.put("Validacion", "La palabra con Id" + id + "no existe no se puede borrar");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
