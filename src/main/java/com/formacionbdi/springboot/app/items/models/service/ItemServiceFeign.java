package com.formacionbdi.springboot.app.items.models.service;

import com.formacionbdi.springboot.app.items.clientes.ProductoClienteRest;
import com.formacionbdi.springboot.app.items.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
public class ItemServiceFeign implements ItemService {

    @Autowired
    private ProductoClienteRest clienteFeign;


    @Override
    public List<Item> findAll() {
        return clienteFeign.listar().stream().map(p -> new Item(p, 1))
                .collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(clienteFeign.ver(id),cantidad);
    }
}
