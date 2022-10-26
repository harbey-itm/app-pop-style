package edu.itm.especializacion.sofware.apppopstyle.service.impl;


import edu.itm.especializacion.sofware.apppopstyle.dto.ProductoDto;
import edu.itm.especializacion.sofware.apppopstyle.entity.ProductoEntity;
import edu.itm.especializacion.sofware.apppopstyle.repository.IProductoRepositorio;
import edu.itm.especializacion.sofware.apppopstyle.service.IProductoServicio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServicioImpl implements IProductoServicio {

    @Autowired
    private IProductoRepositorio productoRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductoDto getProducto(Long id) {

        if(productoRepositorio.findById(id).isPresent())
            return mapToDto(productoRepositorio.findById(id).get());

        return null;
    }

    @Override
    public List<ProductoDto> getProductos() {
        List<ProductoEntity> misProductos = productoRepositorio.findAll();


        if(!misProductos.isEmpty()){
            List<ProductoDto> misProdDtos = misProductos.stream()
                    .map(prod -> modelMapper.map(prod, ProductoDto.class))
                    .collect(Collectors.toList());

            return misProdDtos;
        }
            return new ArrayList<ProductoDto>();
    }

    @Override
    public ProductoDto guardarProducto(ProductoDto producto) {
        return mapToDto(productoRepositorio.save(mapToEntity(producto)));

    }

    @Override
    public List<ProductoDto> guardarProductos(List<ProductoDto> productos) {

        List<ProductoEntity> listaProdEntity= productos.stream()
                        .map(producto -> mapToEntity(producto))
                                .collect(Collectors.toList());

        return productoRepositorio.saveAll(listaProdEntity).stream().map(prod -> mapToDto(prod))
                .collect(Collectors.toList());
    }

    //Mapear Dto a Entity
    private ProductoEntity mapToEntity(ProductoDto productoDto){
        return modelMapper.map(productoDto, ProductoEntity.class);
    }

    private ProductoDto mapToDto(ProductoEntity productoEntity){
        return modelMapper.map(productoEntity, ProductoDto.class);
    }

}
