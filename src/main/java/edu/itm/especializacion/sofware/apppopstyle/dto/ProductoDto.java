package edu.itm.especializacion.sofware.apppopstyle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductoDto {

    private long id;
    private String nombre;
    private String descripcion;
    private Double precio;

}

