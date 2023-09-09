package com.rhabad.productosREST.services;

import com.rhabad.productosREST.model.ProductoModel;
import com.rhabad.productosREST.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {


    @Autowired
    private ProductoRepository proRepo;


    public List<ProductoModel> listarProductos(){
        return proRepo.findAll();
    }

    public void guardarProducto(ProductoModel productoModel){
        proRepo.save(productoModel);
    }

    public ProductoModel obtenerProductoPorId(Long id){
        return proRepo.findById(id).get();
    }

    public void eliminarProducto(Long id){
        proRepo.deleteById(id);
    }

}
