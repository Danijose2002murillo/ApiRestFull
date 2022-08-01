/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Api.servicio;

import com.example.Api.entidad.Usuario;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import org.springframework.data.domain.Page;

/**
 *
 * @author Asusi5
 */
public interface UsuarioServicio {
    

    public Iterable<Usuario> findAll();

    public Page<Usuario> findAll(Pageable pageable);

    public Optional<Usuario> findById(Long id);

    public Usuario save(Usuario user);

    public void deleteById(Long id);
}
