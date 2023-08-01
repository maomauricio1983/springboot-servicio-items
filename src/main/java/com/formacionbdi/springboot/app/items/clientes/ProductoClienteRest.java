package com.formacionbdi.springboot.app.items.clientes;


import com.formacionbdi.springboot.app.items.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {


    @GetMapping("/listar")
    public List<Producto> listar();


    @GetMapping("/ver/{id}")
    public Producto ver(@PathVariable Long id);
}
