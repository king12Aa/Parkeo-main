package com.parking.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping({"", "index"})
    public String index() {
        return "Página principal disponible";
    }

    @GetMapping("/tables")
    public String tables() {
        return "Vista de tablas disponible";
    }

    @GetMapping("/charts")
    public String charts() {
        return "Vista de gráficos disponible";
    }

    @GetMapping("/register")
    public String mostrarFormularioRegister() {
        return "Formulario de registro disponible";
    }

    @GetMapping("/password")
    public String password() {
        return "Vista de cambio de contraseña disponible";
    }

    @GetMapping("/layout-static")
    public String layoutStatic() {
        return "Layout estático disponible";
    }

    @GetMapping("/layout-sidenav-light")
    public String layoutSidenavLight() {
        return "Layout con sidenav light disponible";
    }

    @GetMapping("/401")
    public String error401() {
        return "Error 401 - No autorizado";
    }

    @GetMapping("/404")
    public String error404() {
        return "Error 404 - Página no encontrada";
    }

    @GetMapping("/500")
    public String error500() {
        return "Error 500 - Error interno del servidor";
    }
}
