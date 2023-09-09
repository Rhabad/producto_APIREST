package com.rhabad.productosREST.controllers;

import com.rhabad.productosREST.model.ProductoModel;
import com.rhabad.productosREST.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService proServi;


    @GetMapping("/productos")
    public List<ProductoModel> listarProductos(){
        return proServi.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoModel> obtenerProducto(@PathVariable Long id){
        try {
            ProductoModel productoModel = proServi.obtenerProductoPorId(id);
            return new ResponseEntity<ProductoModel>(productoModel, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<ProductoModel>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/productos")
    public void guardarProductos(@RequestBody ProductoModel productoModel){
        proServi.guardarProducto(productoModel);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> actualizarProductos(@RequestBody ProductoModel productoModel, @PathVariable Long id){
        try {
            ProductoModel proModel = proServi.obtenerProductoPorId(id);

            proModel.setNombre(productoModel.getNombre());
            proModel.setPrecio(productoModel.getPrecio());

            proServi.guardarProducto(proModel);
            return new ResponseEntity<ProductoModel>(HttpStatus.OK);
        } catch (Exception e){
        return new ResponseEntity<ProductoModel>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/productos/{id}")
    public void eliminarPrductos(@PathVariable Long id){
        proServi.eliminarProducto(id);
    }
}
