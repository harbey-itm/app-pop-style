package edu.itm.especializacion.sofware.apppopstyle.service;

import edu.itm.especializacion.sofware.apppopstyle.dto.ProductoDto;

import java.util.List;

public interface IProductoServicio {

    ProductoDto getProducto(Long id);
    List<ProductoDto> getProductos();
    ProductoDto guardarProducto(ProductoDto producto);
    List<ProductoDto> guardarProductos(List<ProductoDto> productos);
}
