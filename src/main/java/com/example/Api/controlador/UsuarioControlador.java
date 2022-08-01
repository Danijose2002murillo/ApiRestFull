/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Api.controlador;

import com.example.Api.entidad.Usuario;
import com.example.Api.servicio.UsuarioServicio;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asusi5
 */
@RestController
@RequestMapping("/api/users")
public class UsuarioControlador {
  @Autowired
    private UsuarioServicio userService;


    @PostMapping
    public ResponseEntity<?> create (@RequestBody Usuario user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }


    @GetMapping("/(id)")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long userId){
        Optional<Usuario> oUser = userService.findById(userId);

        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUser);
    }


    @PutMapping("/(id)")
    public ResponseEntity<?> update (@RequestBody Usuario userDetails, @PathVariable(value = "id") Long userId){
        Optional<Usuario> user = userService.findById(userId);

        if (!user.isPresent()){
            return ResponseEntity.notFound().build();
        }

        user.get().setNombre(userDetails.getNombre());
        user.get().setContra(userDetails.getContra());
        user.get().setEmail(userDetails.getEmail());
        user.get().setEstado(userDetails.getEstado());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
    }


    @DeleteMapping("/(id)")
    public ResponseEntity<?> delete (@PathVariable(value = "id") Long userId){
        if (!userService.findById(userId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public List<Usuario> readAll(){
        List<Usuario> users = StreamSupport
                .stream(userService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return users;
    }  
}

