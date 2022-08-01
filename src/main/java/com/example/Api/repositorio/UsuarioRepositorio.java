/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Api.repositorio;

import com.example.Api.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Asusi5
 */
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    
}