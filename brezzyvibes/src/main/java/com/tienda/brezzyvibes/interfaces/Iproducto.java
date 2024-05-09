package com.tienda.brezzyvibes.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.brezzyvibes.model.Producto;

@Repository
public interface Iproducto extends CrudRepository<Producto,Integer>{

}
