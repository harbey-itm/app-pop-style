package edu.itm.especializacion.sofware.apppopstyle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaProductoJson {

    private RespuestaDto respuesta;
    private List<ProductoDto> misProductos;

}
