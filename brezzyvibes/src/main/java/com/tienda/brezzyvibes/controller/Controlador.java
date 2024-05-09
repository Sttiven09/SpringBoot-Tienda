package com.tienda.brezzyvibes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.brezzyvibes.interfaceservice.IProductoService;
import com.tienda.brezzyvibes.model.Producto;



@Controller
@RequestMapping
public class Controlador {
    
    @Autowired
    private IProductoService service;
    
    @GetMapping({"/"})
    public String mostrar(Model model) {
        List<Producto> productos = service.listar();
        model.addAttribute("productos", productos);
        return "index";
    }

    @GetMapping({"/listar"})
    public String listar(Model model) {
        List<Producto> productos = service.listar();
        model.addAttribute("productos", productos);
        return "formulario";
    }
    @GetMapping({"/new"})
    public String agregar(Model model){
        model.addAttribute("producto",new Producto());
        return "formularioCrear";
    }

    @PostMapping("/save")
    public String save(Producto p, Model model){
        service.save(p);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional <Producto> producto = service.listarId(id);
        model.addAttribute("producto", producto);
        return "formularioEditar";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/listar";
    }
}
