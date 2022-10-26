package edu.itm.especializacion.sofware.apppopstyle.controller;


import edu.itm.especializacion.sofware.apppopstyle.dto.ProductoDto;
import edu.itm.especializacion.sofware.apppopstyle.dto.RespuestaDto;
import edu.itm.especializacion.sofware.apppopstyle.dto.RespuestaProductoJson;
import edu.itm.especializacion.sofware.apppopstyle.service.IProductoServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ProductoController {
    private final IProductoServicio productoServicio;

    public ProductoController(IProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping(value="/consultarproducto/{id}")
    public RespuestaProductoJson consultarProducto(@PathVariable Long id){
        ProductoDto producto = productoServicio.getProducto(id);

        if(producto != null){
            List<ProductoDto> misProductos = new ArrayList<>();
            misProductos.add(producto);
            return new RespuestaProductoJson(new RespuestaDto(), misProductos);
        }
        log.warn("El producto: "+id+" no se encuentra en la Base de Datos");
        return new RespuestaProductoJson(new RespuestaDto(false, "El producto: "+id+" no se encuentra en la Base de Datos"), null);
    }

    @GetMapping(value="/consultarproductos")
    public RespuestaProductoJson consultarProductos(){
        List<ProductoDto> misProductos = productoServicio.getProductos();

        if(!misProductos.isEmpty()){
            return new RespuestaProductoJson(new RespuestaDto(), misProductos);
        }
        return new RespuestaProductoJson(new RespuestaDto(false, "No existen productos en la Base de Datos"), null);
    }

    @PostMapping(value="/guardarproducto")
    @ResponseStatus(HttpStatus.CREATED)
    public RespuestaProductoJson guardarProducto(@RequestBody ProductoDto producto){

        List<ProductoDto> misProductos = new ArrayList<>();
        misProductos.add(productoServicio.guardarProducto(producto));
        return new RespuestaProductoJson(new RespuestaDto(), misProductos);
    }
    @PostMapping(value="/guardarlistaproductos")
    @ResponseStatus(HttpStatus.CREATED)
    public RespuestaProductoJson guardarProducto(@RequestBody List<ProductoDto> productos){
        return new RespuestaProductoJson(new RespuestaDto(), productoServicio.guardarProductos(productos));
    }

}
