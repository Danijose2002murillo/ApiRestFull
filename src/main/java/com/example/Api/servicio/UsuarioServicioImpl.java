/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Api.servicio;

import com.example.Api.entidad.Usuario;
import com.example.Api.repositorio.UsuarioRepositorio;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asusi5
 */
@Service
public class UsuarioServicioImpl implements UsuarioServicio {
    @Autowired
    private UsuarioRepositorio userRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Usuario> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public Usuario save(Usuario user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    } 
}


