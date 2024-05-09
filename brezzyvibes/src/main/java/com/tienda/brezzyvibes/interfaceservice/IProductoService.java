package com.tienda.brezzyvibes.interfaceservice;

import java.util.List;
import java.util.Optional;

import com.tienda.brezzyvibes.model.Producto;

public interface IProductoService {
    public List<Producto>listar();
    public Optional<Producto>listarId(int id);
    public int save(Producto p);
    public void delete(int id);

}
