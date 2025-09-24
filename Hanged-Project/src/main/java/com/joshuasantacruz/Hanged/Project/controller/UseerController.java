package com.joshuasantacruz.Hanged.Project.controller;

import com.joshuasantacruz.Hanged.Project.model.Useer;
import com.joshuasantacruz.Hanged.Project.service.UseerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UseerController {

    private final UseerService useerService;

    public UseerController(UseerService useerService) {
        this.useerService = useerService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody Useer useer, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        try {
            useerService.savedUseer(useer);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("userName", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Usuario registrado correctamente");
        return ResponseEntity.ok(respuesta);
    }


    // Listar todos
    @GetMapping
    public List<Useer> getAllUsers() {
        return useerService.getAllUseers();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Useer getUserById(@PathVariable Integer id) {
        return useerService.getUseerById(id);
    }

    // Actualizar usuario con validaciones
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @Valid @RequestBody Useer useer, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        Useer updated = useerService.updateUseer(id, useer);
        return ResponseEntity.ok(updated);
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
        boolean eliminado = useerService.deleteUseer(id);

        if (eliminado) {
            return ResponseEntity.noContent().build(); // 204 si se eliminó
        } else {
            // Devuelve 404 con mensaje
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "El usuario con ID " + id + " no existe y no se puede borrar");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
