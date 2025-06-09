package com.parking.service;

import com.parking.entity.Usuario;

public interface LoginService {
    Usuario login(String correo, String contrasena);
}
