package com.tienda.brezzyvibes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.brezzyvibes.interfaces.Iproducto;
import com.tienda.brezzyvibes.interfaceservice.IProductoService;
import com.tienda.brezzyvibes.model.Producto;

@Service
public class ProductoService implements IProductoService {


    @Autowired
    private Iproducto datos;

    @Override
    public void delete(int id) {
        datos.deleteById(id);
    }

    @Override
    public List<Producto> listar() {
        return  (List<Producto>)datos.findAll() ;
    }

    @Override
    public Optional<Producto> listarId(int id) {
        return datos.findById(id);
    }

    @Override
    public int save(Producto p) {
        int res=0;
        Producto producto= datos.save(p);
        if(!producto.equals(null)){
            res=1;
        }
        return res;
    }

    

}
